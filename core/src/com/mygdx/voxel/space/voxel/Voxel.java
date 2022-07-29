package com.mygdx.voxel.space.voxel;

import com.badlogic.gdx.graphics.Color;

public class Voxel {
    Color color; // цвет
    float vert; // высота

    public Voxel(Color color, float vert) {
        this.color = color;
        this.vert = vert;
    }

    public Color getColor() {
        return color;
    }

    public float getVert() {
        return vert;
    }
}
