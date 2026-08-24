package tannyjung.tanscomplexmagic_handcode.core;

import tannyjung.tanscomplexmagic_core.game.NBTManager;
import tannyjung.tanscomplexmagic_core.game.screen.ScreenDrawing;

public class Overlays {
    
    public static void eventMenu () {



    }

    public static void eventInGame () {

        {

            if (NBTManager.Mob.getLogic(ScreenDrawing.player_local, "spell1", "is_active") == true && NBTManager.Mob.getLogic(ScreenDrawing.player_local, "spell1", "is_overlay_enable") == true) {

                ScreenDrawing.Position.set(ScreenDrawing.Anchor.Type.TOP_LEFT, 10, 50);
                ScreenDrawing.ComponentOverlay.drawTextBasic(0.4, "§fPause All Cards (" + NBTManager.Mob.getLogic(ScreenDrawing.player_local, "spell1", "is_pause_all") + ")");
                ScreenDrawing.Position.addZ(2);
                ScreenDrawing.ComponentOverlay.drawTextBasic(0.4, "§fRadius (" + (int) NBTManager.Mob.getNumber(ScreenDrawing.player_local, "spell1", "radius") + ")");
                ScreenDrawing.Position.addZ(8);

                // Cards
                {

                    String status = "";

                    for (int number = 1; number <= 13; number++) {

                        if (NBTManager.Mob.getLogic(ScreenDrawing.player_local, "spell1", "is_card_enable" + number) == false) {

                            continue;

                        }

                        ScreenDrawing.ComponentOverlay.drawImageBasic(12, 12, "tanscomplexmagic:textures/block/zodiac_card" + number + ".png");
                        ScreenDrawing.Position.setMark();
                        ScreenDrawing.Position.add(10, 2);
                        ScreenDrawing.ComponentOverlay.drawTextBasic(0.4, "§f" + (int) NBTManager.Mob.getNumber(ScreenDrawing.player_local, "spell1", "number_of_targets_detected" + number));

                        if (NBTManager.Mob.getLogic(ScreenDrawing.player_local, "spell1", "is_card_active" + number) == true) {

                            status = NBTManager.Mob.getText(ScreenDrawing.player_local, "spell1", "card_status" + number);

                            if (status.equals("effect") == true) {

                                status = "§a*";

                            } else if (status.equals("flip") == true) {

                                status = "§e*";

                            } else {

                                status = "§c*";

                            }

                        } else {

                            status = "";

                        }

                        ScreenDrawing.Position.addZ(2);
                        ScreenDrawing.ComponentOverlay.drawTextBasic(0.4, "§f" + NBTManager.Mob.getText(ScreenDrawing.player_local, "spell1", "remaining_duration" + number) + " " + status);
                        ScreenDrawing.Position.returnMark();
                        ScreenDrawing.Position.addZ(15);

                    }

                }

            }

        }

    }

}
