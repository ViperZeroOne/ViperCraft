package com.viper01.vipercraft.blocks;

import com.viper01.vipercraft.Reference;
import com.viper01.vipercraft.ViperCraft;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockVeloreanOre extends Block {

	public BlockVeloreanOre() {
		super(Material.ROCK);
		setUnlocalizedName(Reference.VCBlocks.VELOREANORE.getUnlocalizedName());
		setRegistryName(Reference.VCBlocks.VELOREANORE.getRegistryName());
		setHardness(1.0F);
		setCreativeTab(ViperCraft.CREATIVE_TAB);
	}
}