package com.vinelles.testmod.init;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

public class CustomMaterials {
    public static final Item.ToolMaterial TOOL_MATERIAL =
            EnumHelper.addToolMaterial("test_tool_material", 2, 256, 20.0F, 10.0F, 12).setRepairItem(new ItemStack(Items.STICK));

    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL =
            EnumHelper.addArmorMaterial("testmod:orange", "testmod:orange", 100, new int[]{100, 100, 100, 100}, 1, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 99.0F)
                    .setRepairItem(new ItemStack(Item.getItemFromBlock(Blocks.OBSIDIAN)));
}
