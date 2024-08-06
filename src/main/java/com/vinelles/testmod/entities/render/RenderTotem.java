package com.vinelles.testmod.entities.render;

import com.vinelles.testmod.entities.EntityTotem;
import com.vinelles.testmod.entities.models.Totem;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderTotem extends RenderLiving<EntityTotem> {

    private static final ResourceLocation TEXTURE = new ResourceLocation("testmod:textures/entity/totem.png");

    public RenderTotem(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new Totem(), 0.5F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityTotem entity) {
        return TEXTURE;
    }
}
