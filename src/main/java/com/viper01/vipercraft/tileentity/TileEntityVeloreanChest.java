package com.viper01.vipercraft.tileentity;

import com.viper01.vipercraft.Reference;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;

public class TileEntityVeloreanChest extends TileEntity implements IInventory {

	private ItemStack[] inventory;
	private String customName;
	
	// Sets up the array to check the inventory of the specific chest you're dealing with
	public TileEntityVeloreanChest() {
		this.inventory = new ItemStack[this.getSizeInventory()];		
	}
	
	// Gets the custom name of the specific chest you're dealing with
	public String getCustomName(){
		return this.customName;
	}
	
	// Sets the custom name for the specific chest you're dealing with
	public void setCustomName (String customName) {
		this.customName = customName;
	}
	
	// Gets the custom name of the chest based on the data from the main JAVA file's register tile entity line
	@Override
	public String getName() {
		return this.hasCustomName() ? this.customName : "container." + Reference.MOD_ID + "TileEntityVeloreanChest";
	}

	// Returns true if the chest has a name that is not blank or null
	@Override
	public boolean hasCustomName() {
		return this.customName != null && !this.customName.equals("");
	}
	
	// Gets the name that the chest GUI will display
	@Override
	public ITextComponent getDisplayName() {
		return this.hasCustomName() ? new TextComponentString(this.getName()) : new TextComponentTranslation(this.getName());
	}

	// The number of slots the chest actually has (examples 9, 18, etc)
	@Override
	public int getSizeInventory() {
		return 108;
	}

	// Chest slots start at 1 but index slots start at 0
	// This override checks the contents of the slots in the chest and enters that
	// information into an array called "inventory", but it only reads slot contents
	// if the variable "index" is within the number of slots the chest actually has.
	// As an example, it won't get info for slot 110 of a 108 slot chest.
	@Override
	public ItemStack getStackInSlot(int index) {
		if(index < 0 || index >= this.getSizeInventory()){
			return null;
		}
		return this.inventory[index];
	}

	// Sets up the process of removing an item from the chest via splitting, clicking, etc.
	// Forces an update when the contents of the chest changes.
	@Override
	public ItemStack decrStackSize(int index, int count) {
		if(this.getStackInSlot(index) != null) {
			ItemStack itemstack;
				if(this.getStackInSlot(index).stackSize <= count){
				itemstack = this.getStackInSlot(index);
				this.setInventorySlotContents(index, null);
				this.markDirty();
				return itemstack;
			} else {
				itemstack = this.getStackInSlot(index).splitStack(count);				
				if(this.getStackInSlot(index).stackSize <= 0) {
					this.setInventorySlotContents(index, null);
				} else {
					this.setInventorySlotContents(index, this.getStackInSlot(index));
				}
				this.markDirty();
				return itemstack;
			}
		} else {
			return null;
		}
	}

	// Sets up the process of removing an entire stack of items from the chest
	@Override
	public ItemStack removeStackFromSlot(int index) {
		ItemStack stack = this.getStackInSlot(index);
		// this next line deletes the stack in the chest once it's in your hand
		this.setInventorySlotContents(index, null);
		return stack;
	}

	// Sets the contents of the inventory slots and forces an update
	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
		if (index < 0 || index >= this.getSizeInventory())
			return;
		if (stack != null && stack.stackSize > this.getInventoryStackLimit())
			stack.stackSize = this.getInventoryStackLimit();
		if (stack != null && stack.stackSize == 0)
			stack = null;
		this.inventory[index] = stack;
		this.markDirty();
	}

	// This sets the limit of how many items a stack in the chest can hold (default 64)
	@Override
	public int getInventoryStackLimit() {
		return 128;
	}

	// Testing to see if the player is close enough to use the chest
	// Calculation is based on a squared area, thus 8 blocks away = 64 distance (8x8=64)
	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return this.worldObj.getTileEntity(this.getPos()) == this && player.getDistanceSq(this.pos.add(0.5, 0.5, 0.5)) <= 64;
	}

	// This is used as a trigger 
	// Some examples include a trap trigger (trapped chest) or an achievement for the first activation.
	// Left here for possible future usage
	@Override
	public void openInventory(EntityPlayer player) {
	}

	// This is used as a trigger
	// Some examples include a trap trigger (on close) or a sound effect (on close)
	// Left here for possible future usage
	@Override
	public void closeInventory(EntityPlayer player) {
	}

	// This is used to check if an item can be placed in a slot
	// For a chest it should always return true, machines will be more specific
	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		return true;
	}

	@Override
	public int getField(int id) {
		return 0;
	}

	@Override
	public void setField(int id, int value) {
		
	}

	@Override
	public int getFieldCount() {
		return 0;
	}

	// If we remove all the items from the chest
	@Override
	public void clear() {
		for(int i = 0; i < this.getSizeInventory(); i++) {
			this.setInventorySlotContents(i, null);
		}
	}

	// Saves the chest slot information so it's not lost
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		
		NBTTagList list = new NBTTagList();
		for(int i = 0; i < this.getSizeInventory(); ++i) {
			if(this.getStackInSlot(i) != null) {
				NBTTagCompound stackTag = new NBTTagCompound();
				stackTag.setByte("Slot", ((byte)i));
				this.getStackInSlot(i).writeToNBT(stackTag);
				list.appendTag(stackTag);
			}
		}
		nbt.setTag("Items", list);
		
		if(this.hasCustomName()) {
			nbt.setString("CustomName", this.getCustomName());
		}
	return nbt;
    }

	// Loads the chest slot information so it can be displayed
	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		
		NBTTagList list = nbt.getTagList("items", 10);
		for(int i = 0; i < list.tagCount(); ++i){
			NBTTagCompound stackTag = list.getCompoundTagAt(i);
			int slot = stackTag.getByte("Slot") & 255;
			this.setInventorySlotContents(slot, ItemStack.loadItemStackFromNBT(stackTag));
		}
		if(nbt.hasKey("CustomName", 8)){
			this.setCustomName(nbt.getString("CustomName"));
		}
	}
}
