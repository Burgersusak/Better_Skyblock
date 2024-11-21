package net.dusan.better_skyblock.effect;

import net.dusan.better_skyblock.BetterSkyblockMod;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, BetterSkyblockMod.MOD_ID);

    public static final RegistryObject<MobEffect> ARCHERY = MOB_EFFECTS.register("archery",
            () -> new ArcheryEffect(MobEffectCategory.BENEFICIAL, 0x90EE90));

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
