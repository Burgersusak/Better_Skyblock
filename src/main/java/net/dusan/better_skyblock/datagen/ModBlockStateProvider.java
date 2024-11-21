package net.dusan.better_skyblock.datagen;

import net.dusan.better_skyblock.BetterSkyblockMod;
import net.dusan.better_skyblock.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, BetterSkyblockMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        /*
        blockWithItem(ModBlocks.TITANIUM_BLOCK);
        blockWithItem(ModBlocks.MITHRIL_1);
        blockWithItem(ModBlocks.MITHRIL_2);
        blockWithItem(ModBlocks.MITHRIL_3);
        blockWithItem(ModBlocks.MITHRIL_4);
        blockWithItem(ModBlocks.MITHRIL_5);
        blockWithItem(ModBlocks.MITHRIL_6);
        blockWithItem(ModBlocks.PURE_DIAMOND);
        blockWithItem(ModBlocks.PURE_COAL);
        blockWithItem(ModBlocks.PURE_EMERALD);
        blockWithItem(ModBlocks.PURE_IRON);
        blockWithItem(ModBlocks.PURE_GOLD);
        blockWithItem(ModBlocks.PURE_REDSTONE);
        blockWithItem(ModBlocks.PURE_LAPIS);*/
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
