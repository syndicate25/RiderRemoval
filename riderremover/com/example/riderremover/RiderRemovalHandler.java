package com.example.riderremover;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.EntityMountEvent;

public class RiderRemovalHandler {

    @SubscribeEvent
    public void onEntityMount(EntityMountEvent event) {
        // Run strictly server-side when an entity is attempting to mount
        if (event.entity != null && !event.entity.worldObj.isRemote && event.isMounting) {
            
            Entity rider = event.entity;
            Entity mount = event.target;

            // Enforce exclusion rules: target must exist and rider cannot be a player
            if (mount != null && rider != null && !(rider instanceof EntityPlayer)) {
                
                // Instantly erase the mount from the world index completely.
                // By letting the mount connection execute instead of cancelling it, 
                // the game processes them as a unit, preventing duplicate rogue spawns.
                mount.setDead();
            }
        }
    }
}