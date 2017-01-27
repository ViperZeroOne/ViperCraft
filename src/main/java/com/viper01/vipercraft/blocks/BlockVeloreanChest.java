package com.viper01.vipercraft.blocks;

import com.viper01.vipercraft.Reference;
import com.viper01.vipercraft.ViperCraft;
import com.viper01.vipercraft.gui.VeloreanChestGUIHandler;
import com.viper01.vipercraft.tileentity.TileEntityVeloreanChest;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockVeloreanChest extends BlockContainer {

    public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	
	public BlockVeloreanChest(Material materialIn) {
		super(materialIn);
		this.setUnlocalizedName(Reference.VCBlocks.VELOREANCHEST.getUnlocalizedName());
		this.setRegistryName(Reference.VCBlocks.VELOREANCHEST.getRegistryName());
		this.setHardness(1.0F);
		this.setHarvestLevel("pickaxe",0);
		this.setCreativeTab(ViperCraft.CREATIVE_TAB);
		this.setSoundType(SoundType.STONE);
		// Sets the default state of the block when placed to be facing North
		setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
	}
	
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, ItemStack helditem, EnumFacing side, float hitX, float hitY, float hitZ) {
		if(!worldIn.isRemote) {
			playerIn.openGui(Reference.MOD_ID + "GUIVeloreanChest", VeloreanChestGUIHandler.VELOREAN_CHEST_GUI, worldIn, pos.getX(), pos.getY(), pos.getZ());
		}
		return true;
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityVeloreanChest();
	}

	// Performs a visual override, letting Minecraft know the object isn't Opaque
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	
	public int getRenderType() {
		return -1;
	}

	
	// If the chest is "broken", drop the contents of the chest and then remove the chest
	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		TileEntityVeloreanChest te = (TileEntityVeloreanChest)worldIn.getTileEntity(pos);
		InventoryHelper.dropInventoryItems(worldIn, pos, te);
		super.breakBlock(worldIn, pos, state);
	}
	
	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase player, ItemStack stack) {
		if(stack.hasDisplayName()){
			((TileEntityVeloreanChest)worldIn.getTileEntity(pos)).setCustomName(stack.getDisplayName());
		}
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
}
