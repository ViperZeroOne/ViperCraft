package com.viper01.vipercraft.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GUIVeloreanChest implements IGuiHandler{

	public static final int VELOREAN_CHEST_GUI = 0;
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == VELOREAN_CHEST_GUI)
			return new ContainerVeloreanChest();
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == VELOREAN_CHEST_GUI)
			return new GuiVeloreanChest();
		return null;
	}

}
