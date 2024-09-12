package com.vinelles.testmod.hud;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

public class SelfStatusBar {
    private static final ResourceLocation FRAME_TEXTURE = new ResourceLocation("testmod", "textures/gui/health_bar_frame.png");
    private static final ResourceLocation HEALTH_BAR_TEXTURE = new ResourceLocation("testmod", "textures/gui/status_bars.png");

    public void renderStatusBar() {
        Minecraft mc = Minecraft.getMinecraft();
        EntityPlayer player = mc.player;

        ScaledResolution resolution = new ScaledResolution(mc);
        int x = 10;  // Положение рамки по X
        int y = 10;  // Положение рамки по Y

        // Рисуем рамку
        mc.getTextureManager().bindTexture(FRAME_TEXTURE);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        mc.ingameGUI.drawTexturedModalRect(x, y, 0, 0, 160, 60);

        // Отображаем модель игрока статично
        drawPlayerModel(x + 30, y + 55, 30, player);

        // Отображаем уровень игрока под рамкой
        String playerLevel = "Level: " + player.experienceLevel;
        mc.fontRenderer.drawString(playerLevel, x + 70, y + 50, 0xFFFFFF);

        // Отображаем полосу здоровья
        renderHealthBar(x + 70, y + 30, player);
    }

    private void drawPlayerModel(int posX, int posY, int scale, EntityPlayer player) {
        GlStateManager.enableColorMaterial();
        GlStateManager.pushMatrix();

        // Позиционируем модель
        GlStateManager.translate((float) posX, (float) posY, 50.0F);
        GlStateManager.scale((float) (-scale), (float) scale, (float) scale);
        GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);  // Поворот модели

        RenderHelper.enableStandardItemLighting();

        // Получаем экземпляр RenderManager
        RenderManager rendermanager = Minecraft.getMinecraft().getRenderManager();

        // Сохраняем текущие значения игрока
        float originalYaw = player.rotationYaw;
        float originalYawHead = player.rotationYawHead;
        float originalPitch = player.rotationPitch;
        float originalPrevLimbSwingAmount = player.prevLimbSwingAmount;
        float originalLimbSwingAmount = player.limbSwingAmount;
        float originalLimbSwing = player.limbSwing;

        // Устанавливаем статичные значения для рендера модели в рамке
        player.rotationYaw = 180.0F; // Фиксируем тело
        player.rotationYawHead = 180.0F; // Фиксируем голову
        player.rotationPitch = 0.0F; // Фиксируем угол по вертикали
        player.prevLimbSwingAmount = 0.0F; // Отключаем анимацию шага
        player.limbSwingAmount = 0.0F;
        player.limbSwing = 0.0F;

        // Рендерим модель игрока в HUD без передачи каких-либо действий
        rendermanager.setPlayerViewY(180F);  // Модель смотрит прямо в экран
        rendermanager.renderEntity(player, 0, 0, 0, 0.0F, 0.0F, false);

        // Восстанавливаем оригинальные значения игрока после рендера
        player.rotationYaw = originalYaw;
        player.rotationYawHead = originalYawHead;
        player.rotationPitch = originalPitch;
        player.prevLimbSwingAmount = originalPrevLimbSwingAmount;
        player.limbSwingAmount = originalLimbSwingAmount;
        player.limbSwing = originalLimbSwing;

        GlStateManager.popMatrix();
        RenderHelper.disableStandardItemLighting();
        GlStateManager.disableRescaleNormal();
    }

    // Метод для отрисовки полосы здоровья
    private void renderHealthBar(int x, int y, EntityPlayer player) {
        Minecraft mc = Minecraft.getMinecraft();
        mc.getTextureManager().bindTexture(HEALTH_BAR_TEXTURE);

        float health = player.getHealth();
        float maxHealth = player.getMaxHealth();
        int healthWidth = (int) ((health / maxHealth) * 100);  // Вычисляем длину полоски в зависимости от здоровья

        // Рисуем только одну полоску, которая уменьшается
        mc.ingameGUI.drawTexturedModalRect(x, y, 0, 0, healthWidth, 10);

        // Отображаем числовое значение здоровья в центре полосы
        String healthText = (int) health + "/" + (int) maxHealth;
        mc.fontRenderer.drawString(healthText, x + 40, y + 1, 0xFFFFFF);
    }
}
