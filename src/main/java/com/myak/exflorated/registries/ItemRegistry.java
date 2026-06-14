package com.myak.exflorated.registries;

import com.myak.exflorated.Exflorated;
import net.minecraft.references.Blocks;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ItemRegistry {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Exflorated.MODID);

    public static final DeferredItem<Item> CITRON = ITEMS.register("citron",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SHALLOT = ITEMS.register("shallot",
            () -> new ItemNameBlockItem(BlockRegistry.SHALLOT_CROP.get(), new Item.Properties()));

    public static final DeferredItem<Item> CANTALOUPE = ITEMS.register("cantaloupe",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> TRANSWHEAT = ITEMS.register("transwheat",
            () -> new Item(new Item.Properties()));

}
