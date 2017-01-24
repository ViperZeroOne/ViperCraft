package com.viper01.vipercraft.proxy;

import com.viper01.vipercraft.init.ModBlocks;
import com.viper01.vipercraft.init.ModItems;
import com.viper01.vipercraft.init.ModTools;
import com.viper01.vipercraft.tileentity.TileEntityJar;
import com.viper01.vipercraft.tileentity.render.RenderJar;

import net.minecraftforge.fml.client.registry.ClientRegistry;

public class ClientProxy implements CommonProxy {

	@Override
	public void init() {
		
		// Registers the rendering of blocks and objects on the Client Side
		ModItems.registerRenders();
		ModBlocks.registerRenders();
		ModTools.registerRenders();
		
		// Registers the Special Rendering on the Client and links it to the renderer
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityJar.class, new RenderJar());
	}

}
