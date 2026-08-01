package tannyjung.tanscomplexmagic_handcode.systems;

import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import tannyjung.tanscomplexmagic_core.Core;
import tannyjung.tanscomplexmagic_core.game.EntityManager;
import tannyjung.tanscomplexmagic_core.game.GameUtils;
import tannyjung.tanscomplexmagic_core.game.NBTManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Spell1 {

    public static void start (ServerLevel level_server, ServerPlayer player_server) {

        Vec3 vec3 = BlockPos.containing(GameUtils.Space.getPosRay(player_server, 100)).getCenter().add(0.0, -0.5, 0.0);




        Entity entity_main = EntityManager.summon(level_server, vec3, false, "minecraft:marker", "Main", new String[]{Core.mod_id_big + "-main"}, "");

        if (entity_main == null) {

            return;

        }

        for (int number = 1; number <= 13; number++) {

            if (Math.random() > 1.0) {

                continue;

            }

            EntityManager.Display.summonItem(level_server, entity_main.position(), (360 / 13) * number, 90, 0, true, "Zodiac Card", new String[]{Core.mod_id_big + "-spell1", Core.mod_id_big + "-spell1_card", Core.mod_id_big + "-spell1_card" + number}, "tanscomplexmagic:zodiac_card_" + number);

        }

        if (NBTManager.Mob.getLogic(player_server, "spell1", "is_enable_all") == true) {

            NBTManager.Mob.setLogic(player_server, "spell1", "is_enable_all", false);
            NBTManager.Mob.setNumber(player_server, "spell1", "start_delay", 40);

        }

    }

    public static void cancel (ServerLevel level_server) {

        for (Entity entity : EntityManager.Get.fromEverywhere(level_server, "", new String[]{"TANNYJUNG"})) {

            entity.discard();

        }

    }

    public static void loopTick (ServerLevel level_server, ServerPlayer player_server) {

        // Delay Before Card Jump
        {

            int delay = (int) NBTManager.Mob.getNumber(player_server, "spell1", "start_delay");

            if (delay > 0) {

                delay = delay - 1;
                NBTManager.Mob.setNumber(player_server, "spell1", "start_delay", delay);

                if (delay == 0) {

                    NBTManager.Mob.setLogic(player_server, "spell1", "is_enable_all", true);

                }

            }

        }

        Entity entity_main = EntityManager.Get.fromEverywhereOne(level_server, "minecraft:marker", new String[]{Core.mod_id_big + "-main"});

        if (entity_main == null) {

            return;

        }

        entity_main.setYRot(entity_main.getYRot() + (float) 0.1);
        Map<Integer, Entity> map_entity_card = new HashMap<>();

        // Import Card
        {

            Entity entity = null;

            for (int number = 1; number <= 13; number++) {

                entity = EntityManager.Get.fromEverywhereOne(level_server, "minecraft:item_display", new String[]{Core.mod_id_big + "-spell1_card" + number});

                if (entity != null) {

                    map_entity_card.put(number, entity);

                }

            }

        }

        double distance = NBTManager.Mob.getNumber(player_server, "spell1", "distance");

        for (Map.Entry<Integer, Entity> entry : map_entity_card.entrySet()) {

            setCardPosition(player_server, entity_main, entry.getValue(), map_entity_card.size());
            setCardPose(level_server, player_server, entry.getValue(), entry.getKey());

            // When Update Distance
            {

                if (NBTManager.Mob.getNumber(entry.getValue(), "spell1", "distance_save") != distance) {

                    NBTManager.Mob.setNumber(entry.getValue(), "spell1", "distance_save", distance);
                    setCardSize(level_server, player_server, entry.getValue());

                }

            }

        }

    }

    public static void loopSecond (ServerLevel level_server, ServerPlayer player_server) {

        // Use custom tick instead? Not from this. But create own NBT for loop

    }

    public static void setCardPosition (ServerPlayer player_server, Entity entity_main, Entity entity_card, int card_count) {

        double distance = NBTManager.Mob.getNumber(player_server, "spell1", "distance");
        double height = 0.0;

        if (NBTManager.Mob.getNumber(entity_card, "spell1", "degree") == 0) {

            if (distance <= 10) {

                height = 0.1;

            } else {

                height = (distance / 100.0) * 95;

            }

        } else {

            if (distance <= 10) {

                height = distance / 4;

            } else {

                height = distance / 1.5;

            }

        }

        entity_card.setPos(GameUtils.Space.getPosLook(entity_main, 0, height, distance));
        entity_card.lookAt(EntityAnchorArgument.Anchor.FEET, entity_main.position());
        entity_card.setXRot(90);

        entity_main.setYRot(entity_main.getYRot() + (float) (360.0 / card_count));

        while (entity_main.getYRot() >= 360) {

            entity_main.setYRot(entity_main.getYRot() - 360);

        }

    }

    public static void setCardPose (ServerLevel level_server, ServerPlayer player_server, Entity entity_card, int card_number) {

        double degree = NBTManager.Mob.getNumber(entity_card, "spell1", "degree");
        int degree_set = 0;

        if (NBTManager.Mob.getLogic(player_server, "spell1", "is_enable_all") == true && NBTManager.Mob.getLogic(player_server, "spell1", "is_enable" + card_number) == true) {

            if (NBTManager.Mob.getLogic(player_server, "spell1", "is_negative" + card_number) == true) {

                degree_set = 90;

            } else {

                degree_set = 270;

            }

        }

        if (degree != degree_set) {

            // Add Degree
            {

                double degree_add = 0.0;
                double test = degree;

                if (test < degree_set) {

                    test = test + 360;

                }

                if (Math.abs(test - degree_set) > 180) {

                    degree_add = 1;

                } else {

                    degree_add = -1;

                }

                degree = degree + degree_add;

                if (degree >= 360) {

                    degree = degree - 360;

                } else if (degree < 0) {

                    degree = degree + 360;

                }

                NBTManager.Mob.setNumber(entity_card, "spell1", "degree", degree);
                EntityManager.Display.setItemRotation(entity_card, "x", degree);

            }

            // GameUtils.Misc.spawnParticle(level_server, entity_card.position(), 0.1, 0.1, 0.1, 0, 1, "minecraft:instant_effect");

            if (degree == degree_set) {

                // GameUtils.Misc.spawnParticle(level_server, entity_card.position(), 0, 0, 0, 0.01, 5, "minecraft:end_rod");

            }

        }

    }

    public static void setCardSize (ServerLevel level_server, ServerPlayer player_server, Entity entity_card) {

        double scale = NBTManager.Mob.getNumber(player_server, "spell1", "distance") / 5.0;
        EntityManager.Display.setItemScale(entity_card, scale);

    }

}
