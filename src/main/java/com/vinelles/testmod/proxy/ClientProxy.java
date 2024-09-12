package com.vinelles.testmod.proxy;

import com.vinelles.custom_inv.KeyHandler;
import com.vinelles.testmod.entities.EntityRoots;
import com.vinelles.testmod.entities.EntityTotem;
import com.vinelles.testmod.entities.ammo.EntityAmmoBullet;
import com.vinelles.testmod.entities.ammo.EntityFrostMagic;
import com.vinelles.testmod.entities.ammo.EntityNewBlizzard;
import com.vinelles.testmod.entities.healing.EntityHealingMagic;
import com.vinelles.testmod.entities.healing.EntityHealingZone;
import com.vinelles.testmod.entities.render.RenderRoots;

import com.vinelles.testmod.handlers.HudEventHandler;
import com.vinelles.testmod.handlers.OpenGuiEventHandler;
import com.vinelles.testmod.hud.AbilityHUD;
import com.vinelles.testmod.init.BlocksRegister;
import com.vinelles.testmod.init.ItemsRegistry;
import com.vinelles.testmod.init.KeybindsRegister;
import com.vinelles.testmod.layers.LayersRegister;
import com.vinelles.testmod.overlay.CastBarRenderer;
import com.vinelles.testmod.overlay.CustomMainMenu;
import com.vinelles.testmod.overlay.CustomMainMenuRenderer;
import com.vinelles.testmod.overlay.MainGameOverlay;
import com.vinelles.testmod.render.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import com.vinelles.testmod.entities.EntityTotem;
import com.vinelles.testmod.entities.render.RenderTotem;


public class ClientProxy extends CommonProxy
{
    @Override
    public void preInit(FMLPreInitializationEvent event)
    {
        super.preInit(event);
        //Регистрируем рендер, и в качестве 1-ого аргумента передаём класс нашего entity,
        //а в качестве второго - наш RenderFactory. Items.APPLE - предмет, с которого entity
        //возьмёт текстуру.
        RenderingRegistry.registerEntityRenderingHandler(EntityAmmoBullet.class, new SnowballRenderFactory(ItemsRegistry.AMMO));
        RenderingRegistry.registerEntityRenderingHandler(EntityFrostMagic.class, new SnowballRenderFactory(Items.NETHER_STAR));
        RenderingRegistry.registerEntityRenderingHandler(EntityNewBlizzard.class, new BlizzardFactory());

        RenderingRegistry.registerEntityRenderingHandler(EntityHealingMagic.class, new SnowballRenderFactory(Items.EMERALD));
        RenderingRegistry.registerEntityRenderingHandler(EntityHealingZone.class, new HealingFactory());

        RenderingRegistry.registerEntityRenderingHandler(EntityTotem.class, RenderTotem::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityRoots.class, RenderRoots::new);


        //для рендера ванильного предмета
        //RenderingRegistry.registerEntityRenderingHandler(EntityAmmoBullet.class, new SnowballRenderFactory(Items.APPLE));
    }

    @Override
    public void init(FMLInitializationEvent event)
    {
        super.init(event);
        BlocksRegister.registerRender();
        LayersRegister.register();
        KeybindsRegister.register();
        KeyHandler.register();

        //registerParticles();
    }

    @Override
    public void postInit(FMLPostInitializationEvent event)
    {
        super.postInit(event);
    }

    @Override
    public void registerRenderers() {
        MinecraftForge.EVENT_BUS.register(new OpenGuiEventHandler());
        MinecraftForge.EVENT_BUS.register(new MainGameOverlay(Minecraft.getMinecraft()));
        MinecraftForge.EVENT_BUS.register(new CustomMainMenuRenderer());
        MinecraftForge.EVENT_BUS.register(new CustomMainMenu());
        MinecraftForge.EVENT_BUS.register(new CastBarRenderer());
        MinecraftForge.EVENT_BUS.register(new AbilityHUD());


        MinecraftForge.EVENT_BUS.register(new HudEventHandler());
        //MinecraftForge.EVENT_BUS.register(new ClientEventHandler());

    }

    // В вашем клиентском прокси
    @SideOnly(Side.CLIENT)
    public void registerParticles() {
        Minecraft.getMinecraft().effectRenderer.registerParticle(0, new ParticleLightningFactory());
    }


}