package net.dusan.better_skyblock.system.mining.capability.mining_speed;

import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;

public class MiningSpeedCalculator {
    public static float calculateMiningSpeed(Player player) {
        ItemStack tool = player.getMainHandItem();
        float speed = getToolMiningSpeed(tool);
        speed += getEfficiencyBonus(tool);
        speed += getEffectBonus(player);
        return speed;
    }

    private static float getEfficiencyBonus(ItemStack tool) {
        int level = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.BLOCK_EFFICIENCY, tool);
        return level > 0 ? 30 + (level - 1) * 20 : 0;
    }

    private static float getEffectBonus(LivingEntity player) {
        int hasteLevel = player.hasEffect(MobEffects.DIG_SPEED) ? player.getEffect(MobEffects.DIG_SPEED).getAmplifier() + 1 : 0;
        int fatigueLevel = player.hasEffect(MobEffects.DIG_SLOWDOWN) ? player.getEffect(MobEffects.DIG_SLOWDOWN).getAmplifier() + 1 : 0;
        return (hasteLevel * 50) - (fatigueLevel * 50);
    }

    private static float getToolMiningSpeed(ItemStack tool) {
        if (tool.getItem() instanceof PickaxeItem) {
            if (tool.is(Items.WOODEN_PICKAXE)) return 70;
            if (tool.is(Items.GOLDEN_PICKAXE)) return 250;
            if (tool.is(Items.STONE_PICKAXE)) return 110;
            if (tool.is(Items.IRON_PICKAXE)) return 160;
            if (tool.is(Items.DIAMOND_PICKAXE)) return 230;
            if (tool.is(Items.NETHERITE_PICKAXE)) return 240;
        }
        return 0;
    }
}
