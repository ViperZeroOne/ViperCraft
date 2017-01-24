package com.viper01.vipercraft;

import com.viper01.vipercraft.init.ModItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ViperTab extends CreativeTabs {

	public ViperTab() {
		super("ViperCraft");
	}

	@Override
	public Item getTabIconItem() {
		return ModItems.cheeseandcracker;
	}
}
