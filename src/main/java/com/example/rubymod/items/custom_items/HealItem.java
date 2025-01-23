package com.example.rubymod.items.custom_items;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
//new item healer
public class HealItem extends Item{
    public HealItem(Properties p){
        super(p);
    }
    @Override
    public InteractionResult useOn(UseOnContext pContext){
        
        Level level=pContext.getLevel();
        Player player=pContext.getPlayer();
        if(!level.isClientSide){//only on server side
            //heals the player
            player.heal(2);
            pContext.getItemInHand().hurtAndBreak(1, ((ServerLevel)level), ((ServerPlayer)pContext.getPlayer()), item -> pContext.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));
            level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.PLAYER_LEVELUP, SoundSource.PLAYERS, 1.0F, 1.0F);
        }
        
       
        return InteractionResult.SUCCESS;
    }
}
