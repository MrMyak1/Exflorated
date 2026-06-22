package com.myak.exflorated.datagen;

import com.myak.exflorated.Exflorated;
import com.myak.exflorated.loot_modifier.SnifferLootModifier;
import com.myak.exflorated.registries.BlockRegistry;
import com.myak.exflorated.registries.ItemRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.neoforged.neoforge.common.loot.LootTableIdCondition;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {


    public ModGlobalLootModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> future) {
        super(output, future, Exflorated.MODID);
    }

    @Override
    protected void start() {
        add("extended_sniffer_plants", new SnifferLootModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(ResourceLocation.parse("gameplay/sniffer_digging")).build()
        }, List.of(ItemRegistry.SHALLOT.get(), BlockRegistry.CITRON_SAPLING.asItem())));
    }
}
