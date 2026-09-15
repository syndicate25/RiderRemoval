package com.example.riderremover;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

public class RiderRemovalHandler {
   @SubscribeEvent
   public void onEntityJoinWorld(EntityJoinWorldEvent event) {
      Entity rider = event.entity;
      World world = rider.worldObj;
      if (!world.isRemote) {
         if (!(rider instanceof EntityPlayer)) {
            if (rider.ridingEntity != null) {
               rider.mountEntity(null);
            }
         }
      }
   }
}
