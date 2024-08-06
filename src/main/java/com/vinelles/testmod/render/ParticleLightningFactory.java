package com.vinelles.testmod.render;


import com.vinelles.testmod.particles.ParticleLightning;
import net.minecraft.client.particle.IParticleFactory;
import net.minecraft.client.particle.Particle;
import net.minecraft.world.World;

public class ParticleLightningFactory implements IParticleFactory {
        @Override
                public Particle createParticle(int particleID, World worldIn, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeedIn, double ySpeedIn, double zSpeedIn, int... parameters) {
                return new ParticleLightning(worldIn, xCoordIn, yCoordIn, zCoordIn, xSpeedIn, ySpeedIn, zSpeedIn);
            }
    }