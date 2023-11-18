package net.robin.foodplus.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.robin.foodplus.FoodPlus;
import net.robin.foodplus.entity.custom.CoconutProjectileEntity;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, FoodPlus.MOD_ID);

    public static final RegistryObject<EntityType<CoconutProjectileEntity>> COCONUT_PROJECTILE =
            ENTITY_TYPES.register("coconut_projectile", () -> EntityType.Builder.<CoconutProjectileEntity>of(CoconutProjectileEntity::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f).build("coconut_projectile"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
