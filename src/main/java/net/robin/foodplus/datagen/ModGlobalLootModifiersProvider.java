package net.robin.foodplus.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;
import net.robin.foodplus.FoodPlus;
import net.robin.foodplus.item.ModItems;
import net.robin.foodplus.loot.AddItemModifier;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, FoodPlus.MOD_ID);
    }

    @Override
    protected void start() {
        add("onion_from_grass", new AddItemModifier(new LootItemCondition[] {
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.GRASS).build(),
                LootItemRandomChanceCondition.randomChance(0.12f).build()
        }, ModItems.ONION.get()));

        // Onion from zombies
        add("onion_from_zombie", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("entities/zombie")).build(),
                LootItemRandomChanceCondition.randomChance(0.025f).build()
        }, ModItems.ONION.get()));
        add("onion_from_zombie_villager", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("entities/zombie_villager")).build(),
                LootItemRandomChanceCondition.randomChance(0.025f).build()
        }, ModItems.ONION.get()));
        add("onion_from_husk", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("entities/husk")).build(),
                LootItemRandomChanceCondition.randomChance(0.025f).build()
        }, ModItems.ONION.get()));
    }
}
