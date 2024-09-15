package com.vinelles.testmod.handlers;

import com.vinelles.testmod.custom_gui.micro_menu.MicroMenu;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainerCreative;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class MicroMenuHandler {
    private final MicroMenu microMenu = new MicroMenu();

    // Событие для отрисовки микро-меню на HUD
    @SubscribeEvent
    public void onRenderGameOverlay(RenderGameOverlayEvent.Post event) {
        // Если HUD отображается и инвентарь не открыт, рисуем микро-меню на HUD
        if (event.getType() == RenderGameOverlayEvent.ElementType.ALL) {
            if (Minecraft.getMinecraft().currentScreen == null) {
                microMenu.renderHudMicroMenu();  // Отрисовка микро-меню на HUD
            }
        }
    }

    // Событие для инициализации микро-меню при открытии инвентаря или креативного меню
    @SubscribeEvent
    public void onGuiOpen(GuiScreenEvent.InitGuiEvent.Post event) {
        if (event.getGui() instanceof GuiInventory || event.getGui() instanceof GuiContainerCreative) {
            // Инициализируем микро-меню, когда открыт инвентарь, передаем `event`, а не `event.getGui()`
            microMenu.initMicroMenu(event);
        }
    }

    // Событие для отрисовки микро-меню в инвентаре
    @SubscribeEvent
    public void onRenderGameOverlayMenu(RenderGameOverlayEvent.Post event) {
        // Если открыт инвентарь или креативное меню, рисуем микро-меню
        if (Minecraft.getMinecraft().currentScreen instanceof GuiInventory || Minecraft.getMinecraft().currentScreen instanceof GuiContainerCreative) {
            microMenu.renderMicroMenu();  // Отрисовка микро-меню в инвентаре
        }
    }
}
