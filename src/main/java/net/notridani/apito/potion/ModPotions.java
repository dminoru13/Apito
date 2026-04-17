package net.notridani.apito.potion;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.notridani.apito.Apito;
import net.notridani.apito.effect.ModEffects;

public class ModPotions {
    public static final RegistryEntry<Potion> BLOODLUST_POTION = registerPotion("bloodlust_potion",
            new Potion(new StatusEffectInstance(ModEffects.BLOODLUST, 1200, 0)));


    private static RegistryEntry<Potion> registerPotion(String name, Potion potion) {
        return Registry.registerReference(Registries.POTION, Identifier.of(Apito.MOD_ID, name), potion);
    }

    public static void registerPotion() {
        Apito.LOGGER.info("Registering mod potions for " + Apito.MOD_ID);
    }
}
