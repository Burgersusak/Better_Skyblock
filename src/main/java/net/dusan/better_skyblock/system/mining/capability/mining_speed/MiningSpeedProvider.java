package net.dusan.better_skyblock.system.mining.capability.mining_speed;

import net.dusan.better_skyblock.capability.ModCapabilities;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.Nullable;


public class MiningSpeedProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
    public static final ResourceLocation CAP_ID = new ResourceLocation("yourmodid", "mining_speed");

    private final MiningSpeedCapability backend = new MiningSpeedCapability();
    private final LazyOptional<MiningSpeedCapability> optional = LazyOptional.of(() -> backend);

    @Override
    public <T> @Nullable T getCapability(Capability<T> cap, Direction side) {
        return cap == ModCapabilities.MINING_SPEED ? (T) optional : null;
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag tag = new CompoundTag();
        tag.putFloat("MiningSpeed", backend.getMiningSpeed());
        return tag;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        backend.setMiningSpeed(nbt.getFloat("MiningSpeed"));
    }
}