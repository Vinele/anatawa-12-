package com.vinelles.testmod.entities.ammo;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityFrostMagic extends EntityThrowable {

    private int slownessDuration = 100; // Продолжительность замедления в тиках (5 секунд)
    private int slownessAmplifier = 4; // Уровень замедления
    private float damage = 4.0F; // Урон снаряда

    //Три блока ниже - это конструкторы. На разные случаи жизни.
    public EntityFrostMagic(World world) {
        super(world);
    }

    public EntityFrostMagic(World world, EntityLivingBase thrower) {
        super(world, thrower);
    }

    public EntityFrostMagic(World world, double x, double y, double z) {
        super(world, x, y, z);
    }

    //Вызов различных событий (частицы, звуки), при попадени снаряда в цель (живое существо, блок)
    @Override
    @SideOnly(Side.CLIENT)
    public void handleStatusUpdate(byte id) {
        if (id == 3) {
            for (int i = 0; i < 8; ++i) {
                //Появляются частицы лавы. В обычном майнкрафте они образуются на потолке, если сверху лава.
                this.world.spawnParticle(EnumParticleTypes.CRIT_MAGIC, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
            }
        }
    }

    //Вызывается, когда предмет попадает в цель (живое существо, блок)

    @Override
    protected void onImpact(RayTraceResult result) {
        if (!this.world.isRemote) {
            // Обработка удара по сущности
            if (result.entityHit != null && result.entityHit != this.getThrower()) {
                result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), damage);
                if (result.entityHit instanceof EntityLivingBase) {
                    EntityLivingBase entity = (EntityLivingBase) result.entityHit;
                    entity.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, slownessDuration, slownessAmplifier)); // Замедление
                }
            }

            // Спавним метель на месте удара
            EntityNewBlizzard blizzard = new EntityNewBlizzard(world, result.hitVec.x, result.hitVec.y, result.hitVec.z);
            this.world.spawnEntity(blizzard);

            // Отправка состояния сущности клиенту
            this.world.setEntityState(this, (byte)3);
        }
        this.setDead();
    }


    @Override
    public void onUpdate() {
        super.onUpdate();

        // Создание частиц для летящего снаряда
        for (int i = 0; i < 4; ++i) {
            this.world.spawnParticle(EnumParticleTypes.SNOWBALL, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
        }
    }

    public void setSlownessEffect(int duration, int amplifier) {
        this.slownessDuration = duration;
        this.slownessAmplifier = amplifier;
    }

    public void setDamage(float damage) {
        this.damage = damage;
    }
}
