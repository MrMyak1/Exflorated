package com.myak.exflorated.registries;

import com.myak.exflorated.Exflorated;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ItemRegistry {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Exflorated.MODID);



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
