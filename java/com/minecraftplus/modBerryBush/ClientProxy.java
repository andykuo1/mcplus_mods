package com.minecraftplus.modBerryBush;

import com.minecraftplus._base.registry.RenderRegistry;
import com.minecraftplus._client.RenderBlock;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ClientProxy extends CommonProxy
{
	public static final RenderBlock renderBerryBush = new RenderBlockBerryBush();

	@SideOnly(Side.CLIENT)
	@Override
	public void register()
	{
		super.register();
		RenderRegistry.addBlockRender(renderBerryBush);
	}
}
