package com.vinelles.testmod.handlers;

import net.minecraft.client.Minecraft;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Keyboard;

public class OpenGuiEventHandler {
    private boolean isAltPressed = false;

    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
        Minecraft mc = Minecraft.getMinecraft();

        if (Keyboard.isKeyDown(Keyboard.KEY_LMENU) && !isAltPressed) { // Проверка нажатия клавиши Alt
            mc.setIngameNotInFocus(); // Отвязка курсора от экрана
            isAltPressed = true;
        } else if (!Keyboard.isKeyDown(Keyboard.KEY_LMENU) && isAltPressed) {
            mc.setIngameFocus(); // Привязка курсора обратно к экрану
            isAltPressed = false;
        }
    }
}
