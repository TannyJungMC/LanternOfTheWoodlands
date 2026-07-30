package tannyjung.tanscomplexmagic_handcode.core;

import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.level.ServerLevel;
import tannyjung.tanscomplexmagic_core.game.CommandMaker;

public class Commands {

    public static void registry (Object event_object) {

        CommandMaker.create(event_object, 2, "command / preset_fixer", run.command::preset_fixer);
        
    }

    private static class run {

        private static class command {

            private static void preset_fixer (CommandContext<CommandSourceStack> data) {

                ServerLevel level_server = data.getSource().getLevel();

            }

        }

    }

}