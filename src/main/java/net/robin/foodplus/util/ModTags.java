package net.robin.foodplus.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.robin.foodplus.FoodPlus;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> HARVESTABLES = tag("harvestables");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(FoodPlus.MOD_ID, name));
        }
    }

    public static class Items {

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(FoodPlus.MOD_ID, name));
        }
    }
}
