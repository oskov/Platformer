package com.warlodya.ability;

import com.warlodya.entity.GameEntity;
import com.warlodya.entity.Projectile;

public abstract class Ability {
	private int currentCoolDown;
	private final GameEntity owner;
	protected int coolDown;
	protected Projectile projectile;
	
	Ability(GameEntity owner){
		
		this.owner=owner;
		coolDown=0;
	}
	
	public GameEntity getOwner() {
		return owner;
	}



	public boolean use() {
		if(currentCoolDown!=0) return false; else {
			
			cast();
			setCurrentCoolDown(coolDown);
		}
		
		return true;
	}
	
	public boolean haveProjectile() {
		return projectile!=null;
	}
	public int getCurrentCoolDown() {
		return currentCoolDown;
	}

	private void setCurrentCoolDown(int currentCoolDown) {
		this.currentCoolDown = currentCoolDown;
	}

	public int getCoolDown() {
		return coolDown;
	}

	abstract protected void cast();
	
	
}
