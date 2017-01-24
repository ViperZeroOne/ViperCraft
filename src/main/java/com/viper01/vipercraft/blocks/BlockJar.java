package com.viper01.vipercraft.blocks;

import java.util.List;

import com.viper01.vipercraft.Reference;
import com.viper01.vipercraft.ViperCraft;
import com.viper01.vipercraft.init.ModItems;
import com.viper01.vipercraft.tileentity.TileEntityJar;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockJar extends Block implements ITileEntityProvider {

	// TO GET AXIS BOUNDING BOX
	// X Axis = East to West
	// Y Axis = Bottom to Top
	// Z Axis = South to North
	// 1 Pixel = 0.0625
	// Measurement = 0.0625 X #Pixels
	// Always Start Measurements at ZERO (East/Bottom/South)
	// xyz1 = South East Bottom Corner
	// xyz2 = North West Top Corner
	
	private static final AxisAlignedBB BOUNDING_BOX = new AxisAlignedBB(0.1875, 0, 0.1875, 0.8125, 0.625, 0.8125);
	
	public BlockJar() {
		super(Material.GLASS);
		setUnlocalizedName(Reference.VCBlocks.JAR.getUnlocalizedName());
		setRegistryName(Reference.VCBlocks.JAR.getRegistryName());
		setHardness(1.0F);
		setCreativeTab(ViperCraft.CREATIVE_TAB);
		setSoundType(blockSoundType.GLASS);
	}
	
	// Performs an override that lets Minecraft know this object isn't a full-size cube
	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}
	
	// Performs a visual override, letting Minecraft know the object isn't Opaque
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
		
    // Performs a visual override, activating translucent textures (glass)
	@Override
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.TRANSLUCENT;
	}
	
	// Activates the bounding box on the object and adjusts it to match the BOUNDING_BOX data above
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return BOUNDING_BOX;
	}
	
	// Activates collision detection based on the borders of the BOUNDING_BOX data above
	@Override
	public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, Entity entityIn) {
		super.addCollisionBoxToList(pos, entityBox, collidingBoxes, BOUNDING_BOX);
	}

	// Performs an override that lets Minecraft know this object CAN be activated by the player
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {		
		// Checks to see if the change needs to happen client/server side
		if(!worldIn.isRemote) {
			// Grabs the location of the activated object in the world
			TileEntity tileEntity = worldIn.getTileEntity(pos);
			// Makes sure the object detected is actually a jar
			if(tileEntity instanceof TileEntityJar) {
				// Assigns the jar to the tileEntity
				TileEntityJar jar = (TileEntityJar) tileEntity;
				if(heldItem != null) {
					if(heldItem.getItem() == ModItems.cracker) {
						// If the player is holding a cracker, attempt to add it to the jar
						if(jar.addCracker()) {
							// If a cracker is added to the jar, remove one cracker from your hand
							heldItem.stackSize--;
							// Return true only if a cracker was added to the jar
							return true;
						}
					}
				}
				// Should the player not be holding a cracker, or the jar be full, it will remove a cracker instead
				jar.removeCracker();	
			}
		}
		// Properly closing out the check for client/server side changes
		return true;
	}
	
	// Override so when a jar is placed it creates a unique identity for the jar
	// This prevents two jars from getting their contents mixed up
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityJar();
	}
}