package com.vinelles.testmod.handlers;

import com.vinelles.testmod.capabilities.mountRiding.IMountRiding;
import com.vinelles.testmod.capabilities.mountRiding.MountRidingProvider;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.TextComponentString;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Keyboard;

public class MountHandler {
    private EntityHorse spawnedHorse;

    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
        if (!Keyboard.isKeyDown(Keyboard.KEY_J)) {
            return;
        }


        Minecraft mc = Minecraft.getMinecraft();
        if (mc.player == null) {
            return;
        }

        EntityPlayer player = mc.player;
        IMountRiding ridingSkill = player.getCapability(MountRidingProvider.MOUNT_RIDING_CAP, null);


        if (ridingSkill == null || ridingSkill.get() < 1) {
            player.sendMessage(new TextComponentString("Вы не умеете ездить верхом." + ridingSkill.get()));
            return;
        }

        if (spawnedHorse == null || !spawnedHorse.isEntityAlive()) {
            // Призываем лошадь рядом с игроком
            spawnedHorse = new EntityHorse(mc.world);
            double x = player.posX;
            double y = player.posY;
            double z = player.posZ;
            spawnedHorse.setPosition(x, y, z);
            spawnedHorse.setHorseTamed(true);
            spawnedHorse.setOwnerUniqueId(player.getUniqueID());
            spawnedHorse.setHorseSaddled(true);

            // Добавляем седло
            ItemStack saddle = new ItemStack(Items.SADDLE);
            spawnedHorse.replaceItemInInventory(401, saddle);

            mc.world.spawnEntity(spawnedHorse);

            // Сажаем игрока на лошадь
            player.startRiding(spawnedHorse);

            player.sendMessage(new TextComponentString("Лошадь призвана и оседлана!"));
        } else {
            // Удаляем лошадь
            spawnedHorse.setDead();
            spawnedHorse = null;

            player.sendMessage(new TextComponentString("Лошадь удалена!"));
        }

        player.sendMessage(new TextComponentString("Текущий уровень верховой езды: " + ridingSkill.get()));
    }
}
