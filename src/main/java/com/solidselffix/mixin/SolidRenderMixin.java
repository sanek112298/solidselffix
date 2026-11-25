package com.solidselffix.mixin;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ItemEntityRenderer;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = {PlayerRenderer.class, ItemEntityRenderer.class}, remap = false)
public abstract class SolidRenderMixin {

    @Redirect(
        method = "*",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/client/renderer/RenderType;entityTranslucent(Lnet/minecraft/resources/ResourceLocation;)Lnet/minecraft/client/renderer/RenderType;"
        ),
        require = 0
    )
    private static RenderType solidselffix$redirectEntityTranslucent(ResourceLocation location) {
        return RenderType.entityCutoutNoCull(location);
    }

    @Redirect(
        method = "*",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/client/renderer/RenderType;itemEntityTranslucentCull(Lnet/minecraft/resources/ResourceLocation;)Lnet/minecraft/client/renderer/RenderType;"
        ),
        require = 0
    )
    private static RenderType solidselffix$redirectItemEntityTranslucent(ResourceLocation location) {
        return RenderType.entityCutoutNoCull(location);
    }
}
