package net.robin.foodplus.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.robin.foodplus.FoodPlus;
import net.robin.foodplus.block.ModBlocks;

public class ModCreativeModeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FoodPlus.MOD_ID);

    public static final RegistryObject<CreativeModeTab> FOODPLUS_TAB = CREATIVE_MODE_TABS.register("foodplus_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ONION.get()))
                    .title(Component.translatable("creativetab.foodplus_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        // Food
                        pOutput.accept(ModItems.ONION.get());
                        pOutput.accept(ModItems.DRAGON_FRUIT.get());
                        pOutput.accept(ModItems.BANANA.get());

                        // Ingredients
                        pOutput.accept(ModItems.SUNFLOWER_OIL.get());
                        pOutput.accept(ModItems.COCONUT.get());

                        // Utility blocks
                        pOutput.accept(ModBlocks.PLOW.get());
                        pOutput.accept(ModBlocks.BREWERY.get());

                        // Tools
                        pOutput.accept(ModItems.SICKLE.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
