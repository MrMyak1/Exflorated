package com.myak.exflorated.item;

import com.myak.exflorated.datamaps.ModDatamaps;
import com.myak.exflorated.datamaps.PurifyingOilCleansingMap;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.Map;

public class PurefyingOilItem extends Item {
    public PurefyingOilItem(Properties properties) {
        super(properties);
    }

    private static final Map<Block, Block> CLENSING_MAP_TEMP = Map.of(
            Blocks.SCULK, Blocks.DIRT

    );

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        Block clickedblock = level.getBlockState(context.getClickedPos()).getBlock();
        Holder<Block> holder = clickedblock.defaultBlockState().getBlockHolder();
        PurifyingOilCleansingMap map = Blocks.SCULK.defaultBlockState().getBlockHolder().getData(ModDatamaps.BLOCK_CLEANSING);
        //System.out.println(map);

        if(!level.isClientSide && CLENSING_MAP_TEMP.containsKey(clickedblock)) {
            level.setBlockAndUpdate(context.getClickedPos(), CLENSING_MAP_TEMP.get(clickedblock).defaultBlockState());
            level.playSound(null, context.getClickedPos(), SoundEvents.ZOMBIE_VILLAGER_CURE, SoundSource.PLAYERS, 0.25f, 1f);
            level.addParticle(ParticleTypes.WAX_ON, context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), 1f, 1f, 1f);
        }

        return InteractionResult.SUCCESS;
    }

}
