package net.notridani.apito.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.notridani.apito.Apito;

public class ModEffects {
    private static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(Apito.MOD_ID, name), statusEffect);
    }

    public static void registerEffects() {
        Apito.LOGGER.info("Registring Mod Effects for " + Apito.MOD_ID);
    }


    public static final RegistryEntry<StatusEffect> BLOODLUST = registerStatusEffect("bloodlust",
            new BloodlustEffect(StatusEffectCategory.NEUTRAL, 0xdd3333));
}
