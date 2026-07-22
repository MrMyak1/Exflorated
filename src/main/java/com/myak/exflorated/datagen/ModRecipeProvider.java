package com.myak.exflorated.datagen;

import com.myak.exflorated.registries.BlockRegistry;
import com.myak.exflorated.registries.ItemRegistry;
import com.myak.exflorated.tag.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.Tags;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider);
    }

    @Override
    protected void buildRecipes(RecipeOutput output) {

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, BlockRegistry.CITRON_PLANKS, 4)
                .requires(ModTags.CITRON_LOGS)
                .unlockedBy("has_citron_logs", has(BlockRegistry.CITRON_LOG))
                .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockRegistry.CITRON_WOOD, 3)
                .pattern("AA")
                .pattern("AA")
                .define('A', BlockRegistry.CITRON_LOG)
                .unlockedBy("has_citron_logs", has(BlockRegistry.CITRON_LOG))
                .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockRegistry.CITRON_STRIPPED_WOOD, 3)
                .pattern("AA")
                .pattern("AA")
                .define('A', BlockRegistry.CITRON_STRIPPED_LOG)
                .unlockedBy("has_citron_logs", has(BlockRegistry.CITRON_LOG))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockRegistry.CITRON_SLAB, 6)
                .pattern("AAA")
                .define('A', BlockRegistry.CITRON_PLANKS)
                .unlockedBy("has_citron_logs", has(BlockRegistry.CITRON_LOG))
                .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockRegistry.CITRON_STAIRS, 4)
                .pattern("A  ")
                .pattern("AA ")
                .pattern("AAA")
                .define('A', BlockRegistry.CITRON_PLANKS)
                .unlockedBy("has_citron_logs", has(BlockRegistry.CITRON_LOG))
                .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockRegistry.CITRON_PRESSURE_PLATE, 1)
                .pattern("AA")
                .define('A', BlockRegistry.CITRON_PLANKS)
                .unlockedBy("has_citron_logs", has(BlockRegistry.CITRON_LOG))
                .save(output);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, BlockRegistry.CITRON_BUTTON, 1)
                .requires(BlockRegistry.CITRON_PLANKS)
                .unlockedBy("has_citron_logs", has(BlockRegistry.CITRON_LOG))
                .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockRegistry.CITRON_TRAPDOOR, 2)
                .pattern("AAA")
                .pattern("AAA")
                .define('A', BlockRegistry.CITRON_PLANKS)
                .unlockedBy("has_citron_logs", has(BlockRegistry.CITRON_LOG))
                .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockRegistry.CITRON_DOOR, 3)
                .pattern("AA")
                .pattern("AA")
                .pattern("AA")
                .define('A', BlockRegistry.CITRON_PLANKS)
                .unlockedBy("has_citron_logs", has(BlockRegistry.CITRON_LOG))
                .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockRegistry.CITRON_FENCE, 3)
                .pattern("ABA")
                .pattern("ABA")
                .define('A', BlockRegistry.CITRON_PLANKS)
                .define('B', Items.STICK)
                .unlockedBy("has_citron_logs", has(BlockRegistry.CITRON_LOG))
                .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockRegistry.CITRON_FENCE_GATE, 1)
                .pattern("BAB")
                .pattern("BAB")
                .define('A', BlockRegistry.CITRON_PLANKS)
                .define('B', Items.STICK)
                .unlockedBy("has_citron_logs", has(BlockRegistry.CITRON_LOG))
                .save(output);
//        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockRegistry.CITRON_SIGN, 1) - citron sign is indevelopment, as i am too stupid to understand blockentities
//                .pattern("AAA")
//                .pattern("AAA")
//                .pattern(" B ")
//                .define('A', BlockRegistry.CITRON_PLANKS)
//                .define('B', Items.STICK)
//                .unlockedBy("has_citron_logs", has(BlockRegistry.CITRON_LOG))
//                .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Items.OAK_BOAT, 1) //temp, should be replaced with "citron boat" when implemented
                .pattern("A A")
                .pattern("AAA")
                .define('A', BlockRegistry.CITRON_PLANKS)
                .unlockedBy("has_citron_logs", has(BlockRegistry.CITRON_LOG))
                .save(output);



        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ItemRegistry.GARLIC_BREAD, 2)
                .pattern("BAB")
                .define('A', ItemRegistry.SHALLOT)
                .define('B', Tags.Items.FOODS_BREAD)
                .unlockedBy("has_shallot", has(ItemRegistry.SHALLOT))
                .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemRegistry.PURIFYING_OIL, 1)
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .define('A', ItemRegistry.SHALLOT)
                .define('B', Items.GLASS_BOTTLE)
                .unlockedBy("has_shallot", has(ItemRegistry.SHALLOT))
                .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, Items.BREAD, 2)
                .pattern("BAB")
                .define('A', ItemRegistry.BOTTLE_OF_STRANGE_OOZE)
                .define('B', Items.WHEAT)
                .unlockedBy("has_ooze", has(ItemRegistry.BOTTLE_OF_STRANGE_OOZE))
                .save(output, ResourceLocation.fromNamespaceAndPath("exflorated", "bread").toString() + "_from_ooze");
    }
}
