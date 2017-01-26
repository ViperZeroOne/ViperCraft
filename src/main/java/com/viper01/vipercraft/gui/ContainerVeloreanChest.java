package com.viper01.vipercraft.gui;

import com.viper01.vipercraft.tileentity.TileEntityVeloreanChest;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;

public class ContainerVeloreanChest extends Container{

	private TileEntityVeloreanChest te;
	
	public ContainerVeloreanChest(IInventory playerInv, TileEntityVeloreanChest te){
		this.te = te;
		
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		return this.te.isUseableByPlayer(playerIn);
	}

}




