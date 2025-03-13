package lantern_of_the_woodlands;

import net.minecraftforge.fml.network.PacketDistributor;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.world.storage.WorldSavedData;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.IServerWorld;
import net.minecraft.network.PacketBuffer;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.player.ServerPlayerEntity;

import java.util.function.Supplier;

public class LanternOfTheWoodlandsModVariables {
	public LanternOfTheWoodlandsModVariables(LanternOfTheWoodlandsModElements elements) {
		elements.addNetworkMessage(WorldSavedDataSyncMessage.class, WorldSavedDataSyncMessage::buffer, WorldSavedDataSyncMessage::new,
				WorldSavedDataSyncMessage::handler);
	}

	@SubscribeEvent
	public void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		if (!event.getPlayer().world.isRemote()) {
			WorldSavedData mapdata = MapVariables.get(event.getPlayer().world);
			WorldSavedData worlddata = WorldVariables.get(event.getPlayer().world);
			if (mapdata != null)
				LanternOfTheWoodlandsMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) event.getPlayer()),
						new WorldSavedDataSyncMessage(0, mapdata));
			if (worlddata != null)
				LanternOfTheWoodlandsMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) event.getPlayer()),
						new WorldSavedDataSyncMessage(1, worlddata));
		}
	}

	@SubscribeEvent
	public void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
		if (!event.getPlayer().world.isRemote()) {
			WorldSavedData worlddata = WorldVariables.get(event.getPlayer().world);
			if (worlddata != null)
				LanternOfTheWoodlandsMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) event.getPlayer()),
						new WorldSavedDataSyncMessage(1, worlddata));
		}
	}

	public static class WorldVariables extends WorldSavedData {
		public static final String DATA_NAME = "lantern_of_the_woodlands_worldvars";

		public WorldVariables() {
			super(DATA_NAME);
		}

		public WorldVariables(String s) {
			super(s);
		}

		@Override
		public void read(CompoundNBT nbt) {
		}

		@Override
		public CompoundNBT write(CompoundNBT nbt) {
			return nbt;
		}

		public void syncData(IWorld world) {
			this.markDirty();
			if (world instanceof World && !world.isRemote())
				LanternOfTheWoodlandsMod.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with(((World) world)::getDimensionKey),
						new WorldSavedDataSyncMessage(1, this));
		}

		static WorldVariables clientSide = new WorldVariables();

		public static WorldVariables get(IWorld world) {
			if (world instanceof ServerWorld) {
				return ((ServerWorld) world).getSavedData().getOrCreate(WorldVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class MapVariables extends WorldSavedData {
		public static final String DATA_NAME = "lantern_of_the_woodlands_mapvars";
		public String spell5_trap = "";
		public String spell5_thickness = "";
		public boolean spell5_start = false;
		public String spell5_spin = "";
		public double spell5_safe_zone_save = 0;
		public String spell5_safe_zone = "";
		public String spell5_room = "";
		public boolean spell5_remove = false;
		public double spell5_radius_save = 0.0;
		public String spell5_radius = "";
		public boolean spell5_pause = false;
		public String spell5_no_wall = "";
		public String spell5_height = "";
		public boolean spell5_gen = false;
		public String spell5_down = "";
		public double spell5_degree_frequency_save = 0;
		public String spell5_degree_frequency = "";
		public double spell5_circle_frequency_save = 0;
		public String spell5_circle_frequency = "";
		public String spell4_weapon_number = "";
		public boolean spell4_weapon_around_lantern = false;
		public double spell4_swap = 0.0;
		public boolean spell4_start = false;
		public boolean spell4_slot8 = false;
		public boolean spell4_slot7 = false;
		public boolean spell4_slot6 = false;
		public boolean spell4_slot5 = false;
		public boolean spell4_slot4 = false;
		public boolean spell4_slot3 = false;
		public boolean spell4_slot2 = false;
		public boolean spell4_slot1 = false;
		public String spell4_shoot_weapon_number = "";
		public boolean spell4_gui_test = false;
		public boolean spell4_8shoot = false;
		public boolean spell4_7shoot = false;
		public boolean spell4_6shoot = false;
		public boolean spell4_5shoot = false;
		public boolean spell4_4shoot = false;
		public boolean spell4_3shoot = false;
		public boolean spell4_2shoot = false;
		public boolean spell4_1shoot = false;
		public boolean spell3_walk = false;
		public double spell3_up_dawn = 0;
		public double spell3_time_second = 0;
		public double spell3_time_minute = 0;
		public double spell3_time = 0;
		public boolean spell3_start = false;
		public double spell3_speed = 1.0;
		public String spell3_show_time = "0:00";
		public String spell3_show_percent_status = "Generating";
		public String spell3_show_percent = "100";
		public boolean spell3_remove_click_again = false;
		public double spell3_percent_full = 0.0;
		public double spell3_percent = 0;
		public boolean spell3_pause = false;
		public boolean spell3_particle = false;
		public boolean spell3_no_block = false;
		public double spell3_left_right = 0;
		public boolean spell3_invisible_dome = false;
		public String spell3_insert = "6";
		public boolean spell3_gen = false;
		public boolean spell3_dome_particle = false;
		public boolean spell3_cancel_click_again = false;
		public boolean spell3_cancel = false;
		public boolean spell3_block_damage = false;
		public boolean spell3_block_arrow = false;
		public boolean spell2_start_repeat = false;
		public boolean spell2_show_waypoint = false;
		public boolean spell2_show_tracker = false;
		public boolean spell2_show_player = false;
		public boolean spell2_show_entity = false;
		public boolean spell2_show_all = false;
		public boolean spell2_notification_tracker = false;
		public boolean spell2_notification_other_team = false;
		public boolean spell2_notification_buoy = false;
		public boolean spell2_notification = false;
		public double spell2_level = 0.0;
		public double spell2_findkey_status = 0;
		public String spell2_findkey_list = "";
		public double spell1_station_count = 0;
		public boolean spell1_start_effect_protection = false;
		public boolean spell1_start_effect_orientation = false;
		public boolean spell1_start_effect_miner = false;
		public boolean spell1_start_effect_healing = false;
		public boolean spell1_start_effect_golden_heart = false;
		public boolean spell1_start_effect_damage_boost = false;
		public boolean spell1_start_effect_clear = false;
		public boolean spell1_start_effect_camouflage = false;
		public boolean spell1_start_effect_barrier = false;
		public boolean spell1_start_effect_ability = false;
		public boolean spell1_speed_rotate = false;
		public boolean spell1_specify_position = false;
		public boolean spell1_lantern_station = true;
		public boolean spell1_invisible_station = false;
		public boolean spell1_effect_protection = false;
		public boolean spell1_effect_orientation = false;
		public boolean spell1_effect_miner = false;
		public boolean spell1_effect_healing = false;
		public boolean spell1_effect_golden_heart = false;
		public boolean spell1_effect_damage_boost = false;
		public boolean spell1_effect_clear = false;
		public boolean spell1_effect_camouflage = false;
		public boolean spell1_effect_barrier = false;
		public boolean spell1_effect_ability = false;
		public boolean place_lantern_up = false;
		public double mana_charge = 0;
		public double mana = 0;
		public double main_spell = 0;
		public double lantern_on_ground = 0;
		public double lantern_in_left_hand = 0.0;
		public String basicspell6_time_left = "";
		public double basicspell6_tick = 0;
		public boolean basicspell6_start = false;
		public double basicspell6_second = 0;
		public double spell5_safe_zone_360 = 0;
		public boolean spell5_always_gen = false;
		public double spell5_trap_degree = 0;
		public boolean spell5_show_trap = false;
		public boolean spell1_effect_water = false;
		public boolean spell1_effect_night_vision = false;
		public boolean spell1_start_effect_water = false;
		public boolean spell1_start_effect_night_vision = false;
		public String ally_list_save = "";
		public String ally_list_save2 = "";
		public String ally_list_save3 = "";
		public String ally_list_save4 = "";
		public boolean ally_list_start_save = false;
		public double basicspell12_mana = 0.0;
		public boolean spell6_create = true;
		public boolean spell6_pause = false;
		public boolean spell6_start_repeat = false;
		public boolean basicspell13_help = false;

		public MapVariables() {
			super(DATA_NAME);
		}

		public MapVariables(String s) {
			super(s);
		}

		@Override
		public void read(CompoundNBT nbt) {
			spell5_trap = nbt.getString("spell5_trap");
			spell5_thickness = nbt.getString("spell5_thickness");
			spell5_start = nbt.getBoolean("spell5_start");
			spell5_spin = nbt.getString("spell5_spin");
			spell5_safe_zone_save = nbt.getDouble("spell5_safe_zone_save");
			spell5_safe_zone = nbt.getString("spell5_safe_zone");
			spell5_room = nbt.getString("spell5_room");
			spell5_remove = nbt.getBoolean("spell5_remove");
			spell5_radius_save = nbt.getDouble("spell5_radius_save");
			spell5_radius = nbt.getString("spell5_radius");
			spell5_pause = nbt.getBoolean("spell5_pause");
			spell5_no_wall = nbt.getString("spell5_no_wall");
			spell5_height = nbt.getString("spell5_height");
			spell5_gen = nbt.getBoolean("spell5_gen");
			spell5_down = nbt.getString("spell5_down");
			spell5_degree_frequency_save = nbt.getDouble("spell5_degree_frequency_save");
			spell5_degree_frequency = nbt.getString("spell5_degree_frequency");
			spell5_circle_frequency_save = nbt.getDouble("spell5_circle_frequency_save");
			spell5_circle_frequency = nbt.getString("spell5_circle_frequency");
			spell4_weapon_number = nbt.getString("spell4_weapon_number");
			spell4_weapon_around_lantern = nbt.getBoolean("spell4_weapon_around_lantern");
			spell4_swap = nbt.getDouble("spell4_swap");
			spell4_start = nbt.getBoolean("spell4_start");
			spell4_slot8 = nbt.getBoolean("spell4_slot8");
			spell4_slot7 = nbt.getBoolean("spell4_slot7");
			spell4_slot6 = nbt.getBoolean("spell4_slot6");
			spell4_slot5 = nbt.getBoolean("spell4_slot5");
			spell4_slot4 = nbt.getBoolean("spell4_slot4");
			spell4_slot3 = nbt.getBoolean("spell4_slot3");
			spell4_slot2 = nbt.getBoolean("spell4_slot2");
			spell4_slot1 = nbt.getBoolean("spell4_slot1");
			spell4_shoot_weapon_number = nbt.getString("spell4_shoot_weapon_number");
			spell4_gui_test = nbt.getBoolean("spell4_gui_test");
			spell4_8shoot = nbt.getBoolean("spell4_8shoot");
			spell4_7shoot = nbt.getBoolean("spell4_7shoot");
			spell4_6shoot = nbt.getBoolean("spell4_6shoot");
			spell4_5shoot = nbt.getBoolean("spell4_5shoot");
			spell4_4shoot = nbt.getBoolean("spell4_4shoot");
			spell4_3shoot = nbt.getBoolean("spell4_3shoot");
			spell4_2shoot = nbt.getBoolean("spell4_2shoot");
			spell4_1shoot = nbt.getBoolean("spell4_1shoot");
			spell3_walk = nbt.getBoolean("spell3_walk");
			spell3_up_dawn = nbt.getDouble("spell3_up_dawn");
			spell3_time_second = nbt.getDouble("spell3_time_second");
			spell3_time_minute = nbt.getDouble("spell3_time_minute");
			spell3_time = nbt.getDouble("spell3_time");
			spell3_start = nbt.getBoolean("spell3_start");
			spell3_speed = nbt.getDouble("spell3_speed");
			spell3_show_time = nbt.getString("spell3_show_time");
			spell3_show_percent_status = nbt.getString("spell3_show_percent_status");
			spell3_show_percent = nbt.getString("spell3_show_percent");
			spell3_remove_click_again = nbt.getBoolean("spell3_remove_click_again");
			spell3_percent_full = nbt.getDouble("spell3_percent_full");
			spell3_percent = nbt.getDouble("spell3_percent");
			spell3_pause = nbt.getBoolean("spell3_pause");
			spell3_particle = nbt.getBoolean("spell3_particle");
			spell3_no_block = nbt.getBoolean("spell3_no_block");
			spell3_left_right = nbt.getDouble("spell3_left_right");
			spell3_invisible_dome = nbt.getBoolean("spell3_invisible_dome");
			spell3_insert = nbt.getString("spell3_insert");
			spell3_gen = nbt.getBoolean("spell3_gen");
			spell3_dome_particle = nbt.getBoolean("spell3_dome_particle");
			spell3_cancel_click_again = nbt.getBoolean("spell3_cancel_click_again");
			spell3_cancel = nbt.getBoolean("spell3_cancel");
			spell3_block_damage = nbt.getBoolean("spell3_block_damage");
			spell3_block_arrow = nbt.getBoolean("spell3_block_arrow");
			spell2_start_repeat = nbt.getBoolean("spell2_start_repeat");
			spell2_show_waypoint = nbt.getBoolean("spell2_show_waypoint");
			spell2_show_tracker = nbt.getBoolean("spell2_show_tracker");
			spell2_show_player = nbt.getBoolean("spell2_show_player");
			spell2_show_entity = nbt.getBoolean("spell2_show_entity");
			spell2_show_all = nbt.getBoolean("spell2_show_all");
			spell2_notification_tracker = nbt.getBoolean("spell2_notification_tracker");
			spell2_notification_other_team = nbt.getBoolean("spell2_notification_other_team");
			spell2_notification_buoy = nbt.getBoolean("spell2_notification_buoy");
			spell2_notification = nbt.getBoolean("spell2_notification");
			spell2_level = nbt.getDouble("spell2_level");
			spell2_findkey_status = nbt.getDouble("spell2_findkey_status");
			spell2_findkey_list = nbt.getString("spell2_findkey_list");
			spell1_station_count = nbt.getDouble("spell1_station_count");
			spell1_start_effect_protection = nbt.getBoolean("spell1_start_effect_protection");
			spell1_start_effect_orientation = nbt.getBoolean("spell1_start_effect_orientation");
			spell1_start_effect_miner = nbt.getBoolean("spell1_start_effect_miner");
			spell1_start_effect_healing = nbt.getBoolean("spell1_start_effect_healing");
			spell1_start_effect_golden_heart = nbt.getBoolean("spell1_start_effect_golden_heart");
			spell1_start_effect_damage_boost = nbt.getBoolean("spell1_start_effect_damage_boost");
			spell1_start_effect_clear = nbt.getBoolean("spell1_start_effect_clear");
			spell1_start_effect_camouflage = nbt.getBoolean("spell1_start_effect_camouflage");
			spell1_start_effect_barrier = nbt.getBoolean("spell1_start_effect_barrier");
			spell1_start_effect_ability = nbt.getBoolean("spell1_start_effect_ability");
			spell1_speed_rotate = nbt.getBoolean("spell1_speed_rotate");
			spell1_specify_position = nbt.getBoolean("spell1_specify_position");
			spell1_lantern_station = nbt.getBoolean("spell1_lantern_station");
			spell1_invisible_station = nbt.getBoolean("spell1_invisible_station");
			spell1_effect_protection = nbt.getBoolean("spell1_effect_protection");
			spell1_effect_orientation = nbt.getBoolean("spell1_effect_orientation");
			spell1_effect_miner = nbt.getBoolean("spell1_effect_miner");
			spell1_effect_healing = nbt.getBoolean("spell1_effect_healing");
			spell1_effect_golden_heart = nbt.getBoolean("spell1_effect_golden_heart");
			spell1_effect_damage_boost = nbt.getBoolean("spell1_effect_damage_boost");
			spell1_effect_clear = nbt.getBoolean("spell1_effect_clear");
			spell1_effect_camouflage = nbt.getBoolean("spell1_effect_camouflage");
			spell1_effect_barrier = nbt.getBoolean("spell1_effect_barrier");
			spell1_effect_ability = nbt.getBoolean("spell1_effect_ability");
			place_lantern_up = nbt.getBoolean("place_lantern_up");
			mana_charge = nbt.getDouble("mana_charge");
			mana = nbt.getDouble("mana");
			main_spell = nbt.getDouble("main_spell");
			lantern_on_ground = nbt.getDouble("lantern_on_ground");
			lantern_in_left_hand = nbt.getDouble("lantern_in_left_hand");
			basicspell6_time_left = nbt.getString("basicspell6_time_left");
			basicspell6_tick = nbt.getDouble("basicspell6_tick");
			basicspell6_start = nbt.getBoolean("basicspell6_start");
			basicspell6_second = nbt.getDouble("basicspell6_second");
			spell5_safe_zone_360 = nbt.getDouble("spell5_safe_zone_360");
			spell5_always_gen = nbt.getBoolean("spell5_always_gen");
			spell5_trap_degree = nbt.getDouble("spell5_trap_degree");
			spell5_show_trap = nbt.getBoolean("spell5_show_trap");
			spell1_effect_water = nbt.getBoolean("spell1_effect_water");
			spell1_effect_night_vision = nbt.getBoolean("spell1_effect_night_vision");
			spell1_start_effect_water = nbt.getBoolean("spell1_start_effect_water");
			spell1_start_effect_night_vision = nbt.getBoolean("spell1_start_effect_night_vision");
			ally_list_save = nbt.getString("ally_list_save");
			ally_list_save2 = nbt.getString("ally_list_save2");
			ally_list_save3 = nbt.getString("ally_list_save3");
			ally_list_save4 = nbt.getString("ally_list_save4");
			ally_list_start_save = nbt.getBoolean("ally_list_start_save");
			basicspell12_mana = nbt.getDouble("basicspell12_mana");
			spell6_create = nbt.getBoolean("spell6_create");
			spell6_pause = nbt.getBoolean("spell6_pause");
			spell6_start_repeat = nbt.getBoolean("spell6_start_repeat");
			basicspell13_help = nbt.getBoolean("basicspell13_help");
		}

		@Override
		public CompoundNBT write(CompoundNBT nbt) {
			nbt.putString("spell5_trap", spell5_trap);
			nbt.putString("spell5_thickness", spell5_thickness);
			nbt.putBoolean("spell5_start", spell5_start);
			nbt.putString("spell5_spin", spell5_spin);
			nbt.putDouble("spell5_safe_zone_save", spell5_safe_zone_save);
			nbt.putString("spell5_safe_zone", spell5_safe_zone);
			nbt.putString("spell5_room", spell5_room);
			nbt.putBoolean("spell5_remove", spell5_remove);
			nbt.putDouble("spell5_radius_save", spell5_radius_save);
			nbt.putString("spell5_radius", spell5_radius);
			nbt.putBoolean("spell5_pause", spell5_pause);
			nbt.putString("spell5_no_wall", spell5_no_wall);
			nbt.putString("spell5_height", spell5_height);
			nbt.putBoolean("spell5_gen", spell5_gen);
			nbt.putString("spell5_down", spell5_down);
			nbt.putDouble("spell5_degree_frequency_save", spell5_degree_frequency_save);
			nbt.putString("spell5_degree_frequency", spell5_degree_frequency);
			nbt.putDouble("spell5_circle_frequency_save", spell5_circle_frequency_save);
			nbt.putString("spell5_circle_frequency", spell5_circle_frequency);
			nbt.putString("spell4_weapon_number", spell4_weapon_number);
			nbt.putBoolean("spell4_weapon_around_lantern", spell4_weapon_around_lantern);
			nbt.putDouble("spell4_swap", spell4_swap);
			nbt.putBoolean("spell4_start", spell4_start);
			nbt.putBoolean("spell4_slot8", spell4_slot8);
			nbt.putBoolean("spell4_slot7", spell4_slot7);
			nbt.putBoolean("spell4_slot6", spell4_slot6);
			nbt.putBoolean("spell4_slot5", spell4_slot5);
			nbt.putBoolean("spell4_slot4", spell4_slot4);
			nbt.putBoolean("spell4_slot3", spell4_slot3);
			nbt.putBoolean("spell4_slot2", spell4_slot2);
			nbt.putBoolean("spell4_slot1", spell4_slot1);
			nbt.putString("spell4_shoot_weapon_number", spell4_shoot_weapon_number);
			nbt.putBoolean("spell4_gui_test", spell4_gui_test);
			nbt.putBoolean("spell4_8shoot", spell4_8shoot);
			nbt.putBoolean("spell4_7shoot", spell4_7shoot);
			nbt.putBoolean("spell4_6shoot", spell4_6shoot);
			nbt.putBoolean("spell4_5shoot", spell4_5shoot);
			nbt.putBoolean("spell4_4shoot", spell4_4shoot);
			nbt.putBoolean("spell4_3shoot", spell4_3shoot);
			nbt.putBoolean("spell4_2shoot", spell4_2shoot);
			nbt.putBoolean("spell4_1shoot", spell4_1shoot);
			nbt.putBoolean("spell3_walk", spell3_walk);
			nbt.putDouble("spell3_up_dawn", spell3_up_dawn);
			nbt.putDouble("spell3_time_second", spell3_time_second);
			nbt.putDouble("spell3_time_minute", spell3_time_minute);
			nbt.putDouble("spell3_time", spell3_time);
			nbt.putBoolean("spell3_start", spell3_start);
			nbt.putDouble("spell3_speed", spell3_speed);
			nbt.putString("spell3_show_time", spell3_show_time);
			nbt.putString("spell3_show_percent_status", spell3_show_percent_status);
			nbt.putString("spell3_show_percent", spell3_show_percent);
			nbt.putBoolean("spell3_remove_click_again", spell3_remove_click_again);
			nbt.putDouble("spell3_percent_full", spell3_percent_full);
			nbt.putDouble("spell3_percent", spell3_percent);
			nbt.putBoolean("spell3_pause", spell3_pause);
			nbt.putBoolean("spell3_particle", spell3_particle);
			nbt.putBoolean("spell3_no_block", spell3_no_block);
			nbt.putDouble("spell3_left_right", spell3_left_right);
			nbt.putBoolean("spell3_invisible_dome", spell3_invisible_dome);
			nbt.putString("spell3_insert", spell3_insert);
			nbt.putBoolean("spell3_gen", spell3_gen);
			nbt.putBoolean("spell3_dome_particle", spell3_dome_particle);
			nbt.putBoolean("spell3_cancel_click_again", spell3_cancel_click_again);
			nbt.putBoolean("spell3_cancel", spell3_cancel);
			nbt.putBoolean("spell3_block_damage", spell3_block_damage);
			nbt.putBoolean("spell3_block_arrow", spell3_block_arrow);
			nbt.putBoolean("spell2_start_repeat", spell2_start_repeat);
			nbt.putBoolean("spell2_show_waypoint", spell2_show_waypoint);
			nbt.putBoolean("spell2_show_tracker", spell2_show_tracker);
			nbt.putBoolean("spell2_show_player", spell2_show_player);
			nbt.putBoolean("spell2_show_entity", spell2_show_entity);
			nbt.putBoolean("spell2_show_all", spell2_show_all);
			nbt.putBoolean("spell2_notification_tracker", spell2_notification_tracker);
			nbt.putBoolean("spell2_notification_other_team", spell2_notification_other_team);
			nbt.putBoolean("spell2_notification_buoy", spell2_notification_buoy);
			nbt.putBoolean("spell2_notification", spell2_notification);
			nbt.putDouble("spell2_level", spell2_level);
			nbt.putDouble("spell2_findkey_status", spell2_findkey_status);
			nbt.putString("spell2_findkey_list", spell2_findkey_list);
			nbt.putDouble("spell1_station_count", spell1_station_count);
			nbt.putBoolean("spell1_start_effect_protection", spell1_start_effect_protection);
			nbt.putBoolean("spell1_start_effect_orientation", spell1_start_effect_orientation);
			nbt.putBoolean("spell1_start_effect_miner", spell1_start_effect_miner);
			nbt.putBoolean("spell1_start_effect_healing", spell1_start_effect_healing);
			nbt.putBoolean("spell1_start_effect_golden_heart", spell1_start_effect_golden_heart);
			nbt.putBoolean("spell1_start_effect_damage_boost", spell1_start_effect_damage_boost);
			nbt.putBoolean("spell1_start_effect_clear", spell1_start_effect_clear);
			nbt.putBoolean("spell1_start_effect_camouflage", spell1_start_effect_camouflage);
			nbt.putBoolean("spell1_start_effect_barrier", spell1_start_effect_barrier);
			nbt.putBoolean("spell1_start_effect_ability", spell1_start_effect_ability);
			nbt.putBoolean("spell1_speed_rotate", spell1_speed_rotate);
			nbt.putBoolean("spell1_specify_position", spell1_specify_position);
			nbt.putBoolean("spell1_lantern_station", spell1_lantern_station);
			nbt.putBoolean("spell1_invisible_station", spell1_invisible_station);
			nbt.putBoolean("spell1_effect_protection", spell1_effect_protection);
			nbt.putBoolean("spell1_effect_orientation", spell1_effect_orientation);
			nbt.putBoolean("spell1_effect_miner", spell1_effect_miner);
			nbt.putBoolean("spell1_effect_healing", spell1_effect_healing);
			nbt.putBoolean("spell1_effect_golden_heart", spell1_effect_golden_heart);
			nbt.putBoolean("spell1_effect_damage_boost", spell1_effect_damage_boost);
			nbt.putBoolean("spell1_effect_clear", spell1_effect_clear);
			nbt.putBoolean("spell1_effect_camouflage", spell1_effect_camouflage);
			nbt.putBoolean("spell1_effect_barrier", spell1_effect_barrier);
			nbt.putBoolean("spell1_effect_ability", spell1_effect_ability);
			nbt.putBoolean("place_lantern_up", place_lantern_up);
			nbt.putDouble("mana_charge", mana_charge);
			nbt.putDouble("mana", mana);
			nbt.putDouble("main_spell", main_spell);
			nbt.putDouble("lantern_on_ground", lantern_on_ground);
			nbt.putDouble("lantern_in_left_hand", lantern_in_left_hand);
			nbt.putString("basicspell6_time_left", basicspell6_time_left);
			nbt.putDouble("basicspell6_tick", basicspell6_tick);
			nbt.putBoolean("basicspell6_start", basicspell6_start);
			nbt.putDouble("basicspell6_second", basicspell6_second);
			nbt.putDouble("spell5_safe_zone_360", spell5_safe_zone_360);
			nbt.putBoolean("spell5_always_gen", spell5_always_gen);
			nbt.putDouble("spell5_trap_degree", spell5_trap_degree);
			nbt.putBoolean("spell5_show_trap", spell5_show_trap);
			nbt.putBoolean("spell1_effect_water", spell1_effect_water);
			nbt.putBoolean("spell1_effect_night_vision", spell1_effect_night_vision);
			nbt.putBoolean("spell1_start_effect_water", spell1_start_effect_water);
			nbt.putBoolean("spell1_start_effect_night_vision", spell1_start_effect_night_vision);
			nbt.putString("ally_list_save", ally_list_save);
			nbt.putString("ally_list_save2", ally_list_save2);
			nbt.putString("ally_list_save3", ally_list_save3);
			nbt.putString("ally_list_save4", ally_list_save4);
			nbt.putBoolean("ally_list_start_save", ally_list_start_save);
			nbt.putDouble("basicspell12_mana", basicspell12_mana);
			nbt.putBoolean("spell6_create", spell6_create);
			nbt.putBoolean("spell6_pause", spell6_pause);
			nbt.putBoolean("spell6_start_repeat", spell6_start_repeat);
			nbt.putBoolean("basicspell13_help", basicspell13_help);
			return nbt;
		}

		public void syncData(IWorld world) {
			this.markDirty();
			if (world instanceof World && !world.isRemote())
				LanternOfTheWoodlandsMod.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), new WorldSavedDataSyncMessage(0, this));
		}

		static MapVariables clientSide = new MapVariables();

		public static MapVariables get(IWorld world) {
			if (world instanceof IServerWorld) {
				return ((IServerWorld) world).getWorld().getServer().getWorld(World.OVERWORLD).getSavedData().getOrCreate(MapVariables::new,
						DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class WorldSavedDataSyncMessage {
		public int type;
		public WorldSavedData data;

		public WorldSavedDataSyncMessage(PacketBuffer buffer) {
			this.type = buffer.readInt();
			this.data = this.type == 0 ? new MapVariables() : new WorldVariables();
			this.data.read(buffer.readCompoundTag());
		}

		public WorldSavedDataSyncMessage(int type, WorldSavedData data) {
			this.type = type;
			this.data = data;
		}

		public static void buffer(WorldSavedDataSyncMessage message, PacketBuffer buffer) {
			buffer.writeInt(message.type);
			buffer.writeCompoundTag(message.data.write(new CompoundNBT()));
		}

		public static void handler(WorldSavedDataSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					if (message.type == 0)
						MapVariables.clientSide = (MapVariables) message.data;
					else
						WorldVariables.clientSide = (WorldVariables) message.data;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
