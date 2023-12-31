package net.robin.foodplus.datagen.loot;

import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.registries.RegistryObject;
import net.robin.foodplus.block.ModBlocks;
import net.robin.foodplus.block.custom.CornCropBlock;
import net.robin.foodplus.block.custom.OnionCropBlock;
import net.robin.foodplus.item.ModItems;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }
    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.PLOW.get());
        this.dropSelf(ModBlocks.BREWERY.get());

        this.dropOther(ModBlocks.COCONUT_BLOCK.get(), ModItems.COCONUT.get());

        LootItemCondition.Builder lootitemcondition$builder1 = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.ONION_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(OnionCropBlock.AGE, 5));
        this.add(ModBlocks.ONION_CROP.get(), applyExplosionDecay(ModBlocks.ONION_CROP.get(),
                LootTable.lootTable().withPool(LootPool.lootPool().add(LootItem.lootTableItem(ModItems.ONION.get())))
                        .withPool(LootPool.lootPool().when(lootitemcondition$builder1)
                                .add(LootItem.lootTableItem(ModItems.ONION.get())
                                        .apply(ApplyBonusCount
                                                .addBonusBinomialDistributionCount(Enchantments.BLOCK_FORTUNE, 0.5714286F, 3))))
                        .withPool(LootPool.lootPool().when(lootitemcondition$builder1))));

        LootItemCondition.Builder lootitemcondition$builder2 = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.CORN_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CornCropBlock.AGE, 12));
        LootItemCondition.Builder lootitemcondition$builder3 = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.CORN_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CornCropBlock.AGE, "<8"));
        this.add(ModBlocks.CORN_CROP.get(), applyExplosionDecay(ModBlocks.CORN_CROP.get(),
                LootTable.lootTable().withPool(LootPool.lootPool().when(lootitemcondition$builder3)
                                .add(LootItem.lootTableItem(ModItems.CORN.get())))
                        .withPool(LootPool.lootPool().when(lootitemcondition$builder2)
                                .add(LootItem.lootTableItem(ModItems.CORN.get())
                                        .apply(ApplyBonusCount
                                                .addBonusBinomialDistributionCount(Enchantments.BLOCK_FORTUNE, 0.723402F, 3))))
                        .withPool(LootPool.lootPool().when(lootitemcondition$builder2))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
