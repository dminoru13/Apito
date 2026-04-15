package net.notridani.apito.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent RAW_GOLBO_LEG = new FoodComponent.Builder()
            .nutrition(2)
            .saturationModifier(0.25f)
            .statusEffect(new StatusEffectInstance(StatusEffects.UNLUCK, 500), 0.7f).build();

    public static final FoodComponent GOLBO_NUGGET = new FoodComponent.Builder()
            .nutrition(5)
            .saturationModifier(3.0f)
            .build();
}
