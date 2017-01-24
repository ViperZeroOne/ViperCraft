package com.viper01.vipercraft.items;

import com.viper01.vipercraft.Reference;
import com.viper01.vipercraft.ViperCraft;

import net.minecraft.item.ItemFood;

public class ItemCheese extends ItemFood {

	public ItemCheese() {

		// Setting the food value (1/2 food bar, cannot be fed to wolves)
		super(1, false);

		// Pulling the VCItems variable information from the Reference.java package
		setUnlocalizedName(Reference.VCItems.CHEESE.getUnlocalizedName());
		setRegistryName(Reference.VCItems.CHEESE.getRegistryName());
		// Adding the item to the ViperCraft tab for Creative Mode
		setCreativeTab(ViperCraft.CREATIVE_TAB);		
	}
}
