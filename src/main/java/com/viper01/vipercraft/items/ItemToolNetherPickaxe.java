package com.viper01.vipercraft.items;

import com.viper01.vipercraft.Reference;
import com.viper01.vipercraft.ViperCraft;

import net.minecraft.item.ItemPickaxe;
import net.minecraft.util.ResourceLocation;

public class ItemToolNetherPickaxe extends ItemPickaxe {

	public ItemToolNetherPickaxe(ToolMaterial material, String unlocalizedName) {
		super(material);
		setUnlocalizedName(Reference.VCItems.ITEMTOOLNETHERPICKAXE.getUnlocalizedName());
		setRegistryName(Reference.VCItems.ITEMTOOLNETHERPICKAXE.getRegistryName());
		// Adding the item to the ViperCraft tab for Creative Mode
		setCreativeTab(ViperCraft.CREATIVE_TAB);		
	}
}
