package com.mygdx.voxel.space;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.voxel.space.voxel.IndexVoxel;

import java.awt.image.IndexColorModel;

public class VoxelSpace extends ApplicationAdapter {
	SpriteBatch batch;
	Texture col, vox;
	Pixmap pm;


	Vector3 position_camera;
	float rotation_camera;

	private Viewport viewport;
	private Camera camera;

	private IndexVoxel indexVoxel;

	@Override
	public void create () {


		batch = new SpriteBatch();
		vox = new Texture("badlogic.jpg");


		col = new Texture("maps\\C1W.png");
		vox = new Texture("maps\\D1.png");


//		//C:\Games\VoxelSpace\assets\maps\C1W.png
//		img.getTextureData().prepare();
//		pm = img.getTextureData().consumePixmap();

		position_camera = new Vector3(50,50,50);
		rotation_camera = 0;

		camera = new OrthographicCamera();

		viewport = new FitViewport(1280, 720, camera);

		indexVoxel = new IndexVoxel(col,vox);

	}

	@Override
	public void render () {
		//camera.position.set(0,480,1);
		this.camera.update();
		this.batch.setProjectionMatrix(camera.combined);


//		if(position_camera.x < 0)
//		position_camera.sub(100 * Gdx.graphics.getDeltaTime(),100 * Gdx.graphics.getDeltaTime(),0);
//
//		if(position_camera.x > 500)position_camera.add(100 * Gdx.graphics.getDeltaTime(),100 * Gdx.graphics.getDeltaTime(),0);
////		pm.getPixel(12, MathUtils.random(0,img.getHeight()));
////		System.out.println(
////				pm.getPixel(12, MathUtils.random(0,img.getHeight()))

//		);
//		Color c = new Color(pm.getPixel(MathUtils.random(0,img.getHeight()), MathUtils.random(0,img.getHeight())));
//		System.out.println(c.r);
//		System.out.println(c.b);
//		System.out.println(c.g);



//		for (int i = 0; i < 30; i++) { // линий визуализации
//			for (int j = 0; j < 150; j++) {
//
//			}
//		}
//
////		for (int j = 1; j < img.getTextureData().getHeight(); j++)
////		for (int i = 1; i < img.getTextureData().getHeight(); i++) {
////			if(MathUtils.randomBoolean(.995f))continue;
////			c = new Color(pm.getPixel(i,j));
////
////			batch.setColor(c);
////			batch.begin();
////				batch.draw(vox, i, j ,5,20);
////			batch.end();
////
////		}
	//	indexVoxel.rander_map(batch,position_camera,rotation_camera);

//		for (int i = 0; i < 30; i++) { // линий визуализации
//			for (int j = 0; j < 150; j++) {
//
//			}
//		}
//
////		for (int j = 1; j < img.getTextureData().getHeight(); j++)
////		for (int i = 1; i < img.getTextureData().getHeight(); i++) {
////			if(MathUtils.randomBoolean(.995f))continue;
////			c = new Color(pm.getPixel(i,j));
////
////			batch.setColor(c);
////			batch.begin();
////				batch.draw(vox, i, j ,5,20);
////			batch.end();
////
////		}
		indexVoxel.rander_map(batch,position_camera,rotation_camera);
		System.out.println(camera.position);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		col.dispose();
		vox.dispose();
	}

	public void resize(int width, int height) {
		viewport.update(width, height);
	}
}
