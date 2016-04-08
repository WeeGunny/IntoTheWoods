package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;

/**
 * Created by Luke on 2016-04-07.
 */
public class StgIntoTheWoods extends Stage{
    ActChar actChar;
    public static final int StageWidth=1000;
    public static final int StageHeight=1000;
    public StgIntoTheWoods(){
        super(new ScalingViewport(Scaling.stretch, StageWidth,StageHeight, new OrthographicCamera(StageWidth, StageHeight)));
        actChar= new ActChar();
        this.addActor(actChar);
        Gdx.input.setInputProcessor(this);
    }

}
