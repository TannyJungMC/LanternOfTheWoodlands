package tannyjung.tanscomplexmagic_handcode.systems;

import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import tannyjung.tanscomplexmagic_core.game.*;

import java.util.HashMap;
import java.util.Map;

public class Spell1 {

    public static void activate (ServerLevel level_server, ServerPlayer player_server) {

        Entity entity_main = EntityManager.summon(level_server, BlockPos.containing(GameUtils.Space.getPosRay(player_server, 200)).getCenter(), false, "minecraft:marker", "Main", Utils.Tag.convertSystem(player_server, new String[]{"main"}), "");

        if (entity_main == null) {

            return;

        }









        BlockPos pos = BlockPos.containing(GameUtils.Space.getPosRay(player_server, 200));

        if (level_server.getBlockState(pos).isAir() == false || level_server.getBlockState(pos.below()).isAir() == true) {

            return;

        }

        // Summon Cards
        {

            Entity entity_center = EntityManager.summon(level_server, entity_main.position().add(0, -0.5, 0), false, "minecraft:marker", "Zodiac Center", Utils.Tag.convertSystem(player_server, new String[]{"center"}), "");

            if (entity_center == null) {

                return;

            }

            int rotationY = (int) (Math.random() * 360);
            entity_center.setYRot(rotationY);

            int count = (int) (Math.random() * 13) + 1;

            for (int number = 1; number <= count; number++) {

                if (count == 1) {

                    number = (int) (Math.random() * 13) + 1;

                }

                EntityManager.Display.summonItem(level_server, entity_center.position(), rotationY + ((360 / count) * (number - 1)) + 180, 90, 0, true, "Zodiac Card " + number, Utils.Tag.convertSystem(player_server, new String[]{"spell1", "spell1_card", "spell1_card" + number}), "tanscomplexmagic:zodiac_card_" + number);

                if (count == 1) {

                    break;

                }

            }

        }

        double radius = NBTManager.Mob.getNumber(player_server, "spell1", "radius");
        GameUtils.spawnParticle(level_server, entity_main.position(), 0, 0, 0, 0, 1, "minecraft:flash");
        GameUtils.playSound(level_server, entity_main.blockPosition(), 0, radius * 5, "minecraft:entity.evoker.prepare_summon");
        GameUtils.playSound(level_server, entity_main.blockPosition(), 0, radius * 10, "minecraft:block.enchantment_table.use");

    }

    public static void deactivate (ServerLevel level_server, ServerPlayer player_server) {

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

        Entity entity_center = EntityManager.Get.fromEverywhereOne(level_server, "minecraft:marker", Utils.Tag.convertSystem(player_server, new String[]{"center"}));

        if (entity_center != null) {

            updateCenter(level_server, player_server, entity_main, entity_center);

        }

    }

    private static void updateCenter (ServerLevel level_server, ServerPlayer player_server, Entity entity_main, Entity entity_center) {

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

        // Position and Rotation
        {

            double height = 0.0;

            if (radius <= 10) {

                height = -0.475;

            } else {

                height = radius / 1.25;

            }

            entity_center.setPos(entity_main.position().add(0, height, 0));
            double rotation = 0.0;

            if (map_entity_card.size() == 1) {

                rotation = 1.75;

            } else {

                rotation = -0.025;

            }

            rotation = entity_center.getYRot() + rotation;

            if (rotation >= 360) {

                rotation = rotation - 360;

            }

            entity_center.setYRot((float) rotation);

        }

        for (Map.Entry<Integer, Entity> entry : map_entity_card.entrySet()) {

            // When Update Radius
            {

                if (NBTManager.Mob.getNumber(entry.getValue(), "", "radius_previous") != radius) {

                    NBTManager.Mob.setNumber(entry.getValue(), "", "radius_previous", radius);
                    setCardSize(player_server, entry.getValue());

                }

            }

            setCardPosition(player_server, entity_center, entry.getValue(), map_entity_card.size());
            setCardPose(level_server, player_server, entity_center, entry.getValue(), entry.getKey(), map_entity_card.size());

            if (NBTManager.Mob.getText(entry.getValue(), "", "status").equals("effect") == true) {

                int effect_tick = (int) NBTManager.Mob.getNumber(entry.getValue(), "", "effect_tick");

                if (effect_tick < 20) {

                    NBTManager.Mob.setNumber(entry.getValue(), "", "effect_tick", effect_tick + 1);

                } else {

                    NBTManager.Mob.setNumber(entry.getValue(), "", "effect_tick", 1);
                    giveEffect(level_server, player_server, entity_main, entry.getValue(), entry.getKey());

                }

                // Center Particle
                {

                    if (map_entity_card.size() == 1) {

                        GameUtils.spawnParticle(level_server, GameUtils.Space.getPosLook(entity_center, radius, 0, 0), 0, 0, 0, 0, 1, "minecraft:firework");
                        GameUtils.spawnParticle(level_server, GameUtils.Space.getPosLook(entity_center, -radius, 0, 0), 0, 0, 0, 0, 1, "minecraft:firework");
                        GameUtils.spawnParticle(level_server, GameUtils.Space.getPosLook(entity_center, 0, 0, radius), 0, 0, 0, 0, 1, "minecraft:firework");
                        GameUtils.spawnParticle(level_server, GameUtils.Space.getPosLook(entity_center, 0, 0, -radius), 0, 0, 0, 0, 1, "minecraft:firework");


                    }

                }

            }

            entity_center.setYRot(entity_center.getYRot() + (float) (360.0 / map_entity_card.size()));

            if (entity_center.getYRot() >= 360) {

                entity_center.setYRot(entity_center.getYRot() - 360);

            }

        }

    }

    private static void setCardPosition (ServerPlayer player_server, Entity entity_center, Entity entity_card, int card_count) {

        double radius = NBTManager.Mob.getNumber(player_server, "spell1", "radius");
        double far = 0.0;
        double height = 0.0;

        if (NBTManager.Mob.getText(entity_card, "", "status").isEmpty() == true) {

            far = radius * 1.25;

        } else {

            far = radius;
            height = radius / 4.0;

            if (radius > 10) {

                height = -height;

            }

        }

        if (card_count == 1) {

            entity_card.setPos(GameUtils.Space.getPosLook(entity_center, 0, height, 0));

        } else {

            entity_card.setPos(GameUtils.Space.getPosLook(entity_center, 0, height, far));

        }

    }

    private static void setCardPose (ServerLevel level_server, ServerPlayer player_server, Entity entity_center, Entity entity_card, int card_number, int card_count) {

        if (card_count == 1) {

            entity_card.setYRot((float) (entity_card.getYRot() + -0.5));

        } else {

            float rotX_save = entity_card.getXRot();
            entity_card.lookAt(EntityAnchorArgument.Anchor.FEET, entity_center.position());
            entity_card.setXRot(rotX_save);

        }

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

                    if (tick < 10) {

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
        int apply_min_duration = 0;
        int duration = 0;
        int level = 0;

        // Effects
        {

            boolean is_positive = entity_card.getXRot() == 0;

            if (card_number == 1) {

                {

                    if (is_positive == true) {

                        effect = "minecraft:night_vision";
                        apply_min_duration = 12;
                        duration = 1;
                        level = 0;

                    } else {

                        effect = "minecraft:blindness";
                        apply_min_duration = 2;
                        duration = 3;
                        level = 0;

                    }

                }

            } else if (card_number == 2) {

                {

                    if (is_positive == true) {

                        effect = "minecraft:resistance";
                        apply_min_duration = 2;
                        duration = 3;
                        level = 0;

                    } else {

                        effect = "minecraft:nausea";
                        apply_min_duration = 5;
                        duration = 1;
                        level = 0;

                    }

                }

            } else if (card_number == 3) {

                {

                    if (is_positive == true) {

                        effect = "minecraft:haste";
                        apply_min_duration = 2;
                        duration = 1;
                        level = 0;

                    } else {

                        effect = "minecraft:mining_fatigue";
                        apply_min_duration = 2;
                        duration = 1;
                        level = 0;

                    }

                }

            } else if (card_number == 4) {

                {

                    if (is_positive == true) {

                        effect = "minecraft:luck";
                        apply_min_duration = 2;
                        duration = 1;
                        level = 0;

                    } else {

                        effect = "minecraft:unluck";
                        apply_min_duration = 2;
                        duration = 1;
                        level = 0;

                    }

                }

            } else if (card_number == 5) {

                {

                    if (is_positive == true) {

                        effect = "minecraft:hero_of_the_village";
                        apply_min_duration = 2;
                        duration = 1;
                        level = 0;

                    } else {

                        effect = "minecraft:bad_omen";
                        apply_min_duration = 2;
                        duration = 1;
                        level = 0;

                    }

                }

            } else if (card_number == 6) {

                {

                    if (is_positive == true) {

                        effect = "minecraft:invisibility";
                        apply_min_duration = 2;
                        duration = 1;
                        level = 0;

                    } else {

                        effect = "minecraft:glowing";
                        apply_min_duration = 2;
                        duration = 1;
                        level = 0;

                    }

                }

            } else if (card_number == 7) {

                {

                    if (is_positive == true) {

                        effect = "clear";
                        duration = 1;
                        level = 0;

                    } else {

                        effect = "share";
                        duration = 1;
                        level = 0;

                    }

                }

            } else if (card_number == 8) {

                {

                    if (is_positive == true) {

                        effect = "minecraft:fire_resistance";
                        apply_min_duration = 2;
                        duration = 1;
                        level = 0;

                    } else {

                        effect = "fire";
                        duration = 2;
                        level = 0;

                    }

                }

            } else if (card_number == 9) {

                {

                    if (is_positive == true) {

                        effect = "minecraft:speed";
                        apply_min_duration = 2;
                        duration = 1;
                        level = 0;

                    } else {

                        effect = "minecraft:slowness";
                        apply_min_duration = 2;
                        duration = 1;
                        level = 0;

                    }

                }

            } else if (card_number == 10) {

                {

                    if (is_positive == true) {

                        effect = "minecraft:strength";
                        apply_min_duration = 2;
                        duration = 1;
                        level = 0;

                    } else {

                        effect = "minecraft:weakness";
                        apply_min_duration = 2;
                        duration = 1;
                        level = 0;

                    }

                }

            } else if (card_number == 11) {

                {

                    if (is_positive == true) {

                        effect = "minecraft:slow_falling";
                        apply_min_duration = 2;
                        duration = 1;
                        level = 0;

                    } else {

                        effect = "minecraft:levitation";
                        apply_min_duration = 2;
                        duration = 1;
                        level = 0;

                    }

                }

            } else if (card_number == 12) {

                {

                    if (is_positive == true) {

                        effect = "minecraft:water_breathing";
                        apply_min_duration = 2;
                        duration = 1;
                        level = 0;

                    } else {

                        effect = "fear_water";
                        duration = 1;
                        level = 0;

                    }

                }

            } else if (card_number == 13) {

                {

                    if (is_positive == true) {

                        effect = "minecraft:regeneration";
                        apply_min_duration = 2;
                        duration = 1;
                        level = 0;

                    } else {

                        effect = "minecraft:poison";
                        apply_min_duration = 2;
                        duration = 1;
                        level = 0;

                    }

                }

            }

        }

        double radius = NBTManager.Mob.getNumber(player_server, "spell1", "radius");

        for (Entity entity : EntityManager.Get.fromArea(level_server, entity_main.position(), radius, false, "", new String[]{})) {

            if (effect.startsWith("minecraft:") == true) {

                if (EffectManager.has(level_server, entity, effect, apply_min_duration, 0) == false) {

                    EffectManager.give(level_server, entity, effect, apply_min_duration + duration, level);

                }

            } else {

                // Special Effects
                {

                    if (effect.equals("clear") == true) {

                        EffectManager.clearAll(entity);

                    } else if (effect.equals("share") == true) {

                        if (player_server != entity) {

                            EffectManager.copyAll(player_server, entity);

                        }

                    } else if (effect.equals("fire") == true) {

                        entity.setRemainingFireTicks(20 * duration);

                    } else if (effect.equals("fear_water") == true) {

                        if (entity.isUnderWater() == true) {

                            GameUtils.runCommandEntity(entity, "damage @s 1 minecraft:drown");

                        }

                    }

                }

            }

        }

    }

}
