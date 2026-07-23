package tannyjung.tanscomplexmagic_core.game;

import io.netty.buffer.Unpooled;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import tannyjung.tanscomplexmagic.TanscomplexmagicMod;
import tannyjung.tanscomplexmagic_core.Core;
import tannyjung.tanscomplexmagic_core.outside.NetworkManager;
import tannyjung.tanscomplexmagic_handcode.systems.GUIs;

import java.util.HashSet;
import java.util.Set;

public class GUIMaker extends AbstractContainerScreen<GUIMakerContainer> {

    public final LocalPlayer player;
    public static String id = "test";

    public GUIMaker (GUIMakerContainer container, Inventory inventory, Component text) {

        super(container, inventory, text);
        this.player = (LocalPlayer) container.entity;
        this.imageWidth = 0;
        this.imageHeight = 0;

    }

    public static class Register {

        public static final DeferredRegister<MenuType<?>> register = DeferredRegister.create(Registries.MENU, TanscomplexmagicMod.MODID);
        public static final DeferredHolder<MenuType<?>, MenuType<GUIMakerContainer>> gui = register.register("gui", () -> IMenuTypeExtension.create(GUIMakerContainer::new));

        @EventBusSubscriber({Dist.CLIENT})
        public static class Event {

            @SubscribeEvent
            public static void event (RegisterMenuScreensEvent event) {

                event.register(gui.get(), GUIMaker::new);

            }

        }

        public static void bus (IEventBus bus) {

            register.register(bus);

        }

    }

    @Override
    public void render (GuiGraphics graphic, int mouseX, int mouseY, float tick) {

        super.render(graphic, mouseX, mouseY, tick);
        this.renderTooltip(graphic, mouseX, mouseY);

        loop(this);

    }

    @Override
    protected void renderBg (GuiGraphics graphic, float partialTicks, int mouseX, int mouseY) {
    }

    @Override
    protected void renderLabels (GuiGraphics graphic, int mouseX, int mouseY) {

        Components.Text.render(graphic);

    }

    @Override
    public void init () {

        super.init();
        Components.refresh();

    }

    public static class Components {

        private static boolean refresh = false;

        public static void refresh () {

            refresh = true;

        }

        public static class Text {

            private static final Set<Object[]> set = new HashSet<>();

            private static void render (GuiGraphics graphic) {

                String text = "";
                int posX = 0;
                int posZ = 0;
                double scale = 0.0;

                for (Object[] scan : set) {

                    text = (String) scan[0];
                    posX = (Integer) scan[1];
                    posZ = (Integer) scan[2];
                    scale = (Double) scan[3];
                    OverlayMaker.drawText(graphic, graphic.guiWidth(), graphic.guiHeight(), "", posX, posZ, scale, text);

                }

            }

            public static void refresh (GUIMaker manager) {

                set.clear();
                GUIs.create(manager, id, "Text");

            }

            public static void add (int posX, int posZ, double scale, String text) {

                set.add(new Object[]{text, posX, posZ, scale, text});

            }

        }

        public static class ButtonExecute {

            private static final Set<Button> set = new HashSet<>();

            private static void render (GUIMaker manager) {

                for (Button button : set) {

                    button.setTooltip(Tooltip.create(Component.literal("Hello World")));
                    button.active = false;

                    manager.addRenderableWidget(button);

                }

            }

            private static void refresh (GUIMaker manager) {

                for (Button button : set) {

                    manager.removeWidget(button);

                }

                set.clear();
                GUIs.create(manager, id, "ButtonExecute");
                render(manager);

                Components.refresh();

            }

            public static void add (GUIMaker manager, int posX, int posZ, int sizeX, int sizeZ, int network_room, String name) {

                posX = -posX;
                posZ = -posZ;

                set.add(Button.builder(Component.literal(name), create -> {

                    // NetworkSender.toServer(9, new CompoundTag());
                    refresh(manager);

                }).bounds(manager.leftPos + posX, manager.topPos + posZ, sizeX, sizeZ).build());

            }

        }

        public static class Switch {

            private static final Set<Button> set = new HashSet<>();

            private static void render (GUIMaker manager) {

                for (Button button : set) {

                    manager.addRenderableWidget(button);

                }

            }

            private static void refresh (GUIMaker manager) {

                for (Button button : set) {

                    manager.removeWidget(button);

                }

                set.clear();
                GUIs.create(manager, id, "Switch");
                render(manager);

                Components.refresh();

            }

            public static void add (GUIMaker manager, int posX, int posZ, String nbt) {

                posX = -posX;
                posZ = -posZ;
                String status = "OFF";

                if (GameUtils.Data.getEntityLogic(manager.player, nbt) == true) {

                    status = "ON";

                }

                set.add(Button.builder(Component.literal(status), create -> {

                    CompoundTag extra_data = new CompoundTag();
                    extra_data.putString("name", nbt);
                    NetworkManager.runServerCore(manager.player, "gui", "switch", extra_data);

                }).bounds(manager.leftPos + posX, manager.topPos + posZ, 32, 16).build());

            }

        }

    }

    private static void loop (GUIMaker manager) {

        if (Components.refresh == true) {

            Components.Text.refresh(manager);
            Components.ButtonExecute.refresh(manager);
            Components.Switch.refresh(manager);

            Components.refresh = false;

        }

    }

    public static void open (Player player) {

        // TODO -> Delete this later
        if (player.level().isClientSide == true) return;

        NetworkManager.runClientCore((ServerPlayer) player, "nbt", "sync_all", player.getPersistentData().getCompound(Core.mod_id));

        MenuProvider provider = new MenuProvider() {

            @Override
            public Component getDisplayName() {

                return Component.literal("test");

            }

            @Override
            public boolean shouldTriggerClientSideContainerClosingOnOpen() {

                return false;

            }

            @Override
            public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {

                // GUIManagerContainer
                // GUIIndexMenu
                return new GUIMakerContainer(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(player.blockPosition()));

            }

        };

        player.openMenu(provider, player.blockPosition());

    }

    public static void close (Player player) {

        player.closeContainer();

    }

}