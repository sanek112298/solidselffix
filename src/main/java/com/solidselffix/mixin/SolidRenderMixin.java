package com.solidselffix.mixin;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(RenderType.class)
public abstract class SolidRenderMixin {

    @Inject(
        method = "entityTranslucent(Lnet/minecraft/resources/ResourceLocation;)Lnet/minecraft/client/renderer/RenderType;",
        at = @At("HEAD"),
        cancellable = true
    )
    private static void solidselffix$entityTranslucent1(ResourceLocation location, CallbackInfoReturnable<RenderType> cir) {
        cir.setReturnValue(RenderType.entityCutoutNoCull(location));
    }

    @Inject(
        method = "entityTranslucent(Lnet/minecraft/resources/ResourceLocation;Z)Lnet/minecraft/client/renderer/RenderType;",
        at = @At("HEAD"),
        cancellable = true
    )
    private static void solidselffix$entityTranslucent2(ResourceLocation location, boolean outline, CallbackInfoReturnable<RenderType> cir) {
        cir.setReturnValue(RenderType.entityCutoutNoCull(location, outline));
    }

    @Inject(
        method = "entityTranslucentCull(Lnet/minecraft/resources/ResourceLocation;)Lnet/minecraft/client/renderer/RenderType;",
        at = @At("HEAD"),
        cancellable = true
    )
    private static void solidselffix$entityTranslucentCull(ResourceLocation location, CallbackInfoReturnable<RenderType> cir) {
        cir.setReturnValue(RenderType.entityCutoutNoCull(location));
    }

    @Inject(
        method = "itemEntityTranslucentCull(Lnet/minecraft/resources/ResourceLocation;)Lnet/minecraft/client/renderer/RenderType;",
        at = @At("HEAD"),
        cancellable = true
    )
    private static void solidselffix$itemEntityTranslucentCull(ResourceLocation location, CallbackInfoReturnable<RenderType> cir) {
        cir.setReturnValue(RenderType.entityCutoutNoCull(location));
    }
}
