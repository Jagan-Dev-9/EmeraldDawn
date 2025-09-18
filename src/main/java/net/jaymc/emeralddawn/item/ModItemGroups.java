package net.jaymc.emeralddawn.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.jaymc.emeralddawn.EmeraldDawn;
import net.jaymc.emeralddawn.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup EMERALDDAWN_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(EmeraldDawn.MOD_ID,"emeralddawn_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.ETHERNAL_EMERALD))
                    .displayName(Text.translatable("itemgroup.emeralddawn.emeralddawn_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.ETHERNAL_EMERALD);
                        entries.add(ModBlocks.ETHERNAL_EMERALD_BLOCK);

                    }).build());


    public static void registerItemGroups(){
        EmeraldDawn.LOGGER.info("Registering Item Groups for "+ EmeraldDawn.MOD_ID);
    }
}
