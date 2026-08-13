package tannyjung.tanscomplexmagic_handcode.core;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.phys.Vec3;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tannyjung.tanscomplexmagic_core.game.screen.GUIScreen;
import tannyjung.tanscomplexmagic_core.game.NBTManager;
import tannyjung.tanscomplexmagic_core.game.screen.ScreenDrawing;
import tannyjung.tanscomplexmagic_core.outside.NetworkManager;
import tannyjung.tanscomplexmagic_core.outside.OutsideUtils;

public class GUIs {

    private static final Logger log = LoggerFactory.getLogger(GUIs.class);

    public static void render (GUIScreen screen, int id) {

        int page = 1;
        int mana = (int) NBTManager.Mob.getNumber(screen.player, "main", "mana");
        generateBackground(screen, id, mana);

        // Main
        {

            // Ally List
            {

                if (page == id) {

                    ScreenDrawing.AutoLine.start(8 * -22 + 0, 8 * -12 + 0);
                    ScreenDrawing.ComponentBasic.drawTextBasic(0, 0, 1.5, "Ally List");
                    ScreenDrawing.ComponentAdvance.drawList(screen, 0 ,0);

                    ScreenDrawing.AutoLine.stop();

                    return;

                } else {

                    page = page + 2;

                }

            }

        }

        // Spell 1
        {

            // Wiki : Cards
            {

                // 1 Aries
                {

                    if (page == id) {

                        ScreenDrawing.ComponentBasic.drawImageBasic(8 * -22 + 0, 8 * -12 + 0, 20, 36, "tanscomplexmagic:textures/screens/background.png");
                        ScreenDrawing.ComponentBasic.drawImageBasic(8 * -22 + 2, 8 * -12 + 2, 32, 32, "tanscomplexmagic:textures/block/zodiac_card1.png");
                        ScreenDrawing.ComponentBasic.drawTextCenteredBasic(8 * -18 + 0, 8 * -10 - 5, true, 1.5, "Aries");
                        ScreenDrawing.ComponentBasic.drawTextCenteredBasic(8 * -18 + 0, 8 * -8 - 6, true, ScreenDrawing.normal_font_scale, "§8Courage and Fear");
                        ScreenDrawing.AutoLine.start(8 * -22 + 0, 8 * -6 + 0);
                        ScreenDrawing.ComponentBasic.drawTextParagraph(0, 0, 160, "§" + (int) NBTManager.Mob.getNumber(screen.player, "test", "color") + "   The 1st sign of zodiac. Aries is the ram full of courage. The legend is quite complicated, some is the golden ram sent by gods to save 2 children. After all, the ram becomes a symbol of courage and sacrifice.");
                        ScreenDrawing.ComponentBasic.drawTextParagraph(0, 0, 160, "§" + (int) NBTManager.Mob.getNumber(screen.player, "test", "color") + "   There's low information to tell what is the true power of this sign. Astral magicians said it can give some of courage to people to do something they are scared to do. Some of them discovered it can reduce their fear of height, or even committing illegal acts. After my tests, I can bring one of its power into the card. The power to see in the dark, as I'm scared of darkness.");
                        ScreenDrawing.AutoLine.stop();
                        ScreenDrawing.ComponentBasic.drawTextParagraph(8 * 2 + 0, 8 * -12 + 0, 160, "§" + (int) NBTManager.Mob.getNumber(screen.player, "test", "color") + "   The card has ability to give people part of his courage to gains fear of darkness. On the other hand, flipping the card will breaks people wall of mind and give them the test.");

                        return;

                    } else {

                        page = page + 2;

                    }

                }

                // 2 Taurus
                {

                    if (page == id) {

                        ScreenDrawing.ComponentBasic.drawImageBasic(8 * -22 + 0, 8 * -12 + 0, 20, 36, "tanscomplexmagic:textures/screens/background.png");
                        ScreenDrawing.ComponentBasic.drawImageBasic(8 * -22 + 2, 8 * -12 + 2, 32, 32, "tanscomplexmagic:textures/block/zodiac_card2.png");
                        ScreenDrawing.ComponentBasic.drawTextCenteredBasic(8 * -18 + 0, 8 * -10 - 5, true, 1.5, "Taurus");
                        ScreenDrawing.ComponentBasic.drawTextCenteredBasic(8 * -18 + 0, 8 * -8 - 6, true, ScreenDrawing.normal_font_scale, "§8Hardiness and Worthlessness");
                        ScreenDrawing.AutoLine.start(8 * -22 + 0, 8 * -6 + 0);
                        ScreenDrawing.ComponentBasic.drawTextParagraph(0, 0, 160, "§" + (int) NBTManager.Mob.getNumber(screen.player, "test", "color") + "   The 2nd sign of zodiac. Taurus is the big strong bull. The legend is that Zeus turned himself into the strong white bull to win the heart of the princess Europa, then carrying her across the sea.");
                        ScreenDrawing.ComponentBasic.drawTextParagraph(0, 0, 160, "§" + (int) NBTManager.Mob.getNumber(screen.player, "test", "color") + "   Even the history is about love and relationship, but the power of Taurus sign is one of strongest power in the zodiac. The sign gives power of body protection that can protect from almost all damage of any weapons, as though this is the bless of Zeus for the princess Europa.");
                        ScreenDrawing.ComponentBasic.drawTextParagraph(0, 0, 160, "§" + (int) NBTManager.Mob.getNumber(screen.player, "test", "color") + "   Note that the sign does not giving people body strength, only body protection. Some magicians called it \"Iron Skin\".");
                        ScreenDrawing.AutoLine.stop();
                        ScreenDrawing.ComponentBasic.drawTextParagraph(8 * 2 + 0, 8 * -12 + 0, 160, "§" + (int) NBTManager.Mob.getNumber(screen.player, "test", "color") + "   The card has ability to share part of protection to people and other living things. Can absorbs almost all of incoming damages. While flipping the card not giving them vulnerability, but instead they will receive the feeling of drunken, as if heartbroken.");

                        return;

                    } else {

                        page = page + 2;

                    }

                }

                // 3 Gemini
                {

                    if (page == id) {

                        ScreenDrawing.ComponentBasic.drawImageBasic(8 * -22 + 0, 8 * -12 + 0, 20, 36, "tanscomplexmagic:textures/screens/background.png");
                        ScreenDrawing.ComponentBasic.drawImageBasic(8 * -22 + 2, 8 * -12 + 2, 32, 32, "tanscomplexmagic:textures/block/zodiac_card3.png");
                        ScreenDrawing.ComponentBasic.drawTextCenteredBasic(8 * -18 + 0, 8 * -10 - 5, true, 1.5, "Gemini ");
                        ScreenDrawing.ComponentBasic.drawTextCenteredBasic(8 * -18 + 0, 8 * -8 - 6, true, ScreenDrawing.normal_font_scale, "§8Hopeful and Hopeless");
                        ScreenDrawing.AutoLine.start(8 * -22 + 0, 8 * -6 + 0);
                        ScreenDrawing.ComponentBasic.drawTextParagraph(0, 0, 160, "§" + (int) NBTManager.Mob.getNumber(screen.player, "test", "color") + "   The 3rd sign of zodiac. Gemini is the twins. Some history tell that they is Pollux and Castor. One has the bloodline of god, so he is an immortal. But other one is a mortal, since he is human. After Castor died, Pollux begged his father to give Castor immortality.");
                        ScreenDrawing.ComponentBasic.drawTextParagraph(0, 0, 160, "§" + (int) NBTManager.Mob.getNumber(screen.player, "test", "color") + "   Gemini sign can make people feel of motivation, increasing their strength by no reason. Some astral magicians said that this sign is one of dangerous signs if use it incorrectly. Even it has the power to give people motivation, but can also give the feeling of discouraged and hopeless to some people.");
                        ScreenDrawing.AutoLine.stop();
                        ScreenDrawing.ComponentBasic.drawTextParagraph(8 * 2 + 0, 8 * -12 + 0, 160, "§" + (int) NBTManager.Mob.getNumber(screen.player, "test", "color") + "   The card has ability to give people feeling of bond, motivation, and energy. If flipping, it will make them feel tired and sometime hopeless.");
                        ScreenDrawing.ComponentBasic.drawTextParagraph(8 * 2 + 0, 8 * -12 + 0, 160, "§" + (int) NBTManager.Mob.getNumber(screen.player, "test", "color") + "   Can make non-players killing themselves?");

                        return;

                    } else {

                        page = page + 2;

                    }

                }

                // 4 Cancer
                {

                    if (page == id) {

                        ScreenDrawing.ComponentBasic.drawImageBasic(8 * -22 + 0, 8 * -12 + 0, 20, 36, "tanscomplexmagic:textures/screens/background.png");
                        ScreenDrawing.ComponentBasic.drawImageBasic(8 * -22 + 2, 8 * -12 + 2, 32, 32, "tanscomplexmagic:textures/block/zodiac_card4.png");
                        ScreenDrawing.ComponentBasic.drawTextCenteredBasic(8 * -18 + 0, 8 * -10 - 5, true, 1.5, "Cancer");
                        ScreenDrawing.ComponentBasic.drawTextCenteredBasic(8 * -18 + 0, 8 * -8 - 6, true, ScreenDrawing.normal_font_scale, "§8Luck and Unluck");
                        ScreenDrawing.AutoLine.start(8 * -22 + 0, 8 * -6 + 0);
                        ScreenDrawing.ComponentBasic.drawTextParagraph(0, 0, 160, "§" + (int) NBTManager.Mob.getNumber(screen.player, "test", "color") + "   The 4st sign of zodiac. Cancer is the crab. Some history tells that he crushed under the foot of Heracles. Moved by his loyalty, Hera brings him placed in the sky and becomes the Cancer constellation.");
                        ScreenDrawing.ComponentBasic.drawTextParagraph(0, 0, 160, "§" + (int) NBTManager.Mob.getNumber(screen.player, "test", "color") + "   Many astral magicians said that the crab is one of weakest signs in the zodiac, with the power of animal attraction in very small scale. However after my some experiments, I discovered that it might be one of the most powerful sign. While making the card and trying to apply the power of it to my body, I noticed my luck changes instead of attracting the butterflies in the room. Sometimes I'm very lucky, sometimes nearly die in accidents.");
                        ScreenDrawing.AutoLine.stop();
                        ScreenDrawing.ComponentBasic.drawTextParagraph(8 * 2 + 0, 8 * -12 + 0, 160, "§" + (int) NBTManager.Mob.getNumber(screen.player, "test", "color") + "   The card has ability to control luck of people. Head up card gives good luck, while head down card gives bad luck. But be careful while using this, the result is unstable. Luck may change to unluck, or just no affect to targets.");

                        return;

                    } else {

                        page = page + 2;

                    }

                }

                // 7 Libra
                {

                    if (page == id) {

                        ScreenDrawing.ComponentBasic.drawImageBasic(8 * -22 + 0, 8 * -12 + 0, 20, 36, "tanscomplexmagic:textures/screens/background.png");
                        ScreenDrawing.ComponentBasic.drawImageBasic(8 * -22 + 2, 8 * -12 + 2, 32, 32, "tanscomplexmagic:textures/block/zodiac_card7.png");
                        ScreenDrawing.ComponentBasic.drawTextCenteredBasic(8 * -18 + 0, 8 * -10 - 5, true, 1.5, "Libra");
                        ScreenDrawing.ComponentBasic.drawTextCenteredBasic(8 * -18 + 0, 8 * -8 - 6, true, ScreenDrawing.normal_font_scale, "§8Fairness and Unfairness");
                        ScreenDrawing.AutoLine.start(8 * -22 + 0, 8 * -6 + 0);
                        ScreenDrawing.ComponentBasic.drawTextParagraph(0, 0, 160, "§" + (int) NBTManager.Mob.getNumber(screen.player, "test", "color") + "   The 7st sign of zodiac. The scales of justice. The only sign in the zodiac that represented as an object.");
                        ScreenDrawing.ComponentBasic.drawTextParagraph(0, 0, 160, "§" + (int) NBTManager.Mob.getNumber(screen.player, "test", "color") + "   Libra doesn't have much information. No one know the true power of it. Some astral magicians discovered that it can detect liars perfectly, some discovered it can change some reality. So they mark this sign as still in dangerous to use, because of not enough information.");
                        ScreenDrawing.ComponentBasic.drawTextParagraph(0, 0, 160, "§" + (int) NBTManager.Mob.getNumber(screen.player, "test", "color") + "   I bring one of its popular powers into the card. Astral magicians named it \"Fair Fight\", used in arenas. It cleanses buffs and debuffs from all fighters in the area.");
                        ScreenDrawing.AutoLine.stop();
                        ScreenDrawing.ComponentBasic.drawTextParagraph(8 * 2 + 0, 8 * -12 + 0, 160, "§" + (int) NBTManager.Mob.getNumber(screen.player, "test", "color") + "   Another power I bring into flipped card. Some astral magicians used it, they named it \"Justice Reflection\". The card will reflect buff and debuff from user into the targets, makes them have the same buff and debuff as user.");

                        return;

                    } else {

                        page = page + 2;

                    }

                }

            }

            // Settings
            {

                // General and Card Settings 1
                {

                    if (page == id) {

                        ScreenDrawing.AutoLine.start(8 * -22 + 0, 8 * -11 + 0);
                        ScreenDrawing.ComponentBasic.drawTextCenteredBasic(0, 0, true, 2, "Settings");
                        ScreenDrawing.ComponentAdvance.drawSwitchBasic(screen, 0, 0, "spell1", "is_pause_all", "Pause All Cards");
                        ScreenDrawing.ComponentAdvance.drawSliderBasic(screen, 0, 0, 160, 1, 100, 1, "spell1", "radius", "Radius");
                        ScreenDrawing.AutoLine.stop();

                        generateSpell1SettingsCard(screen, mana, false, "Aries 1", 1, 1, 1, 120, 180);

                        return;

                    } else {

                        page = page + 2;

                    }

                }

                // Card Settings 2-3
                {

                    if (page == id) {

                        generateSpell1SettingsCard(screen, mana, true, "Taurus 2", 2, 3, 1, 60, 180);
                        generateSpell1SettingsCard(screen, mana, false, "Gemini 3", 3, 2, 2, 120, 180);

                        return;

                    } else {

                        page = page + 2;

                    }

                }

                // Card Settings 4-5
                {

                    if (page == id) {

                        generateSpell1SettingsCard(screen, mana, true, "Cancer 4", 4, 1, 1, 120, 120);
                        generateSpell1SettingsCard(screen, mana, false, "Leo 5", 5, 1, 1, 60, 180);

                        return;

                    } else {

                        page = page + 2;

                    }

                }

                // Card Settings 6-7
                {

                    if (page == id) {

                        generateSpell1SettingsCard(screen, mana, true, "Virgo 6", 6, 1, 1, 60, 120);
                        generateSpell1SettingsCard(screen, mana, false, "Libra 7", 7, 1, 1, 60, 60);

                        return;

                    } else {

                        page = page + 2;

                    }

                }

                // Card Settings 8-9
                {

                    if (page == id) {

                        generateSpell1SettingsCard(screen, mana, true, "Scorpio 8", 8, 1, 1, 120, 60);
                        generateSpell1SettingsCard(screen, mana, false, "Sagittarius 9", 9, 1, 1, 120, 120);

                        return;

                    } else {

                        page = page + 2;

                    }

                }

                // Card Settings 10-11
                {

                    if (page == id) {

                        generateSpell1SettingsCard(screen, mana, true, "Capricorn 10", 10, 1, 1, 60, 60);
                        generateSpell1SettingsCard(screen, mana, false, "Aquarius 11", 11, 1, 1, 120, 120);

                        return;

                    } else {

                        page = page + 2;

                    }

                }

                // Card Settings 12-13
                {

                    if (page == id) {

                        generateSpell1SettingsCard(screen, mana, true, "Pisces 12", 12, 1, 1, 120, 120);
                        generateSpell1SettingsCard(screen, mana, false, "Ophiuchus 13", 13, 1, 1, 60, 60);

                        return;

                    } else {

                        page = page + 2;

                    }

                }

            }

        }

    }
    
    private static void generateBackground (GUIScreen screen, int id, int mana) {

        // Page Number
        {

            StringBuilder page_left = new StringBuilder().append(id);
            StringBuilder page_right = new StringBuilder().append(id + 1);

            while (page_left.length() < 3) {

                page_left.insert(0, "0");

            }

            while (page_right.length() < 3) {

                page_right.insert(0, "0");

            }

            ScreenDrawing.ComponentBasic.drawTextBasic(8 * -21 + 1, 8 * 12 + 0, 0.5, page_left.toString());
            ScreenDrawing.ComponentBasic.drawTextBasic(8 * 19 + 6, 8 * 12 + 0, 0.5, page_right.toString());

        }

        ScreenDrawing.ComponentBasic.drawTextBasic(8 * -22 + 0, 8 * 13 + 7, 0.54, NBTManager.Mob.getText(screen.player, "book", "log_text"));
        ScreenDrawing.ComponentBasic.drawImageBasic(8 * -25 + 0, 8 * -15 + 0, 400, 240, "tanscomplexmagic:textures/screens/gui_component_background.png");
        ScreenDrawing.ComponentBasic.drawImageSplit(8 * 1 + 0, 8 * 13 + 6, 168, 7, true, 24, (int) ((screen.player.clientLevel.dayTime() % 24000) / 1000), "tanscomplexmagic:textures/screens/gui_component_clock.png");

        // Compass
        {

            Vec3 destination_pos = new Vec3(0, 0, 0);
            int degree = 0;

            destination_pos = screen.player.clientLevel.getSharedSpawnPos().getCenter();
            degree = (int) OutsideUtils.Calculation.getDegreeDestinationX(screen.player.getYRot(), screen.player.getX(), screen.player.getZ(), destination_pos.x, destination_pos.z);
            degree = (int) Math.round(degree / 45.0);
            ScreenDrawing.ComponentBasic.drawImageSplit(8 * 2 - 0, 8 * 13 + 6, 56, 7, true, 8, degree, "tanscomplexmagic:textures/screens/gui_component_compass.png");

            destination_pos = new Vec3(NBTManager.Mob.getNumber(screen.player, "book", "compassX"), 0, NBTManager.Mob.getNumber(screen.player, "book", "compassZ"));
            degree = (int) OutsideUtils.Calculation.getDegreeDestinationX(screen.player.getYRot(), screen.player.getX(), screen.player.getZ(), destination_pos.x, destination_pos.z);
            degree = (int) Math.round(degree / 45.0);
            ScreenDrawing.ComponentBasic.drawImageSplit(8 * 3 - 0, 8 * 13 + 6, 56, 7, true, 8, degree, "tanscomplexmagic:textures/screens/gui_component_compass_custom.png");

        }

        ScreenDrawing.ComponentBasic.drawImageSplit(8 * 24 + 3, 8 * 5 + 6, 61, 60, true, 61, (int) NBTManager.Mob.getNumber(screen.player, "main", "mana_charge"), "tanscomplexmagic:textures/screens/gui_component_mana_bar_charge.png");
        ScreenDrawing.ComponentBasic.drawImageSplit(8 * 24 + 3, 8 * -14 + 4, 151, 150, true, 151, mana, "tanscomplexmagic:textures/screens/gui_component_mana_bar.png");

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

            ScreenDrawing.ComponentBasic.drawImageSplit(8 * -23 - 4, 8 * 13 + 6, 28, 7, true, 4, log, "tanscomplexmagic:textures/screens/gui_component_log_type.png");

        }

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

    private static void generateSpell1SettingsCard (GUIScreen screen, int mana, boolean is_page_left, String name, int number, int max_level_positive, int max_level_negative, int duration_per_mana_positive, int duration_per_mana_negative) {

        int posX = 0;

        if (is_page_left == true) {

            posX = 8 * -22 + 0;

        } else {

            posX = 8 * 2 + 0;

        }

        ScreenDrawing.AutoLine.start(posX, 8 * -12 + 0);
        ScreenDrawing.ComponentBasic.drawTextCenteredBasic(0, 0, true, 1, "Card Settings : " + name);
        ScreenDrawing.ComponentBasic.drawTextBasic(0, 0, ScreenDrawing.normal_font_scale, "§8Detected Targets : " + (int) NBTManager.Mob.getNumber(screen.player, "spell1", "number_of_targets_detected" + number));
        ScreenDrawing.ComponentBasic.drawTextBasic(0, 0, ScreenDrawing.normal_font_scale, "§8Remaining Duration : " + NBTManager.Mob.getText(screen.player, "spell1", "remaining_duration" + number));
        ScreenDrawing.AutoLine.setMarkZ();
        ScreenDrawing.ComponentAdvance.drawSwitchBasic(screen, 0, 0, "spell1", "is_card_enable" + number, "Enable");
        ScreenDrawing.ComponentAdvance.drawSwitchBasic(screen, 0, 0, "spell1", "is_card_active" + number, "Activate Effect");
        ScreenDrawing.AutoLine.returnMarkZ();
        ScreenDrawing.ComponentAdvance.drawSwitchBasic(screen, 80, 0, "spell1", "is_card_negative" + number, "Flip Card");
        ScreenDrawing.ComponentAdvance.drawSwitchBasic(screen, 80, 0, "spell1", "is_card_high_power_mode" + number, "High Power Mode");

        ScreenDrawing.ComponentBasic.drawTextBasic(0, 0, ScreenDrawing.normal_font_scale, "Targets");
        ScreenDrawing.AutoLine.addSpace(-4);
        ScreenDrawing.ComponentAdvance.drawSwitchBasic(screen, 0, 0, "spell1", "is_card_target_user" + number, "User");
        ScreenDrawing.ComponentAdvance.drawSwitchBasic(screen, 0, 0, "spell1", "is_card_target_ally_player" + number, "Ally Player");
        ScreenDrawing.ComponentAdvance.drawSwitchBasic(screen, 0, 0, "spell1", "is_card_target_ally_non_player" + number, "Ally Non-Player");
        ScreenDrawing.ComponentAdvance.drawSwitchBasic(screen, 0, 0, "spell1", "is_card_target_enemy_player" + number, "Enemy Player");
        ScreenDrawing.ComponentAdvance.drawSwitchBasic(screen, 0, 0, "spell1", "is_card_target_enemy_non_player" + number, "Enemy Non-Player");
        ScreenDrawing.ComponentAdvance.drawSwitchBasic(screen, 0, 0, "spell1", "is_card_target_mark" + number, "Mark");

        // Duration
        {

            ScreenDrawing.ComponentAdvance.drawSliderBasic(screen, 0, 0, 160, 0, NBTManager.Mob.getNumber(screen.player, "spell1", "card_duration_max_positive" + number), 1, "spell1", "card_duration_positive" + number, "Positive Duration");
            ScreenDrawing.AutoLine.addSpace(-8);

            ScreenDrawing.ComponentAdvance.drawButtonLockableCustomWork(screen, 0, 0, 160, true, mana < 1, "+" + duration_per_mana_positive + " / 1 Mana", "+" + duration_per_mana_positive + " / 1 Mana", () -> {

                CompoundTag tag = new CompoundTag();
                tag.putInt("duration_per_mana_positive", duration_per_mana_positive);
                NetworkManager.runServer(screen.player, "spell1", "get_duration_positive" + number, tag);

            });

            ScreenDrawing.ComponentAdvance.drawSliderBasic(screen, 0, 0, 160, 0, NBTManager.Mob.getNumber(screen.player, "spell1", "card_duration_max_negative" + number), 1, "spell1", "card_duration_negative" + number, "Negative Duration");
            ScreenDrawing.AutoLine.addSpace(-8);

            ScreenDrawing.ComponentAdvance.drawButtonLockableCustomWork(screen, 0, 0, 160, true, mana < 1, "+" + duration_per_mana_negative + " / 1 Mana)", "+" + duration_per_mana_negative + " / 1 Mana", () -> {

                CompoundTag tag = new CompoundTag();
                tag.putInt("duration_per_mana_negative", duration_per_mana_negative);
                NetworkManager.runServer(screen.player, "spell1", "get_duration_negative" + number, tag);

            });

        }

        ScreenDrawing.AutoLine.stop();

    }

}
