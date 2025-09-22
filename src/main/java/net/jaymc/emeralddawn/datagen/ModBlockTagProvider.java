package net.jaymc.emeralddawn.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.jaymc.emeralddawn.block.ModBlocks;
import net.jaymc.emeralddawn.util.ModTags;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.MAGIC_BLOCK);

        // Configure the inverse tag system - blocks that emerald tools CANNOT mine
        getOrCreateTagBuilder(ModTags.Blocks.INCORRECT_FOR_EMERALD_TOOL)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL);
                
        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.ETHERNAL_EMERALD_BLOCK);
    }
}
