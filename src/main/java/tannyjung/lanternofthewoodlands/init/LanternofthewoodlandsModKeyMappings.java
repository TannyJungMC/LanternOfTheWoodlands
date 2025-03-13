
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package tannyjung.lanternofthewoodlands.init;

import tannyjung.lanternofthewoodlands.network.Spell4keyTypeMessage;
import tannyjung.lanternofthewoodlands.network.MainKeyMessage;
import tannyjung.lanternofthewoodlands.network.KEYSpell4ShootMessage;
import tannyjung.lanternofthewoodlands.network.KEYSpell4ReverseMessage;
import tannyjung.lanternofthewoodlands.network.KEYSpell4ModeMessage;
import tannyjung.lanternofthewoodlands.network.KEYSpell4HomingMessage;
import tannyjung.lanternofthewoodlands.network.KEYSpell4DistanceReduceMessage;
import tannyjung.lanternofthewoodlands.network.KEYSpell4DistanceAddMessage;
import tannyjung.lanternofthewoodlands.network.KEYSpell4ConstantMessage;
import tannyjung.lanternofthewoodlands.network.KEYSpell4ActivateMessage;
import tannyjung.lanternofthewoodlands.network.KEYSpell4AbilityMessage;
import tannyjung.lanternofthewoodlands.network.KEYSPell4LockTargetMessage;
import tannyjung.lanternofthewoodlands.LanternofthewoodlandsMod;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class LanternofthewoodlandsModKeyMappings {
	public static final KeyMapping SPELL_4KEY_TYPE = new KeyMapping("key.lanternofthewoodlands.spell_4key_type", GLFW.GLFW_KEY_1, "key.categories.lanternofthewoodlands") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new Spell4keyTypeMessage(0, 0));
				Spell4keyTypeMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping MAIN_KEY = new KeyMapping("key.lanternofthewoodlands.main_key", GLFW.GLFW_KEY_LEFT_CONTROL, "key.categories.lanternofthewoodlands") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new MainKeyMessage(0, 0));
				MainKeyMessage.pressAction(Minecraft.getInstance().player, 0, 0);
				MAIN_KEY_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - MAIN_KEY_LASTPRESS);
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new MainKeyMessage(1, dt));
				MainKeyMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping KEY_SPELL_4_REVERSE = new KeyMapping("key.lanternofthewoodlands.key_spell_4_reverse", GLFW.GLFW_KEY_UNKNOWN, "key.categories.lanternofthewoodlands") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new KEYSpell4ReverseMessage(0, 0));
				KEYSpell4ReverseMessage.pressAction(Minecraft.getInstance().player, 0, 0);
				KEY_SPELL_4_REVERSE_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - KEY_SPELL_4_REVERSE_LASTPRESS);
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new KEYSpell4ReverseMessage(1, dt));
				KEYSpell4ReverseMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping KEY_SPELL_4_SHOOT = new KeyMapping("key.lanternofthewoodlands.key_spell_4_shoot", GLFW.GLFW_KEY_UNKNOWN, "key.categories.lanternofthewoodlands") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new KEYSpell4ShootMessage(0, 0));
				KEYSpell4ShootMessage.pressAction(Minecraft.getInstance().player, 0, 0);
				KEY_SPELL_4_SHOOT_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - KEY_SPELL_4_SHOOT_LASTPRESS);
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new KEYSpell4ShootMessage(1, dt));
				KEYSpell4ShootMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping KEY_SPELL_4_ACTIVATE = new KeyMapping("key.lanternofthewoodlands.key_spell_4_activate", GLFW.GLFW_KEY_TAB, "key.categories.lanternofthewoodlands") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new KEYSpell4ActivateMessage(0, 0));
				KEYSpell4ActivateMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping KEY_SPELL_4_HOMING = new KeyMapping("key.lanternofthewoodlands.key_spell_4_homing", GLFW.GLFW_KEY_C, "key.categories.lanternofthewoodlands") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new KEYSpell4HomingMessage(0, 0));
				KEYSpell4HomingMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping KEY_SPELL_4_CONSTANT = new KeyMapping("key.lanternofthewoodlands.key_spell_4_constant", GLFW.GLFW_KEY_X, "key.categories.lanternofthewoodlands") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new KEYSpell4ConstantMessage(0, 0));
				KEYSpell4ConstantMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping KEY_SPELL_4_MODE = new KeyMapping("key.lanternofthewoodlands.key_spell_4_mode", GLFW.GLFW_KEY_2, "key.categories.lanternofthewoodlands") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new KEYSpell4ModeMessage(0, 0));
				KEYSpell4ModeMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping KEYS_PELL_4_LOCK_TARGET = new KeyMapping("key.lanternofthewoodlands.keys_pell_4_lock_target", GLFW.GLFW_KEY_Z, "key.categories.lanternofthewoodlands") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new KEYSPell4LockTargetMessage(0, 0));
				KEYSPell4LockTargetMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping KEY_SPELL_4_DISTANCE_ADD = new KeyMapping("key.lanternofthewoodlands.key_spell_4_distance_add", GLFW.GLFW_KEY_4, "key.categories.lanternofthewoodlands") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new KEYSpell4DistanceAddMessage(0, 0));
				KEYSpell4DistanceAddMessage.pressAction(Minecraft.getInstance().player, 0, 0);
				KEY_SPELL_4_DISTANCE_ADD_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - KEY_SPELL_4_DISTANCE_ADD_LASTPRESS);
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new KEYSpell4DistanceAddMessage(1, dt));
				KEYSpell4DistanceAddMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping KEY_SPELL_4_DISTANCE_REDUCE = new KeyMapping("key.lanternofthewoodlands.key_spell_4_distance_reduce", GLFW.GLFW_KEY_3, "key.categories.lanternofthewoodlands") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new KEYSpell4DistanceReduceMessage(0, 0));
				KEYSpell4DistanceReduceMessage.pressAction(Minecraft.getInstance().player, 0, 0);
				KEY_SPELL_4_DISTANCE_REDUCE_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - KEY_SPELL_4_DISTANCE_REDUCE_LASTPRESS);
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new KEYSpell4DistanceReduceMessage(1, dt));
				KEYSpell4DistanceReduceMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping KEY_SPELL_4_ABILITY = new KeyMapping("key.lanternofthewoodlands.key_spell_4_ability", GLFW.GLFW_KEY_5, "key.categories.lanternofthewoodlands") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new KEYSpell4AbilityMessage(0, 0));
				KEYSpell4AbilityMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	private static long MAIN_KEY_LASTPRESS = 0;
	private static long KEY_SPELL_4_REVERSE_LASTPRESS = 0;
	private static long KEY_SPELL_4_SHOOT_LASTPRESS = 0;
	private static long KEY_SPELL_4_DISTANCE_ADD_LASTPRESS = 0;
	private static long KEY_SPELL_4_DISTANCE_REDUCE_LASTPRESS = 0;

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(SPELL_4KEY_TYPE);
		event.register(MAIN_KEY);
		event.register(KEY_SPELL_4_REVERSE);
		event.register(KEY_SPELL_4_SHOOT);
		event.register(KEY_SPELL_4_ACTIVATE);
		event.register(KEY_SPELL_4_HOMING);
		event.register(KEY_SPELL_4_CONSTANT);
		event.register(KEY_SPELL_4_MODE);
		event.register(KEYS_PELL_4_LOCK_TARGET);
		event.register(KEY_SPELL_4_DISTANCE_ADD);
		event.register(KEY_SPELL_4_DISTANCE_REDUCE);
		event.register(KEY_SPELL_4_ABILITY);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				SPELL_4KEY_TYPE.consumeClick();
				MAIN_KEY.consumeClick();
				KEY_SPELL_4_REVERSE.consumeClick();
				KEY_SPELL_4_SHOOT.consumeClick();
				KEY_SPELL_4_ACTIVATE.consumeClick();
				KEY_SPELL_4_HOMING.consumeClick();
				KEY_SPELL_4_CONSTANT.consumeClick();
				KEY_SPELL_4_MODE.consumeClick();
				KEYS_PELL_4_LOCK_TARGET.consumeClick();
				KEY_SPELL_4_DISTANCE_ADD.consumeClick();
				KEY_SPELL_4_DISTANCE_REDUCE.consumeClick();
				KEY_SPELL_4_ABILITY.consumeClick();
			}
		}
	}
}
