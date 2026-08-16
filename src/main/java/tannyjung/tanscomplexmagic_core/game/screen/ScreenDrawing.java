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

    private static class NBT {

        private static boolean getLogic (GUIScreen screen, String type, String name) {

            if (GUIScreen.item.isEmpty() == true) {

                return NBTManager.Mob.getLogic(screen.player, type, name);

            } else {

                return NBTManager.Item.getLogic(GUIScreen.item, type, name);

            }

        }

        private static String getText (GUIScreen screen, String type, String name) {

            if (GUIScreen.item.isEmpty() == true) {

                return NBTManager.Mob.getText(screen.player, type, name);

            } else {

                return NBTManager.Item.getText(GUIScreen.item, type, name);

            }

        }

        private static double getNumber (GUIScreen screen, String type, String name) {

            if (GUIScreen.item.isEmpty() == true) {

                return NBTManager.Mob.getNumber(screen.player, type, name);

            } else {

                return NBTManager.Item.getNumber(GUIScreen.item, type, name);

            }

        }

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
            sizeX = (int) Math.round(sizeX * scale);
            sizeZ = (int) Math.round(sizeZ * scale);
            return Anchor.convertPosCenter(centerX, centerZ, sizeX, sizeZ);

        }

    }

    public static class AutoLine {

        private static boolean is_active = false;
        private static boolean is_pause = false;
        private static String previous_type = "";
        private static int posX = 0;
        private static int posZ = 0;
        private static int markX = 0;
        private static int markZ = 0;
        private static String markX_previous_type = "";
        private static String markZ_previous_type = "";

        public static void start (int posX, int posZ) {

            is_active = true;
            previous_type = "";
            AutoLine.posX = posX;
            AutoLine.posZ = posZ;

        }
        
        public static void stop () {

            is_active = false;
            
        }

        public static void setMarkX () {

            markX = posX;
            markX_previous_type = previous_type;

        }

        public static void setMarkZ () {

            markZ = posZ;
            markZ_previous_type = previous_type;

        }

        public static void returnMarkX () {

            posX = markX;
            previous_type = markX_previous_type;

        }

        public static void returnMarkZ () {

            posZ = markZ;
            previous_type = markZ_previous_type;

        }

        public static void addSpace (int size) {

            if (is_pause == true) {

                return;

            }

            posZ = posZ + size;

        }

        private static int getPosX (int originalX) {

            if (is_active == true && is_pause == false) {

                if (originalX != 0) {

                    return posX + originalX;

                }

                return posX;

            }

            return originalX;

        }

        private static int getPosZ (int originalZ, String type, int add_same, int add_different) {

            if (is_active == true && is_pause == false) {

                if (previous_type.isEmpty() == true) {

                    previous_type = type;

                } else {

                    if (previous_type.equals(type) == true) {

                        posZ = posZ + add_same;

                    } else {

                        posZ = posZ + add_different;
                        previous_type = type;

                    }

                }

                if (originalZ != 0) {

                    return posZ + originalZ;

                }

                return posZ;

            }

            return originalZ;

        }

        public static void setPosX (int posX) {

            AutoLine.posX = posX;

        }

    }

    public static class ComponentBasic {

        private static final Map<String, String> online_image_id = new HashMap<>();
        private static final Map<String, String> online_image_status = new HashMap<>();

        private static void drawText (GuiGraphics graphic, int posX, int posZ, double scale, boolean shadow, String text) {

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
        
        public static void drawTextBasic (int posX, int posZ, double scale, String text) {

            posX = AutoLine.getPosX(posX);
            posZ = AutoLine.getPosZ(posZ, "text_basic", 3, 8);
            AutoLine.addSpace((int) Math.round(8 * scale));

            PreCalculate.addText(posX, posZ, scale, false, text);
            
        }

        public static void drawTextParagraph (int posX, int posZ, int length_per_line, String text) {

            posX = AutoLine.getPosX(posX);
            posZ = AutoLine.getPosZ(posZ, "text_paragraph", 8, 8);

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

                AutoLine.addSpace(8);
                PreCalculate.addText(posX, posZ + (entry.getKey() * 8), normal_font_scale, false, entry.getValue().toString());

            }

        }

        private static void drawTextCentered (int posX, int posZ, boolean is_only_vertical, double scale, boolean shadow, String text) {

            posX = AutoLine.getPosX(posX);
            posZ = AutoLine.getPosZ(posZ, "text_centered", 8, 8);
            AutoLine.addSpace((int) (4 * scale));

            int[] pos_convert = Anchor.convertPosCenterText(posX, posZ, scale, text);

            if (is_only_vertical == true) {

                pos_convert[0] = posX;

            }

            PreCalculate.addText(pos_convert[0], pos_convert[1], scale, shadow, text);

        }

        public static void drawTextCenteredBasic (int posX, int posZ, boolean is_only_vertical, double scale, String text) {

            drawTextCentered(posX, posZ, is_only_vertical, scale, false, text);

        }

        public static void drawTextCenteredShadow (int posX, int posZ, boolean is_only_vertical, double scale, String text) {

            drawTextCentered(posX, posZ, is_only_vertical, scale, true, text);

        }

        private static void drawImage (GuiGraphics graphic, int posX, int posZ, int overall_sizeX, int overall_sizeZ, int slideX, int slideZ, int split_sizeX, int split_sizeZ, String path) {
            
            graphic.blit(ResourceLocation.parse(path), (graphic.guiWidth() / 2) + posX, (graphic.guiHeight() / 2) + posZ, slideX,slideZ, split_sizeX, split_sizeZ, overall_sizeX, overall_sizeZ);

        }

        public static void drawImageBasic (int posX, int posZ, int sizeX, int sizeZ, String path) {

            PreCalculate.addImage(posX, posZ, sizeX, sizeZ, 0, 0, sizeX, sizeZ, path);

        }

        public static void drawImageSplit (int posX, int posZ, int overall_sizeX, int overall_sizeZ, boolean is_horizontal, int piece_count, int choose, String path) {

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

            PreCalculate.addImage(posX, posZ, overall_sizeX, overall_sizeZ, slideX, slideZ, split_sizeX, split_sizeZ, path);

        }

        public static void drawImageOnline (int posX, int posZ, int sizeX, int sizeZ, String url, String path_loading, String path_fail) {

            String id = online_image_id.get(url);

            if (id == null) {

                id = "tannyjung:online_image_" + (online_image_id.size() + 1) + ".png";
                online_image_id.put(url, id);
                online_image_status.put(id, "loading");
                String id_final = id;

                Core.thread.submit(() -> {

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

            PreCalculate.addImage(posX, posZ, sizeX, sizeZ, 0, 0, sizeX, sizeZ, id);

        }

        public static class PreCalculate {

            private static final List<Object[]> text = new ArrayList<>();
            private static final List<Object[]> image = new ArrayList<>();

            public static void clear () {

                text.clear();
                image.clear();

            }

            public static void renderText (GuiGraphics graphic) {

                for (Object[] objects : text) {

                    drawText(graphic, (int) objects[0], (int) objects[1], (double) objects[2], (boolean) objects[3], (String) objects[4]);

                }

            }

            public static void renderImage (GuiGraphics graphic) {

                for (Object[] objects : image) {

                    drawImage(graphic, (int) objects[0], (int) objects[1], (int) objects[2], (int) objects[3], (int) objects[4], (int) objects[5], (int) objects[6], (int) objects[7], (String) objects[8]);

                }

            }

            private static void addText (int posX, int posZ, double scale, boolean shadow, String text) {

                PreCalculate.text.add(new Object[]{posX, posZ, scale, shadow, text});

            }

            private static void addImage (int posX, int posZ, int overall_sizeX, int overall_sizeZ, int slideX, int slideZ, int split_sizeX, int split_sizeZ, String path) {

                image.add(new Object[]{posX, posZ, overall_sizeX, overall_sizeZ, slideX, slideZ, split_sizeX, split_sizeZ, path});

            }

        }

    }

    public static class ComponentAdvance {

        public static void regenerate () {

            Shape.map.clear();
            ButtonTiny.map.clear();
            ButtonImage.map.clear();
            TextBox.map.clear();
            Slider.map.clear();

        }

        public static class Shape {

            private static final Map<String, Button> map = new HashMap<>();

            private static void draw (GUIScreen screen, int posX, int posZ, int sizeX, int sizeZ) {

                String key = posX + "/" + posZ;
                Button button = map.get(key);

                if (button == null) {

                    button = Button.builder(Component.empty(), create -> {}).build();
                    button.setPosition(screen.getGuiLeft() + posX, screen.getGuiTop() + posZ);
                    button.setSize(sizeX, sizeZ);
                    button.active = false;
                    GUIScreen.addWidget(screen, button);
                    map.put(key, button);

                }

            }

        }

        public static class ButtonTiny {

            private static final Map<String, Button> map = new HashMap<>();

            private static void draw (GUIScreen screen, int posX, int posZ, int sizeX, int sizeZ, boolean is_active, boolean is_lock, Runnable runnable) {

                String key = posX + "/" + posZ;
                Button button = map.get(key);

                if (button == null) {

                    button = Button.builder(Component.empty(), create -> {

                        runnable.run();

                    }).build();

                    button.setPosition(screen.getGuiLeft() + posX, screen.getGuiTop() + posZ);
                    button.setSize(sizeX, sizeZ);
                    GUIScreen.addWidget(screen, button);
                    map.put(key, button);

                }

                button.active = is_active == true && is_lock == false;

            }

            public static void drawBasic (GUIScreen screen, int posX, int posZ, int sizeX, int sizeZ, String network, String work_type, String work) {

                drawBasicLockable(screen, posX, posZ, sizeX, sizeZ, true, false, network, work_type, work);

            }

            public static void drawBasicLockable (GUIScreen screen, int posX, int posZ, int sizeX, int sizeZ, boolean is_active, boolean is_lock, String network, String work_type, String work) {

                drawBasicRunnableLockable(screen, posX, posZ, sizeX, sizeZ, is_active, is_lock, () -> {

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

            public static void drawBasicRunnable (GUIScreen screen, int posX, int posZ, int sizeX, int sizeZ, Runnable runnable) {

                drawBasicRunnableLockable(screen, posX, posZ, sizeX, sizeZ, true, false, runnable);

            }

            public static void drawBasicRunnableLockable (GUIScreen screen, int posX, int posZ, int sizeX, int sizeZ, boolean is_active, boolean is_lock, Runnable runnable) {

                posX = AutoLine.getPosX(posX);
                posZ = AutoLine.getPosZ(posZ, "button", 1, 8);
                AutoLine.addSpace(sizeZ);

                draw(screen, posX, posZ, sizeX, sizeZ, is_active, is_lock, runnable);

            }

            public static void drawText (GUIScreen screen, int posX, int posZ, int length, String network, String work_type, String work, String text) {

                drawTextLockable(screen, posX, posZ, length, true, false, network, work_type, work, "", text);

            }

            public static void drawTextLockable (GUIScreen screen, int posX, int posZ, int length, boolean is_active, boolean is_lock, String network, String work_type, String work, String text_lock, String text_unlock) {

                drawTextRunnableLockable(screen, posX, posZ, length, is_active, is_lock, text_lock, text_unlock, () -> {

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

            public static void drawTextRunnable (GUIScreen screen, int posX, int posZ, int length, String text, Runnable runnable) {

                drawTextRunnableLockable(screen, posX, posZ, length, true, false, "", text, runnable);

            }

            public static void drawTextRunnableLockable (GUIScreen screen, int posX, int posZ, int length, boolean is_active, boolean is_lock, String text_lock, String text_unlock, Runnable runnable) {

                posX = AutoLine.getPosX(posX);
                posZ = AutoLine.getPosZ(posZ, "button", 1, 8);
                AutoLine.addSpace(11);

                AutoLine.is_pause = true;
                drawBasicRunnableLockable(screen, posX, posZ, length, 11, true, false, runnable);

                // Ingredient
                {

                    String text = "";

                    if (is_active == true && is_lock == false) {

                        text = "§f" + text_unlock;

                    } else {

                        text = "§c" + text_lock;

                    }

                    AutoLine.is_pause = true;
                    ComponentBasic.drawTextCenteredShadow(posX + (length / 2), posZ + 6, false, normal_font_scale, text);

                }

                AutoLine.is_pause = false;

            }

        }

        public static class ButtonImage {

            private static final Map<String, ImageButton> map = new HashMap<>();

            public static void draw (GUIScreen screen, int posX, int posZ, int sizeX, int sizeZ, boolean is_horizontal, boolean is_active, boolean is_lock, String network, String work_type, String work, String path) {

                String key = posX + "/" + posZ;
                ImageButton button = map.get(key);

                if (button == null) {

                    ResourceLocation location = ResourceLocation.parse(path);

                    if (is_horizontal == true) {

                        sizeX = sizeX / 2;

                    } else {

                        sizeZ = sizeZ / 2;

                    }

                    button = new ImageButton(screen.getGuiLeft() + posX, screen.getGuiTop() + posZ, sizeX, sizeZ, new WidgetSprites(location, location), create -> {

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
                        public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {

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
                    map.put(key, button);

                }

            }

        }

        public static class Switch {

            private static void draw (GUIScreen screen, int posX, int posZ, boolean is_active, boolean is_lock, String nbt_type, String nbt_name) {

                CompoundTag extra_data = new CompoundTag();
                extra_data.putBoolean("is_item", GUIScreen.item.isEmpty() == false);
                extra_data.putString("nbt_type", nbt_type);
                extra_data.putString("nbt_name", nbt_name);
                Runnable runnable = () -> NetworkManager.runServerCore(screen.player, "gui", "switch", extra_data);

                boolean value = NBT.getLogic(screen, nbt_type, nbt_name);

                AutoLine.is_pause = true;
                ButtonTiny.drawBasicRunnableLockable(screen, posX, posZ, 6, 6, is_active && value == false, is_lock, runnable);
                AutoLine.is_pause = true;
                ButtonTiny.drawBasicRunnableLockable(screen, posX + 6, posZ, 6, 6, is_active && value == true, is_lock, runnable);
                AutoLine.is_pause = false;

            }

            public static void drawBasic (GUIScreen screen, int posX, int posZ, String nbt_type, String nbt_name) {

                drawBasicLockable(screen, posX, posZ, true, false, nbt_type, nbt_name);

            }

            public static void drawBasicLockable (GUIScreen screen, int posX, int posZ, boolean is_active, boolean is_lock, String nbt_type, String nbt_name) {

                drawTextLockable(screen, posX, posZ, is_active, is_lock, nbt_type, nbt_name, "");

            }

            public static void drawText (GUIScreen screen, int posX, int posZ, String nbt_type, String nbt_name, String text) {

                drawTextLockable(screen, posX, posZ, true, false, nbt_type, nbt_name, text);

            }

            public static void drawTextLockable (GUIScreen screen, int posX, int posZ, boolean is_active, boolean is_lock, String nbt_type, String nbt_name, String text) {

                posX = AutoLine.getPosX(posX);
                posZ = AutoLine.getPosZ(posZ, "switch", 0, 8);
                AutoLine.addSpace(8);

                draw(screen, posX, posZ, is_active, is_lock, nbt_type, nbt_name);

                // Ingredient
                {



                    if (text.isEmpty() == false) {

                        AutoLine.is_pause = true;
                        ComponentBasic.drawTextCenteredBasic(posX + 16, posZ + 4, true, normal_font_scale, text);

                    }

                }

                AutoLine.is_pause = false;

            }

        }

        public static class TextBox {

            private static final Map<String, EditBox> map = new HashMap<>();

            private static void draw (GUIScreen screen, int posX, int posZ, int length, boolean is_active, boolean is_lock, String nbt_type, String nbt_name, String text_lock) {

                String key = posX + "/" + posZ;
                EditBox box = map.get(key);

                if (box == null) {

                    EditBox box_new = new EditBox(Minecraft.getInstance().font, screen.getGuiLeft() + posX, screen.getGuiTop() + posZ, length, 14, Component.empty());
                    box_new.setMaxLength(10000);
                    box_new.setTextShadow(false);

                    box_new.setResponder(value -> {

                        if (box_new.isFocused() == false) {

                            return;

                        }

                        CompoundTag extra_data = new CompoundTag();
                        extra_data.putBoolean("is_item", GUIScreen.item.isEmpty() == false);
                        extra_data.putString("nbt_type", nbt_type);
                        extra_data.putString("nbt_name", nbt_name);
                        extra_data.putString("nbt_value", value);
                        NetworkManager.runServerCore(screen.player, "gui", "text_box", extra_data);

                    });

                    box = box_new;
                    GUIScreen.addWidget(screen, box_new);
                    map.put(key, box_new);

                }

                if (is_active == false || is_lock == true) {

                    box.active = false;
                    box.setEditable(false);

                } else {

                    if (box.isFocused() == false) {

                        box.setValue(NBT.getText(screen, nbt_type, nbt_name));

                    }

                }

                // Ingredient
                {

                    if (is_lock == true) {

                        AutoLine.is_pause = true;
                        ComponentBasic.drawTextCenteredBasic(posX + 9 + (box.getWidth() / 2), posZ + 15, false, normal_font_scale, text_lock);

                    }

                }

                AutoLine.is_pause = false;

            }

            public static void drawBasic (GUIScreen screen, int posX, int posZ, int length, String nbt_type, String nbt_name) {

                drawBasicLockable(screen, posX, posZ, length, true, false, nbt_type, nbt_name, "");

            }

            public static void drawBasicLockable (GUIScreen screen, int posX, int posZ, int length, boolean is_active, boolean is_lock, String nbt_type, String nbt_name, String text_lock) {

                posX = AutoLine.getPosX(posX);
                posZ = AutoLine.getPosZ(posZ, "text_box", 8, 8);
                AutoLine.addSpace(14);

                draw(screen, posX, posZ, length, is_active, is_lock, nbt_type, nbt_name, text_lock);

            }

            public static void drawText (GUIScreen screen, int posX, int posZ, int length, String nbt_type, String nbt_name, String text) {

                drawTextLockable(screen, posX, posZ, length, true, false, nbt_type, nbt_name, text, "");

            }

            public static void drawTextLockable (GUIScreen screen, int posX, int posZ, int length, boolean is_active, boolean is_lock, String nbt_type, String nbt_name, String text, String text_lock) {

                posX = AutoLine.getPosX(posX);
                posZ = AutoLine.getPosZ(posZ, "text_box", 8, 8);
                AutoLine.addSpace(22);

                AutoLine.is_pause = true;
                drawBasicLockable(screen, posX, posZ + 8, length, is_active, is_lock, nbt_type, nbt_name, text_lock);

                // Ingredient
                {

                    AutoLine.is_pause = true;
                    ComponentBasic.drawTextBasic(posX, posZ, normal_font_scale, text);

                }

                AutoLine.is_pause = false;

            }

        }

        public static class Slider {

            private static final Map<String, AbstractSliderButton> map = new HashMap<>();

            private static void draw (GUIScreen screen, int posX, int posZ, int length, boolean is_active, boolean is_lock, double value_min, double value_max, double value_move, String nbt_type, String nbt_name) {

                String key = posX + "/" + posZ;
                AbstractSliderButton slider = map.get(key);

                if (slider != null) {

                    GUIScreen.removeWidget(screen, slider);

                }

                double range = value_max - value_min;
                double value_default = 0.0;

                // Get Default Value
                {

                    double value = NBT.getNumber(screen, nbt_type, nbt_name);
                    value_default = (value - value_min) / range;

                    if (value_default < 0.0 || value_default > 1.0) {

                        double set = 0.0;

                        if (range == 0 || value_default < 0.0) {

                            value_default = 0.0;
                            set = value_min;

                        } else {

                            value_default = 1.0;
                            set = value_max;

                        }

                        CompoundTag extra_data = new CompoundTag();
                        extra_data.putBoolean("is_item", GUIScreen.item.isEmpty() == false);
                        extra_data.putString("nbt_type", nbt_type);
                        extra_data.putString("nbt_name", nbt_name);
                        extra_data.putDouble("nbt_value", set);
                        NetworkManager.runServerCore(screen.player, "gui", "slider", extra_data);

                    }

                }

                slider = new AbstractSliderButton(screen.getGuiLeft() + posX, screen.getGuiTop() + posZ, length, 6, Component.empty(), value_default) {

                    private double value_previous = value_min - 1;

                    @Override
                    protected void updateMessage () {



                    }

                    @Override
                    protected void applyValue () {

                        double value = this.value;
                        value = value * range;
                        value = Math.round(value / value_move) * value_move;
                        this.value = value / range;

                        if (value_previous != value) {

                            value_previous = value;
                            CompoundTag extra_data = new CompoundTag();
                            extra_data.putBoolean("is_item", GUIScreen.item.isEmpty() == false);
                            extra_data.putString("nbt_type", nbt_type);
                            extra_data.putString("nbt_name", nbt_name);
                            extra_data.putDouble("nbt_value", value);
                            NetworkManager.runServerCore(screen.player, "gui", "slider", extra_data);

                        }

                    }

                };

                slider.active = is_active == true && is_lock == false;
                GUIScreen.addWidget(screen, slider);
                map.put(key, slider);

            }

            public static void drawBasic (GUIScreen screen, int posX, int posZ, int length, double value_min, double value_max, double value_move, String nbt_type, String nbt_name) {

                drawBasicLockable(screen, posX, posZ, length, true, false, value_min, value_max, value_move, nbt_type, nbt_name);

            }

            public static void drawBasicLockable (GUIScreen screen, int posX, int posZ, int length, boolean is_active, boolean is_lock, double value_min, double value_max, double value_move, String nbt_type, String nbt_name) {

                posX = AutoLine.getPosX(posX);
                posZ = AutoLine.getPosZ(posZ, "slider", 4, 8);
                AutoLine.addSpace(8);

                draw(screen, posX, posZ, length, is_active, is_lock, value_min, value_max, value_move, nbt_type, nbt_name);

            }

            public static void drawText (GUIScreen screen, int posX, int posZ, int length, double value_min, double value_max, double value_move, String nbt_type, String nbt_name, String text) {

                posX = AutoLine.getPosX(posX);
                posZ = AutoLine.getPosZ(posZ, "slider", 4, 8);
                AutoLine.addSpace(16);

                AutoLine.is_pause = true;
                drawBasicLockable(screen, posX, posZ + 8, length, true, false, value_min, value_max, value_move, nbt_type, nbt_name);

                // Ingredient
                {

                    double value_default = NBT.getNumber(screen, nbt_type, nbt_name);
                    StringBuilder builder = new StringBuilder();
                    builder.append(text).append(" ");

                    // Number Show
                    {

                        builder.append("(");

                        if (value_default % 1 == 0) {

                            builder.append((int) value_default);

                        } else {

                            builder.append(value_default);

                        }

                        if (value_min == 0 || value_min == 1) {

                            builder.append("/");

                            if (value_default % 1 == 0) {

                                builder.append((int) value_max);

                            } else {

                                builder.append(value_max);

                            }

                        }

                        builder.append(")");

                    }

                    AutoLine.is_pause = true;
                    ComponentBasic.drawTextBasic(posX, posZ, normal_font_scale, builder.toString());

                }

                AutoLine.is_pause = false;

            }

        }

        public static class Radio {

            private static void draw (GUIScreen screen, int posX, int posZ, boolean is_active, boolean is_lock, String text, String nbt_type, String nbt_name, String[] nbt_values) {

                // Ingredient
                {

                    ComponentBasic.drawTextBasic(posX, posZ, normal_font_scale, text);

                }

                boolean is_select = false;

                for (String scan : nbt_values) {

                    AutoLine.addSpace(8);
                    posZ = posZ + 8;

                    is_select = NBT.getText(screen, nbt_type, nbt_name).equals(scan) == true;

                    CompoundTag extra_data = new CompoundTag();
                    extra_data.putBoolean("is_item", GUIScreen.item.isEmpty() == false);
                    extra_data.putString("nbt_type", nbt_type);
                    extra_data.putString("nbt_name", nbt_name);
                    extra_data.putString("nbt_value", scan);

                    ButtonTiny.drawBasicRunnableLockable(screen, posX, posZ + 1, 6, 6, is_active, is_lock == true || is_select == true, () -> {

                        NetworkManager.runServerCore(screen.player, "gui", "radio", extra_data);

                    });

                    // Ingredient
                    {

                        if (is_select == false) {

                            scan = "§7" + scan;

                        }

                        ComponentBasic.drawTextCenteredBasic(posX + 10, posZ + 4, true, normal_font_scale, scan);

                    }

                }

            }

            public static void drawBasic (GUIScreen screen, int posX, int posZ, String text, String nbt_type, String nbt_name, String[] nbt_values) {

                drawBasicLockable(screen, posX, posZ, true, false, text, nbt_type, nbt_name, nbt_values);

            }

            public static void drawBasicLockable (GUIScreen screen, int posX, int posZ, boolean is_active, boolean is_lock, String text, String nbt_type, String nbt_name, String[] nbt_values) {

                posX = AutoLine.getPosX(posX);
                posZ = AutoLine.getPosZ(posZ, "radio", 8, 8);

                draw(screen, posX, posZ, is_active, is_lock, text, nbt_type, nbt_name, nbt_values);

            }

        }

        public static class ListBoard {

            public static void draw (GUIScreen screen, int posX, int posZ, int sizeX, int sizeZ, String nbt_type, String nbt_name) {

                posX = AutoLine.getPosX(posX);
                posZ = AutoLine.getPosZ(posZ, "list", 8, 8);

                List<String> list = NBTManager.Mob.ListText.get(screen.player, nbt_type, nbt_name);
                int line_limit = (int) (Math.ceil(sizeZ / 8.0) - 2);

                if (list.isEmpty() == true) {

                    AutoLine.is_pause = true;
                    ComponentBasic.drawTextCenteredBasic(posX + (sizeX / 2), posZ + (sizeZ / 2), false, normal_font_scale, "§fEmpty List");

                } else {

                    // Draw List
                    {

                        int sub_start = 0;
                        int sub_end = 0;

                        // Get Sub Start and End
                        {

                            int page = (int) NBTManager.Mob.getNumber(screen.player, nbt_type, nbt_name + "_page");
                            sub_start = page * line_limit;
                            sub_end = sub_start + line_limit;

                            if (sub_start < 0) {

                                sub_start = 0;

                            } else if (sub_start > list.size()) {

                                sub_start = list.size();

                            }

                            if (sub_end < 0) {

                                sub_end = 0;

                            } else if (sub_end > list.size()) {

                                sub_end = list.size();

                            }

                        }

                        int line_limit_test = line_limit;
                        int posZ_add = 8;

                        for (String scan : list.subList(sub_start, sub_end)) {

                            AutoLine.is_pause = true;
                            ComponentBasic.drawTextBasic(posX + 8, posZ + posZ_add, normal_font_scale, scan);
                            posZ_add = posZ_add + 8;

                            if (line_limit_test > 1) {

                                line_limit_test = line_limit_test - 1;

                            } else {

                                break;

                            }

                        }

                    }

                }

                // Ingredient
                {

                    Shape.draw(screen, posX, posZ, sizeX, sizeZ);





                    int max_page = 0;

                    if (list.size() > 0) {

                        max_page = (int) Math.floor((list.size() - 1) / (double) line_limit);

                    }

                    posZ = posZ + sizeZ + 1;
                    AutoLine.is_pause = true;
                    Slider.drawBasic(screen, posX, posZ, sizeX, 0, max_page, 1, nbt_type, nbt_name + "_page");

                }

                AutoLine.is_pause = false;

            }

        }

    }

}
