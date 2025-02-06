package com.example.rubymod.items.custom_items;
import java.util.function.Consumer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

import com.example.rubymod.entity.ModEntities;
import com.example.rubymod.entity.custom.SpearEntity;
import com.example.rubymod.items.ModItems;

public class SpearItem extends Item {

    public SpearItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        ItemStack ammo = new ItemStack(ModItems.SPEAR.get());
        if(!getAmmo(player).isEmpty()){

            if (!world.isClientSide) { // Server-side execution
                ItemStack bullets=getAmmo(player);
                SpearEntity spear = new SpearEntity(ModEntities.SPEAR.get(),world, player,ammo);
                spear.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 3.0F, 1.0F);
                world.addFreshEntity(spear);
                bullets.shrink(1);
            }
            return InteractionResultHolder.sidedSuccess(stack, world.isClientSide());
        }else {
            // Play empty gun click sound
            world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.DISPENSER_FAIL, SoundSource.PLAYERS, 1.0F, 1.0F);
            return InteractionResultHolder.fail(stack);
        }
        
    }

    private ItemStack getAmmo(Player player) {
        for (ItemStack itemStack : player.getInventory().items) {
            if (itemStack.getItem() == ModItems.SPEAR.get()) {
                return itemStack;
            }
        }
        return ItemStack.EMPTY;
    }
}