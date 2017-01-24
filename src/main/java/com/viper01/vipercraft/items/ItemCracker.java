package com.viper01.vipercraft.items;

import com.viper01.vipercraft.Reference;
import com.viper01.vipercraft.ViperCraft;

import net.minecraft.item.ItemFood;

public class ItemCracker extends ItemFood {
	
	public ItemCracker() {
		
		// Setting the food value (1/2 food bar, cannot be fed to wolves)
		super(1, false);

		// Pulling the VCItems variable information from the Reference.java package
		setUnlocalizedName(Reference.VCItems.CRACKER.getUnlocalizedName());
		setRegistryName(Reference.VCItems.CRACKER.getRegistryName());
		// Adding the item to the ViperCraft tab for Creative Mode
		setCreativeTab(ViperCraft.CREATIVE_TAB);		
	}
}
