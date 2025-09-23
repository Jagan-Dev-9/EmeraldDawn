package net.jaymc.emeralddawn.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.jaymc.emeralddawn.block.ModBlocks;
import net.jaymc.emeralddawn.item.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.data.server.recipe.SmeltingRecipeJsonBuilder;
import net.minecraft.data.server.recipe.BlastingRecipeJsonBuilder;
import net.minecraft.data.server.recipe.CookingRecipeJsonBuilder;
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
        generateModRecipes(exporter);
        generateBlockRecipes(exporter);
        generateSmeltingRecipes(exporter);
        generateAlternativeRecipes(exporter);
        generatePracticeRecipes(exporter);
        generateConversionRecipes(exporter);
        generateDecorationRecipes(exporter);
        generateUtilityRecipes(exporter);
    }
    
    private void generateModRecipes(RecipeExporter exporter) {
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
    }
    
    private void generateToolRecipes(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.EMERALD_PICKAXE)
                .pattern("RRR")
                .pattern(" A ")
                .pattern(" A ")
                .input('R', ModItems.ETHERNAL_EMERALD)
                .input('A', Items.STICK)
                .criterion(hasItem(ModItems.ETHERNAL_EMERALD), conditionsFromItem(ModItems.ETHERNAL_EMERALD))
                .offerTo(exporter);
        
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.EMERALD_AXE)
                .pattern(" RR")
                .pattern(" AR")
                .pattern(" A ")
                .input('R', ModItems.ETHERNAL_EMERALD)
                .input('A', Items.STICK)
                .criterion(hasItem(ModItems.ETHERNAL_EMERALD), conditionsFromItem(ModItems.ETHERNAL_EMERALD))
                .offerTo(exporter);
        
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.EMERALD_SWORD)
                .pattern(" R ")
                .pattern(" R ")
                .pattern(" A ")
                .input('R', ModItems.ETHERNAL_EMERALD)
                .input('A', Items.STICK)
                .criterion(hasItem(ModItems.ETHERNAL_EMERALD), conditionsFromItem(ModItems.ETHERNAL_EMERALD))
                .offerTo(exporter);
        
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.EMERALD_SHOVEL)
                .pattern(" R ")
                .pattern(" A ")
                .pattern(" A ")
                .input('R', ModItems.ETHERNAL_EMERALD)
                .input('A', Items.STICK)
                .criterion(hasItem(ModItems.ETHERNAL_EMERALD), conditionsFromItem(ModItems.ETHERNAL_EMERALD))
                .offerTo(exporter);
        
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.EMERALD_HOE)
                .pattern(" RR")
                .pattern(" A ")
                .pattern(" A ")
                .input('R', ModItems.ETHERNAL_EMERALD)
                .input('A', Items.STICK)
                .criterion(hasItem(ModItems.ETHERNAL_EMERALD), conditionsFromItem(ModItems.ETHERNAL_EMERALD))
                .offerTo(exporter);
    }
    
    private void generateBlockRecipes(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ETHERNAL_EMERALD_BLOCK)
                .pattern("RRR")
                .pattern("RRR")
                .pattern("RRR")
                .input('R', ModItems.ETHERNAL_EMERALD)
                .criterion(hasItem(ModItems.ETHERNAL_EMERALD), conditionsFromItem(ModItems.ETHERNAL_EMERALD))
                .offerTo(exporter);
        
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ETHERNAL_EMERALD, 9)
                .input(ModBlocks.ETHERNAL_EMERALD_BLOCK)
                .criterion(hasItem(ModBlocks.ETHERNAL_EMERALD_BLOCK), conditionsFromItem(ModBlocks.ETHERNAL_EMERALD_BLOCK))
                .offerTo(exporter, "ethernal_emerald_from_block");
        
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.MAGIC_BLOCK)
                .pattern("OEO")
                .pattern("ERE")
                .pattern("OEO")
                .input('E', ModItems.ETHERNAL_EMERALD)
                .input('R', Items.REDSTONE)
                .input('O', Blocks.OBSIDIAN)
                .criterion(hasItem(ModItems.ETHERNAL_EMERALD), conditionsFromItem(ModItems.ETHERNAL_EMERALD))
                .offerTo(exporter);
    }
    
    private void generateSmeltingRecipes(RecipeExporter exporter) {
        SmeltingRecipeJsonBuilder.create(
                Items.EMERALD,
                RecipeCategory.MISC,
                ModItems.ETHERNAL_EMERALD,
                0.7f,
                200)
                .criterion(hasItem(Items.EMERALD), conditionsFromItem(Items.EMERALD))
                .offerTo(exporter, "ethernal_emerald_from_smelting");
        
        BlastingRecipeJsonBuilder.create(
                Items.EMERALD,
                RecipeCategory.MISC,
                ModItems.ETHERNAL_EMERALD,
                0.7f,
                100)
                .criterion(hasItem(Items.EMERALD), conditionsFromItem(Items.EMERALD))
                .offerTo(exporter, "ethernal_emerald_from_blasting");
        
        SmeltingRecipeJsonBuilder.create(
                Items.IRON_INGOT,
                RecipeCategory.MISC,
                Items.GOLD_INGOT,
                0.5f,
                200)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter, "gold_from_iron_smelting");
        
        BlastingRecipeJsonBuilder.create(
                Items.COPPER_INGOT,
                RecipeCategory.MISC,
                Items.IRON_INGOT,
                0.5f,
                100)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(exporter, "iron_from_copper_blasting");
    }
    
    private void generateAlternativeRecipes(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.EMERALD_AXE)
                .pattern("RR ")
                .pattern("RA ")
                .pattern(" A ")
                .input('R', ModItems.ETHERNAL_EMERALD)
                .input('A', Items.STICK)
                .criterion(hasItem(ModItems.ETHERNAL_EMERALD), conditionsFromItem(ModItems.ETHERNAL_EMERALD))
                .offerTo(exporter, "emerald_axe_alt");
        
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.EMERALD_HOE)
                .pattern("RR ")
                .pattern(" A ")
                .pattern(" A ")
                .input('R', ModItems.ETHERNAL_EMERALD)
                .input('A', Items.STICK)
                .criterion(hasItem(ModItems.ETHERNAL_EMERALD), conditionsFromItem(ModItems.ETHERNAL_EMERALD))
                .offerTo(exporter, "emerald_hoe_alt");
        
        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.EMERALD_APPLE)
                .input(Items.APPLE)
                .input(ModItems.ETHERNAL_EMERALD)
                .input(ModItems.ETHERNAL_EMERALD)
                .input(ModItems.ETHERNAL_EMERALD)
                .input(ModItems.ETHERNAL_EMERALD)
                .criterion(hasItem(ModItems.ETHERNAL_EMERALD), conditionsFromItem(ModItems.ETHERNAL_EMERALD))
                .offerTo(exporter, "emerald_apple_simple");
    }
    
    private void generatePracticeRecipes(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.DIAMOND_BLOCK)
                .pattern("DDD")
                .pattern("DDD")
                .pattern("DDD")
                .input('D', Items.DIAMOND)
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .offerTo(exporter, "diamond_block_practice");
        
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.DIAMOND, 9)
                .input(Blocks.DIAMOND_BLOCK)
                .criterion(hasItem(Blocks.DIAMOND_BLOCK), conditionsFromItem(Blocks.DIAMOND_BLOCK))
                .offerTo(exporter, "diamond_from_block_practice");
        
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.EMERALD_BLOCK)
                .pattern("EEE")
                .pattern("EEE")
                .pattern("EEE")
                .input('E', Items.EMERALD)
                .criterion(hasItem(Items.EMERALD), conditionsFromItem(Items.EMERALD))
                .offerTo(exporter, "emerald_block_practice");
        
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.EMERALD, 9)
                .input(Blocks.EMERALD_BLOCK)
                .criterion(hasItem(Blocks.EMERALD_BLOCK), conditionsFromItem(Blocks.EMERALD_BLOCK))
                .offerTo(exporter, "emerald_from_block_practice");
        
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.GOLD_BLOCK)
                .pattern("GGG")
                .pattern("GGG")
                .pattern("GGG")
                .input('G', Items.GOLD_INGOT)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .offerTo(exporter, "gold_block_practice");
        
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.GOLD_INGOT, 9)
                .input(Blocks.GOLD_BLOCK)
                .criterion(hasItem(Blocks.GOLD_BLOCK), conditionsFromItem(Blocks.GOLD_BLOCK))
                .offerTo(exporter, "gold_from_block_practice");
    }
    
    private void generateConversionRecipes(RecipeExporter exporter) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.COAL, 4)
                .input(Blocks.COAL_BLOCK)
                .criterion(hasItem(Blocks.COAL_BLOCK), conditionsFromItem(Blocks.COAL_BLOCK))
                .offerTo(exporter, "coal_from_block_conversion");
        
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.COAL_BLOCK)
                .pattern("CC")
                .pattern("CC")
                .input('C', Items.COAL)
                .criterion(hasItem(Items.COAL), conditionsFromItem(Items.COAL))
                .offerTo(exporter, "coal_block_conversion");
        
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.REDSTONE, 4)
                .input(Blocks.REDSTONE_BLOCK)
                .criterion(hasItem(Blocks.REDSTONE_BLOCK), conditionsFromItem(Blocks.REDSTONE_BLOCK))
                .offerTo(exporter, "redstone_from_block_conversion");
        
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, Blocks.REDSTONE_BLOCK)
                .pattern("RRR")
                .pattern("RRR")
                .pattern("RRR")
                .input('R', Items.REDSTONE)
                .criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
                .offerTo(exporter, "redstone_block_conversion");
        
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.LAPIS_LAZULI, 9)
                .input(Blocks.LAPIS_BLOCK)
                .criterion(hasItem(Blocks.LAPIS_BLOCK), conditionsFromItem(Blocks.LAPIS_BLOCK))
                .offerTo(exporter, "lapis_from_block_conversion");
        
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.LAPIS_BLOCK)
                .pattern("LLL")
                .pattern("LLL")
                .pattern("LLL")
                .input('L', Items.LAPIS_LAZULI)
                .criterion(hasItem(Items.LAPIS_LAZULI), conditionsFromItem(Items.LAPIS_LAZULI))
                .offerTo(exporter, "lapis_block_conversion");
    }
    
    private void generateDecorationRecipes(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, Blocks.CHISELED_STONE_BRICKS)
                .pattern("S")
                .pattern("S")
                .input('S', Blocks.STONE_BRICK_SLAB)
                .criterion(hasItem(Blocks.STONE_BRICK_SLAB), conditionsFromItem(Blocks.STONE_BRICK_SLAB))
                .offerTo(exporter, "chiseled_stone_bricks_decoration");
        
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, Blocks.MOSSY_STONE_BRICKS, 4)
                .pattern("SS")
                .pattern("SS")
                .input('S', Blocks.STONE_BRICKS)
                .criterion(hasItem(Blocks.STONE_BRICKS), conditionsFromItem(Blocks.STONE_BRICKS))
                .offerTo(exporter, "mossy_stone_bricks_decoration");
        
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, Blocks.CRACKED_STONE_BRICKS, 2)
                .pattern("S")
                .pattern("S")
                .input('S', Blocks.STONE_BRICKS)
                .criterion(hasItem(Blocks.STONE_BRICKS), conditionsFromItem(Blocks.STONE_BRICKS))
                .offerTo(exporter, "cracked_stone_bricks_decoration");
        
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, Blocks.POLISHED_GRANITE, 4)
                .pattern("GG")
                .pattern("GG")
                .input('G', Blocks.GRANITE)
                .criterion(hasItem(Blocks.GRANITE), conditionsFromItem(Blocks.GRANITE))
                .offerTo(exporter, "polished_granite_decoration");
        
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, Blocks.POLISHED_DIORITE, 4)
                .pattern("DD")
                .pattern("DD")
                .input('D', Blocks.DIORITE)
                .criterion(hasItem(Blocks.DIORITE), conditionsFromItem(Blocks.DIORITE))
                .offerTo(exporter, "polished_diorite_decoration");
        
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, Blocks.POLISHED_ANDESITE, 4)
                .pattern("AA")
                .pattern("AA")
                .input('A', Blocks.ANDESITE)
                .criterion(hasItem(Blocks.ANDESITE), conditionsFromItem(Blocks.ANDESITE))
                .offerTo(exporter, "polished_andesite_decoration");
    }
    
    private void generateUtilityRecipes(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, Blocks.OBSERVER)
                .pattern("CCC")
                .pattern("RRQ")
                .pattern("CCC")
                .input('C', Blocks.COBBLESTONE)
                .input('R', Items.REDSTONE)
                .input('Q', Items.QUARTZ)
                .criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
                .offerTo(exporter, "observer_utility");
        
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, Blocks.PISTON)
                .pattern("PPP")
                .pattern("CIC")
                .pattern("CRC")
                .input('P', Blocks.OAK_PLANKS)
                .input('C', Blocks.COBBLESTONE)
                .input('I', Items.IRON_INGOT)
                .input('R', Items.REDSTONE)
                .criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
                .offerTo(exporter, "piston_utility");
        
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, Blocks.STICKY_PISTON)
                .pattern("S")
                .pattern("P")
                .input('S', Items.SLIME_BALL)
                .input('P', Blocks.PISTON)
                .criterion(hasItem(Blocks.PISTON), conditionsFromItem(Blocks.PISTON))
                .offerTo(exporter, "sticky_piston_utility");
        
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Blocks.CRAFTING_TABLE)
                .pattern("PP")
                .pattern("PP")
                .input('P', Blocks.OAK_PLANKS)
                .criterion(hasItem(Blocks.OAK_PLANKS), conditionsFromItem(Blocks.OAK_PLANKS))
                .offerTo(exporter, "crafting_table_utility");
        
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, Blocks.FURNACE)
                .pattern("CCC")
                .pattern("C C")
                .pattern("CCC")
                .input('C', Blocks.COBBLESTONE)
                .criterion(hasItem(Blocks.COBBLESTONE), conditionsFromItem(Blocks.COBBLESTONE))
                .offerTo(exporter, "furnace_utility");
        
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, Blocks.CHEST)
                .pattern("PPP")
                .pattern("P P")
                .pattern("PPP")
                .input('P', Blocks.OAK_PLANKS)
                .criterion(hasItem(Blocks.OAK_PLANKS), conditionsFromItem(Blocks.OAK_PLANKS))
                .offerTo(exporter, "chest_utility");
    }
}
