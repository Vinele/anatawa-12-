package com.vinelles.testmod.entities.ammo;


import com.vinelles.testmod.particles.ParticleLightning;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.List;

public class EntityAmmoBullet extends EntityThrowable {
    private int bounces = 5; // Максимальное количество отскоков
    private double speed = 1.0; // Текущая скорость
    private List<EntityLivingBase> hitEntities = new ArrayList<>(); // Список сущностей, по которым был произведен удар

    // Три блока ниже - это конструкторы. На разные случаи жизни.
    public EntityAmmoBullet(World world) {
        super(world);
    }

    public EntityAmmoBullet(World world, EntityLivingBase thrower) {
        super(world, thrower);
        // Спавним снаряд перед лицом игрока
        Vec3d look = thrower.getLookVec();
        this.setPosition(thrower.posX + look.x * 1.5, thrower.posY + thrower.getEyeHeight(), thrower.posZ + look.z * 1.5);
    }

    public EntityAmmoBullet(World world, double x, double y, double z) {
        super(world, x, y, z);
    }

    // Вызов различных событий (частицы, звуки), при попадении снаряда в цель (живое существо, блок)
    @Override
    @SideOnly(Side.CLIENT)
    public void handleStatusUpdate(byte id) {
        if (id == 3) {
            for (int i = 0; i < 8; ++i) {
                // Появляются частицы магии.
                spawnCustomParticle(this.posX, this.posY, this.posZ);
            }
        }
    }

    // Метод для спавна кастомных частиц
    @SideOnly(Side.CLIENT)
    private void spawnCustomParticle(double x, double y, double z) {
        Minecraft.getMinecraft().effectRenderer.addEffect(new ParticleLightning(this.world, x, y, z, 0.0D, 0.0D, 0.0D));

    }

    // Вызывается, когда предмет попадает в цель (живое существо, блок)
    @Override
    protected void onImpact(RayTraceResult result) {
        if (result.entityHit != null && result.entityHit != this.getThrower()) {
            // Проверяем, что цель - это другой entity
            int damage = 15;
            result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), (float) damage);

            // Добавляем цель в список ударенных сущностей
            hitEntities.add((EntityLivingBase) result.entityHit);

            // Отскок к следующей цели
            if (bounces > 0) {
                bounces--;
                EntityLivingBase currentTarget = (EntityLivingBase) result.entityHit;
                EntityLivingBase nextTarget = findNextTarget(currentTarget);
                if (nextTarget != null) {
                    bounceToTarget(nextTarget);
                } else {
                    this.setDead();
                }
            } else {
                this.setDead();
            }
        } else {
            this.setDead(); // Снаряд пропадает при попадании в блок
        }

        // Проверяем, что мир - "ВсёКромеКлиента", то-есть мир НЕ подключён к какому-либо серверу,
        // а значит сам является сервером. Имеется в виду ЛОГИЧЕСКИЙ сервер
        if (!this.world.isRemote) {
            // Отправляет пакет с "действием" нашего снаряда, где идентификатором выступает байт
            this.world.setEntityState(this, (byte) 3);
        }
    }

    private EntityLivingBase findNextTarget(EntityLivingBase currentTarget) {
        AxisAlignedBB aabb = new AxisAlignedBB(
                currentTarget.posX - 10, currentTarget.posY - 10, currentTarget.posZ - 10,
                currentTarget.posX + 10, currentTarget.posY + 10, currentTarget.posZ + 10);

        List<EntityLivingBase> entities = this.world.getEntitiesWithinAABB(EntityLivingBase.class, aabb);
        EntityLivingBase closestTarget = null;
        double closestDistance = Double.MAX_VALUE;

        for (EntityLivingBase entity : entities) {
            if (entity != currentTarget && entity != this.getThrower() && !entity.isDead && !hitEntities.contains(entity)) {
                double distance = entity.getDistanceSq(currentTarget);
                if (distance < closestDistance) {
                    closestDistance = distance;
                    closestTarget = entity;
                }
            }
        }
        return closestTarget;
    }

    private void bounceToTarget(EntityLivingBase target) {
        double dx = target.posX - this.posX;
        double dy = target.posY + (double) target.getEyeHeight() - this.posY;
        double dz = target.posZ - this.posZ;
        double distance = Math.sqrt(dx * dx + dy * dy + dz * dz);

        this.motionX = dx / distance * speed; // Используем параметр скорости
        this.motionY = dy / distance * speed;
        this.motionZ = dz / distance * speed;
    }

    @Override
    public void onUpdate() {
        super.onUpdate();

        if (this.ticksExisted < 2) {
            this.motionX *= 0.5; // Понижение скорости на первых тиках
            this.motionY *= 0.5;
            this.motionZ *= 0.5;
        }

        // Создание частиц для летящего снаряда
        for (int i = 0; i < 4; ++i) {
            spawnCustomParticle(this.posX, this.posY, this.posZ);
        }
    }

    @Override
    public void setDead() {
        super.setDead();
        // Очищаем список сущностей, по которым был произведен удар
        hitEntities.clear();
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}
