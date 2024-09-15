package com.vinelles.testmod.custom_gui.micro_menu;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class MicroMenu {
    private static final ResourceLocation FRAME_TEXTURE = new ResourceLocation("testmod", "textures/gui/micro_menu_frame.png");
    private static final ResourceLocation BUTTONS_TEXTURE = new ResourceLocation("testmod", "textures/gui/micro_menu_buttons.png");

    private static final int FRAME_WIDTH = 122;
    private static final int FRAME_HEIGHT = 22;

    private static final int BUTTON_WIDTH = 16;
    private static final int BUTTON_HEIGHT = 16;
    private static final int BUTTON_SPACING = 5;

    private final int[] buttonXOffsets = {5, 26, 47, 68, 89, 110}; // Координаты кнопок
    private final int buttonYOffset = 3;

    private static final String[] TOOLTIPS = {
            "Книга заклинаний", "Специализация и таланты", "Транспорт",
            "Атлас подземелий", "Друзья", "Внутриигровой магазин"
    };

    public void render(GuiScreen screen, int mouseX, int mouseY) {
        if (!(screen instanceof GuiInventory)) return; // Показывать только при открытом инвентаре

        Minecraft mc = Minecraft.getMinecraft();
        int guiLeft = screen.width - FRAME_WIDTH - 10; // Положение рамки в правом нижнем углу
        int guiTop = screen.height - FRAME_HEIGHT - 10;

        // Загружаем текстуру рамки
        mc.getTextureManager().bindTexture(FRAME_TEXTURE);

        // Включаем смешивание для обработки прозрачности
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

        // Отрисовка рамки: вырезаем точные размеры 122x22 пикселя
        screen.drawTexturedModalRect(guiLeft, guiTop, 0, 0, FRAME_WIDTH, FRAME_HEIGHT);
        GL11.glDisable(GL11.GL_BLEND);

        // Отрисовка кнопок
        mc.getTextureManager().bindTexture(BUTTONS_TEXTURE);
        for (int i = 0; i < buttonXOffsets.length; i++) {
            int buttonX = guiLeft + buttonXOffsets[i];
            int buttonY = guiTop + buttonYOffset;

            boolean isHovered = mouseX >= buttonX && mouseY >= buttonY && mouseX < buttonX + BUTTON_WIDTH && mouseY < buttonY + BUTTON_HEIGHT;
            int textureY = isHovered ? BUTTON_HEIGHT : 0; // Если наводим мышь, используем альтернативную текстуру

            // Вырезаем каждую кнопку из текстуры
            screen.drawTexturedModalRect(buttonX, buttonY, 0, textureY, BUTTON_WIDTH, BUTTON_HEIGHT);

            if (isHovered) {
                // Отображаем подсказку при наведении
                screen.drawHoveringText(TOOLTIPS[i], mouseX, mouseY);
            }
        }
    }
}
