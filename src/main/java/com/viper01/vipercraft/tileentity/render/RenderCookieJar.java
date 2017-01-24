package com.viper01.vipercraft.tileentity.render;

import com.viper01.vipercraft.tileentity.TileEntityCookieJar;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

// Calling the special render and linking it to the cookie jar (TileEntityCookieJar)
public class RenderCookieJar extends TileEntitySpecialRenderer<TileEntityCookieJar>{

	// Calling an item (cookie) to become a visual object (ITEM) which can be placed in theWorld
	private static final EntityItem ITEM = new EntityItem(Minecraft.getMinecraft().theWorld, 0, 0, 0, new ItemStack(Items.COOKIE));
	
	//Calling the override that will render the object in the world
	@Override
	public void renderTileEntityAt(TileEntityCookieJar te, double x, double y, double z, float partialTicks, int destroyStage) {
		super.renderTileEntityAt(te, x, y, z, partialTicks, destroyStage);
		
		// Begin the item hovering at a height of zero (on the cookie jar, linked above)
		ITEM.hoverStart = 0F;
		
		// Begin the special render on the client side
		GlStateManager.pushMatrix();
		{
			// Perform adjustments to the starting location of the cookie, to center it properly;
			// - Places the object at the location of the cookie jar
			GlStateManager.translate(x, y, z);
			// - Rotates the object 90 degrees so it's laying down in the cookie jar
			GlStateManager.rotate(90F, 1, 0, 0);
			// - Adjusts it's position so it's centered in the cookie jar
			GlStateManager.translate(0.5, 0.16, -0.05);
			// Begin a loop that will allow each cookie (up to 10) to appear in the cookie jar
			for(int i = 0; i < te.cookieCount; i++)
			{
				//Call for the rendering of the cookie in the cookie jar
				Minecraft.getMinecraft().getRenderManager().doRenderEntity(ITEM, 0, 0, 0, 0F, 0F, false);
				//Make a slight adjustment in the location of each consecutive cookie so they appear stacked in the cookie jar
				GlStateManager.translate(0, 0, -0.046);
				//Add a slight rotation so the stack doesn't look perfect
				GlStateManager.rotate(1, 0, 0, 1);
			}
		}
		// No idea what this does, although I believe it renders the removal of the cookie client-side
		GlStateManager.popMatrix();
	}
}
