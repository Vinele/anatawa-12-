package com.vinelles.testmod;

import com.vinelles.testmod.entities.ModEntities;
import com.vinelles.testmod.entities.ammo.EntityAmmoBullet;
import com.vinelles.testmod.init.ItemsRegistry;
import com.vinelles.testmod.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import org.apache.logging.log4j.Logger;

import static com.mojang.realmsclient.gui.screens.RealmsLongConfirmationScreen.Type.Info;

@Mod(modid = TestMod.MODID, name = TestMod.NAME, version = TestMod.VERSION)
public class TestMod
{
    public static final String MODID = "testmod";
    public static final String NAME = "Test Mod";
    public static final String VERSION = "1.12.2-1.0";

    private static Logger logger;


    @SidedProxy(clientSide = "com.vinelles.testmod.proxy.ClientProxy", serverSide = "com.vinelles.testmod.proxy.CommonProxy")
    public static CommonProxy proxy;


    @Mod.Instance(TestMod.MODID)
    public static TestMod instance;

    public static final CreativeTabs CTAB = new CreativeTabs("testmod.moditems") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(ItemsRegistry.KEY);
        }
    };

    public static final CreativeTabs MODFOOD = new CreativeTabs("testmod.modfood") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(ItemsRegistry.COCONUT);
        }
    };


    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        proxy.preInit(event);
        ModEntities.registerEntities();

    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init(event);
        proxy.registerRenderers();

    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        proxy.postInit(event);
    }
    @Mod.EventHandler
    public void serverStarting(FMLServerStartingEvent event) {
        proxy.registerCommands(event);
    }

}
