package com.warlodya.entity;

import com.badlogic.gdx.graphics.Texture;
import com.warlodya.game.util.ContentLoader;

public class Player extends GameEntity {
	

	
	public Player(float x, float y, float width, float height){
		super(x,y,width,height);
		this.setPlayer();
		this.maxHP=10;
		this.TextureName="Skeleton";
		setMinSpeed(1);
		setMaxSpeed(3);
		setAcceleration(0.1f);
		setJumpPower(5);
		init();
	}
	


	
	
	
}
