package com.warlodya.game.util;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.warlodya.entity.Player;
import com.warlodya.game.GameLogic;

public class InputHandler implements InputProcessor {
    private GameLogic game;
    private Player player;

    public InputHandler(GameLogic game) {
        player = game.getPlayer();

    }

    @Override
    public boolean keyDown(int keycode) {
        boolean moveinput = false;
        switch (keycode) {
            case Keys.A:
                player.leftPressed = true;
                moveinput = true;
                break;
            case Keys.D:
                moveinput = true;
                player.rightPressed = true;
                break;
            case Keys.W:
                player.jump();
                break;
        }
        if (moveinput)
            player.moveInput();
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        boolean moveinput = false;
        switch (keycode) {
            case Keys.A:
                player.leftPressed = false;
                moveinput = true;
                break;
            case Keys.D:
                moveinput = true;
                player.rightPressed = false;
                break;

        }
        if (moveinput)
            player.moveInput();
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        if (character == 'o') Const.DEBUG = !Const.DEBUG;
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        // TODO Auto-generated method stub
        return false;
    }

}
