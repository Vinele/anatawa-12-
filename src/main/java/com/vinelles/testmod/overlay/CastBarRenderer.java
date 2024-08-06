package com.vinelles.testmod.overlay;

import com.vinelles.testmod.item.tools.Azzinot;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class CastBarRenderer {
    private static final ResourceLocation CAST_BAR_TEXTURE = new ResourceLocation("testmod", "textures/gui/cast.png");
    private static final ResourceLocation CAST_BAR_FRAME_TEXTURE = new ResourceLocation("testmod", "textures/gui/cast_frame.png");

    @SubscribeEvent
    public void onRenderGameOverlay(RenderGameOverlayEvent.Post event) {
        Minecraft mc = Minecraft.getMinecraft();
        EntityPlayer player = mc.player;
        if (event.getType() == RenderGameOverlayEvent.ElementType.ALL && player != null && player.isHandActive()) {
            ItemStack activeItemStack = player.getActiveItemStack();
            if (activeItemStack.getItem() instanceof Azzinot) {
                Azzinot azzinotItem = (Azzinot) activeItemStack.getItem();
                int castProgress = azzinotItem.getCastProgress();
                int castDuration = 20; // 1 секунда

                ScaledResolution scaledResolution = new ScaledResolution(mc);
                int width = scaledResolution.getScaledWidth();
                int height = scaledResolution.getScaledHeight();

                // Уменьшенные размеры полосы и рамки
                int frameWidth = 128;
                int frameHeight = 16;
                int barWidth = 120;
                int barHeight = 8;

                // Координаты для отображения над панелью инструментов
                int x = (width - frameWidth) / 2;
                int y = height - 48; // немного выше панели инструментов

                GlStateManager.enableBlend();
                mc.getTextureManager().bindTexture(CAST_BAR_FRAME_TEXTURE);
                mc.ingameGUI.drawTexturedModalRect(x, y, 0, 0, frameWidth, frameHeight);

                mc.getTextureManager().bindTexture(CAST_BAR_TEXTURE);
                int filledWidth = (int) (barWidth * (castProgress / (float) castDuration));
                mc.ingameGUI.drawTexturedModalRect(x + 4, y + 4, 0, 0, filledWidth, barHeight);
                GlStateManager.disableBlend();
            }
        }
    }
}
