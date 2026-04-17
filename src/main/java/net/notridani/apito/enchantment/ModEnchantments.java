package net.notridani.apito.enchantment;

import com.mojang.serialization.MapCodec;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.notridani.apito.Apito;
import net.notridani.apito.enchantment.custom.LightningStrikerEnchantmentEffect;

public class ModEnchantments {
    public static final MapCodec<? extends EnchantmentEntityEffect> LIGHTNING_STRIKER =
            registerEntityEffect("lighting_striker", LightningStrikerEnchantmentEffect.CODEC);

    private static MapCodec<? extends EnchantmentEntityEffect> registerEntityEffect(String name,
                                                                                    MapCodec<?extends EnchantmentEntityEffect> codec) {
        return Registry.register(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, Identifier.of(Apito.MOD_ID, name), codec);
    }

    public static  void registerEnchantmentEffects() {
        Apito.LOGGER.info("Registering mod enchantmen effects for " + Apito.MOD_ID);
    }
}
