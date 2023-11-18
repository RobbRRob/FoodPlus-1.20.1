package net.robin.foodplus.entity.custom;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.robin.foodplus.block.ModBlocks;
import net.robin.foodplus.entity.ModEntities;
import net.robin.foodplus.item.ModItems;

public class CoconutProjectileEntity extends ThrowableItemProjectile {
    public CoconutProjectileEntity(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }
    public CoconutProjectileEntity(Level pLevel) {
        super(ModEntities.COCONUT_PROJECTILE.get(), pLevel);
    }
    public CoconutProjectileEntity(Level pLevel, LivingEntity livingEntity) {
        super(ModEntities.COCONUT_PROJECTILE.get(), livingEntity,pLevel);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.COCONUT.get();
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        if(!this.level().isClientSide()) {
            super.onHitEntity(pResult);
            Entity entity = pResult.getEntity();
            entity.hurt(this.damageSources().thrown(this, this.getOwner()), 10f);

            //this.level().broadcastEntityEvent(this, ((byte) 3));
            //this.level().setBlock(blockPosition(), ((CoconutBlock) ModBlocks.COCONUT_BLOCK.get()), 3);
        }

        super.onHitEntity(pResult);
    }

    @Override
    protected void onHitBlock(BlockHitResult pResult) {
        if(!this.level().isClientSide()) {
            //this.level().broadcastEntityEvent(this, ((byte) 3));
            //this.level().setBlock(blockPosition(), ((CoconutBlock) ModBlocks.COCONUT_BLOCK.get()), 3);
        }

        super.onHitBlock(pResult);
    }
}
