package com.warlodya.entity;

import com.badlogic.gdx.graphics.Texture;

public class Modifier extends GameEntity {
	
	private int timeToDeath;
	private GameEntity owner;
	Modifier(GameEntity owner) {
		super(owner.getBounds());
		
	}
	
		
	
}
