package net.robin.foodplus.block.entity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.robin.foodplus.FoodPlus;
import net.robin.foodplus.block.ModBlocks;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, FoodPlus.MOD_ID);

    public static final RegistryObject<BlockEntityType<BreweryBlockEntity>> BREWERY_BE =
            BLOCK_ENTITIES.register("brewery_be", () ->
                    BlockEntityType.Builder.of(BreweryBlockEntity::new,
                            ModBlocks.BREWERY.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
