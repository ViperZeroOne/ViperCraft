package com.viper01.vipercraft.tileentity.render;

import com.viper01.vipercraft.tileentity.TileEntityVeloreanChest;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;

public class RenderVeloreanChest extends TileEntitySpecialRenderer<TileEntityVeloreanChest> {

	public void renderTileEntityAt(TileEntityVeloreanChest te, double x, double y, double z, float partialTicks, int destroyStage) {
		super.renderTileEntityAt(te, x, y, z, partialTicks, destroyStage);

		GlStateManager.pushMatrix();
		GlStateManager.popMatrix();

	}
}
