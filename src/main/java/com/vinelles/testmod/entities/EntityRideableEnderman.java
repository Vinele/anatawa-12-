package com.vinelles.testmod.entities;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class EntityRideableEnderman extends EntityGiantZombie {

    public EntityRideableEnderman(World world) {
        super(world);
        //this.setSize(0.6F, 2.9F);
    }

    @Override
    public boolean processInteract(EntityPlayer player, EnumHand hand) {
        if (!this.world.isRemote && !player.isSneaking()) {
            player.startRiding(this);
        }
        return super.processInteract(player, hand);
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();


        if (this.isBeingRidden() && this.canBeSteered()) {
            EntityPlayer player = (EntityPlayer) this.getControllingPassenger();
            this.rotationYaw = player.rotationYaw;
            this.prevRotationYaw = this.rotationYaw;
            this.rotationPitch = player.rotationPitch * 0.5F;
            this.setRotation(this.rotationYaw, this.rotationPitch);
            this.jumpMovementFactor = this.getAIMoveSpeed() * 0.1F;

            this.moveRelative(player.moveStrafing, 0.0F, player.moveForward, 0.1F);
            this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);

            this.motionX *= 0.8D;
            this.motionZ *= 0.8D;

            if (player.isSneaking() && this.onGround) {
                this.motionY = 1.5D;
            }
        }
    }



    @Override
    public EntityPlayer getControllingPassenger() {
        if(this.getPassengers() != null && this.getPassengers().size() > 0 )
        {
            return (EntityPlayer) this.getPassengers().get(0);
        }
        else
            return null;
    }

    @Override
    public boolean canBeSteered() {
        return this.getControllingPassenger() instanceof EntityPlayer;
    }
}