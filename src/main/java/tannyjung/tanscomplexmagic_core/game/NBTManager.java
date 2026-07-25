package tannyjung.tanscomplexmagic_core.game;

import net.minecraft.core.BlockPos;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.TagParser;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import tannyjung.tanscomplexmagic_core.Core;
import tannyjung.tanscomplexmagic_core.outside.FileManager;
import tannyjung.tanscomplexmagic_core.outside.NetworkManager;
import tannyjung.tanscomplexmagic_core.outside.OutsideUtils;

import java.util.HashSet;
import java.util.Set;

public class NBTManager {

    public static CompoundTag convertJSONToTag (String data) {

        try {

            return TagParser.parseTag(data);

        } catch (Exception ignored) {

            return new CompoundTag();

        }

    }

    public static MutableComponent convertJSONToComponent (String data) {

        try {

            /*
            (1.20.1)
            return Component.Serializer.fromJson(data);
            (1.21.1)
            return Component.Serializer.fromJson(data, RegistryAccess.EMPTY);
            */
            return Component.Serializer.fromJson(data, RegistryAccess.EMPTY);

        } catch (Exception exception) {

            OutsideUtils.exception(new Exception(), exception, "");

        }

        return null;

    }

    public static String convertFileToForgeData (String path) {

        StringBuilder data = new StringBuilder();
        String[] split = null;
        Set<String> normal = new HashSet<>();

        // Add Normal
        {

            normal.add("-");
            normal.add("0");
            normal.add("1");
            normal.add("2");
            normal.add("3");
            normal.add("4");
            normal.add("5");
            normal.add("6");
            normal.add("7");
            normal.add("8");
            normal.add("9");

        }

        for (String scan : FileManager.readTXT(path)) {

            if (scan.isEmpty() == false && scan.startsWith("---") == false) {

                split = scan.split(" = ");

                if (split[1].isEmpty() == true || split[1].equals("none") == true) {

                    continue;

                } else if (normal.contains(split[1].substring(0, 1)) == true) {

                    data.append(split[0]).append(":").append(split[1]);

                } else if (split[1].equals("true") == true || split[1].equals("false") == true) {

                    data.append(split[0]).append(":").append(split[1]);

                } else {

                    data.append(split[0]).append(":\"").append(split[1]).append("\"");

                }

                data.append(",");

            }

        }

        return "{NeoForgeData:{" + Core.mod_id + ":{" + data + "}}}";

    }

    public static String createText (String data) {

        StringBuilder convert = new StringBuilder();
        String[] split = null;
        boolean first = false;

        for (String scan : data.split(" \\| ")) {

            if (first == false) {

                first = true;

            } else {

                convert.append(",");

            }

            split = scan.split(" / ");

            if (split.length == 1) {

                convert.append("{\"text\":\"");
                convert.append(split[0]);
                convert.append("\",\"color\":\"white\"");

            } else {

                convert.append("{\"text\":\"");
                convert.append(split[0]);
                convert.append("\",\"color\":\"");
                convert.append(split[1]);
                convert.append("\"");

                if (split.length == 3) {

                    if (split[2].startsWith("https") == true) {

                        convert.append(",\"clickEvent\":{\"action\":\"open_url\",\"value\":\"");
                        convert.append(split[2]);
                        convert.append("\"}");

                    } else if (split[2].startsWith("/") == true) {

                        convert.append(",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"");
                        convert.append(split[2]);
                        convert.append("\"}");

                    }

                    convert.append(",\"hoverEvent\":{\"action\":\"show_text\",\"contents\":\"");
                    convert.append(split[2]);
                    convert.append("\"}");

                }

            }

            convert.append("}");

        }

        return convert.toString();

    }

    public static String createTextDoubleBackslash (String data) {

        return createText(data).replace("\"", "\\\"");

    }

    public static String createItem (String name, String lore, String custom_data, String forge_data) {

        /*
        (1.20.1)
        String part_name = "display:{Name:\"" + createTextDoubleBackslash(name) + "\"},";
        String part_lore = "Lore:[\"" + createTextDoubleBackslash(lore) + "\"],";
        String part_custom_data = "tag:{" + Core.mod_id + ":{" + custom_data + "}},";
        String part_forge_data = "BlockEntityData:{NeoForgeData:{" + Core.mod_id + ":{" + forge_data + "}}},";
        (1.21.1)
        String part_name = "custom_name:\"" + createTextDoubleBackslash(name) + "\",";
        String part_lore = "lore:[\"" + createTextDoubleBackslash(lore) + "\"],";
        String part_custom_data = "custom_data:{" + custom_data + "},";
        String part_forge_data = "block_entity_data:{id:\"\",NeoForgeData:{" + Core.mod_id + ":{" + forge_data + "}}},";
        */
        String part_name = "custom_name:\"" + createTextDoubleBackslash(name) + "\",";
        String part_lore = "lore:[\"" + createTextDoubleBackslash(lore) + "\"],";
        String part_custom_data = "custom_data:{" + custom_data + "},";
        String part_forge_data = "block_entity_data:{id:\"\",NeoForgeData:{" + Core.mod_id + ":{" + forge_data + "}}},";

        StringBuilder write = new StringBuilder();
        if (name.isEmpty() == false) write.append(part_name);
        if (lore.isEmpty() == false) write.append(part_lore);
        if (custom_data.isEmpty() == false) write.append(part_custom_data);
        if (forge_data.isEmpty() == false) write.append(part_forge_data);
        return write.toString();

    }

    public static String getEntityText (Entity entity, String type, String name) {

        /*
        (1.20.1) (1.21.1)
        return entity.getPersistentData().getCompound(Core.mod_id).getString(name);
        (1.21.8)
        return entity.getPersistentData().getCompound(Core.mod_id).getString(name).get();
        */
        return entity.getPersistentData().getCompound(Core.mod_id).getCompound(type).getString(name);

    }

    public static Boolean getEntityLogic (Entity entity, String type, String name) {

        /*
        (1.20.1) (1.21.1)
        return entity.getPersistentData().getCompound(Core.mod_id).getBoolean(name);
        (1.21.8)
        return entity.getPersistentData().getCompound(Core.mod_id).getBoolean(name).get();
        */
        return entity.getPersistentData().getCompound(Core.mod_id).getCompound(type).getBoolean(name);

    }

    public static double getEntityNumber (Entity entity, String name) {

        /*
        (1.20.1) (1.21.1)
        return entity.getPersistentData().getCompound(Core.mod_id).getDouble(name);
        (1.21.8)
        return entity.getPersistentData().getCompound(Core.mod_id).getDouble(name).get();
        */
        return entity.getPersistentData().getCompound(Core.mod_id).getDouble(name);

    }

    public static double[] getEntityListNumber (Entity entity, String name) {

        /*
        (1.20.1) (1.21.1)
        ListTag list = entity.getPersistentData().getCompound(Core.mod_id).getList(name, Tag.TAG_DOUBLE);
        (1.21.8)
        ListTag list = entity.getPersistentData().getCompound(Core.mod_id).getList(name).get();
        */
        ListTag list = entity.getPersistentData().getCompound(Core.mod_id).getList(name, Tag.TAG_DOUBLE);

        double[] convert = new double[list.size()];

        for (int count = 0; count <= list.size() - 1; count++) {

				/*
				(1.20.1) (1.21.1)
				convert[count] = list.getDouble(count);
				(1.21.8)
				convert[count] = list.getDouble(count).get();
				*/
            convert[count] = list.getDouble(count);

        }

        return convert;

    }

    public static double[] getEntityListNumberFloat (Entity entity, String name) {

        /*
        (1.20.1) (1.21.1)
        ListTag list = entity.getPersistentData().getCompound(Core.mod_id).getList(name, Tag.TAG_FLOAT);
        (1.21.8)
        ListTag list = entity.getPersistentData().getCompound(Core.mod_id).getList(name).get();
        */
        ListTag list = entity.getPersistentData().getCompound(Core.mod_id).getList(name, Tag.TAG_FLOAT);

        double[] convert = new double[list.size()];

        for (int count = 0; count <= list.size() - 1; count++) {

            /*
            (1.20.1) (1.21.1)
            convert[count] = list.getFloat(count);
            (1.21.8)
            convert[count] = list.getFloat(count).get();
            */
            convert[count] = list.getFloat(count);

        }

        return convert;

    }

    public static void setEntityText (Entity entity, String type, String name, String value) {

        CompoundTag tag = new CompoundTag();
        CompoundTag tag_type = new CompoundTag();
        CompoundTag tag_mod = new CompoundTag();
        tag.putString(name, value);
        tag_type.put(type, tag);
        tag_mod.put(Core.mod_id, tag_type);
        entity.getPersistentData().merge(tag_mod);

        if (entity instanceof ServerPlayer player) {

            Network.syncOne(player, tag_mod);

        }

    }

    public static void setEntityLogic (Entity entity, String type, String name, boolean value) {

        CompoundTag tag = new CompoundTag();
        CompoundTag tag_type = new CompoundTag();
        CompoundTag tag_mod = new CompoundTag();
        tag.putBoolean(name, value);
        tag_type.put(type, tag);
        tag_mod.put(Core.mod_id, tag_type);
        entity.getPersistentData().merge(tag_mod);

        if (entity instanceof ServerPlayer player) {

            Network.syncOne(player, tag_mod);

        }

    }

    public static void setEntityNumber (Entity entity, String name, double value) {

        CompoundTag tag = new CompoundTag();
        CompoundTag tag_add = new CompoundTag();
        tag_add.putDouble(name, value);
        tag.put(Core.mod_id, tag_add);
        entity.getPersistentData().merge(tag);

    }

    public static void addEntityNumber (Entity entity, String name, double value) {

        /*
        (1.20.1) (1.21.1)
        entity.getPersistentData().getCompound(Core.mod_id).putDouble(name, entity.getPersistentData().getCompound(Core.mod_id).getDouble(name) + value);
        (1.21.8)
        entity.getPersistentData().getCompound(Core.mod_id).putDouble(name, entity.getPersistentData().getCompound(Core.mod_id).getDouble(name).get() + value);
        */
        entity.getPersistentData().getCompound(Core.mod_id).putDouble(name, entity.getPersistentData().getCompound(Core.mod_id).getDouble(name) + value);

    }

    public static String getBlockText (LevelAccessor level_accessor, BlockPos pos, String name) {

        return new Object() {

            public String getValue (LevelAccessor level_accessor, BlockPos pos, String name) {

                BlockEntity block_entity = level_accessor.getBlockEntity(pos);

                if (block_entity == null) {

                    return "";

                }

                /*
                (1.20.1) (1.21.1)
                return block_entity.getPersistentData().getCompound(Core.mod_id).getString(name);
                (1.21.8)
                return block_entity.getPersistentData().getCompound(Core.mod_id).getString(name).get();
                */
                return block_entity.getPersistentData().getCompound(Core.mod_id).getString(name);

            }

        }.getValue(level_accessor, pos, name);

    }

    public static double getBlockNumber (LevelAccessor level_accessor, BlockPos pos, String name) {

        return new Object() {

            public double getValue (LevelAccessor level_accessor, BlockPos pos, String name) {

                BlockEntity block_entity = level_accessor.getBlockEntity(pos);

                if (block_entity == null) {

                    return 0.0;

                }

                /*
                (1.20.1) (1.21.1)
                return block_entity.getPersistentData().getCompound(Core.mod_id).getDouble(name);
                (1.21.8)
                return block_entity.getPersistentData().getCompound(Core.mod_id).getDouble(name).get();
                */
                return block_entity.getPersistentData().getCompound(Core.mod_id).getDouble(name);

            }

        }.getValue(level_accessor, pos, name);

    }

    public static boolean getBlockLogic (LevelAccessor level_accessor, BlockPos pos, String name) {

        return new Object() {

            public boolean getValue (LevelAccessor level_accessor, BlockPos pos, String name) {

                BlockEntity blockEntity = level_accessor.getBlockEntity(pos);

                if (blockEntity != null) {

                    /*
                    (1.20.1) (1.21.1)
                    return blockEntity.getPersistentData().getCompound(Core.mod_id).getBoolean(name);
                    (1.21.8)
                    return blockEntity.getPersistentData().getCompound(Core.mod_id).getBoolean(name).get();
                    */
                    return blockEntity.getPersistentData().getCompound(Core.mod_id).getBoolean(name);

                }

                return false;

            }

        }.getValue(level_accessor, pos, name);

    }

    public static void setBlockText (LevelAccessor level_accessor, ServerLevel level_server, BlockPos pos, String name, String value) {

        BlockEntity block_entity = level_accessor.getBlockEntity(pos);

        if (block_entity != null) {

            CompoundTag tag = new CompoundTag();
            CompoundTag tag_add = new CompoundTag();
            tag_add.putString(name, value);
            tag.put(Core.mod_id, tag_add);
            block_entity.getPersistentData().merge(tag);
            BlockState block = level_accessor.getBlockState(pos);
            level_server.sendBlockUpdated(pos, block, block, 2);

        }

    }

    public static void setBlockLogic (LevelAccessor level_accessor, ServerLevel level_server, BlockPos pos, String name, boolean value) {

        BlockEntity block_entity = level_accessor.getBlockEntity(pos);

        if (block_entity != null) {

            CompoundTag tag = new CompoundTag();
            CompoundTag tag_add = new CompoundTag();
            tag_add.putBoolean(name, value);
            tag.put(Core.mod_id, tag_add);
            block_entity.getPersistentData().merge(tag);
            BlockState block = level_accessor.getBlockState(pos);
            level_server.sendBlockUpdated(pos, block, block, 2);

        }

    }

    public static void setBlockNumber (LevelAccessor level_accessor, ServerLevel level_server, BlockPos pos, String name, double value) {

        BlockEntity block_entity = level_accessor.getBlockEntity(pos);

        if (block_entity != null) {

            CompoundTag tag = new CompoundTag();
            CompoundTag tag_add = new CompoundTag();
            tag_add.putDouble(name, value);
            tag.put(Core.mod_id, tag_add);
            block_entity.getPersistentData().merge(tag);
            BlockState block = level_accessor.getBlockState(pos);
            level_server.sendBlockUpdated(pos, block, block, 2);

        }

    }

    public static void addBlockNumber (LevelAccessor level_accessor, ServerLevel level_server, BlockPos pos, String name, double value) {

        BlockEntity block_entity = level_accessor.getBlockEntity(pos);

        if (block_entity != null) {

            /*
            (1.20.1) (1.21.1)
            block_entity.getPersistentData().getCompound(Core.mod_id).putDouble(name, block_entity.getPersistentData().getCompound(Core.mod_id).getDouble(name) + value);
            (1.21.8)
            block_entity.getPersistentData().getCompound(Core.mod_id).putDouble(name, block_entity.getPersistentData().getCompound(Core.mod_id).getDouble(name).get() + value);
            */
            block_entity.getPersistentData().getCompound(Core.mod_id).putDouble(name, block_entity.getPersistentData().getCompound(Core.mod_id).getDouble(name) + value);

            BlockState block = level_accessor.getBlockState(pos);
            level_server.sendBlockUpdated(pos, block, block, 2);

        }

    }

    public static String getItemText (Entity entity, EquipmentSlot slot, String name) {

        /*
        (1.20.1)
        return Item.getSlot(entity, slot).getOrCreateTag().getCompound(Core.mod_id).getString(name);
        (1.21.1)
        return Item.getSlot(entity, slot).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getCompound(Core.mod_id).getString(name);
        */
        return GameUtils.Item.getSlot(entity, slot).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getCompound(Core.mod_id).getString(name);

    }

    public static void setItemText (Entity entity, EquipmentSlot slot, String name, String value) {

        CompoundTag tag = new CompoundTag();
        CompoundTag tag_add = new CompoundTag();
        tag_add.putString(name, value);
        tag.put(Core.mod_id, tag_add);

        /*
        (1.20.1)
        Item.getSlot(entity, slot).getOrCreateTag().merge(tag);
        (1.21.1)
        CustomData.update(DataComponents.CUSTOM_DATA, Item.getSlot(entity, slot), create -> create.merge(tag));
        */
        CustomData.update(DataComponents.CUSTOM_DATA, GameUtils.Item.getSlot(entity, slot), create -> create.merge(tag));

    }

    public static class Network {

        public static void syncAll (ServerPlayer player) {

            CompoundTag tag = new CompoundTag();
            tag.put(Core.mod_id, player.getPersistentData().getCompound(Core.mod_id));
            NetworkManager.runClientCore(player, "nbt", "sync", tag);

        }

        public static void syncOne (ServerPlayer player, CompoundTag tag) {

            NetworkManager.runClientCore(player, "nbt", "sync", tag);

        }

    }

}
