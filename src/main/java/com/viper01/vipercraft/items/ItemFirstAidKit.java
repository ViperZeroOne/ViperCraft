package com.viper01.vipercraft.items;

import com.viper01.vipercraft.Reference;
import com.viper01.vipercraft.ViperCraft;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemFirstAidKit extends Item {

	public ItemFirstAidKit() {

		// Pulling the VCItems variable information from the Reference.java package
		setUnlocalizedName(Reference.VCItems.FIRSTAIDKIT.getUnlocalizedName());
		setRegistryName(Reference.VCItems.FIRSTAIDKIT.getRegistryName());
		// Adding the item to the ViperCraft tab for Creative Mode
		setCreativeTab(ViperCraft.CREATIVE_TAB);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World world, EntityPlayer player, EnumHand hand) {
		if(player.getHealth() < player.getMaxHealth()) {
			player.heal(10);
			player.getHeldItem(hand).stackSize--;
		}
		return super.onItemRightClick(stack, world, player, hand);
	}
}