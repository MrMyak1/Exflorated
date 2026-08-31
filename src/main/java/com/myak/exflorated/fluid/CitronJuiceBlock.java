package com.myak.exflorated.fluid;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;

public class CitronJuiceBlock extends LiquidBlock {
    public CitronJuiceBlock(CitronJuiceFluid fluid) {
        super(fluid, BlockBehaviour.Properties.ofFullCopy(Blocks.WATER));
    }
}
