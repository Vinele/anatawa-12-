package com.vinelles.testmod.capabilities.mountRiding;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

import javax.annotation.Nullable;

public class MountRidingStorage implements Capability.IStorage<IMountRiding> {
    @Nullable
    @Override
    public NBTBase writeNBT(Capability<IMountRiding> capability, IMountRiding instance, EnumFacing enumFacing) {
        return new NBTTagInt(instance.get());
    }

    @Override
    public void readNBT(Capability<IMountRiding> capability, IMountRiding instance, EnumFacing enumFacing, NBTBase nbt) {
        instance.set(((NBTPrimitive) nbt).getInt());
    }
}
