package com.myak.exflorated.item;

import com.myak.exflorated.datamaps.ModDatamaps;
import com.myak.exflorated.datamaps.PurifyingOilCleansingMap;
import com.myak.exflorated.registries.BlockRegistry;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;

import java.util.Map;

public class PurifyingOilItem extends Item {
    public PurifyingOilItem(Properties properties) {
        super(properties);
    }

    private static final Map<Block, Block> CLENSING_MAP_TEMP = Map.of(
            Blocks.SCULK, Blocks.DIRT,
            BlockRegistry.REINFORCED_SCULK.get(), Blocks.BONE_BLOCK

    );

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        Block clickedblock = level.getBlockState(context.getClickedPos()).getBlock();
        Player player = context.getPlayer();
        Holder<Block> holder = clickedblock.defaultBlockState().getBlockHolder();
        PurifyingOilCleansingMap map = Blocks.SCULK.defaultBlockState().getBlockHolder().getData(ModDatamaps.BLOCK_CLEANSING);
        //System.out.println(map);

        if(CLENSING_MAP_TEMP.containsKey(clickedblock)) {
            if (level.isClientSide) {
                Vec3 offset = context.getClickedPos().getCenter().offsetRandom(player.getRandom(), 2f);
                level.addParticle(ParticleTypes.WAX_OFF, offset.x, offset.y, offset.z, 1f, 1f, 1f);
            } else {
                level.setBlockAndUpdate(context.getClickedPos(), CLENSING_MAP_TEMP.get(clickedblock).defaultBlockState());
                level.playSound(null, context.getClickedPos(), SoundEvents.ZOMBIE_VILLAGER_CURE, SoundSource.PLAYERS, 0.25f, 1f);
            }
        }

        return InteractionResult.SUCCESS;
    }

}
