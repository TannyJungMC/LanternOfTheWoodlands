package tannyjung.tanscomplexmagic_core.game.screen;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.*;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.lwjgl.glfw.GLFW;
import tannyjung.tanscomplexmagic.TanscomplexmagicMod;
import tannyjung.tanscomplexmagic_core.Core;
import tannyjung.tanscomplexmagic_core.game.NBTManager;

public class GUIScreen extends AbstractContainerScreen<GUIContainer> {

    public static final DeferredRegister<MenuType<?>> register = DeferredRegister.create(Registries.MENU, TanscomplexmagicMod.MODID);
    public static final DeferredHolder<MenuType<?>, MenuType<GUIContainer>> gui = register.register("gui", () -> IMenuTypeExtension.create(GUIContainer::new));

    public static GUIScreen screen = null;
    public static LocalPlayer player_local = null;
    public static ItemStack item = ItemStack.EMPTY;
    public static String id_group = "";
    public static String id_name = "";

    public GUIScreen (GUIContainer container, Inventory inventory, Component text) {

        super(container, inventory, text);
        this.imageWidth = 0;
        this.imageHeight = 0;

        GUIScreen.screen = this;
        GUIScreen.player_local = (LocalPlayer) container.entity;

    }

    @Override
    public void onClose () {

        super.onClose();

        GUIScreen.screen = null;
        GUIScreen.player_local = null;

    }

    @Override
    public boolean keyPressed (int key, int scan, int modifier) {

        if (key == GLFW.GLFW_KEY_ESCAPE) {

            {

                GUIManager.close(player_local);
                return true;

            }

        } else if (key == GLFW.GLFW_KEY_ENTER || key == GLFW.GLFW_KEY_KP_ENTER) {

            {

                for (Renderable renderable : this.renderables) {

                    if (renderable instanceof EditBox box) {

                        box.setFocused(false);

                    }

                }

                return true;

            }

        } if (key == GLFW.GLFW_KEY_E) {

            {

                for (Renderable renderable : this.renderables) {

                    if (renderable instanceof EditBox box) {

                        if (box.isFocused() == true) {

                            return false;

                        }

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

    }

    @Override
    protected void renderBg (GuiGraphics graphic, float partialTicks, int mouseX, int mouseY) {

        ScreenDrawing.ComponentBasic.PreCalculate.renderImage(graphic);

    }

    @Override
    protected void renderLabels (GuiGraphics graphic, int mouseX, int mouseY) {

        ScreenDrawing.ComponentBasic.PreCalculate.renderText(graphic);

    }

    @Override
    public void init () {

        super.init();

        GUIScreen.id_group = "";
        GUIScreen.id_name = "";
        ScreenDrawing.refresh();

    }

    public static class Widget {

        public static void add (AbstractWidget widget) {

            screen.addRenderableWidget(widget);

        }

        public static void remove (AbstractWidget widget) {

            screen.removeWidget(widget);

        }

        public static void removeAll () {

            screen.clearWidgets();

        }

    }

}