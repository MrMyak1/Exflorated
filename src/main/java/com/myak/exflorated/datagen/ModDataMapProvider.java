package com.myak.exflorated.datagen;

import com.myak.exflorated.datamaps.ModDatamaps;
import com.myak.exflorated.datamaps.PurifyingOilCleansingMap;
//import earth.terrarium.pastel.registries.PastelItems;
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
                .add(getHolder(Blocks.SCULK), new PurifyingOilCleansingMap(Blocks.DIRT), false)
                .add(getHolder(Blocks.WARPED_STEM), new PurifyingOilCleansingMap(Blocks.CRIMSON_STEM), false);
                //.add(PastelBlocks.BLACK_MATERIA , new PurifyingOilCleansingMap(Blocks.DIRT), false, new ModLoadedCondition("pastel"));
    }
    private Holder<Block> getHolder(Block block) {
        return BuiltInRegistries.BLOCK.wrapAsHolder(block);
    }
}
