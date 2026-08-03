package tannyjung.tanscomplexmagic_handcode.systems;

import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import tannyjung.tanscomplexmagic_core.game.EffectManager;
import tannyjung.tanscomplexmagic_core.game.EntityManager;
import tannyjung.tanscomplexmagic_core.game.GameUtils;
import tannyjung.tanscomplexmagic_core.game.NBTManager;

import java.util.HashMap;
import java.util.Map;

public class Spell1 {

    public static void start (ServerLevel level_server, ServerPlayer player_server) {

        BlockPos pos = BlockPos.containing(GameUtils.Space.getPosRay(player_server, 100));

        if (level_server.getBlockState(pos).isAir() == false || level_server.getBlockState(pos.below()).isAir() == true) {

            return;

        }

        Vec3 vec3 = pos.getCenter();






        Entity entity_main = EntityManager.summon(level_server, vec3, false, "minecraft:marker", "Main", Utils.Tag.convertSystem(player_server, new String[]{"main"}), "");

        if (entity_main == null) {

            return;

        }

        for (int number = 1; number <= 13; number++) {

            if (Math.random() > 1.0) {

                continue;

            }

            EntityManager.Display.summonItem(level_server, entity_main.position().add(0.0, -0.5, 0.0), ((360 / 13) * number) + 180 - 15, 90, 0, true, "Zodiac Card " + number, Utils.Tag.convertSystem(player_server, new String[]{"spell1", "spell1_card", "spell1_card" + number}), "tanscomplexmagic:zodiac_card_" + number);

        }

        double radius = NBTManager.Mob.getNumber(player_server, "spell1", "radius");
        GameUtils.spawnParticle(level_server, entity_main.position(), 0, 0, 0, 0, 1, "minecraft:flash");
        GameUtils.playSound(level_server, entity_main.blockPosition(), 0, radius * 5, "minecraft:entity.evoker.prepare_summon");
        GameUtils.playSound(level_server, entity_main.blockPosition(), 0, radius * 10, "minecraft:block.enchantment_table.use");

    }

    public static void cancel (ServerLevel level_server, ServerPlayer player_server) {

        double radius = NBTManager.Mob.getNumber(player_server, "spell1", "radius");

        for (Entity entity : EntityManager.Get.fromEverywhere(level_server, "minecraft:item_display", Utils.Tag.convertSystem(player_server, new String[]{"spell1_card"}))) {

            GameUtils.spawnParticle(level_server, entity.position(), 0, 0, 0, 0, 1, "minecraft:flash");
            GameUtils.playSound(level_server, entity.blockPosition(), 0, radius * 4, "minecraft:entity.evoker.cast_spell");

        }

        for (Entity entity : EntityManager.Get.fromEverywhere(level_server, "", Utils.Tag.convertSystemAll(player_server))) {

            entity.discard();

        }

    }

    public static void tick (ServerLevel level_server, ServerPlayer player_server) {

        Entity entity_main = EntityManager.Get.fromEverywhereOne(level_server, "minecraft:marker", Utils.Tag.convertSystem(player_server, new String[]{"main"}));

        if (entity_main == null) {

            return;

        }

        entity_main.setYRot(entity_main.getYRot() + (float) 0.05);

        updateCard(level_server, player_server, entity_main);

    }

    private static void updateCard (ServerLevel level_server, ServerPlayer player_server, Entity entity_main) {

        Map<Integer, Entity> map_entity_card = new HashMap<>();

        // Import Card
        {

            Entity entity = null;

            for (int number = 1; number <= 13; number++) {

                entity = EntityManager.Get.fromEverywhereOne(level_server, "minecraft:item_display", Utils.Tag.convertSystem(player_server, new String[]{"spell1_card" + number}));

                if (entity != null) {

                    map_entity_card.put(number, entity);

                }

            }

        }

        double radius = NBTManager.Mob.getNumber(player_server, "spell1", "radius");

        for (Map.Entry<Integer, Entity> entry : map_entity_card.entrySet()) {

            // When Update Radius
            {

                if (NBTManager.Mob.getNumber(entry.getValue(), "", "radius_previous") != radius) {

                    NBTManager.Mob.setNumber(entry.getValue(), "", "radius_previous", radius);
                    setCardSize(player_server, entry.getValue());

                }

            }

            setCardPosition(player_server, entity_main, entry.getValue(), map_entity_card.size());
            setCardPose(level_server, player_server, entity_main, entry.getValue(), entry.getKey());

            if (NBTManager.Mob.getText(entry.getValue(), "", "status").equals("effect") == true) {

                int effect_tick = (int) NBTManager.Mob.getNumber(entry.getValue(), "", "effect_tick");

                if (effect_tick < 20) {

                    NBTManager.Mob.setNumber(entry.getValue(), "", "effect_tick", effect_tick + 1);

                } else {

                    NBTManager.Mob.setNumber(entry.getValue(), "", "effect_tick", 1);
                    giveEffect(level_server, player_server, entity_main, entry.getValue(), entry.getKey());

                }

            }

        }

    }

    private static void setCardPosition (ServerPlayer player_server, Entity entity_main, Entity entity_card, int card_count) {

        double radius = NBTManager.Mob.getNumber(player_server, "spell1", "radius");
        double height = 0.0;

        if (NBTManager.Mob.getText(entity_card, "", "status").isEmpty() == true) {

            if (radius <= 10) {

                height = 0.1;

            } else {

                height = (radius / 100.0) * 95;

            }

        } else {

            if (radius <= 10) {

                height = radius / 4;

            } else {

                height = radius / 1.5;

            }

        }

        entity_card.setPos(GameUtils.Space.getPosLook(entity_main, 0, height - 0.5, radius));
        entity_main.setYRot(entity_main.getYRot() + (float) (360.0 / card_count));

        if (entity_main.getYRot() >= 360) {

            entity_main.setYRot(entity_main.getYRot() - 360);

        }

    }

    private static void setCardPose (ServerLevel level_server, ServerPlayer player_server, Entity entity_main, Entity entity_card, int card_number) {

        float rotX_save = entity_card.getXRot();
        entity_card.lookAt(EntityAnchorArgument.Anchor.FEET, entity_main.position());
        entity_card.setXRot(rotX_save);

        int degree_set = 90;

        if (NBTManager.Mob.getLogic(player_server, "spell1", "pause") == false) {

            if (NBTManager.Mob.getLogic(player_server, "spell1", "is_enable" + card_number) == true) {

                if (NBTManager.Mob.getLogic(player_server, "spell1", "is_negative" + card_number) == true) {

                    degree_set = -180;

                } else {

                    degree_set = 0;

                }

            }

        }

        if (entity_card.getXRot() != degree_set) {

            // Flipping
            {

                double radius = NBTManager.Mob.getNumber(player_server, "spell1", "radius");
                double sound_distance = radius + 2.5;

                if (NBTManager.Mob.getText(entity_card, "", "status").equals("flip") == false) {

                    // At Start of Flipping
                    {

                        NBTManager.Mob.setText(entity_card, "", "status", "flip");

                        if (entity_card.getXRot() != 90) {

                            GameUtils.playSound(level_server, entity_card.blockPosition(), (Math.random() * 0.5) + 0.5, sound_distance * 5.0, "minecraft:block.bell.use");

                        } else {

                            GameUtils.playSound(level_server, entity_card.blockPosition(), (Math.random() * 0.5) + 0.5, sound_distance * 5.0, "minecraft:block.ender_chest.open");

                        }

                    }

                }

                // Add Degree
                {

                    double degree = 1.0 - (radius / 200.0);
                    degree = (degree * 0.6) + 0.4;

                    if (entity_card.getXRot() > degree_set && entity_card.getXRot() - (float) degree > degree_set) {

                        entity_card.setXRot(entity_card.getXRot() - (float) degree);

                    } else if (entity_card.getXRot() < degree_set && entity_card.getXRot() + (float) degree < degree_set) {

                        entity_card.setXRot(entity_card.getXRot() + (float) degree);

                    } else {

                        entity_card.setXRot((float) degree_set);

                    }

                }

                // Gear Sound
                {

                    int tick = (int) NBTManager.Mob.getNumber(entity_card, "", "gear_sound_tick");

                    if (tick < 13) {

                        NBTManager.Mob.setNumber(entity_card, "", "gear_sound_tick", tick + 1);

                    } else {

                        NBTManager.Mob.setNumber(entity_card, "", "gear_sound_tick", 1);
                        GameUtils.playSound(level_server, entity_card.blockPosition(), 0, sound_distance * 5.0, "minecraft:block.wooden_door.open");


                    }

                }

                if (entity_card.getXRot() == degree_set || entity_card.getXRot() == -180) {

                    // Finish Flipping
                    {

                        if (degree_set == 90) {

                            NBTManager.Mob.setText(entity_card, "", "status", "");
                            GameUtils.playSound(level_server, entity_card.blockPosition(), (Math.random() * 0.5) + 0.5, sound_distance * 5.0, "minecraft:block.note_block.chime");

                        } else {

                            NBTManager.Mob.setText(entity_card, "", "status", "effect");
                            GameUtils.playSound(level_server, entity_card.blockPosition(), 0, sound_distance * 5.0, "minecraft:block.iron_door.open");

                        }

                    }

                }

            }

        }

    }

    private static void setCardSize (ServerPlayer player_server, Entity entity_card) {

        double scale = NBTManager.Mob.getNumber(player_server, "spell1", "radius") / 5.0;
        EntityManager.Display.setItemScale(entity_card, scale);

    }

    private static void giveEffect (ServerLevel level_server, ServerPlayer player_server, Entity entity_main, Entity entity_card, int card_number) {

        String effect = "";
        int duration = 0;
        int level = 0;

        // Effects
        {

            boolean is_positive = entity_card.getXRot() == 0;

            if (card_number == 1) {

                {

                    if (is_positive == true) {

                        effect = "glowing";
                        duration = 2;
                        level = 1;

                    } else {

                        effect = "speed";
                        duration = 2;
                        level = 5;

                    }

                }

            }

        }

        if (effect.isEmpty() == false) {

            double radius = NBTManager.Mob.getNumber(player_server, "spell1", "radius");

            for (Entity entity : EntityManager.Get.fromArea(level_server, entity_main.position(), radius, false, "", new String[]{})) {

                if (EffectManager.has(level_server, entity, effect, 3, 0) == false) {

                    EffectManager.give(level_server, entity, effect, duration, level);

                }

            }

        }

    }

}
