package com.hertzole.colorBlocks.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class ModBlocks{
	
	public static Block testBlock;
	public static Block coloredWood;
	
	public static void createBlocks(){
		GameRegistry.registerBlock(testBlock = new BasicBlock("test_block"), "test_block");
		GameRegistry.registerBlock(coloredWood = new BlockProperties("wood_colored", Material.wood, 2, 5), ItemBlockMeta.class, "wood_colored");
	}
}
