package tannyjung.tanscomplexmagic_core.game.screen;

import com.mojang.blaze3d.platform.NativeImage;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.*;
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
import java.util.*;

public class ScreenDrawing {

    public static double normal_font_scale = 0.68;

    public static void refresh () {

        GUIScreen.refresh = true;

    }

    public static class Anchor {

        public static int[] getWindowPoint (int windowX, int windowZ, boolean is_top, boolean is_bottom, boolean is_left, boolean is_right) {

            windowX = windowX / 2;
            windowZ = windowZ / 2;

            if (is_top == true && is_bottom == false) {

                if (is_left == true && is_right == false) {

                    return new int[]{-windowX, -windowZ};

                } else if (is_left == false && is_right == true) {

                    return new int[]{windowX, -windowZ};

                } else {

                    return new int[]{(int) (windowX * 1.5), (int) (windowZ * 1.5)};

                }

            }

            return new int[]{0, 0};

        }

        public static int[] convertPosCenter (int centerX, int centerZ, int sizeX, int sizeZ) {

            return new int[]{centerX - sizeX, centerZ - sizeZ};

        }

        private static int[] convertPosCenterText (int centerX, int centerZ, double scale, String text) {

            int sizeX = Minecraft.getInstance().font.width(text) / 2;
            int sizeZ = (Minecraft.getInstance().font.lineHeight - 1) / 2;
            sizeX = (int) Math.floor(sizeX * scale);
            sizeZ = (int) Math.floor(sizeZ * scale);
            return Anchor.convertPosCenter(centerX, centerZ, sizeX, sizeZ);

        }

    }

    private static int[] convertPosAnchor (GuiGraphics graphic, int posX, int posZ, String pos_anchor, double scale) {

        int[] pos = new int[]{0, 0};

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

        pos[0] = (int) Math.round(pos[0] / scale);
        pos[1] = (int) Math.round(pos[1] / scale);
        return pos;

    }

    public static class AutoLine {

        private static boolean start = false;
        private static int save_pos = 0;
        private static String previous_type = "";

        public static void start (int pos) {

            start = true;
            save_pos = pos;
            previous_type = "";

        }
        
        public static void stop () {

            start = false;
            
        }

        public static void addSpaceMark () {

            save_pos = save_pos + 8;

        }

        private static int test (int original_posZ, String type, int distance) {

            if (start == false) {
                
                return original_posZ;
                
            }
            
            int export = 0;

            if (previous_type.isEmpty() == true) {

                previous_type = type;
                export = save_pos;

            } else {

                if (previous_type.equals(type) == false) {

                    previous_type = type;
                    save_pos = save_pos + 8;

                }

                export = save_pos;

            }

            save_pos = save_pos + distance;
            return export;

        }

    }

    public static class Ingredient {

        private static final Set<Object[]> text = new HashSet<>();

        public static void clear () {

            text.clear();

        }

        public static void renderText (GuiGraphics graphic) {

            for (Object[] objects : text) {

                ComponentBasic.drawText(graphic, (int) objects[1], (int) objects[2], (double) objects[3], (boolean) objects[4], (String) objects[5]);

            }

        }

    }

    public static class ComponentBasic {

        private static final Map<String, String> online_image_id = new HashMap<>();
        private static final Map<String, String> online_image_status = new HashMap<>();

        public static void drawText (GuiGraphics graphic, int posX, int posZ, double scale, boolean shadow, String text) {

            posX = (int) Math.round(posX / scale);
            posZ = (int) Math.round(posZ / scale);

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

        public static void drawTextCentered (GuiGraphics graphic, int centerX, int centerZ, boolean is_only_vertical, double scale, String text) {

            int[] pos_convert = Anchor.convertPosCenterText(centerX, centerZ, scale, text);

            if (is_only_vertical == true) {

                pos_convert[0] = centerX;

            }

            drawText(graphic, pos_convert[0], pos_convert[1], scale, false, text);

        }

        public static void drawTextParagraph (GuiGraphics graphic, int posX, int posZ, int length_per_line, String text) {

            posZ = AutoLine.test(posZ, "text_paragraph", 8);

            Map<Integer, StringBuilder> paragraph = new HashMap<>();
            int line = 0;
            int width = 0;
            int width_all = 0;

            for (String word : text.split(" ")) {

                word = word + " ";
                width = (int) (Minecraft.getInstance().font.width(word) * normal_font_scale);

                if (width_all + width < length_per_line) {

                    width_all = width_all + width;

                } else {

                    line = line + 1;
                    width_all = width;

                }

                paragraph.computeIfAbsent(line, create -> new StringBuilder()).append(word);

            }

            for (Map.Entry<Integer, StringBuilder> entry : paragraph.entrySet()) {

                AutoLine.test(posZ, "text_paragraph", 8);

                drawText(graphic, posX, posZ + (entry.getKey() * 8), normal_font_scale, false, entry.getValue().toString());

            }

        }

        private static void drawImage (GuiGraphics graphic, int posX, int posZ, int overall_sizeX, int overall_sizeZ, int slideX, int slideZ, int split_sizeX, int split_sizeZ, String path) {

            graphic.blit(ResourceLocation.parse(path), (graphic.guiWidth() / 2) + posX, (graphic.guiHeight() / 2) + posZ, slideX,slideZ, split_sizeX, split_sizeZ, overall_sizeX, overall_sizeZ);

        }

        public static void drawImageBasic (GuiGraphics graphic, int posX, int posZ, int sizeX, int sizeZ, String path) {

            drawImage(graphic, posX, posZ, sizeX, sizeZ, 0, 0, sizeX, sizeZ, path);

        }

        public static void drawImageSplit (GuiGraphics graphic, int posX, int posZ, int overall_sizeX, int overall_sizeZ, boolean is_horizontal, int piece_count, int choose, String path) {

            int split_sizeX = 0;
            int split_sizeZ = 0;
            int slideX = 0;
            int slideZ = 0;

            if (is_horizontal == true) {

                split_sizeX = overall_sizeX / piece_count;
                split_sizeZ = overall_sizeZ;
                slideX = split_sizeX * choose;
                slideZ = overall_sizeZ;

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

                id = "tannyjung:online_image_" + (online_image_id.size() + 1) + ".png";
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
                                Minecraft.getInstance().getTextureManager().register(ResourceLocation.parse(id_final), new DynamicTexture(native_image));
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

            if (id.isEmpty() == true) {

                return;

            }

            drawImageBasic(graphic, posX, posZ, sizeX, sizeZ, id);

        }

    }

    public static class ComponentAdvance {

        public static void drawShape (GUIScreen screen, int posX, int posZ, int sizeX, int sizeZ) {

            drawButton(screen, posX, posZ, sizeX, sizeZ, 0, false, true, "", "", () -> {});

        }

        private static void drawButton (GUIScreen screen, int posX, int posZ, int sizeX, int sizeZ, double font_scale, boolean is_active, boolean is_lock, String text_lock, String text_unlock, Runnable runnable) {

            Button button = Button.builder(Component.empty(), create -> {

                create.setFocused(false);
                runnable.run();

            }).build();

            button.setSize(sizeX, sizeZ);
            button.setPosition(screen.getGuiLeft() + posX, screen.getGuiTop() + posZ);
            String text = "";

            if (is_active == false) {

                button.active = false;

            } else {

                if (is_lock == true) {

                    button.active = false;
                    text = text_lock;

                } else {

                    text = text_unlock;

                }

            }

            GUIScreen.addWidget(screen, button);

            // Ingredient
            {

                int[] pos_convert = Anchor.convertPosCenterText(posX + (sizeX / 2), posZ + (sizeZ / 2), font_scale, text);
                Ingredient.text.add(new Object[]{"", pos_convert[0], pos_convert[1], font_scale, true, text});

            }

        }

        public static void drawButtonBasic (GUIScreen screen, int posX, int posZ, int length, String text, String network, String work_type, String work) {

            posZ = AutoLine.test(posZ, "button", 12);

            drawButton(screen, posX, posZ + 1, length, 10, normal_font_scale, true, false, "", text, () -> {

                if (network.equals("client") == true) {

                    NetworkManager.runClient(screen.player, work_type, work, new CompoundTag());

                } else if (network.equals("server") == true) {

                    NetworkManager.runServer(screen.player, work_type, work, new CompoundTag());

                } else if (network.equals("client_core") == true) {

                    NetworkManager.runClientCore(screen.player, work_type, work, new CompoundTag());

                } else if (network.equals("server_core") == true) {

                    NetworkManager.runServerCore(screen.player, work_type, work, new CompoundTag());

                }

            });

        }

        public static void drawButtonLockable (GUIScreen screen, int posX, int posZ, int length, boolean is_active, boolean is_lock, String text_lock, String text_unlock, String network, String work_type, String work) {

            posZ = AutoLine.test(posZ, "button", 12);

            drawButton(screen, posX, posZ + 1, length, 10, normal_font_scale, is_active, is_lock, text_lock, text_unlock, () -> {

                if (network.equals("client") == true) {

                    NetworkManager.runClient(screen.player, work_type, work, new CompoundTag());

                } else if (network.equals("server") == true) {

                    NetworkManager.runServer(screen.player, work_type, work, new CompoundTag());

                } else if (network.equals("client_core") == true) {

                    NetworkManager.runClientCore(screen.player, work_type, work, new CompoundTag());

                } else if (network.equals("server_core") == true) {

                    NetworkManager.runServerCore(screen.player, work_type, work, new CompoundTag());

                }

            });

        }

        public static void drawSwitch (GUIScreen screen, int posX, int posZ, boolean is_active, boolean is_lock, String nbt_type, String nbt_name, String text) {

            posZ = AutoLine.test(posZ, "switch", 8);

            CompoundTag extra_data = new CompoundTag();
            extra_data.putString("nbt_type", nbt_type);
            extra_data.putString("nbt_name", nbt_name);

            Button button_left = Button.builder(Component.empty(), create -> {

                NetworkManager.runServerCore(screen.player, "gui", "switch", extra_data);

            }).bounds(screen.getGuiLeft() + posX, screen.getGuiTop() + posZ + 1, 6, 6).build();

            Button button_right = Button.builder(Component.empty(), create -> {

                NetworkManager.runServerCore(screen.player, "gui", "switch", extra_data);

            }).bounds(screen.getGuiLeft() + posX + 6, screen.getGuiTop() + posZ + 1, 6, 6).build();

            if (is_active == false) {

                button_left.active = false;
                button_right.active = false;

            } else {

                if (is_lock == true) {

                    button_left.active = false;
                    button_right.active = false;

                } else {

                    if (NBTManager.Mob.getLogic(screen.player, nbt_type, nbt_name) == true) {

                        button_left.active = false;
                        button_right.active = true;

                    } else {

                        button_left.active = true;
                        button_right.active = false;

                    }

                }

            }

            GUIScreen.addWidget(screen, button_left);
            GUIScreen.addWidget(screen, button_right);

            // Ingredient
            {

                int[] pos_convert = Anchor.convertPosCenterText(0, posZ + 4, normal_font_scale, text);
                Ingredient.text.add(new Object[]{"", posX + 16, pos_convert[1], normal_font_scale, false, text});

            }

        }

        private static void drawTextBox (GUIScreen screen, int posX, int posZ, boolean is_active, boolean is_lock, String text_lock, String text_unlock, String nbt_type, String nbt_name) {

            posZ = AutoLine.test(posZ, "text_box", 24);

            EditBox box = new EditBox(Minecraft.getInstance().font, screen.getGuiLeft() + posX + 10, screen.getGuiTop() + posZ + 8, 150, 14, Component.empty());
            box.setMaxLength(10000);
            box.setTextShadow(false);

            if (is_active == false || is_lock == true) {

                box.active = false;
                box.setEditable(false);

            } else {

                box.setValue(NBTManager.Mob.getText(screen.player, nbt_type, nbt_name));

            }

            GUIScreen.addWidget(screen, box);

            // Ingredient
            {

                Ingredient.text.add(new Object[]{"", posX, posZ, normal_font_scale, false, text_unlock});

                drawButton(screen, posX, posZ + 8, 10, 14, 1.0, true, is_active == false || is_lock == true, "§7{", "§f{", () -> {

                    CompoundTag extra_data = new CompoundTag();
                    extra_data.putString("nbt_type", nbt_type);
                    extra_data.putString("nbt_name", nbt_name);
                    extra_data.putString("nbt_value", box.getValue());
                    NetworkManager.runServerCore(screen.player, "gui", "text_box", extra_data);

                });

                if (is_lock == true) {

                    int[] pos_convert = Anchor.convertPosCenterText(posX + 10 + (150 / 2), posZ + 15, normal_font_scale, text_lock);
                    Ingredient.text.add(new Object[]{"", pos_convert[0], pos_convert[1], normal_font_scale, false, text_lock});

                }

            }

        }

        public static void drawTextBoxBasic (GUIScreen screen, int posX, int posZ, String text, String nbt_type, String nbt_name) {

            drawTextBox(screen, posX, posZ, true, false, "", text, nbt_type, nbt_name);

        }

        public static void drawTextBoxLockable (GUIScreen screen, int posX, int posZ, boolean is_active, boolean is_lock, String text_lock, String text_unlock, String nbt_type, String nbt_name) {

            drawTextBox(screen, posX, posZ, is_active, is_lock, text_lock, text_unlock, nbt_type, nbt_name);

        }

        public static void drawImageButton (GUIScreen screen, int posX, int posZ, int sizeX, int sizeZ, boolean is_horizontal, boolean is_active, boolean is_lock, String network, String work_type, String work, String path) {

            ResourceLocation location = ResourceLocation.parse(path);

            if (is_horizontal == true) {

                sizeX = sizeX / 2;

            } else {

                sizeZ = sizeZ / 2;

            }

            ImageButton button = new ImageButton(screen.getGuiLeft() + posX, screen.getGuiTop() + posZ, sizeX, sizeZ, new WidgetSprites(location, location), create -> {

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

                    int offsetX = 0;
                    int offsetZ = 0;
                    int multiply_width = 1;
                    int multiply_height = 1;

                    if (isHoveredOrFocused() == true) {

                        if (is_horizontal == true) {

                            offsetX = width;

                        } else {

                            offsetZ = height;

                        }

                    }

                    if (is_horizontal == true) {

                        multiply_width = 2;

                    } else {

                        multiply_height = 2;

                    }

                    guiGraphics.blit(sprites.get(true, isHoveredOrFocused()), getX(), getY(), offsetX, offsetZ, width, height, width * multiply_width, height * multiply_height);

                }

            };

            button.active = is_active == true && is_lock == false;

            GUIScreen.addWidget(screen, button);

        }

        public static void drawSlider (GUIScreen screen, int posX, int posZ, double value_min, double value_max, double value_move, boolean is_active, boolean is_lock, String nbt_type, String nbt_name, String text) {

            posZ = AutoLine.test(posZ, "slider", 16);

            double range = value_max - value_min;
            double value_default = NBTManager.Mob.getNumber(screen.player, nbt_type, nbt_name);
            double value_default_percent = (value_default - value_min) / range;

            if (value_default_percent < 0.0 || value_default_percent > 1.0) {

                value_default_percent = 0.0;
                CompoundTag extra_data = new CompoundTag();
                extra_data.putString("nbt_type", nbt_type);
                extra_data.putString("nbt_name", nbt_name);
                extra_data.putDouble("nbt_value", value_min);
                NetworkManager.runServerCore(screen.player, "gui", "slider", extra_data);

            }

            AbstractSliderButton slider = new AbstractSliderButton(screen.getGuiLeft() + posX, screen.getGuiTop() + posZ + 8, 160, 6, Component.empty(), value_default_percent) {

                private final double value_previous = value_min - 1.0;

                @Override
                protected void updateMessage () {
                }

                @Override
                protected void applyValue () {

                    double value = this.value;
                    value = value * range;
                    value = Math.round(value / value_move);
                    value = (value * value_move) + value_min;

                    if (value != value_previous) {

                        CompoundTag extra_data = new CompoundTag();
                        extra_data.putString("nbt_type", nbt_type);
                        extra_data.putString("nbt_name", nbt_name);
                        extra_data.putDouble("nbt_value", value);
                        NetworkManager.runServerCore(screen.player, "gui", "slider", extra_data);

                    }

                }

            };

            slider.active = is_active == true && is_lock == false;
            GUIScreen.addWidget(screen, slider);

            // Ingredient
            {

                text = text + " (";

                if (value_default % 1 == 0) {

                    text = text + (int) value_default;

                } else {

                    text = text + value_default;

                }

                text = text + ")";
                Ingredient.text.add(new Object[]{"", posX, posZ, normal_font_scale, false, text});

            }

        }

        public static void drawRadio (GUIScreen screen, int posX, int posZ, boolean is_active, boolean is_lock, String text, String nbt_type, String nbt_name, String nbt_value) {

            posZ = AutoLine.test(posZ, "radio", 8);

            // Ingredient
            {

                Ingredient.text.add(new Object[]{"", posX, posZ, normal_font_scale, false, text});

            }

            boolean is_select = false;
            int[] pos_convert = new int[]{};

            for (String scan : nbt_value.split(" / ")) {

                posZ = AutoLine.test(posZ, "radio", 8);

                is_select = NBTManager.Mob.getText(screen.player, nbt_type, nbt_name).equals(scan) == true;

                CompoundTag extra_data = new CompoundTag();
                extra_data.putString("nbt_type", nbt_type);
                extra_data.putString("nbt_name", nbt_name);
                extra_data.putString("nbt_value", scan);

                drawButton(screen, posX, posZ + 1, 6, 6, 0.0, is_active, is_lock == true || is_select == true, "", "", () -> {

                    NetworkManager.runServerCore(screen.player, "gui", "radio", extra_data);

                });

                // Ingredient
                {

                    if (is_select == false) {

                        scan = "§7" + scan;

                    }

                    pos_convert = Anchor.convertPosCenterText(0, posZ + 4, normal_font_scale, scan);
                    Ingredient.text.add(new Object[]{"", posX + 10, pos_convert[1], normal_font_scale, false, scan});

                }

            }

        }

    }

}
