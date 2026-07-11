package com.myak.exflorated.datagen;

import com.myak.exflorated.Exflorated;
import com.myak.exflorated.registries.BlockRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Exflorated.MODID, existingFileHelper);
    }

    // Add your tag entries here.
    @Override
    protected void addTags(HolderLookup.Provider lookupProvider) {
        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(BlockRegistry.CITRON_LOG.get())
                .add(BlockRegistry.CITRON_STRIPPED_LOG.get());
        this.tag(BlockTags.PLANKS)
                .add(BlockRegistry.CITRON_PLANKS.get());
        this.tag(BlockTags.MINEABLE_WITH_AXE)
                .add(BlockRegistry.CITRON_LOG.get())
                .add(BlockRegistry.CITRON_STRIPPED_LOG.get())
                .add(BlockRegistry.CITRON_WOOD.get())
                .add(BlockRegistry.CITRON_STRIPPED_WOOD.get())
                .add(BlockRegistry.CITRON_SLAB.get())
                .add(BlockRegistry.CITRON_STAIRS.get())
                .add(BlockRegistry.CITRON_FENCE.get())
                .add(BlockRegistry.CITRON_FENCE_GATE.get())
                .add(BlockRegistry.CITRON_TRAPDOOR.get())
                .add(BlockRegistry.CITRON_DOOR.get())
                .add(BlockRegistry.CITRON_BUTTON.get())
                .add(BlockRegistry.CITRON_PRESSURE_PLATE.get());
        this.tag(BlockTags.FENCES)
                .add(BlockRegistry.CITRON_FENCE.get());
        this.tag(BlockTags.FENCE_GATES)
                .add(BlockRegistry.CITRON_FENCE_GATE.get());

    }
}
