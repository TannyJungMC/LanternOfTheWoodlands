
package lotw.gui.overlay;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.Minecraft;

import lotw.procedures.Spell4returnOverlayTRUEProcedure;

import lotw.LotwModVariables;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

@Mod.EventBusSubscriber
public class Spell4overlayOverlay {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGameOverlayEvent.Post event) {
		if (event.getType() == RenderGameOverlayEvent.ElementType.HELMET) {
			int w = event.getWindow().getScaledWidth();
			int h = event.getWindow().getScaledHeight();
			int posX = w / 2;
			int posY = h / 2;
			World _world = null;
			double _x = 0;
			double _y = 0;
			double _z = 0;
			PlayerEntity entity = Minecraft.getInstance().player;
			if (entity != null) {
				_world = entity.world;
				_x = entity.getPosX();
				_y = entity.getPosY();
				_z = entity.getPosZ();
			}
			World world = _world;
			double x = _x;
			double y = _y;
			double z = _z;
			if (Spell4returnOverlayTRUEProcedure
					.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("entity", entity))
							.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().fontRenderer.drawString(event.getMatrixStack(),
						"Distance : " + (int) (LotwModVariables.MapVariables.get(world).spell4_distance) + "", posX + -207, posY + -12, -52429);
				Minecraft.getInstance().fontRenderer.drawString(event.getMatrixStack(),
						"Weapon : " + (LotwModVariables.MapVariables.get(world).spell4_weapon_type) + "", posX + -207, posY + -48, -13395712);
				Minecraft.getInstance().fontRenderer.drawString(event.getMatrixStack(),
						"Mode : " + (LotwModVariables.MapVariables.get(world).spell4_mode) + "", posX + -207, posY + -36, -16737895);
				Minecraft.getInstance().fontRenderer.drawString(event.getMatrixStack(),
						"Skill : " + (LotwModVariables.MapVariables.get(world).spell4_ability) + "", posX + -207, posY + 36, -3407770);
				Minecraft.getInstance().fontRenderer.drawString(event.getMatrixStack(),
						"Reverse : " + (LotwModVariables.MapVariables.get(world).spell4_reverse) + "", posX + -207, posY + 24, -3381760);
				Minecraft.getInstance().fontRenderer.drawString(event.getMatrixStack(),
						"Lock Target : " + (LotwModVariables.MapVariables.get(world).spell4_target_lock) + "", posX + -207, posY + 0, -3355648);
			}
		}
	}
}
