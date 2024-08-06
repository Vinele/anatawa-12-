package com.vinelles.testmod.capabilities.mountRiding;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class MountRidingProvider implements ICapabilitySerializable<NBTBase> {

    @CapabilityInject(IMountRiding.class)
    public static final Capability<IMountRiding> MOUNT_RIDING_CAP = null;

    private IMountRiding instance = MOUNT_RIDING_CAP.getDefaultInstance();

    @Override
    public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable EnumFacing enumFacing) {
        return capability == MOUNT_RIDING_CAP;
    }

    @Nullable
    @Override
    public <T> T getCapability(@Nonnull Capability<T> capability, @Nullable EnumFacing enumFacing) {
        return capability == MOUNT_RIDING_CAP ? MOUNT_RIDING_CAP.<T> cast(this.instance) : null;
    }

    @Override
    public NBTBase serializeNBT() {
        return MOUNT_RIDING_CAP.getStorage().writeNBT(MOUNT_RIDING_CAP, this.instance, null);
    }

    @Override
    public void deserializeNBT(NBTBase nbt) {
        MOUNT_RIDING_CAP.getStorage().readNBT(MOUNT_RIDING_CAP, this.instance, null, nbt);
    }
}
