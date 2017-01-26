package com.viper01.vipercraft.tileentity.render;

import org.lwjgl.opengl.GL11;

import com.viper01.vipercraft.Reference;
import com.viper01.vipercraft.model.ModelVeloreanChest;
import com.viper01.vipercraft.tileentity.TileEntityVeloreanChest;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderVeloreanChest extends TileEntitySpecialRenderer<TileEntityVeloreanChest> {

	ResourceLocation texture = new ResourceLocation(Reference.MOD_ID + ":" + "textures/entities/veloreanchest.png");
	private ModelVeloreanChest model;
	
	public void TileEntityVeloreanChest() {
		model = new ModelVeloreanChest();
	}

	@Override
	public void renderTileEntityAt(TileEntityVeloreanChest te, double x, double y, double z, float partialTicks, int destroyStage) {
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
		GL11.glRotatef(180, 0F, 0F, 1F);
		bindTexture(texture);
		GL11.glPushMatrix();
		model.renderModel(0.0625F);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}
}
