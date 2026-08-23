package tannyjung.tanscomplexmagic_handcode.core;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.phys.Vec3;
import tannyjung.tanscomplexmagic_core.game.NBTManager;
import tannyjung.tanscomplexmagic_core.game.screen.GUIManager;
import tannyjung.tanscomplexmagic_core.game.screen.ScreenDrawing;
import tannyjung.tanscomplexmagic_core.outside.NetworkManager;
import tannyjung.tanscomplexmagic_core.outside.OutsideUtils;
import tannyjung.tanscomplexmagic_handcode.systems.Utils;

public class GUIs {

    public static void add () {

        // Main
        {

            GUIManager.Storage.add("book", "ally_list", () -> {

                generateBackground();

                ScreenDrawing.Position.set(ScreenDrawing.Anchor.Type.CENTER, 8 * -22 + 0, 8 * -12 + 0);
                ScreenDrawing.ComponentOverlay.drawTextBasic(1.25, "Ally List");
                ScreenDrawing.Position.addZ(8);
                ScreenDrawing.ComponentOverlay.drawTextParagraph(160, "   Hello");
                ScreenDrawing.Position.addZ(8);
                ScreenDrawing.ComponentOverlay.drawImageBasic(16, 16, "tanscomplexmagic:textures/screens/icon_ally_list.png");
                ScreenDrawing.Position.addZ(8);
                ScreenDrawing.ComponentOverlay.drawTextParagraph(160, "   Hello");

            });

            GUIManager.Storage.add("book", "ally_list_manager", () -> {

                generateBackground();

                ScreenDrawing.Position.set(ScreenDrawing.Anchor.Type.CENTER, 8 * -22 + 0, 8 * -12 + 0);
                ScreenDrawing.ComponentWidget.Board.ListEntity.draw("Ally List", Utils.Tag.getAlly(ScreenDrawing.player_local), "   Manage list of your ally. Some spell systems can interact with this list, some can skip negative actions on them.");

            });

        }

        // Spell 1
        {

            // Wiki
            {

                GUIManager.Storage.add("book", "spell1_wiki_card1", () -> {

                    generateBackground();

                    ScreenDrawing.Position.set(ScreenDrawing.Anchor.Type.CENTER, 8 * -22 + 0, 8 * -12 + 0);
                    ScreenDrawing.ComponentOverlay.drawImageBasic(20, 36, "tanscomplexmagic:textures/screens/background.png");
                    ScreenDrawing.Position.add(2, 2);
                    ScreenDrawing.ComponentOverlay.drawImageBasic(32, 32, "tanscomplexmagic:textures/block/zodiac_card1.png");
                    ScreenDrawing.Position.set(ScreenDrawing.Anchor.Type.CENTER, 8 * -18 + 0, 8 * -10 - 3);
                    ScreenDrawing.ComponentOverlay.drawTextCenteredBasic(true, 1, "Aries");
                    ScreenDrawing.Position.set(ScreenDrawing.Anchor.Type.CENTER, 8 * -18 + 0, 8 * -9 - 1);
                    ScreenDrawing.ComponentOverlay.drawTextCenteredBasic(true, ScreenDrawing.normal_font_scale, "§8Courage and Fear");

                    ScreenDrawing.Position.set(ScreenDrawing.Anchor.Type.CENTER, 8 * -22 + 0, 8 * -6 + 0);
                    ScreenDrawing.ComponentOverlay.drawTextParagraph(160, "   The 1st sign of zodiac. Aries is the ram full of courage. The legend is quite complicated, some is the golden ram sent by gods to save 2 children. After all, the ram becomes a symbol of courage and sacrifice.");
                    ScreenDrawing.Position.addZ(8);
                    ScreenDrawing.ComponentOverlay.drawTextParagraph(160, "   There's low information to tell what is the true power of this sign. Astral magicians said it can give some of courage to people to do something they are scared to do. Some of them discovered it can reduce their fear of height, or even committing illegal acts. After my tests, I can bring one of its power into the card. The power to see in the dark, as I'm scared of darkness.");

                    ScreenDrawing.Position.set(ScreenDrawing.Anchor.Type.CENTER, 8 * 2 + 0, 8 * -12 + 0);
                    ScreenDrawing.ComponentOverlay.drawTextParagraph(160, "   The card has ability to give people part of his courage to gains fear of darkness. On the other hand, flipping the card will breaks people wall of mind and give them the test.");

                });

                GUIManager.Storage.add("book", "spell1_wiki_card2", () -> {

                    generateBackground();

                    ScreenDrawing.ComponentOverlay.drawImageBasic(20, 36, "tanscomplexmagic:textures/screens/background.png");
                    ScreenDrawing.ComponentOverlay.drawImageBasic(32, 32, "tanscomplexmagic:textures/block/zodiac_card2.png");
                    ScreenDrawing.ComponentOverlay.drawTextCenteredBasic(true, 1, "Taurus");
                    ScreenDrawing.ComponentOverlay.drawTextCenteredBasic(true, ScreenDrawing.normal_font_scale, "§8Hardiness and Worthlessness");
                    
                    ScreenDrawing.ComponentOverlay.drawTextParagraph(160, "§" + (int) NBTManager.Mob.getNumber(ScreenDrawing.player_local, "test", "color") + "   The 2nd sign of zodiac. Taurus is the big strong bull. The legend is that Zeus turned himself into the strong white bull to win the heart of the princess Europa, then carrying her across the sea.");
                    ScreenDrawing.ComponentOverlay.drawTextParagraph(160, "§" + (int) NBTManager.Mob.getNumber(ScreenDrawing.player_local, "test", "color") + "   Even the history is about love and relationship, but the power of Taurus sign is one of strongest power in the zodiac. The sign gives power of body protection that can protect from almost all damage of any weapons, as though this is the bless of Zeus for the princess Europa.");
                    ScreenDrawing.ComponentOverlay.drawTextParagraph(160, "§" + (int) NBTManager.Mob.getNumber(ScreenDrawing.player_local, "test", "color") + "   Note that the sign does not giving people body strength, only body protection. Some magicians called it \"Iron Skin\".");
                    
                    ScreenDrawing.ComponentOverlay.drawTextParagraph(160, "§" + (int) NBTManager.Mob.getNumber(ScreenDrawing.player_local, "test", "color") + "   The card has ability to share part of protection to people and other living things. Can absorbs almost all of incoming damages. While flipping the card not giving them vulnerability, but instead they will receive the feeling of drunken, as if heartbroken.");

                });

                GUIManager.Storage.add("book", "spell1_wiki_card3", () -> {

                    generateBackground();

                    ScreenDrawing.ComponentOverlay.drawImageBasic(20, 36, "tanscomplexmagic:textures/screens/background.png");
                    ScreenDrawing.ComponentOverlay.drawImageBasic(32, 32, "tanscomplexmagic:textures/block/zodiac_card3.png");
                    ScreenDrawing.ComponentOverlay.drawTextCenteredBasic(true, 1, "Gemini ");
                    ScreenDrawing.ComponentOverlay.drawTextCenteredBasic(true, ScreenDrawing.normal_font_scale, "§8Hopeful and Hopeless");
                    
                    ScreenDrawing.ComponentOverlay.drawTextParagraph(160, "§" + (int) NBTManager.Mob.getNumber(ScreenDrawing.player_local, "test", "color") + "   The 3rd sign of zodiac. Gemini is the twins. Some history tell that they is Pollux and Castor. One has the bloodline of god, so he is an immortal. But other one is a mortal, since he is human. After Castor died, Pollux begged his father to give Castor immortality.");
                    ScreenDrawing.ComponentOverlay.drawTextParagraph(160, "§" + (int) NBTManager.Mob.getNumber(ScreenDrawing.player_local, "test", "color") + "   Gemini sign can make people feel of motivation, increasing their strength by no reason. Some astral magicians said that this sign is one of dangerous signs if use it incorrectly. Even it has the power to give people motivation, but can also give the feeling of discouraged and hopeless to some people.");
                    
                    ScreenDrawing.Position.set(ScreenDrawing.Anchor.Type.CENTER, 8 * 2 + 0, 8 * -12 + 0);
                    ScreenDrawing.ComponentOverlay.drawTextParagraph(160, "§" + (int) NBTManager.Mob.getNumber(ScreenDrawing.player_local, "test", "color") + "   The card has ability to give people feeling of bond, motivation, and energy. If flipping, it will make them feel tired and sometime hopeless.");
                    

                });

                GUIManager.Storage.add("book", "spell1_wiki_card4", () -> {

                    generateBackground();

                    ScreenDrawing.ComponentOverlay.drawImageBasic(20, 36, "tanscomplexmagic:textures/screens/background.png");
                    ScreenDrawing.ComponentOverlay.drawImageBasic(32, 32, "tanscomplexmagic:textures/block/zodiac_card4.png");
                    ScreenDrawing.ComponentOverlay.drawTextCenteredBasic(true, 1, "Cancer");
                    ScreenDrawing.ComponentOverlay.drawTextCenteredBasic(true, ScreenDrawing.normal_font_scale, "§8Luck and Unluck");
                    
                    ScreenDrawing.ComponentOverlay.drawTextParagraph(160, "§" + (int) NBTManager.Mob.getNumber(ScreenDrawing.player_local, "test", "color") + "   The 4st sign of zodiac. Cancer is the crab. Some history tells that he crushed under the foot of Heracles. Moved by his loyalty, Hera brings him placed in the sky and becomes the Cancer constellation.");
                    ScreenDrawing.ComponentOverlay.drawTextParagraph(160, "§" + (int) NBTManager.Mob.getNumber(ScreenDrawing.player_local, "test", "color") + "   Many astral magicians said that the crab is one of weakest signs in the zodiac, with the power of animal attraction in very small scale. However after my some experiments, I discovered that it might be one of the most powerful sign. While making the card and trying to apply the power of it to my body, I noticed my luck changes instead of attracting the butterflies in the room. Sometimes I'm very lucky, sometimes nearly die in accidents.");
                    
                    ScreenDrawing.ComponentOverlay.drawTextParagraph(160, "§" + (int) NBTManager.Mob.getNumber(ScreenDrawing.player_local, "test", "color") + "   The card has ability to control luck of people. Head up card gives good luck, while head down card gives bad luck. But be careful while using this, the result is unstable. Luck may change to unluck, or just no affect to targets.");
                    
                });

                GUIManager.Storage.add("book", "spell1_wiki_card7", () -> {

                    generateBackground();

                    ScreenDrawing.ComponentOverlay.drawImageBasic(20, 36, "tanscomplexmagic:textures/screens/background.png");
                    ScreenDrawing.ComponentOverlay.drawImageBasic(32, 32, "tanscomplexmagic:textures/block/zodiac_card7.png");
                    ScreenDrawing.ComponentOverlay.drawTextCenteredBasic(true, 1, "Libra");
                    ScreenDrawing.ComponentOverlay.drawTextCenteredBasic(true, ScreenDrawing.normal_font_scale, "§8Fairness and Unfairness");
                    
                    ScreenDrawing.ComponentOverlay.drawTextParagraph(160, "§" + (int) NBTManager.Mob.getNumber(ScreenDrawing.player_local, "test", "color") + "   The 7st sign of zodiac. The scales of justice. The only sign in the zodiac that represented as an object.");
                    ScreenDrawing.ComponentOverlay.drawTextParagraph(160, "§" + (int) NBTManager.Mob.getNumber(ScreenDrawing.player_local, "test", "color") + "   Libra doesn't have much information. No one know the true power of it. Some astral magicians discovered that it can detect liars perfectly, some discovered it can change some reality. So they mark this sign as still in dangerous to use, because of not enough information.");
                    ScreenDrawing.ComponentOverlay.drawTextParagraph(160, "§" + (int) NBTManager.Mob.getNumber(ScreenDrawing.player_local, "test", "color") + "   I bring one of its popular powers into the card. Astral magicians named it \"Fair Fight\", used in arenas. It cleanses buffs and debuffs from all fighters in the area.");
                    
                    ScreenDrawing.ComponentOverlay.drawTextParagraph(160, "§" + (int) NBTManager.Mob.getNumber(ScreenDrawing.player_local, "test", "color") + "   Another power I bring into flipped card. Some astral magicians used it, they named it \"Justice Reflection\". The card will reflect buff and debuff from user into the targets, makes them have the same buff and debuff as user.");


                });

            }

            // Settings
            {

                GUIManager.Storage.add("book", "spell1_settings", () -> {

                    generateBackground();

                    ScreenDrawing.Position.set(ScreenDrawing.Anchor.Type.CENTER, 8 * -22 + 0, 8 * -12 + 0);
                    ScreenDrawing.ComponentOverlay.drawTextBasic(1.25, "Settings");
                    ScreenDrawing.Position.addZ(8);
                    ScreenDrawing.ComponentWidget.Switch.drawText("spell1", "is_pause_all", "Pause All Cards");
                    ScreenDrawing.Position.addZ(8);
                    ScreenDrawing.ComponentWidget.Slider.drawText(160, 1, 200, 1, "spell1", "radius", "Radius");

                });

                GUIManager.Storage.add("book", "spell1_target_mark_manager", () -> {

                    generateBackground();

                    ScreenDrawing.Position.set(ScreenDrawing.Anchor.Type.CENTER, 8 * -22 + 0, 8 * -12 + 0);
                    ScreenDrawing.ComponentWidget.Board.ListEntity.draw("Target Mark", Utils.Tag.getUser(ScreenDrawing.player_local) + "_spell1_mark", "   You can mark specific targets you want to add effects using this list. Once adding them, you can enable target mode \"Mark\" in the card settings page.");

                });

            }

            // Settings : Cards
            {

                GUIManager.Storage.add("book", "spell1_settings_card1", () -> {

                    generateBackground();
                    generateSpell1SettingsCard(true, "Aries 1", 1, 150 * 3, 150 * 5);
                    generateSpell1SettingsCard(false, "Taurus 2", 2, 150 * 1, 150 * 5);

                });

                GUIManager.Storage.add("book", "spell1_settings_card2", () -> {

                    generateBackground();
                    generateSpell1SettingsCard(true, "Gemini 3", 3, 150 * 2, 150 * 5);
                    generateSpell1SettingsCard(false, "Cancer 4", 4, 150 * 3, 150 * 3);

                });

                GUIManager.Storage.add("book", "spell1_settings_card3", () -> {

                    generateBackground();
                    generateSpell1SettingsCard(true, "Leo 5", 5, 150 * 1, 150 * 4);
                    generateSpell1SettingsCard(false, "Virgo 6", 6, 150 * 1, 150 * 2);

                });

                GUIManager.Storage.add("book", "spell1_settings_card4", () -> {

                    generateBackground();
                    generateSpell1SettingsCard(true, "Libra 7", 7, 150 * 1, 150 * 1);
                    generateSpell1SettingsCard(false, "Scorpio 8", 8, 150 * 3, 150 * 2);

                });

                GUIManager.Storage.add("book", "spell1_settings_card5", () -> {

                    generateBackground();
                    generateSpell1SettingsCard(true, "Sagittarius 9", 9, 150 * 2, 150 * 4);
                    generateSpell1SettingsCard(false, "Capricorn 10", 10, 150 * 1, 150 * 3);

                });

                GUIManager.Storage.add("book", "spell1_settings_card6", () -> {

                    generateBackground();
                    generateSpell1SettingsCard(true, "Aquarius 11", 11, 150 * 2, 150 * 3);
                    generateSpell1SettingsCard(false, "Pisces 12", 12, 150 * 2, 150 * 3);

                });

                GUIManager.Storage.add("book", "spell1_settings_card7", () -> {

                    generateBackground();
                    generateSpell1SettingsCard(true, "Ophiuchus 13", 13, 150 * 1, 150 * 1);

                });
                
            }

        }

    }
    
    private static void generateBackground () {

        String group = NBTManager.Mob.getText(ScreenDrawing.player_local, "gui", "group");
        String name = NBTManager.Mob.getText(ScreenDrawing.player_local, "gui", "name");
        int number = GUIManager.Storage.getNumber(group, name);
        int mana = (int) NBTManager.Mob.getNumber(ScreenDrawing.player_local, "main", "mana");

        ScreenDrawing.Position.set(ScreenDrawing.Anchor.Type.CENTER, 8 * -22 + 0, 8 * 13 + 7);
        ScreenDrawing.ComponentOverlay.drawTextBasic(0.54, NBTManager.Mob.getText(ScreenDrawing.player_local, "book", "log_text"));
        ScreenDrawing.Position.set(ScreenDrawing.Anchor.Type.CENTER, 8 * -25 + 0, 8 * -15 + 0);
        ScreenDrawing.ComponentOverlay.drawImageBasic(400, 240, "tanscomplexmagic:textures/screens/gui_component_background.png");
        ScreenDrawing.Position.set(ScreenDrawing.Anchor.Type.CENTER, 8 * 1 + 0, 8 * 13 + 6);
        ScreenDrawing.ComponentOverlay.drawImageSplit(168, 7, true, 24, (int) ((ScreenDrawing.player_local.clientLevel.dayTime() % 24000) / 1000), "tanscomplexmagic:textures/screens/gui_component_clock.png");
        ScreenDrawing.Position.set(ScreenDrawing.Anchor.Type.CENTER, 8 * 25 + 0, 8 * 15 + 0);

        ScreenDrawing.ComponentWidget.ButtonImage.draw(16, 8, true, true, false, "tanscomplexmagic:textures/screens/gui_component_close.png", () -> {

            NetworkManager.runServer("gui", "book_close", new CompoundTag());

        });

        // Page Number
        {

            StringBuilder page_left = new StringBuilder().append(number);
            StringBuilder page_right = new StringBuilder().append(number + 1);

            while (page_left.length() < 3) {

                page_left.insert(0, "0");

            }

            while (page_right.length() < 3) {

                page_right.insert(0, "0");

            }

            ScreenDrawing.Position.set(ScreenDrawing.Anchor.Type.CENTER, 8 * -21 + 1, 8 * 12 + 0);
            ScreenDrawing.ComponentOverlay.drawTextBasic(0.5, page_left.toString());
            ScreenDrawing.Position.set(ScreenDrawing.Anchor.Type.CENTER, 8 * 19 + 6, 8 * 12 + 0);
            ScreenDrawing.ComponentOverlay.drawTextBasic(0.5, page_right.toString());

        }

        // Compass
        {

            Vec3 destination_pos = new Vec3(0, 0, 0);
            int degree = 0;

            destination_pos = ScreenDrawing.player_local.clientLevel.getSharedSpawnPos().getCenter();
            degree = (int) OutsideUtils.Calculation.getDegreeDestinationX(ScreenDrawing.player_local.getYRot(), ScreenDrawing.player_local.getX(), ScreenDrawing.player_local.getZ(), destination_pos.x, destination_pos.z);
            degree = (int) Math.round(degree / 45.0);

            ScreenDrawing.Position.set(ScreenDrawing.Anchor.Type.CENTER, 8 * 2 - 0, 8 * 13 + 6);
            ScreenDrawing.ComponentOverlay.drawImageSplit(56, 7, true, 8, degree, "tanscomplexmagic:textures/screens/gui_component_compass.png");

            destination_pos = new Vec3(NBTManager.Mob.getNumber(ScreenDrawing.player_local, "book", "compassX"), 0, NBTManager.Mob.getNumber(ScreenDrawing.player_local, "book", "compassZ"));
            degree = (int) OutsideUtils.Calculation.getDegreeDestinationX(ScreenDrawing.player_local.getYRot(), ScreenDrawing.player_local.getX(), ScreenDrawing.player_local.getZ(), destination_pos.x, destination_pos.z);
            degree = (int) Math.round(degree / 45.0);

            ScreenDrawing.Position.set(ScreenDrawing.Anchor.Type.CENTER, 8 * 3 - 0, 8 * 13 + 6);
            ScreenDrawing.ComponentOverlay.drawImageSplit(56, 7, true, 8, degree, "tanscomplexmagic:textures/screens/gui_component_compass_custom.png");
            ScreenDrawing.Position.set(ScreenDrawing.Anchor.Type.CENTER, 8 * 4 + 0, 8 * 13 + 8);

            ScreenDrawing.ComponentWidget.ButtonImage.draw(6, 3, true, true, false, "tanscomplexmagic:textures/screens/gui_component_compass_custom_set.png", () -> {

                NetworkManager.runServer("gui", "book_custom_compass_set", new CompoundTag());

            });

        }

        // Log
        {

            int log = 0;

            if (NBTManager.Mob.getText(ScreenDrawing.player_local, "book", "log").equals("mana") == true) {

                log = 1;

            } else if (NBTManager.Mob.getText(ScreenDrawing.player_local, "book", "log").equals("action") == true) {

                log = 2;

            } else if (NBTManager.Mob.getText(ScreenDrawing.player_local, "book", "log").equals("warning") == true) {

                log = 3;

            }

            ScreenDrawing.Position.set(ScreenDrawing.Anchor.Type.CENTER, 8 * -23 - 4, 8 * 13 + 6);
            ScreenDrawing.ComponentOverlay.drawImageSplit(28, 7, true, 4, log, "tanscomplexmagic:textures/screens/gui_component_log_type.png");
            ScreenDrawing.Position.set(ScreenDrawing.Anchor.Type.CENTER, 8 * -23 - 4, 8 * 13 + 6);

            ScreenDrawing.ComponentWidget.ButtonImage.draw(14, 7, true, true, false, "tanscomplexmagic:textures/screens/gui_component_log_type_set.png", () -> {

                NetworkManager.runServer("gui", "book_log", new CompoundTag());

            });

        }

        // Page Turn
        {

            ScreenDrawing.Position.set(ScreenDrawing.Anchor.Type.CENTER, 8 * -23 - 4, 8 * 11 + 4);

            ScreenDrawing.ComponentWidget.ButtonImage.draw(32, 16, true, true, false, "tanscomplexmagic:textures/screens/gui_component_page_previous.png", () -> {

                NetworkManager.runServer("gui", "book_page_previous", new CompoundTag());

            });

            ScreenDrawing.Position.set(ScreenDrawing.Anchor.Type.CENTER, 8 * 22 - 4, 8 * 11 + 4);

            ScreenDrawing.ComponentWidget.ButtonImage.draw(32, 16, true, true, false, "tanscomplexmagic:textures/screens/gui_component_page_next.png", () -> {

                NetworkManager.runServer("gui", "book_page_next", new CompoundTag());

            });

        }

        // Book Mark
        {

            ScreenDrawing.Position.set(ScreenDrawing.Anchor.Type.CENTER, 8 * -27 + 0, 8 * -12 + 0);

            ScreenDrawing.ComponentWidget.ButtonImage.draw(24, 16, false, true, false, "tanscomplexmagic:textures/screens/icon_home.png", () -> {

                NetworkManager.runServer("gui", "book_mark_" + "home", new CompoundTag());

            });
            ScreenDrawing.Position.addZ(8);

            ScreenDrawing.ComponentWidget.ButtonImage.draw(24, 16, false, true, false, "tanscomplexmagic:textures/screens/gui_component_shortcut_ally_list.png", () -> {

                NetworkManager.runServer("gui", "book_mark_" + "ally_list_manager", new CompoundTag());

            });

            ScreenDrawing.Position.addZ(2);

            ScreenDrawing.ComponentWidget.ButtonImage.draw(24, 16, false, true, false, "tanscomplexmagic:textures/screens/gui_component_shortcut_basic_spells.png", () -> {

                NetworkManager.runServer("gui", "book_mark_" + "basic_spell", new CompoundTag());

            });

            ScreenDrawing.Position.addZ(2);

            ScreenDrawing.ComponentWidget.ButtonImage.draw(24, 16, false, true, false, "tanscomplexmagic:textures/screens/gui_component_shortcut_spell_control.png", () -> {

                NetworkManager.runServer("gui", "book_mark_" + "spell1_settings", new CompoundTag());

            });

            ScreenDrawing.Position.addZ(8);

            ScreenDrawing.ComponentWidget.ButtonImage.draw(24, 16, false, true, false, "tanscomplexmagic:textures/screens/gui_component_shortcut_custom.png", () -> {

                NetworkManager.runServer("gui", "book_mark_" + "home", new CompoundTag());

            });

        }

        // Mana Bar
        {

            ScreenDrawing.Position.set(ScreenDrawing.Anchor.Type.CENTER, 8 * 24 + 3, 8 * 5 + 6);
            ScreenDrawing.ComponentOverlay.drawImageSplit(61, 60, true, 61, (int) NBTManager.Mob.getNumber(ScreenDrawing.player_local, "main", "mana_charge"), "tanscomplexmagic:textures/screens/gui_component_mana_bar_charge.png");
            ScreenDrawing.Position.set(ScreenDrawing.Anchor.Type.CENTER, 8 * 24 + 3, 8 * -14 + 4);
            ScreenDrawing.ComponentOverlay.drawImageSplit(151, 150, true, 151, mana, "tanscomplexmagic:textures/screens/gui_component_mana_bar.png");

        }

    }
    
    private static void generateWikiCard () {
        
        
        
    }

    private static void generateSpell1SettingsCard (boolean is_page_left, String name, int number, int duration_per_mana_positive, int duration_per_mana_negative) {
        
        int mana = (int) NBTManager.Mob.getNumber(ScreenDrawing.player_local, "main", "mana");
        int posX = 0;

        if (is_page_left == true) {

            posX = 8 * -22 + 0;

        } else {

            posX = 8 * 2 + 0;

        }

        ScreenDrawing.Position.set(ScreenDrawing.Anchor.Type.CENTER, posX, 8 * -12 + 0);
        ScreenDrawing.ComponentOverlay.drawTextBasic(1, "Card Settings : " + name);
        ScreenDrawing.Position.addZ(8);
        ScreenDrawing.ComponentOverlay.drawTextBasic( ScreenDrawing.normal_font_scale, "§8Detected Targets : " + (int) NBTManager.Mob.getNumber(ScreenDrawing.player_local, "spell1", "number_of_targets_detected" + number));
        ScreenDrawing.Position.addZ(3);
        ScreenDrawing.ComponentOverlay.drawTextBasic(ScreenDrawing.normal_font_scale, "§8Remaining Duration : " + NBTManager.Mob.getText(ScreenDrawing.player_local, "spell1", "remaining_duration" + number));
        ScreenDrawing.Position.addZ(8);
        ScreenDrawing.Position.setMarkZ();
        ScreenDrawing.ComponentWidget.Switch.drawText("spell1", "is_card_enable" + number, "Enable");
        ScreenDrawing.Position.addZ(2);
        ScreenDrawing.ComponentWidget.Switch.drawText("spell1", "is_card_active" + number, "Activate Effect");
        ScreenDrawing.Position.returnMarkZ();
        ScreenDrawing.Position.setMarkX();
        ScreenDrawing.Position.addX(80);
        ScreenDrawing.ComponentWidget.Switch.drawText("spell1", "is_card_negative" + number, "Flip Card");
        ScreenDrawing.Position.addZ(2);
        ScreenDrawing.ComponentWidget.Switch.drawText("spell1", "is_card_high_power_mode" + number, "High Power Mode");
        ScreenDrawing.Position.returnMarkX();

        // Targets
        {

            ScreenDrawing.Position.addZ(8);
            ScreenDrawing.ComponentOverlay.drawTextBasic(ScreenDrawing.normal_font_scale, "Targets");
            ScreenDrawing.Position.addZ(4);

            boolean is_libra = number == 7;
            boolean is_libra_negative = NBTManager.Mob.getLogic(ScreenDrawing.player_local, "spell1", "is_card_negative7") == true;
            boolean is_libra_lock = is_libra == true && is_libra_negative == false;

            if (is_libra == false) {

                ScreenDrawing.ComponentWidget.Switch.drawText("spell1", "is_card_target_user" + number, "User");
                ScreenDrawing.Position.addZ(2);

            }

            ScreenDrawing.ComponentWidget.Switch.drawTextLockable(true, is_libra_lock == true, "spell1", "is_card_target_ally_player" + number, "Ally Player");
            ScreenDrawing.Position.addZ(2);
            ScreenDrawing.ComponentWidget.Switch.drawTextLockable(true, is_libra_lock == true, "spell1", "is_card_target_ally_non_player" + number, "Ally Non-Player");
            ScreenDrawing.Position.addZ(2);
            ScreenDrawing.ComponentWidget.Switch.drawTextLockable(true, is_libra_lock == true, "spell1", "is_card_target_enemy_player" + number, "Enemy Player");
            ScreenDrawing.Position.addZ(2);
            ScreenDrawing.ComponentWidget.Switch.drawTextLockable(true, is_libra_lock == true, "spell1", "is_card_target_enemy_non_player" + number, "Enemy Non-Player");
            ScreenDrawing.Position.addZ(2);
            ScreenDrawing.ComponentWidget.Switch.drawTextLockable(true, is_libra_lock == true, "spell1", "is_card_target_mark" + number, "Mark");

        }

        // Duration
        {

            ScreenDrawing.Position.setZ(26);
            ScreenDrawing.ComponentWidget.Slider.drawText(160, 0, NBTManager.Mob.getNumber(ScreenDrawing.player_local, "spell1", "card_duration_max_positive" + number), 1, "spell1", "card_duration_positive" + number, "Positive Duration");
            ScreenDrawing.Position.addZ(2);

            ScreenDrawing.ComponentWidget.ButtonTiny.drawTextLockable(160, true, mana < 1, "+" + duration_per_mana_positive + " / 1 Mana", "+" + duration_per_mana_positive + " / 1 Mana", () -> {

                CompoundTag tag = new CompoundTag();
                tag.putInt("number", number);
                tag.putString("positive_negative", "positive");
                tag.putInt("duration_per_mana", duration_per_mana_positive);
                NetworkManager.runServer("gui", "spell1_get_duration", tag);

            });

            ScreenDrawing.Position.addZ(8);
            ScreenDrawing.ComponentWidget.Slider.drawText(160, 0, NBTManager.Mob.getNumber(ScreenDrawing.player_local, "spell1", "card_duration_max_negative" + number), 1, "spell1", "card_duration_negative" + number, "Negative Duration");
            ScreenDrawing.Position.addZ(2);

            ScreenDrawing.ComponentWidget.ButtonTiny.drawTextLockable(160, true, mana < 1, "+" + duration_per_mana_negative + " / 1 Mana)", "+" + duration_per_mana_negative + " / 1 Mana", () -> {

                CompoundTag tag = new CompoundTag();
                tag.putInt("number", number);
                tag.putString("positive_negative", "negative");
                tag.putInt("duration_per_mana", duration_per_mana_positive);
                NetworkManager.runServer("gui", "spell1_get_duration", tag);

            });

        }

    }

}
