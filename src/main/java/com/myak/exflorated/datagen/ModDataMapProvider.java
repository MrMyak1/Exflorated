package com.myak.exflorated.datagen;

import com.myak.exflorated.datamaps.ModDatamaps;
import com.myak.exflorated.datamaps.PurifyingOilCleansingMap;
//import earth.terrarium.pastel.registries.PastelItems;
import com.myak.exflorated.registries.BlockRegistry;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;
import net.neoforged.neoforge.common.data.DataMapProvider;

import java.util.concurrent.CompletableFuture;


public class ModDataMapProvider extends DataMapProvider {
    protected ModDataMapProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void gather(HolderLookup.Provider provider) {
        builder(ModDatamaps.BLOCK_CLEANSING)
                .add(getHolder(Blocks.SCULK), new PurifyingOilCleansingMap(getHolder(Blocks.DIRT)), false)
                .add(getHolder(Blocks.SCULK_CATALYST), new PurifyingOilCleansingMap(getHolder(Blocks.AIR)), false)
                .add(getHolder(Blocks.SCULK_VEIN), new PurifyingOilCleansingMap(getHolder(Blocks.VINE)), false)
                .add(getHolder(Blocks.SCULK_SENSOR), new PurifyingOilCleansingMap(getHolder(Blocks.AIR)), false)
                .add(getHolder(Blocks.SCULK_SHRIEKER), new PurifyingOilCleansingMap(getHolder(Blocks.BONE_BLOCK)), false)
                .add(getHolder(Blocks.CALIBRATED_SCULK_SENSOR), new PurifyingOilCleansingMap(getHolder(Blocks.AMETHYST_CLUSTER)), false)

                .add(getHolder(Blocks.WARPED_STEM), new PurifyingOilCleansingMap(getHolder(Blocks.CRIMSON_STEM)), false)
                .add(getHolder(Blocks.WARPED_WART_BLOCK), new PurifyingOilCleansingMap(getHolder(Blocks.NETHER_WART_BLOCK)), false)
                .add(getHolder(Blocks.WARPED_NYLIUM), new PurifyingOilCleansingMap(getHolder(Blocks.CRIMSON_NYLIUM)), false)

                .add(BlockRegistry.REINFORCED_SCULK, new PurifyingOilCleansingMap(getHolder(Blocks.BONE_BLOCK)), false);
    }
    private Holder<Block> getHolder(Block block) {
        return BuiltInRegistries.BLOCK.wrapAsHolder(block);
    }
}
