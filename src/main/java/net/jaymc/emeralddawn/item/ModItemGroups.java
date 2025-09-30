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
                        entries.add(ModItems.EMERALD_WAND);
                        entries.add(ModBlocks.ETHERNAL_EMERALD_BLOCK);
                        entries.add(ModBlocks.MAGIC_BLOCK);
                        entries.add(ModItems.EMERALD_APPLE);
                        entries.add(ModItems.BLUE_BERRY);

                        entries.add(ModItems.EMERALD_PICKAXE);
                        entries.add(ModItems.EMERALD_AXE);
                        entries.add(ModItems.EMERALD_SWORD);
                        entries.add(ModItems.EMERALD_SHOVEL);
                        entries.add(ModItems.EMERALD_HOE);

                        entries.add(ModItems.EMERALD_HAMMER);

                        entries.add(ModItems.EMERALD_HELMET);
                        entries.add(ModItems.EMERALD_CHESTPLATE);
                        entries.add(ModItems.EMERALD_LEGGINGS);
                        entries.add(ModItems.EMERALD_BOOTS);

                        entries.add(ModItems.EMERALD_HORSE_ARMOR);

                        entries.add(ModItems.BAR_BRAWL_MUSIC_DISC);

                    }).build());


    public static void registerItemGroups(){
        EmeraldDawn.LOGGER.info("Registering Item Groups for "+ EmeraldDawn.MOD_ID);
    }
}
