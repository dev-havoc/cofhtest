package me.havocdev.cofh.blocks;

import me.havocdev.cofh.CofhTest;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlocksInitializer {

	public static Block testMachine;

    @SideOnly(Side.CLIENT)
	public static final void init()
	{
		testMachine = new BlockTestMachine().setBlockName("test_generator_block").setBlockTextureName(CofhTest.modid+":"+"test_generator_block").setCreativeTab(CreativeTabs.tabBlock);
		GameRegistry.registerBlock(testMachine, "test_generator_block");
	}
}
