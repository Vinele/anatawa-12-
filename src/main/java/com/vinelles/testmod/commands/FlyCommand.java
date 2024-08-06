package com.vinelles.testmod.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;

public class FlyCommand extends CommandBase {

    @Override
    public String getName() {
        return "flyup";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "/flyup";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) {
        if (sender instanceof EntityPlayerMP) {
            EntityPlayerMP player = (EntityPlayerMP) sender;
            player.setPositionAndUpdate(player.posX, player.posY + 50, player.posZ);
            sender.sendMessage(new TextComponentString("You have been flown up by 50 blocks."));
        } else {
            sender.sendMessage(new TextComponentString("This command can only be run by a player."));
        }
    }

    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
        return true; // Поменяйте это на нужную проверку прав
    }
}
