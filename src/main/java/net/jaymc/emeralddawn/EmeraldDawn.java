package net.jaymc.emeralddawn;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.jaymc.emeralddawn.block.ModBlocks;
import net.jaymc.emeralddawn.enchantment.ModEnchantmentEffects;
import net.jaymc.emeralddawn.enchantment.ModEnchantments;
import net.jaymc.emeralddawn.item.ModItemGroups;
import net.jaymc.emeralddawn.item.ModItems;
import net.jaymc.emeralddawn.util.HammerUsageEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmeraldDawn implements ModInitializer {
	public static final String MOD_ID = "emeralddawn";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModEnchantmentEffects.registerEnchantmentEffects();

		PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());
	}
}