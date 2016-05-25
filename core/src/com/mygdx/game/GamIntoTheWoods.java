package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Audio;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
// Mrgfhci animation1 project

public class GamIntoTheWoods extends Game {
	ScrIntoTheWoods scrIntoTheWoods;
	ScrMain scrMain;
	ScrBattle scrBattle;
	ScrWin scrWin;
	ScrWeapons scrWeapons;
	public enum GameState {
		MENU, GAME, BATTLE, WIN, WEAPONS
	}
	public GameState currentState;
	public void updateState(){
		if(currentState==GameState.MENU){
			setScreen(scrMain);
		}else if(currentState==GameState.GAME) {
			setScreen(scrIntoTheWoods);
		}
		else if(currentState==GameState.BATTLE){
			setScreen(scrBattle);
		}
		else if(currentState==GameState.WEAPONS){
			setScreen(scrWeapons);
		}
		else if(currentState==GameState.WIN){
			setScreen(scrWin);
		}


	}

	@Override
	public void create () {
		setScreen(new ScrIntoTheWoods(this));
		scrMain = new ScrMain(this);
		scrIntoTheWoods = new ScrIntoTheWoods(this);
		scrBattle= new ScrBattle(this);
		scrWin= new ScrWin(this);
		scrWeapons= new ScrWeapons(this);
		currentState = GameState.MENU; //Set the current state to the main menu, and update it.
		updateState();

	}

	@Override
	public void render () {
		super.render();
	}

}
