package com.vinelles.testmod.entities.healing;

import com.vinelles.testmod.particle_effects.ParticleCircle;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;

public class EntityHealingZoneRender extends Render<EntityHealingZone> {



    public EntityHealingZoneRender(RenderManager renderManager) {
        super(renderManager);

    }

    @Override
    public void doRender(EntityHealingZone entity, double x, double y, double z, float entityYaw, float partialTicks) {
        if (entity.world.isRemote) {
            // Создание цилиндра из частиц вокруг EntityHealingZone
            double radius = entity.getRadius();
            int layers = 5; // Количество слоев
            int particleCount = 1; // Количество частиц в каждом слое

            ParticleCircle.createCylinder(entity.world, entity.posX, entity.posY, entity.posZ, radius, layers, particleCount, EnumParticleTypes.TOTEM);
        }
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityHealingZone entity) {
        return null; // Поскольку эта сущность не имеет текстуры, возвращаем null
    }
}
