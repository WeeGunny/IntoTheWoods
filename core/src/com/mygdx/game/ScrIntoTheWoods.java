package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;

/**
 * Created by Luke on 2016-04-07.
 */
public class ScrIntoTheWoods implements Screen{
    StgIntoTheWoods stgIntoTheWoods;
    GamIntoTheWoods gamIntoTheWoods;
    public ScrIntoTheWoods(GamIntoTheWoods gamIntoTheWoods) {
        this.gamIntoTheWoods = gamIntoTheWoods;
    }

    @Override
    public void show() {
        stgIntoTheWoods= new StgIntoTheWoods();
        Gdx.input.setInputProcessor(stgIntoTheWoods);

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stgIntoTheWoods.act();
        stgIntoTheWoods.draw();


    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
