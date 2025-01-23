package com.example.rubymod.items.custom_items;

import java.util.Map;
import java.util.Random;
import com.example.rubymod.RubyMod;
import com.example.rubymod.blocks.ModBlocks;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;


public class MagicBlade extends Item{
   
    private static final Map<Block, Integer[]> MAGIC_BLADE_MAP = Map.of(
        Blocks.STONE, new Integer[]{15, 26, 36, 48, 70, 80, 90, 100}//posibilities of each ore to appear
    );
    
    private static final Block[] STONE_REPLACEMENTS = new Block[]{
        Blocks.COAL_ORE,
        Blocks.IRON_ORE,
        Blocks.LAPIS_ORE,
        Blocks.REDSTONE_ORE,
        Blocks.GOLD_ORE,
        Blocks.DIAMOND_ORE,
        Blocks.EMERALD_ORE,
        ModBlocks.RUBY_ORE.get()
    };
    

    public MagicBlade(Properties p){
        super(p);
    }
    
    @Override
    public InteractionResult useOn(UseOnContext pContext){
        Random rand=new Random();
        int r=rand.nextInt(100);
        Level level=pContext.getLevel();
        //takes the clicked object
        Block BlockClicked =  level.getBlockState(pContext.getClickedPos()).getBlock();//getNearbyPlayers
        if(MAGIC_BLADE_MAP.containsKey(BlockClicked)){
            
                //takes the inner array
                Integer[] pos = MAGIC_BLADE_MAP.get(BlockClicked); // The inner map
                
                
                
                for (int i=0;i<pos.length;i++) {

                    
                    //System.out.println(r+" "+pos[i]+" Is True? "+(r<pos[i]));//for debuging
                    if(r<pos[i]){
                        if(!level.isClientSide()){
                            level.setBlockAndUpdate(pContext.getClickedPos(),STONE_REPLACEMENTS[i].defaultBlockState());
                            pContext.getItemInHand().hurtAndBreak(1, ((ServerLevel)level), ((ServerPlayer)pContext.getPlayer()), item -> pContext.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));
                            level.playSound(null, pContext.getClickedPos(), SoundEvents.GRINDSTONE_USE, SoundSource.BLOCKS);
                            
                        }
                        break;
                    }
                    
                    
                    
                }
            }

        
            
         return InteractionResult.SUCCESS;
    }
}
