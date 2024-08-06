package com.vinelles.testmod.overlay;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiTextField;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class CustomMainMenu extends GuiMainMenu {

   // @SubscribeEvent
   // public void onGuiOpen(GuiOpenEvent event) {
   //     if (event.getGui() instanceof GuiMainMenu) {
   //         event.setGui(new CustomMainMenu());
   //     }
   // }
//
   // @Override
   // public void initGui() {
   //     super.initGui();
//
   //     // Найти и удалить кнопки "Сетевая игра", "Mods" и "Realms"
   //     buttonList.removeIf(button -> button.id == 2 || button.id == 6 || button.id == 14);
//
   //     // Найти и удалить текстовые поля, которые могут быть связаны с изумрудом
   //     removeEmeraldElement();
//
   //     // Обновить координаты кнопок после удаления
//
   // }
//
   // private void removeEmeraldElement() {
   //     this.buttonList.removeIf(button -> button.id == 14); // Удалить кнопку "Realms" и её изумруд
   //     // Удалить изумруд, если он является отдельным элементом
   //     this.buttonList.removeIf(button -> button.displayString.equals("Mods")); // Это может помочь удалить изумруд
   // }
//
   // private void updateButtonPositions() {
   //     int i = this.height / 4 + 48;
//
   //     for (GuiButton button : this.buttonList) {
   //         // Переместить кнопки вверх после удаления
   //         if (button.id == 1) { // "Одиночная игра"
   //             button.y = i;
   //         } else if (button.id == 0) { // "Настройки..."
   //             button.y = i + 24;
   //         } else if (button.id == 4) { // "Выйти из игры"
   //             button.y = i + 48;
   //         }
   //     }
   // }
}
