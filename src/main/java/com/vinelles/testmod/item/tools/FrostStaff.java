package com.vinelles.testmod.item.tools;

import com.vinelles.testmod.TestMod;
import com.vinelles.testmod.entities.ammo.EntityFrostMagic;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class FrostStaff extends Item {
    public FrostStaff() {
        this.setRegistryName("frost_staff");
        this.setUnlocalizedName("frost_staff");
        this.setMaxStackSize(1);
        this.setCreativeTab(TestMod.CTAB);
        this.setMaxDamage(100);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        ItemStack itemStack = player.getHeldItem(hand);

        if (!world.isRemote) {
            // Стреляем снарядом
            Vec3d look = player.getLookVec();
            //EntityFrostStar snowball = new EntityFrostStar(world, player);

            EntityFrostMagic snowball = new EntityFrostMagic(world, player);

            snowball.setPosition(player.posX + look.x * 1.5, player.posY + player.getEyeHeight(), player.posZ + look.z * 1.5);
            snowball.shoot(player, player.rotationPitch, player.rotationYaw, 0.0F, 1.5F, 1.0F);

            world.spawnEntity(snowball);

            // Проигрываем звук выстрела
            world.playSound(null, player.posX, player.posY, player.posZ, SoundEvents.BLOCK_NOTE_GUITAR, SoundCategory.PLAYERS, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

            // Добавляем эффект замедления
            itemStack.damageItem(1, player);
        }

        player.swingArm(hand);
        return new ActionResult<>(EnumActionResult.SUCCESS, itemStack);
    }
}