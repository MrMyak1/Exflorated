package com.myak.exflorated.datamaps;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

public record PurifyingOilCleansingMap(Block block) {
    public static final Codec<PurifyingOilCleansingMap> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Block.CODEC.fieldOf("purified_block").forGetter(PurifyingOilCleansingMap::block)
    )
            .apply(instance, PurifyingOilCleansingMap::new));
}
