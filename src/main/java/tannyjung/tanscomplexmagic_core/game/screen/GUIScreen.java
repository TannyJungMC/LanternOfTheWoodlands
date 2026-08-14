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
import tannyjung.tanscomplexmagic.TanscomplexmagicMod;
import tannyjung.tanscomplexmagic_core.game.NBTManager;
import tannyjung.tanscomplexmagic_handcode.core.GUIs;

public class GUIScreen extends AbstractContainerScreen<GUIContainer> {

    public static final DeferredRegister<MenuType<?>> register = DeferredRegister.create(Registries.MENU, TanscomplexmagicMod.MODID);
    public static final DeferredHolder<MenuType<?>, MenuType<GUIContainer>> gui = register.register("gui", () -> IMenuTypeExtension.create(GUIContainer::new));

    public static boolean refresh = false;
    public static ItemStack item = ItemStack.EMPTY;
    public final LocalPlayer player;
    public int id = 0;

    public GUIScreen (GUIContainer container, Inventory inventory, Component text) {

        super(container, inventory, text);
        this.player = (LocalPlayer) container.entity;
        this.imageWidth = 0;
        this.imageHeight = 0;

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

        ScreenDrawing.ComponentBasic.PreCalculate.renderImage(graphic);

    }

    @Override
    protected void renderLabels (GuiGraphics graphic, int mouseX, int mouseY) {

        ScreenDrawing.ComponentBasic.PreCalculate.renderText(graphic);

    }

    @Override
    public void init () {

        super.init();
        refresh();

    }

    private void refresh () {

        this.clearWidgets();
        ScreenDrawing.ComponentBasic.PreCalculate.clear();

        id = (int) NBTManager.Mob.getNumber(player, "gui", "id");
        GUIs.render(this, id);

    }

    public static void addWidget (GUIScreen screen, AbstractWidget widget) {

        screen.addRenderableWidget(widget);

    }

}