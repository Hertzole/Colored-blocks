package com.hertzole.colorBlocks;

import com.hertzole.colorBlocks.blocks.ModBlocks;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ColorBlockTab extends CreativeTabs{

	public ColorBlockTab(String label) {
		super(label);
	}

	@Override
	public Item getTabIconItem() {
		return Item.getItemFromBlock(ModBlocks.coloredWood);
	}

}
