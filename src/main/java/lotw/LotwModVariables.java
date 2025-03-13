package lotw;

import net.minecraftforge.fml.network.PacketDistributor;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.storage.WorldSavedData;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.IServerWorld;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Direction;
import net.minecraft.network.PacketBuffer;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.Minecraft;

import java.util.function.Supplier;

public class LotwModVariables {
	public LotwModVariables(LotwModElements elements) {
		elements.addNetworkMessage(WorldSavedDataSyncMessage.class, WorldSavedDataSyncMessage::buffer, WorldSavedDataSyncMessage::new,
				WorldSavedDataSyncMessage::handler);
		elements.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new,
				PlayerVariablesSyncMessage::handler);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::init);
	}

	private void init(FMLCommonSetupEvent event) {
		CapabilityManager.INSTANCE.register(PlayerVariables.class, new PlayerVariablesStorage(), PlayerVariables::new);
	}

	@SubscribeEvent
	public void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		if (!event.getPlayer().world.isRemote()) {
			WorldSavedData mapdata = MapVariables.get(event.getPlayer().world);
			WorldSavedData worlddata = WorldVariables.get(event.getPlayer().world);
			if (mapdata != null)
				LotwMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) event.getPlayer()),
						new WorldSavedDataSyncMessage(0, mapdata));
			if (worlddata != null)
				LotwMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) event.getPlayer()),
						new WorldSavedDataSyncMessage(1, worlddata));
		}
	}

	@SubscribeEvent
	public void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
		if (!event.getPlayer().world.isRemote()) {
			WorldSavedData worlddata = WorldVariables.get(event.getPlayer().world);
			if (worlddata != null)
				LotwMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) event.getPlayer()),
						new WorldSavedDataSyncMessage(1, worlddata));
		}
	}

	public static class WorldVariables extends WorldSavedData {
		public static final String DATA_NAME = "lotw_worldvars";

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
				LotwMod.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with(((World) world)::getDimensionKey),
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
		public static final String DATA_NAME = "lotw_mapvars";
		public String ally_list_auto1 = "player,distance=..5";
		public String ally_list_auto2 = "villager";
		public String ally_list_auto3 = "iron_golem";
		public String ally_list_auto4 = "";
		public String ally_list_auto5 = "";
		public String ally_list_chat = "";
		public String aternative_keyboard = "";
		public String aternative_keyboard_save1 = "";
		public String aternative_keyboard_save2 = "";
		public String aternative_keyboard_save3 = "";
		public String aternative_keyboard_save4 = "";
		public String bag_lantern = "Off";
		public boolean bag_place = false;
		public double basicspell12_mana = 0.0;
		public double basicspell6_second = 0;
		public boolean basicspell6_start = false;
		public double basicspell6_tick = 0;
		public String basicspell6_time_left = "";
		public double book_page = 0;
		public double circle_hl_f = 0;
		public double circle_hl_s = 0;
		public double circle_hr_f = 0;
		public double circle_hr_s = 0;
		public double circle_vl_f = 0;
		public double circle_vl_s = 0;
		public double circle_vr_f = 0;
		public double circle_vr_s = 0;
		public String custom_planting_bag_1_plant = "";
		public double custom_planting_bag_1_stage = 0;
		public String custom_planting_bag_2_plant = "";
		public double custom_planting_bag_2_stage = 0;
		public String custom_planting_bag_3_plant = "";
		public double custom_planting_bag_3_stage = 0;
		public String custom_planting_bag_4_plant = "";
		public double custom_planting_bag_4_stage = 0;
		public String custom_planting_bag_5_plant = "";
		public double custom_planting_bag_5_stage = 0;
		public String custom_planting_bag_6_plant = "";
		public double custom_planting_bag_6_stage = 0;
		public double lantern_in_left_hand = 0.0;
		public double lantern_on_ground = 0;
		public double main_spell = 0;
		public double mana = 0;
		public double mana_charge = 0;
		public boolean mana_full_repeat = false;
		public double password = 0;
		public boolean place_lantern_up = false;
		public String player_list_manual = "player";
		public boolean spell_cost_insert_item = false;
		public double spell1_distance = 2.0;
		public boolean spell1_distance_get = false;
		public String spell1_door1 = "";
		public String spell1_door2 = "";
		public String spell1_door3 = "";
		public String spell1_door4 = "";
		public double spell1_effect_count = 0.0;
		public double spell1_effect_count_max = 4.0;
		public boolean spell1_effect_info = false;
		public String spell1_effect1 = "Off";
		public String spell1_effect10 = "Off";
		public String spell1_effect11 = "Off";
		public String spell1_effect12 = "Off";
		public String spell1_effect13 = "Off";
		public String spell1_effect2 = "Off";
		public String spell1_effect3 = "Off";
		public String spell1_effect4 = "Off";
		public String spell1_effect5 = "Off";
		public String spell1_effect6 = "Off";
		public String spell1_effect7 = "Off";
		public String spell1_effect8 = "Off";
		public String spell1_effect9 = "Off";
		public String spell1_invisible_card = "Off";
		public String spell1_invisible_circle = "Off";
		public boolean spell1_speed_rotate = false;
		public boolean spell1_start_effect1 = false;
		public boolean spell1_start_effect10 = false;
		public boolean spell1_start_effect11 = false;
		public boolean spell1_start_effect12 = false;
		public boolean spell1_start_effect13 = false;
		public boolean spell1_start_effect2 = false;
		public boolean spell1_start_effect3 = false;
		public boolean spell1_start_effect4 = false;
		public boolean spell1_start_effect5 = false;
		public boolean spell1_start_effect6 = false;
		public boolean spell1_start_effect7 = false;
		public boolean spell1_start_effect8 = false;
		public boolean spell1_start_effect9 = false;
		public String spell1_target_bad = "No Target";
		public String spell1_target_good = "No Target";
		public String spell2_custom = "Off";
		public double spell2_distance = 0.0;
		public String spell2_findkey_list = "!player";
		public boolean spell2_findkey_status = false;
		public String spell2_footstep = "Off";
		public double spell2_level = 1.0;
		public String spell2_notification_buoy = "Off";
		public String spell2_notification_other_team = "Off";
		public String spell2_notification_tracker = "Off";
		public String spell2_scanner_quarity = "Off";
		public String spell2_show_entity = "Off";
		public String spell2_show_info = "Off";
		public String spell2_show_player = "Off";
		public String spell2_show_tracker = "Off";
		public String spell2_show_waypoint = "Off";
		public double spell2_size = 0.5;
		public String spell2_speed = "5s (High)";
		public boolean spell2_start_repeat = false;
		public double spell2_zoom = 100.0;
		public boolean spell3_block_arrow = false;
		public boolean spell3_block_damage = false;
		public boolean spell3_cancel = false;
		public boolean spell3_cancel_click_again = false;
		public boolean spell3_dome_particle = false;
		public boolean spell3_gen = false;
		public String spell3_insert = "6";
		public boolean spell3_invisible_dome = false;
		public double spell3_left_right = 0;
		public boolean spell3_no_block = false;
		public boolean spell3_particle = false;
		public boolean spell3_pause = false;
		public double spell3_percent = 0;
		public double spell3_percent_full = 0.0;
		public boolean spell3_remove_click_again = false;
		public String spell3_show_percent = "100";
		public String spell3_show_percent_status = "Generating";
		public String spell3_show_time = "0:00";
		public double spell3_speed = 1.0;
		public boolean spell3_start = false;
		public double spell3_time = 0;
		public double spell3_time_minute = 0;
		public double spell3_time_second = 0;
		public double spell3_up_dawn = 0;
		public boolean spell3_walk = false;
		public String spell4_ability = "Ready";
		public String spell4_arrow = "On";
		public double spell4_distance = 10.0;
		public double spell4_distance_set = 0;
		public String spell4_follow_you = "Off";
		public String spell4_mode = "Multiple Shot";
		public String spell4_pause_around_lantern = "On";
		public String spell4_pause_free_flying = "Off";
		public String spell4_pause_gravity = "Off";
		public double spell4_pause_size = 2.0;
		public String spell4_reverse = "Off";
		public boolean spell4_shoot = false;
		public boolean spell4_show_key = false;
		public boolean spell4_start = false;
		public String spell4_switch_reverse = "Off";
		public String spell4_switch_shoot = "Off";
		public String spell4_target_lock = "Off";
		public double spell4_tick_auto_shot = 0;
		public double spell4_tick_fly_up_down = 0;
		public double spell4_weapon_count_type1 = 0;
		public double spell4_weapon_count_type2 = 0;
		public double spell4_weapon_count_type3 = 0;
		public double spell4_weapon_count_type4 = 0;
		public double spell4_weapon_count_type5 = 0;
		public double spell4_weapon_count_type6 = 0;
		public double spell4_weapon_count_type7 = 0;
		public String spell4_weapon_type = "Off";
		public String spell4_weapon_type_tag = "tag=LOTW-weapon_manipulation_type0,";
		public boolean spell5_always_gen = false;
		public String spell5_circle_frequency = "";
		public double spell5_circle_frequency_save = 0;
		public String spell5_degree_frequency = "";
		public double spell5_degree_frequency_save = 0;
		public String spell5_down = "";
		public boolean spell5_gen = false;
		public String spell5_height = "";
		public String spell5_no_wall = "";
		public boolean spell5_pause = false;
		public String spell5_radius = "";
		public double spell5_radius_save = 0.0;
		public boolean spell5_remove = false;
		public String spell5_room = "";
		public String spell5_safe_zone = "";
		public double spell5_safe_zone_360 = 0;
		public double spell5_safe_zone_save = 0;
		public boolean spell5_show_trap = false;
		public String spell5_spin = "";
		public boolean spell5_start = false;
		public String spell5_thickness = "";
		public String spell5_trap = "";
		public double spell5_trap_degree = 0;
		public boolean spell6_create = false;
		public boolean spell6_pause = false;
		public boolean spell6_start_repeat = false;
		public double spell7_book_cost = 0;
		public double spell7_book_degree = 0;
		public String spell7_book_id = "";
		public String spell7_book_id_custom = "";
		public double spell7_book_id_number = 0;
		public double spell7_book_id_number_spell = 0.0;
		public double spell7_book_number = 0.0;
		public double spell7_book_time = 0;
		public String spell7_book_time_text = "";
		public boolean spell7_can_generate = false;
		public double spell7_duration = 0;
		public double spell7_fly_updown = 0;
		public String spell7_generator1 = "";
		public String spell7_generator1_id = "";
		public double spell7_generator1_pos = 0;
		public double spell7_generator1_time = 0;
		public String spell7_generator2 = "";
		public String spell7_generator2_id = "";
		public double spell7_generator2_pos = 0;
		public double spell7_generator2_time = 0;
		public String spell7_generator3 = "";
		public String spell7_generator3_id = "";
		public double spell7_generator3_pos = 0;
		public double spell7_generator3_time = 0;
		public double spell7_mode = 1.0;
		public double spell7_move = 0;
		public boolean spell7_select = false;
		public boolean spell7_start = false;
		public double spell7_temporary_number = 0;
		public String spell7_test_use = "";
		public String spell7_type = "Generate Spell Book";
		public String spell7_use = "Inactive";
		public String spell7_use_double = "";
		public double spell7_use_double_number = 0;
		public boolean user_near_lantern = false;
		public boolean user_only = false;
		public String who_can_see_plant_chat_bubble = "User";
		public boolean spell7_show_key = false;

		public MapVariables() {
			super(DATA_NAME);
		}

		public MapVariables(String s) {
			super(s);
		}

		@Override
		public void read(CompoundNBT nbt) {
			ally_list_auto1 = nbt.getString("ally_list_auto1");
			ally_list_auto2 = nbt.getString("ally_list_auto2");
			ally_list_auto3 = nbt.getString("ally_list_auto3");
			ally_list_auto4 = nbt.getString("ally_list_auto4");
			ally_list_auto5 = nbt.getString("ally_list_auto5");
			ally_list_chat = nbt.getString("ally_list_chat");
			aternative_keyboard = nbt.getString("aternative_keyboard");
			aternative_keyboard_save1 = nbt.getString("aternative_keyboard_save1");
			aternative_keyboard_save2 = nbt.getString("aternative_keyboard_save2");
			aternative_keyboard_save3 = nbt.getString("aternative_keyboard_save3");
			aternative_keyboard_save4 = nbt.getString("aternative_keyboard_save4");
			bag_lantern = nbt.getString("bag_lantern");
			bag_place = nbt.getBoolean("bag_place");
			basicspell12_mana = nbt.getDouble("basicspell12_mana");
			basicspell6_second = nbt.getDouble("basicspell6_second");
			basicspell6_start = nbt.getBoolean("basicspell6_start");
			basicspell6_tick = nbt.getDouble("basicspell6_tick");
			basicspell6_time_left = nbt.getString("basicspell6_time_left");
			book_page = nbt.getDouble("book_page");
			circle_hl_f = nbt.getDouble("circle_hl_f");
			circle_hl_s = nbt.getDouble("circle_hl_s");
			circle_hr_f = nbt.getDouble("circle_hr_f");
			circle_hr_s = nbt.getDouble("circle_hr_s");
			circle_vl_f = nbt.getDouble("circle_vl_f");
			circle_vl_s = nbt.getDouble("circle_vl_s");
			circle_vr_f = nbt.getDouble("circle_vr_f");
			circle_vr_s = nbt.getDouble("circle_vr_s");
			custom_planting_bag_1_plant = nbt.getString("custom_planting_bag_1_plant");
			custom_planting_bag_1_stage = nbt.getDouble("custom_planting_bag_1_stage");
			custom_planting_bag_2_plant = nbt.getString("custom_planting_bag_2_plant");
			custom_planting_bag_2_stage = nbt.getDouble("custom_planting_bag_2_stage");
			custom_planting_bag_3_plant = nbt.getString("custom_planting_bag_3_plant");
			custom_planting_bag_3_stage = nbt.getDouble("custom_planting_bag_3_stage");
			custom_planting_bag_4_plant = nbt.getString("custom_planting_bag_4_plant");
			custom_planting_bag_4_stage = nbt.getDouble("custom_planting_bag_4_stage");
			custom_planting_bag_5_plant = nbt.getString("custom_planting_bag_5_plant");
			custom_planting_bag_5_stage = nbt.getDouble("custom_planting_bag_5_stage");
			custom_planting_bag_6_plant = nbt.getString("custom_planting_bag_6_plant");
			custom_planting_bag_6_stage = nbt.getDouble("custom_planting_bag_6_stage");
			lantern_in_left_hand = nbt.getDouble("lantern_in_left_hand");
			lantern_on_ground = nbt.getDouble("lantern_on_ground");
			main_spell = nbt.getDouble("main_spell");
			mana = nbt.getDouble("mana");
			mana_charge = nbt.getDouble("mana_charge");
			mana_full_repeat = nbt.getBoolean("mana_full_repeat");
			password = nbt.getDouble("password");
			place_lantern_up = nbt.getBoolean("place_lantern_up");
			player_list_manual = nbt.getString("player_list_manual");
			spell_cost_insert_item = nbt.getBoolean("spell_cost_insert_item");
			spell1_distance = nbt.getDouble("spell1_distance");
			spell1_distance_get = nbt.getBoolean("spell1_distance_get");
			spell1_door1 = nbt.getString("spell1_door1");
			spell1_door2 = nbt.getString("spell1_door2");
			spell1_door3 = nbt.getString("spell1_door3");
			spell1_door4 = nbt.getString("spell1_door4");
			spell1_effect_count = nbt.getDouble("spell1_effect_count");
			spell1_effect_count_max = nbt.getDouble("spell1_effect_count_max");
			spell1_effect_info = nbt.getBoolean("spell1_effect_info");
			spell1_effect1 = nbt.getString("spell1_effect1");
			spell1_effect10 = nbt.getString("spell1_effect10");
			spell1_effect11 = nbt.getString("spell1_effect11");
			spell1_effect12 = nbt.getString("spell1_effect12");
			spell1_effect13 = nbt.getString("spell1_effect13");
			spell1_effect2 = nbt.getString("spell1_effect2");
			spell1_effect3 = nbt.getString("spell1_effect3");
			spell1_effect4 = nbt.getString("spell1_effect4");
			spell1_effect5 = nbt.getString("spell1_effect5");
			spell1_effect6 = nbt.getString("spell1_effect6");
			spell1_effect7 = nbt.getString("spell1_effect7");
			spell1_effect8 = nbt.getString("spell1_effect8");
			spell1_effect9 = nbt.getString("spell1_effect9");
			spell1_invisible_card = nbt.getString("spell1_invisible_card");
			spell1_invisible_circle = nbt.getString("spell1_invisible_circle");
			spell1_speed_rotate = nbt.getBoolean("spell1_speed_rotate");
			spell1_start_effect1 = nbt.getBoolean("spell1_start_effect1");
			spell1_start_effect10 = nbt.getBoolean("spell1_start_effect10");
			spell1_start_effect11 = nbt.getBoolean("spell1_start_effect11");
			spell1_start_effect12 = nbt.getBoolean("spell1_start_effect12");
			spell1_start_effect13 = nbt.getBoolean("spell1_start_effect13");
			spell1_start_effect2 = nbt.getBoolean("spell1_start_effect2");
			spell1_start_effect3 = nbt.getBoolean("spell1_start_effect3");
			spell1_start_effect4 = nbt.getBoolean("spell1_start_effect4");
			spell1_start_effect5 = nbt.getBoolean("spell1_start_effect5");
			spell1_start_effect6 = nbt.getBoolean("spell1_start_effect6");
			spell1_start_effect7 = nbt.getBoolean("spell1_start_effect7");
			spell1_start_effect8 = nbt.getBoolean("spell1_start_effect8");
			spell1_start_effect9 = nbt.getBoolean("spell1_start_effect9");
			spell1_target_bad = nbt.getString("spell1_target_bad");
			spell1_target_good = nbt.getString("spell1_target_good");
			spell2_custom = nbt.getString("spell2_custom");
			spell2_distance = nbt.getDouble("spell2_distance");
			spell2_findkey_list = nbt.getString("spell2_findkey_list");
			spell2_findkey_status = nbt.getBoolean("spell2_findkey_status");
			spell2_footstep = nbt.getString("spell2_footstep");
			spell2_level = nbt.getDouble("spell2_level");
			spell2_notification_buoy = nbt.getString("spell2_notification_buoy");
			spell2_notification_other_team = nbt.getString("spell2_notification_other_team");
			spell2_notification_tracker = nbt.getString("spell2_notification_tracker");
			spell2_scanner_quarity = nbt.getString("spell2_scanner_quarity");
			spell2_show_entity = nbt.getString("spell2_show_entity");
			spell2_show_info = nbt.getString("spell2_show_info");
			spell2_show_player = nbt.getString("spell2_show_player");
			spell2_show_tracker = nbt.getString("spell2_show_tracker");
			spell2_show_waypoint = nbt.getString("spell2_show_waypoint");
			spell2_size = nbt.getDouble("spell2_size");
			spell2_speed = nbt.getString("spell2_speed");
			spell2_start_repeat = nbt.getBoolean("spell2_start_repeat");
			spell2_zoom = nbt.getDouble("spell2_zoom");
			spell3_block_arrow = nbt.getBoolean("spell3_block_arrow");
			spell3_block_damage = nbt.getBoolean("spell3_block_damage");
			spell3_cancel = nbt.getBoolean("spell3_cancel");
			spell3_cancel_click_again = nbt.getBoolean("spell3_cancel_click_again");
			spell3_dome_particle = nbt.getBoolean("spell3_dome_particle");
			spell3_gen = nbt.getBoolean("spell3_gen");
			spell3_insert = nbt.getString("spell3_insert");
			spell3_invisible_dome = nbt.getBoolean("spell3_invisible_dome");
			spell3_left_right = nbt.getDouble("spell3_left_right");
			spell3_no_block = nbt.getBoolean("spell3_no_block");
			spell3_particle = nbt.getBoolean("spell3_particle");
			spell3_pause = nbt.getBoolean("spell3_pause");
			spell3_percent = nbt.getDouble("spell3_percent");
			spell3_percent_full = nbt.getDouble("spell3_percent_full");
			spell3_remove_click_again = nbt.getBoolean("spell3_remove_click_again");
			spell3_show_percent = nbt.getString("spell3_show_percent");
			spell3_show_percent_status = nbt.getString("spell3_show_percent_status");
			spell3_show_time = nbt.getString("spell3_show_time");
			spell3_speed = nbt.getDouble("spell3_speed");
			spell3_start = nbt.getBoolean("spell3_start");
			spell3_time = nbt.getDouble("spell3_time");
			spell3_time_minute = nbt.getDouble("spell3_time_minute");
			spell3_time_second = nbt.getDouble("spell3_time_second");
			spell3_up_dawn = nbt.getDouble("spell3_up_dawn");
			spell3_walk = nbt.getBoolean("spell3_walk");
			spell4_ability = nbt.getString("spell4_ability");
			spell4_arrow = nbt.getString("spell4_arrow");
			spell4_distance = nbt.getDouble("spell4_distance");
			spell4_distance_set = nbt.getDouble("spell4_distance_set");
			spell4_follow_you = nbt.getString("spell4_follow_you");
			spell4_mode = nbt.getString("spell4_mode");
			spell4_pause_around_lantern = nbt.getString("spell4_pause_around_lantern");
			spell4_pause_free_flying = nbt.getString("spell4_pause_free_flying");
			spell4_pause_gravity = nbt.getString("spell4_pause_gravity");
			spell4_pause_size = nbt.getDouble("spell4_pause_size");
			spell4_reverse = nbt.getString("spell4_reverse");
			spell4_shoot = nbt.getBoolean("spell4_shoot");
			spell4_show_key = nbt.getBoolean("spell4_show_key");
			spell4_start = nbt.getBoolean("spell4_start");
			spell4_switch_reverse = nbt.getString("spell4_switch_reverse");
			spell4_switch_shoot = nbt.getString("spell4_switch_shoot");
			spell4_target_lock = nbt.getString("spell4_target_lock");
			spell4_tick_auto_shot = nbt.getDouble("spell4_tick_auto_shot");
			spell4_tick_fly_up_down = nbt.getDouble("spell4_tick_fly_up_down");
			spell4_weapon_count_type1 = nbt.getDouble("spell4_weapon_count_type1");
			spell4_weapon_count_type2 = nbt.getDouble("spell4_weapon_count_type2");
			spell4_weapon_count_type3 = nbt.getDouble("spell4_weapon_count_type3");
			spell4_weapon_count_type4 = nbt.getDouble("spell4_weapon_count_type4");
			spell4_weapon_count_type5 = nbt.getDouble("spell4_weapon_count_type5");
			spell4_weapon_count_type6 = nbt.getDouble("spell4_weapon_count_type6");
			spell4_weapon_count_type7 = nbt.getDouble("spell4_weapon_count_type7");
			spell4_weapon_type = nbt.getString("spell4_weapon_type");
			spell4_weapon_type_tag = nbt.getString("spell4_weapon_type_tag");
			spell5_always_gen = nbt.getBoolean("spell5_always_gen");
			spell5_circle_frequency = nbt.getString("spell5_circle_frequency");
			spell5_circle_frequency_save = nbt.getDouble("spell5_circle_frequency_save");
			spell5_degree_frequency = nbt.getString("spell5_degree_frequency");
			spell5_degree_frequency_save = nbt.getDouble("spell5_degree_frequency_save");
			spell5_down = nbt.getString("spell5_down");
			spell5_gen = nbt.getBoolean("spell5_gen");
			spell5_height = nbt.getString("spell5_height");
			spell5_no_wall = nbt.getString("spell5_no_wall");
			spell5_pause = nbt.getBoolean("spell5_pause");
			spell5_radius = nbt.getString("spell5_radius");
			spell5_radius_save = nbt.getDouble("spell5_radius_save");
			spell5_remove = nbt.getBoolean("spell5_remove");
			spell5_room = nbt.getString("spell5_room");
			spell5_safe_zone = nbt.getString("spell5_safe_zone");
			spell5_safe_zone_360 = nbt.getDouble("spell5_safe_zone_360");
			spell5_safe_zone_save = nbt.getDouble("spell5_safe_zone_save");
			spell5_show_trap = nbt.getBoolean("spell5_show_trap");
			spell5_spin = nbt.getString("spell5_spin");
			spell5_start = nbt.getBoolean("spell5_start");
			spell5_thickness = nbt.getString("spell5_thickness");
			spell5_trap = nbt.getString("spell5_trap");
			spell5_trap_degree = nbt.getDouble("spell5_trap_degree");
			spell6_create = nbt.getBoolean("spell6_create");
			spell6_pause = nbt.getBoolean("spell6_pause");
			spell6_start_repeat = nbt.getBoolean("spell6_start_repeat");
			spell7_book_cost = nbt.getDouble("spell7_book_cost");
			spell7_book_degree = nbt.getDouble("spell7_book_degree");
			spell7_book_id = nbt.getString("spell7_book_id");
			spell7_book_id_custom = nbt.getString("spell7_book_id_custom");
			spell7_book_id_number = nbt.getDouble("spell7_book_id_number");
			spell7_book_id_number_spell = nbt.getDouble("spell7_book_id_number_spell");
			spell7_book_number = nbt.getDouble("spell7_book_number");
			spell7_book_time = nbt.getDouble("spell7_book_time");
			spell7_book_time_text = nbt.getString("spell7_book_time_text");
			spell7_can_generate = nbt.getBoolean("spell7_can_generate");
			spell7_duration = nbt.getDouble("spell7_duration");
			spell7_fly_updown = nbt.getDouble("spell7_fly_updown");
			spell7_generator1 = nbt.getString("spell7_generator1");
			spell7_generator1_id = nbt.getString("spell7_generator1_id");
			spell7_generator1_pos = nbt.getDouble("spell7_generator1_pos");
			spell7_generator1_time = nbt.getDouble("spell7_generator1_time");
			spell7_generator2 = nbt.getString("spell7_generator2");
			spell7_generator2_id = nbt.getString("spell7_generator2_id");
			spell7_generator2_pos = nbt.getDouble("spell7_generator2_pos");
			spell7_generator2_time = nbt.getDouble("spell7_generator2_time");
			spell7_generator3 = nbt.getString("spell7_generator3");
			spell7_generator3_id = nbt.getString("spell7_generator3_id");
			spell7_generator3_pos = nbt.getDouble("spell7_generator3_pos");
			spell7_generator3_time = nbt.getDouble("spell7_generator3_time");
			spell7_mode = nbt.getDouble("spell7_mode");
			spell7_move = nbt.getDouble("spell7_move");
			spell7_select = nbt.getBoolean("spell7_select");
			spell7_start = nbt.getBoolean("spell7_start");
			spell7_temporary_number = nbt.getDouble("spell7_temporary_number");
			spell7_test_use = nbt.getString("spell7_test_use");
			spell7_type = nbt.getString("spell7_type");
			spell7_use = nbt.getString("spell7_use");
			spell7_use_double = nbt.getString("spell7_use_double");
			spell7_use_double_number = nbt.getDouble("spell7_use_double_number");
			user_near_lantern = nbt.getBoolean("user_near_lantern");
			user_only = nbt.getBoolean("user_only");
			who_can_see_plant_chat_bubble = nbt.getString("who_can_see_plant_chat_bubble");
			spell7_show_key = nbt.getBoolean("spell7_show_key");
		}

		@Override
		public CompoundNBT write(CompoundNBT nbt) {
			nbt.putString("ally_list_auto1", ally_list_auto1);
			nbt.putString("ally_list_auto2", ally_list_auto2);
			nbt.putString("ally_list_auto3", ally_list_auto3);
			nbt.putString("ally_list_auto4", ally_list_auto4);
			nbt.putString("ally_list_auto5", ally_list_auto5);
			nbt.putString("ally_list_chat", ally_list_chat);
			nbt.putString("aternative_keyboard", aternative_keyboard);
			nbt.putString("aternative_keyboard_save1", aternative_keyboard_save1);
			nbt.putString("aternative_keyboard_save2", aternative_keyboard_save2);
			nbt.putString("aternative_keyboard_save3", aternative_keyboard_save3);
			nbt.putString("aternative_keyboard_save4", aternative_keyboard_save4);
			nbt.putString("bag_lantern", bag_lantern);
			nbt.putBoolean("bag_place", bag_place);
			nbt.putDouble("basicspell12_mana", basicspell12_mana);
			nbt.putDouble("basicspell6_second", basicspell6_second);
			nbt.putBoolean("basicspell6_start", basicspell6_start);
			nbt.putDouble("basicspell6_tick", basicspell6_tick);
			nbt.putString("basicspell6_time_left", basicspell6_time_left);
			nbt.putDouble("book_page", book_page);
			nbt.putDouble("circle_hl_f", circle_hl_f);
			nbt.putDouble("circle_hl_s", circle_hl_s);
			nbt.putDouble("circle_hr_f", circle_hr_f);
			nbt.putDouble("circle_hr_s", circle_hr_s);
			nbt.putDouble("circle_vl_f", circle_vl_f);
			nbt.putDouble("circle_vl_s", circle_vl_s);
			nbt.putDouble("circle_vr_f", circle_vr_f);
			nbt.putDouble("circle_vr_s", circle_vr_s);
			nbt.putString("custom_planting_bag_1_plant", custom_planting_bag_1_plant);
			nbt.putDouble("custom_planting_bag_1_stage", custom_planting_bag_1_stage);
			nbt.putString("custom_planting_bag_2_plant", custom_planting_bag_2_plant);
			nbt.putDouble("custom_planting_bag_2_stage", custom_planting_bag_2_stage);
			nbt.putString("custom_planting_bag_3_plant", custom_planting_bag_3_plant);
			nbt.putDouble("custom_planting_bag_3_stage", custom_planting_bag_3_stage);
			nbt.putString("custom_planting_bag_4_plant", custom_planting_bag_4_plant);
			nbt.putDouble("custom_planting_bag_4_stage", custom_planting_bag_4_stage);
			nbt.putString("custom_planting_bag_5_plant", custom_planting_bag_5_plant);
			nbt.putDouble("custom_planting_bag_5_stage", custom_planting_bag_5_stage);
			nbt.putString("custom_planting_bag_6_plant", custom_planting_bag_6_plant);
			nbt.putDouble("custom_planting_bag_6_stage", custom_planting_bag_6_stage);
			nbt.putDouble("lantern_in_left_hand", lantern_in_left_hand);
			nbt.putDouble("lantern_on_ground", lantern_on_ground);
			nbt.putDouble("main_spell", main_spell);
			nbt.putDouble("mana", mana);
			nbt.putDouble("mana_charge", mana_charge);
			nbt.putBoolean("mana_full_repeat", mana_full_repeat);
			nbt.putDouble("password", password);
			nbt.putBoolean("place_lantern_up", place_lantern_up);
			nbt.putString("player_list_manual", player_list_manual);
			nbt.putBoolean("spell_cost_insert_item", spell_cost_insert_item);
			nbt.putDouble("spell1_distance", spell1_distance);
			nbt.putBoolean("spell1_distance_get", spell1_distance_get);
			nbt.putString("spell1_door1", spell1_door1);
			nbt.putString("spell1_door2", spell1_door2);
			nbt.putString("spell1_door3", spell1_door3);
			nbt.putString("spell1_door4", spell1_door4);
			nbt.putDouble("spell1_effect_count", spell1_effect_count);
			nbt.putDouble("spell1_effect_count_max", spell1_effect_count_max);
			nbt.putBoolean("spell1_effect_info", spell1_effect_info);
			nbt.putString("spell1_effect1", spell1_effect1);
			nbt.putString("spell1_effect10", spell1_effect10);
			nbt.putString("spell1_effect11", spell1_effect11);
			nbt.putString("spell1_effect12", spell1_effect12);
			nbt.putString("spell1_effect13", spell1_effect13);
			nbt.putString("spell1_effect2", spell1_effect2);
			nbt.putString("spell1_effect3", spell1_effect3);
			nbt.putString("spell1_effect4", spell1_effect4);
			nbt.putString("spell1_effect5", spell1_effect5);
			nbt.putString("spell1_effect6", spell1_effect6);
			nbt.putString("spell1_effect7", spell1_effect7);
			nbt.putString("spell1_effect8", spell1_effect8);
			nbt.putString("spell1_effect9", spell1_effect9);
			nbt.putString("spell1_invisible_card", spell1_invisible_card);
			nbt.putString("spell1_invisible_circle", spell1_invisible_circle);
			nbt.putBoolean("spell1_speed_rotate", spell1_speed_rotate);
			nbt.putBoolean("spell1_start_effect1", spell1_start_effect1);
			nbt.putBoolean("spell1_start_effect10", spell1_start_effect10);
			nbt.putBoolean("spell1_start_effect11", spell1_start_effect11);
			nbt.putBoolean("spell1_start_effect12", spell1_start_effect12);
			nbt.putBoolean("spell1_start_effect13", spell1_start_effect13);
			nbt.putBoolean("spell1_start_effect2", spell1_start_effect2);
			nbt.putBoolean("spell1_start_effect3", spell1_start_effect3);
			nbt.putBoolean("spell1_start_effect4", spell1_start_effect4);
			nbt.putBoolean("spell1_start_effect5", spell1_start_effect5);
			nbt.putBoolean("spell1_start_effect6", spell1_start_effect6);
			nbt.putBoolean("spell1_start_effect7", spell1_start_effect7);
			nbt.putBoolean("spell1_start_effect8", spell1_start_effect8);
			nbt.putBoolean("spell1_start_effect9", spell1_start_effect9);
			nbt.putString("spell1_target_bad", spell1_target_bad);
			nbt.putString("spell1_target_good", spell1_target_good);
			nbt.putString("spell2_custom", spell2_custom);
			nbt.putDouble("spell2_distance", spell2_distance);
			nbt.putString("spell2_findkey_list", spell2_findkey_list);
			nbt.putBoolean("spell2_findkey_status", spell2_findkey_status);
			nbt.putString("spell2_footstep", spell2_footstep);
			nbt.putDouble("spell2_level", spell2_level);
			nbt.putString("spell2_notification_buoy", spell2_notification_buoy);
			nbt.putString("spell2_notification_other_team", spell2_notification_other_team);
			nbt.putString("spell2_notification_tracker", spell2_notification_tracker);
			nbt.putString("spell2_scanner_quarity", spell2_scanner_quarity);
			nbt.putString("spell2_show_entity", spell2_show_entity);
			nbt.putString("spell2_show_info", spell2_show_info);
			nbt.putString("spell2_show_player", spell2_show_player);
			nbt.putString("spell2_show_tracker", spell2_show_tracker);
			nbt.putString("spell2_show_waypoint", spell2_show_waypoint);
			nbt.putDouble("spell2_size", spell2_size);
			nbt.putString("spell2_speed", spell2_speed);
			nbt.putBoolean("spell2_start_repeat", spell2_start_repeat);
			nbt.putDouble("spell2_zoom", spell2_zoom);
			nbt.putBoolean("spell3_block_arrow", spell3_block_arrow);
			nbt.putBoolean("spell3_block_damage", spell3_block_damage);
			nbt.putBoolean("spell3_cancel", spell3_cancel);
			nbt.putBoolean("spell3_cancel_click_again", spell3_cancel_click_again);
			nbt.putBoolean("spell3_dome_particle", spell3_dome_particle);
			nbt.putBoolean("spell3_gen", spell3_gen);
			nbt.putString("spell3_insert", spell3_insert);
			nbt.putBoolean("spell3_invisible_dome", spell3_invisible_dome);
			nbt.putDouble("spell3_left_right", spell3_left_right);
			nbt.putBoolean("spell3_no_block", spell3_no_block);
			nbt.putBoolean("spell3_particle", spell3_particle);
			nbt.putBoolean("spell3_pause", spell3_pause);
			nbt.putDouble("spell3_percent", spell3_percent);
			nbt.putDouble("spell3_percent_full", spell3_percent_full);
			nbt.putBoolean("spell3_remove_click_again", spell3_remove_click_again);
			nbt.putString("spell3_show_percent", spell3_show_percent);
			nbt.putString("spell3_show_percent_status", spell3_show_percent_status);
			nbt.putString("spell3_show_time", spell3_show_time);
			nbt.putDouble("spell3_speed", spell3_speed);
			nbt.putBoolean("spell3_start", spell3_start);
			nbt.putDouble("spell3_time", spell3_time);
			nbt.putDouble("spell3_time_minute", spell3_time_minute);
			nbt.putDouble("spell3_time_second", spell3_time_second);
			nbt.putDouble("spell3_up_dawn", spell3_up_dawn);
			nbt.putBoolean("spell3_walk", spell3_walk);
			nbt.putString("spell4_ability", spell4_ability);
			nbt.putString("spell4_arrow", spell4_arrow);
			nbt.putDouble("spell4_distance", spell4_distance);
			nbt.putDouble("spell4_distance_set", spell4_distance_set);
			nbt.putString("spell4_follow_you", spell4_follow_you);
			nbt.putString("spell4_mode", spell4_mode);
			nbt.putString("spell4_pause_around_lantern", spell4_pause_around_lantern);
			nbt.putString("spell4_pause_free_flying", spell4_pause_free_flying);
			nbt.putString("spell4_pause_gravity", spell4_pause_gravity);
			nbt.putDouble("spell4_pause_size", spell4_pause_size);
			nbt.putString("spell4_reverse", spell4_reverse);
			nbt.putBoolean("spell4_shoot", spell4_shoot);
			nbt.putBoolean("spell4_show_key", spell4_show_key);
			nbt.putBoolean("spell4_start", spell4_start);
			nbt.putString("spell4_switch_reverse", spell4_switch_reverse);
			nbt.putString("spell4_switch_shoot", spell4_switch_shoot);
			nbt.putString("spell4_target_lock", spell4_target_lock);
			nbt.putDouble("spell4_tick_auto_shot", spell4_tick_auto_shot);
			nbt.putDouble("spell4_tick_fly_up_down", spell4_tick_fly_up_down);
			nbt.putDouble("spell4_weapon_count_type1", spell4_weapon_count_type1);
			nbt.putDouble("spell4_weapon_count_type2", spell4_weapon_count_type2);
			nbt.putDouble("spell4_weapon_count_type3", spell4_weapon_count_type3);
			nbt.putDouble("spell4_weapon_count_type4", spell4_weapon_count_type4);
			nbt.putDouble("spell4_weapon_count_type5", spell4_weapon_count_type5);
			nbt.putDouble("spell4_weapon_count_type6", spell4_weapon_count_type6);
			nbt.putDouble("spell4_weapon_count_type7", spell4_weapon_count_type7);
			nbt.putString("spell4_weapon_type", spell4_weapon_type);
			nbt.putString("spell4_weapon_type_tag", spell4_weapon_type_tag);
			nbt.putBoolean("spell5_always_gen", spell5_always_gen);
			nbt.putString("spell5_circle_frequency", spell5_circle_frequency);
			nbt.putDouble("spell5_circle_frequency_save", spell5_circle_frequency_save);
			nbt.putString("spell5_degree_frequency", spell5_degree_frequency);
			nbt.putDouble("spell5_degree_frequency_save", spell5_degree_frequency_save);
			nbt.putString("spell5_down", spell5_down);
			nbt.putBoolean("spell5_gen", spell5_gen);
			nbt.putString("spell5_height", spell5_height);
			nbt.putString("spell5_no_wall", spell5_no_wall);
			nbt.putBoolean("spell5_pause", spell5_pause);
			nbt.putString("spell5_radius", spell5_radius);
			nbt.putDouble("spell5_radius_save", spell5_radius_save);
			nbt.putBoolean("spell5_remove", spell5_remove);
			nbt.putString("spell5_room", spell5_room);
			nbt.putString("spell5_safe_zone", spell5_safe_zone);
			nbt.putDouble("spell5_safe_zone_360", spell5_safe_zone_360);
			nbt.putDouble("spell5_safe_zone_save", spell5_safe_zone_save);
			nbt.putBoolean("spell5_show_trap", spell5_show_trap);
			nbt.putString("spell5_spin", spell5_spin);
			nbt.putBoolean("spell5_start", spell5_start);
			nbt.putString("spell5_thickness", spell5_thickness);
			nbt.putString("spell5_trap", spell5_trap);
			nbt.putDouble("spell5_trap_degree", spell5_trap_degree);
			nbt.putBoolean("spell6_create", spell6_create);
			nbt.putBoolean("spell6_pause", spell6_pause);
			nbt.putBoolean("spell6_start_repeat", spell6_start_repeat);
			nbt.putDouble("spell7_book_cost", spell7_book_cost);
			nbt.putDouble("spell7_book_degree", spell7_book_degree);
			nbt.putString("spell7_book_id", spell7_book_id);
			nbt.putString("spell7_book_id_custom", spell7_book_id_custom);
			nbt.putDouble("spell7_book_id_number", spell7_book_id_number);
			nbt.putDouble("spell7_book_id_number_spell", spell7_book_id_number_spell);
			nbt.putDouble("spell7_book_number", spell7_book_number);
			nbt.putDouble("spell7_book_time", spell7_book_time);
			nbt.putString("spell7_book_time_text", spell7_book_time_text);
			nbt.putBoolean("spell7_can_generate", spell7_can_generate);
			nbt.putDouble("spell7_duration", spell7_duration);
			nbt.putDouble("spell7_fly_updown", spell7_fly_updown);
			nbt.putString("spell7_generator1", spell7_generator1);
			nbt.putString("spell7_generator1_id", spell7_generator1_id);
			nbt.putDouble("spell7_generator1_pos", spell7_generator1_pos);
			nbt.putDouble("spell7_generator1_time", spell7_generator1_time);
			nbt.putString("spell7_generator2", spell7_generator2);
			nbt.putString("spell7_generator2_id", spell7_generator2_id);
			nbt.putDouble("spell7_generator2_pos", spell7_generator2_pos);
			nbt.putDouble("spell7_generator2_time", spell7_generator2_time);
			nbt.putString("spell7_generator3", spell7_generator3);
			nbt.putString("spell7_generator3_id", spell7_generator3_id);
			nbt.putDouble("spell7_generator3_pos", spell7_generator3_pos);
			nbt.putDouble("spell7_generator3_time", spell7_generator3_time);
			nbt.putDouble("spell7_mode", spell7_mode);
			nbt.putDouble("spell7_move", spell7_move);
			nbt.putBoolean("spell7_select", spell7_select);
			nbt.putBoolean("spell7_start", spell7_start);
			nbt.putDouble("spell7_temporary_number", spell7_temporary_number);
			nbt.putString("spell7_test_use", spell7_test_use);
			nbt.putString("spell7_type", spell7_type);
			nbt.putString("spell7_use", spell7_use);
			nbt.putString("spell7_use_double", spell7_use_double);
			nbt.putDouble("spell7_use_double_number", spell7_use_double_number);
			nbt.putBoolean("user_near_lantern", user_near_lantern);
			nbt.putBoolean("user_only", user_only);
			nbt.putString("who_can_see_plant_chat_bubble", who_can_see_plant_chat_bubble);
			nbt.putBoolean("spell7_show_key", spell7_show_key);
			return nbt;
		}

		public void syncData(IWorld world) {
			this.markDirty();
			if (world instanceof World && !world.isRemote())
				LotwMod.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), new WorldSavedDataSyncMessage(0, this));
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

	@CapabilityInject(PlayerVariables.class)
	public static Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = null;

	@SubscribeEvent
	public void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
		if (event.getObject() instanceof PlayerEntity && !(event.getObject() instanceof FakePlayer))
			event.addCapability(new ResourceLocation("lotw", "player_variables"), new PlayerVariablesProvider());
	}

	private static class PlayerVariablesProvider implements ICapabilitySerializable<INBT> {
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(PLAYER_VARIABLES_CAPABILITY::getDefaultInstance);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public INBT serializeNBT() {
			return PLAYER_VARIABLES_CAPABILITY.getStorage().writeNBT(PLAYER_VARIABLES_CAPABILITY, this.instance.orElseThrow(RuntimeException::new),
					null);
		}

		@Override
		public void deserializeNBT(INBT nbt) {
			PLAYER_VARIABLES_CAPABILITY.getStorage().readNBT(PLAYER_VARIABLES_CAPABILITY, this.instance.orElseThrow(RuntimeException::new), null,
					nbt);
		}
	}

	private static class PlayerVariablesStorage implements Capability.IStorage<PlayerVariables> {
		@Override
		public INBT writeNBT(Capability<PlayerVariables> capability, PlayerVariables instance, Direction side) {
			CompoundNBT nbt = new CompoundNBT();
			nbt.putString("spell4_overlay", instance.spell4_overlay);
			nbt.putString("spell7_overlay", instance.spell7_overlay);
			return nbt;
		}

		@Override
		public void readNBT(Capability<PlayerVariables> capability, PlayerVariables instance, Direction side, INBT inbt) {
			CompoundNBT nbt = (CompoundNBT) inbt;
			instance.spell4_overlay = nbt.getString("spell4_overlay");
			instance.spell7_overlay = nbt.getString("spell7_overlay");
		}
	}

	public static class PlayerVariables {
		public String spell4_overlay = "On";
		public String spell7_overlay = "On";

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayerEntity)
				LotwMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) entity), new PlayerVariablesSyncMessage(this));
		}
	}

	@SubscribeEvent
	public void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
		if (!event.getPlayer().world.isRemote())
			((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
					.syncPlayerVariables(event.getPlayer());
	}

	@SubscribeEvent
	public void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
		if (!event.getPlayer().world.isRemote())
			((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
					.syncPlayerVariables(event.getPlayer());
	}

	@SubscribeEvent
	public void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
		if (!event.getPlayer().world.isRemote())
			((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
					.syncPlayerVariables(event.getPlayer());
	}

	@SubscribeEvent
	public void clonePlayer(PlayerEvent.Clone event) {
		PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new PlayerVariables()));
		PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
		clone.spell4_overlay = original.spell4_overlay;
		clone.spell7_overlay = original.spell7_overlay;
		if (!event.isWasDeath()) {
		}
	}

	public static class PlayerVariablesSyncMessage {
		public PlayerVariables data;

		public PlayerVariablesSyncMessage(PacketBuffer buffer) {
			this.data = new PlayerVariables();
			new PlayerVariablesStorage().readNBT(null, this.data, null, buffer.readCompoundTag());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, PacketBuffer buffer) {
			buffer.writeCompoundTag((CompoundNBT) new PlayerVariablesStorage().writeNBT(null, message.data, null));
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new PlayerVariables()));
					variables.spell4_overlay = message.data.spell4_overlay;
					variables.spell7_overlay = message.data.spell7_overlay;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
