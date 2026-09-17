package com.example.riderremover;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = "riderremover", name = "Rider Remover Mod", version = "1.0")
public class RiderRemoverMod {
   public static final String MODID = "riderremover";
   public static final String NAME = "Rider Remover Mod";
   public static final String VERSION = "1.0";

   @EventHandler
   public void preInit(FMLPreInitializationEvent event) {
      FMLCommonHandler.instance().bus().register(new RiderRemovalHandler());
   }

   @EventHandler
   public void init(FMLInitializationEvent event) {
   }
}
