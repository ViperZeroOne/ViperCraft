package com.viper01.vipercraft.blocks;

import com.viper01.vipercraft.Reference;
import com.viper01.vipercraft.ViperCraft;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockCheese extends Block {

	public BlockCheese() {
		super(Material.CAKE);
		setUnlocalizedName(Reference.VCBlocks.CHEESE.getUnlocalizedName());
		setRegistryName(Reference.VCBlocks.CHEESE.getRegistryName());
		setHardness(1.0F);
		setCreativeTab(ViperCraft.CREATIVE_TAB);
	}
}