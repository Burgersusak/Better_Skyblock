package net.dusan.better_skyblock.item.custom;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class EnchantedItem extends TooltipItem {


    public EnchantedItem(String pTooltipKey, Properties pProperties) {
        super(pTooltipKey, pProperties);
    }

    @Override
    public boolean isFoil(ItemStack pStack) {
        return true;
    }
}
