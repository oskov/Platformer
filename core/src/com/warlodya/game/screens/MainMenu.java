package com.warlodya.game.screens;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.warlodya.game.Platformer;
public class MainMenu implements Screen {
	private Stage stage;
	private Platformer platformer;
	
	private TextureAtlas atlas;
	private Skin skin;
	
	private Table root;
	
	
	public MainMenu(Platformer platformer) {
		this.platformer = platformer;
		stage= new Stage();
		TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("skin/skin.atlas"));
		skin=new Skin(atlas);
		skin.load(Gdx.files.internal("skin/skin.json"));
	}
	
	
	

	@Override
	public void show() {
		 Gdx.input.setInputProcessor(stage);
		 Table RootTable = new Table();
		 RootTable.setFillParent(true);
		 TextButton serverButton = new TextButton("CreateServer", skin);
	     TextButton clientButton = new TextButton("ConnectToServer", skin);
	     TextButton exitButton = new TextButton("Exit", skin);
	     
	     serverButton.addListener(new ClickListener(){
	            public void clicked(InputEvent event, float x, float y) {
	                platformer.setScreen(new GameScreen());
	            }
	        });
	     
	     RootTable.add(serverButton);
	     RootTable.row();
	     RootTable.add(clientButton);
	     RootTable.row();
	     RootTable.add(exitButton);
	     stage.addActor(RootTable);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(.1f, .12f, .16f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act();
        stage.draw();
		
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
