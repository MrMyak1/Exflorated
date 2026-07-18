package com.myak.exflorated.registries;

import com.myak.exflorated.Exflorated;
import com.myak.exflorated.item.PurifyingOilItem;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SignItem;
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

    public static final DeferredItem<Item> BOTTLE_OF_STRANGE_OOZE = ITEMS.register("bottle_of_strange_ooze",
            () -> new Item(new Item.Properties().stacksTo(16).rarity(Rarity.EPIC).component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true)));

    //public static final DeferredItem<Item> CITRON_SIGN = ITEMS.register("citron_sign",
    //        () -> new SignItem(new Item.Properties(), BlockRegistry.CITRON_SIGN.get(), BlockRegistry.CITRON_WALL_SIGN.get()));

}
