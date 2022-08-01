package com.mygdx.voxel.space;

import com.badlogic.gdx.InputProcessor;


public class InputKey implements InputProcessor {
    boolean forward = false;
    boolean back = false;
    boolean left = false;
    boolean right = false;

    @Override
    public boolean keyDown(int keycode) {

        if (keycode == 29) this.left = true;
        if (keycode == 32) this.right = true;
        if (keycode == 51) this.forward = true;
        if (keycode == 47) this.back = true;


        return false;
    }

    @Override
    public boolean keyUp(int keycode) {

        if (keycode == 29) this.left = false;
        if (keycode == 32) this.right = false;
        if (keycode == 51) this.forward = false;
        if (keycode == 47) this.back = false;

        return false;
    }

    @Override
    public boolean keyTyped(char character) {

        // System.out.println(character);
        return true;
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
