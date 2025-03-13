package lantern_of_the_woodlands.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.container.Slot;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;

import lantern_of_the_woodlands.item.WhirlwindSummonerItem;
import lantern_of_the_woodlands.item.SeaAnchorItem;
import lantern_of_the_woodlands.item.ParaniyaStaffItem;
import lantern_of_the_woodlands.item.PaperBombKunaiItem;
import lantern_of_the_woodlands.item.ManInTheMirrorItem;
import lantern_of_the_woodlands.item.KnightSwordItem;
import lantern_of_the_woodlands.item.ImaginaryShieldItem;
import lantern_of_the_woodlands.item.HellInnovationItem;
import lantern_of_the_woodlands.item.ForestStaffItem;
import lantern_of_the_woodlands.item.EnderowItem;
import lantern_of_the_woodlands.item.DualScythesItem;
import lantern_of_the_woodlands.item.AdventureCardsItem;

import lantern_of_the_woodlands.LanternOfTheWoodlandsModVariables;

import lantern_of_the_woodlands.LanternOfTheWoodlandsMod;

import java.util.function.Supplier;
import java.util.Map;

public class Spell4slot1testProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency world for procedure Spell4slot1test!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency x for procedure Spell4slot1test!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency y for procedure Spell4slot1test!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency z for procedure Spell4slot1test!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency entity for procedure Spell4slot1test!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					("/data merge entity @e[type=armor_stand,name=spell4weapon,limit=1,tag=weapon"
							+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_weapon_number + "] {ArmorItems:[{},{},{},{id:\"" + ""
							+ "\",Count:1b}]}"));
		}
		if ((new Object() {
			public ItemStack getItemStack(int sltid) {
				Entity _ent = entity;
				if (_ent instanceof ServerPlayerEntity) {
					Container _current = ((ServerPlayerEntity) _ent).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							return ((Slot) ((Map) invobj).get(sltid)).getStack();
						}
					}
				}
				return ItemStack.EMPTY;
			}
		}.getItemStack((int) (new Object() {
			double convert(String s) {
				try {
					return Double.parseDouble(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_weapon_number)))).getItem() == SeaAnchorItem.block) {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						("/data merge entity @e[type=armor_stand,name=spell4weapon,limit=1,tag=weapon"
								+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_weapon_number + "] {ArmorItems:[{},{},{},{id:\""
								+ "lantern_of_the_woodlands:sea_anchor" + "\",Count:1b}]}"));
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						("tag @e[type=armor_stand,name=spell4weapon,tag=weapon"
								+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_weapon_number + "] add " + "effect1"));
			}
		} else {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						("tag @e[type=armor_stand,name=spell4weapon,tag=weapon"
								+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_weapon_number + "] remove " + "effect1"));
			}
		}
		if ((new Object() {
			public ItemStack getItemStack(int sltid) {
				Entity _ent = entity;
				if (_ent instanceof ServerPlayerEntity) {
					Container _current = ((ServerPlayerEntity) _ent).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							return ((Slot) ((Map) invobj).get(sltid)).getStack();
						}
					}
				}
				return ItemStack.EMPTY;
			}
		}.getItemStack((int) (new Object() {
			double convert(String s) {
				try {
					return Double.parseDouble(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_weapon_number)))).getItem() == EnderowItem.block) {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						("/data merge entity @e[type=armor_stand,name=spell4weapon,limit=1,tag=weapon"
								+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_weapon_number + "] {ArmorItems:[{},{},{},{id:\""
								+ "lantern_of_the_woodlands:enderow" + "\",Count:1b}]}"));
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						("tag @e[type=armor_stand,name=spell4weapon,tag=weapon"
								+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_weapon_number + "] add " + "effect2"));
			}
		} else {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						("tag @e[type=armor_stand,name=spell4weapon,tag=weapon"
								+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_weapon_number + "] remove " + "effect2"));
			}
		}
		if ((new Object() {
			public ItemStack getItemStack(int sltid) {
				Entity _ent = entity;
				if (_ent instanceof ServerPlayerEntity) {
					Container _current = ((ServerPlayerEntity) _ent).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							return ((Slot) ((Map) invobj).get(sltid)).getStack();
						}
					}
				}
				return ItemStack.EMPTY;
			}
		}.getItemStack((int) (new Object() {
			double convert(String s) {
				try {
					return Double.parseDouble(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_weapon_number)))).getItem() == PaperBombKunaiItem.block) {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						("/data merge entity @e[type=armor_stand,name=spell4weapon,limit=1,tag=weapon"
								+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_weapon_number + "] {ArmorItems:[{},{},{},{id:\""
								+ "lantern_of_the_woodlands:paper_bomb_kunai" + "\",Count:1b}]}"));
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						("tag @e[type=armor_stand,name=spell4weapon,tag=weapon"
								+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_weapon_number + "] add " + "effect3"));
			}
		} else {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						("tag @e[type=armor_stand,name=spell4weapon,tag=weapon"
								+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_weapon_number + "] remove " + "effect3"));
			}
		}
		if ((new Object() {
			public ItemStack getItemStack(int sltid) {
				Entity _ent = entity;
				if (_ent instanceof ServerPlayerEntity) {
					Container _current = ((ServerPlayerEntity) _ent).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							return ((Slot) ((Map) invobj).get(sltid)).getStack();
						}
					}
				}
				return ItemStack.EMPTY;
			}
		}.getItemStack((int) (new Object() {
			double convert(String s) {
				try {
					return Double.parseDouble(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_weapon_number)))).getItem() == ParaniyaStaffItem.block) {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						("/data merge entity @e[type=armor_stand,name=spell4weapon,limit=1,tag=weapon"
								+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_weapon_number + "] {ArmorItems:[{},{},{},{id:\""
								+ "lantern_of_the_woodlands:paraniya_staff" + "\",Count:1b}]}"));
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						("tag @e[type=armor_stand,name=spell4weapon,tag=weapon"
								+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_weapon_number + "] add " + "effect4"));
			}
		} else {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						("tag @e[type=armor_stand,name=spell4weapon,tag=weapon"
								+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_weapon_number + "] remove " + "effect4"));
			}
		}
		if ((new Object() {
			public ItemStack getItemStack(int sltid) {
				Entity _ent = entity;
				if (_ent instanceof ServerPlayerEntity) {
					Container _current = ((ServerPlayerEntity) _ent).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							return ((Slot) ((Map) invobj).get(sltid)).getStack();
						}
					}
				}
				return ItemStack.EMPTY;
			}
		}.getItemStack((int) (new Object() {
			double convert(String s) {
				try {
					return Double.parseDouble(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_weapon_number)))).getItem() == KnightSwordItem.block) {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						("/data merge entity @e[type=armor_stand,name=spell4weapon,limit=1,tag=weapon"
								+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_weapon_number + "] {ArmorItems:[{},{},{},{id:\""
								+ "lantern_of_the_woodlands:knight_sword" + "\",Count:1b}]}"));
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						("tag @e[type=armor_stand,name=spell4weapon,tag=weapon"
								+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_weapon_number + "] add " + "effect5"));
			}
		} else {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						("tag @e[type=armor_stand,name=spell4weapon,tag=weapon"
								+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_weapon_number + "] remove " + "effect5"));
			}
		}
		if ((new Object() {
			public ItemStack getItemStack(int sltid) {
				Entity _ent = entity;
				if (_ent instanceof ServerPlayerEntity) {
					Container _current = ((ServerPlayerEntity) _ent).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							return ((Slot) ((Map) invobj).get(sltid)).getStack();
						}
					}
				}
				return ItemStack.EMPTY;
			}
		}.getItemStack((int) (new Object() {
			double convert(String s) {
				try {
					return Double.parseDouble(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_weapon_number)))).getItem() == WhirlwindSummonerItem.block) {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						("/data merge entity @e[type=armor_stand,name=spell4weapon,limit=1,tag=weapon"
								+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_weapon_number + "] {ArmorItems:[{},{},{},{id:\""
								+ "lantern_of_the_woodlands:whirlwind_summoner" + "\",Count:1b}]}"));
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						("tag @e[type=armor_stand,name=spell4weapon,tag=weapon"
								+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_weapon_number + "] add " + "effect6"));
			}
		} else {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						("tag @e[type=armor_stand,name=spell4weapon,tag=weapon"
								+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_weapon_number + "] remove " + "effect6"));
			}
		}
		if ((new Object() {
			public ItemStack getItemStack(int sltid) {
				Entity _ent = entity;
				if (_ent instanceof ServerPlayerEntity) {
					Container _current = ((ServerPlayerEntity) _ent).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							return ((Slot) ((Map) invobj).get(sltid)).getStack();
						}
					}
				}
				return ItemStack.EMPTY;
			}
		}.getItemStack((int) (new Object() {
			double convert(String s) {
				try {
					return Double.parseDouble(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_weapon_number)))).getItem() == ManInTheMirrorItem.block) {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						("/data merge entity @e[type=armor_stand,name=spell4weapon,limit=1,tag=weapon"
								+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_weapon_number + "] {ArmorItems:[{},{},{},{id:\""
								+ "lantern_of_the_woodlands:man_in_the_mirror" + "\",Count:1b}]}"));
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						("tag @e[type=armor_stand,name=spell4weapon,tag=weapon"
								+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_weapon_number + "] add " + "effect7"));
			}
		} else {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						("tag @e[type=armor_stand,name=spell4weapon,tag=weapon"
								+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_weapon_number + "] remove " + "effect7"));
			}
		}
		if ((new Object() {
			public ItemStack getItemStack(int sltid) {
				Entity _ent = entity;
				if (_ent instanceof ServerPlayerEntity) {
					Container _current = ((ServerPlayerEntity) _ent).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							return ((Slot) ((Map) invobj).get(sltid)).getStack();
						}
					}
				}
				return ItemStack.EMPTY;
			}
		}.getItemStack((int) (new Object() {
			double convert(String s) {
				try {
					return Double.parseDouble(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_weapon_number)))).getItem() == ForestStaffItem.block) {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						("/data merge entity @e[type=armor_stand,name=spell4weapon,limit=1,tag=weapon"
								+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_weapon_number + "] {ArmorItems:[{},{},{},{id:\""
								+ "lantern_of_the_woodlands:forest_staff" + "\",Count:1b}]}"));
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						("tag @e[type=armor_stand,name=spell4weapon,tag=weapon"
								+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_weapon_number + "] add " + "effect8"));
			}
		} else {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						("tag @e[type=armor_stand,name=spell4weapon,tag=weapon"
								+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_weapon_number + "] remove " + "effect8"));
			}
		}
		if ((new Object() {
			public ItemStack getItemStack(int sltid) {
				Entity _ent = entity;
				if (_ent instanceof ServerPlayerEntity) {
					Container _current = ((ServerPlayerEntity) _ent).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							return ((Slot) ((Map) invobj).get(sltid)).getStack();
						}
					}
				}
				return ItemStack.EMPTY;
			}
		}.getItemStack((int) (new Object() {
			double convert(String s) {
				try {
					return Double.parseDouble(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_weapon_number)))).getItem() == HellInnovationItem.block) {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						("/data merge entity @e[type=armor_stand,name=spell4weapon,limit=1,tag=weapon"
								+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_weapon_number + "] {ArmorItems:[{},{},{},{id:\""
								+ "lantern_of_the_woodlands:hell_innovation" + "\",Count:1b}]}"));
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						("tag @e[type=armor_stand,name=spell4weapon,tag=weapon"
								+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_weapon_number + "] add " + "effect9"));
			}
		} else {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						("tag @e[type=armor_stand,name=spell4weapon,tag=weapon"
								+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_weapon_number + "] remove " + "effect9"));
			}
		}
		if ((new Object() {
			public ItemStack getItemStack(int sltid) {
				Entity _ent = entity;
				if (_ent instanceof ServerPlayerEntity) {
					Container _current = ((ServerPlayerEntity) _ent).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							return ((Slot) ((Map) invobj).get(sltid)).getStack();
						}
					}
				}
				return ItemStack.EMPTY;
			}
		}.getItemStack((int) (new Object() {
			double convert(String s) {
				try {
					return Double.parseDouble(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_weapon_number)))).getItem() == DualScythesItem.block) {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						("/data merge entity @e[type=armor_stand,name=spell4weapon,limit=1,tag=weapon"
								+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_weapon_number + "] {ArmorItems:[{},{},{},{id:\""
								+ "lantern_of_the_woodlands:dual_scythes" + "\",Count:1b}]}"));
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						("tag @e[type=armor_stand,name=spell4weapon,tag=weapon"
								+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_weapon_number + "] add " + "effect10"));
			}
		} else {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						("tag @e[type=armor_stand,name=spell4weapon,tag=weapon"
								+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_weapon_number + "] remove " + "effect10"));
			}
		}
		if ((new Object() {
			public ItemStack getItemStack(int sltid) {
				Entity _ent = entity;
				if (_ent instanceof ServerPlayerEntity) {
					Container _current = ((ServerPlayerEntity) _ent).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							return ((Slot) ((Map) invobj).get(sltid)).getStack();
						}
					}
				}
				return ItemStack.EMPTY;
			}
		}.getItemStack((int) (new Object() {
			double convert(String s) {
				try {
					return Double.parseDouble(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_weapon_number)))).getItem() == ImaginaryShieldItem.block) {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						("/data merge entity @e[type=armor_stand,name=spell4weapon,limit=1,tag=weapon"
								+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_weapon_number + "] {ArmorItems:[{},{},{},{id:\""
								+ "lantern_of_the_woodlands:imaginary_shield" + "\",Count:1b}]}"));
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						("tag @e[type=armor_stand,name=spell4weapon,tag=weapon"
								+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_weapon_number + "] add " + "effect11"));
			}
		} else {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						("tag @e[type=armor_stand,name=spell4weapon,tag=weapon"
								+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_weapon_number + "] remove " + "effect11"));
			}
		}
		if ((new Object() {
			public ItemStack getItemStack(int sltid) {
				Entity _ent = entity;
				if (_ent instanceof ServerPlayerEntity) {
					Container _current = ((ServerPlayerEntity) _ent).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							return ((Slot) ((Map) invobj).get(sltid)).getStack();
						}
					}
				}
				return ItemStack.EMPTY;
			}
		}.getItemStack((int) (new Object() {
			double convert(String s) {
				try {
					return Double.parseDouble(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_weapon_number)))).getItem() == AdventureCardsItem.block) {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						("/data merge entity @e[type=armor_stand,name=spell4weapon,limit=1,tag=weapon"
								+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_weapon_number + "] {ArmorItems:[{},{},{},{id:\""
								+ "lantern_of_the_woodlands:adventure_cards" + "\",Count:1b}]}"));
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						("tag @e[type=armor_stand,name=spell4weapon,tag=weapon"
								+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_weapon_number + "] add " + "effect12"));
			}
		} else {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						("tag @e[type=armor_stand,name=spell4weapon,tag=weapon"
								+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_weapon_number + "] remove " + "effect12"));
			}
		}
	}
}
