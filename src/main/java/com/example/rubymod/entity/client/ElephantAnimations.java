package com.example.rubymod.entity.client;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.KeyframeAnimations;
import net.minecraft.client.animation.Keyframe;

public class ElephantAnimations {
        public static final AnimationDefinition WALKING = AnimationDefinition.Builder.withLength(2f).looping()
.addAnimation("f1",
	new AnimationChannel(AnimationChannel.Targets.POSITION, 
		new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR), 
		new Keyframe(1f, KeyframeAnimations.posVec(0f, 0f, -1f),
			AnimationChannel.Interpolations.LINEAR), 
		new Keyframe(2f, KeyframeAnimations.posVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("f1",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1f, KeyframeAnimations.degreeVec(-10f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("f2",
	new AnimationChannel(AnimationChannel.Targets.POSITION, 
		new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, -1f),
			AnimationChannel.Interpolations.LINEAR), 
		new Keyframe(1f, KeyframeAnimations.posVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR), 
		new Keyframe(2f, KeyframeAnimations.posVec(0f, 0f, -1f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("f2",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(-10f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(2f, KeyframeAnimations.degreeVec(-10f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("f3",
	new AnimationChannel(AnimationChannel.Targets.POSITION, 
		new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR), 
		new Keyframe(1f, KeyframeAnimations.posVec(0f, 0f, -1f),
			AnimationChannel.Interpolations.LINEAR), 
		new Keyframe(2f, KeyframeAnimations.posVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("f3",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1f, KeyframeAnimations.degreeVec(-10f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("f4",
	new AnimationChannel(AnimationChannel.Targets.POSITION, 
		new Keyframe(0f, KeyframeAnimations.posVec(0f, 5f, -2f),
			AnimationChannel.Interpolations.LINEAR), 
		new Keyframe(1f, KeyframeAnimations.posVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR), 
		new Keyframe(2f, KeyframeAnimations.posVec(0f, 5f, -2f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("f4",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(-10f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(2f, KeyframeAnimations.degreeVec(-10f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR))).build();
}
