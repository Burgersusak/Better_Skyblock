package net.dusan.better_skyblock.datagen.loot;

import net.dusan.better_skyblock.block.ModBlocks;
import net.dusan.better_skyblock.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {/*
        this.dropSelf(ModBlocks.MITHRIL_5.get());
        this.dropSelf(ModBlocks.MITHRIL_1.get());
        this.dropSelf(ModBlocks.MITHRIL_2.get());
        this.dropSelf(ModBlocks.MITHRIL_3.get());
        this.dropSelf(ModBlocks.MITHRIL_4.get());
        this.dropSelf(ModBlocks.MITHRIL_6.get());
        this.dropSelf(ModBlocks.TITANIUM_BLOCK.get());
        this.dropSelf(ModBlocks.PURE_COAL.get());
        this.dropSelf(ModBlocks.PURE_DIAMOND.get());
        this.dropSelf(ModBlocks.PURE_EMERALD.get());
        this.dropSelf(ModBlocks.PURE_GOLD.get());
        this.dropSelf(ModBlocks.PURE_IRON.get());
        this.dropSelf(ModBlocks.PURE_REDSTONE.get());
        this.dropSelf(ModBlocks.PURE_LAPIS.get());
        */
    }

    //NOTE !!!!! THIS IS A PLACEHOLDER CHANGE AFTER IMPLEMENTING A MINING SYSTEM!!!!!!
    protected LootTable.Builder createOreDrop(Block pBlock, Item pItem) {
        return createSilkTouchDispatchTable(pBlock, this.applyExplosionDecay(pBlock, LootItem.lootTableItem(pItem).apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
