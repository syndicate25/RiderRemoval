package com.example.riderremover;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

public class RiderRemovalHandler {

    @SubscribeEvent
    public void onEntityJoinWorld(EntityJoinWorldEvent event) {
        // Run strictly server-side
        if (event.entity == null || event.world.isRemote) {
            return;
        }

        Entity entity = event.entity;

        // One-part control: We only intercept the mount when it enters the world
        if (entity instanceof EntitySpider) {
            
            // Check if Minecraft forced a bonus rider onto it during generation
            if (entity.riddenByEntity != null) {
                Entity rider = entity.riddenByEntity;

                // Protect human players from being kicked off/killed
                if (!(rider instanceof EntityPlayer)) {
                    
                    // 1. Terminate the illegal bonus rider
                    rider.setDead();
                    
                    // 2. Clear the seat so the mount enters the world clean
                    entity.riddenByEntity = null;
                }
            }
        }
    }
}
