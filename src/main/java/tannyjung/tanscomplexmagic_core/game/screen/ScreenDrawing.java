package tannyjung.tanscomplexmagic_core.game.screen;

import com.mojang.blaze3d.platform.NativeImage;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.font.FontManager;
import net.minecraft.client.gui.font.FontOption;
import net.minecraft.client.gui.font.FontSet;
import net.minecraft.client.renderer.texture.AbstractTexture;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.neoforged.neoforge.client.model.DynamicFluidContainerModel;
import tannyjung.tanscomplexmagic_core.Core;
import tannyjung.tanscomplexmagic_core.game.NBTManager;
import tannyjung.tanscomplexmagic_core.outside.NetworkManager;
import tannyjung.tanscomplexmagic_core.outside.OutsideUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class ScreenDrawing {

    private static final Map<String, String> image_status = new HashMap<>();
    private static final Map<String, Integer> image_online_id = new HashMap<>();

    public static void refresh () {

        GUIScreen.refresh = true;
        image_status.clear();
        image_online_id.clear();

    }

    private static int[] convertPosAnchor (GuiGraphics graphic, int posX, int posZ, String pos_anchor, double scale) {

        int[] pos = new int[2];

        if (pos_anchor.isEmpty() == true) {

            pos[0] = posX;
            pos[1] = posZ;

        } else {

            if (pos_anchor.startsWith("top-") == true) {

                pos[1] = posZ;

            } else if (pos_anchor.startsWith("bottom-") == true) {

                pos[1] = graphic.guiHeight() - posZ;

            }

            if (pos_anchor.endsWith("-left") == true) {

                pos[0] = posX;

            } else if (pos_anchor.endsWith("-right") == true) {

                pos[0] = graphic.guiWidth() - posX;

            }

        }

        pos[0] = (int) (pos[0] / scale);
        pos[1] = (int) (pos[1] / scale);
        return pos;

    }

    public static class Basic {

        public static void drawText (GuiGraphics graphic, String pos_anchor, int posX, int posZ, double scale, boolean shadow, String text) {

            posX = -posX;
            posZ = -posZ;

            int[] pos = convertPosAnchor(graphic, posX, posZ, pos_anchor, scale);
            posX = pos[0];
            posZ = pos[1];

            /*
            (1.20.1) (1.21.1)
            graphic.pose().pushPose();
            graphic.pose().scale((float) scale, (float) scale, 1.0f);
            graphic.drawString(Minecraft.getInstance().font, text, posX, posZ, 0, shadow);
            graphic.pose().popPose();
            (1.21.8)
            graphic.pose().pushMatrix();
            graphic.pose().scale((float) scale, (float) scale);
            graphic.drawString(Minecraft.getInstance().font, text, posX, posZ, 0, shadow);
            graphic.pose().popMatrix();
            */
            graphic.pose().pushPose();
            graphic.pose().scale((float) scale, (float) scale, 1.0f);
            graphic.drawString(Minecraft.getInstance().font, text, posX, posZ, 0, shadow);
            graphic.pose().popPose();

        }

        public static void drawImage (GuiGraphics graphic, boolean internet, String path, String path_load, String path_fail, int posX, int posZ, int sizeX, int sizeZ, int piece_countX, int piece_countZ, int choose) {

            posX = -posX;
            posZ = -posZ;
            posX = posX - sizeX;
            posZ = posZ - sizeZ;

            String name = "";

            // Get Name
            {

                if (internet == true) {

                    if (image_online_id.containsKey(path) == false) {

                        image_online_id.put(path, image_online_id.size() + 1);

                    }

                    name = "tannyjung:online_image_" + image_online_id.get(path) + ".png";

                } else {

                    name = path;

                }

            }

            ResourceLocation location = null;

            if (image_status.containsKey(name) == false) {

                // Load
                {

                    image_status.put(name, "load");

                    if (internet == true) {

                        String name_final = name;

                        Core.thread_main.submit(() -> {

                            {

                                if (OutsideUtils.isURLAvailable(path) == true) {

                                    // Download Online
                                    {

                                        try {

                                            BufferedImage buffer = ImageIO.read(URI.create(path).toURL());
                                            NativeImage native_image = new NativeImage(buffer.getWidth(), buffer.getHeight(), false);

                                            // Color Convert
                                            {

                                                int argb = 0;
                                                int a = 0;
                                                int r = 0;
                                                int g = 0;
                                                int b = 0;
                                                int abgr = 0;

                                                for (int scanY = 0; scanY < buffer.getHeight(); scanY++) {

                                                    for (int scanX = 0; scanX < buffer.getWidth(); scanX++) {

                                                        argb = buffer.getRGB(scanX, scanY);
                                                        a = (argb >>> 24) & 0xFF;
                                                        r = (argb >>> 16) & 0xFF;
                                                        g = (argb >>> 8) & 0xFF;
                                                        b = (argb) & 0xFF;
                                                        abgr = (a << 24) | (b << 16) | (g << 8) | r;

                                                    /*
                                                    (1.20.1) (1.21.1)
                                                    native_image.setPixelRGBA(scanX, scanY, abgr);
                                                    (1.21.8)
                                                    native_image.setPixelABGR(scanX, scanY, abgr);
                                                    */
                                                        native_image.setPixelRGBA(scanX, scanY, abgr);

                                                    }

                                                }

                                            }

                                        /*
                                        (1.20.1) (1.21.1)
                                        Minecraft.getInstance().getTextureManager().register(location, new DynamicTexture(native_image));
                                        (1.21.8)
                                        Minecraft.getInstance().getTextureManager().register(location, new DynamicTexture(() -> "test", native_image));
                                        */
                                            Minecraft.getInstance().getTextureManager().register(ResourceLocation.parse(name_final), new DynamicTexture(native_image));

                                            image_status.put(name_final, "available");

                                        } catch (Exception exception) {

                                            OutsideUtils.exception(new Exception(), exception, "");
                                            image_status.put(name_final, "fail");

                                        }

                                    }

                                } else {

                                    image_status.put(name_final, "fail");

                                }

                            }

                        });

                    } else {

                        AbstractTexture texture = Minecraft.getInstance().getTextureManager().getTexture(ResourceLocation.parse(name));

                        if (texture.getId() == -1) {

                            image_status.put(name, "fail");

                        } else {

                            image_status.put(name, "available");

                        }

                    }

                }

            }

            if (image_status.get(name).equals("available") == true) {

                location = ResourceLocation.parse(name);

            } else if (image_status.get(name).equals("load") == true) {

                location = ResourceLocation.parse(path_load);

            } else {

                location = ResourceLocation.parse(path_fail);

            }

            int piece_sizeX = sizeX / piece_countX;
            int piece_sizeZ = sizeZ / piece_countZ;
            int startX = Mth.clamp(choose * piece_sizeX, 0, sizeX - piece_sizeX);
            int startZ = Mth.clamp(choose * piece_sizeZ, 0, sizeZ - piece_sizeZ);

            graphic.blit(location, (graphic.guiWidth() / 2) + posX, (graphic.guiHeight() / 2) + posZ, startX, startZ, piece_sizeX, piece_sizeZ, sizeX, sizeZ);

        }

    }

    public static class GUI {

        public static void drawButtonClientRunnable (GUIScreen screen, int posX, int posZ, int sizeX, int sizeZ, String text, Runnable runnable) {

            posX = -posX;
            posZ = -posZ;

            Button button = Button.builder(Component.literal(text), create -> {

                runnable.run();
                ScreenDrawing.refresh();

            }).bounds(screen.getGuiLeft() + posX, screen.getGuiTop() + posZ, sizeX, sizeZ).build();

            GUIScreen.addWidget(screen, button);

        }

        public static void drawButtonNetwork (GUIScreen screen, int posX, int posZ, int sizeX, int sizeZ, String text, String work) {

            posX = -posX;
            posZ = -posZ;

            Button button = Button.builder(Component.literal(text), create -> {

                NetworkManager.runServerCore(screen.player, "gui", work, new CompoundTag());

            }).bounds(screen.getGuiLeft() + posX, screen.getGuiTop() + posZ, sizeX, sizeZ).build();

            GUIScreen.addWidget(screen, button);

        }

        public static void drawSwitch (GUIScreen screen, int posX, int posZ, String nbt) {

            posX = -posX;
            posZ = -posZ;

            Button button_left = Button.builder(Component.empty(), create -> {

                CompoundTag extra_data = new CompoundTag();
                extra_data.putString("name", nbt);
                NetworkManager.runServerCore(screen.player, "gui", "switch", extra_data);

            }).bounds(screen.getGuiLeft() + posX, screen.getGuiTop() + posZ, 5, 10).build();

            Button button_right = Button.builder(Component.empty(), create -> {

                CompoundTag extra_data = new CompoundTag();
                extra_data.putString("name", nbt);
                NetworkManager.runServerCore(screen.player, "gui", "switch", extra_data);

            }).bounds(screen.getGuiLeft() + posX + 5, screen.getGuiTop() + posZ, 5, 10).build();

            if (NBTManager.getEntityLogic(screen.player, "gui", nbt) == true) {

                button_left.active = false;
                button_right.active = true;

            } else {

                button_left.active = true;
                button_right.active = false;

            }

            GUIScreen.addWidget(screen, button_left);
            GUIScreen.addWidget(screen, button_right);

        }

        public static void drawTextBox (GUIScreen screen, int posX, int posZ, String nbt) {

            posX = -posX;
            posZ = -posZ;

            EditBox box = new EditBox(Minecraft.getInstance().font, screen.getGuiLeft() + posX + 10, screen.getGuiTop() + posZ, 170 - 10, 20, Component.literal("Hello"));
            box.setValue(NBTManager.getEntityText(screen.player, "gui", nbt));
            box.setMaxLength(8192);
            box.setTextShadow(false);

            box.setEditable(true);






            Button button = Button.builder(Component.literal("{"), create -> {

                CompoundTag extra_data = new CompoundTag();
                extra_data.putString("name", nbt);
                extra_data.putString("value", box.getValue());
                NetworkManager.runServerCore(screen.player, "gui", "text_box", extra_data);

            }).bounds(screen.getGuiLeft() + posX, screen.getGuiTop() + posZ, 10, 20).build();

            GUIScreen.addWidget(screen, box);
            GUIScreen.addWidget(screen, button);

        }

    }

}
