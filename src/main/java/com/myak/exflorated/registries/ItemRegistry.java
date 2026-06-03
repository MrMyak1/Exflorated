package com.myak.exflorated.registries;

import com.myak.exflorated.Exflorated;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ItemRegistry {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Exflorated.MODID);

    public static final DeferredItem<Item> CITRON = ITEMS.register("citron",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SHALLOT = ITEMS.register("shallot",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> CANTALOUPE = ITEMS.register("cantaloupe",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> TRANSWHEAT = ITEMS.register("transwheat",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
