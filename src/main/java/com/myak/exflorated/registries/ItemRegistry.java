package com.myak.exflorated.registries;

import com.myak.exflorated.Exflorated;
import com.myak.exflorated.item.PurifyingOilItem;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ItemRegistry {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Exflorated.MODID);

    public static final DeferredItem<Item> CITRON = ITEMS.register("citron",
            () -> new Item(new Item.Properties().food(Foods.APPLE)));

    public static final DeferredItem<Item> SHALLOT = ITEMS.register("shallot",
            () -> new ItemNameBlockItem(BlockRegistry.SHALLOT_CROP.get(), new Item.Properties()));

    public static final DeferredItem<Item> ZUCCHINI = ITEMS.register("zucchini",
            () -> new Item(new Item.Properties().food(Foods.POTATO)));

    public static final DeferredItem<Item> CANTALOUPE = ITEMS.register("cantaloupe",
            () -> new Item(new Item.Properties())); // Unused

    public static final DeferredItem<Item> TRANSWHEAT = ITEMS.register("transwheat",
            () -> new Item(new Item.Properties())); // Unused



    public static final DeferredItem<Item> PURIFYING_OIL = ITEMS.register("purifying_oil",
            () -> new PurifyingOilItem(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> GARLIC_BREAD = ITEMS.register("garlic_bread",
            () -> new Item(new Item.Properties().food(Foods.COOKED_BEEF)));

}
