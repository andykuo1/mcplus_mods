package net.minecraftplus._api;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.ModContainer;
import net.minecraftplus._api.base._Mod;
import net.minecraftplus._api.dictionary.Assets;
import net.minecraftplus._api.factory.writer.ResourceWriter;
import net.minecraftplus.mcp_api._API;
import net.minecraftplus.mcp_bamboo._Bamboo;
import net.minecraftplus.mcp_battle_hearts._Battle_Hearts;
import net.minecraftplus.mcp_beetroot._Beetroot;
import net.minecraftplus.mcp_blowpipe._Blowpipe;
import net.minecraftplus.mcp_clay_tools._Clay_Tools;
import net.minecraftplus.mcp_clippers._Clippers;
import net.minecraftplus.mcp_cocoa._Cocoa;
import net.minecraftplus.mcp_collision._Collision;
import net.minecraftplus.mcp_fossil._Fossil;
import net.minecraftplus.mcp_gems._Gems;
import net.minecraftplus.mcp_gift_box._Gift_Box;
import net.minecraftplus.mcp_glowing_slime._Glowing_Slime;
import net.minecraftplus.mcp_ice_box._Ice_Box;
import net.minecraftplus.mcp_loom._Loom;
import net.minecraftplus.mcp_loose_stone._Loose_Stone;
import net.minecraftplus.mcp_lumber._Lumber;
import net.minecraftplus.mcp_overgrowth._Overgrowth;
import net.minecraftplus.mcp_rotten._Rotten;
import net.minecraftplus.mcp_satchel._Satchel;
import net.minecraftplus.mcp_saw._Saw;
import net.minecraftplus.mcp_shatter._Shatter;
import net.minecraftplus.mcp_sickle._Sickle;
import net.minecraftplus.mcp_sweet_potato._Sweet_Potato;
import net.minecraftplus.mcp_torch._Torch;
import net.minecraftplus.mcp_turnip._Turnip;
import net.minecraftplus.mcp_turtle._Turtle;
import net.minecraftplus.mcp_wheel._Wheel;
import net.minecraftplus.mcp_wild_animal._Wild_Animal;

public final class Munge
{
	private static final boolean MUNGE = true;
	private static final ResourceWriter mungeLog = new ResourceWriter(Assets.directory(), "munge.log");
	private static boolean running = false;
	private static boolean dirty = false;

	public static void Open()
	{
		if (!MUNGE) return;

		assert(!mungeLog.isOpen());

		if (mungeLog.exists())
		{
			MCL.error("Munge log already exist!");
			FMLCommonHandler.instance().exitJava(1, false);
		}

		try
		{
			mungeLog.open();
			MCL.setStream(mungeLog.toStream());
			MCL.warning("Date: ", (new SimpleDateFormat("HH:mm:ss - dd/MM/yyyy")).format(new Date()));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		running = true;
	}

	public static void Close()
	{
		if (!MUNGE) return;

		if (mungeLog.isOpen())
		{
			try
			{
				MCL.setStream(System.out);
				mungeLog.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}

			if (!dirty)
			{
				mungeLog.delete();
			}

			running = false;
		}
	}

	public static void PreInitialize()
	{
		if (!MUNGE) return;

		assert(mungeLog.isOpen());

		/*
		String modid = "mcp_glowing_slimeball";
		String modclass = "_Glowing_Slimeball";
		MCF.makeMod(MCF.modDirectory(modid), modclass + ".java");
		MCF.makeProxy(MCF.modDirectory(modid));
		MCF.makeDirectory(Assets.directory() + "/" + modid + "/textures/items");
		MCF.makeDirectory(Assets.directory() + "/" + modid + "/textures/blocks");
		MCF.makeDirectory(Assets.directory() + "/" + modid + "/models/item");
		MCF.makeDirectory(Assets.directory() + "/" + modid + "/models/block");
		 */

		dirty = true;
	}

	public static void Initialize(ModContainer parModContainer)
	{
		if (!MUNGE) return;

		assert(mungeLog.isOpen());

		_Mod mod = (_Mod) parModContainer.getMod();
		String MODID = parModContainer.getModId();

		if (mod == _API.INSTANCE)
		{
			mod.Munge();
			MCL.debug("Completed Initialization:", mod);
		}
		else if (mod == _Cocoa.INSTANCE)
		{
			mod.Munge();
			MCL.debug("Completed Initialization:", mod);
		}
		else if (mod == _Bamboo.INSTANCE)
		{
			mod.Munge();
			MCL.debug("Completed Initialization:", mod);
		}
		else if (mod == _Blowpipe.INSTANCE)
		{
			mod.Munge();
			MCL.debug("Completed Initialization:", mod);
		}
		else if (mod == _Gems.INSTANCE)
		{
			mod.Munge();
			MCL.debug("Completed Initialization:", mod);
		}
		else if (mod == _Clippers.INSTANCE)
		{
			mod.Munge();
			MCL.debug("Completed Initialization:", mod);
		}
		else if (mod == _Battle_Hearts.INSTANCE)
		{
			mod.Munge();
			MCL.debug("Completed Initialization:", mod);
		}
		else if (mod == _Beetroot.INSTANCE)
		{
			mod.Munge();
			MCL.debug("Completed Initialization:", mod);
		}
		else if (mod == _Satchel.INSTANCE)
		{
			mod.Munge();
			MCL.debug("Completed Initialization:", mod);
		}
		else if (mod == _Saw.INSTANCE)
		{
			mod.Munge();
			MCL.debug("Completed Initialization:", mod);
		}
		else if (mod == _Shatter.INSTANCE)
		{
			mod.Munge();
			MCL.debug("Completed Initialization:", mod);
		}
		else if (mod == _Sweet_Potato.INSTANCE)
		{
			mod.Munge();
			MCL.debug("Completed Initialization:", mod);
		}
		else if (mod == _Fossil.INSTANCE)
		{
			mod.Munge();
			MCL.debug("Completed Initialization:", mod);
		}
		else if (mod == _Sickle.INSTANCE)
		{
			mod.Munge();
			MCL.debug("Completed Initialization:", mod);
		}
		else if (mod == _Clay_Tools.INSTANCE)
		{
			mod.Munge();
			MCL.debug("Completed Initialization:", mod);
		}
		else if (mod == _Turnip.INSTANCE)
		{
			mod.Munge();
			MCL.debug("Completed Initialization:", mod);
		}
		else if (mod == _Overgrowth.INSTANCE)
		{
			mod.Munge();
			MCL.debug("Completed Initialization:", mod);
		}
		else if (mod == _Loose_Stone.INSTANCE)
		{
			mod.Munge();
			MCL.debug("Completed Initialization:", mod);
		}
		else if (mod == _Gift_Box.INSTANCE)
		{
			mod.Munge();
			MCL.debug("Completed Initialization:", mod);
		}
		else if (mod == _Lumber.INSTANCE)
		{
			mod.Munge();
			MCL.debug("Completed Initialization:", mod);
		}
		else if (mod == _Wheel.INSTANCE)
		{
			mod.Munge();
			MCL.debug("Completed Initialization:", mod);
		}
		else if (mod == _Torch.INSTANCE)
		{
			mod.Munge();
			MCL.debug("Completed Initialization:", mod);
		}
		else if (mod == _Rotten.INSTANCE)
		{
			mod.Munge();
			MCL.debug("Completed Initialization:", mod);
		}
		else if (mod == _Wild_Animal.INSTANCE)
		{
			mod.Munge();
			MCL.debug("Completed Initialization:", mod);
		}
		else if (mod == _Turtle.INSTANCE)
		{
			mod.Munge();
			MCL.debug("Completed Initialization:", mod);
		}
		else if (mod == _Loom.INSTANCE)
		{
			mod.Munge();
			MCL.debug("Completed Initialization:", mod);
		}
		else if (mod == _Ice_Box.INSTANCE)
		{
			mod.Munge();
			MCL.debug("Completed Initialization:", mod);
		}
		else if (mod == _Glowing_Slime.INSTANCE)
		{
			mod.Munge();
			MCL.debug("Completed Initialization:", mod);
		}
		else if (mod == _Collision.INSTANCE)
		{
			mod.Munge();
			MCL.debug("Completed Initialization:", mod);
		}
		else
		{
			MCL.error("Unknown initialization:", mod);
		}
	}

	public static void setDirty()
	{
		dirty = true;
	}

	public static boolean isRunning()
	{
		return running;
	}

	public static boolean isDirty()
	{
		return dirty;
	}
}
