package com.vinelles.testmod.item.wings;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class DemonWings extends Item {

    public DemonWings() {
        super();
        this.setUnlocalizedName("demon_wings");
        this.setRegistryName("demon_wings");
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onLivingUpdate(LivingUpdateEvent event) {
        if (event.getEntity() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.getEntity();
            ItemStack chestItem = player.getItemStackFromSlot(EntityEquipmentSlot.CHEST);
            if (chestItem != null && chestItem.getItem() instanceof DemonWings) {
                // Логика планирования
                if (player.motionY < 0 && !player.onGround) {
                    player.motionY *= 0.6; // Уменьшение скорости падения
                    player.fallDistance = 0; // Сброс дистанции падения
                }
            }
        }
    }
}