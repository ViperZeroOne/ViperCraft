package com.viper01.vipercraft.blocks;

import java.util.List;

import com.viper01.vipercraft.Reference;
import com.viper01.vipercraft.ViperCraft;
import com.viper01.vipercraft.tileentity.TileEntityCookieJar;

import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCookieJar extends BlockHorizontal implements ITileEntityProvider {

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
	
	public BlockCookieJar() {
		super(Material.GLASS);
		setUnlocalizedName(Reference.VCBlocks.COOKIEJAR.getUnlocalizedName());
		setRegistryName(Reference.VCBlocks.COOKIEJAR.getRegistryName());
		setHardness(1.0F);
		setCreativeTab(ViperCraft.CREATIVE_TAB);
		setSoundType(SoundType.GLASS);
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
			// Makes sure the object detected is actually a cookie jar
			if(tileEntity instanceof TileEntityCookieJar) {
				// Assigns the cookiejar to the tileEntity
				TileEntityCookieJar cookiejar = (TileEntityCookieJar) tileEntity;
				if(heldItem != null) {
					if(heldItem.getItem() == Items.COOKIE) {
						// If the player is holding a cookie, attempt to add it to the jar
						if(cookiejar.addCookie()) {
							// If a cookie is added to the jar, remove one cookie from your hand
							heldItem.stackSize--;
							// Return true only if a cookie was added to the jar
							return true;
						}
					}
				}
				// Should the player not be holding a cracker, or the jar be full, it will remove a cracker instead
				cookiejar.removeCookie();	
			}
		}
		// Properly closing out the check for client/server side changes
		return true;
	}
	
	// Override so when a cookiejar is placed it creates a unique identity for the cookiejar
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityCookieJar();
	}
}