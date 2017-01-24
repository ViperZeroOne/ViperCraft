package com.viper01.vipercraft.blocks;

import java.util.List;

import com.viper01.vipercraft.Reference;
import com.viper01.vipercraft.ViperCraft;

import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

// Extending the BlockHorizontal indicates this block can face directions other than North
public class BlockDairyChurn extends BlockHorizontal 
{
	// TO GET AXIS BOUNDING BOX
	// X Axis = East to West
	// Y Axis = Bottom to Top
	// Z Axis = South to North
	// 1 Pixel = 0.0625
	// Measurement = 0.0625 X #Pixels
	// Always Start Measurements at ZERO (East/Bottom/South)
	// xyz1 = South East Bottom Corner
	// xyz2 = North West Top Corner
	
	private static final AxisAlignedBB BOUNDING_BOX = new AxisAlignedBB(0.1875, 0, 0.1875, 0.8125, 1, 0.8125);
	
	public BlockDairyChurn() {
		super(Material.ANVIL);
		setUnlocalizedName(Reference.VCBlocks.DAIRYCHURN.getUnlocalizedName());
		setRegistryName(Reference.VCBlocks.DAIRYCHURN.getRegistryName());
		setHardness(1.0F);
		setCreativeTab(ViperCraft.CREATIVE_TAB);
		// Sets the default state of the block when placed to be facing North
		setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
	}

	// When the block is placed in the world it gets the facing direction of the placer (player)
	@SuppressWarnings("deprecation")
	@Override
	public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
		IBlockState state = super.onBlockPlaced(worldIn, pos, facing, hitX, hitY, hitZ, meta, placer);
	    return state.withProperty(FACING, placer.getHorizontalFacing());
	}
	
	// The following three overrides create the block in the world and face it the proper direction
	// This direction is based on the compass direction the player was facing when they placed the block
	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(FACING).getHorizontalIndex();
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return getDefaultState().withProperty(FACING, EnumFacing.getHorizontal(meta));
	}
	
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, FACING);
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
	
}
