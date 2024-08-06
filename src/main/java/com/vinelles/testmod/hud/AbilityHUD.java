package com.vinelles.testmod.hud;

import com.vinelles.testmod.custom_gui.skills.ActiveSkillsManager;
import com.vinelles.testmod.custom_gui.skills.Skill;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.MinecraftForge;
import org.lwjgl.opengl.GL11;

import java.util.List;

public class AbilityHUD extends Gui {

    private final Minecraft mc = Minecraft.getMinecraft();
    private static final ResourceLocation WIDGETS_TEXTURE = new ResourceLocation("minecraft", "textures/gui/widgets.png");
    private static final ResourceLocation FIREBALL_TEXTURE = new ResourceLocation("minecraft", "textures/items/fire_charge.png");
    List<Skill> activeSkills;

    public AbilityHUD() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onRenderGameOverlay(RenderGameOverlayEvent.Post event) {
        if (event.getType() == RenderGameOverlayEvent.ElementType.ALL) {
            renderAbilityBar();
        }
    }

    private void renderAbilityBar() {
        int xPos = 10; // Отступ от левого края экрана
        int yPos = 10; // Отступ от верхнего края экрана
        int panelWidth = 182; // Ширина панели инструментов
        int panelHeight = 22; // Высота панели инструментов

        mc.getTextureManager().bindTexture(WIDGETS_TEXTURE);
        GL11.glPushMatrix();
        GL11.glTranslatef(xPos + panelHeight, yPos, 0); // Перемещаемся к позиции панели
        GL11.glRotatef(90, 0, 0, 1); // Поворачиваем на 90 градусов по часовой стрелке
        drawTexturedModalRect(0, 0, 0, 0, panelWidth, panelHeight); // Рисуем панель инструментов
        GL11.glPopMatrix();

        renderActiveSkills(xPos + panelHeight, yPos);
    }

    private void renderActiveSkills(int xPos, int yPos) {
        activeSkills = ActiveSkillsManager.getActiveSkills();
        int iconSize = 16; // Размер иконки скилла
        int spacing = 4; // Расстояние между иконками
        int yOffset = 20; // Смещение по Y для каждого нового скилла

        for (int i = 0; i < activeSkills.size(); i++) {
            ResourceLocation icon;
            if (i == 0) {
                // Используем текстуру огненного шара для первой ячейки
                icon = FIREBALL_TEXTURE;
            } else {
                // Используем иконку скилла для остальных
                icon = activeSkills.get(i).getIcon();
            }

            mc.getTextureManager().bindTexture(icon);

            int iconX = xPos;
            int iconY = yPos + i * yOffset;

            GL11.glPushMatrix();
            GL11.glTranslatef(iconX, iconY, 0);
            drawTexturedModalRect(0, 0, 0, 0, iconSize, iconSize);
            GL11.glPopMatrix();
        }
    }
}