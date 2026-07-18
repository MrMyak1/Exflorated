package com.myak.exflorated.block;

import com.myak.exflorated.registries.ItemRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

public class ShrineMechanismBlock extends Block {
    public ShrineMechanismBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected @NotNull ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (!level.isClientSide && stack.getItem() == Items.GLASS_BOTTLE) {
            stack.consume(1, player);
            player.addItem(new ItemStack(ItemRegistry.BOTTLE_OF_STRANGE_OOZE.get(), 1));
            level.playSound(null, pos, SoundEvents.BOTTLE_FILL, SoundSource.PLAYERS, 1f, 1f);
        }

        return super.useItemOn(stack, state, level, pos, player, hand, hitResult);
    }
}
