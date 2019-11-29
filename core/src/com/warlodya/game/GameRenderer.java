package com.warlodya.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.warlodya.entity.GameEntity;
import com.warlodya.entity.Player;
import com.warlodya.entity.State;
import com.warlodya.game.util.Const;
import com.warlodya.game.util.ContentLoader;

import java.util.HashMap;
import java.util.LinkedList;

public class GameRenderer {
    private GameLogic game;
    private OrthographicCamera camera;
    private ShapeRenderer shapeRenderer;
    private Stage stage;
    private Skin skin;
    private ScreenViewport view;
    private AssetManager manager;
    private SpriteBatch batch;
    private HashMap<String, HashMap<State, Animation<TextureRegion>>> textures;
    private float stateTime;
    private float worldLenght;

    public GameRenderer(GameLogic game) {
        this.game = game;
        batch = new SpriteBatch();
        shapeRenderer = new ShapeRenderer();
        manager = ContentLoader.getManager();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        textures = new HashMap<>();
        view = new ScreenViewport(camera);
        worldLenght = game.getGameMap().length * Const.BLOCK_SIZE;
        loadTextures();

    }

    private void loadTextures() {
        loadTexture("textures/Skeleton Walk.png", "Skeleton", State.Walk, 13);
        loadTexture("textures/Skeleton Idle.png", "Skeleton", State.Idle, 11);
    }

    private void loadTexture(String path, String name, State state, int frames) {
        Texture tex = manager.get(path);
        loadTexture(tex, name, state, frames);
    }

    // Loads Texture as animation
    private void loadTexture(Texture tex, String name, State state, int frames) {

        TextureRegion[][] tmp = TextureRegion.split(tex, tex.getWidth() / frames, tex.getHeight());
        TextureRegion[] walkframes = new TextureRegion[frames];
        for (int i = 0; i < frames; i++)
            walkframes[i] = tmp[0][i];
        Animation<TextureRegion> animation = new Animation<TextureRegion>(0.1f, walkframes);
        HashMap<State, Animation<TextureRegion>> texture = new HashMap<>();
        texture.put(state, animation);

        textures.put(name + state, texture);
    }

    public void render() {
        Gdx.gl.glClearColor(200, 200, 200, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        renderMap();
        renderMobs();
        stateTime += Gdx.graphics.getDeltaTime();

        batch.setProjectionMatrix(camera.combined);
        shapeRenderer.setProjectionMatrix(camera.combined);
        moveCamera();

    }

    private void moveCamera() {
        Player player = game.getPlayer();
        float x = player.getX();
        float y = player.getY();
        float cameraX = 0;
        float cameraY = camera.viewportHeight / 2;

        if (x < camera.viewportWidth / 2) {
            cameraX = camera.viewportWidth / 2;

        } else if (x + camera.viewportWidth / 2 > worldLenght) {
            cameraX = worldLenght - camera.viewportWidth / 2;
        } else cameraX = x;
        if (y < camera.viewportHeight / 2) {
            cameraY = camera.viewportHeight / 2;

        } else if (y + camera.viewportHeight / 2 > worldLenght) {
            cameraY = worldLenght - camera.viewportHeight / 2;
        } else cameraY = y;

        //camera.position.set(game.getPlayer().getX(), game.getPlayer().getY(), 0);
        camera.position.set(cameraX, cameraY, 0);
        camera.update();
    }

    private void renderMap() {
        int[][] map = game.getGameMap();
        GameEntity tmp = game.getmobList().getFirst();
        shapeRenderer.setAutoShapeType(true);
        shapeRenderer.begin();
        shapeRenderer.set(ShapeType.Filled);

        for (int a = 0; a < map.length; a++) {
            for (int b = 0; b < map.length; b++) {
                if (map[a][b] == 1)
                    shapeRenderer.setColor(Color.GOLD);
                else if (map[a][b] == 0)
                    shapeRenderer.setColor(Color.BLACK);
                else shapeRenderer.setColor(Color.CYAN);
                shapeRenderer.rect(b * Const.BLOCK_SIZE, a * Const.BLOCK_SIZE, Const.BLOCK_SIZE, Const.BLOCK_SIZE);
            }

        }
        if (Const.DEBUG) {
            shapeRenderer.setColor(Color.BROWN);
            shapeRenderer.rect(((int) tmp.getX() / Const.BLOCK_SIZE) * Const.BLOCK_SIZE,
                    (int) tmp.getY() / Const.BLOCK_SIZE * Const.BLOCK_SIZE, Const.BLOCK_SIZE, Const.BLOCK_SIZE);
        }
        shapeRenderer.end();

    }

    private void renderMobs() {
        LinkedList<GameEntity> ent = game.getmobList();
        batch.begin();
        for (GameEntity e : ent) {
            if (!Const.DEBUG) {
                Animation<TextureRegion> animation = textures.get(e.getTextureName() + e.getState()).get(e.getState());
                TextureRegion currentFrame = animation.getKeyFrame(stateTime, true);
                boolean flip = !e.isLookForward();
                batch.draw(currentFrame, flip ? e.getX() + e.getWidth() : e.getX(), e.getY(),
                        flip ? -e.getWidth() : e.getWidth(),                        // trick for performance
                        e.getHeight());
            } else {
                renderDebug(e);
            }
        }

        batch.end();

    }

    private void renderDebug(GameEntity e) {
        shapeRenderer.begin();
        shapeRenderer.set(ShapeType.Filled);
        shapeRenderer.setColor(Color.BLUE);
        shapeRenderer.rect(e.getX(), e.getY(), e.getWidth(), e.getHeight());
        shapeRenderer.end();

    }

}
