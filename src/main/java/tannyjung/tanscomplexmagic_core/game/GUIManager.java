package tannyjung.tanscomplexmagic_core.game;

import io.netty.buffer.Unpooled;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import tannyjung.tanscomplexmagic_core.Core;
import tannyjung.tanscomplexmagic_core.outside.NetworkSender;
import tannyjung.tanscomplexmagic_handcode.systems.GUIs;

import java.util.HashSet;
import java.util.Set;

public class GUIManager extends AbstractContainerScreen<GUIManagerContainer> {

    private final Level level;
    private final Player player;
    private static final Set<Object[]> map_text = new HashSet<>();
    private static final Set<Object[]> map_text_dynamic = new HashSet<>();
    private static final Set<Object[]> map_button = new HashSet<>();
    private String gui = "test";
    private int dynamic_text_loop = 0;

    public GUIManager(GUIManagerContainer container, Inventory inventory, Component text) {

        super(container, inventory, text);
        this.level = container.world;
        this.player = container.entity;
        this.imageWidth = 0;
        this.imageHeight = 0;

    }

    @EventBusSubscriber
    public static class Register {

        public static final DeferredHolder<MenuType<?>, MenuType<GUIManagerContainer>> test = DeferredRegister.create(Registries.MENU, Core.mod_id).register("test", () -> IMenuTypeExtension.create(GUIManagerContainer::new));

        @SubscribeEvent
        public static void event (RegisterMenuScreensEvent event) {

            event.register(test.get(), GUIManager::new);

        }

        public static void bus (IEventBus bus) {

            DeferredRegister<MenuType<?>> register = DeferredRegister.create(Registries.MENU, Core.mod_id);
            register.register("test", () -> IMenuTypeExtension.create(GUIManagerContainer::new));
            register.register(bus);

        }

    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {

        super.render(guiGraphics, mouseX, mouseY, partialTicks);
        this.renderTooltip(guiGraphics, mouseX, mouseY);

    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
    }

    @Override
    protected void renderLabels (GuiGraphics graphic, int mouseX, int mouseY) {

        // Text
        {

            String text = "";
            int posX = 0;
            int posZ = 0;
            double scale = 0.0;

            for (Object[] scan : map_text) {

                text = (String) scan[0];
                posX = (Integer) scan[1];
                posZ = (Integer) scan[2];
                scale = (Double) scan[3];
                OverlayMaker.drawText(graphic, graphic.guiWidth(), graphic.guiHeight(), "", posX, posZ, scale, text);

            }

            for (Object[] scan : map_text_dynamic) {

                text = (String) scan[0];
                posX = (Integer) scan[1];
                posZ = (Integer) scan[2];
                scale = (Double) scan[3];
                OverlayMaker.drawText(graphic, graphic.guiWidth(), graphic.guiHeight(), "", posX, posZ, scale, text);

            }

            if (dynamic_text_loop < 10) {

                dynamic_text_loop = dynamic_text_loop + 1;

            } else {

                dynamic_text_loop = 1;
                Components.refreshTextDynamic(this.gui);

            }

        }

    }

    @Override
    public void init () {

        this.clearWidgets();
        super.init();

        // Button
        {

            map_button.clear();
            GUIs.createButton(this.gui);

            String name = "";
            int network_room = 0;
            int posX = 0;
            int posZ = 0;
            int sizeX = 0;
            int sizeZ = 0;

            for (Object[] scan : map_button) {

                name = (String) scan[0];
                network_room = (Integer) scan[1];
                posX = (Integer) scan[2];
                posZ = (Integer) scan[3];
                sizeX = (Integer) scan[4];
                sizeZ = (Integer) scan[5];

                int network_room_final = network_room;
                posX = -posX;
                posZ = -posZ;

                this.addRenderableWidget(Button.builder(Component.literal(name), create -> {

                    NetworkSender.send(this.player, network_room_final);
                    init();

                }).bounds(this.leftPos + posX, this.topPos + posZ, sizeX, sizeZ).build());

            }

        }

        Components.refreshText(this.gui);
        Components.refreshTextDynamic(this.gui);

    }

    public static void open (Player player) {

        MenuProvider provider = new MenuProvider() {

            @Override
            public Component getDisplayName () {

                return Component.literal("test");

            }

            @Override
            public boolean shouldTriggerClientSideContainerClosingOnOpen () {

                return false;

            }

            @Override
            public AbstractContainerMenu createMenu (int id, Inventory inventory, Player player) {

                // GUIManagerContainer
                // GUIIndexMenu
                return new GUIManagerContainer(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(player.blockPosition()));

            }

        };

        player.openMenu(provider, player.blockPosition());

    }

    public static void close (Player player) {

        player.closeContainer();

    }

    public static class Components {

        public static void refreshText (String gui) {

            map_text.clear();
            GUIs.createText(gui);

        }

        public static void refreshTextDynamic (String gui) {

            map_text_dynamic.clear();
            GUIs.createTextDynamic(gui);

        }

        public static void addText (int posX, int posZ, double scale, String text) {

            map_text.add(new Object[]{text, posX, posZ, scale, text});

        }

        public static void addTextDynamic (int posX, int posZ, double scale, String text) {

            map_text_dynamic.add(new Object[]{text, posX, posZ, scale, text});

        }

        public static void addButton (int posX, int posZ, int sizeX, int sizeZ, int network_room, String name) {

            map_button.add(new Object[]{name, network_room, posX, posZ, sizeX, sizeZ});

        }

    }

}