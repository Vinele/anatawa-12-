package com.vinelles.testmod.handlers;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;

public class PlayerStatusHandler {
    private static final int MAX_LEVEL = 50;
    private static final float BASE_HEALTH = 20.0F; // Базовое здоровье
    private static final float HEALTH_PER_LEVEL = 1.0F; // Дополнительное здоровье за уровень

    @SubscribeEvent
    public void onPlayerLevelChange(LivingEvent.LivingUpdateEvent event) {
        if (event.getEntity() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.getEntity();
            int playerLevel = player.experienceLevel;

            // Ограничиваем уровень игрока до 30
            if (playerLevel > MAX_LEVEL) {
                player.addExperienceLevel(MAX_LEVEL - playerLevel);
                player.sendMessage(new TextComponentString("§4§lТекущий максимальный уровень: " + MAX_LEVEL));
            }

            // Устанавливаем максимальное здоровье в зависимости от уровня
            float newMaxHealth = BASE_HEALTH + (Math.min(playerLevel, MAX_LEVEL) * HEALTH_PER_LEVEL);
            if (player.getMaxHealth() != newMaxHealth) {
                player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(newMaxHealth);
                player.setHealth(newMaxHealth); // Устанавливаем текущее здоровье на максимальное
            }
        }
    }
    @SubscribeEvent
    public void onPlayerLogin(PlayerLoggedInEvent event) {
        EntityPlayer player = event.player;
        int playerLevel = player.experienceLevel;

        // Устанавливаем максимальное здоровье в зависимости от уровня при входе в игру
        float newMaxHealth = BASE_HEALTH + (Math.min(playerLevel, MAX_LEVEL) * HEALTH_PER_LEVEL);
        player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(newMaxHealth);
        player.setHealth(newMaxHealth); // Устанавливаем текущее здоровье на максимальное
    }
}
