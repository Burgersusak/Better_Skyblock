package net.dusan.better_skyblock.datagen;

import net.dusan.better_skyblock.BetterSkyblockMod;
import net.dusan.better_skyblock.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, BetterSkyblockMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.FEL_ROSE);
        simpleItem(ModItems.FEL_SKULL);
        simpleItem(ModItems.GIANT_FRAGMENT_BIGFOOT);
        simpleItem(ModItems.GIANT_FRAGMENT_DIAMOND);
        simpleItem(ModItems.GIANT_FRAGMENT_LASER);
        simpleItem(ModItems.GIANT_FRAGMENT_BOULDER);
        simpleItem(ModItems.SPIRIT_BONE);
        simpleItem(ModItems.SPIRIT_WING);
        simpleItem(ModItems.NECRON_HANDLE);
        simpleItem(ModItems.MITHRIL);
        simpleItem(ModItems.ENCHANTED_REDSTONE);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(BetterSkyblockMod.MOD_ID,"item/" + item.getId().getPath()));
    }
}
