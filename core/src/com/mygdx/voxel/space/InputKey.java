package com.mygdx.voxel.space;

import com.badlogic.gdx.InputProcessor;
<<<<<<< HEAD
import com.badlogic.gdx.math.MathUtils;
=======
>>>>>>> 1a9c7938884db88e8ed83832126053ecf03f9069

public class InputKey implements InputProcessor {
    boolean forward = false;
    boolean back = false;
    boolean left = false;
    boolean right = false;

    @Override
    public boolean keyDown(int keycode) {
<<<<<<< HEAD
        if (keycode == 29) this.left = true;
        if (keycode == 32) this.right = true;
        if (keycode == 51) this.forward = true;
        if (keycode == 47) this.back = true;

        System.out.println(keycode);
=======
        if(keycode==29) this.left = false;
        if(keycode==32) this.right = false;
        if(keycode==51) this.forward = false;
        if(keycode==57) this.back = false;
>>>>>>> 1a9c7938884db88e8ed83832126053ecf03f9069
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
<<<<<<< HEAD
        if (keycode == 29) this.left = false;
        if (keycode == 32) this.right = false;
        if (keycode == 51) this.forward = false;
        if (keycode == 47) this.back = false;
=======
        if(keycode==29) this.left = true;
        if(keycode==32) this.right = true;
        if(keycode==51) this.forward = true;
        if(keycode==57) this.back = true;
>>>>>>> 1a9c7938884db88e8ed83832126053ecf03f9069
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
<<<<<<< HEAD
        // System.out.println(character);
=======
        System.out.println(character);
>>>>>>> 1a9c7938884db88e8ed83832126053ecf03f9069
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }

    public boolean isForward() {
        return forward;
    }

    public boolean isBack() {
        return back;
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }
}
