package com.warlodya.game.screens;

import java.util.ArrayList;
import java.util.LinkedList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.warlodya.entity.Entity;
import com.warlodya.game.GameLogic;
import com.warlodya.game.GameRenderer;
import com.warlodya.game.Platformer;
import com.warlodya.game.util.ContentLoader;
import com.warlodya.game.util.InputHandler;

public class GameScreen implements Screen {
	private Platformer application;
	private GameLogic game;
	private GameRenderer renderer;
	int i=0;
	public GameScreen(Platformer app) {
		game = new GameLogic();
		renderer=new GameRenderer(game);
		application = app;
		InputMultiplexer input = new InputMultiplexer(new InputHandler(game));
		Gdx.input.setInputProcessor(input);

	}

	@Override
	public void show() {

	}

	@Override
	public void render(float delta) {
		game.update();	
		
		renderer.render();
		i++;
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
