package com.vinelles.testmod.render;

import com.vinelles.testmod.entities.ammo.EntityNewBlizzard;
import com.vinelles.testmod.entities.EntityBlizzardRenderer;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.EnumParticleTypes;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class BlizzardFactory implements IRenderFactory<EntityNewBlizzard> {
    @Override
    public Render<? super EntityNewBlizzard> createRenderFor(RenderManager manager) {
        return new EntityBlizzardRenderer(manager);
    }
}
