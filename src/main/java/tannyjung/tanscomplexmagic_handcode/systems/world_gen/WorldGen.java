package tannyjung.tanscomplexmagic_handcode.systems.world_gen;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.chunk.ChunkGenerator;
import tannyjung.tanscomplexmagic_core.Core;

import java.io.File;

public class WorldGen {

    public static void stepBeforePlants (LevelAccessor level_accessor, ServerLevel level_server, ChunkGenerator chunk_generator, String dimension, ChunkPos chunk_pos) {



    }

    public static void stepPlants (LevelAccessor level_accessor, ServerLevel level_server, ChunkGenerator chunk_generator, String dimension, ChunkPos chunk_pos) {



    }

    public static void stepLast (LevelAccessor level_accessor, ServerLevel level_server, ChunkGenerator chunk_generator, String dimension, ChunkPos chunk_pos) {



    }

    public static void finishRegion (String dimension, ChunkPos chunk_pos) {

        String path_prefix = Core.path_world_mod;
        String path_suffix = dimension + "/" + (chunk_pos.x >> 5) + "," + (chunk_pos.z >> 5) + ".bin";
        new File(path_prefix + "/world_gen/place/" + path_suffix).delete();
        new File(path_prefix + "/world_gen/detailed_detection/" + path_suffix).delete();

    }

}
