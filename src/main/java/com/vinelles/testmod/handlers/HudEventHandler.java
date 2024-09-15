package com.vinelles.testmod.handlers;

import com.vinelles.testmod.custom_gui.micro_menu.MicroMenu;
import com.vinelles.testmod.hud.SelfStatusBar;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainerCreative;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Mouse;

public class HudEventHandler {
    private final SelfStatusBar statusBar = new SelfStatusBar();
    private final MicroMenu microMenu = new MicroMenu(); // Добавляем микроменю

    @SubscribeEvent
    public void onRenderGameOverlay(RenderGameOverlayEvent.Pre event) {
        // Отключаем стандартное отображение здоровья
        if (event.getType() == RenderGameOverlayEvent.ElementType.HEALTH) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public void onRenderGameOverlay(RenderGameOverlayEvent.Post event) {
        if (event.getType() == RenderGameOverlayEvent.ElementType.ALL) {
            statusBar.renderStatusBar();  // Отрисовка рамки с информацией
        }
    }

    // Отрисовка микроменю
    @SubscribeEvent
    public void onGuiDraw(GuiScreenEvent.DrawScreenEvent.Post event) {
        // Проверяем, открыт ли инвентарь или креативный режим
        if (event.getGui() instanceof GuiInventory || event.getGui() instanceof GuiContainerCreative) {
            // Получаем координаты мыши для корректного рендера
            int mouseX = event.getMouseX();
            int mouseY = event.getMouseY();

            // Отрисовываем микроменю
            microMenu.render(event.getGui(), mouseX, mouseY);
        }
    }
}
