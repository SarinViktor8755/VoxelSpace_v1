package com.mygdx.voxel.space.voxel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
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

    Vector3 pos_hero;

    public IndexVoxel(Texture color, Texture voxel) { // w - x ;; h -y
        pos_hero = new Vector3(0,0,0);
        System.out.println("start");
        this.max_w = color.getWidth();
        this.max_h = color.getHeight();
        this.voxelmapDb = new HashMap<>();
        Color color_v = new Color();
        color.getTextureData().prepare();
        Pixmap pm = color.getTextureData().consumePixmap();
        float col = 0;
        for (int w = 1; w <= max_w; w++) {
            for (int h = 1; h <= max_h; h++) {

                color_v.set(pm.getPixel(w, h));
                medium_color.add(color_v);

                //  color_v.set(pm.getPixel(w,h));
                generate(w, h, color_v, 22);
                col++;
            }

        }
        medium_color.r = medium_color.r / col;
        medium_color.b = medium_color.b / col;
        medium_color.g = medium_color.g / col;
        System.out.println("mc " + medium_color.r);
        batch = new SpriteBatch();

        //  System.out.println(voxelmapDb);
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

        this.voxelmapDb.put(generateHash(x, y), new Voxel(new Color(color), height));
    }

    private String generateHash(int x, int y) {
        return x + "-" + y;
    }

    public void rander_map(SpriteBatch spriteBatch, Vector3 pos, float rot) {
        // if (MathUtils.randomBoolean(0.005f))
            ScreenUtils.clear(medium_color);
        batch.begin();

        for (int w = 1; w < 700; w++) {
            for (int h = 1; h < 300; h++) {
                //  System.out.println("--  "+getVoxel(h,w));
                if (!MathUtils.randomBoolean(.99f)) continue;
                Voxel v = getVoxel(w, h);

                batch.setColor(v.color);
                batch.draw(vox, pos.x + w * 2, pos.x + h *2 ,3,3);

            }

        }
        batch.end();
    }

    private void processManagement(){
        //if(inputKey.isBack()) pos_hero
        
    }


}
