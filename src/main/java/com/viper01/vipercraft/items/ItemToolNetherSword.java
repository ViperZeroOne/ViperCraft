package com.viper01.vipercraft.items;

import com.viper01.vipercraft.Reference;
import com.viper01.vipercraft.ViperCraft;

import net.minecraft.item.ItemSword;
import net.minecraft.util.ResourceLocation;

public class ItemToolNetherSword extends ItemSword {

	public ItemToolNetherSword(ToolMaterial material, String unlocalizedName) {
		super(material);
		setUnlocalizedName(Reference.VCItems.ITEMTOOLNETHERSWORD.getUnlocalizedName());
		setRegistryName(Reference.VCItems.ITEMTOOLNETHERSWORD.getRegistryName());
		// Adding the item to the ViperCraft tab for Creative Mode
		setCreativeTab(ViperCraft.CREATIVE_TAB);		
		}

}