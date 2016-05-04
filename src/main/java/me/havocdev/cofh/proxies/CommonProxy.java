package me.havocdev.cofh.proxies;

import me.havocdev.cofh.blocks.BlocksInitializer;
import me.havocdev.cofh.tileentities.TileEntitiesInitializer;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
	public void preInit(FMLPreInitializationEvent e) {
		BlocksInitializer.init();
		TileEntitiesInitializer.init();
    }

    public void init(FMLInitializationEvent e) {

    }

    public void postInit(FMLPostInitializationEvent e) {

    }
}
