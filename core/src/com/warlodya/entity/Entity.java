package com.warlodya.entity;

import com.badlogic.gdx.math.Rectangle;

public abstract class Entity {
    protected String TextureName;
    protected float speed;
    protected int vectorX;
    protected int vectorY;
    protected float maxSpeed;
    protected float minSpeed;
    protected float acceleration;
    protected boolean lookForward;
    private Rectangle bounds;

    Entity(float x, float y, float width, float height) {
        this(new Rectangle(x, y, width, height));
    }

    Entity(Rectangle rect) {
        speed = 0;
        vectorX = 0;
        vectorY = 0;
        minSpeed = 1;
        maxSpeed = 3;
        acceleration = 1;
        bounds = rect;
    }

    public boolean isLookForward() {
        return lookForward;
    }

    public void setLookForward(boolean lookForward) {
        this.lookForward = lookForward;
    }

    public String getTextureName() {
        return TextureName;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float f) {
        this.speed = f;
    }

    public int getVectorX() {
        return vectorX;
    }

    public void setVectorX(int vectorX) {
        this.vectorX = vectorX;
    }

    public int getVectorY() {
        return vectorY;
    }

    public void setVectorY(int vectorY) {
        this.vectorY = vectorY;
    }

    public float getX() {
        return bounds.x;
    }

    public void setX(float x) {
        bounds.setX(x);
    }

    public float getY() {
        return bounds.y;
    }

    public void setY(float y) {
        bounds.setY(y);
    }

    public float getWidth() { return bounds.width; }

    public float getHeight() {
        return bounds.height;
    }

    public float getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(float f) {
        this.acceleration = f;
    }

    public float getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public float getMinSpeed() {
        return minSpeed;
    }

    public void setMinSpeed(int minSpeed) {
        this.minSpeed = minSpeed;
    }

}
