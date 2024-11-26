package net.dusan.better_skyblock.event.custom.tickBreakSpeed;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.eventbus.api.Cancelable;
import net.minecraftforge.eventbus.api.Event;

/**
 * This event is fired when a player's block break progress is updated.
 * It allows modifying the break time in ticks or canceling the action entirely.
 */
@Cancelable
public class PlayerBreakBlockTimeEvent extends Event {
    private final ServerPlayer player;
    private final BlockState blockState;
    private final BlockPos blockPos;
    private int breakTime; // The block break time in ticks

    public PlayerBreakBlockTimeEvent(ServerPlayer player, BlockState blockState, BlockPos blockPos, int breakTime) {
        this.player = player;
        this.blockState = blockState;
        this.blockPos = blockPos;
        this.breakTime = breakTime;
    }

    public ServerPlayer getPlayer() {
        return player;
    }

    public BlockState getBlockState() {
        return blockState;
    }

    public BlockPos getBlockPos() {
        return blockPos;
    }

    public int getBreakTime() {
        return breakTime;
    }

    public void setBreakTime(int breakTime) {
        this.breakTime = breakTime;
    }
}
