package com.viper01.vipercraft.gui;

import com.viper01.vipercraft.tileentity.TileEntityVeloreanChest;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerVeloreanChest extends Container{

	private TileEntityVeloreanChest te;
	
	public ContainerVeloreanChest(IInventory playerInv, TileEntityVeloreanChest te){
		this.te = te;

		//Note:  Slots are 18 pixels tall and 18 pixels wide, thus all the 18's below
		
		//Tile Entity, Slot 0-8. Slot IDs 0-8
		//This outlines the inventory GUI of the CHEST with X and Y being the grid size
		//It will be modified depending on the CHEST's available inventory slots
		for(int y = 0; y < 12; ++y) {
			for(int x = 0; x < 9; ++x ) {
				// Below (x + y * #SLOTSWIDE)
				this.addSlotToContainer(new Slot(te, x + y * 9, 62 + x * 18, 17 + y * 18));
			}
		}
		
		//Player Inventory, Slot 9-35, Slot IDs 9-35
		//This outlines the player inventory, which appears below the chest inventory in the GUI
		//It should remain the same for ALL GUI interfaces
		for(int y=0; y < 3; ++y) {
			for(int x=0; x < 9; ++x) {
				this.addSlotToContainer(new Slot(playerInv, x + y * 9, 8 + x * 18, 84 + y * 18));
			}
		}
		
		//Player Inventory, Slot 0-8, Slot IDs 36-44
		//This outlines the player's quick slot inventory, which appears below the player inventory
		//It should remain the same for ALL GUI interfaces
		for (int x=0; x < 9 ; ++x){
			this.addSlotToContainer(new Slot(playerInv, x, 8 + x * 18, 142));
		}
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		return this.te.isUseableByPlayer(playerIn);
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int fromSlot) {
		ItemStack previous = null;
		Slot slot = (Slot)this.inventorySlots.get(fromSlot);

		if(slot != null && slot.getHasStack()) {
			ItemStack current = slot.getStack();
			previous = current.copy();
		
			if(fromSlot < 9) {
				if(!this.mergeItemStack(current, 9, 45, true))
					return null;
			} else {
				if(!this.mergeItemStack(current, 0, 9, false))
					return null;
			}
		
			if(current.stackSize == 0)
				slot.putStack((ItemStack)null);
			else
				slot.onSlotChanged();
			
			if(current.stackSize == previous.stackSize)
				return null;
			slot.onPickupFromSlot(playerIn, current);
		}
		
		return previous;
	}
}