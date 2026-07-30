package tannyjung.tanscomplexmagic_core.game;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import tannyjung.tanscomplexmagic_core.Core;

import java.lang.reflect.Array;
import java.util.*;

public class EntityManager {

    public static class Import {

        private static final Map<String, Map<List<String>, List<Entity>>> cache_entities = new HashMap<>();

        public static void eventAddRemove (Entity entity, boolean is_join) {

            Map<List<String>, List<Entity>> map_tag_entity = new HashMap<>();
            String id = "";

            {

                map_tag_entity = cache_entities.get(id);

                if (map_tag_entity != null) {

                    for (Map.Entry<List<String>, List<Entity>> entry : map_tag_entity.entrySet()) {

                        if (entry.getKey().equals("[]") == true || entity.getTags().containsAll(entry.getKey()) == true) {

                            if (is_join == true) {

                                entry.getValue().add(entity);

                            } else {

                                Core.DelayedWork.create(false, 1, () -> {

                                    entry.getValue().remove(entity);

                                });

                            }

                        }

                    }

                }

            }

            id = EntityType.getKey(entity.getType()).toString();

            {

                map_tag_entity = cache_entities.get(id);

                if (map_tag_entity != null) {

                    for (Map.Entry<List<String>, List<Entity>> entry : map_tag_entity.entrySet()) {

                        if (entry.getKey().equals("[]") == true || entity.getTags().containsAll(entry.getKey()) == true) {

                            if (is_join == true) {

                                entry.getValue().add(entity);

                            } else {

                                Core.DelayedWork.create(false, 1, () -> {

                                    entry.getValue().remove(entity);

                                });

                            }

                        }

                    }

                }

            }

        }

        public static List<Entity> fromEverywhere (ServerLevel level_server, String id, String[] tags) {

            Map<List<String>, List<Entity>> map_tag_entity = cache_entities.get(id);

            if (map_tag_entity == null) {

                cache_entities.put(id, new HashMap<>());

            }

            List<String> tag_convert = Arrays.stream(tags).toList();
            List<Entity> entities = cache_entities.get(id).get(tag_convert);

            if (entities == null) {

                List<Entity> scan = new ArrayList<>();

                level_server.getAllEntities().forEach(entity -> {

                    if (id.isEmpty() == true || EntityType.getKey(entity.getType()).toString().equals(id) == true) {

                        if (tag_convert.isEmpty() == true || entity.getTags().containsAll(tag_convert) == true) {

                            scan.add(entity);

                        }

                    }

                });

                entities = scan;
                cache_entities.get(id).put(tag_convert, scan);

            }

            return entities;

        }

        public static List<Entity> fromArea (ServerLevel level_server, Vec3 vec3, int distance, boolean is_box, String id, String[] tags) {

            List<String> tag_convert = List.of(tags);

            return level_server.getEntitiesOfClass(Entity.class, new AABB(vec3, vec3).inflate(distance), entity -> {

                if (is_box == true || entity.position().distanceTo(vec3) <= distance) {

                    if (id.isEmpty() == true || EntityType.getKey(entity.getType()).toString().equals(id) == true) {

                        return tag_convert.isEmpty() == true || entity.getTags().containsAll(tag_convert) == true;

                    }

                    return false;

                }

                return false;

            });

        }

        public static List<Entity> sort (List<Entity> entities, Vec3 vec3_center, boolean is_nearest, int count) {

            List<Entity> sorted_entities = new ArrayList<>();

            if (is_nearest == true) {

                sorted_entities = entities.stream().sorted(Comparator.comparingDouble(entity -> entity.position().distanceTo(vec3_center))).toList();

            } else {

                sorted_entities = entities.stream().sorted(Comparator.comparingDouble(entity -> entity.position().distanceTo(vec3_center))).toList();

            }

            if (count > 0) {

                if (sorted_entities.size() > count) {

                    sorted_entities = sorted_entities.subList(0, count);

                }

            }

            return sorted_entities;

        }

    }

    public static Entity summon (ServerLevel level_server, Vec3 vec3, String id, String name, String tag, String custom) {

        EntityType<?> type = level_server.registryAccess().registryOrThrow(Registries.ENTITY_TYPE).get(ResourceLocation.parse(id));

        if (type == null) {

            return null;

        }

        Entity entity = type.create(level_server);

        if (entity == null) {

            return null;

        }

        if (custom.isEmpty() == false) {

            entity.load(GameUtils.Data.convertJSONToTag(custom));

        }

        entity.setCustomName(Component.literal(name));
        entity.setCustomNameVisible(true);

        entity.addTag("TANNYJUNG");
        entity.addTag(Core.mod_id_big);

        for (String get : tag.split(" / ")) {

            entity.addTag(get);

        }

        entity.setPos(vec3);
        level_server.addFreshEntity(entity);

        return entity;

    }

    public static void summonWorldGen (ServerLevel level_server, Vec3 vec3, String id, String name, String tag, String custom) {

        level_server.getServer().execute(() -> {

            summon(level_server, vec3, id, name, tag, custom);

        });

    }

    public static boolean isCreativeMode (Entity entity) {

        if (entity instanceof Player player) {

            return player.getAbilities().instabuild;

        }

        return false;

    }

    public static boolean isSneaking (Entity entity) {

        if (entity instanceof Player player) {

            return player.isShiftKeyDown();

        }

        return false;

    }

}
