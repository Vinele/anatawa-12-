package com.vinelles.testmod.render;

import com.vinelles.testmod.entities.healing.EntityHealingZone;
import com.vinelles.testmod.entities.healing.EntityHealingZoneRender;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraft.util.EnumParticleTypes;

public class HealingFactory implements IRenderFactory<EntityHealingZone> {
    @Override
    public Render<? super EntityHealingZone> createRenderFor(RenderManager manager) {
        return new EntityHealingZoneRender(manager);
    }
}
