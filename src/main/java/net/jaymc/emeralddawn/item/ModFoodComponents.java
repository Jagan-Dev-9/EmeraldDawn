package net.jaymc.emeralddawn.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent BLUE_BERRY = new FoodComponent.Builder().nutrition(2).saturationModifier(0.25f)
            .statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 200),0.15f).build();
     public static final FoodComponent EMERALD_APPLE = new FoodComponent.Builder().nutrition(5).saturationModifier(0.5f)
            .statusEffect(new StatusEffectInstance(StatusEffects.LUCK, 2000),0.5f).build();

}
