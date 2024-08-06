package com.vinelles.testmod.particles;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class CustomParticle extends Particle {

    public CustomParticle(World worldIn, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeedIn, double ySpeedIn, double zSpeedIn) {
        super(worldIn, xCoordIn, yCoordIn, zCoordIn, xSpeedIn, ySpeedIn, zSpeedIn);
        // Установка времени жизни и гравитации частицы
        this.particleMaxAge = 100; // Время жизни частицы в тиках
        this.particleGravity = 0.0F; // Гравитация частицы

        // Получение текстуры дыма из атласа текстур
        TextureAtlasSprite sprite = Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite("minecraft:particle/smoke");
        this.setParticleTexture(sprite);
    }

    @Override
    public void renderParticle(BufferBuilder buffer, Entity entityIn, float partialTicks, float rotationX, float rotationZ, float rotationYZ, float rotationXY, float rotationXZ) {
        // Рендеринг частицы
        super.renderParticle(buffer, entityIn, partialTicks, rotationX, rotationZ, rotationYZ, rotationXY, rotationXZ);
    }

    @Override
    public int getFXLayer() {
        return 1; // Уровень слоя рендера (1 для текстур частиц)
    }
}
