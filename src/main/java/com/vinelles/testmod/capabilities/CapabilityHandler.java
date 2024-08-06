package com.vinelles.testmod.capabilities;

import com.vinelles.testmod.TestMod;
import com.vinelles.testmod.capabilities.mountRiding.IMountRiding;
import com.vinelles.testmod.capabilities.mountRiding.MountRidingProvider;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CapabilityHandler {
    public static final ResourceLocation MOUNT_RIDING_CAP = new ResourceLocation(TestMod.MODID, "mount_riding");

    @SubscribeEvent
    public void attachCapability(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof EntityPlayer) {
            event.addCapability(MOUNT_RIDING_CAP, new MountRidingProvider());
        }
    }



    @SubscribeEvent
    public static void playerClone(PlayerEvent.Clone event) {
        if (event.isWasDeath()) {
            IMountRiding original = event.getOriginal().getCapability(MountRidingProvider.MOUNT_RIDING_CAP, null);
            IMountRiding clone = event.getEntityPlayer().getCapability(MountRidingProvider.MOUNT_RIDING_CAP, null);
            if (original != null && clone != null) {
                clone.set(original.get());
            }
        }
    }
}
