package com.vinelles.testmod.particles;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ParticleLightning extends Particle {

    private static final ResourceLocation LIGHTNING_TEXTURE = new ResourceLocation("testmod:textures/particles/lightning.png");

    public ParticleLightning(World worldIn, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeedIn, double ySpeedIn, double zSpeedIn) {
        super(worldIn, xCoordIn, yCoordIn, zCoordIn, xSpeedIn, ySpeedIn, zSpeedIn);
        this.setParticleTexture(Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite(LIGHTNING_TEXTURE.toString()));
        this.particleMaxAge = 20; // Время жизни частицы
        this.particleGravity = 0.0F; // Гравитация частицы
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        // Логика обновления частицы
    }

    @Override
    public int getFXLayer() {
        return 1; // Слой текстуры
    }

    @Override
    public void renderParticle(BufferBuilder buffer, Entity entityIn, float partialTicks, float rotationX, float rotationZ, float rotationYZ, float rotationXY, float rotationXZ) {
        // Рендеринг частицы
        super.renderParticle(buffer, entityIn, partialTicks, rotationX, rotationZ, rotationYZ, rotationXY, rotationXZ);
    }
}
