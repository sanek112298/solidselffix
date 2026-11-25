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
    private static void solidselffix$makeEntityTranslucentSolid(ResourceLocation location, CallbackInfoReturnable<RenderType> cir) {
        cir.setReturnValue(RenderType.entityCutoutNoCull(location));
    }

    @Inject(
        method = "entityTranslucent(Lnet/minecraft/resources/ResourceLocation;Z)Lnet/minecraft/client/renderer/RenderType;",
        at = @At("HEAD"),
        cancellable = true
    )
    private static void solidselffix$makeEntityTranslucentOutlineSolid(ResourceLocation location, boolean outline, CallbackInfoReturnable<RenderType> cir) {
        cir.setReturnValue(RenderType.entityCutoutNoCull(location, outline));
    }

    @Inject(
        method = "itemEntityTranslucentCull(Lnet/minecraft/resources/ResourceLocation;)Lnet/minecraft/client/renderer/RenderType;",
        at = @At("HEAD"),
        cancellable = true
    )
    private static void solidselffix$makeItemEntitySolid(ResourceLocation location, CallbackInfoReturnable<RenderType> cir) {
        cir.setReturnValue(RenderType.entityCutoutNoCull(location));
    }

    @Inject(
        method = "text(Lnet/minecraft/resources/ResourceLocation;)Lnet/minecraft/client/renderer/RenderType;",
        at = @At("HEAD"),
        cancellable = true
    )
    private static void solidselffix$makeTextSolid(ResourceLocation location, CallbackInfoReturnable<RenderType> cir) {
        cir.setReturnValue(RenderType.entityCutoutNoCull(location));
    }
}
