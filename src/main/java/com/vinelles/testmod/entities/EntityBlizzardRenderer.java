package com.vinelles.testmod.entities;

import com.vinelles.testmod.entities.ammo.EntityNewBlizzard;
import com.vinelles.testmod.particle_effects.ParticleCircle;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;

public class EntityBlizzardRenderer extends Render<EntityNewBlizzard> {


    public EntityBlizzardRenderer(RenderManager renderManager) {
        super(renderManager);

    }

    @Override
    public void doRender(EntityNewBlizzard entity, double x, double y, double z, float entityYaw, float partialTicks) {
        if (entity.world.isRemote) {
            // Создание цилиндра из частиц вокруг EntityNewBlizzard
            double radius = entity.getRadius();
            int layers = 10; // Количество слоев
            int particleCount = 1; // Количество частиц в каждом слое

            ParticleCircle.createDome(entity.world, entity.posX, entity.posY, entity.posZ, radius, layers, particleCount, EnumParticleTypes.SNOW_SHOVEL );
        }
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityNewBlizzard entity) {
        return null; // Поскольку эта сущность не имеет текстуры, возвращаем null
    }
}
