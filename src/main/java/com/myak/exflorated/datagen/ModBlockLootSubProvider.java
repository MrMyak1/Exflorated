package com.myak.exflorated.datagen;

import com.myak.exflorated.block.ShallotCropBlock;
import com.myak.exflorated.registries.BlockRegistry;
import com.myak.exflorated.registries.ItemRegistry;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;

import java.util.Set;

public class ModBlockLootSubProvider extends BlockLootSubProvider {
    public ModBlockLootSubProvider(HolderLookup.Provider lookupProvider) {
        // The first parameter is a set of blocks we are creating loot tables for. Instead of hardcoding,
        // we use our block registry and just pass an empty set here.
        // The second parameter is the feature flag set, this will be the default flags
        // unless you are adding custom flags (which is beyond the scope of this article).
        super(Set.of(), FeatureFlags.DEFAULT_FLAGS, lookupProvider);
    }
    @Override
    protected Iterable<Block> getKnownBlocks() {
        // The contents of our DeferredRegister.
        return BlockRegistry.BLOCKS.getEntries()
                .stream()
                // Cast to Block here, otherwise it will be a ? extends Block and Java will complain.
                .map(e -> (Block) e.value())
                .toList();
    }
    @Override
    protected void generate() {
        dropSelf(BlockRegistry.CITRON_SAPLING.get());
        dropSelf(BlockRegistry.CITRON_LOG.get());
        add(BlockRegistry.CITRON_LEAVES.get(), block ->
                createOakLeavesDrops(block, BlockRegistry.CITRON_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        dropSelf(BlockRegistry.CITRON_PLANKS.get());
        dropSelf(BlockRegistry.CITRON_STRIPPED_LOG.get());
        dropSelf(BlockRegistry.CITRON_STRIPPED_WOOD.get());
        dropSelf(BlockRegistry.CITRON_WOOD.get());
        dropSelf(BlockRegistry.CITRON_SLAB.get());
        dropSelf(BlockRegistry.CITRON_STAIRS.get());
        dropSelf(BlockRegistry.CITRON_FENCE.get());
        dropSelf(BlockRegistry.CITRON_FENCE_GATE.get());
        dropSelf(BlockRegistry.CITRON_TRAPDOOR.get());
        dropSelf(BlockRegistry.CITRON_DOOR.get());
        dropSelf(BlockRegistry.CITRON_PRESSURE_PLATE.get());
        dropSelf(BlockRegistry.CITRON_BUTTON.get());

        LootItemCondition.Builder lootItemConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(BlockRegistry.SHALLOT_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(ShallotCropBlock.AGE, 4));
        this.add(BlockRegistry.SHALLOT_CROP.get(), this.createCropDrops(BlockRegistry.SHALLOT_CROP.get(), ItemRegistry.SHALLOT.get(),ItemRegistry.SHALLOT.get(), lootItemConditionBuilder));


    }
}
