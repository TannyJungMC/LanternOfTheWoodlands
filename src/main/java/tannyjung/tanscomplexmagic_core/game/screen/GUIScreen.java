package tannyjung.tanscomplexmagic_core.game.screen;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.*;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ISystemReportExtender;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import tannyjung.tanscomplexmagic.TanscomplexmagicMod;
import tannyjung.tanscomplexmagic_core.Core;
import tannyjung.tanscomplexmagic_core.game.NBTManager;
import tannyjung.tanscomplexmagic_core.outside.NetworkManager;
import tannyjung.tanscomplexmagic_handcode.systems.GUIs;

public class GUIScreen extends AbstractContainerScreen<GUIContainer> {

    public final LocalPlayer player;
    public static int id = 0;
    public static boolean refresh = false;

    public GUIScreen (GUIContainer container, Inventory inventory, Component text) {

        super(container, inventory, text);
        this.player = (LocalPlayer) container.entity;
        this.imageWidth = 0;
        this.imageHeight = 0;

    }

    public static class Register {

        public static final DeferredRegister<MenuType<?>> register = DeferredRegister.create(Registries.MENU, TanscomplexmagicMod.MODID);
        public static final DeferredHolder<MenuType<?>, MenuType<GUIContainer>> gui = register.register("gui", () -> IMenuTypeExtension.create(GUIContainer::new));

        @EventBusSubscriber(Dist.CLIENT)
        public static class Event {

            @SubscribeEvent
            public static void event (RegisterMenuScreensEvent event) {

                event.register(gui.get(), GUIScreen::new);

            }

        }

        public static void bus (IEventBus bus) {

            register.register(bus);

        }

    }

    @Override
    public boolean keyPressed (int key, int scan, int modifier) {

        if (key == 256) {

            this.player.closeContainer();
            return true;

        } else if (key == 69) {

            for (Renderable renderable : this.renderables) {

                if (renderable instanceof EditBox box) {

                    if (box.isFocused() == true) {

                        return true;

                    }

                }

            }

        }

        return super.keyPressed(key, scan, modifier);

    }

    @Override
    public boolean mouseDragged (double mouseX, double mouseY, int button, double dragX, double dragY) {

        if (this.isDragging() == true && button == 0) {

            return this.getFocused().mouseDragged(mouseX, mouseY, button, dragX, dragY);

        }

        return super.mouseDragged(mouseX, mouseY, button, dragX, dragY);

    }

    @Override
    public void render (GuiGraphics graphic, int mouseX, int mouseY, float tick) {

        super.render(graphic, mouseX, mouseY, tick);
        this.renderTooltip(graphic, mouseX, mouseY);

        if (refresh == true) {

            refresh = false;
            refresh();

        }

    }

    @Override
    protected void renderBg (GuiGraphics graphic, float partialTicks, int mouseX, int mouseY) {

        GUIs.render(this, graphic, id, "image");

    }

    @Override
    protected void renderLabels (GuiGraphics graphic, int mouseX, int mouseY) {

        GUIs.render(this, graphic, id, "text");
        ScreenDrawing.Ingredient.renderText(graphic);

    }

    @Override
    public void init () {

        super.init();
        refresh();

    }

    private void refresh () {

        this.clearWidgets();
        ScreenDrawing.Ingredient.clear();

        id = (int) NBTManager.getEntityNumber(player, "gui", "id");
        GUIs.render(this, null, id, "widget");

    }

    public static void addWidget (GUIScreen screen, AbstractWidget widget) {

        screen.addRenderableWidget(widget);

    }

}