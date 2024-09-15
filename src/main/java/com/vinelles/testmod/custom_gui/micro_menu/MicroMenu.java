package com.vinelles.testmod.custom_gui.micro_menu;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Mouse;

import java.util.ArrayList;
import java.util.List;

public class MicroMenu extends GuiScreen {
    private static final ResourceLocation FRAME_TEXTURE = new ResourceLocation("testmod", "textures/gui/micro_menu_frame.png");
    private static final ResourceLocation BUTTONS_TEXTURE = new ResourceLocation("testmod", "textures/gui/micro_menu_buttons.png");
    private static final ResourceLocation HUD_TEXTURE = new ResourceLocation("testmod", "textures/gui/micro_menu_hud.png");

    private final int frameWidth = 122;
    private final int frameHeight = 22;
    private final int buttonWidth = 16;
    private final int buttonHeight = 16;
    private final int buttonSpacing = 5;

    private final int[] buttonXOffsets = {5, 26, 47, 68, 89, 110};
    private final int buttonYOffset = 3;
    private final String[] buttonTooltips = {
            "Книга заклинаний",
            "Специализация и таланты",
            "Транспорт",
            "Атлас подземелий",
            "Друзья",
            "Внутриигровой магазин"
    };

    private final List<GuiButton> buttons = new ArrayList<>();

    // Новый метод initMicroMenu для инициализации меню
    public void initMicroMenu(GuiScreenEvent.InitGuiEvent.Post event) {
        Minecraft mc = Minecraft.getMinecraft();
        ScaledResolution resolution = new ScaledResolution(mc);

        int screenWidth = resolution.getScaledWidth();
        int screenHeight = resolution.getScaledHeight();
        int frameX = screenWidth - frameWidth - 10;
        int frameY = screenHeight - frameHeight - 10;

        // Создаем кнопки и добавляем их в список через событие
        for (int i = 0; i < buttonXOffsets.length; i++) {
            int buttonX = frameX + buttonXOffsets[i];
            int buttonY = frameY + buttonYOffset;

            GuiButton button = new GuiButton(1000 + i, buttonX, buttonY, buttonWidth, buttonHeight, "");
            buttons.add(button);
            event.getButtonList().add(button);  // Добавляем кнопки через событие
        }
    }



    // Отрисовка микро-меню в инвентаре
    public void renderMicroMenu() {
        Minecraft mc = Minecraft.getMinecraft();
        ScaledResolution resolution = new ScaledResolution(mc);

        int screenWidth = resolution.getScaledWidth();
        int screenHeight = resolution.getScaledHeight();
        int frameX = screenWidth - frameWidth - 10;
        int frameY = screenHeight - frameHeight - 10;

        // Отрисовка рамки микро-меню
        mc.getTextureManager().bindTexture(FRAME_TEXTURE);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        drawModalRectWithCustomSizedTexture(frameX, frameY, 0, 0, frameWidth, frameHeight, frameWidth, frameHeight);

        // Отрисовка кнопок
        mc.getTextureManager().bindTexture(BUTTONS_TEXTURE);
        for (int i = 0; i < buttons.size(); i++) {
            GuiButton button = buttons.get(i);
            int buttonX = button.x;
            int buttonY = button.y;

            if (isMouseOverButton(buttonX, buttonY, buttonWidth, buttonHeight)) {
                drawModalRectWithCustomSizedTexture(buttonX, buttonY, buttonWidth, 0, buttonWidth, buttonHeight, 64, 32);
                renderTooltip(i, buttonX, buttonY);
            } else {
                drawModalRectWithCustomSizedTexture(buttonX, buttonY, 0, 0, buttonWidth, buttonHeight, 64, 32);
            }
        }
    }

    // Отрисовка микро-меню в HUD (когда инвентарь закрыт)
    public void renderHudMicroMenu() {
        Minecraft mc = Minecraft.getMinecraft();
        ScaledResolution resolution = new ScaledResolution(mc);

        int screenWidth = resolution.getScaledWidth();
        int screenHeight = resolution.getScaledHeight();
        int frameX = screenWidth - frameWidth - 10;
        int frameY = screenHeight - frameHeight - 10;

        // Отрисовка текстуры HUD микро-меню
        mc.getTextureManager().bindTexture(HUD_TEXTURE);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        drawModalRectWithCustomSizedTexture(frameX, frameY, 0, 0, frameWidth, frameHeight, frameWidth, frameHeight);
    }

    private boolean isMouseOverButton(int x, int y, int width, int height) {
        int mouseX = (int) (Mouse.getX() * new ScaledResolution(Minecraft.getMinecraft()).getScaledWidth() / (float) Minecraft.getMinecraft().displayWidth);
        int mouseY = new ScaledResolution(Minecraft.getMinecraft()).getScaledHeight() - Mouse.getY() * new ScaledResolution(Minecraft.getMinecraft()).getScaledHeight() / Minecraft.getMinecraft().displayHeight - 1;
        return mouseX >= x && mouseY >= y && mouseX < x + width && mouseY < y + height;
    }

    private void renderTooltip(int buttonIndex, int x, int y) {
        String tooltip = buttonTooltips[buttonIndex];
        drawCenteredString(Minecraft.getMinecraft().fontRenderer, tooltip, x + (buttonWidth / 2), y - 12, 0xFFFFFF);
    }
}
