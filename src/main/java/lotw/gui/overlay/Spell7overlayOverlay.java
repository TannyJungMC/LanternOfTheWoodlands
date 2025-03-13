
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

import lotw.procedures.Spell7returnOverlayProcedure;
import lotw.procedures.Spell7returnGenerator3workProcedure;
import lotw.procedures.Spell7returnGenerator2workProcedure;
import lotw.procedures.Spell7returnGenerator1workProcedure;
import lotw.procedures.Spell7returnDoubleSpellProcedure;

import lotw.LotwModVariables;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

@Mod.EventBusSubscriber
public class Spell7overlayOverlay {
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
			if (Spell7returnOverlayProcedure
					.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("entity", entity))
							.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().fontRenderer.drawString(event.getMatrixStack(),
						"Pos : " + (int) (LotwModVariables.MapVariables.get(world).spell7_book_number) + " \u00BB "
								+ (int) (LotwModVariables.MapVariables.get(world).spell7_move) + "",
						posX + -207, posY + -16, -3368449);
				Minecraft.getInstance().fontRenderer.drawString(event.getMatrixStack(),
						"" + (LotwModVariables.MapVariables.get(world).spell7_generator1) + "", posX + -191, posY + -116, -3368704);
				Minecraft.getInstance().fontRenderer.drawString(event.getMatrixStack(),
						"" + (LotwModVariables.MapVariables.get(world).spell7_generator2) + "", posX + -191, posY + -104, -3368704);
				Minecraft.getInstance().fontRenderer.drawString(event.getMatrixStack(),
						"" + (LotwModVariables.MapVariables.get(world).spell7_generator3) + "", posX + -191, posY + -92, -3368704);
				if (Spell7returnGenerator1workProcedure
						.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("entity", entity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					Minecraft.getInstance().fontRenderer.drawString(event.getMatrixStack(), "\u2611", posX + -207, posY + -116, -6710887);
				if (Spell7returnGenerator2workProcedure
						.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("entity", entity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					Minecraft.getInstance().fontRenderer.drawString(event.getMatrixStack(), "\u2611", posX + -207, posY + -104, -6710887);
				if (Spell7returnGenerator3workProcedure
						.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("entity", entity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					Minecraft.getInstance().fontRenderer.drawString(event.getMatrixStack(), "\u2611", posX + -207, posY + -92, -6710887);
				Minecraft.getInstance().fontRenderer.drawString(event.getMatrixStack(),
						"Mode : " + (int) (LotwModVariables.MapVariables.get(world).spell7_mode) + "", posX + -207, posY + 8, -6697984);
				Minecraft.getInstance().fontRenderer.drawString(event.getMatrixStack(),
						"Spell : " + (LotwModVariables.MapVariables.get(world).spell7_use) + "", posX + -207, posY + -4, -16724839);
				if (Spell7returnDoubleSpellProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					Minecraft.getInstance().fontRenderer.drawString(event.getMatrixStack(),
							"First Spell : " + (LotwModVariables.MapVariables.get(world).spell7_use_double) + "", posX + -207, posY + -56, -3355444);
				if (Spell7returnDoubleSpellProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					Minecraft.getInstance().fontRenderer.drawString(event.getMatrixStack(),
							"First Pos : " + (int) (LotwModVariables.MapVariables.get(world).spell7_use_double_number) + "", posX + -207, posY + -44,
							-6710887);
			}
		}
	}
}
