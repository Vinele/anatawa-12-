package com.vinelles.testmod.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomCommand extends CommandBase {

    private static final Random RANDOM = new Random();

    @Override
    public String getName() {
        return "roll";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "/roll";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) {
        if (sender instanceof EntityPlayerMP) {
            EntityPlayerMP player = (EntityPlayerMP) sender;
            int roll = RANDOM.nextInt(126) - 50; // Случайное число от -50 до 75
            String message = player.getName() + " выкидывает число: " + roll;

            // Получаем всех игроков в радиусе 70 блоков
            List<EntityPlayerMP> nearbyPlayers = new ArrayList<>();
            for (EntityPlayerMP p : server.getPlayerList().getPlayers()) {
                if (p.getDistance(player) <= 70) {
                    nearbyPlayers.add(p);
                }
            }

            // Отправляем сообщение только игрокам в радиусе 70 блоков
            for (EntityPlayerMP nearbyPlayer : nearbyPlayers) {
                nearbyPlayer.sendMessage(new TextComponentString("§6" + message));
            }
        } else {
            sender.sendMessage(new TextComponentString("This command can only be run by a player."));
        }
    }

    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
        return true; // Все игроки могут использовать эту команду
    }
}