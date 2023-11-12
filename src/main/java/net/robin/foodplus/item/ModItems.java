package net.robin.foodplus.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.robin.foodplus.FoodPlus;
import net.robin.foodplus.item.custon.SickleItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, FoodPlus.MOD_ID);

    // Food
    public static final RegistryObject<Item> ONION = ITEMS.register("onion",
            () -> new Item(new Item.Properties().food(ModFoods.ONION)));
    public static final RegistryObject<Item> DRAGON_FRUIT = ITEMS.register("dragon_fruit",
            () -> new Item(new Item.Properties().food(ModFoods.DRAGON_FRUIT)));

    // Ingredient
    public static final RegistryObject<Item> SUNFLOWER_OIL = ITEMS.register("sunflower_oil",
            () -> new Item(new Item.Properties().stacksTo(1)));

    // Tools
    public static final RegistryObject<Item> SICKLE = ITEMS.register("sickle",
            () -> new SickleItem(new Item.Properties().durability(100)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
