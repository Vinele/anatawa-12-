package com.vinelles.testmod.item;

import com.vinelles.testmod.TestMod;
import com.vinelles.testmod.capabilities.mountRiding.IMountRiding;
import com.vinelles.testmod.capabilities.mountRiding.MountRidingProvider;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class ItemKey extends Item {


    public ItemKey() {
        this.setRegistryName("key");
        this.setUnlocalizedName("key");
        this.setCreativeTab(TestMod.CTAB);
        this.setMaxStackSize(100);
    }

    @Override
    public int getItemBurnTime(ItemStack itemStack) {
        return 200;
    }

    @Override
    public int getItemStackLimit(ItemStack stack) {
        return 100;
    }


    //@Override
    //public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
    //    ItemStack itemStack = player.getHeldItem(hand);
    //    if (!world.isRemote) {
    //
    //        IMountRiding ridingSkill = player.getCapability(MountRidingProvider.MOUNT_RIDING_CAP, null);
    //        ridingSkill.upgrade();
//
    //        player.sendMessage(new TextComponentString("Вы научились верховой езде!"));
    //        player.sendMessage(new TextComponentString("Текущий уровень: " + ridingSkill.get()));
//
    //        itemStack.shrink(1); // Уменьшаем количество предметов на 1
    //    }
//
    //    return new ActionResult<>(EnumActionResult.SUCCESS, itemStack);
    //}

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        ItemStack itemStack = player.getHeldItem(hand);
        if (!world.isRemote) {
            if(!player.getEntityData().getBoolean("isWingsActive"))
            player.getEntityData().setBoolean("isWingsActive", true);
            else
            player.getEntityData().setBoolean("isWingsActive", false);

            player.sendMessage(new TextComponentString("Текущий уровень: " + player.getEntityData().getBoolean("isWingsActive")));
        }

        return new ActionResult<>(EnumActionResult.SUCCESS, itemStack);
    }

}
