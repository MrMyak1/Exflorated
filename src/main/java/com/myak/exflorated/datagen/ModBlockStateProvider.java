package com.myak.exflorated.datagen;

import com.myak.exflorated.Exflorated;
import com.myak.exflorated.block.ShallotCropBlock;
import com.myak.exflorated.registries.BlockRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.function.Function;
import java.util.function.Supplier;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Exflorated.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        logBlock((RotatedPillarBlock) BlockRegistry.CITRON_LOG.get());
        logBlock((RotatedPillarBlock) BlockRegistry.CITRON_STRIPPED_LOG.get());
        saplingBlock(BlockRegistry.CITRON_SAPLING);
        blockWithItem(BlockRegistry.CITRON_PLANKS);
        leavesBlock(BlockRegistry.CITRON_LEAVES);
        axisBlock(((RotatedPillarBlock) BlockRegistry.CITRON_WOOD.get()), blockTexture(BlockRegistry.CITRON_LOG.get()), blockTexture(BlockRegistry.CITRON_LOG.get()));
        axisBlock(((RotatedPillarBlock) BlockRegistry.CITRON_STRIPPED_WOOD.get()), blockTexture(BlockRegistry.CITRON_STRIPPED_LOG.get()), blockTexture(BlockRegistry.CITRON_STRIPPED_LOG.get()));
        slabBlock(BlockRegistry.CITRON_SLAB.get(),blockTexture(BlockRegistry.CITRON_PLANKS.get()), blockTexture(BlockRegistry.CITRON_PLANKS.get()));
        stairsBlock(BlockRegistry.CITRON_STAIRS.get(),blockTexture(BlockRegistry.CITRON_PLANKS.get()));
        fenceBlock(BlockRegistry.CITRON_FENCE.get(),blockTexture(BlockRegistry.CITRON_PLANKS.get()));
        fenceGateBlock(BlockRegistry.CITRON_FENCE_GATE.get(),blockTexture(BlockRegistry.CITRON_PLANKS.get()));
        doorBlockWithRenderType(BlockRegistry.CITRON_DOOR.get(), modLoc("block/citron_door_bottom"), modLoc("block/citron_door_top"), "cutout");
        trapdoorBlockWithRenderType(BlockRegistry.CITRON_TRAPDOOR.get(), modLoc("block/citron_trapdoor"), true, "cutout");
        buttonBlock(BlockRegistry.CITRON_BUTTON.get(), blockTexture(BlockRegistry.CITRON_PLANKS.get()));
        pressurePlateBlock(BlockRegistry.CITRON_PRESSURE_PLATE.get(), blockTexture(BlockRegistry.CITRON_PLANKS.get()));
        signBlock((StandingSignBlock) BlockRegistry.CITRON_SIGN.get(), (WallSignBlock) BlockRegistry.CITRON_WALL_SIGN.get(), blockTexture(BlockRegistry.CITRON_PLANKS.get()));

        blockWithItem(BlockRegistry.REINFORCED_SCULK);
        blockWithItem(BlockRegistry.SHRINE_MECHANISM);

        blockItem(BlockRegistry.CITRON_LOG);
        blockItem(BlockRegistry.CITRON_STRIPPED_LOG);
        blockItem(BlockRegistry.CITRON_PLANKS);
        blockItem(BlockRegistry.CITRON_LEAVES);
        blockItem(BlockRegistry.CITRON_WOOD);
        blockItem(BlockRegistry.CITRON_STRIPPED_WOOD);
        blockItem(BlockRegistry.CITRON_SLAB);
        blockItem(BlockRegistry.CITRON_STAIRS);
        blockItem(BlockRegistry.CITRON_PRESSURE_PLATE);
        blockItem(BlockRegistry.CITRON_FENCE_GATE);
        blockItem(BlockRegistry.CITRON_TRAPDOOR, "_bottom");
        blockItem(BlockRegistry.CITRON_PRESSURE_PLATE);

        makeCrop(((CropBlock) BlockRegistry.SHALLOT_CROP.get()), "shallot_crop_stage", "shallot_crop_stage");

    }
    private void blockWithItem(Supplier<Block> blockSupplier) {
        simpleBlockWithItem(blockSupplier.get(), cubeAll(blockSupplier.get()));
    }
    private void saplingBlock(DeferredBlock<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(), models().cross(BuiltInRegistries.BLOCK.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void leavesBlock(DeferredBlock<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(), models().singleTexture(BuiltInRegistries.BLOCK.getKey(blockRegistryObject.get()).getPath(), ResourceLocation.parse("minecraft:block/leaves"), "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }
    public void makeCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> states(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] states(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((ShallotCropBlock) block).getAgeProperty()),
                ResourceLocation.fromNamespaceAndPath(Exflorated.MODID, "block/" + textureName + state.getValue(((ShallotCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("exflorated:block/" + deferredBlock.getId().getPath()));
    }
    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("exflorated:block/" + deferredBlock.getId().getPath() + appendix));
    }

}