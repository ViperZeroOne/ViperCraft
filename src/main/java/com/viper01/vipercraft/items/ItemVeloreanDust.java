package com.viper01.vipercraft.items;

import com.viper01.vipercraft.Reference;
import com.viper01.vipercraft.ViperCraft;

import net.minecraft.item.Item;

public class ItemVeloreanDust extends Item {

	public ItemVeloreanDust() {

		// Pulling the VCItems variable information from the Reference.java package
		setUnlocalizedName(Reference.VCItems.VELOREANDUST.getUnlocalizedName());
		setRegistryName(Reference.VCItems.VELOREANDUST.getRegistryName());
		// Adding the item to the ViperCraft tab for Creative Mode
		setCreativeTab(ViperCraft.CREATIVE_TAB);		
	}
}
