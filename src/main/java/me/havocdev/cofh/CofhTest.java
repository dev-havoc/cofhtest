package me.havocdev.cofh;

import me.havocdev.cofh.proxies.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid= "cofh", version = "1.0")
public class CofhTest {

	public static String modid = "cofh", version = "1.0";


	@SidedProxy(clientSide="me.havocdev.cofh.proxies.CommonProxy", serverSide="me.havocdev.cofh.proxies.ServerProxy")
	public static CommonProxy proxy;
	
	@EventHandler        
	public void preInit(FMLPreInitializationEvent e)
	{
		proxy.preInit(e);
	}
	

	@EventHandler
	public void init(FMLInitializationEvent e)
	{
		proxy.init(e);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent e)
	{
		proxy.postInit(e);
	}
	
	
}
