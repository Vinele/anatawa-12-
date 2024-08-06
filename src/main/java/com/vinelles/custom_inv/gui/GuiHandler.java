package com.vinelles.custom_inv.gui;

import com.vinelles.custom_inv.ContainerCustomInv;
import com.vinelles.custom_inv.GUICustomInv;
import com.vinelles.custom_inv.capa.CAPCustomInventoryProvider;
import com.vinelles.custom_inv.capa.ICAPCustomInventory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

    public static final int INVENTORY_GUI_ID = 0;

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        //Обьект инвентаря храниться в КАПе, значит будем брать его из нее
        ICAPCustomInventory inv = player.getCapability(CAPCustomInventoryProvider.INVENTORY_CAP, null);
        if(ID == INVENTORY_GUI_ID) {
            return new ContainerCustomInv(player.inventory, inv.getInventory(), player);
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        //Обьект инвентаря храниться в КАПе, значит будем брать его из нее
        ICAPCustomInventory inv = player.getCapability(CAPCustomInventoryProvider.INVENTORY_CAP, null);
        if(ID == INVENTORY_GUI_ID) {
            return new GUICustomInv(player, player.inventory, inv.getInventory());
        }
        return null;
    }

}