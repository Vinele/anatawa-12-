package com.vinelles.testmod.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;



public class CustomCommand extends CommandBase {




    @Override
    public String getName() {
        return "saymyname";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "/saymyname";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) {
        if (sender instanceof EntityPlayerMP) {
            EntityPlayerMP player = (EntityPlayerMP) sender;
            String playerName = player.getName();
            sender.sendMessage(new TextComponentString("Your name is: " + playerName));


        } else {
            sender.sendMessage(new TextComponentString("This command can only be run by a player."));
        }
    }

    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
        return true; // Поменяйте это на нужную проверку прав
    }
}
