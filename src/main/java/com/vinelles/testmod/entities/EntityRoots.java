package com.vinelles.testmod.entities;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;

import java.util.List;

public class EntityRoots extends EntityLiving {
    private int duration = 200; // Продолжительность в тиках (10 секунд)
    private int tickCounter = 0;
    private EntityPlayer owner; // Игрок, который поставил тотем

    public EntityRoots(World worldIn) {
        super(worldIn);
        this.setSize(1.0F, 1.0F);
    }

    public EntityRoots(World worldIn, EntityPlayer owner, double x, double y, double z) {
        this(worldIn);
        this.setPosition(x, y, z);
        this.owner = owner;
    }

    @Override
    protected void entityInit() {
        super.entityInit();
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(1.0D);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound compound) {
        super.readEntityFromNBT(compound);
        duration = compound.getInteger("Duration");
        tickCounter = compound.getInteger("TickCounter");
        if (compound.hasUniqueId("OwnerUUID")) {
            this.owner = this.world.getPlayerEntityByUUID(compound.getUniqueId("OwnerUUID"));
        }
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound compound) {
        super.writeEntityToNBT(compound);
        compound.setInteger("Duration", duration);
        compound.setInteger("TickCounter", tickCounter);
        if (this.owner != null) {
            compound.setUniqueId("OwnerUUID", this.owner.getUniqueID());
        }
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        tickCounter++;

        if (this.world.isRemote) {
            spawnParticles();
        } else {
            applySlownessEffect();
            if (tickCounter >= duration) {
                this.setDead();
            }
        }
    }

    private void applySlownessEffect() {
        List<EntityLivingBase> entities = this.world.getEntitiesWithinAABB(EntityLivingBase.class, new AxisAlignedBB(
                this.posX - 10, this.posY - 10, this.posZ - 10,
                this.posX + 10, this.posY + 10, this.posZ + 10));
        for (EntityLivingBase entity : entities) {
            if (entity != this.owner) {
                entity.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 40, 1, true, true));
            }
        }
    }

    private void spawnParticles() {
        for (int i = 0; i < 1; ++i) {
            this.world.spawnParticle(EnumParticleTypes.FLAME, this.posX + (this.rand.nextDouble() - 0.5) * this.width, this.posY +1 + this.rand.nextDouble() * this.height, this.posZ + (this.rand.nextDouble() - 0.5) * this.width, 0.0, 0.1, 0.0);
        }
    }
}
