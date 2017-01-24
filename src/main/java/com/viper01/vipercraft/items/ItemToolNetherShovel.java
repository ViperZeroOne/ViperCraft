package com.viper01.vipercraft.items;

import com.viper01.vipercraft.Reference;
import com.viper01.vipercraft.ViperCraft;

import net.minecraft.item.ItemSpade;

public class ItemToolNetherShovel extends ItemSpade {
	
	public ItemToolNetherShovel(ToolMaterial material, String unlocalizedName) {
		super (material);
		setUnlocalizedName(Reference.VCItems.ITEMTOOLNETHERSHOVEL.getUnlocalizedName());
		setRegistryName(Reference.VCItems.ITEMTOOLNETHERSHOVEL.getRegistryName());
		// Adding the item to the ViperCraft tab for Creative Mode
		setCreativeTab(ViperCraft.CREATIVE_TAB);		
	}
}
