package io.github.real_septicake.hexxyplanes.mixin;

import io.github.real_septicake.hexxyplanes.HexxyplanesDimension;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerPlayer.class)
public abstract class ServerPlayerMixin {
    @Shadow public abstract void sendSystemMessage(Component component);

    @Inject(method = "setRespawnPosition", at = @At(value = "HEAD"), cancellable = true)
    private void noneOfThatPlease(ResourceKey<Level> dimension, BlockPos position, float angle, boolean forced, boolean sendMessage, CallbackInfo ci) {
        if(dimension.registry().equals(HexxyplanesDimension.INSTANCE.getWORLD_KEY().registry()) &&
            dimension.location().equals(HexxyplanesDimension.INSTANCE.getWORLD_KEY().location())) {
            sendSystemMessage(Component.literal("You cannot set your spawn here."));
            ci.cancel();
        }
    }
}
