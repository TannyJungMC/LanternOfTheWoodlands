package tannyjung.lanternofthewoodlands.network;

import tannyjung.lanternofthewoodlands.LanternofthewoodlandsMod;

import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.client.Minecraft;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class LanternofthewoodlandsModVariables {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		LanternofthewoodlandsMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
	}

	@SubscribeEvent
	public static void init(RegisterCapabilitiesEvent event) {
		event.register(PlayerVariables.class);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			event.getOriginal().revive();
			PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			clone.agreement_accept = original.agreement_accept;
			clone.ally_list_auto1 = original.ally_list_auto1;
			clone.ally_list_auto2 = original.ally_list_auto2;
			clone.ally_list_auto3 = original.ally_list_auto3;
			clone.ally_list_chat_setting = original.ally_list_chat_setting;
			clone.ally_list_manual = original.ally_list_manual;
			clone.alternative_keyboard = original.alternative_keyboard;
			clone.alternative_keyboard_save = original.alternative_keyboard_save;
			clone.alternative_keyboard_save2 = original.alternative_keyboard_save2;
			clone.alternative_keyboard_save3 = original.alternative_keyboard_save3;
			clone.alternative_keyboard_save4 = original.alternative_keyboard_save4;
			clone.alternative_keyboard_save5 = original.alternative_keyboard_save5;
			clone.alternative_keyboard_save6 = original.alternative_keyboard_save6;
			clone.book_compass_custom_posX = original.book_compass_custom_posX;
			clone.book_compass_custom_posZ = original.book_compass_custom_posZ;
			clone.book_log_display_info = original.book_log_display_info;
			clone.book_log_display_info_duration = original.book_log_display_info_duration;
			clone.book_log_display_notification = original.book_log_display_notification;
			clone.book_log_display_notification_duraation = original.book_log_display_notification_duraation;
			clone.book_log_display_notification_duration = original.book_log_display_notification_duration;
			clone.book_log_type = original.book_log_type;
			clone.book_page = original.book_page;
			clone.book_shortcut_custom = original.book_shortcut_custom;
			clone.id = original.id;
			clone.main_key = original.main_key;
			clone.mana = original.mana;
			clone.mana_charge = original.mana_charge;
			clone.mana_max = original.mana_max;
			clone.personal_skill = original.personal_skill;
			clone.personal_skill_cooldown = original.personal_skill_cooldown;
			clone.personal_skill_custom = original.personal_skill_custom;
			clone.personal_skill_custom_value = original.personal_skill_custom_value;
			clone.personal_skill_duration = original.personal_skill_duration;
			clone.personal_skill_level = original.personal_skill_level;
			clone.personal_skill_loop_second = original.personal_skill_loop_second;
			clone.personal_skill_loop_tick = original.personal_skill_loop_tick;
			clone.personal_skill_radius = original.personal_skill_radius;
			clone.personal_skill_skill_blink = original.personal_skill_skill_blink;
			clone.personal_skill_skill_circle_of_healing = original.personal_skill_skill_circle_of_healing;
			clone.personal_skill_skill_rejuvenating_mushroom = original.personal_skill_skill_rejuvenating_mushroom;
			clone.personal_skill_skill_the_missing_person = original.personal_skill_skill_the_missing_person;
			clone.personal_skill_upgrade = original.personal_skill_upgrade;
			clone.personal_weapon = original.personal_weapon;
			clone.personal_weapon_flying = original.personal_weapon_flying;
			clone.personal_weapon_flying_tick = original.personal_weapon_flying_tick;
			clone.personal_weapon_place = original.personal_weapon_place;
			clone.personal_weapon_pos_x = original.personal_weapon_pos_x;
			clone.personal_weapon_pos_y = original.personal_weapon_pos_y;
			clone.personal_weapon_pos_z = original.personal_weapon_pos_z;
			clone.personal_weapon_pose_x = original.personal_weapon_pose_x;
			clone.personal_weapon_pose_y = original.personal_weapon_pose_y;
			clone.personal_weapon_pose_z = original.personal_weapon_pose_z;
			clone.personal_weapon_rotation = original.personal_weapon_rotation;
			clone.personal_weapon_rotation_reverse = original.personal_weapon_rotation_reverse;
			clone.personal_weapon_show_center = original.personal_weapon_show_center;
			clone.player_tick_second = original.player_tick_second;
			clone.player_tick_tick = original.player_tick_tick;
			clone.spell = original.spell;
			clone.spell4_ability = original.spell4_ability;
			clone.spell4_ability_cooldown = original.spell4_ability_cooldown;
			clone.spell4_ability_duration = original.spell4_ability_duration;
			clone.spell4_auto_shot_cooldown = original.spell4_auto_shot_cooldown;
			clone.spell4_can_summon = original.spell4_can_summon;
			clone.spell4_constant = original.spell4_constant;
			clone.spell4_distance = original.spell4_distance;
			clone.spell4_distance_set = original.spell4_distance_set;
			clone.spell4_distancing_in = original.spell4_distancing_in;
			clone.spell4_distancing_out = original.spell4_distancing_out;
			clone.spell4_distancing_speed = original.spell4_distancing_speed;
			clone.spell4_guard_pose = original.spell4_guard_pose;
			clone.spell4_guard_pose_distance = original.spell4_guard_pose_distance;
			clone.spell4_homing = original.spell4_homing;
			clone.spell4_lock_reverse = original.spell4_lock_reverse;
			clone.spell4_lock_shoot = original.spell4_lock_shoot;
			clone.spell4_lock_target = original.spell4_lock_target;
			clone.spell4_mode = original.spell4_mode;
			clone.spell4_pause_at_mark = original.spell4_pause_at_mark;
			clone.spell4_pause_balancing = original.spell4_pause_balancing;
			clone.spell4_pause_boundary = original.spell4_pause_boundary;
			clone.spell4_pause_gravity = original.spell4_pause_gravity;
			clone.spell4_pause_rotation = original.spell4_pause_rotation;
			clone.spell4_reverse = original.spell4_reverse;
			clone.spell4_shoot = original.spell4_shoot;
			clone.spell4_show_overlay = original.spell4_show_overlay;
			clone.spell4_show_target_arrow = original.spell4_show_target_arrow;
			clone.spell4_skill_sword_skill_hidden_objects = original.spell4_skill_sword_skill_hidden_objects;
			clone.spell4_tick_auto_shot = original.spell4_tick_auto_shot;
			clone.spell4_tick_fly_updown = original.spell4_tick_fly_updown;
			clone.spell4_tick_summon = original.spell4_tick_summon;
			clone.spell4_type = original.spell4_type;
			clone.spell4_type_tag = original.spell4_type_tag;
			clone.spell4_weapon_anchor_count = original.spell4_weapon_anchor_count;
			clone.spell4_weapon_anchor_count_max = original.spell4_weapon_anchor_count_max;
			clone.spell4_weapon_anchor_level = original.spell4_weapon_anchor_level;
			clone.spell4_weapon_bow_count = original.spell4_weapon_bow_count;
			clone.spell4_weapon_bow_count_max = original.spell4_weapon_bow_count_max;
			clone.spell4_weapon_bow_level = original.spell4_weapon_bow_level;
			clone.spell4_weapon_knight_sword_count = original.spell4_weapon_knight_sword_count;
			clone.spell4_weapon_knight_sword_count_max = original.spell4_weapon_knight_sword_count_max;
			clone.spell4_weapon_lantern_count = original.spell4_weapon_lantern_count;
			clone.spell4_weapon_lantern_count_max = original.spell4_weapon_lantern_count_max;
			clone.spell4_weapon_lantern_level = original.spell4_weapon_lantern_level;
			clone.spell4_weapon_shield_count = original.spell4_weapon_shield_count;
			clone.spell4_weapon_shield_count_max = original.spell4_weapon_shield_count_max;
			clone.spell4_weapon_shield_level = original.spell4_weapon_shield_level;
			clone.spell4_weapon_sword_count = original.spell4_weapon_sword_count;
			clone.spell4_weapon_sword_count_max = original.spell4_weapon_sword_count_max;
			clone.spell4_weapon_sword_level = original.spell4_weapon_sword_level;
			clone.tick = original.tick;
			clone.user_book_flying_tick = original.user_book_flying_tick;
			clone.user_book_item_open = original.user_book_item_open;
			clone.user_book_place = original.user_book_place;
			clone.user_book_posX = original.user_book_posX;
			clone.user_book_posY = original.user_book_posY;
			clone.user_book_posZ = original.user_book_posZ;
			clone.user_DELETE_THIS = original.user_DELETE_THIS;
			clone.user = original.user;
			clone.spell4_ability_cooldown_max = original.spell4_ability_cooldown_max;
			clone.spell4_ability_duration_max = original.spell4_ability_duration_max;
			if (!event.isWasDeath()) {
			}
		}
	}

	public static final Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerVariables>() {
	});

	@Mod.EventBusSubscriber
	private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
		@SubscribeEvent
		public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
			if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer))
				event.addCapability(new ResourceLocation("lanternofthewoodlands", "player_variables"), new PlayerVariablesProvider());
		}

		private final PlayerVariables playerVariables = new PlayerVariables();
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(() -> playerVariables);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public Tag serializeNBT() {
			return playerVariables.writeNBT();
		}

		@Override
		public void deserializeNBT(Tag nbt) {
			playerVariables.readNBT(nbt);
		}
	}

	public static class PlayerVariables {
		public boolean agreement_accept = false;
		public String ally_list_auto1 = "";
		public String ally_list_auto2 = "";
		public String ally_list_auto3 = "";
		public String ally_list_chat_setting = "";
		public String ally_list_manual = "";
		public String alternative_keyboard = "";
		public String alternative_keyboard_save = "";
		public String alternative_keyboard_save2 = "";
		public String alternative_keyboard_save3 = "";
		public String alternative_keyboard_save4 = "";
		public String alternative_keyboard_save5 = "";
		public String alternative_keyboard_save6 = "";
		public double book_compass_custom_posX = 0;
		public double book_compass_custom_posZ = 0;
		public String book_log_display_info = "";
		public double book_log_display_info_duration = 0;
		public String book_log_display_notification = "";
		public String book_log_display_notification_duraation = "";
		public double book_log_display_notification_duration = 0;
		public String book_log_type = "";
		public double book_page = 0.0;
		public double book_shortcut_custom = 0;
		public String id = "";
		public boolean main_key = false;
		public double mana = 0;
		public double mana_charge = 0;
		public double mana_max = 0;
		public String personal_skill = "";
		public double personal_skill_cooldown = 0;
		public String personal_skill_custom = "";
		public String personal_skill_custom_value = "";
		public double personal_skill_duration = 0;
		public double personal_skill_level = 0;
		public boolean personal_skill_loop_second = false;
		public boolean personal_skill_loop_tick = false;
		public double personal_skill_radius = 0;
		public boolean personal_skill_skill_blink = false;
		public boolean personal_skill_skill_circle_of_healing = false;
		public boolean personal_skill_skill_rejuvenating_mushroom = false;
		public boolean personal_skill_skill_the_missing_person = false;
		public String personal_skill_upgrade = "";
		public ItemStack personal_weapon = ItemStack.EMPTY;
		public boolean personal_weapon_flying = false;
		public double personal_weapon_flying_tick = 0;
		public boolean personal_weapon_place = false;
		public double personal_weapon_pos_x = 0;
		public double personal_weapon_pos_y = 0;
		public double personal_weapon_pos_z = 0;
		public double personal_weapon_pose_x = 0;
		public double personal_weapon_pose_y = 0;
		public double personal_weapon_pose_z = 0;
		public boolean personal_weapon_rotation = false;
		public boolean personal_weapon_rotation_reverse = false;
		public boolean personal_weapon_show_center = false;
		public double player_tick_second = 0;
		public double player_tick_tick = 0;
		public double spell = 0;
		public String spell4_ability = "";
		public double spell4_ability_cooldown = 0;
		public double spell4_ability_duration = 0;
		public double spell4_auto_shot_cooldown = 0;
		public boolean spell4_can_summon = false;
		public boolean spell4_constant = false;
		public double spell4_distance = 0;
		public double spell4_distance_set = 0;
		public double spell4_distancing_in = 0;
		public double spell4_distancing_out = 0;
		public double spell4_distancing_speed = 0;
		public boolean spell4_guard_pose = false;
		public double spell4_guard_pose_distance = 0;
		public boolean spell4_homing = false;
		public boolean spell4_lock_reverse = false;
		public boolean spell4_lock_shoot = false;
		public boolean spell4_lock_target = false;
		public String spell4_mode = "";
		public boolean spell4_pause_at_mark = false;
		public boolean spell4_pause_balancing = false;
		public double spell4_pause_boundary = 0;
		public boolean spell4_pause_gravity = false;
		public double spell4_pause_rotation = 0;
		public boolean spell4_reverse = false;
		public boolean spell4_shoot = false;
		public boolean spell4_show_overlay = false;
		public boolean spell4_show_target_arrow = false;
		public boolean spell4_skill_sword_skill_hidden_objects = false;
		public double spell4_tick_auto_shot = 0;
		public double spell4_tick_fly_updown = 0;
		public double spell4_tick_summon = 0;
		public String spell4_type = "";
		public String spell4_type_tag = "";
		public double spell4_weapon_anchor_count = 0;
		public double spell4_weapon_anchor_count_max = 0;
		public double spell4_weapon_anchor_level = 0;
		public double spell4_weapon_bow_count = 0;
		public double spell4_weapon_bow_count_max = 0;
		public double spell4_weapon_bow_level = 0;
		public double spell4_weapon_knight_sword_count = 0;
		public double spell4_weapon_knight_sword_count_max = 0;
		public double spell4_weapon_lantern_count = 0;
		public double spell4_weapon_lantern_count_max = 0;
		public double spell4_weapon_lantern_level = 0;
		public double spell4_weapon_shield_count = 0;
		public double spell4_weapon_shield_count_max = 0;
		public double spell4_weapon_shield_level = 0;
		public double spell4_weapon_sword_count = 0;
		public double spell4_weapon_sword_count_max = 0;
		public double spell4_weapon_sword_level = 0;
		public double tick = 0;
		public double user_book_flying_tick = 0;
		public boolean user_book_item_open = false;
		public boolean user_book_place = false;
		public double user_book_posX = 0;
		public double user_book_posY = 0.0;
		public double user_book_posZ = 0;
		public String user_DELETE_THIS = "";
		public boolean user = false;
		public double spell4_ability_cooldown_max = 0;
		public double spell4_ability_duration_max = 0;

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				LanternofthewoodlandsMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new PlayerVariablesSyncMessage(this));
		}

		public Tag writeNBT() {
			CompoundTag nbt = new CompoundTag();
			nbt.putBoolean("agreement_accept", agreement_accept);
			nbt.putString("ally_list_auto1", ally_list_auto1);
			nbt.putString("ally_list_auto2", ally_list_auto2);
			nbt.putString("ally_list_auto3", ally_list_auto3);
			nbt.putString("ally_list_chat_setting", ally_list_chat_setting);
			nbt.putString("ally_list_manual", ally_list_manual);
			nbt.putString("alternative_keyboard", alternative_keyboard);
			nbt.putString("alternative_keyboard_save", alternative_keyboard_save);
			nbt.putString("alternative_keyboard_save2", alternative_keyboard_save2);
			nbt.putString("alternative_keyboard_save3", alternative_keyboard_save3);
			nbt.putString("alternative_keyboard_save4", alternative_keyboard_save4);
			nbt.putString("alternative_keyboard_save5", alternative_keyboard_save5);
			nbt.putString("alternative_keyboard_save6", alternative_keyboard_save6);
			nbt.putDouble("book_compass_custom_posX", book_compass_custom_posX);
			nbt.putDouble("book_compass_custom_posZ", book_compass_custom_posZ);
			nbt.putString("book_log_display_info", book_log_display_info);
			nbt.putDouble("book_log_display_info_duration", book_log_display_info_duration);
			nbt.putString("book_log_display_notification", book_log_display_notification);
			nbt.putString("book_log_display_notification_duraation", book_log_display_notification_duraation);
			nbt.putDouble("book_log_display_notification_duration", book_log_display_notification_duration);
			nbt.putString("book_log_type", book_log_type);
			nbt.putDouble("book_page", book_page);
			nbt.putDouble("book_shortcut_custom", book_shortcut_custom);
			nbt.putString("id", id);
			nbt.putBoolean("main_key", main_key);
			nbt.putDouble("mana", mana);
			nbt.putDouble("mana_charge", mana_charge);
			nbt.putDouble("mana_max", mana_max);
			nbt.putString("personal_skill", personal_skill);
			nbt.putDouble("personal_skill_cooldown", personal_skill_cooldown);
			nbt.putString("personal_skill_custom", personal_skill_custom);
			nbt.putString("personal_skill_custom_value", personal_skill_custom_value);
			nbt.putDouble("personal_skill_duration", personal_skill_duration);
			nbt.putDouble("personal_skill_level", personal_skill_level);
			nbt.putBoolean("personal_skill_loop_second", personal_skill_loop_second);
			nbt.putBoolean("personal_skill_loop_tick", personal_skill_loop_tick);
			nbt.putDouble("personal_skill_radius", personal_skill_radius);
			nbt.putBoolean("personal_skill_skill_blink", personal_skill_skill_blink);
			nbt.putBoolean("personal_skill_skill_circle_of_healing", personal_skill_skill_circle_of_healing);
			nbt.putBoolean("personal_skill_skill_rejuvenating_mushroom", personal_skill_skill_rejuvenating_mushroom);
			nbt.putBoolean("personal_skill_skill_the_missing_person", personal_skill_skill_the_missing_person);
			nbt.putString("personal_skill_upgrade", personal_skill_upgrade);
			nbt.put("personal_weapon", personal_weapon.save(new CompoundTag()));
			nbt.putBoolean("personal_weapon_flying", personal_weapon_flying);
			nbt.putDouble("personal_weapon_flying_tick", personal_weapon_flying_tick);
			nbt.putBoolean("personal_weapon_place", personal_weapon_place);
			nbt.putDouble("personal_weapon_pos_x", personal_weapon_pos_x);
			nbt.putDouble("personal_weapon_pos_y", personal_weapon_pos_y);
			nbt.putDouble("personal_weapon_pos_z", personal_weapon_pos_z);
			nbt.putDouble("personal_weapon_pose_x", personal_weapon_pose_x);
			nbt.putDouble("personal_weapon_pose_y", personal_weapon_pose_y);
			nbt.putDouble("personal_weapon_pose_z", personal_weapon_pose_z);
			nbt.putBoolean("personal_weapon_rotation", personal_weapon_rotation);
			nbt.putBoolean("personal_weapon_rotation_reverse", personal_weapon_rotation_reverse);
			nbt.putBoolean("personal_weapon_show_center", personal_weapon_show_center);
			nbt.putDouble("player_tick_second", player_tick_second);
			nbt.putDouble("player_tick_tick", player_tick_tick);
			nbt.putDouble("spell", spell);
			nbt.putString("spell4_ability", spell4_ability);
			nbt.putDouble("spell4_ability_cooldown", spell4_ability_cooldown);
			nbt.putDouble("spell4_ability_duration", spell4_ability_duration);
			nbt.putDouble("spell4_auto_shot_cooldown", spell4_auto_shot_cooldown);
			nbt.putBoolean("spell4_can_summon", spell4_can_summon);
			nbt.putBoolean("spell4_constant", spell4_constant);
			nbt.putDouble("spell4_distance", spell4_distance);
			nbt.putDouble("spell4_distance_set", spell4_distance_set);
			nbt.putDouble("spell4_distancing_in", spell4_distancing_in);
			nbt.putDouble("spell4_distancing_out", spell4_distancing_out);
			nbt.putDouble("spell4_distancing_speed", spell4_distancing_speed);
			nbt.putBoolean("spell4_guard_pose", spell4_guard_pose);
			nbt.putDouble("spell4_guard_pose_distance", spell4_guard_pose_distance);
			nbt.putBoolean("spell4_homing", spell4_homing);
			nbt.putBoolean("spell4_lock_reverse", spell4_lock_reverse);
			nbt.putBoolean("spell4_lock_shoot", spell4_lock_shoot);
			nbt.putBoolean("spell4_lock_target", spell4_lock_target);
			nbt.putString("spell4_mode", spell4_mode);
			nbt.putBoolean("spell4_pause_at_mark", spell4_pause_at_mark);
			nbt.putBoolean("spell4_pause_balancing", spell4_pause_balancing);
			nbt.putDouble("spell4_pause_boundary", spell4_pause_boundary);
			nbt.putBoolean("spell4_pause_gravity", spell4_pause_gravity);
			nbt.putDouble("spell4_pause_rotation", spell4_pause_rotation);
			nbt.putBoolean("spell4_reverse", spell4_reverse);
			nbt.putBoolean("spell4_shoot", spell4_shoot);
			nbt.putBoolean("spell4_show_overlay", spell4_show_overlay);
			nbt.putBoolean("spell4_show_target_arrow", spell4_show_target_arrow);
			nbt.putBoolean("spell4_skill_sword_skill_hidden_objects", spell4_skill_sword_skill_hidden_objects);
			nbt.putDouble("spell4_tick_auto_shot", spell4_tick_auto_shot);
			nbt.putDouble("spell4_tick_fly_updown", spell4_tick_fly_updown);
			nbt.putDouble("spell4_tick_summon", spell4_tick_summon);
			nbt.putString("spell4_type", spell4_type);
			nbt.putString("spell4_type_tag", spell4_type_tag);
			nbt.putDouble("spell4_weapon_anchor_count", spell4_weapon_anchor_count);
			nbt.putDouble("spell4_weapon_anchor_count_max", spell4_weapon_anchor_count_max);
			nbt.putDouble("spell4_weapon_anchor_level", spell4_weapon_anchor_level);
			nbt.putDouble("spell4_weapon_bow_count", spell4_weapon_bow_count);
			nbt.putDouble("spell4_weapon_bow_count_max", spell4_weapon_bow_count_max);
			nbt.putDouble("spell4_weapon_bow_level", spell4_weapon_bow_level);
			nbt.putDouble("spell4_weapon_knight_sword_count", spell4_weapon_knight_sword_count);
			nbt.putDouble("spell4_weapon_knight_sword_count_max", spell4_weapon_knight_sword_count_max);
			nbt.putDouble("spell4_weapon_lantern_count", spell4_weapon_lantern_count);
			nbt.putDouble("spell4_weapon_lantern_count_max", spell4_weapon_lantern_count_max);
			nbt.putDouble("spell4_weapon_lantern_level", spell4_weapon_lantern_level);
			nbt.putDouble("spell4_weapon_shield_count", spell4_weapon_shield_count);
			nbt.putDouble("spell4_weapon_shield_count_max", spell4_weapon_shield_count_max);
			nbt.putDouble("spell4_weapon_shield_level", spell4_weapon_shield_level);
			nbt.putDouble("spell4_weapon_sword_count", spell4_weapon_sword_count);
			nbt.putDouble("spell4_weapon_sword_count_max", spell4_weapon_sword_count_max);
			nbt.putDouble("spell4_weapon_sword_level", spell4_weapon_sword_level);
			nbt.putDouble("tick", tick);
			nbt.putDouble("user_book_flying_tick", user_book_flying_tick);
			nbt.putBoolean("user_book_item_open", user_book_item_open);
			nbt.putBoolean("user_book_place", user_book_place);
			nbt.putDouble("user_book_posX", user_book_posX);
			nbt.putDouble("user_book_posY", user_book_posY);
			nbt.putDouble("user_book_posZ", user_book_posZ);
			nbt.putString("user_DELETE_THIS", user_DELETE_THIS);
			nbt.putBoolean("user", user);
			nbt.putDouble("spell4_ability_cooldown_max", spell4_ability_cooldown_max);
			nbt.putDouble("spell4_ability_duration_max", spell4_ability_duration_max);
			return nbt;
		}

		public void readNBT(Tag tag) {
			CompoundTag nbt = (CompoundTag) tag;
			agreement_accept = nbt.getBoolean("agreement_accept");
			ally_list_auto1 = nbt.getString("ally_list_auto1");
			ally_list_auto2 = nbt.getString("ally_list_auto2");
			ally_list_auto3 = nbt.getString("ally_list_auto3");
			ally_list_chat_setting = nbt.getString("ally_list_chat_setting");
			ally_list_manual = nbt.getString("ally_list_manual");
			alternative_keyboard = nbt.getString("alternative_keyboard");
			alternative_keyboard_save = nbt.getString("alternative_keyboard_save");
			alternative_keyboard_save2 = nbt.getString("alternative_keyboard_save2");
			alternative_keyboard_save3 = nbt.getString("alternative_keyboard_save3");
			alternative_keyboard_save4 = nbt.getString("alternative_keyboard_save4");
			alternative_keyboard_save5 = nbt.getString("alternative_keyboard_save5");
			alternative_keyboard_save6 = nbt.getString("alternative_keyboard_save6");
			book_compass_custom_posX = nbt.getDouble("book_compass_custom_posX");
			book_compass_custom_posZ = nbt.getDouble("book_compass_custom_posZ");
			book_log_display_info = nbt.getString("book_log_display_info");
			book_log_display_info_duration = nbt.getDouble("book_log_display_info_duration");
			book_log_display_notification = nbt.getString("book_log_display_notification");
			book_log_display_notification_duraation = nbt.getString("book_log_display_notification_duraation");
			book_log_display_notification_duration = nbt.getDouble("book_log_display_notification_duration");
			book_log_type = nbt.getString("book_log_type");
			book_page = nbt.getDouble("book_page");
			book_shortcut_custom = nbt.getDouble("book_shortcut_custom");
			id = nbt.getString("id");
			main_key = nbt.getBoolean("main_key");
			mana = nbt.getDouble("mana");
			mana_charge = nbt.getDouble("mana_charge");
			mana_max = nbt.getDouble("mana_max");
			personal_skill = nbt.getString("personal_skill");
			personal_skill_cooldown = nbt.getDouble("personal_skill_cooldown");
			personal_skill_custom = nbt.getString("personal_skill_custom");
			personal_skill_custom_value = nbt.getString("personal_skill_custom_value");
			personal_skill_duration = nbt.getDouble("personal_skill_duration");
			personal_skill_level = nbt.getDouble("personal_skill_level");
			personal_skill_loop_second = nbt.getBoolean("personal_skill_loop_second");
			personal_skill_loop_tick = nbt.getBoolean("personal_skill_loop_tick");
			personal_skill_radius = nbt.getDouble("personal_skill_radius");
			personal_skill_skill_blink = nbt.getBoolean("personal_skill_skill_blink");
			personal_skill_skill_circle_of_healing = nbt.getBoolean("personal_skill_skill_circle_of_healing");
			personal_skill_skill_rejuvenating_mushroom = nbt.getBoolean("personal_skill_skill_rejuvenating_mushroom");
			personal_skill_skill_the_missing_person = nbt.getBoolean("personal_skill_skill_the_missing_person");
			personal_skill_upgrade = nbt.getString("personal_skill_upgrade");
			personal_weapon = ItemStack.of(nbt.getCompound("personal_weapon"));
			personal_weapon_flying = nbt.getBoolean("personal_weapon_flying");
			personal_weapon_flying_tick = nbt.getDouble("personal_weapon_flying_tick");
			personal_weapon_place = nbt.getBoolean("personal_weapon_place");
			personal_weapon_pos_x = nbt.getDouble("personal_weapon_pos_x");
			personal_weapon_pos_y = nbt.getDouble("personal_weapon_pos_y");
			personal_weapon_pos_z = nbt.getDouble("personal_weapon_pos_z");
			personal_weapon_pose_x = nbt.getDouble("personal_weapon_pose_x");
			personal_weapon_pose_y = nbt.getDouble("personal_weapon_pose_y");
			personal_weapon_pose_z = nbt.getDouble("personal_weapon_pose_z");
			personal_weapon_rotation = nbt.getBoolean("personal_weapon_rotation");
			personal_weapon_rotation_reverse = nbt.getBoolean("personal_weapon_rotation_reverse");
			personal_weapon_show_center = nbt.getBoolean("personal_weapon_show_center");
			player_tick_second = nbt.getDouble("player_tick_second");
			player_tick_tick = nbt.getDouble("player_tick_tick");
			spell = nbt.getDouble("spell");
			spell4_ability = nbt.getString("spell4_ability");
			spell4_ability_cooldown = nbt.getDouble("spell4_ability_cooldown");
			spell4_ability_duration = nbt.getDouble("spell4_ability_duration");
			spell4_auto_shot_cooldown = nbt.getDouble("spell4_auto_shot_cooldown");
			spell4_can_summon = nbt.getBoolean("spell4_can_summon");
			spell4_constant = nbt.getBoolean("spell4_constant");
			spell4_distance = nbt.getDouble("spell4_distance");
			spell4_distance_set = nbt.getDouble("spell4_distance_set");
			spell4_distancing_in = nbt.getDouble("spell4_distancing_in");
			spell4_distancing_out = nbt.getDouble("spell4_distancing_out");
			spell4_distancing_speed = nbt.getDouble("spell4_distancing_speed");
			spell4_guard_pose = nbt.getBoolean("spell4_guard_pose");
			spell4_guard_pose_distance = nbt.getDouble("spell4_guard_pose_distance");
			spell4_homing = nbt.getBoolean("spell4_homing");
			spell4_lock_reverse = nbt.getBoolean("spell4_lock_reverse");
			spell4_lock_shoot = nbt.getBoolean("spell4_lock_shoot");
			spell4_lock_target = nbt.getBoolean("spell4_lock_target");
			spell4_mode = nbt.getString("spell4_mode");
			spell4_pause_at_mark = nbt.getBoolean("spell4_pause_at_mark");
			spell4_pause_balancing = nbt.getBoolean("spell4_pause_balancing");
			spell4_pause_boundary = nbt.getDouble("spell4_pause_boundary");
			spell4_pause_gravity = nbt.getBoolean("spell4_pause_gravity");
			spell4_pause_rotation = nbt.getDouble("spell4_pause_rotation");
			spell4_reverse = nbt.getBoolean("spell4_reverse");
			spell4_shoot = nbt.getBoolean("spell4_shoot");
			spell4_show_overlay = nbt.getBoolean("spell4_show_overlay");
			spell4_show_target_arrow = nbt.getBoolean("spell4_show_target_arrow");
			spell4_skill_sword_skill_hidden_objects = nbt.getBoolean("spell4_skill_sword_skill_hidden_objects");
			spell4_tick_auto_shot = nbt.getDouble("spell4_tick_auto_shot");
			spell4_tick_fly_updown = nbt.getDouble("spell4_tick_fly_updown");
			spell4_tick_summon = nbt.getDouble("spell4_tick_summon");
			spell4_type = nbt.getString("spell4_type");
			spell4_type_tag = nbt.getString("spell4_type_tag");
			spell4_weapon_anchor_count = nbt.getDouble("spell4_weapon_anchor_count");
			spell4_weapon_anchor_count_max = nbt.getDouble("spell4_weapon_anchor_count_max");
			spell4_weapon_anchor_level = nbt.getDouble("spell4_weapon_anchor_level");
			spell4_weapon_bow_count = nbt.getDouble("spell4_weapon_bow_count");
			spell4_weapon_bow_count_max = nbt.getDouble("spell4_weapon_bow_count_max");
			spell4_weapon_bow_level = nbt.getDouble("spell4_weapon_bow_level");
			spell4_weapon_knight_sword_count = nbt.getDouble("spell4_weapon_knight_sword_count");
			spell4_weapon_knight_sword_count_max = nbt.getDouble("spell4_weapon_knight_sword_count_max");
			spell4_weapon_lantern_count = nbt.getDouble("spell4_weapon_lantern_count");
			spell4_weapon_lantern_count_max = nbt.getDouble("spell4_weapon_lantern_count_max");
			spell4_weapon_lantern_level = nbt.getDouble("spell4_weapon_lantern_level");
			spell4_weapon_shield_count = nbt.getDouble("spell4_weapon_shield_count");
			spell4_weapon_shield_count_max = nbt.getDouble("spell4_weapon_shield_count_max");
			spell4_weapon_shield_level = nbt.getDouble("spell4_weapon_shield_level");
			spell4_weapon_sword_count = nbt.getDouble("spell4_weapon_sword_count");
			spell4_weapon_sword_count_max = nbt.getDouble("spell4_weapon_sword_count_max");
			spell4_weapon_sword_level = nbt.getDouble("spell4_weapon_sword_level");
			tick = nbt.getDouble("tick");
			user_book_flying_tick = nbt.getDouble("user_book_flying_tick");
			user_book_item_open = nbt.getBoolean("user_book_item_open");
			user_book_place = nbt.getBoolean("user_book_place");
			user_book_posX = nbt.getDouble("user_book_posX");
			user_book_posY = nbt.getDouble("user_book_posY");
			user_book_posZ = nbt.getDouble("user_book_posZ");
			user_DELETE_THIS = nbt.getString("user_DELETE_THIS");
			user = nbt.getBoolean("user");
			spell4_ability_cooldown_max = nbt.getDouble("spell4_ability_cooldown_max");
			spell4_ability_duration_max = nbt.getDouble("spell4_ability_duration_max");
		}
	}

	public static class PlayerVariablesSyncMessage {
		private final PlayerVariables data;

		public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
			this.data = new PlayerVariables();
			this.data.readNBT(buffer.readNbt());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeNbt((CompoundTag) message.data.writeNBT());
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
					variables.agreement_accept = message.data.agreement_accept;
					variables.ally_list_auto1 = message.data.ally_list_auto1;
					variables.ally_list_auto2 = message.data.ally_list_auto2;
					variables.ally_list_auto3 = message.data.ally_list_auto3;
					variables.ally_list_chat_setting = message.data.ally_list_chat_setting;
					variables.ally_list_manual = message.data.ally_list_manual;
					variables.alternative_keyboard = message.data.alternative_keyboard;
					variables.alternative_keyboard_save = message.data.alternative_keyboard_save;
					variables.alternative_keyboard_save2 = message.data.alternative_keyboard_save2;
					variables.alternative_keyboard_save3 = message.data.alternative_keyboard_save3;
					variables.alternative_keyboard_save4 = message.data.alternative_keyboard_save4;
					variables.alternative_keyboard_save5 = message.data.alternative_keyboard_save5;
					variables.alternative_keyboard_save6 = message.data.alternative_keyboard_save6;
					variables.book_compass_custom_posX = message.data.book_compass_custom_posX;
					variables.book_compass_custom_posZ = message.data.book_compass_custom_posZ;
					variables.book_log_display_info = message.data.book_log_display_info;
					variables.book_log_display_info_duration = message.data.book_log_display_info_duration;
					variables.book_log_display_notification = message.data.book_log_display_notification;
					variables.book_log_display_notification_duraation = message.data.book_log_display_notification_duraation;
					variables.book_log_display_notification_duration = message.data.book_log_display_notification_duration;
					variables.book_log_type = message.data.book_log_type;
					variables.book_page = message.data.book_page;
					variables.book_shortcut_custom = message.data.book_shortcut_custom;
					variables.id = message.data.id;
					variables.main_key = message.data.main_key;
					variables.mana = message.data.mana;
					variables.mana_charge = message.data.mana_charge;
					variables.mana_max = message.data.mana_max;
					variables.personal_skill = message.data.personal_skill;
					variables.personal_skill_cooldown = message.data.personal_skill_cooldown;
					variables.personal_skill_custom = message.data.personal_skill_custom;
					variables.personal_skill_custom_value = message.data.personal_skill_custom_value;
					variables.personal_skill_duration = message.data.personal_skill_duration;
					variables.personal_skill_level = message.data.personal_skill_level;
					variables.personal_skill_loop_second = message.data.personal_skill_loop_second;
					variables.personal_skill_loop_tick = message.data.personal_skill_loop_tick;
					variables.personal_skill_radius = message.data.personal_skill_radius;
					variables.personal_skill_skill_blink = message.data.personal_skill_skill_blink;
					variables.personal_skill_skill_circle_of_healing = message.data.personal_skill_skill_circle_of_healing;
					variables.personal_skill_skill_rejuvenating_mushroom = message.data.personal_skill_skill_rejuvenating_mushroom;
					variables.personal_skill_skill_the_missing_person = message.data.personal_skill_skill_the_missing_person;
					variables.personal_skill_upgrade = message.data.personal_skill_upgrade;
					variables.personal_weapon = message.data.personal_weapon;
					variables.personal_weapon_flying = message.data.personal_weapon_flying;
					variables.personal_weapon_flying_tick = message.data.personal_weapon_flying_tick;
					variables.personal_weapon_place = message.data.personal_weapon_place;
					variables.personal_weapon_pos_x = message.data.personal_weapon_pos_x;
					variables.personal_weapon_pos_y = message.data.personal_weapon_pos_y;
					variables.personal_weapon_pos_z = message.data.personal_weapon_pos_z;
					variables.personal_weapon_pose_x = message.data.personal_weapon_pose_x;
					variables.personal_weapon_pose_y = message.data.personal_weapon_pose_y;
					variables.personal_weapon_pose_z = message.data.personal_weapon_pose_z;
					variables.personal_weapon_rotation = message.data.personal_weapon_rotation;
					variables.personal_weapon_rotation_reverse = message.data.personal_weapon_rotation_reverse;
					variables.personal_weapon_show_center = message.data.personal_weapon_show_center;
					variables.player_tick_second = message.data.player_tick_second;
					variables.player_tick_tick = message.data.player_tick_tick;
					variables.spell = message.data.spell;
					variables.spell4_ability = message.data.spell4_ability;
					variables.spell4_ability_cooldown = message.data.spell4_ability_cooldown;
					variables.spell4_ability_duration = message.data.spell4_ability_duration;
					variables.spell4_auto_shot_cooldown = message.data.spell4_auto_shot_cooldown;
					variables.spell4_can_summon = message.data.spell4_can_summon;
					variables.spell4_constant = message.data.spell4_constant;
					variables.spell4_distance = message.data.spell4_distance;
					variables.spell4_distance_set = message.data.spell4_distance_set;
					variables.spell4_distancing_in = message.data.spell4_distancing_in;
					variables.spell4_distancing_out = message.data.spell4_distancing_out;
					variables.spell4_distancing_speed = message.data.spell4_distancing_speed;
					variables.spell4_guard_pose = message.data.spell4_guard_pose;
					variables.spell4_guard_pose_distance = message.data.spell4_guard_pose_distance;
					variables.spell4_homing = message.data.spell4_homing;
					variables.spell4_lock_reverse = message.data.spell4_lock_reverse;
					variables.spell4_lock_shoot = message.data.spell4_lock_shoot;
					variables.spell4_lock_target = message.data.spell4_lock_target;
					variables.spell4_mode = message.data.spell4_mode;
					variables.spell4_pause_at_mark = message.data.spell4_pause_at_mark;
					variables.spell4_pause_balancing = message.data.spell4_pause_balancing;
					variables.spell4_pause_boundary = message.data.spell4_pause_boundary;
					variables.spell4_pause_gravity = message.data.spell4_pause_gravity;
					variables.spell4_pause_rotation = message.data.spell4_pause_rotation;
					variables.spell4_reverse = message.data.spell4_reverse;
					variables.spell4_shoot = message.data.spell4_shoot;
					variables.spell4_show_overlay = message.data.spell4_show_overlay;
					variables.spell4_show_target_arrow = message.data.spell4_show_target_arrow;
					variables.spell4_skill_sword_skill_hidden_objects = message.data.spell4_skill_sword_skill_hidden_objects;
					variables.spell4_tick_auto_shot = message.data.spell4_tick_auto_shot;
					variables.spell4_tick_fly_updown = message.data.spell4_tick_fly_updown;
					variables.spell4_tick_summon = message.data.spell4_tick_summon;
					variables.spell4_type = message.data.spell4_type;
					variables.spell4_type_tag = message.data.spell4_type_tag;
					variables.spell4_weapon_anchor_count = message.data.spell4_weapon_anchor_count;
					variables.spell4_weapon_anchor_count_max = message.data.spell4_weapon_anchor_count_max;
					variables.spell4_weapon_anchor_level = message.data.spell4_weapon_anchor_level;
					variables.spell4_weapon_bow_count = message.data.spell4_weapon_bow_count;
					variables.spell4_weapon_bow_count_max = message.data.spell4_weapon_bow_count_max;
					variables.spell4_weapon_bow_level = message.data.spell4_weapon_bow_level;
					variables.spell4_weapon_knight_sword_count = message.data.spell4_weapon_knight_sword_count;
					variables.spell4_weapon_knight_sword_count_max = message.data.spell4_weapon_knight_sword_count_max;
					variables.spell4_weapon_lantern_count = message.data.spell4_weapon_lantern_count;
					variables.spell4_weapon_lantern_count_max = message.data.spell4_weapon_lantern_count_max;
					variables.spell4_weapon_lantern_level = message.data.spell4_weapon_lantern_level;
					variables.spell4_weapon_shield_count = message.data.spell4_weapon_shield_count;
					variables.spell4_weapon_shield_count_max = message.data.spell4_weapon_shield_count_max;
					variables.spell4_weapon_shield_level = message.data.spell4_weapon_shield_level;
					variables.spell4_weapon_sword_count = message.data.spell4_weapon_sword_count;
					variables.spell4_weapon_sword_count_max = message.data.spell4_weapon_sword_count_max;
					variables.spell4_weapon_sword_level = message.data.spell4_weapon_sword_level;
					variables.tick = message.data.tick;
					variables.user_book_flying_tick = message.data.user_book_flying_tick;
					variables.user_book_item_open = message.data.user_book_item_open;
					variables.user_book_place = message.data.user_book_place;
					variables.user_book_posX = message.data.user_book_posX;
					variables.user_book_posY = message.data.user_book_posY;
					variables.user_book_posZ = message.data.user_book_posZ;
					variables.user_DELETE_THIS = message.data.user_DELETE_THIS;
					variables.user = message.data.user;
					variables.spell4_ability_cooldown_max = message.data.spell4_ability_cooldown_max;
					variables.spell4_ability_duration_max = message.data.spell4_ability_duration_max;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
