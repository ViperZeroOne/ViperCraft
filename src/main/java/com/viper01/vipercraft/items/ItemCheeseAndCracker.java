package com.viper01.vipercraft.items;

import com.viper01.vipercraft.Reference;
import com.viper01.vipercraft.ViperCraft;

import net.minecraft.item.ItemFood;

public class ItemCheeseAndCracker extends ItemFood {

	public ItemCheeseAndCracker() {
		
		// Setting the food value (2 food bars, 0.4 saturation, cannot be fed to wolves)
		super(4, 0.4F, false);
		
		// Pulling the VCItems variable information from the Reference.java package
		setUnlocalizedName(Reference.VCItems.CHEESEANDCRACKER.getUnlocalizedName());
		setRegistryName(Reference.VCItems.CHEESEANDCRACKER.getRegistryName());
		// Adding the item to the ViperCraft tab for Creative Mode
		setCreativeTab(ViperCraft.CREATIVE_TAB);		
		}
}
