package com.vinelles.testmod.entities.ammo;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;

import java.util.List;

public class EntityNewBlizzard extends Entity {
    private int duration = 100; // Продолжительность метели в тиках (5 секунд)
    private int tickCounter = 0;
    private double radius = 5.0;

    public EntityNewBlizzard(World worldIn) {
        super(worldIn);
        this.setSize(1.0F, 1.0F);
    }

    public EntityNewBlizzard(World worldIn, double x, double y, double z) {
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

        // Нанесение урона всем сущностям в радиусе каждую секунду
        if (!this.world.isRemote && tickCounter % 20 == 0) { // Каждые 20 тиков (1 секунда)
            List<EntityLivingBase> nearbyEntities = this.world.getEntitiesWithinAABB(EntityLivingBase.class, new AxisAlignedBB(
                    posX - radius, posY - 1, posZ - radius, posX + radius, posY + 1, posZ + radius));
            for (EntityLivingBase entity : nearbyEntities) {
                entity.attackEntityFrom(DamageSource.MAGIC, 2.0F); // Урон магией
            }
        }

        // Если метель длится дольше 5 секунд, отключаем её
        if (!this.world.isRemote && tickCounter >= duration) {
            this.setDead();
        }
    }

    public double getRadius() {
        return radius;
    }
}
