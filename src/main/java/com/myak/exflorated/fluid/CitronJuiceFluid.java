package com.myak.exflorated.fluid;

import com.myak.exflorated.Exflorated;
import com.myak.exflorated.registries.BlockRegistry;
import com.myak.exflorated.registries.FluidRegistry;
import com.myak.exflorated.registries.ItemRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.fluids.FluidType;
import org.jetbrains.annotations.NotNull;

public abstract class CitronJuiceFluid extends FlowingFluid {

    @Override
    public Fluid getFlowing() {
        return FluidRegistry.CITRON_JUICE_FLOWING.get();
    }

    @Override
    public Fluid getSource() {
        return FluidRegistry.CITRON_JUICE_SOURCE.get();
    }

    @Override
    public Item getBucket() {
        return ItemRegistry.CITRON_JUICE_BUCKET.get();
    }

    @Override
    protected boolean canConvertToSource(Level level) {
        return true;
    }

    @Override
    protected void beforeDestroyingBlock(LevelAccessor levelAccessor, BlockPos blockPos, BlockState blockState) {
        BlockEntity blockentity = blockState.hasBlockEntity() ? levelAccessor.getBlockEntity(blockPos) : null;
        Block.dropResources(blockState, levelAccessor, blockPos, blockentity);
    }

    @Override
    protected int getSlopeFindDistance(LevelReader levelReader) {
        return 4;
    }

    @Override
    protected int getDropOff(LevelReader levelReader) {
        return 1;
    }

    @Override
    public int getAmount(FluidState fluidState) {
        return fluidState.getValue(LEVEL);
    }


    @Override
    protected boolean canBeReplacedWith(FluidState fluidState, BlockGetter blockGetter, BlockPos blockPos, Fluid fluid, Direction direction) {
        return false;
    }

    @Override
    public int getTickDelay(LevelReader levelReader) {
        return 5;
    }

    @Override
    protected float getExplosionResistance() {
        return 100.0f;
    }

    @Override
    protected BlockState createLegacyBlock(FluidState fluidState) {
        return BlockRegistry.CITRON_JUICE_BLOCK.get().defaultBlockState().setValue(BlockStateProperties.LEVEL, getLegacyLevel(fluidState));
    }


    @Override
    public @NotNull FluidType getFluidType() {
        return FluidRegistry.CITRON_JUICE_TYPE.get();
    }

    public boolean isSame(Fluid fluid) {
        return fluid == FluidRegistry.CITRON_JUICE_SOURCE.get() || fluid == FluidRegistry.CITRON_JUICE_FLOWING.get();
    }


    public static class Source extends CitronJuiceFluid {
        @Override
        public boolean isSource(FluidState fluidState) {
            return true;
        }
        @Override
        public int getAmount(FluidState fluidState) {
            return 8;
        }
    }
    public static class Flowing extends CitronJuiceFluid {
        @Override
        protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
            super.createFluidStateDefinition(builder);
            builder.add(LEVEL);
        }
        @Override
        public int getAmount(FluidState state) {
            return state.getValue(LEVEL);
        }

        @Override
        public boolean isSource(FluidState fluidState) {
            return false;
        }
    }
}
