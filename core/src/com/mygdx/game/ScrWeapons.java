package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

/**
 * Created by michelle on 4/21/2016.
 */
public class ScrWeapons implements Screen {

    GamIntoTheWoods gamIntoTheWoods;
    TbsMenu tbsMenu;
    TbMenu tbContinue;
    IbMenu ibKnife;
    Stage stage;
    SpriteBatch batch;
    String sWin;
    BitmapFont font;

    public ScrWeapons(GamIntoTheWoods gamIntoTheWoods) {
        this.gamIntoTheWoods = gamIntoTheWoods;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        stage = new Stage();
        tbsMenu = new TbsMenu();
        ibKnife = new IbMenu();
        tbContinue = new TbMenu("Continue", tbsMenu);
        tbContinue.setY(0);
        stage.addActor(tbContinue);
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        Gdx.gl.glClearColor(1, 1, 1, 1);
        batch.begin();
        stage.act();
        batch.end();
        stage.draw();
        if(tbContinue.isPressed()){
            gamIntoTheWoods.currentState = GamIntoTheWoods.GameState.BATTLE;
            gamIntoTheWoods.updateState();
        }
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
