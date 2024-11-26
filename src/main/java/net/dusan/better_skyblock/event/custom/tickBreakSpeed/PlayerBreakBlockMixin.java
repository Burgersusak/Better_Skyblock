package net.dusan.better_skyblock.event.custom.tickBreakSpeed;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerPlayerGameMode;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.MinecraftForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ServerPlayerGameMode.class)
public class PlayerBreakBlockMixin {
    @Shadow
    private ServerPlayer player; // Access the private `player` field via Shadow

    @Inject(method = "incrementDestroyProgress", at = @At("HEAD"), cancellable = true)
    private void onIncrementDestroyProgress(BlockState pState, BlockPos pPos, int p_9279_, CallbackInfoReturnable<Float> cir) {
        // Get the default break time in ticks
        float hardness = pState.getDestroySpeed(player.level(), pPos); // Hardness of the block
        if (hardness <= 0.0F) {
            // Blocks like bedrock or unbreakable blocks will have <= 0 hardness
            cir.setReturnValue(0.0F);
            return;
        }
        int defaultBreakTime = (int) (hardness * 20); // Default break time in ticks (hardness * 20)

        // Fire the custom event
        PlayerBreakBlockTimeEvent event = new PlayerBreakBlockTimeEvent(player, pState, pPos, defaultBreakTime);
        if (MinecraftForge.EVENT_BUS.post(event)) {
            // Cancel block-breaking by setting progress to 0
            cir.setReturnValue(0.0F);
            return;
        }

        // Use the modified break time from the event
        int modifiedBreakTime = event.getBreakTime();

        // Calculate the progress increment per tick
        float progressPerTick = 1.0F / modifiedBreakTime; // Proper scaling for ticks
        cir.setReturnValue(progressPerTick);
    }
}
