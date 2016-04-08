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
    public ScrIntoTheWoods(GamIntoTheWoods gamIntoTheWoods){
        stgIntoTheWoods= new StgIntoTheWoods();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stgIntoTheWoods.draw();
        stgIntoTheWoods.act();


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
