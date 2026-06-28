package com.myak.exflorated.datamaps;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

public record PurifyingOilCleansingMap(Holder<Block> pureBlock) {
    public static final Codec<PurifyingOilCleansingMap> CODEC = RecordCodecBuilder.create(instance -> instance.group(
                    BuiltInRegistries.BLOCK.holderByNameCodec().fieldOf("purified_block").forGetter(PurifyingOilCleansingMap::pureBlock)
    )
            .apply(instance, PurifyingOilCleansingMap::new));
}
