package tannyjung.tanscomplexmagic_core.game;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import tannyjung.tanscomplexmagic_core.Core;

import java.util.*;

public class EntityManager {

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

            entity.load(NBTManager.convertJSONToTag(custom));

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

    public static Vec3 getPosLook (Entity entity, double offsetX, double offsetY, double offsetZ) {

        Vec3 vec3_forward = Vec3.directionFromRotation(entity.getXRot(), entity.getYRot());
        Vec3 vec3_vertical = null;

        if (Math.abs(vec3_forward.y) > 0.999) {

            vec3_vertical = new Vec3(0,0,1);

        } else {

            vec3_vertical = new Vec3(0,1,0);

        }

        Vec3 vec3_horizontal = vec3_forward.cross(vec3_vertical).normalize();
        Vec3 vec3_vertical_adjust = vec3_horizontal.cross(vec3_forward).normalize();
        return entity.position().add(vec3_horizontal.scale(offsetX)).add(vec3_vertical_adjust.scale(offsetY)).add(vec3_forward.scale(offsetZ));
    }

    public static Vec3 getPosLookReverse (Entity entity, Vec3 vec3_target, double offsetX, double offsetY, double offsetZ) {

        Vec3 forward_behind = vec3_target.subtract(entity.getEyePosition()).normalize();
        Vec3 left_right = forward_behind.cross(new Vec3(0, 1, 0)).normalize();
        Vec3 up = left_right.cross(forward_behind).normalize();
        return entity.getEyePosition().add(left_right.scale(offsetX)).add(up.scale(offsetY)).add(forward_behind.scale(offsetZ));

    }

    public static Vec3 getPosRay (Entity entity, double distance) {

        return entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(distance)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getLocation();

    }

    public static Entity getTarget (Entity entity) {

        if (entity instanceof Mob mob) {

            return mob.getTarget();

        }

        return null;

    }

    public static void setTarget (Entity entity_attacker, Entity entity_target) {

        if (entity_attacker instanceof Mob mob) {

            if (entity_target instanceof LivingEntity entity_living) {

                mob.setTarget(entity_living);

            }

        }

    }

    public static void clearTarget (Entity entity) {

        if (entity instanceof Mob == true) {

            EventCenter.attacker_reset_target.add(entity);

        }

    }

    public static void go (Entity entity, Vec3 vec3, double speed) {

        if (entity instanceof Mob mob) {

            mob.getNavigation().moveTo(vec3.x, vec3.y, vec3.z, speed);

        }

    }

    public static class Population {

        private static final Map<String, Map<List<String>, List<Entity>>> population = new HashMap<>();

        public static void eventAddRemove (Entity entity, boolean is_join) {

            Map<List<String>, List<Entity>> map_tag_entity = new HashMap<>();
            String id = "";

            for (int loop = 2; loop > 0; loop--) {

                map_tag_entity = population.get(id);

                if (map_tag_entity != null) {

                    test:
                    for (Map.Entry<List<String>, List<Entity>> entry : map_tag_entity.entrySet()) {

                        if (entry.getKey().equals("[]") == false) {

                            for (String scan : entry.getKey()) {

                                if (scan.startsWith("!") == true) {

                                    scan = scan.substring(1);

                                    if (entity.getTags().contains(scan) == true) {

                                        continue test;

                                    }

                                } else {

                                    if (entity.getTags().contains(scan) == false) {

                                        continue test;

                                    }

                                }

                            }

                        }

                        if (is_join == true) {

                            entry.getValue().add(entity);

                        } else {

                            Core.DelayedWork.create(false, 1, () -> {

                                // Fix entities remove by re-enter the chunks, caused by status not instant update.
                                // When re-enter the chunks, the game will send some entity leave event, some is new created entities with status null, do not delete them.
                                if (entity.isRemoved() == true) {

                                    entry.getValue().remove(entity);

                                }

                            });

                        }

                    }

                }

                if (id.isEmpty() == true) {

                    id = EntityType.getKey(entity.getType()).toString();

                } else {

                    break;

                }

            }

        }

        public static List<Entity> getEverywhere (ServerLevel level_server, String id, String[] tags) {

            Map<List<String>, List<Entity>> map_tag_entity = population.get(id);

            if (map_tag_entity == null) {

                population.put(id, new HashMap<>());

            }

            List<String> tag_convert = Arrays.stream(tags).toList();
            List<Entity> entities = population.get(id).get(tag_convert);

            if (entities == null) {

                List<Entity> list = new ArrayList<>();

                level_server.getAllEntities().forEach(entity -> {

                    if (test(entity, id, tag_convert) == true) {

                        list.add(entity);

                    }

                });

                entities = list;
                population.get(id).put(tag_convert, list);

            }

            return entities;

        }

        public static Entity getEverywhereOne (ServerLevel level_server, String id, String[] tags) {

            List<Entity> list = getEverywhere(level_server, id, tags);

            if (list.isEmpty() == true) {

                return null;

            }

            return list.getFirst();

        }

        public static List<Entity> getArea (ServerLevel level_server, Vec3 vec3, double distance, boolean is_box, String id, String[] tags) {

            return level_server.getEntitiesOfClass(Entity.class, new AABB(vec3, vec3).inflate(distance), entity -> {

                if (is_box == true || entity.position().distanceTo(vec3) <= distance) {

                    if (id.isEmpty() == false && EntityType.getKey(entity.getType()).toString().equals(id) == false) {

                        return false;

                    }

                    test:
                    {

                        for (String scan : tags) {

                            if (scan.startsWith("!") == true) {

                                scan = scan.substring(1);

                                if (entity.getTags().contains(scan) == true) {

                                    break test;

                                }

                            } else {

                                if (entity.getTags().contains(scan) == false) {

                                    break test;

                                }

                            }

                        }

                        return true;

                    }

                }

                return false;

            });

        }

        public static boolean test (Entity entity, String id, List<String> tag_convert) {

            if (id.isEmpty() == false) {

                boolean blacklist = false;

                if (id.startsWith("!") == true) {

                    id = id.substring(1);
                    blacklist = true;

                }

                boolean test = EntityType.getKey(entity.getType()).toString().equals(id) == true;

                if (blacklist == true && test == true) {

                    return false;

                } else if (blacklist == false && test == false) {

                    return false;

                }

            }

            for (String scan : tag_convert) {

                if (scan.startsWith("!") == true) {

                    if (entity.getTags().contains(scan) == true) {

                        return false;

                    }

                } else {

                    if (entity.getTags().contains(scan) == false) {

                        return false;

                    }

                }

            }

            return true;

        }

        public static List<Entity> sort (List<Entity> entities, Vec3 vec3_center, boolean is_nearest, int count) {

            List<Entity> list = new ArrayList<>();

            if (is_nearest == true) {

                list = entities.stream().sorted(Comparator.comparingDouble(entity -> entity.position().distanceTo(vec3_center))).toList();

            } else {

                list = entities.stream().sorted(Comparator.comparingDouble(entity -> entity.position().distanceTo(vec3_center))).toList();

            }

            if (count > 0) {

                if (list.size() > count) {

                    list = list.subList(0, count);

                }

            }

            return list;

        }

        public static List<Entity> filter (List<Entity> entities, String id, String[] tags) {

            List<Entity> list = new ArrayList<>();
            List<String> tag_convert = List.of(tags);

            for (Entity entity : entities) {

                if (test(entity, id, tag_convert) == true) {

                    list.add(entity);

                }

            }

            return list;

        }

        public static List<Entity> filterLivingEntity (List<Entity> entities) {

            List<Entity> list = new ArrayList<>();

            for (Entity entity : entities) {

                if (entity instanceof LivingEntity entity_living) {

                    list.add(entity_living);

                }

            }

            return list;

        }

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

                for (Entity scan : Population.getArea(level_server, vec3, 1, true, "minecraft:text_display", new String[]{Core.mod_id_big + "-display_text"})) {

                    scan.discard();

                }

            });

            return entity;

        }

        public static Entity summonItem (ServerLevel level_server, Vec3 vec3, int rotate_horizontal, int rotate_vertical, double scale, boolean is_luminous, String name, String[] tags, String id) {

            StringBuilder builder = new StringBuilder();
            builder.append("item:{id:\"").append(id).append("\",Count:1b},teleport_duration:10");
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

            GameUtils.runCommandEntity(entity, "data modify entity @s transformation.left_rotation set value " + data);

        }

        public static void setItemScale (Entity entity, double scale) {

            GameUtils.runCommandEntity(entity, "data modify entity @s transformation.scale set value [" + scale + "f," + scale + "f," + scale + "f]");

        }

    }

}
