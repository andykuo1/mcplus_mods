package net.minecraftplus.mcp_blowpipe;

import net.minecraftplus._api.MCS;
import net.minecraftplus._api.base.Proxy;

public class _CommonProxy extends Proxy
{
	@Override
	public void Initialize()
	{
		MCS.entity(EntitySeeds.class, "Seeds");

		super.Initialize();
	}
}