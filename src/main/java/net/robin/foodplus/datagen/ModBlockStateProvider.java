package net.robin.foodplus.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;
import net.robin.foodplus.FoodPlus;
import net.robin.foodplus.block.ModBlocks;
import net.robin.foodplus.block.custom.CornCropBlock;
import net.robin.foodplus.block.custom.OnionCropBlock;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, FoodPlus.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.PLOW);
        blockWithItem(ModBlocks.COCONUT_BLOCK);

        makeOnionCrop((CropBlock) ModBlocks.ONION_CROP.get(), "onion_stage", "onion_stage");
        makeCornCrop((CropBlock) ModBlocks.CORN_CROP.get(), "corn_stage_", "corn_stage_");

        simpleBlock(ModBlocks.BREWERY.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/brewery")));
    }

    public void makeOnionCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> onionStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] onionStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((OnionCropBlock) block).getAgeProperty()),
                new ResourceLocation(FoodPlus.MOD_ID, "block/" + textureName + state.getValue(((OnionCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    public void makeCornCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> cornStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] cornStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((CornCropBlock) block).getAgeProperty()),
                new ResourceLocation(FoodPlus.MOD_ID, "block/" + textureName + state.getValue(((CornCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
