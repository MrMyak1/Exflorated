package com.myak.exflorated.registries;

import com.myak.exflorated.Exflorated;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class CreativeTabRegistry {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MOD_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Exflorated.MODID);

    public static final Supplier<CreativeModeTab> EXFLORATED_TAB = CREATIVE_MOD_TAB.register("exflorated_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ItemRegistry.CITRON.get()))
                    .title(Component.translatable("creativetab.exflorated.exflorated_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ItemRegistry.CITRON);

                        output.accept(BlockRegistry.CITRON_SAPLING);
                        output.accept(BlockRegistry.CITRON_LEAVES);
                        output.accept(BlockRegistry.CITRON_LOG);
                        output.accept(BlockRegistry.CITRON_STRIPPED_LOG);
                        output.accept(BlockRegistry.CITRON_WOOD);
                        output.accept(BlockRegistry.CITRON_STRIPPED_WOOD);
                        output.accept(BlockRegistry.CITRON_PLANKS);
                        output.accept(BlockRegistry.CITRON_SLAB);
                        output.accept(BlockRegistry.CITRON_STAIRS);
                        output.accept(BlockRegistry.CITRON_FENCE);
                        output.accept(BlockRegistry.CITRON_FENCE_GATE);
                        output.accept(BlockRegistry.CITRON_DOOR);
                        output.accept(BlockRegistry.CITRON_TRAPDOOR);
                        output.accept(BlockRegistry.CITRON_BUTTON);
                        output.accept(BlockRegistry.CITRON_PRESSURE_PLATE);
                        output.accept(BlockRegistry.CITRON_SAPLING);
                        output.accept(ItemRegistry.SHALLOT);
                        output.accept(ItemRegistry.PURIFYING_OIL);
                        output.accept(ItemRegistry.GARLIC_BREAD);
                    })
                            .build());
}
