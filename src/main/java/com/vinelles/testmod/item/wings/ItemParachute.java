package com.vinelles.testmod.item.wings;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class ItemParachute extends Item {

    public ItemParachute() {
        this.setMaxStackSize(1);
        this.setUnlocalizedName("parachute");
        this.setRegistryName("parachute");
        this.setCreativeTab(CreativeTabs.TRANSPORTATION);
        MinecraftForge.EVENT_BUS.register(this); // Регистрация событий
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        ItemStack itemStack = player.getHeldItem(hand);

        // Проверка, активирован ли парашют
        NBTTagCompound nbt = itemStack.getTagCompound();
        if (nbt == null) {
            nbt = new NBTTagCompound();
            itemStack.setTagCompound(nbt);
        }

        boolean isActive = nbt.getBoolean("isActive");
        nbt.setBoolean("isActive", !isActive); // Переключение состояния парашюта

        // Обновление рендера крыльев
        player.getEntityData().setBoolean("isParachuteActive", !isActive);

        return new ActionResult<>(EnumActionResult.SUCCESS, itemStack);
    }

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event) {
        EntityPlayer player = event.player;
        ItemStack itemStack = findParachute(player);

        if (itemStack != null && itemStack.hasTagCompound() && itemStack.getTagCompound().getBoolean("isActive")) {
            if (!player.isElytraFlying() && player.motionY < 0) {
                player.motionY /= 2; // Замедление падения
                player.fallDistance = 0; // Обнуление урона от падения

                // Добавление горизонтального движения
                if (player.moveForward > 0) {
                    player.motionX += -Math.sin(Math.toRadians(player.rotationYaw)) * 0.1;
                    player.motionZ += Math.cos(Math.toRadians(player.rotationYaw)) * 0.1;
                }
            }
        }
    }

    @SubscribeEvent
    public void onPlayerFall(LivingFallEvent event) {
        if (event.getEntityLiving() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.getEntityLiving();
            ItemStack itemStack = findParachute(player);

            if (itemStack != null && itemStack.hasTagCompound() && itemStack.getTagCompound().getBoolean("isActive")) {
                itemStack.getTagCompound().setBoolean("isActive", false); // Деактивация парашюта при приземлении
                player.getEntityData().setBoolean("isParachuteActive", false); // Обновление рендера крыльев
            }
        }
    }

    private ItemStack findParachute(EntityPlayer player) {
        for (ItemStack stack : player.inventory.mainInventory) {
            if (stack != null && stack.getItem() instanceof ItemParachute) {
                return stack;
            }
        }
        return null;
    }
}