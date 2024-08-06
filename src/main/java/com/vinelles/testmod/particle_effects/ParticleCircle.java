package com.vinelles.testmod.particle_effects;

import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

public class ParticleCircle {

    private static double angle = 0; // Угол для вращения

    public static void createCylinder(World world, double centerX, double centerY, double centerZ, double radius, int layers, int particleCount, EnumParticleTypes particleType) {
        angle += 0.1; // Обновляем угол для вращения
        if (angle > 2 * Math.PI) {
            angle -= 2 * Math.PI;
        }

        for (int layer = 0; layer < layers; layer++) {
            double yOffset = layer * 0.5; // Высота каждого слоя

            for (int i = 0; i < particleCount; i++) {
                double particleAngle = 2 * Math.PI * i / particleCount + angle; // Угол частицы с учетом вращения
                double xOffset = Math.cos(particleAngle) * radius;
                double zOffset = Math.sin(particleAngle) * radius;
                world.spawnParticle(particleType, centerX + xOffset, centerY + yOffset, centerZ + zOffset, 0.0D, 0.0D, 0.0D);
            }
        }
    }

    public static void createDome(World world, double centerX, double centerY, double centerZ, double radius, int layers, int particleCount, EnumParticleTypes particleType) {
        angle += 0.1; // Обновляем угол для вращения
        if (angle > 2 * Math.PI) {
            angle -= 2 * Math.PI;
        }

        for (int layer = 0; layer < layers; layer++) {
            double layerAngle = Math.PI * layer / (layers - 1) / 2; // Угол для слоев полусферы (от 0 до PI/2)
            double currentAngle = (layer % 2 == 0) ? angle : -angle; // Направление вращения для слоя

            for (int i = 0; i < particleCount; i++) {
                double particleAngle = 2 * Math.PI * i / particleCount + currentAngle; // Угол частицы с учетом вращения
                double xOffset = Math.cos(particleAngle) * Math.sin(layerAngle) * radius;
                double yOffset = Math.cos(layerAngle) * radius;
                double zOffset = Math.sin(particleAngle) * Math.sin(layerAngle) * radius;
                world.spawnParticle(particleType, centerX + xOffset, centerY + yOffset, centerZ + zOffset, 0.0D, 0.0D, 0.0D);
            }
        }
    }

}
