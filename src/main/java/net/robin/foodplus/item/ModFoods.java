package net.robin.foodplus.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties ONION = new FoodProperties.Builder().nutrition(2)
            .saturationMod(0.2f)
            .effect(() -> new MobEffectInstance(MobEffects.BLINDNESS, 100), 0.2f)
            .build();

    public static final FoodProperties DRAGON_FRUIT = new FoodProperties.Builder().nutrition(4)
            .saturationMod(7.2f)
            .build();
}
