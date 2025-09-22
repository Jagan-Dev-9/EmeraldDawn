package net.jaymc.emeralddawn.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.jaymc.emeralddawn.block.ModBlocks;
import net.jaymc.emeralddawn.item.ModItems;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
//        offer
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.EMERALD_APPLE)
                .pattern("RRR")
                .pattern("RAR")
                .pattern("RRR")
                .input('R', ModItems.ETHERNAL_EMERALD)
                .input('A', Items.APPLE)
                .criterion(hasItem(ModItems.ETHERNAL_EMERALD), conditionsFromItem(ModItems.ETHERNAL_EMERALD))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.EMERALD_WAND)
                .pattern(" ED")
                .pattern(" SE")
                .pattern("S  ")
                .input('S', Items.STICK)
                .input('E', Items.EMERALD)
                .input('D', Items.DIAMOND)
                .criterion(hasItem(ModItems.ETHERNAL_EMERALD), conditionsFromItem(ModItems.ETHERNAL_EMERALD))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.EMERALD_PICKAXE)
                .pattern("RRR")
                .pattern(" A ")
                .pattern(" A ")
                .input('R', ModItems.ETHERNAL_EMERALD)
                .input('A', Items.STICK)
                .criterion(hasItem(ModItems.ETHERNAL_EMERALD), conditionsFromItem(ModItems.ETHERNAL_EMERALD))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.EMERALD_AXE)
                .pattern(" RR")
                .pattern(" AR")
                .pattern(" A ")
                .input('R', ModItems.ETHERNAL_EMERALD)
                .input('A', Items.STICK)
                .criterion(hasItem(ModItems.ETHERNAL_EMERALD), conditionsFromItem(ModItems.ETHERNAL_EMERALD))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.EMERALD_SWORD)
                .pattern(" R ")
                .pattern(" R ")
                .pattern(" A ")
                .input('R', ModItems.ETHERNAL_EMERALD)
                .input('A', Items.STICK)
                .criterion(hasItem(ModItems.ETHERNAL_EMERALD), conditionsFromItem(ModItems.ETHERNAL_EMERALD))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.EMERALD_SHOVEL)
                .pattern(" R ")
                .pattern(" A ")
                .pattern(" A ")
                .input('R', ModItems.ETHERNAL_EMERALD)
                .input('A', Items.STICK)
                .criterion(hasItem(ModItems.ETHERNAL_EMERALD), conditionsFromItem(ModItems.ETHERNAL_EMERALD))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.EMERALD_HOE)
                .pattern(" RR")
                .pattern(" A ")
                .pattern(" A ")
                .input('R', ModItems.ETHERNAL_EMERALD)
                .input('A', Items.STICK)
                .criterion(hasItem(ModItems.ETHERNAL_EMERALD), conditionsFromItem(ModItems.ETHERNAL_EMERALD))
                .offerTo(exporter);
    }
}
