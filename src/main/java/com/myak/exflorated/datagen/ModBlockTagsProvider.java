package com.myak.exflorated.datagen;

import com.myak.exflorated.Exflorated;
import com.myak.exflorated.registries.BlockRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Exflorated.MODID, existingFileHelper);
    }

    // Add your tag entries here.
    @Override
    protected void addTags(HolderLookup.Provider lookupProvider) {
        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(BlockRegistry.CITRINE_LEAVES.get())
                .add(BlockRegistry.CITRINE_PLANKS.get())
                .add(BlockRegistry.CITRINE_SAPLING.get())
                .add(BlockRegistry.CITRINE_LOG.get())
                .add(BlockRegistry.CITRINE_STRIPPED_LOG.get());
    }
}
