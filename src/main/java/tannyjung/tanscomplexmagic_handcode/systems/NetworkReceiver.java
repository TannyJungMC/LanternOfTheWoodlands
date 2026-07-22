package tannyjung.tanscomplexmagic_handcode.systems;

import net.minecraft.world.entity.player.Player;

public class NetworkReceiver {

    public static void get (Player player, int room) {

        if (room == 5) System.out.println("Done");
        else if (room == 6) System.out.println("Cancel");



    }

}
