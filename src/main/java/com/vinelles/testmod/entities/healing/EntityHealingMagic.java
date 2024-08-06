package com.vinelles.testmod.entities.healing;


import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityHealingMagic extends EntityThrowable {

    // Три блока ниже - это конструкторы. На разные случаи жизни.
    public EntityHealingMagic(World world) {
        super(world);
    }

    public EntityHealingMagic(World world, EntityLivingBase thrower) {
        super(world, thrower);
    }

    public EntityHealingMagic(World world, double x, double y, double z) {
        super(world, x, y, z);
    }

    // Вызов различных событий (частицы, звуки), при попадении снаряда в цель (живое существо, блок)
    @Override
    @SideOnly(Side.CLIENT)
    public void handleStatusUpdate(byte id) {
        if (id == 3) {
            for (int i = 0; i < 8; ++i) {
                // Появляются частицы магии
                this.world.spawnParticle(EnumParticleTypes.CRIT_MAGIC, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
            }
        }
    }

    // Вызывается, когда предмет попадает в цель (живое существо, блок)
    @Override
    protected void onImpact(RayTraceResult result) {
        if (!this.world.isRemote) {
            if (result.typeOfHit == RayTraceResult.Type.BLOCK) {
                // Призыв EntityHealingZone на месте удара
                EntityHealingZone healingZone = new EntityHealingZone(this.world, result.hitVec.x, result.hitVec.y, result.hitVec.z);
                this.world.spawnEntity(healingZone);
            }

            // Отправка состояния сущности клиенту
            this.world.setEntityState(this, (byte)3);
            this.setDead();
        }
    }

    @Override
    public void onUpdate() {
        super.onUpdate();

        // Создание частиц для летящего снаряда
        for (int i = 0; i < 4; ++i) {
            this.world.spawnParticle(EnumParticleTypes.CRIT_MAGIC, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
        }
    }
}
