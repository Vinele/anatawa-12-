package com.vinelles.testmod.init;

import com.vinelles.testmod.commands.CommandExpandInventory;
import com.vinelles.testmod.commands.CustomCommand;
import com.vinelles.testmod.commands.FlyCommand;
import com.vinelles.testmod.commands.RandomCommand;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

public class CommandRegister {

    public static void registerCommands(FMLServerStartingEvent event) {
        event.registerServerCommand(new CustomCommand());
        event.registerServerCommand(new FlyCommand());
        event.registerServerCommand(new CommandExpandInventory());
        event.registerServerCommand(new RandomCommand());
    }
}
