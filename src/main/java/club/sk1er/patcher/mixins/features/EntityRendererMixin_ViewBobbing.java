package club.sk1er.patcher.mixins.features;

import club.sk1er.patcher.config.PatcherConfig;
import club.sk1er.patcher.hooks.EntityRendererHook;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.settings.GameSettings;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(EntityRenderer.class)
public class EntityRendererMixin_ViewBobbing {
    @Redirect(method = "renderHand", at = @At(value = "FIELD", target = "Lnet/minecraft/client/settings/GameSettings;viewBobbing:Z", ordinal = 0))
    private boolean patcher$mapBobbing(GameSettings instance) {
        return instance.viewBobbing && !EntityRendererHook.hasMap();
    }

    @Redirect(method = "setupCameraTransform", at = @At(value = "FIELD", target = "Lnet/minecraft/client/settings/GameSettings;viewBobbing:Z", ordinal = 0))
    private boolean patcher$viewBobbing(GameSettings instance) {
        return instance.viewBobbing && !PatcherConfig.removeViewBobbing;
    }
}
