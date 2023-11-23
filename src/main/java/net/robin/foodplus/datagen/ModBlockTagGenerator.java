package net.robin.foodplus.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.robin.foodplus.FoodPlus;
import net.robin.foodplus.block.ModBlocks;
import net.robin.foodplus.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {

    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, FoodPlus.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ModTags.Blocks.HARVESTABLE_WITH_SICKLE)
                .add(
                        Blocks.POTATOES,
                        Blocks.CARROTS,
                        Blocks.WHEAT,
                        Blocks.BEETROOTS,
                        ModBlocks.CORN_CROP.get(),
                        ModBlocks.ONION_CROP.get()
                );
    }
}
