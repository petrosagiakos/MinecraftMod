package com.example.rubymod.entity.custom;

import com.example.rubymod.items.ModItems;

import net.minecraft.network.protocol.Packet;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;


public class SpearEntity extends AbstractArrow {
    
    public SpearEntity(EntityType<? extends SpearEntity> entityType, Level world) {
        super(entityType, world);
    }

    public SpearEntity(EntityType<? extends AbstractArrow> type, Level world, LivingEntity shooter, ItemStack ammo) {
        super(type, shooter.getX(), shooter.getY() + shooter.getEyeHeight(), shooter.getZ(), world, ammo, null);
    }

   @Override
    protected void onHitEntity(EntityHitResult hitResult) {
        super.onHitEntity(hitResult);

        Entity hitEntity = hitResult.getEntity();
        if (hitEntity instanceof LivingEntity livingTarget) {
            // Get the correct damage type from the world's registry
            DamageSource spearDamageSource = new DamageSource(livingTarget.level().registryAccess()
                    .registryOrThrow(net.minecraft.core.registries.Registries.DAMAGE_TYPE)
                    .getHolderOrThrow(DamageTypes.ARROW));

            // Apply damage
            livingTarget.hurt(spearDamageSource, 12.0f);
        }

         
    }
    @Override
    protected ItemStack getDefaultPickupItem() {
        return new ItemStack(ModItems.SPEAR.get());
    }
    @Override
    protected void onHitBlock(BlockHitResult blockHitResult) {
        this.setDeltaMovement(0, 0, 0); // Stops moving
        this.setNoGravity(false); // Stick in the block
        this.playSound(SoundEvents.TRIDENT_HIT, 1.0F, 1.0F);
    }

 
}
