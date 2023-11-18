package net.robin.foodplus.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.robin.foodplus.FoodPlus;
import net.robin.foodplus.block.ModBlocks;
import net.robin.foodplus.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, FoodPlus.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        // Food
        simpleItem(ModItems.ONION);
        simpleItem(ModItems.DRAGON_FRUIT);
        simpleItem(ModItems.BANANA);

        // Ingredients
        simpleItem(ModItems.SUNFLOWER_OIL);
        simpleItem(ModItems.COCONUT);

        // Tools
        simpleItem(ModItems.SICKLE);

        // Utility block
        simpleBlockItem(ModBlocks.BREWERY);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(FoodPlus.MOD_ID, "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(FoodPlus.MOD_ID, "item/" + item.getId().getPath()));
    }
}
