package com.vinelles.testmod.item.tools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemPickaxe;

public class ItemToolAxe extends ItemAxe {
    public ItemToolAxe(String name, ToolMaterial material) {
        // То что указано как 2, 2 это урон и скорость рубки. Можете задать свои значения, но лучше не оставлять данные поля пустыми.
        super(material, 2, 0.2F);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setCreativeTab(CreativeTabs.TOOLS);
    }
}
