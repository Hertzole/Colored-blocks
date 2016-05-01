package com.hertzole.colorBlocks.blocks;

import java.util.List;

import com.hertzole.colorBlocks.Main;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class BlockProperties extends Block implements IMetaBlockName{

	public static final PropertyEnum TYPE = PropertyEnum.create("type", BlockProperties.EnumType.class);
	
	public BlockProperties(String unlocalizedName, Material material, float hardness, float resistance){
		super(material);
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(Main.blocksTab);
		this.setHardness(hardness);
		this.setResistance(resistance);
		this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, EnumType.WHITE));
		
		if(material == Material.wood){
			this.setStepSound(soundTypeWood);
		}
		else if(material == Material.rock){
			this.setStepSound(soundTypeStone);
		}
		else if(material == Material.glass){
			this.setStepSound(soundTypeGlass);
		}
	}
	
	@Override
	protected BlockState createBlockState(){
		return new BlockState(this, new IProperty[] { TYPE });
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta){
		switch(meta){
		case 0:
			return getDefaultState().withProperty(TYPE, EnumType.WHITE);
		case 1:
			return getDefaultState().withProperty(TYPE, EnumType.ORANGE);
		case 2:
			return getDefaultState().withProperty(TYPE, EnumType.MAGENTA);
		case 3:
			return getDefaultState().withProperty(TYPE, EnumType.LIGHT_BLUE);
		case 4:
			return getDefaultState().withProperty(TYPE, EnumType.YELLOW);
		case 5:
			return getDefaultState().withProperty(TYPE, EnumType.LIME);
		case 6:
			return getDefaultState().withProperty(TYPE, EnumType.PINK);
		case 7:
			return getDefaultState().withProperty(TYPE, EnumType.GRAY);
		case 8:
			return getDefaultState().withProperty(TYPE, EnumType.SILVER);
		case 9:
			return getDefaultState().withProperty(TYPE, EnumType.CYAN);
		case 10:
			return getDefaultState().withProperty(TYPE, EnumType.PURPLE);
		case 11:
			return getDefaultState().withProperty(TYPE, EnumType.BLUE);
		case 12:
			return getDefaultState().withProperty(TYPE, EnumType.BROWN);
		case 13:
			return getDefaultState().withProperty(TYPE, EnumType.GREEN);
		case 14:
			return getDefaultState().withProperty(TYPE, EnumType.RED);
		case 15:
			return getDefaultState().withProperty(TYPE, EnumType.BLACK);
		}
		
		return getDefaultState().withProperty(TYPE, EnumType.WHITE);
	}
	
	@Override
	public int getMetaFromState(IBlockState state){
		EnumType type = (EnumType) state.getValue(TYPE);
		return type.getID();
	}
	
	@Override
	public int damageDropped(IBlockState state){
		return getMetaFromState(state);
	}
	
	@Override
	public String getSpecialName(ItemStack stack){
		switch(stack.getItemDamage()){
		case 0:
			return "white";
		case 1:
			return "orange";
		case 2:
			return "magenta";
		case 3:
			return "light_blue";
		case 4:
			return "yellow";
		case 5:
			return "lime";
		case 6:
			return "pink";
		case 7:
			return "gray";
		case 8:
			return "silver";
		case 9:
			return "cyan";
		case 10:
			return "purple";
		case 11:
			return "blue";
		case 12:
			return "brown";
		case 13:
			return "green";
		case 14:
			return "red";
		case 15:
			return "black";
		}
		
		return "white";
	}
	
	@Override
	public ItemStack getPickBlock(MovingObjectPosition target, World world, BlockPos pos){
		return new ItemStack(Item.getItemFromBlock(this), 1, this.getMetaFromState(world.getBlockState(pos)));
	}
	
	@Override
	public void getSubBlocks(Item itemIn, CreativeTabs tab, List list) {
		for(int i = 0; i < 16; i++)
			list.add(new ItemStack(itemIn, 1, i));
	}
	
	public enum EnumType implements IStringSerializable{
		WHITE(0, "white"),
		ORANGE(1, "orange"),
		MAGENTA(2, "magenta"),
		LIGHT_BLUE(3, "light_blue"),
		YELLOW(4, "yellow"),
		LIME(5, "lime"),
		PINK(6, "pink"),
		GRAY(7, "gray"),
		SILVER(8, "silver"),
		CYAN(9, "cyan"),
		PURPLE(10, "purple"),
		BLUE(11, "blue"),
		BROWN(12, "brown"),
		GREEN(13, "green"),
		RED(14, "red"),
		BLACK(15, "black");
		
		private int ID;
		private String name;
		
		private EnumType(int ID, String name) {
			this.ID = ID;
			this.name = name;
		}

		@Override
		public String getName() {
			return this.name;
		}

		public int getID() {
			return this.ID;
		}

		@Override
		public String toString() {
			return this.getName();
		}
	}
}