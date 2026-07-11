package com.myak.exflorated.registries;

import com.myak.exflorated.Exflorated;
import com.myak.exflorated.block.ModLogBlock;
import com.myak.exflorated.block.ShallotCropBlock;
import com.myak.exflorated.block.ShrineMechanismBlock;
import com.myak.exflorated.worldgen.tree.ModTreeGrower;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class BlockRegistry {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Exflorated.MODID);

    public static final DeferredBlock<Block> CITRON_SAPLING = registerBlock("citron_sapling",()-> new SaplingBlock(ModTreeGrower.CITRON_TREE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<Block> CITRON_LOG = registerBlock("citron_log",()-> new ModLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
    public static final DeferredBlock<Block> CITRON_WOOD = registerBlock("citron_wood",()-> new ModLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)));
    public static final DeferredBlock<Block> CITRON_STRIPPED_LOG = registerBlock("citron_stripped_log",()-> new ModLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG)));
    public static final DeferredBlock<Block> CITRON_STRIPPED_WOOD = registerBlock("citron_stripped_wood",()-> new ModLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> CITRON_LEAVES = registerBlock("citron_leaves",()-> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<Block> CITRON_PLANKS = registerBlock("citron_planks",()-> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)) {


        @Override
        public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
            return 20;
        }

    });
    public static final DeferredBlock<SlabBlock> CITRON_SLAB = registerBlock("citron_slab",()-> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB)));
    public static final DeferredBlock<StairBlock> CITRON_STAIRS = registerBlock("citron_stairs",()-> new StairBlock(BlockRegistry.CITRON_PLANKS.get().defaultBlockState(),BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS)));
    public static final DeferredBlock<FenceBlock> CITRON_FENCE = registerBlock("citron_fence",()-> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB)));
    public static final DeferredBlock<FenceGateBlock> CITRON_FENCE_GATE = registerBlock("citron_fence_gate",()-> new FenceGateBlock(WoodType.OAK,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE)));
    public static final DeferredBlock<TrapDoorBlock> CITRON_TRAPDOOR = registerBlock("citron_trapdoor",()-> new TrapDoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR)));
    public static final DeferredBlock<DoorBlock> CITRON_DOOR = registerBlock("citron_door",()-> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR)));
    public static final DeferredBlock<ButtonBlock> CITRON_BUTTON = registerBlock("citron_button",()-> new ButtonBlock(BlockSetType.OAK, 30, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON)));
    public static final DeferredBlock<PressurePlateBlock> CITRON_PRESSURE_PLATE = registerBlock("citron_pressure_plate",()-> new PressurePlateBlock(BlockSetType.OAK,  BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON)));
    public static final DeferredBlock<SignBlock> CITRON_SIGN = BLOCKS.register("citron_sign", ()-> new StandingSignBlock(WoodType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN)));
    public static final DeferredBlock<WallSignBlock> CITRON_WALL_SIGN = BLOCKS.register("citron_wall_sign", ()-> new WallSignBlock(WoodType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN).lootFrom(BlockRegistry.CITRON_SIGN)));

    public static final DeferredBlock<Block> SHALLOT_CROP = BLOCKS.register("shallot_crop",
            ()-> new ShallotCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CARROTS)));

    public static final DeferredBlock<Block> REINFORCED_SCULK = registerBlock("reinforced_sculk",()-> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BEDROCK)));
    public static final DeferredBlock<Block> SHRINE_MECHANISM = registerBlock("shrine_mechanism",()-> new ShrineMechanismBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ANCIENT_DEBRIS)));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ItemRegistry.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
}
