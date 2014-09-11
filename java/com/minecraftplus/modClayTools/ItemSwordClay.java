package com.minecraftplus.modClayTools;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.IIcon;

import com.minecraftplus._base.registry.IconRegistry;
import com.minecraftplus._common.dye.Dyeable;
import com.minecraftplus._common.dye.IDyeable;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemSwordClay extends ItemSword implements IDyeable.Item
{
	@SideOnly(Side.CLIENT)
	private IIcon itemIcon1;

	public ItemSwordClay(ToolMaterial par1ToolMaterial)
	{
		super(par1ToolMaterial);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister par1IIconRegister)
	{
		this.itemIcon = IconRegistry.add(par1IIconRegister, this);
		this.itemIcon1 = IconRegistry.add(par1IIconRegister, this, ".overlay");
	}

	@SideOnly(Side.CLIENT)
	@Override
	public boolean requiresMultipleRenderPasses()
	{
		return true;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIconFromDamageForRenderPass(int par1, int par2)
	{
		return par2 == 1 ? this.itemIcon1 : super.getIconFromDamageForRenderPass(par1, par2);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public int getColorFromItemStack(ItemStack par1ItemStack, int par2)
	{
		return Dyeable.Item.getColorFromItemStack(par1ItemStack, par2 == 1 ? 2 : 1, 0xFFFFFF);
	}

	@Override
	public boolean hasColor(ItemStack par1ItemStack)
	{
		return Dyeable.Item.hasColor(par1ItemStack);
	}

	@Override
	public int getColor(ItemStack par1ItemStack)
	{
		return Dyeable.Item.getColor(par1ItemStack, 0xAFB9CE);
	}

	@Override
	public void setColor(ItemStack par1ItemStack, int par2)
	{
		Dyeable.Item.setColor(par1ItemStack, par2);
	}

	@Override
	public void removeColor(ItemStack par1ItemStack)
	{
		Dyeable.Item.removeColor(par1ItemStack);
	}
}
