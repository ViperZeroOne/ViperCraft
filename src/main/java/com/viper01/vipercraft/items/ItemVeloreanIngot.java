package com.viper01.vipercraft.items;

import com.viper01.vipercraft.Reference;
import com.viper01.vipercraft.ViperCraft;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;

public class ItemVeloreanIngot extends Item {

	public ItemVeloreanIngot() {

		// Pulling the VCItems variable information from the Reference.java package
		setUnlocalizedName(Reference.VCItems.VELOREANINGOT.getUnlocalizedName());
		setRegistryName(Reference.VCItems.VELOREANINGOT.getRegistryName());
		// Adding the item to the ViperCraft tab for Creative Mode
		setCreativeTab(ViperCraft.CREATIVE_TAB);		
	}
}
