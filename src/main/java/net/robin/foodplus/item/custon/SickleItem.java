package net.robin.foodplus.item.custon;

import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraftforge.event.level.BlockEvent;
import net.robin.foodplus.block.ModBlocks;
import net.robin.foodplus.block.custom.CornCropBlock;
import net.robin.foodplus.block.custom.OnionCropBlock;
import net.robin.foodplus.item.ModItems;
import net.robin.foodplus.util.ModTags;

import java.util.Map;

public class SickleItem extends Item {
    public SickleItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if(!pContext.getLevel().isClientSide()) {
            BlockPos positionClicked = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            BlockState state = pContext.getLevel().getBlockState(positionClicked);

            if(isHarvestable(state)) {
                CropBlock harvestedBlock = (CropBlock) state.getBlock();

                // harvestedBlock.AGE.value().equals(harvestedBlock.getMaxAge())
                if(harvestedBlock.isMaxAge(state)) {
                    BlockState blockstate;

                    if(state.is(ModBlocks.CORN_CROP.get())) {
                        CornCropBlock harvestedCorn = (CornCropBlock) harvestedBlock;
                        blockstate = state.setValue(harvestedCorn.getAgeProperty(), Integer.valueOf(8));
                    } else if(state.is(ModBlocks.ONION_CROP.get())) {
                        OnionCropBlock harvestedOnion = (OnionCropBlock) harvestedBlock;
                        blockstate = state.setValue(harvestedOnion.getAgeProperty(), Integer.valueOf(1));
                    } else {
                        blockstate = state.setValue(harvestedBlock.AGE, Integer.valueOf(1));
                    }
                    pContext.getLevel().setBlock(positionClicked, blockstate, 2);


                    // TODO
                    // get drops on crop click
                    state.getBlock().getLootTable();
                    ItemStack cropDrops = new ItemStack(harvestedBlock.asItem());
                    player.addItem(cropDrops);
                }
            }
        }

        pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(),
                player -> player.broadcastBreakEvent(player.getUsedItemHand()));

        return InteractionResult.SUCCESS;
    }

    private boolean isHarvestable(BlockState state) {
        return state.is(ModTags.Blocks.HARVESTABLE_WITH_SICKLE);
    }
}