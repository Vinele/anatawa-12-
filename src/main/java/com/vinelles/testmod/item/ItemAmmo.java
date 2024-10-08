package com.vinelles.testmod.item;

import com.vinelles.testmod.TestMod;
import com.vinelles.testmod.entities.EntityRoots;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemAmmo extends Item {
    public ItemAmmo() {
        this.setRegistryName("ammo");
        this.setUnlocalizedName("ammo");
        this.setCreativeTab(TestMod.CTAB);
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (!worldIn.isRemote) {
            ItemStack itemstack = player.getHeldItem(hand);
            EntityRoots roots = new EntityRoots(worldIn, player, pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5);
            worldIn.spawnEntity(roots);
            itemstack.shrink(1);
        }
        return EnumActionResult.SUCCESS;
    }
}
