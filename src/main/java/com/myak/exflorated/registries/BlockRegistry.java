package com.myak.exflorated.registries;

import com.myak.exflorated.Exflorated;
import com.myak.exflorated.block.ModLogBlock;
import com.myak.exflorated.block.ShallotCropBlock;
import com.myak.exflorated.worldgen.tree.ModTreeGrower;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class BlockRegistry {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Exflorated.MODID);

    public static final DeferredBlock<Block> CITRON_SAPLING = registerBlock("citron_sapling",()-> new SaplingBlock(ModTreeGrower.CITRON_TREE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<Block> CITRON_LOG = registerBlock("citron_log",()-> new ModLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
    public static final DeferredBlock<Block> CITRON_STRIPPED_LOG = registerBlock("citron_stripped_log",()-> new ModLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG)));
    public static final DeferredBlock<Block> CITRON_LEAVES = registerBlock("citron_leaves",()-> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<Block> CITRON_PLANKS = registerBlock("citron_planks",()-> new ModLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)) {


        @Override
        public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
            return 20;
        }

    });
    public static final DeferredBlock<Block> SHALLOT_CROP = BLOCKS.register("shallot_crop",
            ()-> new ShallotCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CARROTS)));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ItemRegistry.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
}
