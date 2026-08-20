package tannyjung.tanscomplexmagic_core.game;

import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.storage.LevelResource;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.client.event.*;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.neoforge.event.entity.EntityLeaveLevelEvent;
import net.neoforged.neoforge.registries.DeferredRegister;
import tannyjung.tanscomplexmagic.TanscomplexmagicMod;
import tannyjung.tanscomplexmagic_core.Core;
import tannyjung.tanscomplexmagic_core.game.screen.GUIScreen;
import tannyjung.tanscomplexmagic_core.game.world_gen.*;
import tannyjung.tanscomplexmagic_core.outside.NetworkManager;
import tannyjung.tanscomplexmagic_core.outside.config.CustomPackOrganizing;
import tannyjung.tanscomplexmagic_core.outside.config.TannyPackManager;
import tannyjung.tanscomplexmagic_handcode.core.Commands;
import tannyjung.tanscomplexmagic_handcode.core.KeyBindings;
import tannyjung.tanscomplexmagic_handcode.core.Overlays;

/*
(1.20.1)
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.level.ChunkEvent;
import net.minecraftforge.event.server.ServerAboutToStartEvent;
import net.minecraftforge.event.server.ServerStartedEvent;
import net.minecraftforge.event.server.ServerStoppingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.api.distmarker.Dist;
(1.21.1)
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.level.ChunkEvent;
import net.neoforged.neoforge.event.server.ServerAboutToStartEvent;
import net.neoforged.neoforge.event.server.ServerStartedEvent;
import net.neoforged.neoforge.event.server.ServerStoppingEvent;
import net.neoforged.neoforge.event.tick.ServerTickEvent;
import net.neoforged.neoforge.client.event.RenderGuiEvent;
import net.neoforged.neoforge.client.event.ScreenEvent;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.api.distmarker.Dist;
*/
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.level.ChunkEvent;
import net.neoforged.neoforge.event.server.ServerAboutToStartEvent;
import net.neoforged.neoforge.event.server.ServerStartedEvent;
import net.neoforged.neoforge.event.server.ServerStoppingEvent;
import net.neoforged.neoforge.event.tick.ServerTickEvent;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.api.distmarker.Dist;

import java.util.Map;

@EventBusSubscriber
public class EventCenter {

    private static boolean first_player_joined = false;

    public static void bus (IEventBus bus) {

        GUIScreen.register.register(bus);

        // Features
        {

            DeferredRegister<Feature<?>> register = DeferredRegister.create(Registries.FEATURE, Core.mod_id);
            register.register("world_gen_before_plants", WorldGenStepBeforePlants::new);
            register.register("world_gen_last", WorldGenStepLast::new);
            register.register("area_grass", FeatureAreaGrass::new);
            register.register("area_dirt", FeatureAreaDirt::new);
            register.register(bus);

        }

    }

    @SubscribeEvent
    public static void setup (FMLCommonSetupEvent event) {

        TanscomplexmagicMod.addNetworkMessage(NetworkManager.type, NetworkManager.stream, NetworkManager::receive);

    }

    @SubscribeEvent
    public static void eventRegisterCommand (RegisterCommandsEvent event) {

        CommandMaker.BuiltinCommands.registry(event);
        Commands.registry(event);

    }

    @SubscribeEvent
    public static void eventWorldAboutToStart (ServerAboutToStartEvent event) {

        String path_world = event.getServer().getWorldPath(new LevelResource(".")).toString();
        Core.path_world_core = path_world + "/data/tannyjung/" + Core.data_structure_version_core;
        Core.path_world_mod = path_world + "/data/" + Core.mod_id;

        Core.DataMigration.run(true);
        Core.restart(null, false, true);

    }

    @SubscribeEvent
    public static void eventWorldStart (ServerStartedEvent event) {

        ServerLevel level_server = event.getServer().overworld();

        Core.generateDataWorld(level_server);
        Core.restart(level_server, true, false);

    }

    @SubscribeEvent
    public static void eventWorldStop (ServerStoppingEvent event) {

        first_player_joined = false;

    }

    @SubscribeEvent
    public static void eventChunkLoad (ChunkEvent.Load event) {

        if (event.getLevel().isClientSide() == true) {

            return;

        }

        if (event.isNewChunk() == true) {

            Core.thread.submit(() -> {

                LevelAccessor level_accessor = event.getLevel();
                ServerLevel level_server = (ServerLevel) level_accessor;
                String dimension = GameUtils.Space.getDimensionID(level_server).replace(":", "-");
                ChunkPos chunk_pos = event.getChunk().getPos();

                WorldGenStepEnd.start(dimension, chunk_pos);

            });

        }

    }

    @SubscribeEvent
    public static void eventPlayerJoin (PlayerEvent.PlayerLoggedInEvent event) {

        ServerPlayer player_server = (ServerPlayer) event.getEntity();
        ServerLevel level_server = player_server.serverLevel();

        NetworkManager.runClientCore(player_server, "nbt", "sync", NBTManager.Mob.getAllMergeReady(player_server));

        if (first_player_joined == false) {

            first_player_joined = true;

            Core.DelayedWork.create(true, 100, () -> {

                CustomPackOrganizing.Error.sendMessage(level_server);

                if (Core.auto_check_update == true) {

                    Core.thread.submit(() -> {

                        TannyPackManager.runCheckUpdate(level_server);

                    });

                }

            });

        }

    }

    @SubscribeEvent
    public static void eventEntityJoin (EntityJoinLevelEvent event) {

        if (event.getLevel().isClientSide == true) {

            return;

        }

        EntityManager.Population.eventAddRemove(event.getEntity(), true);

    }

    @SubscribeEvent
    public static void eventEntityLeave (EntityLeaveLevelEvent event) {

        if (event.getLevel().isClientSide == true) {

            return;

        }

        EntityManager.Population.eventAddRemove(event.getEntity(), false);

    }

    @SubscribeEvent
    public static void eventPlayerRespawn (PlayerEvent.PlayerRespawnEvent event) {

        NetworkManager.runClientCore(event.getEntity(), "nbt", "sync", NBTManager.Mob.getAllMergeReady(event.getEntity()));

    }

    @SubscribeEvent
    public static void eventPlayerClone (PlayerEvent.Clone event) {

        NBTManager.Mob.merge(event.getEntity(), NBTManager.Mob.getAllMergeReady(event.getOriginal()), true);

    }

    @SubscribeEvent

    /*
    (1.20.1)
    public static void eventTickServer (TickEvent.ServerTickEvent event) {
    (1.21.1)
    public static void eventTickServer (ServerTickEvent.Post event) {
    */
    public static void eventTickServer (ServerTickEvent.Post event) {

        if (Core.global_locking == true) {

            return;

        }

        /*
        (1.20.1)
        if (event.phase == TickEvent.Phase.START) return;
        (1.21.1)
        ### Nothing ###
        */


        ServerLevel level_server = event.getServer().overworld();
        Core.DelayedWork.runTick();
        Core.Loop.loopTick(level_server);

    }

    @EventBusSubscriber(Dist.CLIENT)
    public static class Client {

        @SubscribeEvent
        public static void eventRegisterKey (RegisterKeyMappingsEvent event) {

            KeyBindingMaker.Storage.is_client_side = true;
            KeyBindings.add();

            for (Map.Entry<String, KeyMapping> entry : KeyBindingMaker.Storage.keys.entrySet()) {

                event.register(entry.getValue());

            }

        }

        @SubscribeEvent
        public static void eventRegisterGUI (RegisterMenuScreensEvent event) {

            event.register(GUIScreen.gui.get(), GUIScreen::new);

        }

        @SubscribeEvent
        public static void eventTick (ClientTickEvent.Post event) {

            KeyBindingMaker.Storage.tick();

        }

        @SubscribeEvent(priority = EventPriority.NORMAL)
        public static void eventOverlayMenu (ScreenEvent.Render.Post event) {

            Screen screen = event.getScreen();
            GuiGraphics graphic = event.getGuiGraphics();
            int screen_width = event.getScreen().width;
            int screen_height = event.getScreen().height;
            Overlays.eventMenu(screen, graphic, screen_width, screen_height);

        }

        @SubscribeEvent(priority = EventPriority.NORMAL)
        public static void eventOverlayInGame (RenderGuiEvent.Post event) {

            if (Minecraft.getInstance().options.hideGui == true) {

                return;

            }

            GuiGraphics graphic = event.getGuiGraphics();
            Overlays.eventInGame(graphic);

            if (Core.developer_mode == true) {

                // ScreenDrawing.Basic.drawText(graphic, "top-left", 8, 58, 0.75, "§9Delayed Command = " + TXTFunction.count_delayed_command);

            }

        }

    }

}
