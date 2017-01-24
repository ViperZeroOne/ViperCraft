package com.viper01.vipercraft.init;

import com.viper01.vipercraft.blocks.BlockCheese;
import com.viper01.vipercraft.blocks.BlockDairyChurn;
import com.viper01.vipercraft.blocks.BlockJar;
import com.viper01.vipercraft.blocks.BlockVeloreanOre;
import com.viper01.vipercraft.items.ItemCheese;
import com.viper01.vipercraft.items.ItemCracker;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks {
	
	// Defining the blocks
	public static Block cheese;
	public static Block jar;
	public static Block dairychurn;
	public static Block veloreanore;

	public static void init() {
		
		// Links the block (example "cheese") to the blocks package (example "BlockCheese")
		// Don't forget to import the "ItemNAME()" after making it in the items package
		// The error on the item line will go away after the import is done
		
		cheese = new BlockCheese();
		jar = new BlockJar();
		dairychurn = new BlockDairyChurn();
		veloreanore = new BlockVeloreanOre();
		
	}
	
	// Registers the block into the game
	public static void register() {
		registerBlock(cheese);
		registerBlock(jar);
		registerBlock(dairychurn);
		registerBlock(veloreanore);
	}
	

	private static void registerBlock(Block block) {
		GameRegistry.register(block);
		ItemBlock item = new ItemBlock(block);
		item.setRegistryName(block.getRegistryName());
		GameRegistry.register(item);
	}
	
	// Registers the rendering for each block
	public static void registerRenders() {
		registerRender(cheese);
		registerRender(jar);
		registerRender(dairychurn);
		registerRender(veloreanore);
	}
	
	// Method for registering block object renders
	private static void registerRender(Block block) {
	
		// Calls a Minecraft model resource for rendering a BLOCK item
	    Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
	}

}
