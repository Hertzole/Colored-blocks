package com.hertzole.colorBlocks.client.render.blocks;

import com.hertzole.colorBlocks.Main;
import com.hertzole.colorBlocks.blocks.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;

public final class BlockRenderRegister {
	
	public static String modid = Main.MODID;
	
	private static final String colors[] = {"white", "orange", "magenta", "light_blue", "yellow", "lime", "pink", "gray", "silver", "cyan", "purple", "blue", "brown", "green", "red", "black"};
	
	public static void preInit(){
	}
	
	public static void registerBlockRenderer(){
		reg(ModBlocks.testBlock);
		registerBlocks(ModBlocks.coloredWood, "wood_colored");
		//ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.coloredWood), 0, new ModelResourceLocation(modid + ":wood_colored#type=white"));
	}
	
	private static void registerBlocks(Block block, String prefix){
		for(int i = 0; i < 16; i++)
			reg(block, i, prefix, colors[i]);
	}
	
	public static void reg(Block block){
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(modid + ":" + block.getUnlocalizedName().substring(5), "inventory"));
		System.out.print("Registering block at " + modid + ":" + block.getUnlocalizedName().substring(5) + "\n");
	}
	
	public static void reg(Block block, int meta, String prefix, String color){
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), meta, new ModelResourceLocation(modid + ":" + prefix + "#type=" + color));
		System.out.print("Registering meta block at " + modid + ":" + prefix + "#type=" + color + "\n");
	}
}
