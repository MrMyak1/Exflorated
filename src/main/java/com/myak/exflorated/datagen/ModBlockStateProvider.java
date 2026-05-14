package com.myak.exflorated.datagen;

import com.myak.exflorated.Exflorated;
import com.myak.exflorated.registries.BlockRegistry;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.function.Supplier;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Exflorated.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        logBlock((RotatedPillarBlock) BlockRegistry.CITRINE_LOG.get());
        logBlock((RotatedPillarBlock) BlockRegistry.CITRINE_STRIPPED_LOG.get());

        blockWithItem(BlockRegistry.CITRINE_PLANKS);
    }
    private void blockWithItem(Supplier<Block> blockSupplier) {
        simpleBlockItem(blockSupplier.get(), cubeAll(blockSupplier.get()));
    }
    private void saplingBlock(DeferredBlock<Block> blockRegistryObject) {

    }

    private void leavesBlock(DeferredBlock<Block> blockRegistryObject) {

    }
}