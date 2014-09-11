package com.minecraftplus.modSoulExtractor;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.minecraftplus._base.registry.PacketRegistry;
import com.minecraftplus._common.container.ContainerWithPlayerInventory;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ContainerSoulExtractor extends ContainerWithPlayerInventory
{
	public TileEntitySoulExtractor soulExtractor;
	private int lastExtractTime;

	public ContainerSoulExtractor(EntityPlayer par1EntityPlayer, TileEntitySoulExtractor par2TileEntitySoulExtractor)
	{
		super(par1EntityPlayer, par1EntityPlayer.inventory);
		this.soulExtractor = par2TileEntitySoulExtractor;
		this.addSlotToContainer(new SlotSoulExtractor(par2TileEntitySoulExtractor, 0, 52, 17, 0));
		this.addSlotToContainer(new SlotSoulExtractor(par2TileEntitySoulExtractor, 1, 28, 35, 1));
		this.addSlotToContainer(new SlotSoulExtractor(par2TileEntitySoulExtractor, 2, 52, 53, 2));
		this.addSlotToContainer(new SlotSoulExtractor(par2TileEntitySoulExtractor, 3, 120, 35, 3));
		this.addSlotPlayerMainInventory(0, 32 + 52);
		this.addSlotPlayerHotBar(0, 32 + 52);
	}

	@Override
	public void addCraftingToCrafters(ICrafting par1ICrafting)
	{
		super.addCraftingToCrafters(par1ICrafting);
		par1ICrafting.sendProgressBarUpdate(this, 0, this.soulExtractor.soulExtractTime);
	}

	@Override
	public void detectAndSendChanges()
	{
		super.detectAndSendChanges();

		for (int i = 0; i < this.crafters.size(); ++i)
		{
			ICrafting icrafting = (ICrafting) this.crafters.get(i);
			if (this.lastExtractTime != this.soulExtractor.soulExtractTime)
			{
				icrafting.sendProgressBarUpdate(this, 0, this.soulExtractor.soulExtractTime);
			}
		}

		this.lastExtractTime = this.soulExtractor.soulExtractTime;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void updateProgressBar(int par1, int par2)
	{
		if (par1 == 0)
		{
			this.soulExtractor.soulExtractTime = par2;
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer par1EntityPlayer)
	{
		return this.soulExtractor.isUseableByPlayer(par1EntityPlayer);
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
	{
		ItemStack itemstack = null;
		Slot slot = (Slot)this.inventorySlots.get(par2);

		if (slot != null && slot.getHasStack())
		{
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();

			if (par2 == 3)
			{
				if (!this.mergeItemStack(itemstack1, 4, 40, true))
				{
					return null;
				}

				slot.onSlotChange(itemstack1, itemstack);
			}
			else if (par2 != 2 && par2 != 1 && par2 != 0)
			{
				if (itemstack1.getItem() == Items.glass_bottle)
				{
					if (!this.mergeItemStack(itemstack1, 0, 1, false))
					{
						return null;
					}
				}
				else if (itemstack1.getItem() == Item.getItemFromBlock(Blocks.soul_sand))
				{
					if (!this.mergeItemStack(itemstack1, 1, 2, false))
					{
						return null;
					}
				}
				else if (itemstack1.getItem() == Items.ender_pearl)
				{
					if (!this.mergeItemStack(itemstack1, 2, 3, false))
					{
						return null;
					}
				}
				else if (par2 >= 4 && par2 < 31)
				{
					if (!this.mergeItemStack(itemstack1, 31, 40, false))
					{
						return null;
					}
				}
				else if (par2 >= 31 && par2 < 40 && !this.mergeItemStack(itemstack1, 4, 31, false))
				{
					return null;
				}
			}
			else if (!this.mergeItemStack(itemstack1, 4, 40, false))
			{
				return null;
			}

			if (itemstack1.stackSize == 0)
			{
				slot.putStack((ItemStack)null);
			}
			else
			{
				slot.onSlotChanged();
			}

			if (itemstack1.stackSize == itemstack.stackSize)
			{
				return null;
			}

			slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
		}

		return itemstack;
	}

	public void sendAbsorbSoulPacket(EntityPlayer par1EntityPlayer, int par2)
	{
		PacketRegistry.getPacketHandler().sendToServer(new PacketAbsorbSoul(par1EntityPlayer, par2));
	}
}
