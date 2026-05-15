package net.notridani.apito.mixin;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.notridani.apito.block.ModBlocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractBlock.AbstractBlockState.class)
public class FogNoAoMixin {

    @Inject(
            method = "getAmbientOcclusionLightLevel",
            at = @At("HEAD"),
            cancellable = true
    )
    private void apito$fogBrightness(CallbackInfoReturnable<Float> cir) {

        BlockState self = (BlockState)(Object)this;

        if (self.isOf(ModBlocks.FOG_BLOCK)) {
            cir.setReturnValue(1.0f);
        }
    }
}