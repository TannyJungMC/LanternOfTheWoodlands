
package tannyjung.lanternofthewoodlands.client.screens;

import tannyjung.lanternofthewoodlands.procedures.Spell4GUIreturnDistanceProcedure;
import tannyjung.lanternofthewoodlands.procedures.OVERLAYSpell4ShowProcedure;
import tannyjung.lanternofthewoodlands.procedures.OVERLAYSpell4ReverseProcedure;
import tannyjung.lanternofthewoodlands.procedures.OVERLAYSpell4ModeProcedure;
import tannyjung.lanternofthewoodlands.procedures.OVERLAYSpell4LockTargetProcedure;
import tannyjung.lanternofthewoodlands.procedures.OVERLAYSpell4HomingProcedure;
import tannyjung.lanternofthewoodlands.procedures.OVERLAYSpell4ConstantProcedure;
import tannyjung.lanternofthewoodlands.procedures.OVERLAYSpell4AbilityDurationProcedure;
import tannyjung.lanternofthewoodlands.procedures.OVERLAYSpell4AbilityCooldownProcedure;

import org.checkerframework.checker.units.qual.h;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.Minecraft;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class OVERLAYSpell4Overlay {
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getWindow().getGuiScaledWidth();
		int h = event.getWindow().getGuiScaledHeight();
		Level world = null;
		double x = 0;
		double y = 0;
		double z = 0;
		Player entity = Minecraft.getInstance().player;
		if (entity != null) {
			world = entity.level();
			x = entity.getX();
			y = entity.getY();
			z = entity.getZ();
		}
		if (OVERLAYSpell4ShowProcedure.execute(entity)) {

			event.getGuiGraphics().blit(new ResourceLocation("lanternofthewoodlands:textures/screens/overlay_spell4_mode.png"), 6, h / 2 + -8, Mth.clamp((int) OVERLAYSpell4ModeProcedure.execute(entity) * 16, 0, 48), 0, 16, 16, 64, 16);

			event.getGuiGraphics().blit(new ResourceLocation("lanternofthewoodlands:textures/screens/overlay_spell4_type.png"), 6, h / 2 + -28, 0, 0, 16, 16, 64, 16);

			event.getGuiGraphics().blit(new ResourceLocation("lanternofthewoodlands:textures/screens/overlay_spell4_constant.png"), 6, h / 2 + 20, Mth.clamp((int) OVERLAYSpell4ConstantProcedure.execute(entity) * 8, 0, 8), 0, 8, 8, 16, 8);

			event.getGuiGraphics().blit(new ResourceLocation("lanternofthewoodlands:textures/screens/overlay_spell4_homing.png"), 14, h / 2 + 20, Mth.clamp((int) OVERLAYSpell4HomingProcedure.execute(entity) * 8, 0, 8), 0, 8, 8, 16, 8);

			event.getGuiGraphics().blit(new ResourceLocation("lanternofthewoodlands:textures/screens/overlay_spell4_lock_target.png"), 14, h / 2 + 12, Mth.clamp((int) OVERLAYSpell4LockTargetProcedure.execute(entity) * 8, 0, 8), 0, 8, 8, 16, 8);

			event.getGuiGraphics().blit(new ResourceLocation("lanternofthewoodlands:textures/screens/overlay_spell4_reverse.png"), 6, h / 2 + 12, Mth.clamp((int) OVERLAYSpell4ReverseProcedure.execute(entity) * 8, 0, 8), 0, 8, 8, 16, 8);

			event.getGuiGraphics().blit(new ResourceLocation("lanternofthewoodlands:textures/screens/overlay_spell4_ability_cooldown.png"), 24, h / 2 + -28, Mth.clamp((int) OVERLAYSpell4AbilityCooldownProcedure.execute(entity) * 1, 0, 17), 0, 1, 16,
					18, 16);

			event.getGuiGraphics().blit(new ResourceLocation("lanternofthewoodlands:textures/screens/overlay_spell4_ability_duration.png"), 24, h / 2 + -28, Mth.clamp((int) OVERLAYSpell4AbilityDurationProcedure.execute(entity) * 1, 0, 17), 0, 1, 16,
					18, 16);

			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					Spell4GUIreturnDistanceProcedure.execute(entity), 26, h / 2 + 16, -13421773, false);
		}
	}
}
