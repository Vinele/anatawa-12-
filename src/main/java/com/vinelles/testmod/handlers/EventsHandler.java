package com.vinelles.testmod.handlers;

import com.vinelles.testmod.capabilities.mountRiding.IMountRiding;
import com.vinelles.testmod.capabilities.mountRiding.MountRidingProvider;
import com.vinelles.testmod.custom_gui.CustomGui;
import com.vinelles.testmod.entities.EntityRideableEnderman;
import com.vinelles.testmod.init.KeybindsRegister;
import com.vinelles.testmod.particle_effects.ParticleCircle;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.world.World;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import org.lwjgl.input.Keyboard;

public class EventsHandler {

    boolean check = false;

   /* @SubscribeEvent
    public void onJoin(EntityJoinWorldEvent e) {
        if (e.getEntity() instanceof EntityPlayer && !e.getWorld().isRemote) {
            EntityPlayer player = (EntityPlayer) e.getEntity();
             //player.sendMessage(new TextComponentString("Hello, %p!".replace("%p", player.getName())));

            player.sendMessage(new TextComponentString("§6§l Привет, " + player.getName() +
                    "! Этот мод был создан в рамках рекламной кампании сервера MineEmpire. " +
                    "Наш сервер будет основан на тематике World of Warcraft, и данный мод " +
                    "представляет собой лишь небольшую часть того грандиозного RPG-проекта, который мы готовим к запуску. " +
                    "Окунитесь в захватывающий мир MineEmpire и станьте частью нашего уникального проекта!")
                    .appendSibling(new TextComponentString("\n §8§b§l✦ Посетить проект §b✦§8"))
                    .setStyle(new Style().setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://vk.com/mineempire_rpg"))));
        }
    }

    */

    private static final String NBT_KEY_WELCOME_MESSAGE = "MineEmpireMod_WelcomeMessageShown";

    @SubscribeEvent
    public void onJoin(EntityJoinWorldEvent event) {
        if (event.getEntity() instanceof EntityPlayer && !event.getWorld().isRemote) {
            EntityPlayer player = (EntityPlayer) event.getEntity();
            NBTTagCompound playerData = player.getEntityData();
            NBTTagCompound persistedData;

            if (!playerData.hasKey(EntityPlayer.PERSISTED_NBT_TAG)) {
                persistedData = new NBTTagCompound();
                playerData.setTag(EntityPlayer.PERSISTED_NBT_TAG, persistedData);
            } else {
                persistedData = playerData.getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG);
            }

            // Проверяем, показывалось ли уже приветственное сообщение
            if (!persistedData.getBoolean(NBT_KEY_WELCOME_MESSAGE)) {
                // Отправляем приветственное сообщение
                player.sendMessage(new TextComponentString("§6§l Привет, " + player.getName() +
                        "! Этот мод был создан в рамках рекламной кампании сервера MineEmpire. " +
                        "Наш сервер будет основан на тематике World of Warcraft, и данный мод " +
                        "представляет собой лишь небольшую часть того грандиозного RPG-проекта, который мы готовим к запуску. " +
                        "Окунитесь в захватывающий мир MineEmpire и станьте частью нашего уникального проекта!")
                        .appendSibling(new TextComponentString("\n §8§b§l✦ Посетить проект §b✦§8")
                                .setStyle(new Style().setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://vk.com/mineempire_rpg")))));

                // Устанавливаем флаг, что сообщение было показано
                persistedData.setBoolean(NBT_KEY_WELCOME_MESSAGE, true);
            }
        }
    }

    @SubscribeEvent
    public void onLogout(PlayerEvent.PlayerLoggedOutEvent event) {
        EntityPlayer player = event.player;
        NBTTagCompound playerData = player.getEntityData();
        if (playerData.hasKey(EntityPlayer.PERSISTED_NBT_TAG)) {
            NBTTagCompound persistedData = playerData.getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG);
            // Сбрасываем флаг при выходе из мира
            persistedData.removeTag(NBT_KEY_WELCOME_MESSAGE);
        }
    }

    //@SubscribeEvent
    //public void onDifficultyChange(DifficultyChangeEvent event) {
    //    // Получаем сервер
    //    MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
    //    if (server != null) {
    //        // Получаем основной мир (Overworld)
    //        World overworld = server.getWorld(0);
    //        if (overworld != null) {
    //            // Проходимся по всем игрокам в основном мире
    //            for (EntityPlayer player : overworld.playerEntities) {
    //                // Создаем золотое яблоко
    //                ItemStack goldenApple = new ItemStack(Items.GOLDEN_APPLE, 1, 1);
    //                // Выбрасываем золотое яблоко рядом с игроком
    //                player.dropItem(goldenApple, false);
    //            }
    //        }
    //    }
    //}

    

    @SubscribeEvent
    public void onPlayerChat(ServerChatEvent event) {
        // Получаем оригинальное сообщение
        String originalMessage = event.getMessage();

        // Получаем ник игрока
        String playerName = event.getUsername();

        // Создаем новое сообщение с префиксом
        String newMessage = "§5§l[Warlock]§r " + playerName + ": " + originalMessage;

        // Устанавливаем новое сообщение
        event.setComponent(new TextComponentString(newMessage));

    }

    @SubscribeEvent
    public void onDeath(LivingDeathEvent e) {
        if (e.getEntity() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) e.getEntity();
            if(!check)
            {
                player.dropItem(new ItemStack(Items.GOLDEN_APPLE, 1, 1), false);
            }
            else
                e.setCanceled(true);
            //if (player.getName().equals("_Ivasik_"))

        }
    }


    private int jumpCounter = 0;

    @SubscribeEvent
    public void onPlayerJump(LivingEvent.LivingJumpEvent event) {
        if (event.getEntityLiving() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.getEntityLiving();
            World world = player.world;

            if (world.isRemote) {
                double radius = 2.0; // Радиус цилиндра
                int layers = 5; // Количество слоев
                int particleCount = 20; // Количество частиц в каждом слое

                if(jumpCounter > 10)
                    jumpCounter = 0;
                ParticleCircle.createCylinder(world, player.posX, player.posY+5, player.posZ, radius + jumpCounter, layers, particleCount, EnumParticleTypes.DRIP_WATER);
                // Создание цилиндра из частиц

            }
        }
    }

    @SubscribeEvent
    public void onPlayerFalls(LivingFallEvent event)
    {
        Entity entity = event.getEntity();

        if (entity.world.isRemote || !(entity instanceof EntityPlayerMP) || event.getDistance() < 3) return;

        EntityPlayer player = (EntityPlayer) entity;
        IMountRiding ridingSkill = player.getCapability(MountRidingProvider.MOUNT_RIDING_CAP, null);
        player.sendMessage(new TextComponentString("Уровень езды: " + ridingSkill.get()));


    }
    private static final String NBT_KEY_HORSE_RIDING_SKILL = "hasHorseRidingSkill";
    private EntityHorse spawnedHorse;

   // @SubscribeEvent
   // public void onKeyInput(InputEvent.KeyInputEvent event) {
   //     if (Keyboard.isKeyDown(Keyboard.KEY_J)) {
   //         Minecraft mc = Minecraft.getMinecraft();
   //         if (mc.player != null) {
   //             NBTTagCompound playerData = mc.player.getEntityData();
   //             NBTTagCompound persistedData;
   //             if (!playerData.hasKey(EntityPlayer.PERSISTED_NBT_TAG)) {
   //                 persistedData = new NBTTagCompound();
   //                 playerData.setTag(EntityPlayer.PERSISTED_NBT_TAG, persistedData);
   //             } else {
   //                 persistedData = playerData.getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG);
   //             }
   //             boolean hasRidingSkill = persistedData.getBoolean(NBT_KEY_HORSE_RIDING_SKILL);
   //             mc.player.sendMessage(new TextComponentString("Состояние умения верховой езды: " + hasRidingSkill));
//
   //             if (hasRidingSkill) {
   //                 if (spawnedHorse == null || !spawnedHorse.isEntityAlive()) {
   //                     // Призываем лошадь рядом с игроком
   //                     spawnedHorse = new EntityHorse(mc.world);
   //                     double x = mc.player.posX;
   //                     double y = mc.player.posY;
   //                     double z = mc.player.posZ;
   //                     spawnedHorse.setPosition(x, y, z);
   //                     spawnedHorse.setHorseTamed(true);
   //                     spawnedHorse.setOwnerUniqueId(mc.player.getUniqueID());
   //                     spawnedHorse.setHorseSaddled(true);
//
   //                     // Добавляем седло
   //                     ItemStack saddle = new ItemStack(Items.SADDLE);
   //                     spawnedHorse.replaceItemInInventory(401, saddle);
//
   //                     mc.world.spawnEntity(spawnedHorse);
//
   //                     // Сажаем игрока на лошадь
   //                     mc.player.startRiding(spawnedHorse);
//
   //                     mc.player.sendMessage(new TextComponentString("Лошадь призвана и оседлана!"));
   //                 } else {
   //                     // Удаляем лошадь
   //                     spawnedHorse.setDead();
   //                     spawnedHorse = null;
//
   //                     mc.player.sendMessage(new TextComponentString("Лошадь удалена!"));
   //                 }
   //             } else {
   //                 mc.player.sendMessage(new TextComponentString("Вы не умеете верховой езде."));
   //             }
   //         }
   //     }
   // }


    // private boolean checkGui = false;
    //
            // @SubscribeEvent
            // public void onKeyInput(InputEvent.KeyInputEvent event) {
        //     Minecraft mc = Minecraft.getMinecraft();
        //
        //     if (KeybindsRegister.KEY_GUI.isPressed() && !(mc.currentScreen instanceof CustomGui)) {
            //         mc.displayGuiScreen(new CustomGui()); // Открытие GUI
            //     }
        // }





    private EntityRideableEnderman spawnedEnderman;

    @SubscribeEvent
    public void onKeyInput2(InputEvent.KeyInputEvent event) {
        if (KeybindsRegister.KEY_MOUNT.isPressed()) {
            Minecraft mc = Minecraft.getMinecraft();
            if (mc.player != null) {
                if (spawnedEnderman == null || !spawnedEnderman.isEntityAlive()) {
                    // Призываем эндермена рядом с игроком
                    spawnedEnderman = new EntityRideableEnderman(mc.world);
                    double x = mc.player.posX;
                    double y = mc.player.posY;
                    double z = mc.player.posZ;
                    spawnedEnderman.setPosition(x, y, z); // Спавним эндермена рядом с игроком

                    mc.world.spawnEntity(spawnedEnderman);

                    // Сажаем игрока на эндермена
                    mc.player.startRiding(spawnedEnderman);

                    mc.player.sendMessage(new TextComponentString("Эндермен призван и оседлан!"));
                } else {
                    // Удаляем эндермена
                    spawnedEnderman.setDead();
                    spawnedEnderman = null;

                    mc.player.sendMessage(new TextComponentString("Эндермен удален!"));
                }
            }
        }
    }

    @SubscribeEvent
    public void onSendMessage(ClientChatEvent event) {
        EntityPlayerSP player = Minecraft.getMinecraft().player; // Получаем текущего игрока
        String originalMessage = event.getMessage(); // Получаем исходное сообщение

        if(originalMessage.equals("/apple") && !check)
        {
            check = true;
            player.sendMessage(new TextComponentString("apple"));
        }
        else if  (originalMessage.equals("/apple") && check)
        {
            check = false;
            player.sendMessage(new TextComponentString("not"));
        }
        // Отправляем сообщение обратно игроку
        //player.sendMessage(new TextComponentString(originalMessage));

    }


}