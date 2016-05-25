package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;

/**
 * Created by michelle on 4/20/2016.
 */
public class ScrWin implements Screen{
    GamIntoTheWoods gamIntoTheWoods;
    TbsMenu tbsMenu;
    TbMenu tbContinue;
    Stage stage;
    SpriteBatch batch;
    String sWin;
    BitmapFont font;

    public ScrWin(GamIntoTheWoods GamIntoTheWoods) {
        this.gamIntoTheWoods = gamIntoTheWoods;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        stage = new Stage();
        tbsMenu = new TbsMenu();
        font = new BitmapFont();
        tbContinue = new TbMenu("Continue", tbsMenu);
        tbContinue.setY(0);
        stage.addActor(tbContinue);
        sWin = "You win!";
        Gdx.input.setInputProcessor(stage);
        tbContinue.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                gamIntoTheWoods.currentState = GamIntoTheWoods.GameState.GAME;
                gamIntoTheWoods.updateState();
                return true;
            }
        });
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        Gdx.gl.glClearColor(.135f, .206f, .235f, 1);
        batch.begin();
        stage.act();
        font.draw(batch, sWin, 500, 500);
        font.draw(batch,"You Win", 500,500);
        batch.end();
        stage.draw();
//        if(tbContinue.isPressed()){
//            gamIntoTheWoods.currentState = GamIntoTheWoods.GameState.GAME;
//            gamIntoTheWoods.updateState();
//        }


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
