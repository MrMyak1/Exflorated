package com.myak.exflorated.loot_modifier;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;

import java.util.List;

public class SnifferLootModifier extends LootModifier {
    public static final MapCodec<SnifferLootModifier> CODEC = RecordCodecBuilder.mapCodec(instance -> codecStart(instance).and(ExtraCodecs.nonEmptyList(BuiltInRegistries.ITEM.byNameCodec().listOf())
                    .fieldOf("item").forGetter(o -> o.items)).apply(instance, SnifferLootModifier::new));
    private final List<Item> items;

    public SnifferLootModifier(LootItemCondition[] conditions, List<Item> items) {
        super(conditions);
        this.items = items;
    }

    @Override
    public MapCodec<? extends IGlobalLootModifier> codec() {
        return CODEC;
    }

    @Override
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedloot, LootContext lootContext) {

        generatedloot.add(Items.PITCHER_POD.getDefaultInstance());
        generatedloot.add(Items.TORCHFLOWER_SEEDS.getDefaultInstance());

        return generatedloot;
    }
}
