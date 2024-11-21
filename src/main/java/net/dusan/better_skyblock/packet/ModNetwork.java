package net.dusan.better_skyblock.packet;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

public class ModNetwork {
    public static final String PROTOCOL = "1.0";
    public static final SimpleChannel CHANNEL = NetworkRegistry.newSimpleChannel(
            new ResourceLocation("yourmodid", "network"),
            () -> PROTOCOL,
            PROTOCOL::equals,
            PROTOCOL::equals
    );

    public static void register() {
        int id = 0;
        CHANNEL.registerMessage(id++, MiningSpeedUpdatePacket.class, MiningSpeedUpdatePacket::encode,
                MiningSpeedUpdatePacket::decode, MiningSpeedUpdatePacket::handle);
        CHANNEL.registerMessage(id++, BlockBreakProgressPacket.class, BlockBreakProgressPacket::encode,
                BlockBreakProgressPacket::decode, BlockBreakProgressPacket::handle);
    }
}
