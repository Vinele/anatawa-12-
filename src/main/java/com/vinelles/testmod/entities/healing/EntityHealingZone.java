package com.vinelles.testmod.entities.healing;


import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;

import java.util.List;

public class EntityHealingZone extends Entity {
    private int duration = 100; // Продолжительность зоны в тиках (5 секунд)
    private int tickCounter = 0;
    private double radius = 5.0;
    private float heal = 5.0F;

    public EntityHealingZone(World worldIn) {
        super(worldIn);
        this.setSize(1.0F, 1.0F);
    }

    public EntityHealingZone(World worldIn, double x, double y, double z) {
        this(worldIn);
        this.setPosition(x, y, z);
    }

    @Override
    protected void entityInit() {
    }

    @Override
    protected void readEntityFromNBT(NBTTagCompound compound) {
        duration = compound.getInteger("Duration");
        tickCounter = compound.getInteger("TickCounter");
        radius = compound.getDouble("Radius");
    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound compound) {
        compound.setInteger("Duration", duration);
        compound.setInteger("TickCounter", tickCounter);
        compound.setDouble("Radius", radius);
    }

    @Override
    public void onUpdate() {
        super.onUpdate();

        tickCounter++;

        // Исцеление всем игрокам в радиусе каждую секунду
        if (!this.world.isRemote && tickCounter % 20 == 0) { // Каждые 20 тиков (1 секунда)
            List<EntityPlayer> nearbyPlayers = this.world.getEntitiesWithinAABB(EntityPlayer.class, new AxisAlignedBB(
                    posX - radius, posY - 1, posZ - radius, posX + radius, posY + 1, posZ + radius));
            for (EntityPlayer player : nearbyPlayers) {
                player.heal(heal); // Исцеление
            }
        }

        // Если зона длится дольше 5 секунд, отключаем её
        if (!this.world.isRemote && tickCounter >= duration) {
            this.setDead();
        }
    }

    public double getRadius() {
        return radius;
    }
}

