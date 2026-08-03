package tannyjung.tanscomplexmagic_core.game;

import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class EffectManager {

    private static Holder<MobEffect> getHolder (ServerLevel level_server, String id) {

        return level_server.registryAccess().lookupOrThrow(Registries.MOB_EFFECT).getOrThrow(ResourceKey.create(Registries.MOB_EFFECT, ResourceLocation.parse(id)));

    }

    public static void give (ServerLevel level_server, Entity entity, String id, int duration, int level) {

        if (entity instanceof LivingEntity entity_living) {

            Holder<MobEffect> effect = getHolder(level_server, id);
            MobEffectInstance instance = new MobEffectInstance(effect, 20 * duration, level, false, false);
            entity_living.addEffect(instance);

        }

    }

    public static boolean has (ServerLevel level_server, Entity entity, String id, int duration_min, int duration_max) {

        if (entity instanceof LivingEntity entity_living) {

            Holder<MobEffect> effect = getHolder(level_server, id);
            MobEffectInstance instance = entity_living.getEffect(effect);

            if (instance != null) {

                duration_min = 20 * duration_min;
                duration_max = 20 * duration_max;
                return (instance.getDuration() >= duration_min && (duration_max == 0 || duration_max <= instance.getDuration()));

            }

        }

        return false;

    }

}
