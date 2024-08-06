package com.vinelles.testmod.item.tools;

import com.vinelles.testmod.TestMod;
import com.vinelles.testmod.init.ItemsRegistry;
import com.vinelles.testmod.item.wings.DemonWings;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.HashMap;
import java.util.Map;

public class Azzinot extends Item {
    private static final int CAST_DURATION = 20; // 1 секунда (20 тиков)
    private static final int ELITRA_DELAY = 20; // 1 секунда (20 тиков)
    private int castProgress = 0;


    public static final DataParameter<Boolean> IS_WINGS_ACTIVE = EntityDataManager.createKey(EntityPlayer.class, DataSerializers.BOOLEAN);

    // Хранение времени, когда нужно надеть крылья
    private Map<EntityPlayer, Integer> elytraTimers = new HashMap<>();

    public Azzinot() {
        this.setUnlocalizedName("azzinot");
        this.setRegistryName("azzinot");
        this.setCreativeTab(TestMod.CTAB);
        this.maxStackSize = 1;
        MinecraftForge.EVENT_BUS.register(this);
    }



    @Override
    public void onUpdate(ItemStack stack, World world, Entity entity, int itemSlot, boolean isSelected) {
        if (isSelected && entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) entity;
            if (player.isHandActive() && player.getActiveItemStack() == stack) {
                castProgress++;
                if (castProgress >= CAST_DURATION) {
                    castSpell(player);
                    player.stopActiveHand();
                    castProgress = 0;
                }
            } else {
                castProgress = 0;
            }
        }
    }

    @Override
    public void onPlayerStoppedUsing(ItemStack stack, World world, EntityLivingBase entityLiving, int timeLeft) {
        castProgress = 0;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        player.setActiveHand(hand);
        return new ActionResult<>(EnumActionResult.SUCCESS, player.getHeldItem(hand));
    }

    private void castSpell(EntityPlayer player) {
        if (!player.world.isRemote) {
            // Поднятие игрока на 2 блоков
            player.addVelocity(0, 2, 0); // Поднимает игрока вверх на 2 блока
            player.velocityChanged = true;

            // Установка таймера для надевания крыльев
            elytraTimers.put(player, ELITRA_DELAY);

            // Установка кулдауна
            player.getCooldownTracker().setCooldown(this, 100);
            player.fallDistance = 0.0F;

            // Активировать парашют
            player.getEntityData().setBoolean("isParachuteActive", true);
            // Активировать крылья
            player.getEntityData().setBoolean("isWingsActive", true);
        }
    }

    @Override
    public int getMaxItemUseDuration(ItemStack stack) {
        return 72000;
    }

    @Override
    public EnumAction getItemUseAction(ItemStack stack) {
        return EnumAction.NONE;
    }

    public int getCastProgress() {
        return castProgress;
    }

    @SubscribeEvent
    public void onLivingUpdate(LivingEvent.LivingUpdateEvent event) {
        if (event.getEntity() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.getEntity();

            // Обработка таймера крыльев
            if (elytraTimers.containsKey(player)) {
                int timeLeft = elytraTimers.get(player) - 1;
                if (timeLeft <= 0) {
                    // Надевание крыльев
                    ItemStack demonicWings = new ItemStack(ItemsRegistry.WINGS);
                    player.setItemStackToSlot(EntityEquipmentSlot.CHEST, demonicWings);
                    elytraTimers.remove(player);

                    // Деактивировать парашют
                    player.getEntityData().setBoolean("isWingsActive", false);
                } else {
                    elytraTimers.put(player, timeLeft);
                }
            }

            // Проверка на то, находится ли игрок в полете
            if (player.isElytraFlying()) {
                // Игрок летит на крыльях, предотвращаем снятие крыльев
                ItemStack chestItem = player.getItemStackFromSlot(EntityEquipmentSlot.CHEST);
                if (chestItem.getItem() instanceof DemonWings) {
                    // Если игрок пытается снять крылья, удаляем их из инвентаря
                    if (!player.getItemStackFromSlot(EntityEquipmentSlot.CHEST).equals(chestItem)) {
                        player.setItemStackToSlot(EntityEquipmentSlot.CHEST, ItemStack.EMPTY);
                    }
                }
            } else if (player.onGround) {
                ItemStack chestItem = player.getItemStackFromSlot(EntityEquipmentSlot.CHEST);
                if (chestItem.getItem() instanceof DemonWings) {
                    // Снять крылья после приземления
                    player.setItemStackToSlot(EntityEquipmentSlot.CHEST, ItemStack.EMPTY);
                    removeDemonicWingsFromInventory(player);
                    // Деактивировать крылья
                    player.getEntityData().setBoolean("isWingsActive", false);
                }
            }
        }
    }

    private void removeDemonicWingsFromInventory(EntityPlayer player) {
        for (int i = 0; i < player.inventory.getSizeInventory(); i++) {
            ItemStack itemStack = player.inventory.getStackInSlot(i);
            if (itemStack.getItem() instanceof DemonWings) {
                player.inventory.setInventorySlotContents(i, ItemStack.EMPTY);
            }
        }
    }
}