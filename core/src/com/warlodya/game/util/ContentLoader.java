package com.warlodya.game.util;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

public class ContentLoader {
    private static AssetManager manager;

    public ContentLoader() {
        manager = new AssetManager();
        manager.load("textures/mob.png", Texture.class);
        manager.load("textures/Skeleton Walk.png", Texture.class);
        manager.load("textures/Hp.png", Texture.class);
        manager.load("textures/Skeleton Dead.png", Texture.class);
        manager.load("textures/Skeleton Idle.png", Texture.class);
        manager.load("textures/Skeleton Hit.png", Texture.class);
        manager.load("textures/Skeleton Attack.png", Texture.class);
        manager.load("textures/Skeleton React.png", Texture.class);

    }

    public static AssetManager getManager() {
        return manager;
    }

    public void finishLoad() {
        manager.finishLoading();
    }

}
