package com.warlodya.entity;

public class Player extends GameEntity {

    public Player(float x, float y, float width, float height) {
        super(x, y, width, height);
        this.setPlayer();
        this.TextureName = "Skeleton";
        setMinSpeed(1);
        setMaxSpeed(3);
        setAcceleration(0.1f);
        setJumpPower(5);

        init();
    }

}
