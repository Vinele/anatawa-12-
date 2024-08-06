package com.vinelles.custom_inv;

import javax.annotation.Nullable;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ContainerCustomInv  extends Container {

	//������� ���� �� ������
    private static final EntityEquipmentSlot[] VALID_EQUIPMENT_SLOTS = new EntityEquipmentSlot[] {EntityEquipmentSlot.HEAD, EntityEquipmentSlot.CHEST, EntityEquipmentSlot.LEGS, EntityEquipmentSlot.FEET};

    private final EntityPlayer thePlayer;
    
    /**
     * �����������
     * @param playerInventory ��������� ������
     * @param cInventory ��������� ���������
     * @param player �����
     */

    public ContainerCustomInv(InventoryPlayer playerInventory, CustomInventory cInventory, EntityPlayer player) {
        
        this.thePlayer = player;
        
        //��������� 8 ��������� ������. ���������: �����, ��������� � �������� ��� ���������, ������ �����, � ����������, � ����������
        this.addSlotToContainer(new StandartSlot(player, cInventory, 0, 87, 8));
        this.addSlotToContainer(new StandartSlot(player, cInventory, 1, 87, 26));
        this.addSlotToContainer(new StandartSlot(player, cInventory, 2, 87, 44));
        this.addSlotToContainer(new StandartSlot(player, cInventory, 3, 87, 62));
        this.addSlotToContainer(new StandartSlot(player, cInventory, 4, 109, 8));
        this.addSlotToContainer(new StandartSlot(player, cInventory, 5, 109, 26));
        this.addSlotToContainer(new StandartSlot(player, cInventory, 6, 109, 44));
        this.addSlotToContainer(new StandartSlot(player, cInventory, 7, 109, 62));
        this.addSlotToContainer(new StandartSlot(player, cInventory, 8, 109, 0));

        
      
        //��� ��� ���� ����� ����� �� net.minecraft.inventory.ContainerPlayer;
        //��������� ��������� ����� ��� �����
        for (int k = 0; k < 4; ++k){
        	
            final EntityEquipmentSlot entityequipmentslot = VALID_EQUIPMENT_SLOTS[k];
            this.addSlotToContainer(new Slot(playerInventory, 36 + (3 - k), 8, 8 + k * 18){

                public int getSlotStackLimit(){
                	
                    return 1;
                }

                public boolean isItemValid(ItemStack stack){
                	
                    return stack.getItem().isValidArmor(stack, entityequipmentslot, thePlayer);
                }
   
                public boolean canTakeStack(EntityPlayer playerIn){
                	
                    ItemStack itemstack = this.getStack();
                    return !itemstack.isEmpty() && !playerIn.isCreative() && EnchantmentHelper.hasBindingCurse(itemstack) ? false : super.canTakeStack(playerIn);
                }
                @Nullable
                @SideOnly(Side.CLIENT)
                public String getSlotTexture(){
                	
                    return ItemArmor.EMPTY_SLOT_NAMES[entityequipmentslot.getIndex()];
                }
            });
             
        }
        
        //��������� 27 ��������� ������ ��������� ������
        for (int l = 0; l < 3; ++l) {
        	
            for (int j1 = 0; j1 < 9; ++j1) {
                this.addSlotToContainer(new Slot(playerInventory, j1 + (l + 1) * 9, 8 + j1 * 18, 84 + l * 18));
            }
        }

        //� ��� �� ��������� 9 ��������� ������ � ������
        for (int i1 = 0; i1 < 9; ++i1) {
        	
            this.addSlotToContainer(new Slot(playerInventory, i1, 8 + i1 * 18, 142));
        }
        
    }
	
    /**
     * ���� ����� ����������� ����� ����� �������� ���� � ������� �� ���� � ����� ����������� �������.
     * ����� �� ������ ������ ������ � ���� ����� ������������ �������� �� ����� �� �������� ��������
     * @param index ������ �����, �� ������� ������� �����
     */
    @Nullable
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
    	
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = (Slot)this.inventorySlots.get(index);
        

        //���� ���� ���������� � �� �� ����
        if (slot != null && slot.getHasStack()){
        	
        	//������� ���� �� �����
            ItemStack itemstack1 = slot.getStack();
            
            itemstack = itemstack1.copy();
           
            //��������������
            //���� ������ ����� ������ 12, �.�. ����� ������� �� ��������� ���� ��� ���� �����
            if (index < 12){
            	
            	//�������� ����������� ���� � ������ ��������� ���� � ������� ��� ���������, �.�. ����� 12 � 47 ������
                if (!this.mergeItemStack(itemstack1, 12, 48, true)) {
                	
                    return ItemStack.EMPTY;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            
            //����� ��������. ���� ����� ������� �� ���� � ��������� ��� �������
            else if (index > 11){
            	
            	//���� ��� �����, �� �� ���� ����������� � ������ ���������� ��� ��� ���� ����� 8 � 11 ��������
            	if(itemstack1.getItem() instanceof ItemArmor){
            		
            		//��� ���� ������. ������ �������� 12 � �� 11? ������ ��� �� ������������. �.�. ����� 8 � 12 ������ �� ������������
            		if (!this.mergeItemStack(itemstack1, 8, 12, false)){
                        return ItemStack.EMPTY;
                    }
            		
            	}else 
            		//���� ��� �� ����� � �� � ��������� �� �� � �������(�.�. ����� 12 � 38 ������), �� �������� ������� � ������, �.�. ����� 39 � 47 ������
            		if (index >= 12 && index < 39){
            			
	                    if (!this.mergeItemStack(itemstack1, 39, 48, false)){
	                        return ItemStack.EMPTY;
	                    }
                }else 
                	//���� �� � �������(�.�. ����� 39 � 47 ������) �� �������� ����������� ������� � ���������(�.�. ����� � ������ ��������� ������ � ���������, �.�. ����� 12 � 38 ������)
                	if (index >= 39 && index < 48 && !this.mergeItemStack(itemstack1, 12, 39, false)){
                		return ItemStack.EMPTY;
                	}
            }        
           

            //��������� ������� ��������
            if (itemstack1.getCount() == 0){
                slot.putStack(ItemStack.EMPTY);
            }
            else{
                slot.onSlotChanged();
            }

            if (itemstack1.getCount() == itemstack.getCount()){
                return ItemStack.EMPTY;
            }

            slot.onTake(playerIn, itemstack1);
        }

        return itemstack;
    }
	
	/**
	 * ����� �� ����� ����������������� � ����������?
	 */
	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		
		return true;
	}

}
