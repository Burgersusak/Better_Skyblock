package net.dusan.better_skyblock.item;

import net.dusan.better_skyblock.BetterSkyblockMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BetterSkyblockMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> COURSE_TAB = CREATIVE_MODE_TABS.register("course_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.NECRON_HANDLE.get()))
                    .title(Component.translatable("creativetab.course_tab"))
                    .displayItems((displayParameters, output) -> {
                        output.accept(ModItems.FEL_SKULL.get());
                        output.accept(ModItems.MITHRIL.get());
                        output.accept(ModItems.FEL_ROSE.get());
                        output.accept(ModItems.GIANT_FRAGMENT_BIGFOOT.get());
                        output.accept(ModItems.GIANT_FRAGMENT_DIAMOND.get());
                        output.accept(ModItems.GIANT_FRAGMENT_BOULDER.get());
                        output.accept(ModItems.GIANT_FRAGMENT_LASER.get());
                        output.accept(ModItems.SPIRIT_BONE.get());
                        output.accept(ModItems.SPIRIT_WING.get());
                        output.accept(ModItems.NECRON_HANDLE.get());
                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
