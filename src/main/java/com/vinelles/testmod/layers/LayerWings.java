package com.vinelles.testmod.layers;


import com.vinelles.testmod.init.ItemsRegistry;
import com.vinelles.testmod.item.tools.Azzinot;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

public class LayerWings implements LayerRenderer<EntityLivingBase> {
    @Override
    public void doRenderLayer(EntityLivingBase entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        if (entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) entity;

            // Условие активации рендера крыльев
            if (player.getDataManager().get(Azzinot.IS_WINGS_ACTIVE)) {
                GlStateManager.pushMatrix();

                // Позиция крыльев
                GlStateManager.translate(0, 0.3F, 0.25F);

                // Вращение крыльев
                GlStateManager.rotate(180, 0, 0, 1); // Поворот вокруг оси Z на 180 градусов

                // Наклон крыльев
                GlStateManager.rotate(-45F, 1, 0, 0); // Наклон вокруг оси X на 45 градусов

                // Размеры крыльев
                GlStateManager.scale(2.0F, 2.0F, 2.0F);

                // Рендер предмета (обычный из Minecraft)
                Minecraft.getMinecraft().getRenderItem().renderItem(new ItemStack(ItemsRegistry.WINGS), player, ItemCameraTransforms.TransformType.FIXED, false);

                GlStateManager.popMatrix();
            }
        }
    }

    @Override
    public boolean shouldCombineTextures() {
        return false;
    }
}