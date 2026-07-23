package tannyjung.tanscomplexmagic.procedures;

import tannyjung.tanscomplexmagic.network.TanscomplexmagicModVariables;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

@EventBusSubscriber
public class PlayerTickProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user == true) {
			if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).player_tick_tick < 20) {
				{
					TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
					_vars.player_tick_tick = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).player_tick_tick + 1;
					_vars.markSyncDirty();
				}
			} else {
				{
					TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
					_vars.player_tick_tick = 0;
					_vars.markSyncDirty();
				}
				if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).player_tick_second < 60) {
					{
						TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
						_vars.player_tick_second = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).player_tick_second + 1;
						_vars.markSyncDirty();
					}
				} else {
					{
						TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
						_vars.player_tick_second = 0;
						_vars.markSyncDirty();
					}
				}
				if (!("Second").isEmpty()) {
					if (true) {
						if (!("Book Log").isEmpty()) {
							if (true) {
								if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).book_log_display_info_duration <= 60) {
									{
										TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
										_vars.book_log_display_info_duration = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).book_log_display_info_duration + 1;
										_vars.markSyncDirty();
									}
								}
								if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).book_log_display_notification_duration <= 60) {
									{
										TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
										_vars.book_log_display_notification_duration = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).book_log_display_notification_duration + 1;
										_vars.markSyncDirty();
									}
								}
							}
						}
						if (!("Mana Regeneration").isEmpty()) {
							if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).mana < 150) {
								if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).mana_charge < 60) {
									{
										TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
										_vars.mana_charge = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).mana_charge + 1;
										_vars.markSyncDirty();
									}
								} else {
									{
										TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
										_vars.mana_charge = 0;
										_vars.mana = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).mana + 1;
										_vars.markSyncDirty();
									}
								}
							} else {
								{
									TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
									_vars.mana = 0;
									_vars.markSyncDirty();
								}
							}
						}
						if (!("Spell").isEmpty()) {
							if (Math.floor(entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell) == 4) {
								Spell4LoopSecondProcedure.execute();
							}
						}
					}
				}
			}
			if (!("Tick").isEmpty()) {
				if (true) {
					if (!("Spell").isEmpty()) {
						if (Math.floor(entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell) == 4) {
							Spell4LoopTickProcedure.execute(world, x, y, z, entity);
						}
					}
				}
			}
		}
	}
}