package com.warlodya.entity;

import com.badlogic.gdx.math.Rectangle;

public abstract class GameEntity extends Entity {
    public boolean rightPressed = false;
    public boolean leftPressed = false;
    private boolean canJump;
    private boolean jumped;
    private boolean isPlayer = false;
    private int timeInJump;
    private float jumpPower;
    private boolean death;
    private State state;

    public GameEntity(float x, float y, float width, float height) {
        super(x, y, width, height);

    }

    public GameEntity(Rectangle rect) {
        super(rect);
        canJump = true;
        lookForward = true;
        timeInJump = 0;
        jumpPower = 5;
    }

    protected void init() {
        death = false;
        state = State.Idle;
        speed = 0;
    }

    public void update() {
    }

    public void jump() {
        if (canJump) {
            canJump = false;
            jumped = true;
            timeInJump = 0;
            this.setVectorY(1);
        }

    }

    public void moveInput() {
        if (rightPressed && !leftPressed) {
            setVectorX(1);
            lookForward = true;
            state = State.Walk;
            speed = this.minSpeed;
        }
        if (!rightPressed && leftPressed) {
            lookForward = false;
            setVectorX(-1);
            state = State.Walk;
            speed = this.minSpeed;
        }
        if ((!rightPressed && !leftPressed) || (rightPressed && leftPressed)) {
            state = State.Idle;
            setVectorX(0);
        }
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
}
