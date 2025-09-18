package net.jaymc.emeralddawn.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.jaymc.emeralddawn.EmeraldDawn;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item ETHERNAL_EMERALD = registerItem("ethernal_emerald", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(EmeraldDawn.MOD_ID, name), item);
    }

    public static void registerModItems() {
        EmeraldDawn.LOGGER.info("Registering Mod Items for " + EmeraldDawn.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(ETHERNAL_EMERALD);
        });
    }
}