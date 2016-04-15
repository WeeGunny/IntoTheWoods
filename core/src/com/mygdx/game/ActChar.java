package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by Luke on 2016-04-07.
 */
public class ActChar extends Actor {
    TextureAtlas taHero;
    TextureRegion trCurrentFrame, trLeft[], trRight[],trUp[],trDown[];
    Animation aniLeft, aniRight,aniUp,aniDown;
    Animation[] arAnimations;
    com.badlogic.gdx.audio.Music Music;
    static Sound Steps;
    float fStateTime;
    int nDir;
    SpriteBatch spriteBatch;
    Texture Background;
    float HeroX,HeroY,HeroSpeed=50f;
    public ActChar(){
        Background= new Texture(Gdx.files.internal("lostwoods2.jpg"));
        taHero = new TextureAtlas("Heroinepacked.pack");
        trCurrentFrame = new TextureRegion();
        Steps= Gdx.audio.newSound(Gdx.files.internal("Steps.mp3"));
        Music= Gdx.audio.newMusic(Gdx.files.internal("IntoTheWoods(Prologue).mp3"));
        Music.isLooping();
        Music.play();

        trLeft = new TextureRegion[3];
        trRight = new TextureRegion[3];
        trUp = new TextureRegion[3];
        trDown = new TextureRegion[3];
        for (int i = 0; i < 3; i++) {
            trLeft[i] = taHero.findRegion("Left" + (i + 1));
            trRight[i] = taHero.findRegion("Right" + (i + 1));
            trUp[i] = taHero.findRegion("Up" + (i + 1));
            trDown[i] = taHero.findRegion("Down" + (i + 1));
        }
        aniRight= new Animation(1f/8,trRight);
        aniLeft= new Animation(1f/8,trLeft);
        aniUp= new Animation(1f/8,trUp);
        aniDown= new Animation(1f/8,trDown);
//		arAnimations 0=down 1=right 2=left 3=up
        arAnimations= new Animation[]{aniDown,aniRight,aniLeft,aniUp};
        spriteBatch = new SpriteBatch();

    }
    public void setDir(int _nDir){
        nDir = _nDir;
        System.out.println(nDir);

    }
    public void Act(){
        trCurrentFrame= aniDown.getKeyFrame(0);
        fStateTime += Gdx.graphics.getDeltaTime();
        if(nDir==2) {
            HeroX -= Gdx.graphics.getDeltaTime() * HeroSpeed;
            trCurrentFrame = aniLeft.getKeyFrame(0+fStateTime,true);
            Steps.play(0.5f);

        }
        if(nDir==1) {
            HeroX += Gdx.graphics.getDeltaTime() * HeroSpeed;
            trCurrentFrame = aniRight.getKeyFrame(0+fStateTime,true);
            Steps.play(0.5f);
        }
        if(nDir==3) {
            HeroY += Gdx.graphics.getDeltaTime() * HeroSpeed;
            trCurrentFrame = aniUp.getKeyFrame(0+fStateTime,true);
            Steps.play(0.5f);

        }
        if(nDir==0) {
            HeroY -= Gdx.graphics.getDeltaTime() * HeroSpeed;
            trCurrentFrame = aniDown.getKeyFrame(0+fStateTime,true);
            Steps.play(0.5f);
        }
        else{
            trCurrentFrame = aniDown.getKeyFrame(0);
        }
    }
    public void Draw(){
        spriteBatch.begin();
        spriteBatch.draw(Background,0,0);
        spriteBatch.draw(trCurrentFrame, (int)HeroX, (int)HeroY);
        spriteBatch.end();
    }

}
