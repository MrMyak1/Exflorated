package com.myak.exflorated.datamaps;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.registries.datamaps.DataMapType;
import net.neoforged.neoforge.registries.datamaps.RegisterDataMapTypesEvent;

public class ModDatamaps {
    public static final DataMapType<Block, PurifyingOilCleansingMap> BLOCK_CLEANSING = DataMapType.builder(
            ResourceLocation.fromNamespaceAndPath("exflorated", "block_cleansing"),
            Registries.BLOCK,
            PurifyingOilCleansingMap.CODEC
    ).synced(PurifyingOilCleansingMap.CODEC, true).build();

    @SubscribeEvent
    public static void registerDataMapTypes(RegisterDataMapTypesEvent event) {
        event.register(BLOCK_CLEANSING);
    }
}
