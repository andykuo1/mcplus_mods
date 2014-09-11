package com.minecraftplus.modFirePit;

import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ClientProxy extends CommonProxy
{
	@SideOnly(Side.CLIENT)
	@Override
	public void register()
	{
		super.register();

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFirePit.class, new RenderFirePit());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(MCP_FirePit.firePit), new RenderFirePit());
	}
}
