package com.minecraftplus.modQuartz;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemHoe;

import com.minecraftplus._base.registry.IconRegistry;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemHoeQuartz extends ItemHoe
{
	public ItemHoeQuartz(ToolMaterial par1ToolMaterial)
	{
		super(par1ToolMaterial);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister par1IIconRegister)
	{
		this.itemIcon = IconRegistry.add(par1IIconRegister, this);
	}
}
