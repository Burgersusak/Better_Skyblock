package net.dusan.better_skyblock.system.mining.event;

import net.dusan.better_skyblock.BetterSkyblockMod;
import net.dusan.better_skyblock.packet.BlockBreakProgressPacket;
import net.dusan.better_skyblock.packet.ModNetwork;
import net.dusan.better_skyblock.system.mining.capability.mining_speed.MiningSpeedCalculator;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.network.PacketDistributor;

import java.util.HashMap;
import java.util.Map;

@Mod.EventBusSubscriber(modid = BetterSkyblockMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class BlockBreakHandler {
    private static final Map<Player, BlockBreakingData> breakingMap = new HashMap<>();

    @SubscribeEvent
    public static void onLeftClickBlock(PlayerInteractEvent.LeftClickBlock event) {
        Player player = event.getEntity();
        Level level = player.level();
        BlockPos pos = event.getPos();
        BlockState state = level.getBlockState(pos);

        if (!level.isClientSide && !player.isSpectator()) {
            float hardness = state.getDestroySpeed(level, pos);
            if (hardness <= 0 || !state.is(BlockTags.MINEABLE_WITH_PICKAXE)) return;

            float miningSpeed = MiningSpeedCalculator.calculateMiningSpeed(player);
            breakingMap.putIfAbsent(player, new BlockBreakingData(pos, 0));
            BlockBreakingData data = breakingMap.get(player);

            if (!data.blockPos.equals(pos)) {
                data.blockPos = pos;
                data.progress = 0;
            }

            data.progress += miningSpeed / (hardness * 20);
            ModNetwork.CHANNEL.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) player),
                    new BlockBreakProgressPacket(pos, data.progress));

            if (data.progress >= 1.0f) {
                level.destroyBlock(pos, true, player);
                breakingMap.remove(player);
            }
        }
    }

    private static class BlockBreakingData {
        public BlockPos blockPos;
        public float progress;

        public BlockBreakingData(BlockPos blockPos, float progress) {
            this.blockPos = blockPos;
            this.progress = progress;
        }
    }
}
