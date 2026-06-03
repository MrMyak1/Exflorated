package com.myak.exflorated.worldgen.tree;

import com.myak.exflorated.Exflorated;
import com.myak.exflorated.worldgen.ModConfiguredFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class ModTreeGrower {
    public static final TreeGrower CITRON_TREE = new TreeGrower(Exflorated.MODID + ":citron", Optional.empty(), Optional.of(ModConfiguredFeatures.CITRON_KEY), Optional.empty());
}
