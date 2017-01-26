package com.viper01.vipercraft;

import com.viper01.vipercraft.init.ModBlocks;
import com.viper01.vipercraft.init.ModCrafting;
import com.viper01.vipercraft.init.ModItems;
import com.viper01.vipercraft.init.ModTools;
import com.viper01.vipercraft.proxy.CommonProxy;
import com.viper01.vipercraft.tileentity.TileEntityCookieJar;
import com.viper01.vipercraft.tileentity.TileEntityJar;
import com.viper01.vipercraft.tileentity.TileEntityVeloreanChest;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION, acceptedMinecraftVersions = Reference.ACCEPTED_VERSIONS)
public class ViperCraft {

	@Instance
	public static ViperCraft instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	public static final CreativeTabs CREATIVE_TAB = new ViperTab();
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		System.out.println("Pre Init");
		
		// Initializing and registering our ModItems.java
		ModItems.init();
		ModItems.register();
		System.out.println("7 Items Registered!");

		// Initializing and registering our ModBlocks.java		
		ModBlocks.init();
		ModBlocks.register();
		System.out.println("5 Blocks Registered!");
		
		// Initializing and registering our ModTools.java
		ModTools.init();
		ModTools.register();
		System.out.println("5 Tools Registered!");
	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		System.out.println("Init");
		// Initializes the proxy and allows forge to choose client or server side
		proxy.init();
		ModCrafting.registerCraftingRecipes();
		System.out.println("12 Crafting Recipes Registered!");
		
		
		ModCrafting.registerSmeltingRecipes();
		System.out.println("2 Smelting Recipes Registered!");
		
		// Registers the TileEntity classes
		GameRegistry.registerTileEntity(TileEntityJar.class, Reference.MOD_ID + "TileEntityJar");
		GameRegistry.registerTileEntity(TileEntityCookieJar.class, Reference.MOD_ID + "TileEntityCookieJar");
		GameRegistry.registerTileEntity(TileEntityVeloreanChest.class, Reference.MOD_ID + "TileEntityVeloreanChest");
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		System.out.println("Post Init");
	}
 
}
