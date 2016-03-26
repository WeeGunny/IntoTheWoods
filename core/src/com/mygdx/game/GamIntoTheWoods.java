package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Audio;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class GamIntoTheWoods extends Game {
	TextureAtlas taHero;
	TextureRegion trCurrentFrame, trLeft[], trRight[],trUp[],trDown[];
	Animation aniLeft, aniRight,aniUp,aniDown;
	Music Music;
	static Sound Steps;
	float fStateTime;
	SpriteBatch spriteBatch;
	Texture Background;
	float HeroX,HeroY,HeroSpeed=50f;

	
	@Override
	public void create () {
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
		
		spriteBatch = new SpriteBatch();
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
		trCurrentFrame= aniDown.getKeyFrame(0);
		fStateTime += Gdx.graphics.getDeltaTime();
		if(Gdx.input.isKeyPressed(Input.Keys.DPAD_LEFT)) {
			HeroX -= Gdx.graphics.getDeltaTime() * HeroSpeed;
			trCurrentFrame = aniLeft.getKeyFrame(0+fStateTime,true);
			Steps.play(0.5f);

		}
		if(Gdx.input.isKeyPressed(Input.Keys.DPAD_RIGHT)) {
			HeroX += Gdx.graphics.getDeltaTime() * HeroSpeed;
			trCurrentFrame = aniRight.getKeyFrame(0+fStateTime,true);
			Steps.play(0.5f);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.DPAD_UP)) {
			HeroY += Gdx.graphics.getDeltaTime() * HeroSpeed;
			trCurrentFrame = aniUp.getKeyFrame(0+fStateTime,true);
			Steps.play(0.5f);

		}
		if(Gdx.input.isKeyPressed(Input.Keys.DPAD_DOWN)) {
			HeroY -= Gdx.graphics.getDeltaTime() * HeroSpeed;
			trCurrentFrame = aniDown.getKeyFrame(0+fStateTime,true);
			Steps.play(0.5f);
		}
		spriteBatch.begin();
		spriteBatch.draw(Background,0,0);
		spriteBatch.draw(trCurrentFrame, (int)HeroX, (int)HeroY);
		spriteBatch.end();
	}
}
