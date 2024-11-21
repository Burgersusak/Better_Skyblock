package net.dusan.better_skyblock.capability;

import net.dusan.better_skyblock.system.mining.capability.mining_speed.MiningSpeedCapability;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;

public class ModCapabilities {
    public static Capability<MiningSpeedCapability> MINING_SPEED = CapabilityManager.get(new CapabilityToken<>() {});

    public static void register() {
        CapabilityManager.INSTANCE.register(MiningSpeedCapability.class, new CapabilityStorage<>(), MiningSpeedCapability::new);
    }
}