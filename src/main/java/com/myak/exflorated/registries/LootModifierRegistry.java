package com.myak.exflorated.registries;

import com.mojang.serialization.MapCodec;
import com.myak.exflorated.Exflorated;
import com.myak.exflorated.loot_modifier.SnifferLootModifier;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

public class LootModifierRegistry {
    public static final DeferredRegister<MapCodec<? extends IGlobalLootModifier>> GLOBAL_LOOT_MODIFIERS = DeferredRegister.create(NeoForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, Exflorated.MODID);

    public static final Supplier<MapCodec<SnifferLootModifier>> SNIFFER_LOOT_MODIFIER = GLOBAL_LOOT_MODIFIERS.register("sniffer_loot_modifier", ()-> SnifferLootModifier.CODEC);
}
