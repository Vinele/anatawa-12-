package com.vinelles.testmod.proxy;


import com.vinelles.custom_inv.capa.CAPCustomInventory;
import com.vinelles.custom_inv.capa.CAPCustomInventoryStorage;
import com.vinelles.custom_inv.capa.CapabilityEventHandler;
import com.vinelles.custom_inv.capa.ICAPCustomInventory;
import com.vinelles.custom_inv.gui.GuiHandler;
import com.vinelles.custom_inv.network.NetworkHandler;
import com.vinelles.testmod.TestMod;
import com.vinelles.testmod.capabilities.CapabilityHandler;
import com.vinelles.testmod.capabilities.mountRiding.IMountRiding;
import com.vinelles.testmod.capabilities.mountRiding.MountRiding;
import com.vinelles.testmod.capabilities.mountRiding.MountRidingStorage;
import com.vinelles.testmod.entities.EntityRoots;
import com.vinelles.testmod.entities.EntityTotem;
import com.vinelles.testmod.entities.ammo.EntityAmmoBullet;
import com.vinelles.testmod.entities.ammo.EntityFrostMagic;
import com.vinelles.testmod.entities.ammo.EntityNewBlizzard;
import com.vinelles.testmod.entities.healing.EntityHealingMagic;
import com.vinelles.testmod.entities.healing.EntityHealingZone;
import com.vinelles.testmod.handlers.ArmorEffectHandler;
import com.vinelles.testmod.handlers.EventsHandler;
import com.vinelles.testmod.handlers.MountHandler;
import com.vinelles.testmod.handlers.PlayerStatusHandler;
import com.vinelles.testmod.init.BlocksRegister;
import com.vinelles.testmod.init.CommandRegister;
import com.vinelles.testmod.init.ModEnchantments;
import com.vinelles.testmod.item.tools.Azzinot;
import com.vinelles.testmod.item.wings.ItemParachute;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class CommonProxy
{
    public void preInit(FMLPreInitializationEvent event)
    {
        BlocksRegister.register();

        MinecraftForge.EVENT_BUS.register(new EventsHandler());
        MinecraftForge.EVENT_BUS.register(new MountHandler());
        MinecraftForge.EVENT_BUS.register(new PlayerStatusHandler());
        MinecraftForge.EVENT_BUS.register(new CapabilityHandler());
        MinecraftForge.EVENT_BUS.register(new ArmorEffectHandler());
        MinecraftForge.EVENT_BUS.register(new Azzinot());


        EntityRegistry.registerModEntity(new ResourceLocation("testmod", "ammo_bullet"), EntityAmmoBullet.class, "testmod:ammo_bullet", 12, TestMod.instance, 64, 20, true);

        EntityRegistry.registerModEntity(new ResourceLocation("testmod", "frost_magic"), EntityFrostMagic.class, "testmod:frost_magic", 13, TestMod.instance, 64, 20, true);

        EntityRegistry.registerModEntity(new ResourceLocation("testmod", "blizzard"), EntityNewBlizzard.class, "testmod:blizzard", 14, TestMod.instance, 64, 20, true);


        EntityRegistry.registerModEntity(new ResourceLocation("testmod", "healmagic"), EntityHealingMagic.class, "testmod:healmagic", 15, TestMod.instance, 64, 20, true);
        EntityRegistry.registerModEntity(new ResourceLocation("testmod", "heal_zone"), EntityHealingZone.class, "testmod:heal_zone", 16, TestMod.instance, 64, 20, true);



        EntityRegistry.registerModEntity(new ResourceLocation("testmod:totem"), EntityTotem.class, "Totem", 17, TestMod.instance, 64, 1, true);
        EntityRegistry.registerModEntity(new ResourceLocation("testmod:roots"), EntityRoots.class, "Roots", 18, TestMod.instance, 64, 1, true);





        MinecraftForge.EVENT_BUS.register(ModEnchantments.class);


        CapabilityManager.INSTANCE.register(IMountRiding.class, new MountRidingStorage(), MountRiding.class);


    }

    public void init(FMLInitializationEvent event)
    {
        CapabilityManager.INSTANCE.register(ICAPCustomInventory.class, new CAPCustomInventoryStorage(), CAPCustomInventory.class);
        CapabilityEventHandler.register();
        NetworkHandler.init();
        NetworkRegistry.INSTANCE.registerGuiHandler(TestMod.instance, new GuiHandler());

    }

    public void postInit(FMLPostInitializationEvent event) {

    }

    public void registerRenderers() {
        // Пустая реализация для серверной стороны
    }

    public void registerCommands(FMLServerStartingEvent event) {
        CommandRegister.registerCommands(event);
    }



}