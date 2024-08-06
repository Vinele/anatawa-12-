package com.vinelles.testmod.handlers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import com.vinelles.testmod.item.armor.ItemMagicArmor;

public class ArmorEffectHandler {

    @SubscribeEvent
    public void onPlayerTick(LivingEvent.LivingUpdateEvent event) {
        if (event.getEntityLiving() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.getEntityLiving();

            boolean hasFullArmorSet = isWearingFullArmorSet(player);

            if (hasFullArmorSet) {
                applyEffects(player);
            } else {
                removeEffects(player);
            }
        }
    }

    private boolean isWearingFullArmorSet(EntityPlayer player) {
        return player.getItemStackFromSlot(EntityEquipmentSlot.HEAD).getItem() instanceof ItemMagicArmor &&
                player.getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem() instanceof ItemMagicArmor &&
                player.getItemStackFromSlot(EntityEquipmentSlot.LEGS).getItem() instanceof ItemMagicArmor &&
                player.getItemStackFromSlot(EntityEquipmentSlot.FEET).getItem() instanceof ItemMagicArmor;
    }

    private void applyEffects(EntityPlayer player) {
        player.addPotionEffect(new PotionEffect(MobEffects.SPEED, 20, 5, true, false));
        player.addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 20, 5, false, false));
    }

    private void removeEffects(EntityPlayer player) {
        player.removePotionEffect(MobEffects.SPEED);
    }
}
