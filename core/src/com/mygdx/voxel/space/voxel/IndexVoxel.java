package com.mygdx.voxel.space.voxel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;

import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.voxel.space.InputKey;

import java.util.HashMap;

public class IndexVoxel {
    SpriteBatch batch;
    HashMap<String, Voxel> voxelmapDb;
    private int max_h, max_w;
    Texture vox = new Texture("badlogic.jpg");
    Pixmap pmap = new Pixmap(4, 10, Pixmap.Format.RGBA8888);
    Color medium_color = new Color(0, 0, 0, 1);
    InputKey inputKey = new InputKey();

    Vector3 pos_hero = new Vector3(500, 500, 0);

    public IndexVoxel(Texture color, Texture voxel) { // w - x ;; h -y

        System.out.println("start");
        this.max_w = color.getWidth();
        this.max_h = color.getHeight();
        this.voxelmapDb = new HashMap<>();
        Color color_v = new Color();
        Color hide_color = new Color();
        color.getTextureData().prepare();
        voxel.getTextureData().prepare();
        Pixmap pm = color.getTextureData().consumePixmap();
        Pixmap pmv = voxel.getTextureData().consumePixmap();
        /////////////////////

        /////////////////////

        float col = 0;
        for (int w = 1; w <= max_w; w++) {
            for (int h = 1; h <= max_h; h++) {

                color_v.set(pm.getPixel(w, h));
                hide_color.set(pmv.getPixel(w, h));
                medium_color.add(color_v);

                generate(w, h, color_v, hide_color.a);
                col++;
            }

        }
        medium_color.r = medium_color.r / col;
        medium_color.b = medium_color.b / col;
        medium_color.g = medium_color.g / col;
        System.out.println("mc " + medium_color.r);
        batch = new SpriteBatch();

        System.out.println("!END");

        Gdx.input.setInputProcessor(inputKey);


    }


    private Voxel getVoxel(int x, int y) {
        //  System.out.println(generateHash(x, y) + " !!!");
        return voxelmapDb.get(generateHash(x, y));
    }

    private void generate(int x, int y, float r, float b, float g, float height) {

        this.voxelmapDb.put(generateHash(x, y), new Voxel(new Color(r, b, g, 1), height));
    }

    private void generate(int x, int y, Color color, float height) {
        Voxel v = new Voxel(new Color(color), height);
        //  System.out.println(v);
        this.voxelmapDb.put(generateHash(x, y), v);
    }

    private String generateHash(int x, int y) {
        return x + "-" + y;
    }

    public void rander_map(SpriteBatch spriteBatch, Vector3 pos, float rot) {
        // if (MathUtils.randomBoolean(0.005f))
        processManagement();

        batch.begin();

        for (int h = 110; h > 1; h--) {
            for (int w = 350 + h; w > 1 - h; w--) {

                //  System.out.println("--  "+getVoxel(h,w));
                if (!MathUtils.randomBoolean(.3f)) continue;
                try {
                    Voxel v = getVoxel(w + (int) pos_hero.x, h + (int) pos_hero.y);

                } catch (NullPointerException e) {
                    if (w + (int) pos_hero.x <= 0) w *= -1;
                    if (h + (int) pos_hero.x <= 0) h *= -1;

                    if (w > max_w) w = 1;
                    if (h > max_h) h = 1;

                } finally {
                    Voxel v = getVoxel(w + (int) pos_hero.x, h + (int) pos_hero.y);
                    batch.setColor(v.color);
                    batch.draw(vox, w, h, 3, 1 + v.getVert() * 100);
                }
            }
        }
        batch.end();

    }


    private void processManagement() {
        boolean move = false;
        if (MathUtils.randomBoolean(.05f)) System.out.println(pos_hero);
        float dt = Gdx.graphics.getDeltaTime();
        if (inputKey.isLeft()) {
            pos_hero.sub(100 * dt, 0, 0);
            move = true;
        }
        if (inputKey.isRight()) {
            pos_hero.add(100 * dt, 0, 0);
            move = true;
        }

        if (inputKey.isForward()) {
            pos_hero.add(0, 100 * dt, 0);
            move = true;
        }
        if (inputKey.isBack()) {
            pos_hero.sub(0, 100 * dt, 0);
            move = true;
        }
        if (move) ScreenUtils.clear(medium_color);

    }


}
