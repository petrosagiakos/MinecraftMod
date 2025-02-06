package com.example.rubymod.entity;

import com.example.rubymod.RubyMod;
import com.example.rubymod.entity.custom.BulletEntity;
import com.example.rubymod.entity.custom.SpearEntity;
import com.example.rubymod.entity.custom.ElephantEntity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, RubyMod.MODID);

       public static final RegistryObject<EntityType<ElephantEntity>> ELEPHANT =
            ENTITY_TYPES.register("elephant", () -> EntityType.Builder.of(ElephantEntity::new, MobCategory.CREATURE)
                    .sized(1.5f, 1.5f).build("elephant"));
        public static final RegistryObject<EntityType<BulletEntity>> BULLET =
                    ENTITY_TYPES.register("bullet", () -> EntityType.Builder.<BulletEntity>of(BulletEntity::new, MobCategory.MISC)
                            .sized(0.25f, 0.25f).clientTrackingRange(4) 
                            .updateInterval(1).build("bullet"));
        public static final RegistryObject<EntityType<SpearEntity>> SPEAR =
                ENTITY_TYPES.register("spear", () -> EntityType.Builder.<SpearEntity>of(SpearEntity::new, MobCategory.MISC)
                        .sized(1f, 1f).clientTrackingRange(4) 
                        .updateInterval(1).build("spear"));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
