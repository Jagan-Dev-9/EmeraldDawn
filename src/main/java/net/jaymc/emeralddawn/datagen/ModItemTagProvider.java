package net.jaymc.emeralddawn.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.jaymc.emeralddawn.item.ModItems;
import net.jaymc.emeralddawn.util.ModTags;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ModTags.Items.TRANSFORMABLE_ITEMS);
        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.EMERALD_SWORD);
        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.EMERALD_PICKAXE);
        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.EMERALD_AXE);
        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.EMERALD_SHOVEL);
        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.EMERALD_HOE);
    }
}
