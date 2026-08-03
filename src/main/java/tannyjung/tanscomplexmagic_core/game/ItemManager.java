package tannyjung.tanscomplexmagic_core.game;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;

public class ItemManager {

    public static ItemStack getSlot (Entity entity, EquipmentSlot equipment_slot) {

        if (entity instanceof LivingEntity living_entity) {

            return living_entity.getItemBySlot(equipment_slot);

        }

        return ItemStack.EMPTY;

    }

    public static boolean isTaggedAs (ItemStack item, String tag) {

        return item.is(ItemTags.create(ResourceLocation.parse(tag))) == true;

    }

    public static void setCount (Entity entity, EquipmentSlot equipment_slot, int value) {

        if (entity instanceof LivingEntity living_entity) {

            ItemStack item = living_entity.getItemBySlot(equipment_slot);
            item.setCount(value);

        }

    }

    public static void addCount (Entity entity, EquipmentSlot equipment_slot, int value) {

        if (entity instanceof LivingEntity living_entity) {

            ItemStack item = living_entity.getItemBySlot(equipment_slot);
            item.setCount(item.getCount() + value);

        }

    }

    public static void setCooldown (Entity entity, ItemStack item, int tick) {

        if (entity instanceof Player player) {

            player.getCooldowns().addCooldown(item.getItem(), tick);

        }

    }

    public static void addDamage (ItemStack item, int value) {

        item.setDamageValue(item.getDamageValue() + value);

        if (item.getMaxDamage() < item.getDamageValue()) {

            item.shrink(1);

        }

    }

    public static void spawn (ServerLevel level_server, Vec3 vec3, ItemStack item) {

        ItemEntity entityToSpawn = new ItemEntity(level_server, vec3.x, vec3.y, vec3.z, item);
        level_server.addFreshEntity(entityToSpawn);

    }

    public static String toID (ItemStack item) {

        String id = item.getDescriptionId();
        return id.substring(id.indexOf(".") + 1).replace(".", ":");

    }

    public static ItemStack fromID (ServerLevel level_server, String id) {

        return level_server.registryAccess().registryOrThrow(Registries.ITEM).get(ResourceLocation.parse(id)).getDefaultInstance();

    }

}
