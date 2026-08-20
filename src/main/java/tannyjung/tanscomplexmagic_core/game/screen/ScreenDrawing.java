package tannyjung.tanscomplexmagic_core.game.screen;

import com.mojang.blaze3d.platform.NativeImage;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.*;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import tannyjung.tanscomplexmagic_core.Core;
import tannyjung.tanscomplexmagic_core.game.EntityManager;
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

        ScreenDrawing.ComponentBasic.PreCalculate.clear();

        if (GUIScreen.screen != null) {

            String group = NBTManager.Mob.getText(GUIScreen.player_local, "gui", "group");
            String name = NBTManager.Mob.getText(GUIScreen.player_local, "gui", "name");

            if (GUIScreen.id_group.equals(group) == false || GUIScreen.id_name.equals(name) == false) {

                GUIScreen.id_group = group;
                GUIScreen.id_name = name;
                GUIScreen.Widget.removeAll();

                ComponentAdvance.Shape.map.clear();
                ComponentAdvance.ButtonTiny.map.clear();
                ComponentAdvance.ButtonImage.map.clear();
                ComponentAdvance.TextBox.map.clear();
                ComponentAdvance.Slider.map.clear();
                ComponentAdvance.Radio.set.clear();

            }

            GUIManager.Storage.draw(group, name);
            
        }
        
    }

    private static class NBT {

        private static boolean getLogic (String type, String name) {

            if (GUIScreen.item.isEmpty() == true) {
                
                return NBTManager.Mob.getLogic(GUIScreen.player_local, type, name);

            } else {

                return NBTManager.Item.getLogic(GUIScreen.item, type, name);

            }

        }

        private static String getText (String type, String name) {

            if (GUIScreen.item.isEmpty() == true) {

                return NBTManager.Mob.getText(GUIScreen.player_local, type, name);

            } else {

                return NBTManager.Item.getText(GUIScreen.item, type, name);

            }

        }

        private static double getNumber (String type, String name) {

            if (GUIScreen.item.isEmpty() == true) {

                return NBTManager.Mob.getNumber(GUIScreen.player_local, type, name);

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

    public static class Position {

        private static int posX = 0;
        private static int posZ = 0;
        private static int markX = 0;
        private static int markZ = 0;

        public static void set (int posX, int posZ) {

            setX(posX);
            setZ(posZ);

        }

        public static void setX (int posX) {

            Position.posX = posX;

        }

        public static void setZ (int posZ) {

            Position.posZ = posZ;

        }

        public static void add (int sizeX, int sizeZ) {

            addX(sizeX);
            addZ(sizeZ);

        }

        public static void addX (int size) {

            posX = posX + size;

        }

        public static void addZ (int size) {

            posZ = posZ + size;

        }

        public static void setMark () {

            setMarkX();
            setMarkZ();

        }

        public static void setMarkX () {

            markX = posX;

        }

        public static void setMarkZ () {

            markZ = posZ;

        }

        public static void returnMark () {

            returnMarkX();
            returnMarkZ();

        }

        public static void returnMarkX () {

            posX = markX;

        }

        public static void returnMarkZ () {

            posZ = markZ;

        }

    }

    public static class ComponentBasic {

        private static final Map<String, String> online_image_id = new HashMap<>();
        private static final Map<String, String> online_image_status = new HashMap<>();

        private static void drawText (GuiGraphics graphic, double scale, boolean shadow, String text) {

            int posX = Position.posX;
            int posZ = Position.posZ;
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
        
        public static void drawTextBasic (double scale, String text) {

            PreCalculate.addText(scale, false, text);
            Position.addZ((int) Math.round(8 * scale));
            
        }

        public static void drawTextParagraph (int length_per_line, String text) {

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

                PreCalculate.addText(normal_font_scale, false, entry.getValue().toString());
                Position.addZ(8);

            }

        }

        private static void drawTextCentered (boolean is_only_vertical, double scale, boolean shadow, String text) {

            int posX = Position.posX;
            int posZ = Position.posZ;
            int[] pos_convert = Anchor.convertPosCenterText(posX, posZ, scale, text);

            if (is_only_vertical == true) {

                pos_convert[0] = posX;

            }

            Position.set(pos_convert[0], pos_convert[1]);

            PreCalculate.addText(scale, shadow, text);

            Position.addZ((int) Math.round(8 * scale));

        }

        public static void drawTextCenteredBasic (boolean is_only_vertical, double scale, String text) {

            drawTextCentered(is_only_vertical, scale, false, text);

        }

        public static void drawTextCenteredShadow (boolean is_only_vertical, double scale, String text) {

            drawTextCentered(is_only_vertical, scale, true, text);

        }

        private static void drawImage (GuiGraphics graphic, int overall_sizeX, int overall_sizeZ, int slideX, int slideZ, int split_sizeX, int split_sizeZ, String path) {

            int posX = Position.posX;
            int posZ = Position.posZ;
            graphic.blit(ResourceLocation.parse(path), (graphic.guiWidth() / 2) + posX, (graphic.guiHeight() / 2) + posZ, slideX,slideZ, split_sizeX, split_sizeZ, overall_sizeX, overall_sizeZ);

        }

        public static void drawImageBasic (int sizeX, int sizeZ, String path) {

            PreCalculate.addImage(sizeX, sizeZ, 0, 0, sizeX, sizeZ, path);

        }

        public static void drawImageSplit (int overall_sizeX, int overall_sizeZ, boolean is_horizontal, int piece_count, int choose, String path) {

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

            PreCalculate.addImage(overall_sizeX, overall_sizeZ, slideX, slideZ, split_sizeX, split_sizeZ, path);

        }

        public static void drawImageOnline (int sizeX, int sizeZ, String url, String path_loading, String path_fail) {

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

            PreCalculate.addImage(sizeX, sizeZ, 0, 0, sizeX, sizeZ, id);

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

                    Position.set((int) objects[0], (int) objects[1]);
                    drawText(graphic, (double) objects[2], (boolean) objects[3], (String) objects[4]);

                }

            }

            public static void renderImage (GuiGraphics graphic) {

                for (Object[] objects : image) {

                    Position.set((int) objects[0], (int) objects[1]);
                    drawImage(graphic, (int) objects[2], (int) objects[3], (int) objects[4], (int) objects[5], (int) objects[6], (int) objects[7], (String) objects[8]);

                }

            }

            private static void addText (double scale, boolean shadow, String text) {

                int posX = Position.posX;
                int posZ = Position.posZ;
                PreCalculate.text.add(new Object[]{posX, posZ, scale, shadow, text});

            }

            private static void addImage (int overall_sizeX, int overall_sizeZ, int slideX, int slideZ, int split_sizeX, int split_sizeZ, String path) {

                int posX = Position.posX;
                int posZ = Position.posZ;
                image.add(new Object[]{posX, posZ, overall_sizeX, overall_sizeZ, slideX, slideZ, split_sizeX, split_sizeZ, path});

            }

        }

    }

    public static class ComponentAdvance {

        public static class Shape {

            private static final Map<String, Button> map = new HashMap<>();

            private static void draw (int sizeX, int sizeZ) {

                String key = Position.posX + "/" + Position.posZ;
                Button button = map.get(key);

                if (button == null) {

                    button = Button.builder(Component.empty(), create -> {}).build();
                    button.setPosition(GUIScreen.screen.getGuiLeft() + Position.posX, GUIScreen.screen.getGuiTop() + Position.posZ);
                    button.setSize(sizeX, sizeZ);
                    button.active = false;
                    GUIScreen.Widget.add(button);
                    map.put(key, button);

                }

            }

        }

        public static class ButtonTiny {

            private static final Map<String, Button> map = new HashMap<>();

            private static void draw (int sizeX, int sizeZ, boolean is_active, boolean is_lock, Runnable runnable) {

                String key = Position.posX + "/" + Position.posZ;
                Button button = map.get(key);

                if (button == null) {

                    button = Button.builder(Component.empty(), create -> {

                        runnable.run();

                    }).build();

                    button.setPosition(GUIScreen.screen.getGuiLeft() + Position.posX, GUIScreen.screen.getGuiTop() + Position.posZ);
                    button.setSize(sizeX, sizeZ);

                    GUIScreen.Widget.add(button);
                    map.put(key, button);

                }

                button.active = is_active == true && is_lock == false;
                Position.addZ(sizeZ);

            }

            public static void drawBasic (int sizeX, int sizeZ, String network, String work_type, String work) {

                drawBasicLockable(sizeX, sizeZ, true, false, network, work_type, work);

            }

            public static void drawBasicLockable (int sizeX, int sizeZ, boolean is_active, boolean is_lock, String network, String work_type, String work) {

                drawBasicRunnableLockable(sizeX, sizeZ, is_active, is_lock, () -> {

                    if (network.equals("client") == true) {

                        NetworkManager.runClient(GUIScreen.player_local, work_type, work, new CompoundTag());

                    } else if (network.equals("server") == true) {

                        NetworkManager.runServer(GUIScreen.player_local, work_type, work, new CompoundTag());

                    } else if (network.equals("client_core") == true) {

                        NetworkManager.runClientCore(GUIScreen.player_local, work_type, work, new CompoundTag());

                    } else if (network.equals("server_core") == true) {

                        NetworkManager.runServerCore(GUIScreen.player_local, work_type, work, new CompoundTag());

                    }

                });

            }

            public static void drawBasicRunnable (int sizeX, int sizeZ, Runnable runnable) {

                drawBasicRunnableLockable(sizeX, sizeZ, true, false, runnable);

            }

            public static void drawBasicRunnableLockable (int sizeX, int sizeZ, boolean is_active, boolean is_lock, Runnable runnable) {

                draw(sizeX, sizeZ, is_active, is_lock, runnable);

            }

            public static void drawText (int length, String network, String work_type, String work, String text) {

                drawTextLockable(length, true, false, network, work_type, work, "", text);

            }

            public static void drawTextLockable (int length, boolean is_active, boolean is_lock, String network, String work_type, String work, String text_lock, String text_unlock) {

                drawTextRunnableLockable(length, is_active, is_lock, text_lock, text_unlock, () -> {

                    if (network.equals("client") == true) {

                        NetworkManager.runClient(GUIScreen.player_local, work_type, work, new CompoundTag());

                    } else if (network.equals("server") == true) {

                        NetworkManager.runServer(GUIScreen.player_local, work_type, work, new CompoundTag());

                    } else if (network.equals("client_core") == true) {

                        NetworkManager.runClientCore(GUIScreen.player_local, work_type, work, new CompoundTag());

                    } else if (network.equals("server_core") == true) {

                        NetworkManager.runServerCore(GUIScreen.player_local, work_type, work, new CompoundTag());

                    }

                });

            }

            public static void drawTextRunnable (int length, String text, Runnable runnable) {

                drawTextRunnableLockable(length, true, false, "", text, runnable);

            }

            public static void drawTextRunnableLockable (int length, boolean is_active, boolean is_lock, String text_lock, String text_unlock, Runnable runnable) {

                drawBasicRunnableLockable(length, 11, is_active, is_lock, runnable);

                // Ingredient
                {

                    String text = "";

                    if (is_active == true && is_lock == false) {

                        text = "§f" + text_unlock;

                    } else {

                        text = "§c" + text_lock;

                    }

                    int posX = Position.posX;
                    int posZ = Position.posZ;
                    Position.add(length / 2, -5);
                    ComponentBasic.drawTextCenteredShadow(false, normal_font_scale, text);
                    Position.set(posX, posZ);

                }

            }

        }

        public static class ButtonImage {

            private static final Map<String, ImageButton> map = new HashMap<>();

            public static void draw (int sizeX, int sizeZ, boolean is_horizontal, boolean is_active, boolean is_lock, String network, String work_type, String work, String path) {

                if (is_horizontal == true) {

                    sizeX = sizeX / 2;

                } else {

                    sizeZ = sizeZ / 2;

                }

                String key = Position.posX + "/" + Position.posZ;
                ImageButton button = map.get(key);

                if (button == null) {

                    ResourceLocation location = ResourceLocation.parse(path);

                    button = new ImageButton(GUIScreen.screen.getGuiLeft() + Position.posX, GUIScreen.screen.getGuiTop() + Position.posZ, sizeX, sizeZ, new WidgetSprites(location, location), create -> {

                        create.setFocused(false);

                        if (network.equals("client") == true) {

                            NetworkManager.runClient(GUIScreen.player_local, work_type, work, new CompoundTag());

                        } else if (network.equals("server") == true) {

                            NetworkManager.runServer(GUIScreen.player_local, work_type, work, new CompoundTag());

                        } else if (network.equals("client_core") == true) {

                            NetworkManager.runClientCore(GUIScreen.player_local, work_type, work, new CompoundTag());

                        } else if (network.equals("server_core") == true) {

                            NetworkManager.runServerCore(GUIScreen.player_local, work_type, work, new CompoundTag());

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
                    GUIScreen.Widget.add(button);
                    map.put(key, button);

                }

                Position.addZ(sizeZ);

            }

        }

        public static class Switch {

            private static void draw (boolean is_active, boolean is_lock, String nbt_type, String nbt_name) {

                CompoundTag extra = new CompoundTag();
                extra.putBoolean("is_item", GUIScreen.item.isEmpty() == false);
                extra.putString("nbt_type", nbt_type);
                extra.putString("nbt_name", nbt_name);
                Runnable runnable = () -> NetworkManager.runServerCore(GUIScreen.player_local, "gui", "switch", extra);

                boolean value = NBT.getLogic(nbt_type, nbt_name);

                ButtonTiny.drawBasicRunnableLockable(6, 6, is_active && value == false, is_lock, runnable);
                Position.addZ(-6);
                Position.addX(6);
                ButtonTiny.drawBasicRunnableLockable(6, 6, is_active && value == true, is_lock, runnable);
                Position.addX(-6);

            }

            public static void drawBasic (String nbt_type, String nbt_name) {

                drawBasicLockable(true, false, nbt_type, nbt_name);

            }

            public static void drawBasicLockable (boolean is_active, boolean is_lock, String nbt_type, String nbt_name) {

                drawTextLockable(is_active, is_lock, nbt_type, nbt_name, "");

            }

            public static void drawText (String nbt_type, String nbt_name, String text) {

                drawTextLockable(true, false, nbt_type, nbt_name, text);

            }

            public static void drawTextLockable (boolean is_active, boolean is_lock, String nbt_type, String nbt_name, String text) {

                draw(is_active, is_lock, nbt_type, nbt_name);

                // Ingredient
                {

                    if (text.isEmpty() == false) {

                        int posX = Position.posX;
                        int posZ = Position.posZ;
                        Position.add(16, -2);
                        ComponentBasic.drawTextCenteredBasic(true, normal_font_scale, text);
                        Position.set(posX, posZ);

                    }

                }

            }

        }

        public static class TextBox {

            private static final Map<String, EditBox> map = new HashMap<>();

            private static void draw (int length, boolean is_active, boolean is_lock, String nbt_type, String nbt_name, String text_lock) {

                int posX = Position.posX;
                int posZ = Position.posZ;
                String key = posX + "/" + posZ;
                EditBox box = map.get(key);

                if (box == null) {

                    EditBox box_new = new EditBox(Minecraft.getInstance().font, GUIScreen.screen.getGuiLeft() + posX, GUIScreen.screen.getGuiTop() + posZ, length, 14, Component.empty());
                    box_new.setMaxLength(10000);
                    box_new.setTextShadow(false);

                    box_new.setResponder(value -> {

                        if (box_new.isFocused() == false) {

                            return;

                        }

                        CompoundTag extra = new CompoundTag();
                        extra.putBoolean("is_item", GUIScreen.item.isEmpty() == false);
                        extra.putString("nbt_type", nbt_type);
                        extra.putString("nbt_name", nbt_name);
                        extra.putString("nbt_value", value);
                        NetworkManager.runServerCore(GUIScreen.player_local, "gui", "text_box", extra);

                    });

                    box = box_new;
                    GUIScreen.Widget.add(box_new);
                    map.put(key, box_new);

                }

                if (is_active == false || is_lock == true) {

                    box.active = false;
                    box.setEditable(false);

                } else {

                    if (box.isFocused() == false) {

                        box.setValue(NBT.getText(nbt_type, nbt_name));

                    }

                }

                // Ingredient
                {

                    if (is_lock == true) {

                        Position.add(9 + (box.getWidth() / 2), 15);
                        ComponentBasic.drawTextCenteredBasic(false, normal_font_scale, text_lock);

                    }

                }

                Position.set(posX, posZ + 14);

            }

            public static void drawBasic (int length, String nbt_type, String nbt_name) {

                drawBasicLockable(length, true, false, nbt_type, nbt_name, "");

            }

            public static void drawBasicLockable (int length, boolean is_active, boolean is_lock, String nbt_type, String nbt_name, String text_lock) {

                draw(length, is_active, is_lock, nbt_type, nbt_name, text_lock);

            }

            public static void drawText (int length, String nbt_type, String nbt_name, String text) {

                drawTextLockable(length, true, false, nbt_type, nbt_name, text, "");

            }

            public static void drawTextLockable (int length, boolean is_active, boolean is_lock, String nbt_type, String nbt_name, String text, String text_lock) {

                // Ingredient
                {

                    ComponentBasic.drawTextBasic(normal_font_scale, text);

                }

                Position.addZ(4);
                drawBasicLockable(length, is_active, is_lock, nbt_type, nbt_name, text_lock);

            }

        }

        public static class Slider {

            private static final Map<String, AbstractSliderButton> map = new HashMap<>();

            private static void draw (int length, boolean is_active, boolean is_lock, double value_min, double value_max, double value_move, String nbt_type, String nbt_name) {

                String key = Position.posX + "/" + Position.posZ;
                AbstractSliderButton slider = map.get(key);

                if (slider != null) {

                    map.remove(key);
                    GUIScreen.Widget.removeSpecific(slider);

                }

                double range = value_max - value_min;
                double value_default = 0.0;

                // Get Default Value
                {

                    double value = NBT.getNumber(nbt_type, nbt_name);
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

                        CompoundTag extra = new CompoundTag();
                        extra.putBoolean("is_item", GUIScreen.item.isEmpty() == false);
                        extra.putString("nbt_type", nbt_type);
                        extra.putString("nbt_name", nbt_name);
                        extra.putDouble("nbt_value", set);
                        NetworkManager.runServerCore(GUIScreen.player_local, "gui", "slider", extra);

                    }

                }

                slider = new AbstractSliderButton(GUIScreen.screen.getGuiLeft() + Position.posX, GUIScreen.screen.getGuiTop() + Position.posZ, length, 6, Component.empty(), value_default) {

                    private double value_previous = value_min - 1;

                    @Override
                    protected void updateMessage () {



                    }

                    @Override
                    protected void applyValue () {

                        double value = this.value;

                        // Calculation
                        {

                            value = value * range;

                            if (value > value_min) {

                                value = value + value_min;

                            }

                            value = Math.round(value / value_move) * value_move;

                            if (value < value_min) {

                                value = value_min;

                            }

                        }

                        if (value_previous != value) {

                            value_previous = value;
                            CompoundTag extra = new CompoundTag();
                            extra.putBoolean("is_item", GUIScreen.item.isEmpty() == false);
                            extra.putString("nbt_type", nbt_type);
                            extra.putString("nbt_name", nbt_name);
                            extra.putDouble("nbt_value", value);
                            NetworkManager.runServerCore(GUIScreen.player_local, "gui", "slider", extra);

                        }

                    }

                };

                slider.active = is_active == true && is_lock == false;

                GUIScreen.Widget.add(slider);
                map.put(key, slider);

                Position.addZ(6);

            }

            public static void drawBasic (int length, double value_min, double value_max, double value_move, String nbt_type, String nbt_name) {

                drawBasicLockable(length, true, false, value_min, value_max, value_move, nbt_type, nbt_name);

            }

            public static void drawBasicLockable (int length, boolean is_active, boolean is_lock, double value_min, double value_max, double value_move, String nbt_type, String nbt_name) {

                draw(length, is_active, is_lock, value_min, value_max, value_move, nbt_type, nbt_name);

            }

            public static void drawText (int length, double value_min, double value_max, double value_move, String nbt_type, String nbt_name, String text) {

                // Ingredient
                {

                    double value_default = NBT.getNumber(nbt_type, nbt_name);
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

                    ComponentBasic.drawTextBasic(normal_font_scale, builder.toString());

                }

                Position.addZ(4);
                drawBasicLockable(length, true, false, value_min, value_max, value_move, nbt_type, nbt_name);

            }

        }

        public static class Radio {

            private static final Set<String> set = new HashSet<>();

            private static void draw (boolean is_active, boolean is_lock, String text, String nbt_type, String nbt_name, String[] nbt_values) {

                String key = Position.posX + "/" + Position.posZ;

                if (set.contains(key) == false) {

                    set.add(key);

                    // Start Auto Sync
                    {

                        if (NBT.getText(nbt_type, nbt_name).isEmpty() == true) {

                            CompoundTag extra = new CompoundTag();
                            extra.putBoolean("is_item", GUIScreen.item.isEmpty() == false);
                            extra.putString("nbt_type", nbt_type);
                            extra.putString("nbt_name", nbt_name);
                            extra.putString("nbt_value", nbt_values[0]);
                            NetworkManager.runServerCore(GUIScreen.player_local, "gui", "radio", extra);

                        }

                    }

                }

                // Ingredient
                {

                    ComponentBasic.drawTextBasic(normal_font_scale, text);

                }

                Position.addZ(2);
                int posX = 0;
                int posZ = 0;
                boolean is_select = false;

                for (String scan : nbt_values) {

                    Position.addZ(2);
                    is_select = NBT.getText(nbt_type, nbt_name).equals(scan) == true;

                    CompoundTag extra = new CompoundTag();
                    extra.putBoolean("is_item", GUIScreen.item.isEmpty() == false);
                    extra.putString("nbt_type", nbt_type);
                    extra.putString("nbt_name", nbt_name);
                    extra.putString("nbt_value", scan);

                    ButtonTiny.drawBasicRunnableLockable(6, 6, is_active, is_lock == true || is_select == true, () -> {

                        NetworkManager.runServerCore(GUIScreen.player_local, "gui", "radio", extra);

                    });

                    // Ingredient
                    {

                        if (is_select == true) {

                            scan = "§8" + scan;

                        } else {

                            scan = "§7" + scan;

                        }

                        posX = Position.posX;
                        posZ = Position.posZ;
                        Position.add(10, -2);
                        ComponentBasic.drawTextCenteredBasic(true, normal_font_scale, scan);

                    }

                    Position.set(posX, posZ);

                }

            }

            public static void drawBasic (String text, String nbt_type, String nbt_name, String[] nbt_values) {

                drawBasicLockable(true, false, text, nbt_type, nbt_name, nbt_values);

            }

            public static void drawBasicLockable (boolean is_active, boolean is_lock, String text, String nbt_type, String nbt_name, String[] nbt_values) {

                draw(is_active, is_lock, text, nbt_type, nbt_name, nbt_values);

            }

        }

        public static class Board {

            private static void draw (int sizeX, int sizeZ, String nbt_type, String nbt_name) {

                int posX = Position.posX;
                int posZ = Position.posZ;

                List<String> list = NBTManager.Mob.getListAsList(GUIScreen.player_local, nbt_type, nbt_name);
                int line_limit = (int) (Math.round(sizeZ / 8.0) - 2);
                int count = 0;

                if (list.isEmpty() == true) {

                    Position.add(sizeX / 2, sizeZ / 2);
                    ComponentBasic.drawTextCenteredBasic(false, normal_font_scale, "§fEmpty List");

                } else {

                    Position.add(8, 5);

                    // List
                    {

                        int sub_start = 0;
                        int sub_end = 0;

                        // Get Sub Start and End
                        {

                            int page = (int) NBTManager.Mob.getNumber(GUIScreen.player_local, nbt_type, nbt_name + "_page");
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

                        int select = (int) NBTManager.Mob.getNumber(GUIScreen.player_local, nbt_type, nbt_name + "_select");
                        int number = 1;

                        for (String scan : list.subList(sub_start, sub_end)) {

                            count = count + 1;

                            if (number == select) {

                                scan = scan + "     §e<-";

                            }

                            Position.addZ(3);
                            ComponentBasic.drawTextBasic(normal_font_scale, scan);

                            if (number < line_limit) {

                                number = number + 1;

                            } else {

                                break;

                            }

                        }

                    }

                }

                Position.set(posX, posZ);

                int max_page = 0;

                if (list.isEmpty() == false) {

                    max_page = (int) Math.floor((list.size() - 1) / (double) line_limit);

                }

                // Ingredient
                {

                    Shape.draw(sizeX, sizeZ);
                    Position.addZ(sizeZ + 2);
                    Slider.drawBasic(160, 0, max_page, 1, nbt_type, nbt_name + "_page");
                    Position.addZ(2);
                    Slider.drawBasic(160, 0, count, 1, nbt_type, nbt_name + "_select");

                }

            }

            public static class ListEntity {

                public static void draw (String title, String tag, String description) {

                    int posX = Position.posX;
                    int posZ = Position.posZ;
                    Position.addX(192);
                    Board.draw(160, 150, "gui", "board_entity_" + tag + "_show");

                    // Ingredient
                    {

                        CompoundTag extra = new CompoundTag();
                        extra.putString("nbt_tag", tag);

                        int temporary_number = 0;

                        Position.addZ(6);
                        temporary_number = Position.posZ;
                        ButtonTiny.drawTextRunnable(40, "Refresh", () -> NetworkManager.runServerCore(GUIScreen.player_local, "gui", "board_entity_refresh", extra));
                        Position.addX(120);
                        Position.setZ(temporary_number);
                        ButtonTiny.drawTextRunnable(40, "Clear", () -> NetworkManager.runServerCore(GUIScreen.player_local, "gui", "board_entity_clear", extra));

                        Position.set(posX, posZ);

                        ComponentBasic.drawTextBasic(1.25, title);
                        Position.addZ(8);
                        ComponentBasic.drawTextParagraph(160, description);

                        Position.setZ(posZ + 80);
                        TextBox.drawText(160, "gui", "board_entity_" + tag + "_id", "Entity ID and Name");
                        Position.addZ(2);
                        TextBox.drawBasic(160, "gui", "board_entity_" + tag + "_name");
                        Position.addZ(8);
                        Slider.drawText(160, 5, 200, 10, "gui", "board_entity_" + tag + "_radius", "Area Radius");

                        Position.addZ(8);
                        posZ = Position.posZ;
                        Radio.drawBasic("Removal Mode", "gui", "board_entity_" + tag + "_remove_mode", new String[]{"Area", "Overall", "Selection"});
                        Position.setZ(posZ);
                        Position.add(80, 22);
                        posZ = Position.posZ;
                        ButtonTiny.drawTextRunnable(39, "Remove", () -> NetworkManager.runServerCore(GUIScreen.player_local, "gui", "board_entity_remove", extra));
                        Position.setZ(posZ);
                        Position.addX(41);
                        ButtonTiny.drawTextRunnable(39, "Add", () -> NetworkManager.runServerCore(GUIScreen.player_local, "gui", "board_entity_add", extra));

                    }

                }

                public static void runRefresh (ServerLevel level_server, ServerPlayer player_server, String tag) {

                    for (Entity scan : EntityManager.Population.getEverywhereUpdatable(level_server, "", "", new String[]{tag})) {

                        scan.removeTag(tag);

                    }

                    List<String> list_id = NBTManager.Mob.getListAsList(player_server, "gui", "board_entity_" + tag + "_list_id");
                    List<String> list_name = NBTManager.Mob.getListAsList(player_server, "gui", "board_entity_" + tag + "_list_name");
                    List<String> list = new ArrayList<>();
                    Entity entity = null;
                    String entity_name = "";
                    String entity_name_color = "";
                    String entity_status = "";
                    int number = 0;

                    for (String scan : NBTManager.Mob.getListAsList(player_server, "gui", "board_entity_" + tag + "_list_uuid")) {

                        entity = EntityManager.getByUUID(level_server, scan);
                        entity_name = list_name.get(number);

                        if (list_id.get(number).equals("minecraft:player") == true) {

                            if (entity == null) {

                                entity_name_color = "§6";
                                entity_status = " (Offline)";

                            } else {

                                entity_name_color = "§a";
                                entity_status = " (Online)";
                                entity.addTag(tag);

                            }

                        } else {

                            if (entity == null) {

                                entity_name_color = "§c";
                                entity_status = " (Not Detected)";

                            } else {

                                if (entity.hasCustomName() == true) {

                                    entity_name_color = "§d";
                                    entity_status = "";

                                } else {

                                    entity_name_color = "§f";
                                    entity_status = " §8(" + (number + 1) + ")";

                                }

                                entity.addTag(tag);

                            }

                        }

                        list.add(entity_name_color + entity_name + entity_status);
                        number = number + 1;

                    }

                    NBTManager.Mob.setListAlternate(player_server, "gui", "board_entity_" + tag + "_show", list, true);

                }

                public static void runAdd (ServerPlayer player_server, String tag) {

                    String target_id = NBTManager.Mob.getText(player_server, "gui", "board_entity_" + tag + "_id");
                    String target_name = NBTManager.Mob.getText(player_server, "gui", "board_entity_" + tag + "_name");
                    int radius = (int) NBTManager.Mob.getNumber(player_server, "gui", "board_entity_" + tag + "_radius");

                    List<String> list_uuid_original = NBTManager.Mob.getListAsList(player_server, "gui", "board_entity_" + tag + "_list_uuid");
                    List<String> list_uuid = new ArrayList<>();
                    List<String> list_id = new ArrayList<>();
                    List<String> list_name = new ArrayList<>();
                    String uuid = "";

                    for (Entity entity : EntityManager.Population.sort(EntityManager.Population.getArea(player_server.serverLevel(), player_server.position(), radius, false, target_id, target_name, new String[]{"!" + Core.mod_id_big}), player_server.position(), false, 0)) {

                        uuid = entity.getStringUUID();

                        if (list_uuid_original.contains(uuid) == true) {

                            continue;

                        }

                        list_uuid.add(uuid);
                        list_id.add(EntityManager.getID(entity));
                        list_name.add(entity.getDisplayName().getString());

                    }

                    NBTManager.Mob.addListMultiple(player_server, "gui", "board_entity_" + tag + "_list_uuid", list_uuid, true);
                    NBTManager.Mob.addListMultiple(player_server, "gui", "board_entity_" + tag + "_list_id", list_id, true);
                    NBTManager.Mob.addListMultiple(player_server, "gui", "board_entity_" + tag + "_list_name", list_name, true);

                }

                public static void runClear (ServerPlayer player_server, String tag) {

                    NBTManager.Mob.setListAlternate(player_server, "gui", "board_entity_" + tag + "_list_uuid", new ArrayList<>(), true);
                    NBTManager.Mob.setListAlternate(player_server, "gui", "board_entity_" + tag + "_list_id", new ArrayList<>(), true);
                    NBTManager.Mob.setListAlternate(player_server, "gui", "board_entity_" + tag + "_list_name", new ArrayList<>(), true);
                    NBTManager.Mob.setListAlternate(player_server, "gui", "board_entity_" + tag + "_list_name_custom", new ArrayList<>(), true);

                }

                public static void runRemove (ServerLevel level_server, ServerPlayer player_server, String tag) {

                    String mode = NBTManager.Mob.getText(player_server, "gui", "board_entity_" + tag + "_remove_mode");

                    if (mode.equals("Area") == true) {

                        runRemoveModeScan(level_server, player_server, tag, false);

                    } else if (mode.equals("Overall") == true) {

                        runRemoveModeScan(level_server, player_server, tag, true);

                    } else if (mode.equals("Selection") == true) {

                        runRemoveModeSelected(player_server, tag);

                    }

                }

                private static void runRemoveModeScan (ServerLevel level_server, ServerPlayer player_server, String tag, boolean is_mode_overall) {

                    String target_id = NBTManager.Mob.getText(player_server, "gui", "board_entity_" + tag + "_id");
                    String target_name = NBTManager.Mob.getText(player_server, "gui", "board_entity_" + tag + "_name");
                    int radius = (int) NBTManager.Mob.getNumber(player_server, "gui", "board_entity_" + tag + "_radius");

                    List<String> list_original_id = NBTManager.Mob.getListAsList(player_server, "gui", "board_entity_" + tag + "_list_id");
                    List<String> list_original_name = NBTManager.Mob.getListAsList(player_server, "gui", "board_entity_" + tag + "_list_name");
                    List<String> list_uuid = new ArrayList<>();
                    List<String> list_id = new ArrayList<>();
                    List<String> list_name = new ArrayList<>();

                    int number = -1;
                    String scan_id = "";
                    String scan_name = "";
                    Entity entity = null;

                    for (String scan : NBTManager.Mob.getListAsList(player_server, "gui", "board_entity_" + tag + "_list_uuid")) {

                        number = number + 1;
                        scan_id = list_original_id.get(number);
                        scan_name = list_original_name.get(number);

                        if (is_mode_overall == true) {

                            {

                                if (target_id.isEmpty() == true || scan_id.equals(target_id) == true) {

                                    if (target_name.isEmpty() == true || scan_name.equals(target_name) == true) {

                                        continue;

                                    }

                                }

                            }

                        } else {

                            {

                                entity = EntityManager.getByUUID(level_server, scan);

                                if (entity != null) {

                                    if (player_server.position().distanceTo(entity.position()) <= radius) {

                                        if (EntityManager.getID(entity).equals(target_id) == true || entity.getDisplayName().getString().equals(target_name) == true) {

                                            continue;

                                        }

                                    }

                                }

                            }

                        }

                        list_uuid.add(scan);
                        list_id.add(scan_id);
                        list_name.add(scan_name);

                    }

                    NBTManager.Mob.addListMultiple(player_server, "gui", "board_entity_" + tag + "_list_uuid", list_uuid, true);
                    NBTManager.Mob.addListMultiple(player_server, "gui", "board_entity_" + tag + "_list_id", list_id, true);
                    NBTManager.Mob.addListMultiple(player_server, "gui", "board_entity_" + tag + "_list_name", list_name, true);

                }

                private static void runRemoveModeSelected (ServerPlayer player_server, String tag) {

                    int page = (int) NBTManager.Mob.getNumber(player_server, "gui", "board_entity_" + tag + "_show_page");
                    int select = (int) NBTManager.Mob.getNumber(player_server, "gui", "board_entity_" + tag + "_show_select");

                    if (select == 0) {

                        return;

                    }

                    int number = (page * 17) + select;
                    number = number - 1;

                    List<String> list_uuid = NBTManager.Mob.getListAsList(player_server, "gui", "board_entity_" + tag + "_list_uuid");
                    List<String> list_id = NBTManager.Mob.getListAsList(player_server, "gui", "board_entity_" + tag + "_list_id");
                    List<String> list_name = NBTManager.Mob.getListAsList(player_server, "gui", "board_entity_" + tag + "_list_name");
                    list_uuid.remove(number);
                    list_id.remove(number);
                    list_name.remove(number);
                    NBTManager.Mob.addListMultiple(player_server, "gui", "board_entity_" + tag + "_list_uuid", list_uuid, true);
                    NBTManager.Mob.addListMultiple(player_server, "gui", "board_entity_" + tag + "_list_id", list_id, true);
                    NBTManager.Mob.addListMultiple(player_server, "gui", "board_entity_" + tag + "_list_name", list_name, true);

                }

            }
            
        }

    }

}
