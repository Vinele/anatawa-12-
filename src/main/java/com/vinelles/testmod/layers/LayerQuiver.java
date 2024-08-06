package com.vinelles.testmod.layers;

import com.vinelles.testmod.init.ItemsRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class LayerQuiver implements LayerRenderer<EntityPlayer> {
    @Override
    public void doRenderLayer(EntityPlayer player, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        GlStateManager.pushMatrix();

        // Позиция предмета
        GlStateManager.translate(0, 0.25F, 0.35F);

        // Вращение предмета
        GlStateManager.rotate(160F, 0, 0, 1); // Повернем вокруг оси Z на 180 градусов

        // Наклон предмета
        GlStateManager.rotate(0F, 1, 0, 0); // Наклон вокруг оси X на 45 градусов

        // Размеры предмета
        GlStateManager.scale(0.85F, 0.85F, 0.85F);

        // Условие: Если игрок присел, то мы меняем положение нашего колчана.
        if (player.isSneaking()) {
            GlStateManager.rotate(-30F, 1, 0, 0);
            GlStateManager.translate(0, -0.155F, 0.04F);
        }

        // Рендер предмета (обычный из Minecraft)
        Minecraft.getMinecraft().getRenderItem().renderItem(new ItemStack(ItemsRegistry.FROSTSTAFF), player, ItemCameraTransforms.TransformType.FIXED, false);

        GlStateManager.popMatrix();
    }

    @Override
    public boolean shouldCombineTextures() {
        return false;
    }
}
