package me.havocdev.cofh.tileentities;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TileEntitiesInitializer {
	

    @SideOnly(Side.CLIENT)
    public static final void init() {
		GameRegistry.registerTileEntity(TileEntityGenerator.class, "test_generator");
    }

}
