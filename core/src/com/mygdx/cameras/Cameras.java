package com.mygdx.cameras;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Cameras extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	OrthographicCamera camera;

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("image.png");
		camera = new OrthographicCamera(
				Gdx.graphics.getWidth(),
				Gdx.graphics.getHeight()
		);
		camera.translate(
				camera.viewportWidth / 2,
				camera.viewportHeight / 2
		);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		camera.update();
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
