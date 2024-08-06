package com.vinelles.testmod.entities;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;

public class EntityAIRideableControl extends EntityAIBase {
    private final EntityCreature entity;
    private final float speed;

    public EntityAIRideableControl(EntityCreature entity, float speed) {
        this.entity = entity;
        this.speed = speed;
        this.setMutexBits(7); // Устанавливаем биты для управления задачами
    }

    @Override
    public boolean shouldExecute() {
        return this.entity.isBeingRidden() && this.entity.getControllingPassenger() instanceof EntityPlayer;
    }

    @Override
    public void updateTask() {
        EntityPlayer player = (EntityPlayer) this.entity.getControllingPassenger();
        this.entity.rotationYaw = player.rotationYaw;
        this.entity.rotationPitch = player.rotationPitch * 0.5F;
        this.entity.setAIMoveSpeed(speed);
    }
}