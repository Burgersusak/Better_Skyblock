package net.dusan.better_skyblock.packet;

import net.dusan.better_skyblock.capability.ModCapabilities;
import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class MiningSpeedUpdatePacket {
    private final float miningSpeed;

    public MiningSpeedUpdatePacket(float miningSpeed) {
        this.miningSpeed = miningSpeed;
    }

    public static void encode(MiningSpeedUpdatePacket packet, FriendlyByteBuf buffer) {
        buffer.writeFloat(packet.miningSpeed);
    }

    public static MiningSpeedUpdatePacket decode(FriendlyByteBuf buffer) {
        return new MiningSpeedUpdatePacket(buffer.readFloat());
    }

    public static void handle(MiningSpeedUpdatePacket packet, Supplier<NetworkEvent.Context> context) {
        context.get().enqueueWork(() -> {
            Player player = Minecraft.getInstance().player;
            if (player != null) {
                player.getCapability(ModCapabilities.MINING_SPEED).ifPresent(cap -> cap.setMiningSpeed(packet.miningSpeed));
            }
        });
        context.get().setPacketHandled(true);
    }
}
