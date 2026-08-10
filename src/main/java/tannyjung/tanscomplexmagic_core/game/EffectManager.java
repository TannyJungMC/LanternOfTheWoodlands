package tannyjung.tanscomplexmagic_core.game;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class EffectManager {

    private static Holder<MobEffect> getHolder (ServerLevel level_server, String id) {

        try {

            return level_server.registryAccess().lookupOrThrow(Registries.MOB_EFFECT).getOrThrow(ResourceKey.create(Registries.MOB_EFFECT, ResourceLocation.parse(id)));

        } catch (Exception ignored) {

            return null;

        }

    }

    public static boolean has (ServerLevel level_server, Entity entity, String id) {

        if (entity instanceof LivingEntity entity_living) {

            Holder<MobEffect> effect = getHolder(level_server, id);

            if (effect == null) {

                return false;

            }

            return entity_living.getEffect(effect) != null;

        }

        return false;

    }

    public static boolean hasDuration (ServerLevel level_server, Entity entity, String id, int duration_min) {

        if (entity instanceof LivingEntity entity_living) {

            Holder<MobEffect> effect = getHolder(level_server, id);

            if (effect == null) {

                return false;

            }

            MobEffectInstance instance = entity_living.getEffect(effect);

            if (instance != null) {

                return duration_min * 20 <= instance.getDuration();

            }

        }

        return false;

    }

    public static void give (ServerLevel level_server, Entity entity, String id, int duration, int level) {

        if (entity instanceof LivingEntity entity_living) {

            Holder<MobEffect> effect = getHolder(level_server, id);

            if (effect == null) {

                return;

            }

            entity_living.addEffect(new MobEffectInstance(effect, 20 * duration, level, false, false));

        }

    }

    public static boolean clearAll (Entity entity) {

        if (entity instanceof LivingEntity entity_living) {

            return entity_living.removeAllEffects();

        }

        return false;

    }

    public static void clearSpecific (ServerLevel level_server, Entity entity, String id) {

        if (entity instanceof LivingEntity entity_living) {

            Holder<MobEffect> effect = getHolder(level_server, id);

            if (effect == null) {

                return;

            }

            entity_living.removeEffect(effect);

        }

    }

    public static void copyAll (Entity entity_from, Entity entity_to) {

        int duration = 2;

        if (entity_from instanceof LivingEntity entity_living_from) {

            if (entity_to instanceof LivingEntity entity_living_to) {

                for (MobEffectInstance instance : entity_living_from.getActiveEffects()) {

                    entity_living_to.addEffect(new MobEffectInstance(instance.getEffect(), 20 * duration, instance.getAmplifier(), instance.isAmbient(), instance.isVisible()));

                }

            }

        }

    }

    public static void copySpecific (ServerLevel level_server, Entity entity_from, Entity entity_to, String id) {

        if (entity_from instanceof LivingEntity entity_living_from) {

            if (entity_to instanceof LivingEntity entity_living_to) {

                Holder<MobEffect> effect = getHolder(level_server, id);

                if (effect == null) {

                    return;

                }

                MobEffectInstance instance = entity_living_from.getEffect(effect);

                if (instance == null) {

                    return;

                }

                entity_living_to.addEffect(instance);

            }

        }

    }

}
