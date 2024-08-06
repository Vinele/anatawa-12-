package com.vinelles.testmod.overlay;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class CustomMainMenuRenderer extends GuiMainMenu {

    private static final ResourceLocation CUSTOM_BACKGROUND = new ResourceLocation("testmod", "textures/gui/custom_gui.png");

    @SubscribeEvent
    public void onGuiOpen(GuiOpenEvent event) {
        if (event.getGui() instanceof GuiMainMenu) {
            event.setGui(new CustomMainMenuRenderer());
        }
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        Minecraft mc = Minecraft.getMinecraft();
        mc.getTextureManager().bindTexture(CUSTOM_BACKGROUND);
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glTexCoord2f(0, 0);
        GL11.glVertex2f(0, 0);
        GL11.glTexCoord2f(1, 0);
        GL11.glVertex2f(mc.displayWidth, 0);
        GL11.glTexCoord2f(1, 1);
        GL11.glVertex2f(mc.displayWidth, mc.displayHeight);
        GL11.glTexCoord2f(0, 1);
        GL11.glVertex2f(0, mc.displayHeight);
        GL11.glEnd();

        super.drawScreen(mouseX, mouseY, partialTicks);
    }
}
