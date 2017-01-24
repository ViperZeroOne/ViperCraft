package com.viper01.vipercraft.init;

import com.viper01.vipercraft.items.ItemToolNetherAxe;
import com.viper01.vipercraft.items.ItemToolNetherHoe;
import com.viper01.vipercraft.items.ItemToolNetherPickaxe;
import com.viper01.vipercraft.items.ItemToolNetherShovel;
import com.viper01.vipercraft.items.ItemToolNetherSword;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;


public class ModTools {

	// Defining the items
	public static ItemPickaxe ItemToolNetherPickaxe;
	public static ItemToolNetherAxe ItemToolNetherAxe;
	public static ItemHoe ItemToolNetherHoe;
	public static ItemSpade ItemToolNetherShovel;
	public static ItemSword ItemToolNetherSword;

	// Creates the material to be used for the tool with the following properties;
	// (name, harvestLevel, maxUses, efficiency, damage, enchantability)
	public static final ToolMaterial netherMaterial = EnumHelper.addToolMaterial("netherMaterial", 3, 450, 5.0F, 3.0F, 12);
	
	public static void init() {
		
		// Links the tool (example "netheraxe") to the tools package (example "ItemModNetherAxe")
		// Also links the materials and textures to the tool
		// Don't forget to import the "ItemNAME()" after making it in the items package
		// The error on the item line will go away after the import is done
		
		ItemToolNetherPickaxe = new ItemToolNetherPickaxe(netherMaterial, "ItemToolNetherPickaxe");
		ItemToolNetherAxe = new ItemToolNetherAxe(netherMaterial, "ItemToolNetherAxe");
		ItemToolNetherHoe = new ItemToolNetherHoe(netherMaterial, "ItemToolNetherHoe");
		ItemToolNetherShovel = new ItemToolNetherShovel(netherMaterial, "ItemToolNetherShovel");
		ItemToolNetherSword = new ItemToolNetherSword(netherMaterial, "ItemToolNetherSword");
	}

		// Registers the tool into the game
		public static void register() {
			GameRegistry.register(ItemToolNetherPickaxe);
			GameRegistry.register(ItemToolNetherAxe);
			GameRegistry.register(ItemToolNetherHoe);
			GameRegistry.register(ItemToolNetherShovel);
			GameRegistry.register(ItemToolNetherSword);
		}

		// Registers the rendering for each tool
		public static void registerRenders() {
			registerRender(ItemToolNetherPickaxe);
			registerRender(ItemToolNetherAxe);
			registerRender(ItemToolNetherHoe);
			registerRender(ItemToolNetherShovel);
			registerRender(ItemToolNetherSword);
			
		}
		
		// Method for registering tool object renders
		private static void registerRender(Item item) {
			// Calls a Minecraft model resource for rendering a tool
		    Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
		}
	}
