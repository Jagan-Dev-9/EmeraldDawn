package net.jaymc.emeralddawn.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.jaymc.emeralddawn.EmeraldDawn;
import net.jaymc.emeralddawn.item.custom.EmeraldWand;
import net.jaymc.emeralddawn.item.custom.HammerItem;
import net.jaymc.emeralddawn.item.custom.ModArmorItem;
import net.jaymc.emeralddawn.sound.ModSounds;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlags;
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

    public static final Item EMERALD_HAMMER = registerItem("emerald_hammer",
            new HammerItem(ModToolMaterials.ETHERNAL_EMERALD,new Item.Settings()
                    .attributeModifiers(HammerItem.createAttributeModifiers(ModToolMaterials.ETHERNAL_EMERALD,7,-3.4f))));


    public static final Item EMERALD_HELMET = registerItem("emerald_helmet",
            new ModArmorItem(ModArmorMaterials.EMERALD_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings()
                    .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(15))));
    public static final Item EMERALD_CHESTPLATE = registerItem("emerald_chestplate",
            new ArmorItem(ModArmorMaterials.EMERALD_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings()
                    .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(15))));
    public static final Item EMERALD_LEGGINGS = registerItem("emerald_leggings",
            new ArmorItem(ModArmorMaterials.EMERALD_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(15))));
    public static final Item EMERALD_BOOTS = registerItem("emerald_boots",
            new ArmorItem(ModArmorMaterials.EMERALD_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(15))));

    public static final Item EMERALD_HORSE_ARMOR = registerItem("emerald_horse_armor",
            new AnimalArmorItem(ModArmorMaterials.EMERALD_ARMOR_MATERIAL, AnimalArmorItem.Type.EQUESTRIAN, false, new Item.Settings().maxCount(1)));
    public static final Item ETHERNAL_SMITHING_TEMPLATE = registerItem("ethernal_armor_trim_smithing_template",
            SmithingTemplateItem.of(Identifier.of(EmeraldDawn.MOD_ID, "ethernal"), FeatureFlags.VANILLA));
    public static final Item BAR_BRAWL_MUSIC_DISC = registerItem("bar_brawl_music_disc",
            new Item(new Item.Settings().jukeboxPlayable(ModSounds.BAR_BRAWL_KEY).maxCount(1)));

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