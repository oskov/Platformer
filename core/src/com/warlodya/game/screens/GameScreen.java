package com.warlodya.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.warlodya.game.GameLogic;
import com.warlodya.game.GameRenderer;
import com.warlodya.game.util.InputHandler;

public class GameScreen implements Screen {
    int i = 0;
    private GameLogic game;
    private GameRenderer renderer;

    public GameScreen() {
        game = new GameLogic();
        renderer = new GameRenderer(game);
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
