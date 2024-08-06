package com.vinelles.testmod.layers;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;

public class LayersRegister {
    public static void register() {
        setLayer(new LayerQuiver());
        setLayer(new LayerWings());

    }

    private static void setLayer(final LayerRenderer layer) {
        Minecraft.getMinecraft().getRenderManager().getSkinMap().get("default").addLayer(layer);
        Minecraft.getMinecraft().getRenderManager().getSkinMap().get("slim").addLayer(layer);
    }
}