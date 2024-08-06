package com.vinelles.testmod.item.tools;


import com.vinelles.testmod.TestMod;
import com.vinelles.testmod.entities.ammo.EntityAmmoBullet;
import com.vinelles.testmod.item.ItemAmmo;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemTestStaff extends Item {
    public ItemTestStaff() {
        this.setRegistryName("test_staff");
        this.setUnlocalizedName("test_staff");
        this.setCreativeTab(TestMod.CTAB);
        this.setMaxStackSize(1);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        ItemStack itemStack = player.getHeldItem(hand);

        if (!world.isRemote) {
            // Проверка наличия патронов
            if (findAmmo(player)) {
                // Выстрел
                shoot(world, player);
                // Расход патрона
                consumeAmmo(player);
            }
        }

        return new ActionResult<>(EnumActionResult.SUCCESS, itemStack);
    }

    private boolean findAmmo(EntityPlayer player) {
        for (int i = 0; i < player.inventory.getSizeInventory(); ++i) {
            ItemStack itemstack = player.inventory.getStackInSlot(i);

            if (itemstack.getItem() instanceof ItemAmmo) {
                return true;
            }
        }

        return false;
    }

    private void consumeAmmo(EntityPlayer player) {
        for (int i = 0; i < player.inventory.getSizeInventory(); ++i) {
            ItemStack itemstack = player.inventory.getStackInSlot(i);

            if (itemstack.getItem() instanceof ItemAmmo) {
                itemstack.shrink(1);

                if (itemstack.isEmpty()) {
                    player.inventory.deleteStack(itemstack);
                }

                return;
            }
        }
    }

    private void shoot(World world, EntityPlayer player) {
        // Логика стрельбы
        EntityAmmoBullet bullet = new EntityAmmoBullet(world, player);
        bullet.shoot(player, player.rotationPitch, player.rotationYaw, 0.0F, 3.0F, 1.0F);
        world.spawnEntity(bullet);
    }
}
