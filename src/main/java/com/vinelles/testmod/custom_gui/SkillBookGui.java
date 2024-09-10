package com.vinelles.testmod.custom_gui;

import com.vinelles.testmod.custom_gui.skills.ActiveSkillsManager;
import com.vinelles.testmod.custom_gui.skills.Skill;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.GlStateManager;

import java.util.List;

public class SkillBookGui extends GuiScreen {

    private final ResourceLocation BOOK_TEXTURE = new ResourceLocation("testmod", "textures/gui/spell_book.png");
    private final int BOOK_WIDTH = 180;
    private final int BOOK_HEIGHT = 180;
    private final int SKILLS_PER_PAGE = 6; // Увеличим количество навыков на странице до 6
    private final int SKILL_SPACING = 20; // Уменьшим расстояние между навыками

    // Новые параметры для сдвига
    private final int ICON_OFFSET_X = 35;
    private final int TEXT_OFFSET_X = 55;
    private final int BUTTON_PLUS_OFFSET_X = 115;
    private final int BUTTON_MINUS_OFFSET_X = 135;

    private List<Skill> skills;
    private int currentPage = 0;

    public SkillBookGui(List<Skill> currentSkills) {
        this.skills = currentSkills;
    }

    @Override
    public void initGui() {
        int centerX = (this.width - BOOK_WIDTH) / 2;
        int centerY = (this.height - BOOK_HEIGHT) / 2;

        int buttonWidth = 15;
        int buttonHeight = 15;
        int skillY = centerY + 20;

        this.buttonList.clear();

        for (int i = 0; i < SKILLS_PER_PAGE; i++) {
            int skillIndex = currentPage * SKILLS_PER_PAGE + i;
            if (skillIndex < skills.size()) {
                this.buttonList.add(new GuiButton(skillIndex * 2, centerX + BUTTON_PLUS_OFFSET_X, skillY + 5, buttonWidth, buttonHeight, "+"));
                this.buttonList.add(new GuiButton(skillIndex * 2 + 1, centerX + BUTTON_MINUS_OFFSET_X, skillY + 5, buttonWidth, buttonHeight, "-"));
                skillY += SKILL_SPACING;
            }
        }

        this.buttonList.add(new PageButton(1000, centerX + 38, centerY + BOOK_HEIGHT - 24, true));
        this.buttonList.add(new PageButton(1001, centerX + BOOK_WIDTH - 58, centerY + BOOK_HEIGHT - 24, false));
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        drawDefaultBackground();

        // Привязываем текстуру книги и рисуем её
        mc.getTextureManager().bindTexture(BOOK_TEXTURE);

        // Получаем центральную позицию
        int centerX = (this.width - BOOK_WIDTH) / 2;
        int centerY = (this.height - BOOK_HEIGHT) / 2;

        // Рисуем текстуру книги с корректными размерами (растягиваем текстуру 180x180 до размеров окна книги)
        drawScaledCustomSizeModalRect(centerX, centerY, 0, 0, 180, 180, BOOK_WIDTH, BOOK_HEIGHT, 180, 180);

        // Отображаем все остальное
        super.drawScreen(mouseX, mouseY, partialTicks);

        int skillY = centerY + 20;  // начальная позиция Y для навыков
        int hoveredSkillIndex = -1; // индекс выделенного навыка (если на него наведен курсор)

        // Проверяем наведение на навыки для выделения
        for (int i = 0; i < SKILLS_PER_PAGE; i++) {
            int skillIndex = currentPage * SKILLS_PER_PAGE + i;
            if (skillIndex < skills.size()) {
                Skill skill = skills.get(skillIndex);

                boolean isMouseOverSkill = (mouseX >= centerX + ICON_OFFSET_X && mouseX < centerX + ICON_OFFSET_X + 16 && mouseY >= skillY + 5 && mouseY < skillY + 21) ||
                        (mouseX >= centerX + TEXT_OFFSET_X && mouseX < centerX + TEXT_OFFSET_X + mc.fontRenderer.getStringWidth(skill.getName()) && mouseY >= skillY + 5 && mouseY < skillY + 15);

                if (isMouseOverSkill) {
                    hoveredSkillIndex = i;
                }

                skillY += SKILL_SPACING;  // увеличиваем Y координату для следующего навыка
            }
        }

        skillY = centerY + 20;  // сбрасываем Y координату для отрисовки иконок и текста навыков
        for (int i = 0; i < SKILLS_PER_PAGE; i++) {
            int skillIndex = currentPage * SKILLS_PER_PAGE + i;
            if (skillIndex < skills.size()) {
                Skill skill = skills.get(skillIndex);

                // Привязываем иконку навыка
                mc.getTextureManager().bindTexture(skill.getIcon());

                // Устанавливаем цвет для отрисовки
                GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);

                // Рисуем иконку навыка
                drawScaledCustomSizeModalRect(centerX + ICON_OFFSET_X, skillY + 5, 0, 0, 16, 16, 16, 16, 16, 16);

                // Отрисовка имени навыка
                drawString(mc.fontRenderer, skill.getName(), centerX + TEXT_OFFSET_X, skillY + 5, 0x808080);

                skillY += SKILL_SPACING;  // увеличиваем Y координату для следующего навыка
            }
        }

        // Отображаем всплывающую подсказку, если курсор наведен на навык
        if (hoveredSkillIndex != -1) {
            int skillIndex = currentPage * SKILLS_PER_PAGE + hoveredSkillIndex;
            if (skillIndex < skills.size()) {
                Skill skill = skills.get(skillIndex);
                drawHoveringText(skill.getTooltip(), mouseX, mouseY);  // отображаем подсказку
            }
        }
    }


    @Override
    protected void actionPerformed(GuiButton button) {
        if (button.id == 1000) {
            if (currentPage > 0) {
                currentPage--;
                initGui();
            }
        } else if (button.id == 1001) {
            if ((currentPage + 1) * SKILLS_PER_PAGE < skills.size()) {
                currentPage++;
                initGui();
            }
        } else {
            int skillIndex = button.id / 2;
            Skill skill = skills.get(skillIndex);
            if (button.displayString.equals("+")) {
                ActiveSkillsManager.addSkill(skill);
            } else if (button.displayString.equals("-")) {
                ActiveSkillsManager.removeSkill(skill);
            }
        }
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }

    private class PageButton extends GuiButton {
        private final boolean isLeft;

        public PageButton(int buttonId, int x, int y, boolean isLeft) {
            super(buttonId, x, y, 20, 20, "");
            this.isLeft = isLeft;
        }

        @Override
        public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks) {
            if (this.visible) {
                mc.getTextureManager().bindTexture(BOOK_TEXTURE);
                GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
                boolean isHovered = mouseX >= this.x && mouseY >= this.y && mouseX < this.x + this.width && mouseY < this.y + this.height;

                int textureX, textureY;

                if (this.isLeft) {
                    textureX = isHovered ? 26 : 3;
                    textureY = 207;
                } else {
                    textureX = isHovered ? 26 : 3;
                    textureY = 194;
                }

                int width = 18;
                int height = 10;

                drawTexturedModalRect(this.x, this.y, textureX, textureY, width, height);
            }
        }
    }
}