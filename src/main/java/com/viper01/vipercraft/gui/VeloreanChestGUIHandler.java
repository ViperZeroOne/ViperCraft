package com.viper01.vipercraft.gui;

import com.viper01.vipercraft.tileentity.TileEntityVeloreanChest;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class VeloreanChestGUIHandler implements IGuiHandler{

	public static final int VELOREAN_CHEST_GUI = 0;
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == VELOREAN_CHEST_GUI)
			return new ContainerVeloreanChest(player.inventory, ((TileEntityVeloreanChest)world.getTileEntity(new BlockPos(x, y, z))));
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == VELOREAN_CHEST_GUI)
			return new GuiVeloreanChest();
		return null;
	}

}