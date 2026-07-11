package com.myak.exflorated.datagen;

import com.myak.exflorated.Exflorated;
import com.myak.exflorated.registries.BlockRegistry;
import com.myak.exflorated.tag.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags,
                               @Nullable ExistingFileHelper existingfilehelper) {
        super(output, lookupProvider, blockTags, Exflorated.MODID, existingfilehelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ItemTags.LOGS_THAT_BURN)
                .add(BlockRegistry.CITRON_LOG.get().asItem())
                .add(BlockRegistry.CITRON_STRIPPED_LOG.get().asItem())
                .add(BlockRegistry.CITRON_WOOD.get().asItem())
                .add(BlockRegistry.CITRON_STRIPPED_WOOD.get().asItem());

        this.tag(ItemTags.PLANKS)
                .add(BlockRegistry.CITRON_PLANKS.asItem());
        this.tag(ItemTags.LOGS)
                .add(BlockRegistry.CITRON_LOG.get().asItem())
                .add(BlockRegistry.CITRON_STRIPPED_LOG.get().asItem())
                .add(BlockRegistry.CITRON_WOOD.get().asItem())
                .add(BlockRegistry.CITRON_STRIPPED_WOOD.get().asItem());
        this.tag(ModTags.CITRON_LOGS)
                .add(BlockRegistry.CITRON_LOG.asItem())
                .add(BlockRegistry.CITRON_STRIPPED_LOG.asItem())
                .add(BlockRegistry.CITRON_WOOD.get().asItem())
                .add(BlockRegistry.CITRON_STRIPPED_WOOD.get().asItem());
    }
}