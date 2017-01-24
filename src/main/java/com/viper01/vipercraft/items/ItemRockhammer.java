package com.viper01.vipercraft.items;

import com.viper01.vipercraft.Reference;
import com.viper01.vipercraft.ViperCraft;

import net.minecraft.item.Item;

public class ItemRockhammer extends Item {

	public ItemRockhammer() {

		// Pulling the VCItems variable information from the Reference.java package
		setUnlocalizedName(Reference.VCItems.ROCKHAMMER.getUnlocalizedName());
		setRegistryName(Reference.VCItems.ROCKHAMMER.getRegistryName());
		// Adding the item to the ViperCraft tab for Creative Mode
		setCreativeTab(ViperCraft.CREATIVE_TAB);		
	}
}
