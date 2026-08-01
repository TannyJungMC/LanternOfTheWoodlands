package tannyjung.tanscomplexmagic_core.game;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import tannyjung.tanscomplexmagic_core.Core;

import java.util.*;

public class EntityManager {

    public static class Get {

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

                    if (filter(entity, id, tag_convert) == true) {

                        scan.add(entity);

                    }

                });

                entities = scan;
                cache_entities.get(id).put(tag_convert, scan);

            }

            return entities;

        }

        public static Entity fromEverywhereOne (ServerLevel level_server, String id, String[] tags) {

            List<Entity> list = fromEverywhere(level_server, id, tags);

            if (list.isEmpty() == true) {

                return null;

            }

            return list.getFirst();

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

        private static boolean filter (Entity entity, String id, List<String> tag_convert) {

            if (id.isEmpty() == true || EntityType.getKey(entity.getType()).toString().equals(id) == true) {

                if (tag_convert.isEmpty() == true || entity.getTags().containsAll(tag_convert) == true) {

                    return true;

                }

            }

            return false;

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

    public static Entity summon (ServerLevel level_server, Vec3 vec3, boolean is_always_show_name, String id, String name, String[] tags, String custom) {

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

        if (is_always_show_name == true) {

            entity.setCustomNameVisible(true);

        }

        entity.setCustomName(Component.literal(name));
        entity.addTag("TANNYJUNG");
        entity.addTag(Core.mod_id_big);

        for (String get : tags) {

            entity.addTag(get);

        }

        entity.setPos(vec3);
        level_server.addFreshEntity(entity);
        return entity;

    }

    public static void summonWorldGen (ServerLevel level_server, Vec3 vec3, String id, String name, String[] tags, String custom) {

        level_server.getServer().execute(() -> {

            summon(level_server, vec3, false, id, name, tags, custom);

        });

    }

    public static class Display {

        public static Entity summonText (ServerLevel level_server, Vec3 vec3, double size, String[] tags, String data) {

            Entity entity = summon(level_server, vec3, false, "minecraft:text_display", "Display Text", tags, "{billboard:vertical,alignment:\"center\",see_through:true,brightness:{block:15, sky:15},text_opacity:0,line_width:1000,transformation:{left_rotation:[0f,0f,0f,1f],right_rotation:[0f,0f,0f,1f],translation:[0f,0f,0f],scale:[" + size + "f," + size + "f," + size + "f]},text:'" + GameUtils.Data.createText(data) + "'}");

            if (entity != null) {

                entity.addTag(Core.mod_id_big + "-display_text");

            }

            return entity;

        }

        public static Entity summonTextTemporary (ServerLevel level_server, Vec3 vec3, double size, String[] tags, String data) {

            Entity entity = summonText(level_server, vec3, size, tags, data);

            Core.DelayedWork.create(false, 200, () -> {

                for (Entity scan : Get.fromArea(level_server, vec3, 1, true, "minecraft:text_display", new String[]{Core.mod_id_big + "-display_text"})) {

                    scan.discard();

                }

            });

            return entity;

        }

        public static Entity summonItem (ServerLevel level_server, Vec3 vec3, int rotate_horizontal, int rotate_vertical, double scale, boolean is_luminous, String name, String[] tags, String id) {

            StringBuilder builder = new StringBuilder();
            builder.append("item:{id:\"").append(id).append("\",Count:1b}, teleport_duration:10");
            builder.append(",Rotation:[").append(rotate_horizontal).append("f,").append(rotate_vertical).append("f]");
            builder.append(",transformation:{left_rotation:[0.0f,0.0f,0.0f,1.0f],right_rotation:[0.0f,0.0f,0.0f,1.0f],translation:[0.0f,0.0f,0.0f],scale:[").append(scale).append("f,").append(scale).append("f,").append(scale).append("f]}");

            if (is_luminous == true) {

                builder.append(",brightness:{block:15,sky:15}");

            }

            return summon(level_server, vec3, false, "minecraft:item_display", name, tags, "{" + builder + "}");

        }

        public static void setItemRotation (Entity entity, String axis, double degree) {

            double angle = Math.toRadians(degree);
            double sin = Math.sin(angle / 2);
            double cos = Math.cos(angle / 2);

            String data = "";

            if (axis.equals("x") == true) {

                data = "[" + sin + "f," + 0 + "f," + 0 + "f," + cos + "f]";

            } else if (axis.equals("y") == true) {

                data = "[" + 0 + "f," + sin + "f," + 0 + "f," + cos + "f]";

            } else if (axis.equals("z") == true) {

                data = "[" + 0 + "f," + 0 + "f," + sin + "f," + cos + "f]";

            }

            GameUtils.Command.runEntity(entity, "data modify entity @s transformation.left_rotation set value " + data);

        }

        public static void setItemScale (Entity entity, double scale) {

            GameUtils.Command.runEntity(entity, "data modify entity @s transformation.scale set value [" + scale + "f," + scale + "f," + scale + "f]");

        }

    }

}
