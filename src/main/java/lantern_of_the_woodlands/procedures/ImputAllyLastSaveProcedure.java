package lantern_of_the_woodlands.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.IWorld;
import net.minecraft.client.gui.widget.TextFieldWidget;

import lantern_of_the_woodlands.LanternOfTheWoodlandsModVariables;

import lantern_of_the_woodlands.LanternOfTheWoodlandsMod;

import java.util.Map;
import java.util.HashMap;

public class ImputAllyLastSaveProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency world for procedure ImputAllyLastSave!");
			return;
		}
		if (dependencies.get("guistate") == null) {
			if (!dependencies.containsKey("guistate"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency guistate for procedure ImputAllyLastSave!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		HashMap guistate = (HashMap) dependencies.get("guistate");
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).ally_list_start_save = (false);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		new Object() {
			private int ticks = 0;
			private float waitTicks;
			private IWorld world;

			public void start(IWorld world, int waitTicks) {
				this.waitTicks = waitTicks;
				MinecraftForge.EVENT_BUS.register(this);
				this.world = world;
			}

			@SubscribeEvent
			public void tick(TickEvent.ServerTickEvent event) {
				if (event.phase == TickEvent.Phase.END) {
					this.ticks += 1;
					if (this.ticks >= this.waitTicks)
						run();
				}
			}

			private void run() {
				{
					TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:add_player_list");
					if (_tf != null) {
						_tf.setText(LanternOfTheWoodlandsModVariables.MapVariables.get(world).ally_list_save);
					}
				}
				{
					TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:add_player_list2");
					if (_tf != null) {
						_tf.setText(LanternOfTheWoodlandsModVariables.MapVariables.get(world).ally_list_save2);
					}
				}
				{
					TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:add_player_list3");
					if (_tf != null) {
						_tf.setText(LanternOfTheWoodlandsModVariables.MapVariables.get(world).ally_list_save3);
					}
				}
				{
					TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:add_player_list4");
					if (_tf != null) {
						_tf.setText(LanternOfTheWoodlandsModVariables.MapVariables.get(world).ally_list_save4);
					}
				}
				LanternOfTheWoodlandsModVariables.MapVariables.get(world).ally_list_start_save = (true);
				LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
				MinecraftForge.EVENT_BUS.unregister(this);
			}
		}.start(world, (int) 20);
	}
}
