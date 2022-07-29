package com.mygdx.voxel.space.voxel;

import com.badlogic.gdx.graphics.Color;

import java.util.HashMap;

public class indexVoxel {
    HashMap<String,Voxel> voxelmapDb;

    public indexVoxel() {
        this.voxelmapDb = new HashMap<>();
    }

    private Voxel getVoxel(int x, int y){
        return voxelmapDb.get(generateHash(x,y));
    }

    private void generate(int x, int y, Color color, float height){
        this.voxelmapDb.put(generateHash(x,y),new Voxel(color,height));
    }

    private String generateHash(int x, int y){
        return "x"+x+"y"+y;
    }
}
