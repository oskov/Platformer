package com.warlodya.entity;

import com.badlogic.gdx.math.Rectangle;
import com.warlodya.game.util.Const;

public abstract class GameEntity extends Entity {
	private Modifier modifier;
	private boolean hasModifier;
	private boolean canJump;
	private boolean jumped;
	private boolean isPlayer = false;
	private int timeInJump;
	private int currentHP;
	private float jumpPower;
	private boolean damaged;
	private int timeDamaged;
	private boolean death;

	protected int maxHP;
	private State state;
	
	
	public boolean rightPressed = false;
	public boolean leftPressed = false;
	
	public GameEntity(float x, float y, float width, float height) {
		super(x, y, width, height);

	}
	
	
	public GameEntity(Rectangle rect) {
		super(rect);
		modifier = null;
		hasModifier = false;
		canJump = true;
		lookForward = true;
		timeInJump = 0;
		jumpPower=5;
	}

	protected void init() {
		death=false;
		currentHP = maxHP;
		state = State.Idle;
		speed=0;
	}
	public void doDamage(int damage) {
		//TODO
		currentHP-=damage;
		if(currentHP<0)death=true;
		damaged=true;
		timeDamaged=Const.DAMAGE_TIME;
	}
	public void update() {
		
		if(timeDamaged==0)damaged=false; 
		timeDamaged--;
	}

	public void jump() {
		if(canJump) {
			canJump=false;
			jumped=true;
			timeInJump=0;
			this.setVectorY(1);
		}
		
	}
	
	public void moveInput() {
		if(rightPressed&&!leftPressed) {
			setVectorX(1);
			lookForward=true;
			state=State.Walk;
			speed=this.minSpeed;
		}
		if(!rightPressed&&leftPressed){
			lookForward=false;
			setVectorX(-1);
			state=State.Walk;
			speed=this.minSpeed;
		}
		if((!rightPressed&&!leftPressed)||(rightPressed&&leftPressed)) {
			state=State.Idle;
			setVectorX(0);
		}
	}
	
	public boolean isDamaged() {
		return damaged;
	}

	public int getTimeDamaged() {
		return timeDamaged;
	}

	public boolean isDeath() {
		return death;
	}

	public boolean isJumped() {
		return jumped;
	}

	public void setJumped(boolean jumped) {
		this.jumped = jumped;
	}

	public float getJumpPower() {
		return jumpPower;
	}

	public void setJumpPower(float jumpPower) {
		this.jumpPower = jumpPower;
	}

	

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public boolean isPlayer() {
		return isPlayer;
	}

	protected void setPlayer() {
		isPlayer = true;
	}

	public Modifier getModifier() {
		return modifier;
	}

	public void setModifier(Modifier modifier) {
		this.modifier = modifier;
	}

	public boolean isHasModifier() {
		return hasModifier;
	}

	public void setHasModifier(boolean hasModifier) {
		this.hasModifier = hasModifier;
	}

	public boolean isCanJump() {
		return canJump;
	}

	public void setCanJump(boolean canJump) {
		this.canJump = canJump;
	}



	public int getTimeInJump() {
		return timeInJump;
	}

	public void setTimeInJump(int timeInJump) {
		this.timeInJump = timeInJump;
	}

	public int getMaxHP() {
		return maxHP;
	}

	public void setMaxHP(int maxHP) {
		this.maxHP = maxHP;
	}

	public int getCurrentHP() {
		return currentHP;
	}

	public void setCurrentHP(int currentHP) {
		this.currentHP = currentHP;
	}
}
