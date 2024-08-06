package com.vinelles.testmod.commands;

import com.vinelles.testmod.inventory.ExpandedInventory;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;

public class CommandExpandInventory extends CommandBase {

    @Override
    public String getName() {
        return "expandinventory";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "/expandinventory";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        if (sender.getCommandSenderEntity() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) sender.getCommandSenderEntity();
            ExpandedInventory expandedInventory = new ExpandedInventory(54); // Пример с 54 слотами

            // Пример добавления предметов в расширенный инвентарь
            expandedInventory.setInventorySlotContents(0, player.getHeldItemMainhand());

            player.sendMessage(new TextComponentString("Your inventory has been expanded!"));
        } else {
            throw new CommandException("This command can only be used by a player!");
        }
    }
}
