package net.dusan.better_skyblock.event;



import net.dusan.better_skyblock.BetterSkyblockMod;
import net.dusan.better_skyblock.effect.ModEffects;
import net.dusan.better_skyblock.event.custom.tickBreakSpeed.PlayerBreakBlockTimeEvent;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BowItem;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BetterSkyblockMod.MOD_ID)
public class ModEvents {
    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event) {
        if (event.getSource().getDirectEntity() instanceof Player player) {
            // Check if the player has the custom effect
            if (player.hasEffect(ModEffects.ARCHERY.get())) {
                // Get the effect level (amplifier)
                int amplifier = player.getEffect(ModEffects.ARCHERY.get()).getAmplifier();

                // Check if the damage source is from a bow
                if (player.getMainHandItem().getItem() instanceof BowItem) {
                    // Increase damage by 12.5% per level
                    float multiplier = 1.0F + (amplifier + 1) * 0.125F; // Amplifier is zero-based
                    event.setAmount(event.getAmount() * multiplier);
                }
            }
        }
    }
    @SubscribeEvent
    public void onPlayerBreakBlockTime(PlayerBreakBlockTimeEvent event) {
        event.setBreakTime(1);
    }
}

