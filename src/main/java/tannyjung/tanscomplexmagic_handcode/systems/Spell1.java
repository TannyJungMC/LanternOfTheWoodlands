package tannyjung.tanscomplexmagic_handcode.systems;

import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import tannyjung.tanscomplexmagic_core.Core;
import tannyjung.tanscomplexmagic_core.game.*;

import java.util.*;

public class Spell1 {

    public static void activate (ServerLevel level_server, ServerPlayer player_server) {

        BlockPos pos = BlockPos.containing(GameUtils.Space.getPosRay(player_server, 200));

        if (level_server.getBlockState(pos).isAir() == false || level_server.getBlockState(pos.below()).isAir() == true) {

            return;

        }

        Entity entity_main = EntityManager.summon(level_server, pos.getCenter(), false, "minecraft:marker", "Main", Utils.Tag.convertSystemSpecific(player_server, new String[]{"main"}), "");

        if (entity_main == null) {

            return;

        }

        Entity entity_center = EntityManager.summon(level_server, entity_main.position().add(0, -0.5, 0), false, "minecraft:marker", "Zodiac Center", Utils.Tag.convertSystemSpecific(player_server, new String[]{"center"}), "");

        if (entity_center == null) {

            return;

        }

        Card.summonAll(level_server, player_server, entity_center);

    }

    public static void deactivate (ServerLevel level_server, ServerPlayer player_server) {

        Card.removeAll(level_server, player_server);

    }

    public static void tick (ServerLevel level_server, ServerPlayer player_server) {

        Entity entity_main = EntityManager.Get.fromEverywhereOne(level_server, "minecraft:marker", Utils.Tag.convertSystemSpecific(player_server, new String[]{"main"}));

        if (entity_main == null) {

            return;

        }

        Entity entity_center = EntityManager.Get.fromEverywhereOne(level_server, "minecraft:marker", Utils.Tag.convertSystemSpecific(player_server, new String[]{"center"}));

        if (entity_center == null) {

            return;

        }

        Map<Integer, Entity> cards = Card.getActive(level_server, player_server);
        updateCenter(entity_center, cards.size() == 1);
        Card.update(level_server, player_server, entity_center, cards);

    }

    private static void updateCenter (Entity entity_center, boolean is_card_single) {

        double rotation = 0.0;

        if (is_card_single == true) {

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

    private static void giveEffect (ServerLevel level_server, ServerPlayer player_server, Entity entity, int card_number, boolean is_negative, int level) {

        if (card_number == 1) {

            {

                if (is_negative == false) {

                    if (EffectManager.hasDuration(level_server, entity, "minecraft:night_vision", 12) == false) {

                        if (EffectManager.has(level_server, entity, "minecraft:night_vision") == false) {

                            EffectManager.give(level_server, entity, "minecraft:blindness", 1, 0);
                            GameUtils.playSound(level_server, entity.blockPosition(), 0.75, 20, "minecraft:entity.goat.ambient");
                            GameUtils.playSound(level_server, entity.blockPosition(), 0.75, 20, "minecraft:block.beacon.power_select");

                        }

                        EffectManager.give(level_server, entity, "minecraft:night_vision", 12, 1);

                    }

                } else {

                    if (EffectManager.hasDuration(level_server, entity, "minecraft:blindness", 2) == false) {

                        if (EffectManager.has(level_server, entity, "minecraft:blindness") == false) {

                            GameUtils.playSound(level_server, entity.blockPosition(), 0, 20, "minecraft:entity.allay.death");
                            GameUtils.playSound(level_server, entity.blockPosition(), 1.25, 20, "minecraft:entity.illusioner.cast_spell");

                        }

                        if (Math.random() < 0.25) GameUtils.playSound(level_server, entity.blockPosition(), 0, 20, "minecraft:entity.goat.ambient");
                        if (Math.random() < 0.1) GameUtils.playSound(level_server, entity.blockPosition(), 0, 20, "minecraft:ambient.cave");

                        GameUtils.spawnParticle(level_server, entity.getEyePosition(), 1, 1, 1, 0, 5, "minecraft:campfire_cosy_smoke");
                        EffectManager.give(level_server, entity, "minecraft:blindness", 2, 1);

                        EntityManager.setTarget(entity, null);
                        EntityManager.moveTo(entity, entity.position().add(10.0 - (Math.random() * 20.0), 10.0 - (Math.random() * 20.0), 10.0 - (Math.random() * 20.0)), 1.5);

                    }

                }

            }

        } else if (card_number == 2) {

            {

                if (is_negative == false) {

                    if (EffectManager.hasDuration(level_server, entity, "minecraft:resistance", 2) == false) {

                        if (EffectManager.has(level_server, entity, "minecraft:resistance") == false) {

                            GameUtils.playSound(level_server, entity.blockPosition(), 0, 20, "minecraft:entity.zombie_horse.ambient");
                            GameUtils.playSound(level_server, entity.blockPosition(), 0, 20, "minecraft:block.amethyst_block.resonate");

                        }

                        EffectManager.give(level_server, entity, "minecraft:resistance", 2, (level * 2) - 1);

                    }

                } else {

                    if (EffectManager.hasDuration(level_server, entity, "minecraft:nausea", 5) == false) {

                        if (EffectManager.has(level_server, entity, "minecraft:nausea") == false) {

                            GameUtils.playSound(level_server, entity.blockPosition(), 0, 20, "minecraft:entity.ravager.death");

                        }

                        EffectManager.give(level_server, entity, "minecraft:nausea", 5, 1);
                        GameUtils.playSound(level_server, entity.blockPosition(), (Math.random() * 0.25) + 0.5, 20, "minecraft:entity.ghast.ambient");

                        if (Math.random() < 0.25) {

                            GameUtils.playSound(level_server, entity.blockPosition(), (Math.random() * 1.5) + 0.5, 10, "minecraft:ambient.cave");

                        }

                    }

                }

            }

        } else if (card_number == 3) {

            {

                if (is_negative == false) {

                    if (EffectManager.hasDuration(level_server, entity, "minecraft:haste", 2) == false) {

                        if (EffectManager.has(level_server, entity, "minecraft:haste") == false) {

                            GameUtils.playSound(level_server, entity.blockPosition(), 0, 20, "minecraft:entity.allay.ambient_with_item");

                        }

                        EffectManager.give(level_server, entity, "minecraft:haste", 2, (level * 3) - 1);

                    }

                } else {

                    if (EffectManager.hasDuration(level_server, entity, "minecraft:mining_fatigue", 2) == false) {

                        if (EffectManager.has(level_server, entity, "minecraft:mining_fatigue") == false) {

                            GameUtils.playSound(level_server, entity.blockPosition(), 0, 20, "minecraft:entity.allay.ambient_without_item");

                        }

                        EffectManager.give(level_server, entity, "minecraft:mining_fatigue", 2, (level * 3) - 1);

                    }

                }

            }

        } else if (card_number == 4) {

            {

                if (is_negative == false) {

                    if (EffectManager.hasDuration(level_server, entity, "minecraft:luck", 2) == false) {

                        if (EffectManager.has(level_server, entity, "minecraft:luck") == false) {

                            GameUtils.playSound(level_server, entity.blockPosition(), 0, 20, "minecraft:entity.stray.step");
                            GameUtils.playSound(level_server, entity.blockPosition(), 0, 20, "minecraft:block.beacon.power_select");
                            GameUtils.playSound(level_server, entity.blockPosition(), 1, 20, "minecraft:block.beacon.power_select");
                            GameUtils.spawnParticle(level_server, entity.position().add(0, 1, 0), 1, 1, 1, 0, 10, "minecraft:happy_villager");

                        }

                        EffectManager.give(level_server, entity, "minecraft:luck", 2, 1);

                    }

                } else {

                    if (EffectManager.hasDuration(level_server, entity, "minecraft:unluck", 2) == false) {

                        if (EffectManager.has(level_server, entity, "minecraft:unluck") == false) {

                            GameUtils.playSound(level_server, entity.blockPosition(), 0, 20, "minecraft:entity.stray.hurt");
                            GameUtils.playSound(level_server, entity.blockPosition(), 0, 20, "minecraft:block.beacon.power_select");
                            GameUtils.playSound(level_server, entity.blockPosition(), 1, 20, "minecraft:block.beacon.power_select");
                            GameUtils.spawnParticle(level_server, entity.position().add(0, 1, 0), 1, 1, 1, 0, 10, "minecraft:happy_villager");

                        }

                        EffectManager.give(level_server, entity, "minecraft:unluck", 2, 1);

                    }

                }

            }

        } else if (card_number == 5) {

            {

                if (is_negative == false) {

                    if (EffectManager.hasDuration(level_server, entity, "minecraft:hero_of_the_village", 2) == false) {

                        if (EffectManager.has(level_server, entity, "minecraft:hero_of_the_village") == false) {

                            GameUtils.playSound(level_server, entity.blockPosition(), 0, 20, "minecraft:entity.warden.roar");
                            GameUtils.playSound(level_server, entity.blockPosition(), 0, 20, "minecraft:block.beacon.power_select");
                            GameUtils.playSound(level_server, entity.blockPosition(), 0, 10, "minecraft:entity.player.levelup");

                        }

                        EffectManager.give(level_server, entity, "minecraft:hero_of_the_village", 2, 1);

                    }

                } else {

                    if (EffectManager.hasDuration(level_server, entity, "minecraft:bad_omen", 2) == false) {

                        if (EffectManager.has(level_server, entity, "minecraft:bad_omen") == false) {

                            GameUtils.playSound(level_server, entity.blockPosition(), 0, 20, "minecraft:entity.warden.roar");
                            GameUtils.playSound(level_server, entity.blockPosition(), 0, 20, "minecraft:block.beacon.power_select");
                            GameUtils.playSound(level_server, entity.blockPosition(), 0.75, 20, "minecraft:entity.evoker.prepare_attack");

                        }

                        EffectManager.give(level_server, entity, "minecraft:bad_omen", 2, 1);

                    }

                }

            }

        } else if (card_number == 6) {

            {

                if (is_negative == false) {

                    if (EffectManager.hasDuration(level_server, entity, "minecraft:invisibility", 2) == false) {

                        if (EffectManager.has(level_server, entity, "minecraft:invisibility") == false) {

                            GameUtils.playSound(level_server, entity.blockPosition(), 0.75, 20, "minecraft:entity.illusioner.mirror_move");
                            GameUtils.playSound(level_server, entity.blockPosition(), 0.75, 20, "minecraft:block.enchantment_table.use");
                            GameUtils.spawnParticle(level_server, entity.position().add(0, 1, 0), 1, 1, 1, 0, 10, "minecraft:campfire_signal_smoke");

                        }

                        EffectManager.give(level_server, entity, "minecraft:invisibility", 2, 1);

                    }

                } else {

                    if (EffectManager.hasDuration(level_server, entity, "minecraft:glowing", 2) == false) {

                        if (EffectManager.has(level_server, entity, "minecraft:glowing") == false) {

                            GameUtils.playSound(level_server, entity.blockPosition(), 2, 20, "minecraft:block.amethyst_block.fall");

                        }

                        EffectManager.give(level_server, entity, "minecraft:glowing", 2, 1);
                        GameUtils.spawnParticle(level_server, entity.position().add(0, 1, 0), 1, 1, 1, 0, 1, "minecraft:firework");

                    }

                }

            }

        } else if (card_number == 7) {

            {

                if (is_negative == false) {

                    Core.DelayedWork.create(false, 1, () -> {

                        if (EffectManager.clearAll(entity) == true) {

                            GameUtils.playSound(level_server, entity.blockPosition(), 0, 20, "minecraft:block.enchantment_table.use");
                            GameUtils.playSound(level_server, entity.blockPosition(), 0.75, 20, "minecraft:block.beacon.power_select");
                            GameUtils.spawnParticle(level_server, entity.position().add(0, 1, 0), 1, 1, 1, 0.1, 10, "minecraft:end_rod");

                        }

                    });

                } else {

                    if (player_server != entity) {

                        EffectManager.copyAll(player_server, entity);

                    }

                    GameUtils.playSound(level_server, entity.blockPosition(), Math.random() + 1.0, 10, "minecraft:block.beacon.ambient");

                }

            }

        } else if (card_number == 8) {

            {

                if (is_negative == false) {

                    if (EffectManager.hasDuration(level_server, entity, "minecraft:fire_resistance", 2) == false) {

                        if (EffectManager.has(level_server, entity, "minecraft:fire_resistance") == false) {

                            GameUtils.playSound(level_server, entity.blockPosition(), 0.75, 20, "minecraft:entity.silverfish.ambient");
                            GameUtils.playSound(level_server, entity.blockPosition(), 0, 20, "minecraft:entity.illusioner.prepare_blindness");
                            GameUtils.spawnParticle(level_server, entity.position().add(0, 1, 0), 1, 1, 1, 0, 10, "minecraft:flame");

                        }

                        EffectManager.give(level_server, entity, "minecraft:fire_resistance", 2, 1);

                    }

                } else {

                    entity.setRemainingFireTicks(20 * 1);
                    GameUtils.playSound(level_server, entity.blockPosition(), 0, 20, "minecraft:entity.skeleton_horse.ambient");
                    GameUtils.playSound(level_server, entity.blockPosition(), 1, 20, "minecraft:entity.blaze.burn");

                }

            }

        } else if (card_number == 9) {

            {

                if (is_negative == false) {

                    if (EffectManager.hasDuration(level_server, entity, "minecraft:speed", 2) == false) {

                        if (EffectManager.has(level_server, entity, "minecraft:speed") == false) {

                            GameUtils.playSound(level_server, entity.blockPosition(), 1.5, 20, "minecraft:item.trident.thunder");
                            GameUtils.playSound(level_server, entity.blockPosition(), 2, 20, "minecraft:item.trident.thunder");
                            GameUtils.spawnParticle(level_server, entity.position().add(0, 1, 0), 1, 1, 1, 0.1, 20, "minecraft:reverse_portal");

                        }

                        EffectManager.give(level_server, entity, "minecraft:speed", 3, 9);
                        EffectManager.give(level_server, entity, "minecraft:jump_boost", 3, 9);

                    }

                } else {

                    if (EffectManager.hasDuration(level_server, entity, "minecraft:slowness", 2) == false) {

                        EffectManager.give(level_server, entity, "minecraft:slowness", 2, 2);
                        GameUtils.spawnParticle(level_server, entity.position().add(0, 1, 0), 1, 1, 1, 0.1, 1, "minecraft:reverse_portal");

                        if (Math.random() < 0.25) {

                            GameUtils.playSound(level_server, entity.blockPosition(), 0, 20, "minecraft:ambient.crimson_forest.mood");

                        }

                    }

                }

            }

        } else if (card_number == 10) {

            {

                if (is_negative == false) {

                    if (EffectManager.hasDuration(level_server, entity, "minecraft:strength", 2) == false) {

                        if (EffectManager.has(level_server, entity, "minecraft:strength") == false) {

                            GameUtils.playSound(level_server, entity.blockPosition(), 0, 20, "minecraft:entity.player.breath");
                            GameUtils.playSound(level_server, entity.blockPosition(), 0, 20, "minecraft:block.enchantment_table.use");
                            GameUtils.spawnParticle(level_server, entity.position().add(0, 1, 0), 1, 1, 1, 1, 10, "minecraft:enchant");

                        }

                        EffectManager.give(level_server, entity, "minecraft:strength", 2, 1);

                    }

                } else {

                    if (EffectManager.hasDuration(level_server, entity, "minecraft:weakness", 2) == false) {

                        if (EffectManager.has(level_server, entity, "minecraft:weakness") == false) {

                            GameUtils.playSound(level_server, entity.blockPosition(), 0, 20, "minecraft:entity.wither.ambient");
                            GameUtils.playSound(level_server, entity.blockPosition(), 0, 20, "minecraft:block.beacon.power_select");
                            GameUtils.spawnParticle(level_server, entity.position().add(0, 1, 0), 1, 1, 1, 1, 10, "minecraft:enchant");

                        }

                        EffectManager.give(level_server, entity, "minecraft:weakness", 2, 1);

                    }

                }

            }

        } else if (card_number == 11) {

            {

                if (is_negative == false) {

                    if (EffectManager.hasDuration(level_server, entity, "minecraft:slow_falling", 2) == false) {

                        if (EffectManager.has(level_server, entity, "minecraft:slow_falling") == false) {

                            GameUtils.playSound(level_server, entity.blockPosition(), 0, 20, "minecraft:entity.allay.ambient_with_item");
                            GameUtils.playSound(level_server, entity.blockPosition(), 0, 20, "minecraft:ambient.cave");
                            GameUtils.spawnParticle(level_server, entity.position().add(0, 1, 0), 1, 1, 1, 0.25, 10, "minecraft:cloud");

                        }

                        EffectManager.give(level_server, entity, "minecraft:slow_falling", 2, 1);

                    }

                } else {

                    if (EffectManager.hasDuration(level_server, entity, "minecraft:levitation", 2) == false) {

                        if (EffectManager.has(level_server, entity, "minecraft:levitation") == false) {

                            GameUtils.playSound(level_server, entity.blockPosition(), 0, 20, "minecraft:entity.allay.ambient_without_item");
                            GameUtils.playSound(level_server, entity.blockPosition(), 0, 20, "minecraft:ambient.cave");
                            GameUtils.spawnParticle(level_server, entity.position().add(0, 1, 0), 1, 1, 1, 0.25, 10, "minecraft:cloud");

                        }

                        EffectManager.give(level_server, entity, "minecraft:levitation", 2, 1);

                        if (Math.random() < 0.25) {

                            GameUtils.playSound(level_server, entity.blockPosition(), 2, 20, "minecraft:ambient.warped_forest.mood");

                        }

                    }

                }

            }

        } else if (card_number == 12) {

            {

                if (is_negative == false) {

                    if (EffectManager.hasDuration(level_server, entity, "minecraft:water_breathing", 2) == false) {

                        if (EffectManager.has(level_server, entity, "minecraft:water_breathing") == false) {

                            GameUtils.playSound(level_server, entity.blockPosition(), 0, 20, "minecraft:entity.dolphin.play");
                            GameUtils.playSound(level_server, entity.blockPosition(), 0, 20, "minecraft:entity.allay.ambient_with_item");
                            GameUtils.spawnParticle(level_server, entity.position().add(0, 1, 0), 1, 1, 1, 0, 10, "minecraft:dripping_water");

                        }

                        EffectManager.give(level_server, entity, "minecraft:water_breathing", 2, 1);

                    }

                } else {

                    if (entity.isUnderWater() == true) {

                        GameUtils.runCommandEntity(entity, "damage @s 1 minecraft:drown");
                        GameUtils.playSound(level_server, entity.blockPosition(), (Math.random() * 0.5) + 0.5, 20, "minecraft:entity.elder_guardian.ambient");

                        if (Math.random() < 0.25) {

                            GameUtils.playSound(level_server, entity.blockPosition(), 1.5, 20, "minecraft:ambient.underwater.loop.additions.ultra_rare");

                        }

                    }

                }

            }

        } else if (card_number == 13) {

            {

                if (is_negative == false) {

                    if (EffectManager.hasDuration(level_server, entity, "minecraft:regeneration", 2) == false) {

                        EffectManager.give(level_server, entity, "minecraft:regeneration", 2, 1);
                        GameUtils.spawnParticle(level_server, entity.position().add(0, 1, 0), 1, 1, 1, 0, 1, "minecraft:soul_fire_flame");

                        if (Math.random() < 0.5) {

                            GameUtils.playSound(level_server, entity.blockPosition(), (Math.random() * 1.5) + 0.5, 20, "minecraft:block.amethyst_block.chime");

                        }

                    }

                } else {

                    if (EffectManager.hasDuration(level_server, entity, "minecraft:poison", 2) == false) {

                        EffectManager.give(level_server, entity, "minecraft:poison", 2, 1);
                        GameUtils.spawnParticle(level_server, entity.position().add(0, 1, 0), 1, 1, 1, 0, 1, "minecraft:sculk_soul");

                        if (Math.random() < 0.25) {

                            GameUtils.playSound(level_server, entity.blockPosition(), (Math.random() * 1.5) + 0.5, 10, "minecraft:ambient.soul_sand_valley.mood");

                        }

                    }

                }

            }

        }

    }

    private static class Card {

        private static void summonAll (ServerLevel level_server, ServerPlayer player_server, Entity entity_center) {

            entity_center.setYRot((float) (Math.random() * 360));
            List<Integer> list = new ArrayList<>();

            for (int number = 1; number <= 13; number++) {

                if (NBTManager.Mob.getLogic(player_server, "spell1", "is_card_enable" + number) == true) {

                    list.add(number);

                }

            }

            int[] numbers = new int[list.size()];

            for (int loop = 0; loop < list.size(); loop++) {

                numbers[loop] = list.get(loop);

            }

            summonSpecific(level_server, player_server, entity_center, numbers);

        }

        private static void summonSpecific (ServerLevel level_server, ServerPlayer player_server, Entity entity_center, int[] numbers) {


            for (int number : numbers) {

                entity_center.setYRot((float) (entity_center.getYRot() + (360.0 / numbers.length)));
                EntityManager.Display.summonItem(level_server, entity_center.position(), (int) (entity_center.getYRot() + 180), 90, 0, true, "Zodiac Card " + number, Utils.Tag.convertSystemSpecific(player_server, new String[]{"spell1", "spell1_card", "spell1_card" + number}), "tanscomplexmagic:zodiac_card_" + number);

                if (entity_center.getYRot() >= 360) {

                    entity_center.setYRot(entity_center.getYRot() - 360);

                }

            }

            double radius = NBTManager.Mob.getNumber(player_server, "spell1", "radius");
            GameUtils.spawnParticle(level_server, entity_center.position(), 0, 0, 0, 0, 1, "minecraft:flash");
            GameUtils.playSound(level_server, entity_center.blockPosition(), 0, radius * 5, "minecraft:entity.evoker.prepare_summon");
            GameUtils.playSound(level_server, entity_center.blockPosition(), 0, radius * 10, "minecraft:block.enchantment_table.use");

        }

        private static void removeAll (ServerLevel level_server, ServerPlayer player_server) {

            double radius = NBTManager.Mob.getNumber(player_server, "spell1", "radius");

            for (Entity entity : EntityManager.Get.fromEverywhere(level_server, "minecraft:item_display", Utils.Tag.convertSystemSpecific(player_server, new String[]{"spell1_card"}))) {

                removeSpecific(level_server, entity, radius);

            }

        }

        private static void removeSpecific (ServerLevel level_server, Entity entity_card, double radius) {

            GameUtils.spawnParticle(level_server, entity_card.position(), 0, 0, 0, 0, 1, "minecraft:flash");
            GameUtils.playSound(level_server, entity_card.blockPosition(), 0, radius * 4, "minecraft:entity.evoker.cast_spell");
            entity_card.discard();

        }

        private static void update (ServerLevel level_server, ServerPlayer player_server, Entity entity_center, Map<Integer, Entity> cards) {

            double radius = NBTManager.Mob.getNumber(player_server, "spell1", "radius");

            for (Map.Entry<Integer, Entity> entry : cards.entrySet()) {

                entity_center.setYRot(entity_center.getYRot() + (float) (360.0 / cards.size()));

                if (entity_center.getYRot() >= 360) {

                    entity_center.setYRot(entity_center.getYRot() - 360);

                }

                // When Update Radius
                {

                    if (NBTManager.Mob.getNumber(entry.getValue(), "", "save_radius") != radius) {

                        NBTManager.Mob.setNumber(entry.getValue(), "", "save_radius", radius);
                        setSize(player_server, entry.getValue());

                    }

                }

                setPosition(player_server, entity_center, entry.getValue(), cards.size());
                setPose(level_server, player_server, entity_center, entry.getValue(), entry.getKey(), cards.size());

            }

            // Second Updates
            {

                int card_update_second_tick = (int) NBTManager.Mob.getNumber(player_server, "", "card_update_second_tick");

                if (card_update_second_tick < 20) {

                    NBTManager.Mob.setNumber(player_server, "", "card_update_second_tick", card_update_second_tick + 1);

                } else {

                    NBTManager.Mob.setNumber(player_server, "", "card_update_second_tick", 1);
                    updateSecond(level_server, player_server, entity_center, cards);

                }

            }

        }

        private static void updateSecond (ServerLevel level_server, ServerPlayer player_server, Entity entity_center, Map<Integer, Entity> cards) {

            double radius = NBTManager.Mob.getNumber(player_server, "spell1", "radius");
            Map<String, List<Entity>> targets = new HashMap<>();
            Entity entity_card = null;

            // Get Targets
            {

                List<Entity> list = EntityManager.Get.filterLivingEntity(EntityManager.Get.fromArea(level_server, entity_center.position(), radius, false, "", new String[]{}));
                targets.put("user", new ArrayList<>());

                if (list.contains(player_server) == true) {

                    targets.get("user").add(player_server);

                }

                targets.put("ally_player", EntityManager.Get.filter(list, "minecraft:player", Utils.Tag.convertAlly(player_server)));
                targets.put("ally_non_player", EntityManager.Get.filter(list, "!minecraft:player", Utils.Tag.convertAlly(player_server)));
                targets.put("enemy_player", EntityManager.Get.filter(list, "minecraft:player", Utils.Tag.convertEnemy(player_server)));
                targets.put("enemy_non_player", EntityManager.Get.filter(list, "!minecraft:player", Utils.Tag.convertEnemy(player_server)));

            }

            boolean is_negative = false;
            String positive_negative = "";

            for (int number = 1; number < 13; number++) {

                entity_card = cards.get(number);

                // When Update Card Enable
                {

                    boolean active = NBTManager.Mob.getLogic(player_server, "spell1", "is_card_enable" + number);

                    if (active != NBTManager.Mob.getLogic(player_server, "spell1", "save_is_card_enable" + number)) {

                        NBTManager.Mob.setLogic(player_server, "spell1", "save_is_card_enable" + number, active);

                        if (entity_card == null) {

                            if (active == true) {

                                summonSpecific(level_server, player_server, entity_center, new int[]{number});

                            }

                        } else {

                            if (active == false) {

                                removeSpecific(level_server, entity_card, radius);

                            }

                        }

                    }

                }

                List<Entity> sort_targets = new ArrayList<>();

                if (entity_card == null) {

                    NBTManager.Mob.setNumber(player_server, "spell1", "number_of_targets_detected" + number, 0);
                    continue;

                }

                // Sort Targets
                {

                    if (NBTManager.Mob.getLogic(player_server, "spell1", "is_card_target_user" + number) == true)
                        sort_targets.addAll(targets.get("user"));
                    if (NBTManager.Mob.getLogic(player_server, "spell1", "is_card_target_ally_player" + number) == true)
                        sort_targets.addAll(targets.get("ally_player"));
                    if (NBTManager.Mob.getLogic(player_server, "spell1", "is_card_target_ally_non_player" + number) == true)
                        sort_targets.addAll(targets.get("ally_non_player"));
                    if (NBTManager.Mob.getLogic(player_server, "spell1", "is_card_target_enemy_player" + number) == true)
                        sort_targets.addAll(targets.get("enemy_player"));
                    if (NBTManager.Mob.getLogic(player_server, "spell1", "is_card_target_enemy_non_player" + number) == true)
                        sort_targets.addAll(targets.get("enemy_non_player"));

                    sort_targets = EntityManager.Get.sort(sort_targets, entity_center.position(), true, 0);

                }

                NBTManager.Mob.setNumber(player_server, "spell1", "number_of_targets_detected" + number, sort_targets.size());
                is_negative = NBTManager.Mob.getLogic(player_server, "spell1", "is_card_negative" + number);

                if (is_negative == true) {

                    positive_negative = "negative";

                } else {

                    positive_negative = "positive";

                }

                if (NBTManager.Mob.getText(entity_card, "", "status").equals("effect") == true) {

                    // Apply Effects
                    {

                        int duration = (int) NBTManager.Mob.getNumber(player_server, "spell1", "card_duration_" + positive_negative + number);
                        int duration_max = (int) NBTManager.Mob.getNumber(player_server, "spell1", "card_duration_max_" + positive_negative + number);

                        for (Entity entity : sort_targets) {

                            if (duration == 0) {

                                break;

                            }

                            duration = duration - 1;
                            duration_max = duration_max - 1;
                            giveEffect(level_server, player_server, entity, number, is_negative, 1);

                        }

                        NBTManager.Mob.setNumber(player_server, "spell1", "card_duration_" + positive_negative + number, duration);
                        NBTManager.Mob.setNumber(player_server, "spell1", "card_duration_max_" + positive_negative + number, duration_max);

                    }

                }

            }

        }

        private static void setPosition (ServerPlayer player_server, Entity entity_center, Entity entity_card, int card_count) {

            boolean is_rest = NBTManager.Mob.getText(entity_card, "", "status").isEmpty() == true;
            double radius = NBTManager.Mob.getNumber(player_server, "spell1", "radius");
            double height = 0.0;
            double far = 0.0;

            if (radius <= 10) {

                if (is_rest == true) {

                    height = 0.075;

                } else {

                    height = radius / 4.0;

                }

            } else {

                height = radius;

                if (is_rest == false) {

                    height = radius - (radius / 4.0);

                }

            }

            if (card_count > 1) {

                if (is_rest == true) {

                    far = radius * 1.25;

                } else {

                    far = radius;

                }

            }

            entity_card.setPos(GameUtils.Space.getPosLook(entity_center, 0, height, far));

        }

        private static void setPose (ServerLevel level_server, ServerPlayer player_server, Entity entity_center, Entity entity_card, int card_number, int card_count) {

            if (card_count == 1) {

                entity_card.setYRot((float) (entity_card.getYRot() + -0.5));

            } else {

                float rotX_save = entity_card.getXRot();
                entity_card.lookAt(EntityAnchorArgument.Anchor.FEET, entity_center.position());
                entity_card.setXRot(rotX_save);

            }

            int degree_set = 90;

            if (NBTManager.Mob.getLogic(player_server, "spell1", "is_pause_all") == false) {

                if (NBTManager.Mob.getLogic(player_server, "spell1", "is_card_active" + card_number) == true) {

                    boolean is_negative = NBTManager.Mob.getLogic(player_server, "spell1", "is_card_negative" + card_number);
                    String positive_negative = "";

                    if (is_negative == true) {

                        positive_negative = "negative";

                    } else {

                        positive_negative = "positive";

                    }

                    if (NBTManager.Mob.getNumber(player_server, "spell1", "card_duration_" + positive_negative + card_number) > 0) {

                        if (is_negative == true) {

                            degree_set = -180;

                        } else {

                            degree_set = 0;

                        }

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

        private static void setSize (ServerPlayer player_server, Entity entity_card) {

            double scale = NBTManager.Mob.getNumber(player_server, "spell1", "radius") / 5.0;
            EntityManager.Display.setItemScale(entity_card, scale);

        }

        private static Map<Integer, Entity> getActive (ServerLevel level_server, ServerPlayer player_server) {

            Map<Integer, Entity> map = new HashMap<>();
            Entity entity = null;

            for (int number = 1; number <= 13; number++) {

                entity = EntityManager.Get.fromEverywhereOne(level_server, "minecraft:item_display", Utils.Tag.convertSystemSpecific(player_server, new String[]{"spell1_card" + number}));

                if (entity == null) {

                    continue;

                }

                map.put(number, entity);

            }

            return map;

        }

    }

}
