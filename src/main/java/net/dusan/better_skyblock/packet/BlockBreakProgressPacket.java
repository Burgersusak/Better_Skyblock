package net.dusan.better_skyblock.packet;

import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class BlockBreakProgressPacket {
    private final BlockPos blockPos;
    private final float progress;

    public BlockBreakProgressPacket(BlockPos blockPos, float progress) {
        this.blockPos = blockPos;
        this.progress = progress;
    }

    public static void encode(BlockBreakProgressPacket packet, FriendlyByteBuf buffer) {
        buffer.writeBlockPos(packet.blockPos);
        buffer.writeFloat(packet.progress);
    }

    public static BlockBreakProgressPacket decode(FriendlyByteBuf buffer) {
        BlockPos blockPos = buffer.readBlockPos();
        float progress = buffer.readFloat();
        return new BlockBreakProgressPacket(blockPos, progress);
    }

    public static void handle(BlockBreakProgressPacket packet, Supplier<NetworkEvent.Context> context) {
        context.get().enqueueWork(() -> {
            Minecraft minecraft = Minecraft.getInstance();
            Level level = minecraft.level;
            if (level != null) {
                BlockPos pos = packet.blockPos;
                float progress = packet.progress;

                // Trigger block-breaking animation
                level.destroyBlockProgress(minecraft.player.getId(), pos, (int) (progress * 10));
            }
        });
        context.get().setPacketHandled(true);
    }
}
