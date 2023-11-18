package net.robin.foodplus.item.custon;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.state.BlockState;
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

            if (!isHarvestable(state)){
                return InteractionResult.FAIL;
            }

            // state.getBlock().defaultBlockState().setValue();

        }

        pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(),
                player -> player.broadcastBreakEvent(player.getUsedItemHand()));

        return InteractionResult.SUCCESS;
    }

    private boolean isHarvestable(BlockState state) {
        return state.is(ModTags.Blocks.HARVESTABLE_WITH_SICKLE);
    }
}
