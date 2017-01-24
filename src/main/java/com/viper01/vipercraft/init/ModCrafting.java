package com.viper01.vipercraft.init;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModCrafting {

	public static void registerCraftingRecipes() {
		// ITEMS
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.cracker), "WW", 'W', Items.WHEAT);
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.cheeseandcracker), "C", "K", 'C', ModItems.cheese, 'K', ModItems.cracker);
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.rockhammer), "II", " S", 'I', Items.IRON_INGOT, 'S', Items.STICK);
		// BLOCKS
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.cheese), "CCC", "CCC", "CCC", 'C', ModItems.cheese);
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.jar), " W ", "GGG", "GGG", 'W', new ItemStack(Blocks.PLANKS, 1, 0), 'G', new ItemStack(Blocks.STAINED_GLASS, 1, 0));
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.dairychurn), "ISW", "WSW", "WWW", 'W', new ItemStack(Blocks.PLANKS, 1, 0), 'S', new ItemStack(Items.STICK), 'I', new ItemStack(Items.IRON_INGOT));
		// TOOLS
		GameRegistry.addShapedRecipe(new ItemStack(ModTools.ItemToolNetherAxe), "NN ", "NB ", " BH", 'N', Blocks.NETHER_BRICK, 'B', Items.BLAZE_ROD, 'H', new ItemStack(ModItems.rockhammer.setContainerItem(ModItems.rockhammer)));
		GameRegistry.addShapedRecipe(new ItemStack(ModTools.ItemToolNetherHoe), "NN ", " B ", " BH", 'N', Blocks.NETHER_BRICK, 'B', Items.BLAZE_ROD, 'H', new ItemStack(ModItems.rockhammer.setContainerItem(ModItems.rockhammer)));
		GameRegistry.addShapedRecipe(new ItemStack(ModTools.ItemToolNetherPickaxe), "NNN", " B ", " BH", 'N', Blocks.NETHER_BRICK, 'B', Items.BLAZE_ROD, 'H', new ItemStack(ModItems.rockhammer.setContainerItem(ModItems.rockhammer)));
		GameRegistry.addShapedRecipe(new ItemStack(ModTools.ItemToolNetherShovel), " N ", " B ", " BH", 'N', Blocks.NETHER_BRICK, 'B', Items.BLAZE_ROD, 'H', new ItemStack(ModItems.rockhammer.setContainerItem(ModItems.rockhammer)));
		GameRegistry.addShapedRecipe(new ItemStack(ModTools.ItemToolNetherSword), " N ", " N ", " BH", 'N', Blocks.NETHER_BRICK, 'B', Items.BLAZE_ROD, 'H', new ItemStack(ModItems.rockhammer.setContainerItem(ModItems.rockhammer)));
	}

	public static void registerSmeltingRecipes() {
		GameRegistry.addSmelting(ModBlocks.veloreanore, new ItemStack(ModItems.veloreaningot), 0.7F);
		GameRegistry.addSmelting(ModItems.veloreandust, new ItemStack(ModItems.veloreaningot), 0.5F);
	}
}


