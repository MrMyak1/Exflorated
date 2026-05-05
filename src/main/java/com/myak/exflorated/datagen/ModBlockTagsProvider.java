package com.myak.exflorated.datagen;

import com.myak.exflorated.Exflorated;
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

    }
}
