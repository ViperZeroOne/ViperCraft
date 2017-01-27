package com.viper01.vipercraft.gui;

import com.viper01.vipercraft.Reference;
import com.viper01.vipercraft.tileentity.TileEntityVeloreanChest;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

public class GUIVeloreanChest extends GuiContainer{

	private IInventory playerInv;
	private TileEntityVeloreanChest te;
	
	public GUIVeloreanChest(IInventory playerInv, TileEntityVeloreanChest te) {
		super(new ContainerVeloreanChest(playerInv, te));
		
		this.playerInv = playerInv;
		this.te = te;
		
		// This is the overall size of the GUI
		// Default = x176 y166
		this.xSize = 176;
		this.ySize = 166;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(new ResourceLocation(Reference.MOD_ID + ":" + "textures/gui/container/veloreanchestgui.png"));
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		String s = this.te.getDisplayName()
	}

}
