package com.vinelles.testmod.custom_gui;

import com.vinelles.testmod.init.KeybindsRegister;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import java.io.IOException;

public class CustomGui extends GuiScreen {

    private static final ResourceLocation BACKGROUND_TEXTURE = new ResourceLocation("testmod", "textures/gui/custom_gui.png");
    private GuiButton closeGuiButton;
    private int mouseX;
    private int mouseY;

    @Override
    public void initGui() {
        super.initGui();
        Keyboard.enableRepeatEvents(true);
        int buttonWidth = 20;
        int buttonHeight = 20;
        int buttonX = this.width - buttonWidth - 55;
        int buttonY = this.height - buttonHeight - 10;
        closeGuiButton = new GuiButton(0, buttonX, buttonY, buttonWidth, buttonHeight, "->");
        this.buttonList.add(closeGuiButton);
    }

    @Override
    public void onGuiClosed() {
        super.onGuiClosed();
        Keyboard.enableRepeatEvents(false);
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);

        int centerX = (this.width - 256) / 2;
        int centerY = (this.height - 192) / 2;

        // Рисование фона с текстурой
        this.mc.getTextureManager().bindTexture(BACKGROUND_TEXTURE);
        this.drawTexturedModalRect(centerX, centerY, 0, 0, 256, 192);

        // Рисование текста в центре экрана
        this.drawCenteredString(this.fontRenderer, "Hello, World!", this.width / 2, this.height / 2, 0xFFFFFF);

        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false; // Чтобы игра не ставилась на паузу при открытии GUI
    }

    @Override
    protected void actionPerformed(GuiButton button) {
        if (button.id == 0) {
            // Сохраняем текущие координаты мыши
            this.mouseX = Mouse.getX();
            this.mouseY = Mouse.getY();

            this.mc.displayGuiScreen(null); // Закрытие CustomGui

            // Открываем инвентарь
            this.mc.displayGuiScreen(new GuiInventory(this.mc.player));

            // Устанавливаем координаты мыши в сохраненное положение
            Mouse.setCursorPosition(this.mouseX, this.mouseY);
        }
    }

    @Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException {
        if (keyCode == Keyboard.KEY_ESCAPE || keyCode == KeybindsRegister.KEY_GUI.getKeyCode()) {
            this.mc.displayGuiScreen(null); // Закрытие GUI
        } else {
            super.keyTyped(typedChar, keyCode);
        }
    }
}
