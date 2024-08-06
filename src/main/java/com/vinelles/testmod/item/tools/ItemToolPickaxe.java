package com.vinelles.testmod.item.tools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemPickaxe;

public class ItemToolPickaxe extends ItemPickaxe {
    public ItemToolPickaxe(String name, ToolMaterial material) {
        super(material);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setCreativeTab(CreativeTabs.TOOLS);
    }
}
