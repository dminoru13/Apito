package net.notridani.apito.mixin;


import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.notridani.apito.effect.ModEffects;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static java.lang.Math.max;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {

    @Inject(method = "damage", at = @At("TAIL"))
    private void apito$lifesteal(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {

        if(!cir.getReturnValue()) return;

        Entity attackerEntity = source.getAttacker();

        if (!(attackerEntity instanceof LivingEntity attacker)) return;

        StatusEffectInstance effect = attacker.getStatusEffect(ModEffects.BLOODLUST);
        if( effect == null) return;

        attacker.heal(max(amount/3, 6));
    }
}
