package tannyjung.tanscomplexmagic_handcode.core;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.phys.Vec3;
import tannyjung.tanscomplexmagic_core.game.screen.GUIScreen;
import tannyjung.tanscomplexmagic_core.game.NBTManager;
import tannyjung.tanscomplexmagic_core.game.screen.ScreenDrawing;
import tannyjung.tanscomplexmagic_core.outside.OutsideUtils;

public class GUIs {

    public static void render (GUIScreen screen, GuiGraphics graphic, int id, String type) {

        // Background
        {

            if (type.equals("text") == true) {

                // Page Number
                {

                    StringBuilder page_left = new StringBuilder().append(id + 1);
                    StringBuilder page_right = new StringBuilder().append(id + 2);

                    while (page_left.length() < 3) {

                        page_left.insert(0, "0");

                    }

                    while (page_right.length() < 3) {

                        page_right.insert(0, "0");

                    }

                    ScreenDrawing.ComponentBasic.drawText(graphic, 8 * -21, 8 * 12, ScreenDrawing.normal_font_scale, false, page_left.toString());
                    ScreenDrawing.ComponentBasic.drawText(graphic, 8 * 19 + 5, 8 * 12, ScreenDrawing.normal_font_scale, false, page_right.toString());

                }

                ScreenDrawing.ComponentBasic.drawText(graphic, 8 * -22 + 0, 8 * 13 + 7, 0.54, false, NBTManager.Mob.getText(screen.player, "book", "log_text"));

            } else if (type.equals("image") == true) {

                ScreenDrawing.ComponentBasic.drawImageBasic(graphic, 8 * -25 + 0, 8 * -15 + 0, 400, 240, "tanscomplexmagic:textures/screens/gui_component_background.png");
                ScreenDrawing.ComponentBasic.drawImageSplit(graphic, 8 * 1 + 0, 8 * 13 + 6, 168, 7, true, 24, (int) ((screen.player.clientLevel.dayTime() % 24000) / 1000), "tanscomplexmagic:textures/screens/gui_component_clock.png");

                // Compass
                {

                    Vec3 destination_pos = new Vec3(0, 0, 0);
                    int degree = 0;

                    destination_pos = screen.player.clientLevel.getSharedSpawnPos().getCenter();
                    degree = (int) OutsideUtils.Calculation.getDegreeDestinationX(screen.player.getYRot(), screen.player.getX(), screen.player.getZ(), destination_pos.x, destination_pos.z);
                    degree = (int) Math.round(degree / 45.0);
                    ScreenDrawing.ComponentBasic.drawImageSplit(graphic, 8 * 2 - 0, 8 * 13 + 6, 56, 7, true, 8, degree, "tanscomplexmagic:textures/screens/gui_component_compass.png");

                    destination_pos = new Vec3(NBTManager.Mob.getNumber(screen.player, "book", "compassX"), 0, NBTManager.Mob.getNumber(screen.player, "book", "compassZ"));
                    degree = (int) OutsideUtils.Calculation.getDegreeDestinationX(screen.player.getYRot(), screen.player.getX(), screen.player.getZ(), destination_pos.x, destination_pos.z);
                    degree = (int) Math.round(degree / 45.0);
                    ScreenDrawing.ComponentBasic.drawImageSplit(graphic, 8 * 3 - 0, 8 * 13 + 6, 56, 7, true, 8, degree, "tanscomplexmagic:textures/screens/gui_component_compass_custom.png");

                }

                ScreenDrawing.ComponentBasic.drawImageSplit(graphic, 8 * 24 + 3, 8 * 5 + 6, 61, 60, true, 61, (int) NBTManager.Mob.getNumber(screen.player, "status", "mana_charge"), "tanscomplexmagic:textures/screens/gui_component_mana_bar_charge.png");
                ScreenDrawing.ComponentBasic.drawImageSplit(graphic, 8 * 24 + 3, 8 * -14 + 4, 151, 150, true, 151, (int) NBTManager.Mob.getNumber(screen.player, "status", "mana"), "tanscomplexmagic:textures/screens/gui_component_mana_bar.png");

                // Log
                {

                    int log = 0;

                    if (NBTManager.Mob.getText(screen.player, "book", "log").equals("mana") == true) {

                        log = 1;

                    } else if (NBTManager.Mob.getText(screen.player, "book", "log").equals("action") == true) {

                        log = 2;

                    } else if (NBTManager.Mob.getText(screen.player, "book", "log").equals("warning") == true) {

                        log = 3;

                    }

                    ScreenDrawing.ComponentBasic.drawImageSplit(graphic, 8 * -23 - 4, 8 * 13 + 6, 28, 7, true, 4, log, "tanscomplexmagic:textures/screens/gui_component_log_type.png");

                }

            } else if (type.equals("widget") == true) {

                ScreenDrawing.ComponentAdvance.drawImageButton(screen, 8 * -23 - 4, 8 * 11 + 4, 32, 16, true, true, false, "server", "book", "page_previous", "tanscomplexmagic:textures/screens/gui_component_page_previous.png");
                ScreenDrawing.ComponentAdvance.drawImageButton(screen, 8 * 22 - 4, 8 * 11 + 4, 32, 16, true, true, false, "server", "book", "page_next", "tanscomplexmagic:textures/screens/gui_component_page_next.png");
                ScreenDrawing.ComponentAdvance.drawImageButton(screen, 8 * 25 + 0, 8 * 15 + 0, 16, 8, true, true, false, "server", "book", "close", "tanscomplexmagic:textures/screens/gui_component_close.png");

                ScreenDrawing.ComponentAdvance.drawImageButton(screen, 8 * -27 + 0, 8 * -12 + 0 , 24, 16, false, true, false, "server", "book", "", "tanscomplexmagic:textures/screens/icon_home.png");
                ScreenDrawing.ComponentAdvance.drawImageButton(screen, 8 * -27 + 0, 8 * -11 + 4, 24, 16, false, true, false, "server", "book", "", "tanscomplexmagic:textures/screens/gui_component_shortcut_ally_list.png");
                ScreenDrawing.ComponentAdvance.drawImageButton(screen, 8 * -27 + 0, 8 * -10 + 8, 24, 16, false, true, false, "server", "book", "", "tanscomplexmagic:textures/screens/gui_component_shortcut_basic_spells.png");
                ScreenDrawing.ComponentAdvance.drawImageButton(screen, 8 * -27 + 0, 8 * -9 + 12, 24, 16, false, true, false, "server", "book", "", "tanscomplexmagic:textures/screens/gui_component_shortcut_spell_control.png");
                ScreenDrawing.ComponentAdvance.drawImageButton(screen, 8 * -27 + 0, 8 * -8 + 16, 24, 16, false, true, false, "server", "book", "", "tanscomplexmagic:textures/screens/gui_component_shortcut_custom.png");

                ScreenDrawing.ComponentAdvance.drawImageButton(screen, 8 * -23 - 4, 8 * 13 + 6, 14, 7, true, true, false, "server", "book", "log", "tanscomplexmagic:textures/screens/gui_component_log_type_set.png");
                ScreenDrawing.ComponentAdvance.drawImageButton(screen, 8 * 4 + 0, 8 * 13 + 8, 6, 3, true, true, false, "server", "book", "compass", "tanscomplexmagic:textures/screens/gui_component_compass_custom_set.png");

            }

        }

        pages:
        {

            int page = 0;

            // Main
            {

                if (page == id) {

                    boolean is_active = NBTManager.Mob.getLogic(screen.player, "test", "active") == true;
                    boolean is_lock = NBTManager.Mob.getLogic(screen.player, "test", "lock") == true;

                    if (type.equals("text") == true) {

                        ScreenDrawing.AutoLine.start(8 * -12);
                        ScreenDrawing.ComponentBasic.drawTextParagraph(graphic, 8 * 2, 0, 160, "§" + (int) NBTManager.Mob.getNumber(screen.player, "test", "color") + "   I have changed, I have changed. Just like you, just like you. For how long? For how long must I wait? I know there's something wrong. Your concrete heart isn't beating. And I've tried to make it come alive. No shadows, just red lights. Now I'm here to rescue you.");
                        ScreenDrawing.ComponentBasic.drawTextParagraph(graphic, 8 * 2, 0, 160, "§" + (int) NBTManager.Mob.getNumber(screen.player, "test", "color") + "   So silent, no violence. But inside my head, so loud and clear. You're screamin', you're screamin'. Covered up with a smile I've learned to fear. Just sunshine and blue skies. Is this all we get (Is this all we get?) for living here?. Come fire, come fire!. Let it burn and love come racing through.");
                        ScreenDrawing.ComponentBasic.drawTextParagraph(graphic, 8 * 2, 0, 160, "§" + (int) NBTManager.Mob.getNumber(screen.player, "test", "color") + "   I've learned to lose, I've learned to win. I turned my face against the wind. I will move fast, I will move slow. Take me where I have to go.");
                        ScreenDrawing.ComponentBasic.drawTextParagraph(graphic, 8 * 2, 0, 160, "§" + (int) NBTManager.Mob.getNumber(screen.player, "test", "color") + "   I'm still alive, I'm still alive. I cannot apologize, no. I'm still alive, I'm still alive. I cannot apologize, no.");
                        ScreenDrawing.AutoLine.stop();

                    } else if (type.equals("widget") == true) {

                        ScreenDrawing.AutoLine.start(8 * -12);
                        ScreenDrawing.ComponentAdvance.drawButtonBasic(screen, 8 * -22, 0, 160, "§fBasic Button", "server_core", "gui", "button");
                        ScreenDrawing.ComponentAdvance.drawButtonLockable(screen, 8 * -22, 0, 160, is_active, is_lock, "§cLockable Button", "§fLockable Button", "server_core", "gui", "button");
                        ScreenDrawing.ComponentAdvance.drawTextBoxLockable(screen, 8 * -22, 0, is_active, false, "§cTurn off lock to use this text box", "Text Box", "test", "box");
                        ScreenDrawing.ComponentAdvance.drawSlider(screen, 8 * -22, 0, 1, 10, 1, is_active, false, "test", "boundary", "Attacking Radius");
                        ScreenDrawing.ComponentAdvance.drawSlider(screen, 8 * -22, 0, 10, 200, 10, is_active, false, "test", "volume", "Spell Distance");
                        ScreenDrawing.ComponentAdvance.drawRadio(screen, 8 * -22, 0, is_active, false, "Radio Option Style", "server_core", "radio", "Fire / Water / Earth / Nature / Wind / Light");
                        ScreenDrawing.ComponentAdvance.drawSwitch(screen, 8 * -22, 0, true, false, "test", "active", "Active");
                        ScreenDrawing.ComponentAdvance.drawSwitch(screen, 8 * -22, 0, true, false, "test", "lock", "Lock");
                        ScreenDrawing.AutoLine.stop();

                    }

                    break pages;

                } else {

                    page = page + 2;

                }

            }

            // Spell 1
            {

                // Test
                {

                    if (page == id) {

                        if (type.equals("image") == true) {

                            ScreenDrawing.ComponentBasic.drawImageBasic(graphic, 8 * 2 + 0, 8 * -12 + 0, 40, 72, "tanscomplexmagic:textures/screens/background.png");
                            ScreenDrawing.ComponentBasic.drawImageBasic(graphic, 8 * 2 + 4, 8 * -12 + 4, 64, 64, "tanscomplexmagic:textures/block/zodiac_card" + (int) (Math.floor(Math.random() * 13) + 1) + ".png");

                        } else if (type.equals("widget") == true) {

                            ScreenDrawing.AutoLine.start(8 * -12);
                            ScreenDrawing.ComponentAdvance.drawSlider(screen, 8 * -22 + 0, 0, 1, 200, 1, true, false, "spell1", "radius", "Radius");
                            ScreenDrawing.ComponentAdvance.drawSwitch(screen, 8 * -22 + 0, 0, true, false, "spell1", "pause", "> Pause");
                            ScreenDrawing.AutoLine.addSpaceMark();
                            ScreenDrawing.ComponentAdvance.drawSwitch(screen, 8 * -22 + 0, 0, true, false, "spell1", "is_enable1", "Enable 1");
                            ScreenDrawing.ComponentAdvance.drawSwitch(screen, 8 * -22 + 0, 0, true, false, "spell1", "is_negative1", "> Negative 1");
                            ScreenDrawing.AutoLine.addSpaceMark();
                            ScreenDrawing.ComponentAdvance.drawSwitch(screen, 8 * -22 + 0, 0, true, false, "spell1", "is_enable2", "Enable 2");
                            ScreenDrawing.ComponentAdvance.drawSwitch(screen, 8 * -22 + 0, 0, true, false, "spell1", "is_negative2", "> Negative 2");
                            ScreenDrawing.AutoLine.addSpaceMark();
                            ScreenDrawing.ComponentAdvance.drawSwitch(screen, 8 * -22 + 0, 0, true, false, "spell1", "is_enable3", "Enable 3");
                            ScreenDrawing.ComponentAdvance.drawSwitch(screen, 8 * -22 + 0, 0, true, false, "spell1", "is_negative3", "> Negative 3");
                            ScreenDrawing.AutoLine.addSpaceMark();
                            ScreenDrawing.ComponentAdvance.drawSwitch(screen, 8 * -22 + 0, 0, true, false, "spell1", "is_enable4", "Enable 4");
                            ScreenDrawing.ComponentAdvance.drawSwitch(screen, 8 * -22 + 0, 0, true, false, "spell1", "is_negative4", "> Negative 4");
                            ScreenDrawing.AutoLine.addSpaceMark();
                            ScreenDrawing.ComponentAdvance.drawSwitch(screen, 8 * -22 + 0, 0, true, false, "spell1", "is_enable5", "Enable 5");
                            ScreenDrawing.ComponentAdvance.drawSwitch(screen, 8 * -22 + 0, 0, true, false, "spell1", "is_negative5", "> Negative 5");
                            ScreenDrawing.AutoLine.addSpaceMark();
                            ScreenDrawing.ComponentAdvance.drawSwitch(screen, 8 * -22 + 0, 0, true, false, "spell1", "is_enable6", "Enable 6");
                            ScreenDrawing.ComponentAdvance.drawSwitch(screen, 8 * -22 + 0, 0, true, false, "spell1", "is_negative6", "> Negative 6");
                            ScreenDrawing.AutoLine.stop();

                            ScreenDrawing.AutoLine.start(8 * -9);
                            ScreenDrawing.ComponentAdvance.drawSwitch(screen, 8 * -12 + 0, 0, true, false, "spell1", "is_enable7", "Enable 7");
                            ScreenDrawing.ComponentAdvance.drawSwitch(screen, 8 * -12 + 0, 0, true, false, "spell1", "is_negative7", "> Negative 7");
                            ScreenDrawing.AutoLine.addSpaceMark();
                            ScreenDrawing.ComponentAdvance.drawSwitch(screen, 8 * -12 + 0, 0, true, false, "spell1", "is_enable8", "Enable 8");
                            ScreenDrawing.ComponentAdvance.drawSwitch(screen, 8 * -12 + 0, 0, true, false, "spell1", "is_negative8", "> Negative 8");
                            ScreenDrawing.AutoLine.addSpaceMark();
                            ScreenDrawing.ComponentAdvance.drawSwitch(screen, 8 * -12 + 0, 0, true, false, "spell1", "is_enable9", "Enable 9");
                            ScreenDrawing.ComponentAdvance.drawSwitch(screen, 8 * -12 + 0, 0, true, false, "spell1", "is_negative9", "> Negative 9");
                            ScreenDrawing.AutoLine.addSpaceMark();
                            ScreenDrawing.ComponentAdvance.drawSwitch(screen, 8 * -12 + 0, 0, true, false, "spell1", "is_enable10", "Enable 10");
                            ScreenDrawing.ComponentAdvance.drawSwitch(screen, 8 * -12 + 0, 0, true, false, "spell1", "is_negative10", "> Negative 10");
                            ScreenDrawing.AutoLine.addSpaceMark();
                            ScreenDrawing.ComponentAdvance.drawSwitch(screen, 8 * -12 + 0, 0, true, false, "spell1", "is_enable11", "Enable 11");
                            ScreenDrawing.ComponentAdvance.drawSwitch(screen, 8 * -12 + 0, 0, true, false, "spell1", "is_negative11", "> Negative 11");
                            ScreenDrawing.AutoLine.addSpaceMark();
                            ScreenDrawing.ComponentAdvance.drawSwitch(screen, 8 * -12 + 0, 0, true, false, "spell1", "is_enable12", "Enable 12");
                            ScreenDrawing.ComponentAdvance.drawSwitch(screen, 8 * -12 + 0, 0, true, false, "spell1", "is_negative12", "> Negative 12");
                            ScreenDrawing.AutoLine.addSpaceMark();
                            ScreenDrawing.ComponentAdvance.drawSwitch(screen, 8 * -12 + 0, 0, true, false, "spell1", "is_enable13", "Enable 13");
                            ScreenDrawing.ComponentAdvance.drawSwitch(screen, 8 * -12 + 0, 0, true, false, "spell1", "is_negative13", "> Negative 13");
                            ScreenDrawing.AutoLine.stop();

                        }

                        break pages;

                    } else {

                        page = page + 2;

                    }

                }

                // Wiki
                {

                    if (page == id) {

                        if (type.equals("text") == true) {

                            ScreenDrawing.ComponentBasic.drawTextCentered(graphic, 8 * -18 + 0, 8 * -10 - 4, true, 2, "Sagittarius");
                            ScreenDrawing.ComponentBasic.drawTextCentered(graphic, 8 * -18 + 0, 8 * -8 - 4, true, ScreenDrawing.normal_font_scale, "§1Damage Boost §r| §4Weakness");
                            ScreenDrawing.ComponentBasic.drawTextParagraph(graphic, 8 * -22 + 0, 8 * -6 + 0, 160, "§" + (int) NBTManager.Mob.getNumber(screen.player, "test", "color") + "   I have changed, I have changed. Just like you, just like you. For how long? For how long must I wait? I know there's something wrong. Your concrete heart isn't beating. And I've tried to make it come alive. No shadows, just red lights. Now I'm here to rescue you.");

                        } else if (type.equals("image") == true) {

                            ScreenDrawing.ComponentBasic.drawImageBasic(graphic, 8 * -22 + 0, 8 * -12 + 0, 20, 36, "tanscomplexmagic:textures/screens/background.png");
                            ScreenDrawing.ComponentBasic.drawImageBasic(graphic, 8 * -22 + 2, 8 * -12 + 2, 32, 32, "tanscomplexmagic:textures/block/zodiac_card1.png");

                        }

                        break pages;

                    } else {

                        page = page + 2;

                    }

                }

            }

        }

    }

}
