package com.example.rubymod.entity.custom;

import com.example.rubymod.entity.ModEntities;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.server.level.ServerLevel;


public class BulletEntity extends AbstractArrow {
    private final float bulletDamage = 10.0f;
    public BulletEntity(EntityType<? extends AbstractArrow> type, Level world) {
        super(type, world);
    
    }

    public BulletEntity(EntityType<? extends AbstractArrow> type, Level world, LivingEntity shooter, ItemStack ammo) {
        super(type, shooter.getX(), shooter.getY() + shooter.getEyeHeight(), shooter.getZ(), world, ammo, null);
    }
    @Override
    protected ItemStack getDefaultPickupItem() {
        return ItemStack.EMPTY; // Prevents bullet pickup
    }
    @Override
    protected void onHitEntity(EntityHitResult hitResult) {
        super.onHitEntity(hitResult);

        Entity hitEntity = hitResult.getEntity();
        if (hitEntity instanceof LivingEntity livingTarget) {
            // Get the correct damage type from the world's registry
            DamageSource bulletDamageSource = new DamageSource(livingTarget.level().registryAccess()
                    .registryOrThrow(net.minecraft.core.registries.Registries.DAMAGE_TYPE)
                    .getHolderOrThrow(DamageTypes.ARROW));

            // Apply damage
            livingTarget.hurt(bulletDamageSource, bulletDamage);
        }

        this.discard(); // Remove bullet after hitting an entity
    }
    
    @Override
    public void tick() {
        super.tick();
        if (this.inGround) {
            this.discard(); // Bullet disappears on impact
        }
    }
}
