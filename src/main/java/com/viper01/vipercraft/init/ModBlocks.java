package com.viper01.vipercraft.init;

import com.viper01.vipercraft.blocks.BlockCheese;
import com.viper01.vipercraft.blocks.BlockCookieJar;
import com.viper01.vipercraft.blocks.BlockDairyChurn;
import com.viper01.vipercraft.blocks.BlockJar;
import com.viper01.vipercraft.blocks.BlockVeloreanChest;
import com.viper01.vipercraft.blocks.BlockVeloreanOre;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks {
	
	// Defining the blocks
	public static Block cheese;
	public static Block jar;
	public static Block cookiejar;
	public static Block dairychurn;
	public static Block veloreanore;
	public static Block veloreanchest;

	public static void init() {
		
		// Links the block (example "cheese") to the blocks package (example "BlockCheese")
		// Don't forget to import the "ItemNAME()" after making it in the items package
		// The error on the item line will go away after the import is done
		
		cheese = new BlockCheese();
		jar = new BlockJar();
		cookiejar = new BlockCookieJar();
		dairychurn = new BlockDairyChurn();
		veloreanore = new BlockVeloreanOre();
		veloreanchest = new BlockVeloreanChest(Material.WOOD);
		
	}
	
	// Registers the block into the game
	public static void register() {
		registerBlock(cheese);
		registerBlock(jar);
		registerBlock(cookiejar);
		registerBlock(dairychurn);
		registerBlock(veloreanore);
		registerBlock(veloreanchest);
	}
	
	// Registers the block as an actual Block
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
		registerRender(cookiejar);
		registerRender(dairychurn);
		registerRender(veloreanore);
		registerRender(veloreanchest);
	}
	
	// Method for registering block object renders
	private static void registerRender(Block block) {
	
		// Calls a Minecraft model resource for rendering a BLOCK item
	    Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
	}

}
