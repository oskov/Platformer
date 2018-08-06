package com.warlodya.entity;

import com.badlogic.gdx.math.Rectangle;

public class Projectile extends Entity {

	private int timeToDeath;
	protected int dmg;
	protected int liveTime;

	public int getLiveTime() {
		return liveTime;
	}

	Projectile(Rectangle bounds) {
		super(bounds);

	}

	public Projectile(int x, int y, int width, int height) {
		super(x, y, width, height);
	}
	public void setTextureName(String name) {
		
		this.TextureName=name;
	}
	public Projectile(float x, float y, float width, float height) {
		super(x, y, width, height);
	}

	public int getTimeToDeath() {
		return timeToDeath;
	}

	public void setTimeToDeath(int timeToDeath) {
		this.timeToDeath = timeToDeath;
	}
	
	public void setDmg(int dmg) {
		this.dmg = dmg;
	}

	public void setLiveTime(int liveTime) {
		this.liveTime = liveTime;
	}

	public int getDmg() {
		return dmg;
	}
}
