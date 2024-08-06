package com.vinelles.testmod.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.potion.PotionEffect;

public class EnchantmentPoison extends Enchantment {

    public EnchantmentPoison() {
        super(Rarity.UNCOMMON, EnumEnchantmentType.WEAPON, new EntityEquipmentSlot[]{
                EntityEquipmentSlot.MAINHAND
        });
        this.setName("poison");
        this.setRegistryName("testmod", "poison");
    }

    @Override
    public int getMinLevel() {
        return 1;
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    public int getMinEnchantability(int enchantmentLevel) {
        return 10 + 20 * (enchantmentLevel - 1);
    }

    @Override
    public int getMaxEnchantability(int enchantmentLevel) {
        return this.getMinEnchantability(enchantmentLevel) + 50;
    }

    @Override
    public boolean isTreasureEnchantment() {
        return false;
    }

    @Override
    public boolean canApplyTogether(Enchantment ench) {
        return super.canApplyTogether(ench);
    }

    @Override
    public boolean canApplyAtEnchantingTable(net.minecraft.item.ItemStack stack) {
        return stack.getItem() instanceof net.minecraft.item.ItemSword || stack.getItem() instanceof net.minecraft.item.ItemTool;
    }

    @Override
    public void onEntityDamaged(EntityLivingBase user, Entity target, int level) {
        if (target instanceof EntityLivingBase) {
            ((EntityLivingBase) target).addPotionEffect(new PotionEffect(MobEffects.POISON, 100 * level, level - 1));
        }
    }
}
