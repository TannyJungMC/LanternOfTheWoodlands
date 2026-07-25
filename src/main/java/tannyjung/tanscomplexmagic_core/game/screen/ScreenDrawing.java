package tannyjung.tanscomplexmagic_core.game.screen;

import com.mojang.blaze3d.platform.NativeImage;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import tannyjung.tanscomplexmagic_core.Core;
import tannyjung.tanscomplexmagic_core.game.NBTManager;
import tannyjung.tanscomplexmagic_core.outside.NetworkManager;
import tannyjung.tanscomplexmagic_core.outside.OutsideUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URI;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ScreenDrawing {

    public static void refresh () {

        GUIScreen.refresh = true;

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

    private static int[] convertPosTextCenter (int centerX, int centerZ, double scale, String text) {

        int font_width = (int) (Minecraft.getInstance().font.width(text) * scale);
        int font_height = (int) (Minecraft.getInstance().font.lineHeight * scale);
        int convertX = centerX + (font_width / 2);
        int convertZ = centerZ - (font_height / 2);
        convertZ = convertZ + 1;
        return new int[]{convertX, convertZ};

    }

    public static class Ingredient {

        private static final Set<Object[]> text = new HashSet<>();

        public static void clear () {

            text.clear();

        }

        public static void renderText (GuiGraphics graphic) {

            for (Object[] objects : text) {

                Overlay.drawText(graphic, (String) objects[0], (int) objects[1], (int) objects[2], (double) objects[3], (boolean) objects[4], (String) objects[5]);

            }

        }

    }

    public static class Overlay {

        private static final Map<String, String> online_image_id = new HashMap<>();
        private static final Map<String, String> online_image_status = new HashMap<>();

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

        private static void drawImage (GuiGraphics graphic, int posX, int posZ, int overall_sizeX, int overall_sizeZ, int slideX, int slideZ, int split_sizeX, int split_sizeZ, String path) {

            graphic.blit(ResourceLocation.parse(path), (graphic.guiWidth() / 2) + posX, (graphic.guiHeight() / 2) + posZ, slideX,slideZ, split_sizeX, split_sizeZ, overall_sizeX, overall_sizeZ);

        }

        public static void drawImageBasic (GuiGraphics graphic, int posX, int posZ, int sizeX, int sizeZ, String path) {

            posX = -posX;
            posZ = -posZ;
            drawImage(graphic, posX, posZ, sizeX, sizeZ, 0, 0, sizeX, sizeZ, path);

        }

        public static void drawImageSplit (GuiGraphics graphic, int posX, int posZ, int overall_sizeX, int overall_sizeZ, boolean is_horizontal, int piece_count, int choose, String path) {

            posX = -posX;
            posZ = -posZ;

            int split_sizeX = 0;
            int split_sizeZ = 0;
            int slideX = 0;
            int slideZ = 0;

            if (is_horizontal == true) {

                split_sizeX = overall_sizeX / piece_count;
                split_sizeZ = overall_sizeZ;
                slideX = split_sizeX * choose;
                slideZ = overall_sizeX;

            } else {

                split_sizeX = overall_sizeX;
                split_sizeZ = overall_sizeZ / piece_count;
                slideX = overall_sizeX;
                slideZ = split_sizeZ * choose;

            }

            drawImage(graphic, posX, posZ, overall_sizeX, overall_sizeZ, slideX, slideZ, split_sizeX, split_sizeZ, path);

        }

        public static void drawImageOnline (GuiGraphics graphic, int posX, int posZ, int sizeX, int sizeZ, String url, String path_loading, String path_fail) {

            String id = online_image_id.get(url);

            if (id == null) {

                id = "tannyjung:online_image_" + online_image_id.size() + ".png";
                online_image_id.put(url, id);
                online_image_status.put(id, "loading");
                String id_final = id;

                Core.thread_main.submit(() -> {

                    {

                        if (OutsideUtils.isURLAvailable(url) == true) {

                            try {

                                BufferedImage buffer = ImageIO.read(URI.create(url).toURL());
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
                                Minecraft.getInstance().getTextureManager().register(ResourceLocation.parse(id_final), new DynamicTexture(native_image));

                                online_image_status.put(id_final, "available");

                            } catch (Exception exception) {

                                OutsideUtils.exception(new Exception(), exception, "");
                                online_image_status.put(id_final, "fail");

                            }

                        } else {

                            online_image_status.put(id_final, "fail");

                        }

                    }

                });

            }

            String status = online_image_status.get(id);

            if (status.equals("loading") == true) {

                id = path_loading;

            } else if (status.equals("fail") == true) {

                id = path_fail;

            }

            drawImageBasic(graphic, posX, posZ, sizeX, sizeZ, id);

        }

    }

    public static class GUI {

        private static void drawButton (GUIScreen screen, int posX, int posZ, int length, String text, Button button) {

            posX = -posX;
            posZ = -posZ;

            button.setSize(length, 12);
            button.setPosition(screen.getGuiLeft() + posX, screen.getGuiTop() + posZ + 4);

            GUIScreen.addWidget(screen, button);

            // Ingredient
            {

                posX = -posX;
                posZ = -posZ;
                int[] pos_convert = convertPosTextCenter(posX - (length / 2), posZ - (12 / 2), 0.67, text);
                Ingredient.text.add(new Object[]{"", pos_convert[0], pos_convert[1], 0.67, true, text});

            }

        }

        public static void drawButtonBasic (GUIScreen screen, int posX, int posZ, int length, String text, String network, String work_type, String work) {

            Button button = Button.builder(Component.empty(), create -> {

                create.setFocused(false);

                if (network.equals("client") == true) {

                    NetworkManager.runClient(screen.player, work_type, work, new CompoundTag());

                } else if (network.equals("server") == true) {

                    NetworkManager.runServer(screen.player, work_type, work, new CompoundTag());

                } else if (network.equals("client_core") == true) {

                    NetworkManager.runClientCore(screen.player, work_type, work, new CompoundTag());

                } else if (network.equals("server_core") == true) {

                    NetworkManager.runServerCore(screen.player, work_type, work, new CompoundTag());

                }

            }).build();

            drawButton(screen, posX, posZ, length, text, button);

        }

        public static void drawButtonLocked (GUIScreen screen, int posX, int posZ, int length, String text) {

            Button button = Button.builder(Component.empty(), create -> {}).build();
            button.active = false;
            drawButton(screen, posX, posZ, length, text, button);

        }

        public static void drawSwitch (GUIScreen screen, int posX, int posZ, String nbt, String text) {

            posX = -posX;
            posZ = -posZ;

            Button button_left = Button.builder(Component.empty(), create -> {

                CompoundTag extra_data = new CompoundTag();
                extra_data.putString("name", nbt);
                NetworkManager.runServerCore(screen.player, "gui", "switch", extra_data);

            }).bounds(screen.getGuiLeft() + posX, screen.getGuiTop() + posZ - 1, 5, 6).build();

            Button button_right = Button.builder(Component.empty(), create -> {

                CompoundTag extra_data = new CompoundTag();
                extra_data.putString("name", nbt);
                NetworkManager.runServerCore(screen.player, "gui", "switch", extra_data);

            }).bounds(screen.getGuiLeft() + posX + 5, screen.getGuiTop() + posZ - 1, 5, 6).build();

            if (NBTManager.getEntityLogic(screen.player, "gui", nbt) == true) {

                button_left.active = false;
                button_right.active = true;

            } else {

                button_left.active = true;
                button_right.active = false;

            }

            GUIScreen.addWidget(screen, button_left);
            GUIScreen.addWidget(screen, button_right);

            // Ingredient
            {

                Ingredient.text.add(new Object[]{"", -(posX) - 14, -(posZ) - 0, 0.67, false, text});

            }

        }

        public static void drawTextBox (GUIScreen screen, int posX, int posZ, String nbt) {

            posX = -posX;
            posZ = -posZ;

            EditBox box = new EditBox(Minecraft.getInstance().font, screen.getGuiLeft() + posX + 10, screen.getGuiTop() + posZ + 4, 160 - 10, 8 + 6, Component.literal("Hello"));
            box.setValue(NBTManager.getEntityText(screen.player, "gui", nbt));
            box.setMaxLength(8192);
            box.setTextShadow(false);

            Button button = Button.builder(Component.literal("{"), create -> {

                CompoundTag extra_data = new CompoundTag();
                extra_data.putString("name", nbt);
                extra_data.putString("value", box.getValue());
                NetworkManager.runServerCore(screen.player, "gui", "text_box_save", extra_data);

            }).bounds(screen.getGuiLeft() + posX, screen.getGuiTop() + posZ + 4, 10, 8 + 6).build();

            GUIScreen.addWidget(screen, box);
            GUIScreen.addWidget(screen, button);

        }

        public static void drawImageButton (GUIScreen screen, int posX, int posZ, int sizeX, int sizeZ, String network, String work_type, String work, String path) {

            posX = -posX;
            posZ = -posZ;
            ResourceLocation location = ResourceLocation.parse(path);

            ImageButton button = new ImageButton(screen.getGuiLeft() + posX, screen.getGuiTop() + posZ, sizeX, sizeZ / 2, new WidgetSprites(location, location), create -> {

                create.setFocused(false);

                if (network.equals("client") == true) {

                    NetworkManager.runClient(screen.player, work_type, work, new CompoundTag());

                } else if (network.equals("server") == true) {

                    NetworkManager.runServer(screen.player, work_type, work, new CompoundTag());

                } else if (network.equals("client_core") == true) {

                    NetworkManager.runClientCore(screen.player, work_type, work, new CompoundTag());

                } else if (network.equals("server_core") == true) {

                    NetworkManager.runServerCore(screen.player, work_type, work, new CompoundTag());

                }

            }) {

                @Override
                public void renderWidget (GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {

                    int offset = 0;

                    if (isHoveredOrFocused() == true) {

                        offset = height;

                    }

                    guiGraphics.blit(sprites.get(true, isHoveredOrFocused()), getX(), getY(), 0, offset, width, height, width, height * 2);

                }

            };

            GUIScreen.addWidget(screen, button);

        }

    }

}
