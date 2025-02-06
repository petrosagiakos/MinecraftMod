package com.example.rubymod.entity.custom;

import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import com.example.rubymod.items.ModItems;

public class ElephantEntity extends Animal{
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout=0;

    public ElephantEntity(EntityType<? extends Animal> pEntityType, Level pLevel){
            super(pEntityType, pLevel);
    }

    @Override
    protected void registerGoals(){
        this.goalSelector.addGoal(0, new FloatGoal(this));//floats in the water
        this.goalSelector.addGoal(1, new PanicGoal(this, 2.0));//panics when hit with and runs with higher speed
        //can breed
        this.goalSelector.addGoal(2, new BreedGoal(this, 1.0));
        //folows when apple is hold
        this.goalSelector.addGoal(3, new TemptGoal(this, 1.25, stack -> stack.is(Items.APPLE), false));

        this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25));
        //avoid getting in to water
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0));
        //looks ate the player
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 6.0F));
        //looks around
        
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
        
        this.goalSelector.addGoal(8,new ZombieAttackGoal(new Zombie(super.level()), 7f,true ));
    }   
    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 60D)//sets health
                .add(Attributes.MOVEMENT_SPEED, 0.35D)//sets speed
                .add(Attributes.FOLLOW_RANGE, 50D)
                .add(Attributes.ATTACK_DAMAGE,12D);
    }

    @Override
    public boolean isFood(ItemStack pStack){
        return pStack.is(Items.APPLE);
    }
    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent){
        return null;
    }
    private void setupAnimationStates() {
        if(this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = 40;
            this.idleAnimationState.start(this.tickCount);
        } else {
            --this.idleAnimationTimeout;
        }
    }
    @Override
    public void tick() {
        super.tick();

        if(this.level().isClientSide()) {
            this.setupAnimationStates();
        }
    }
}
