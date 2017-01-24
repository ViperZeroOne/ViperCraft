package com.viper01.vipercraft.items;

import net.minecraft.util.ResourceLocation;

import com.viper01.vipercraft.Reference;
import com.viper01.vipercraft.ViperCraft;

import net.minecraft.item.ItemHoe;

public class ItemToolNetherHoe extends ItemHoe {
	
	public ItemToolNetherHoe(ToolMaterial material, String unlocalizedName) {
		super (material);
		setUnlocalizedName(Reference.VCItems.ITEMTOOLNETHERHOE.getUnlocalizedName());
		setRegistryName(Reference.VCItems.ITEMTOOLNETHERHOE.getRegistryName());
		// Adding the item to the ViperCraft tab for Creative Mode
		setCreativeTab(ViperCraft.CREATIVE_TAB);		
	}

}
