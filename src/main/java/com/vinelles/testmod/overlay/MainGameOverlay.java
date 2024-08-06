package com.vinelles.testmod.overlay;

import com.vinelles.testmod.custom_gui.CustomGui;
import com.vinelles.testmod.custom_gui.SkillBookGui;
import com.vinelles.testmod.custom_gui.skills.MageSkills;
import com.vinelles.testmod.custom_gui.skills.Skill;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainerCreative;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.List;

public class MainGameOverlay {
    private final Minecraft mc;
    private GuiButton openGuiButton;
    private GuiButton skillBookButton;

    public MainGameOverlay(Minecraft mc) {
        this.mc = mc;
    }

    @SubscribeEvent
    public void onGuiOpen(GuiScreenEvent.InitGuiEvent.Post event) {
        if (event.getGui() instanceof GuiInventory || event.getGui() instanceof GuiContainerCreative) {
            int buttonWidth = 100;
            int buttonHeight = 20;
            int buttonX = event.getGui().width - buttonWidth - 10;
            int buttonY = event.getGui().height - buttonHeight - 10;

            openGuiButton = new GuiButton(1000, buttonX, buttonY, buttonWidth, buttonHeight, "Open Custom GUI");
            skillBookButton = new GuiButton(1001, buttonX, buttonY - buttonHeight - 5, buttonWidth, buttonHeight, "Skill Book");

            event.getButtonList().add(openGuiButton);
            event.getButtonList().add(skillBookButton);
        }
    }

    @SubscribeEvent
    public void onGuiButtonClick(GuiScreenEvent.ActionPerformedEvent.Post event) {
        if ((event.getGui() instanceof GuiInventory || event.getGui() instanceof GuiContainerCreative)) {
            if (event.getButton().id == 1000) {
                mc.displayGuiScreen(new CustomGui());
            } else if (event.getButton().id == 1001) {
                List<Skill> skills = MageSkills.getSkills();
                mc.displayGuiScreen(new SkillBookGui(MageSkills.getSkills()));
            }
        }
    }
}