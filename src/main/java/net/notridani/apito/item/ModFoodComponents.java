package net.notridani.apito.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.notridani.apito.effect.ModEffects;

public class ModFoodComponents {
    public static final FoodComponent RAW_GOLBO_LEG = new FoodComponent.Builder()
            .nutrition(2)
            .saturationModifier(0.25f)
            .statusEffect(new StatusEffectInstance(StatusEffects.UNLUCK, 500), 0.7f).build();

    public static final FoodComponent GOLBO_NUGGET = new FoodComponent.Builder()
            .nutrition(5)
            .saturationModifier(3.0f)
            .build();

    public static final FoodComponent SNAIL_BERRY = new FoodComponent.Builder()
            .nutrition(4)
            .saturationModifier(0.1f)
            .build();

    public static final FoodComponent VAMPIRIC_BERRY = new FoodComponent.Builder()
            .nutrition(1)
            .saturationModifier(0.1f)
            .statusEffect(new StatusEffectInstance(ModEffects.BLOODLUST, 200), 1)
            .build();
}
