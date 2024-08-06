package com.vinelles.testmod.entities;

import com.vinelles.testmod.TestMod;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class ModEntities {
    public static void registerEntities() {
        registerEntity("rideable_enderman", EntityRideableEnderman.class, 120, 50, 0x1A1A1A, 0xFF00FF,0xFF00FF );


    }

    private static void registerEntity(String name, Class<? extends Entity> entityClass, int id, int trackingRange, int updateFrequency, int eggPrimary, int eggSecondary) {
        ResourceLocation location = new ResourceLocation(TestMod.MODID, name);
        EntityRegistry.registerModEntity(location, entityClass, name, id, TestMod.MODID, trackingRange, updateFrequency, true, eggPrimary, eggSecondary);
    }
}