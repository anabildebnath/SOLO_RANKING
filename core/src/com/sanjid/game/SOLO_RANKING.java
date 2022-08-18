package com.sanjid.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.sanjid.game.States.GameStateManager;
import com.sanjid.game.States.MenuState;

public class SOLO_RANKING extends ApplicationAdapter {
	public static final int WIDTH = 1000;
	public static final int HEIGHT = 800;
	public static final float SCALE = 0.5f;
	public static final String TITLE = "SOLO_RANKING";

	private SpriteBatch spriteBatch;
	private GameStateManager gameStateManager;
    public Music music;

	@Override
	public void create () {
		spriteBatch = new SpriteBatch();
		gameStateManager = new GameStateManager();
		music = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
		music.setLooping(true);
		music.setVolume(0.1f);
		music.play();
		gameStateManager.push(new MenuState(gameStateManager));

		Gdx.gl.glClearColor(1, 0, 0, 1);
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gameStateManager.update(Gdx.graphics.getDeltaTime());
		gameStateManager.render(spriteBatch);
	}
	public void dispose(){
		super.dispose();
		music.dispose();
	}
}
