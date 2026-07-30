package tannyjung.tanscomplexmagic_handcode.systems;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import tannyjung.tanscomplexmagic_core.game.EntityManager;
import tannyjung.tanscomplexmagic_core.game.GameUtils;

public class Spell2 {

    public static void loopTick (ServerLevel level_server, ServerPlayer player_server) {

        for (Entity entity : EntityManager.Import.fromEverywhere(level_server, "minecraft:marker", new String[]{})) {

            GameUtils.Misc.spawnParticle(level_server, entity.position(), 0, 0, 0, 0, 1, "flash");

        }

    }

    public static void loopSecond (ServerLevel level_server, ServerPlayer player_server) {



    }

}
