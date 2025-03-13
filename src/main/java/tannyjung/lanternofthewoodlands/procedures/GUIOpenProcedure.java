package tannyjung.lanternofthewoodlands.procedures;

import tannyjung.lanternofthewoodlands.world.inventory.GUISpell4Menu;
import tannyjung.lanternofthewoodlands.world.inventory.GUIIndexMenu;
import tannyjung.lanternofthewoodlands.world.inventory.GUIDescriptionMenu;
import tannyjung.lanternofthewoodlands.network.LanternofthewoodlandsModVariables;

import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import io.netty.buffer.Unpooled;

public class GUIOpenProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double variable_number = 0;
		{
			Entity _ent = entity;
			if (!_ent.level().isClientSide() && _ent.getServer() != null) {
				_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
						_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "playsound minecraft:item.book.page_turn ambient @a[distance=..100] ~ ~ ~ 1 0.75 0.025");
			}
		}
		if (true) {
			if ((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).book_page < 1) {
				{
					double _setval = 1;
					entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.book_page = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if (true) {
				variable_number = 1;
				if (!("Info").isEmpty()) {
					if (true) {
						if (true) {
							if ((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).book_page == variable_number) {
								if (entity instanceof ServerPlayer _ent) {
									BlockPos _bpos = BlockPos.containing(x, y, z);
									NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
										@Override
										public Component getDisplayName() {
											return Component.literal("GUIIndex");
										}

										@Override
										public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
											return new GUIIndexMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
										}
									}, _bpos);
								}
							}
							variable_number = variable_number + 2;
						}
						if (true) {
							if ((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).book_page == variable_number) {
								if (entity instanceof ServerPlayer _ent) {
									BlockPos _bpos = BlockPos.containing(x, y, z);
									NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
										@Override
										public Component getDisplayName() {
											return Component.literal("GUIDescription");
										}

										@Override
										public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
											return new GUIDescriptionMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
										}
									}, _bpos);
								}
							}
							variable_number = variable_number + 2;
						}
					}
				}
				if (!("Advance Spells").isEmpty()) {
					if (true) {
						if (true) {
							if ((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).book_page == variable_number) {
								if (entity instanceof ServerPlayer _ent) {
									BlockPos _bpos = BlockPos.containing(x, y, z);
									NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
										@Override
										public Component getDisplayName() {
											return Component.literal("GUISpell4");
										}

										@Override
										public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
											return new GUISpell4Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
										}
									}, _bpos);
								}
							}
							variable_number = variable_number + 2;
						}
					}
				}
			}
			if ((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).book_page > variable_number - 2) {
				{
					double _setval = (entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).book_page - 2;
					entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.book_page = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}
}
