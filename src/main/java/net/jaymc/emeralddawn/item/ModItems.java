package net.jaymc.emeralddawn.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.jaymc.emeralddawn.EmeraldDawn;
import net.jaymc.emeralddawn.item.custom.EmeraldWand;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item ETHERNAL_EMERALD = registerItem("ethernal_emerald", new Item(new Item.Settings()));

    public static final Item EMERALD_WAND = registerItem("emerald_wand",new EmeraldWand(new Item.Settings().maxDamage(32)));
    public static final Item EMERALD_APPLE = registerItem("emerald_apple",new Item(new Item.Settings().food(ModFoodComponents.EMERALD_APPLE)));
    public static final Item BLUE_BERRY = registerItem("blue_berry",new Item(new Item.Settings().food(ModFoodComponents.BLUE_BERRY)));

    public static final Item EMERALD_SWORD = registerItem("emerald_sword",
            new SwordItem(ModToolMaterials.ETHERNAL_EMERALD,new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.ETHERNAL_EMERALD,3,-2.0f))));
   public static final Item EMERALD_PICKAXE = registerItem("emerald_pickaxe",
            new PickaxeItem(ModToolMaterials.ETHERNAL_EMERALD,new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.ETHERNAL_EMERALD,1,-2.8f))));
   public static final Item EMERALD_SHOVEL= registerItem("emerald_shovel",
            new ShovelItem(ModToolMaterials.ETHERNAL_EMERALD,new Item.Settings()
                    .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.ETHERNAL_EMERALD,1.5f,-3.0f))));
   public static final Item EMERALD_AXE = registerItem("emerald_axe",
            new AxeItem(ModToolMaterials.ETHERNAL_EMERALD,new Item.Settings()
                    .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.ETHERNAL_EMERALD,6,-3.2f))));
   public static final Item EMERALD_HOE = registerItem("emerald_hoe",
            new HoeItem(ModToolMaterials.ETHERNAL_EMERALD,new Item.Settings()
                    .attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.ETHERNAL_EMERALD,0,-3.0f))));

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