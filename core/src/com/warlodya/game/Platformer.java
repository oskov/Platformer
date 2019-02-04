package com.warlodya.game;

import com.badlogic.gdx.Game;

import com.warlodya.game.screens.GameScreen;
import com.warlodya.game.screens.MainMenu;
import com.warlodya.game.util.ContentLoader;

public class Platformer extends Game {
	private ContentLoader loader;
	@Override
	public void create() {
		loader=new ContentLoader();
		loader.finishLoad();
		setScreen(new MainMenu(this));
		
	}


}
