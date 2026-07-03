package com.myak.exflorated.datagen;

import com.myak.exflorated.Exflorated;
import com.myak.exflorated.registries.BlockRegistry;
import com.myak.exflorated.registries.ItemRegistry;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Exflorated.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        saplingItem(BlockRegistry.CITRON_SAPLING);
        basicItem(ItemRegistry.SHALLOT.get());
        basicItem(ItemRegistry.CITRON.get());
        basicItem(ItemRegistry.PURIFYING_OIL.get());
        basicItem(ItemRegistry.GARLIC_BREAD.get());
        buttonItem(BlockRegistry.CITRON_BUTTON, BlockRegistry.CITRON_PLANKS);
        fenceItem(BlockRegistry.CITRON_FENCE, BlockRegistry.CITRON_PLANKS);
        basicItem(BlockRegistry.CITRON_DOOR.asItem());

    }

    private ItemModelBuilder saplingItem(DeferredBlock<Block> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(Exflorated.MODID, "block/" + item.getId().getPath()));
    }
    private ItemModelBuilder buttonItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        return  withExistingParent(block.getId().getPath(), mcLoc("block/button_inventory"))
                .texture("texture", ResourceLocation.fromNamespaceAndPath(Exflorated.MODID,
                        "block/" + baseBlock.getId().getPath()));
    }
    private ItemModelBuilder fenceItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        return  withExistingParent(block.getId().getPath(), mcLoc("block/fence_inventory"))
                .texture("texture", ResourceLocation.fromNamespaceAndPath(Exflorated.MODID,
                        "block/" + baseBlock.getId().getPath()));
    }
    

}
