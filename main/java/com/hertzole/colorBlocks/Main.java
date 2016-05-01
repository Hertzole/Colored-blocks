package com.hertzole.colorBlocks;

import com.hertzole.colorBlocks.blocks.ModBlocks;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Main.MODID, name = Main.MODNAME, version = Main.VERSION)
public class Main {
	public static final String MODID = "hertzole";
	public static final String MODNAME = "Color Blocks";
	public static final String VERSION = "1.0.0";
	
	@SidedProxy(clientSide="com.hertzole.colorBlocks.ClientProxy", serverSide = "com.hertzole.colorBlocks.ServerProxy")
	public static CommonProxy proxy;
	
	public static final CreativeTabs blocksTab = new ColorBlockTab("colorBlocksTab");
	
	@Instance
	public static Main instance = new Main();
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
	    ModBlocks.createBlocks();
	}

	@EventHandler
	public void init(FMLInitializationEvent e) {
	    this.proxy.init(e);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
	    this.proxy.postInit(e);
	}
}
