package com.myak.exflorated.registries;

import com.myak.exflorated.Exflorated;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class BlockRegistry {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Exflorated.MODID);

    public static final DeferredBlock<Block> CITRINE_SAPLING = registerBlock("citrine_sapling",()-> new Block(BlockBehaviour.Properties.of()
            .strength(0F, 0f)
            .sound(SoundType.GRASS)));
    public static final DeferredBlock<Block> CITRINE_LOG = registerBlock("citrine_log",()-> new Block(BlockBehaviour.Properties.of()
            .strength(2F, 2f)
            .sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> CITRINE_LEAVES = registerBlock("citrine_leaves",()-> new Block(BlockBehaviour.Properties.of()
            .strength(0F, 0f)
            .sound(SoundType.GRASS)));


    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ItemRegistry.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
