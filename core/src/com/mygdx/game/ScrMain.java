package com.mygdx.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

/**
 * Created by michelle on 3/22/2016.
 */
 public class ScrMain implements Screen {

    GamIntoTheWoods gamIntoTheWoods;
    TbsMenu tbsMenu;
    TbMenu tbPlay, tbInstr;
    Stage stage;
    SpriteBatch batch;

    public ScrMain(GamIntoTheWoods gamIntoTheWoods) {
        this.gamIntoTheWoods = gamIntoTheWoods;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        stage = new Stage();
        tbsMenu = new TbsMenu();
        tbPlay = new TbMenu("Play", tbsMenu);
        tbInstr = new TbMenu("Instructions", tbsMenu);
        tbPlay.setY(200);
        stage.addActor(tbPlay);
        stage.addActor(tbInstr);
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        Gdx.gl.glClearColor(1,1,1,1);
        batch.begin();
        stage.act();
        batch.end();
        stage.draw();
        if(tbPlay.isPressed()){
            gamIntoTheWoods.currentState = GamIntoTheWoods.GameState.GAME;
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
