package com.vinelles.testmod.init;

import com.vinelles.testmod.enchantment.EnchantmentPoison;
import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class ModEnchantments {

    public static final Enchantment POISON = new EnchantmentPoison();

    @SubscribeEvent
    public static void registerEnchantments(RegistryEvent.Register<Enchantment> event) {
        event.getRegistry().register(POISON);
    }
   //public static void registerEnchantments() {

   //    ForgeRegistries.ENCHANTMENTS.register(new EnchantmentPoison());
   //}
}
