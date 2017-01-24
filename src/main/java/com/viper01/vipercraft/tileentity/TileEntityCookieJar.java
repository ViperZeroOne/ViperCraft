package com.viper01.vipercraft.tileentity;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityCookieJar extends TileEntity {

	// When a jar is placed, initializes it with Zero cookies inside
	public int cookieCount = 0;
	
	// When the player tries to add a cookie;
	// - Checks to see if the data needs stored on the server/client
	// - Checks to see if the container is full (10 cookies)
	// - Adds a cookie to the container
	// - Marks the block as requiring an update
	// - Performs an update on the block so the visual change happens immediately
	public boolean addCookie() {
		if(!worldObj.isRemote) {
			if(cookieCount < 10) {
				cookieCount++;
				markDirty();
				IBlockState state = worldObj.getBlockState(pos);
				worldObj.notifyBlockUpdate(pos, state, state, 3);
				return true;
			}
		}
		return false;
	}

	
	// When the player tries to remove a cookie;
	// - Checks to see if the data needs stored on the server/client
	// - Checks to see if the container has cookies (more than 0)
	// - Spawns a cookie on the top of the cookie jar
	// - Removes a cookie from the jar's cookie count
	// - Marks the block as requiring an update
	// - Performs an update on the block so the visual change happens immediately
	public void removeCookie() {
		if(!worldObj.isRemote) {
			if(cookieCount > 0) {
				worldObj.spawnEntityInWorld(new EntityItem(worldObj, pos.getX() + 0.5, pos.getY() + 1.0, pos.getZ() + 0.5, new ItemStack(Items.COOKIE)));
				cookieCount--;
				markDirty();
				IBlockState state = worldObj.getBlockState(pos);
				worldObj.notifyBlockUpdate(pos, state, state, 3);
			}
		}
	}

	// The following overrides have to do with getting and writing information to the server/client in order
	// to properly label the jar (as there can be more than 1 in the world) and update the cracker count.
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		compound.setInteger("CookieCount", this.cookieCount);
		return compound;
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		this.cookieCount = compound.getInteger("CookieCount");
	}
	
	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) {
		NBTTagCompound tag = pkt.getNbtCompound();
		readUpdateTag(tag);
	}
	
	@Override
	public SPacketUpdateTileEntity getUpdatePacket() {
		NBTTagCompound tag = new NBTTagCompound();
		this.writeUpdateTag(tag);
		return new SPacketUpdateTileEntity(pos, getBlockMetadata(), tag);
	}
	
	@Override
	public NBTTagCompound getUpdateTag() {
		NBTTagCompound tag = super.getUpdateTag();
		writeUpdateTag(tag);
		return tag;
	}
	
	public void writeUpdateTag(NBTTagCompound tag) {
		tag.setInteger("CookieCount", this.cookieCount);
	}

	public void readUpdateTag(NBTTagCompound tag) {
		this.cookieCount = tag.getInteger("CookieCount");
	}
}

