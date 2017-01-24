package com.viper01.vipercraft.init;

import com.viper01.vipercraft.items.ItemCheese;
import com.viper01.vipercraft.items.ItemCheeseAndCracker;
import com.viper01.vipercraft.items.ItemCracker;
import com.viper01.vipercraft.items.ItemFirstAidKit;
import com.viper01.vipercraft.items.ItemRockhammer;
import com.viper01.vipercraft.items.ItemVeloreanDust;
import com.viper01.vipercraft.items.ItemVeloreanIngot;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {

	// Defining the items
	public static Item cheese;
	public static Item cracker;
	public static Item cheeseandcracker;
	public static Item veloreandust;
	public static Item veloreaningot;
	public static Item rockhammer;
	public static Item firstaidkit;
	
	public static void init() {
		
		// Links the item (example "cheese") to the items package (example "ItemCheese")
		// Don't forget to import the "ItemNAME()" after making it in the items package
		// The error on the item line will go away after the import is done
		
		cheese = new ItemCheese();
		cracker = new ItemCracker();
		cheeseandcracker = new ItemCheeseAndCracker();
		veloreandust = new ItemVeloreanDust();
		veloreaningot = new ItemVeloreanIngot();
		rockhammer = new ItemRockhammer();
		firstaidkit = new ItemFirstAidKit();
	}

	// Registers the item into the game
	public static void register() {
		GameRegistry.register(cheese);
		GameRegistry.register(cracker);
		GameRegistry.register(cheeseandcracker);
		GameRegistry.register(veloreandust);
		GameRegistry.register(veloreaningot);
		GameRegistry.register(rockhammer);
		GameRegistry.register(firstaidkit);
	}

	// Registers the rendering for each item
	public static void registerRenders() {
		registerRender(cheese);
		registerRender(cracker);
		registerRender(cheeseandcracker);
		registerRender(veloreandust);
		registerRender(veloreaningot);
		registerRender(rockhammer);
		registerRender(firstaidkit);
	}
	
	// Method for registering item object renders
	private static void registerRender(Item item) {
		// Calls a Minecraft model resource for rendering an Inventory item
	    Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
		//ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
}
