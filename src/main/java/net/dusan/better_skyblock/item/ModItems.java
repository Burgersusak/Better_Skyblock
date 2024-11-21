package net.dusan.better_skyblock.item;

import net.dusan.better_skyblock.BetterSkyblockMod;
import net.dusan.better_skyblock.item.custom.EnchantedItem;
import net.dusan.better_skyblock.item.custom.TooltipItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, BetterSkyblockMod.MOD_ID);

    public static final RegistryObject<Item> NECRON_HANDLE = ITEMS.register("necron_handle",
            () -> new TooltipItem("necron_handle", new Item.Properties()));
    public static final RegistryObject<Item> GIANT_FRAGMENT_LASER = ITEMS.register("giant_fragment_laser",
            () -> new TooltipItem("giant_fragment_laser", new Item.Properties()));
    public static final RegistryObject<Item> GIANT_FRAGMENT_DIAMOND = ITEMS.register("giant_fragment_diamond",
            () -> new TooltipItem("giant_fragment_diamond", new Item.Properties()));
    public static final RegistryObject<Item> GIANT_FRAGMENT_BOULDER = ITEMS.register("giant_fragment_boulder",
            () -> new TooltipItem("giant_fragment_boulder", new Item.Properties()));
    public static final RegistryObject<Item> GIANT_FRAGMENT_BIGFOOT = ITEMS.register("giant_fragment_bigfoot",
            () -> new TooltipItem("giant_fragment_bigfoot", new Item.Properties()));
    public static final RegistryObject<Item> FEL_ROSE = ITEMS.register("fel_rose",
            () -> new TooltipItem("fel_rose", new Item.Properties()));
    public static final RegistryObject<Item> FEL_SKULL = ITEMS.register("fel_skull",
            () -> new TooltipItem("fel_skull", new Item.Properties()));
    public static final RegistryObject<Item> SPIRIT_BONE = ITEMS.register("spirit_bone",
            () -> new TooltipItem("spirit_bone", new Item.Properties()));
    public static final RegistryObject<Item> SPIRIT_WING = ITEMS.register("spirit_wing",
            () -> new TooltipItem("spirit_wing", new Item.Properties()));
    public static final RegistryObject<Item> MITHRIL = ITEMS.register("mithril",
            () -> new TooltipItem("mithril", new Item.Properties()));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}