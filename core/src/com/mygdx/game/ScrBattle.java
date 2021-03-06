package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Json;

/**
 * Created by michelle on 4/20/2016.
 *
 * Idea came from (Rectangle that shrinks for the health bar)
 * http://stackoverflow.com/questions/24356672/how-to-create-a-healthbar-in-libgdx
 */
public class ScrBattle implements Screen {

    GamIntoTheWoods gamIntoTheWoods;
    TextureAtlas taHero;
    Texture txEnemy, txHealth, txHealthBorder, txBackground, txMainC;
    TbsMenu tbsMenu;
    TbMenu tbAttack, tbWeapons;
    SpriteBatch spriteBatch;
    float fEnemyHealth, fHeroHealth;
    Stage stage;

    public ScrBattle(GamIntoTheWoods gamIntoTheWoods) {
        this.gamIntoTheWoods = gamIntoTheWoods;
    }

    @Override
    public void show() {
        stage = new Stage();
        tbsMenu = new TbsMenu();
        tbAttack = new TbMenu("Attack", tbsMenu);
        tbWeapons = new TbMenu("Weapons", tbsMenu);
        tbWeapons.setX(300);
        tbAttack.setSize(290, 100);
        tbWeapons.setSize(290, 100);
        stage.addActor(tbAttack);
        stage.addActor(tbWeapons);

        txBackground = new Texture(Gdx.files.internal("woods.jpg"));
        txMainC = new Texture(Gdx.files.internal("cinderella.png"));
        txHealthBorder = new Texture(Gdx.files.internal("healthborder.png"));
        txHealth = new Texture(Gdx.files.internal("red.png"));
        txEnemy = new Texture(Gdx.files.internal("witch.png"));
        fEnemyHealth = 200;
        fHeroHealth = 200;

        tbAttack.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                fEnemyHealth = fEnemyHealth - 10;
                System.out.println(fEnemyHealth);
                if (fEnemyHealth == 0){
                    gamIntoTheWoods.currentState = GamIntoTheWoods.GameState.WIN;
                    gamIntoTheWoods.updateState();
                }
                return true;
            }
        });
        tbWeapons.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                gamIntoTheWoods.currentState = GamIntoTheWoods.GameState.WEAPONS;
                gamIntoTheWoods.updateState();
                return true;
            }
        });

        spriteBatch = new SpriteBatch();
        Gdx.input.setInputProcessor(stage);
    }


    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        Gdx.gl.glClearColor(1,1,1,1);
        stage.act();
        spriteBatch.begin();
        spriteBatch.draw(txBackground, 0, 0);
        spriteBatch.draw(txHealthBorder, 390, 380, 220, 30);
        spriteBatch.draw(txHealth, 400, 390, fEnemyHealth, 15);
        spriteBatch.draw(txHealthBorder, 0, 380, 220, 30);
        spriteBatch.draw(txHealth, 0, 390 , fHeroHealth, 15);
        spriteBatch.draw(txEnemy, 400, 180, 200, 200);
        spriteBatch.draw(txMainC, 0, 170, 200, 200);
        spriteBatch.end();
        stage.draw();
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
