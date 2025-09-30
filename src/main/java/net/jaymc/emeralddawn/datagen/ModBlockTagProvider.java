package net.jaymc.emeralddawn.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.jaymc.emeralddawn.block.ModBlocks;
import net.jaymc.emeralddawn.util.ModTags;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        
        configureModBlockTags();
        
        
        configureToolRequirements();
        
        
        configureMiningLevels();
        
        
        configureMaterialTypes();
        
        
        configureEmeraldToolTags();
        
        
        configureDecorativeTags();
        
        
        configureVanillaBlockPractice();
        
        configureAdditionalMiningTags();
        
        configureOreTags();
    }
    
    private void configureModBlockTags() {
        
        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.MAGIC_BLOCK);
        
        
        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.ETHERNAL_EMERALD_BLOCK);
        
        
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.MAGIC_BLOCK)
                .add(ModBlocks.ETHERNAL_EMERALD_BLOCK);
    }
    
    private void configureToolRequirements() {
        
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(Blocks.OBSIDIAN)          
                .add(Blocks.CRYING_OBSIDIAN)   
                .add(Blocks.ANCIENT_DEBRIS)    
                .add(Blocks.NETHERITE_BLOCK);  
        
        
        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(Blocks.MELON)             
                .add(Blocks.PUMPKIN)           
                .add(Blocks.MUSHROOM_STEM);    
        
        
        getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE)
                .add(Blocks.CLAY)              
                .add(Blocks.SOUL_SAND)         
                .add(Blocks.SOUL_SOIL);        
        
        
        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE)
                .add(Blocks.HAY_BLOCK)         
                .add(Blocks.DRIED_KELP_BLOCK)  
                .add(Blocks.SPONGE);           
    }
    
    private void configureMiningLevels() {
        
        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(Blocks.IRON_ORE)          
                .add(Blocks.IRON_BLOCK)        
                .add(Blocks.LAPIS_ORE)         
                .add(Blocks.LAPIS_BLOCK);      
        
        
        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(Blocks.GOLD_ORE)          
                .add(Blocks.GOLD_BLOCK)        
                .add(Blocks.DIAMOND_ORE)       
                .add(Blocks.EMERALD_ORE)       
                .add(Blocks.REDSTONE_ORE);     
        
        
        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(Blocks.OBSIDIAN)          
                .add(Blocks.CRYING_OBSIDIAN)   
                .add(Blocks.ANCIENT_DEBRIS)    
                .add(Blocks.RESPAWN_ANCHOR);   
    }
    
    private void configureEmeraldToolTags() {
        
        getOrCreateTagBuilder(ModTags.Blocks.INCORRECT_FOR_EMERALD_TOOL)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL)  
                .add(Blocks.BEDROCK)                   
                .add(Blocks.BARRIER)                   
                .add(Blocks.COMMAND_BLOCK)             
                .add(Blocks.STRUCTURE_BLOCK)           
                .add(Blocks.JIGSAW);                   
        
        // Configure what blocks need emerald tools to be mined properly
        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_EMERALD_TOOL)
                .add(ModBlocks.MAGIC_BLOCK)
                .addTag(BlockTags.NEEDS_IRON_TOOL);
        
    }
    
    private void configureMaterialTypes() {
        
        getOrCreateTagBuilder(BlockTags.STONE_ORE_REPLACEABLES)
                .add(Blocks.STONE)             
                .add(Blocks.GRANITE)           
                .add(Blocks.DIORITE)           
                .add(Blocks.ANDESITE);         
        
        
        getOrCreateTagBuilder(BlockTags.DEEPSLATE_ORE_REPLACEABLES)
                .add(Blocks.DEEPSLATE)         
                .add(Blocks.TUFF);             
        
        
        getOrCreateTagBuilder(BlockTags.BASE_STONE_OVERWORLD)
                .add(Blocks.STONE)             
                .add(Blocks.GRANITE)           
                .add(Blocks.DIORITE)           
                .add(Blocks.ANDESITE)          
                .add(Blocks.DEEPSLATE);        
    }

    private void configureDecorativeTags() {
        
        getOrCreateTagBuilder(BlockTags.BEACON_BASE_BLOCKS)
                .add(ModBlocks.ETHERNAL_EMERALD_BLOCK)  
                .add(Blocks.EMERALD_BLOCK);             
        
        
        getOrCreateTagBuilder(BlockTags.DRAGON_IMMUNE)
                .add(ModBlocks.MAGIC_BLOCK)             
                .add(Blocks.OBSIDIAN)                   
                .add(Blocks.CRYING_OBSIDIAN);           
        
        
        getOrCreateTagBuilder(BlockTags.WITHER_IMMUNE)
                .add(ModBlocks.MAGIC_BLOCK)             
                .add(Blocks.BEDROCK)                    
                .add(Blocks.BARRIER);                   
    }

    private void configureVanillaBlockPractice() {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(Blocks.COBBLESTONE)
                .add(Blocks.COBBLED_DEEPSLATE)
                .add(Blocks.BLACKSTONE)
                .add(Blocks.END_STONE);
        
        getOrCreateTagBuilder(BlockTags.LAVA_POOL_STONE_CANNOT_REPLACE)
                .add(Blocks.BEDROCK)
                .add(Blocks.SPAWNER)
                .add(Blocks.CHEST)
                .add(Blocks.ENDER_CHEST);
        
        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .add(Blocks.OAK_LOG)
                .add(Blocks.BIRCH_LOG)
                .add(Blocks.SPRUCE_LOG)
                .add(Blocks.JUNGLE_LOG);
        
        getOrCreateTagBuilder(BlockTags.PREVENT_MOB_SPAWNING_INSIDE)
                .add(Blocks.RAIL)
                .add(Blocks.POWERED_RAIL)
                .add(Blocks.DETECTOR_RAIL)
                .add(Blocks.ACTIVATOR_RAIL);
    }
    
    private void configureAdditionalMiningTags() {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(Blocks.COAL_ORE)
                .add(Blocks.DEEPSLATE_COAL_ORE)
                .add(Blocks.COPPER_ORE)
                .add(Blocks.DEEPSLATE_COPPER_ORE)
                .add(Blocks.COAL_BLOCK)
                .add(Blocks.COPPER_BLOCK)
                .add(Blocks.CUT_COPPER)
                .add(Blocks.EXPOSED_COPPER)
                .add(Blocks.WEATHERED_COPPER)
                .add(Blocks.OXIDIZED_COPPER);
        
        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(Blocks.BAMBOO)
                .add(Blocks.BAMBOO_PLANKS)
                .add(Blocks.BAMBOO_MOSAIC)
                .add(Blocks.CHERRY_PLANKS)
                .add(Blocks.MANGROVE_PLANKS)
                .add(Blocks.CRIMSON_PLANKS)
                .add(Blocks.WARPED_PLANKS)
                .add(Blocks.BOOKSHELF)
                .add(Blocks.CHISELED_BOOKSHELF)
                .add(Blocks.LECTERN);
        
        getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE)
                .add(Blocks.DIRT)
                .add(Blocks.COARSE_DIRT)
                .add(Blocks.PODZOL)
                .add(Blocks.ROOTED_DIRT)
                .add(Blocks.MUD)
                .add(Blocks.MUDDY_MANGROVE_ROOTS)
                .add(Blocks.SAND)
                .add(Blocks.RED_SAND)
                .add(Blocks.GRAVEL)
                .add(Blocks.SUSPICIOUS_SAND);
        
        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE)
                .add(Blocks.MOSS_BLOCK)
                .add(Blocks.MOSS_CARPET)
                .add(Blocks.AZALEA_LEAVES)
                .add(Blocks.FLOWERING_AZALEA_LEAVES)
                .add(Blocks.MANGROVE_LEAVES)
                .add(Blocks.CHERRY_LEAVES)
                .add(Blocks.SCULK)
                .add(Blocks.SCULK_CATALYST)
                .add(Blocks.SCULK_SENSOR)
                .add(Blocks.SCULK_SHRIEKER);
    }
    
    private void configureOreTags() {
        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(Blocks.COPPER_ORE)
                .add(Blocks.DEEPSLATE_COPPER_ORE)
                .add(Blocks.COAL_ORE)
                .add(Blocks.DEEPSLATE_COAL_ORE)
                .add(Blocks.COPPER_BLOCK)
                .add(Blocks.CUT_COPPER)
                .add(Blocks.EXPOSED_COPPER)
                .add(Blocks.WEATHERED_COPPER)
                .add(Blocks.OXIDIZED_COPPER)
                .add(Blocks.WAXED_COPPER_BLOCK);
        
        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(Blocks.DEEPSLATE_GOLD_ORE)
                .add(Blocks.DEEPSLATE_DIAMOND_ORE)
                .add(Blocks.DEEPSLATE_EMERALD_ORE)
                .add(Blocks.DEEPSLATE_REDSTONE_ORE)
                .add(Blocks.DEEPSLATE_LAPIS_ORE)
                .add(Blocks.NETHER_GOLD_ORE)
                .add(Blocks.NETHER_QUARTZ_ORE)
                .add(Blocks.DIAMOND_BLOCK)
                .add(Blocks.EMERALD_BLOCK)
                .add(Blocks.REDSTONE_BLOCK);
        
        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(Blocks.NETHERITE_BLOCK)
                .add(Blocks.REINFORCED_DEEPSLATE)
                .add(Blocks.CRYING_OBSIDIAN)
                .add(Blocks.LODESTONE)
                .add(Blocks.ENCHANTING_TABLE)
                .add(Blocks.ENDER_CHEST)
                .add(Blocks.ANVIL)
                .add(Blocks.CHIPPED_ANVIL)
                .add(Blocks.DAMAGED_ANVIL)
                .add(Blocks.BEACON);
        
        // Beginning with 1.20 ore tags

        // ==========================================
                // EXTENSIVE VANILLA BLOCK COMPATIBILITY TAGS
                // ==========================================

                // Advanced Stone Variants for Emerald Tools
                getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                        .add(Blocks.STONE)
                        .add(Blocks.COBBLESTONE)
                        .add(Blocks.MOSSY_COBBLESTONE)
                        .add(Blocks.SMOOTH_STONE)
                        .add(Blocks.STONE_BRICKS)
                        .add(Blocks.MOSSY_STONE_BRICKS)
                        .add(Blocks.CRACKED_STONE_BRICKS)
                        .add(Blocks.CHISELED_STONE_BRICKS)
                        .add(Blocks.GRANITE)
                        .add(Blocks.POLISHED_GRANITE)
                        .add(Blocks.DIORITE)
                        .add(Blocks.POLISHED_DIORITE)
                        .add(Blocks.ANDESITE)
                        .add(Blocks.POLISHED_ANDESITE)
                        .add(Blocks.DEEPSLATE)
                        .add(Blocks.COBBLED_DEEPSLATE)
                        .add(Blocks.POLISHED_DEEPSLATE)
                        .add(Blocks.DEEPSLATE_BRICKS)
                        .add(Blocks.CRACKED_DEEPSLATE_BRICKS)
                        .add(Blocks.DEEPSLATE_TILES)
                        .add(Blocks.CRACKED_DEEPSLATE_TILES)
                        .add(Blocks.CHISELED_DEEPSLATE)
                        .add(Blocks.CALCITE)
                        .add(Blocks.TUFF)
                        .add(Blocks.DRIPSTONE_BLOCK)
                        .add(Blocks.SANDSTONE)
                        .add(Blocks.CHISELED_SANDSTONE)
                        .add(Blocks.CUT_SANDSTONE)
                        .add(Blocks.SMOOTH_SANDSTONE)
                        .add(Blocks.RED_SANDSTONE)
                        .add(Blocks.CHISELED_RED_SANDSTONE)
                        .add(Blocks.CUT_RED_SANDSTONE)
                        .add(Blocks.SMOOTH_RED_SANDSTONE)
                        .add(Blocks.BLACKSTONE)
                        .add(Blocks.POLISHED_BLACKSTONE)
                        .add(Blocks.POLISHED_BLACKSTONE_BRICKS)
                        .add(Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS)
                        .add(Blocks.CHISELED_POLISHED_BLACKSTONE)
                        .add(Blocks.GILDED_BLACKSTONE)
                        .add(Blocks.BASALT)
                        .add(Blocks.POLISHED_BASALT)
                        .add(Blocks.SMOOTH_BASALT)
                        .add(Blocks.TERRACOTTA)
                        .add(Blocks.WHITE_TERRACOTTA)
                        .add(Blocks.ORANGE_TERRACOTTA)
                        .add(Blocks.MAGENTA_TERRACOTTA)
                        .add(Blocks.LIGHT_BLUE_TERRACOTTA)
                        .add(Blocks.YELLOW_TERRACOTTA)
                        .add(Blocks.LIME_TERRACOTTA)
                        .add(Blocks.PINK_TERRACOTTA)
                        .add(Blocks.GRAY_TERRACOTTA)
                        .add(Blocks.LIGHT_GRAY_TERRACOTTA)
                        .add(Blocks.CYAN_TERRACOTTA)
                        .add(Blocks.PURPLE_TERRACOTTA)
                        .add(Blocks.BLUE_TERRACOTTA)
                        .add(Blocks.BROWN_TERRACOTTA)
                        .add(Blocks.GREEN_TERRACOTTA)
                        .add(Blocks.RED_TERRACOTTA)
                        .add(Blocks.BLACK_TERRACOTTA)
                        .add(Blocks.WHITE_GLAZED_TERRACOTTA)
                        .add(Blocks.ORANGE_GLAZED_TERRACOTTA)
                        .add(Blocks.MAGENTA_GLAZED_TERRACOTTA)
                        .add(Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA)
                        .add(Blocks.YELLOW_GLAZED_TERRACOTTA)
                        .add(Blocks.LIME_GLAZED_TERRACOTTA)
                        .add(Blocks.PINK_GLAZED_TERRACOTTA)
                        .add(Blocks.GRAY_GLAZED_TERRACOTTA)
                        .add(Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA)
                        .add(Blocks.CYAN_GLAZED_TERRACOTTA)
                        .add(Blocks.PURPLE_GLAZED_TERRACOTTA)
                        .add(Blocks.BLUE_GLAZED_TERRACOTTA)
                        .add(Blocks.BROWN_GLAZED_TERRACOTTA)
                        .add(Blocks.GREEN_GLAZED_TERRACOTTA)
                        .add(Blocks.RED_GLAZED_TERRACOTTA)
                        .add(Blocks.BLACK_GLAZED_TERRACOTTA);

                        // Comprehensive Concrete Variants
                getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                        .add(Blocks.WHITE_CONCRETE)
                        .add(Blocks.ORANGE_CONCRETE)
                        .add(Blocks.MAGENTA_CONCRETE)
                        .add(Blocks.LIGHT_BLUE_CONCRETE)
                        .add(Blocks.YELLOW_CONCRETE)
                        .add(Blocks.LIME_CONCRETE)
                        .add(Blocks.PINK_CONCRETE)
                        .add(Blocks.GRAY_CONCRETE)
                        .add(Blocks.LIGHT_GRAY_CONCRETE)
                        .add(Blocks.CYAN_CONCRETE)
                        .add(Blocks.PURPLE_CONCRETE)
                        .add(Blocks.BLUE_CONCRETE)
                        .add(Blocks.BROWN_CONCRETE)
                        .add(Blocks.GREEN_CONCRETE)
                        .add(Blocks.RED_CONCRETE)
                        .add(Blocks.BLACK_CONCRETE)
                        .add(Blocks.WHITE_CONCRETE_POWDER)
                        .add(Blocks.ORANGE_CONCRETE_POWDER);
    }
}
