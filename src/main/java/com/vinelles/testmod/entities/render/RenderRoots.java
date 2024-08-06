package com.vinelles.testmod.entities.render;

import com.vinelles.testmod.entities.EntityRoots;
import com.vinelles.testmod.entities.models.Roots;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderRoots extends RenderLiving<EntityRoots> {

    private static final ResourceLocation TEXTURE = new ResourceLocation("testmod:textures/entity/roots.png");
    private final Roots model;

    public RenderRoots(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new Roots(), 0.5F);
        this.model = (Roots) super.mainModel;
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityRoots entity) {
        return TEXTURE;
    }

    @Override
    public void doRender(EntityRoots entity, double x, double y, double z, float entityYaw, float partialTicks) {
        if (entity.ticksExisted <= 26) { // 26 тиков соответствует длительности анимации (1.2917 секунд)
            model.setAnimationTime(entity.ticksExisted / 20.0F); // обновляем модель по времени анимации
        } else {
            model.setAnimationTime(1.2917F); // останавливаем анимацию на последнем кадре
        }

        GlStateManager.pushMatrix();
        GlStateManager.translate(x, y, z);
        GlStateManager.rotate(entityYaw, 0, 1, 0);
        this.bindEntityTexture(entity);
        this.model.render(entity, 0, 0, 0, 0, 0, 0.0625F);
        GlStateManager.popMatrix();
    }
}
