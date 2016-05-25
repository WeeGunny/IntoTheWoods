package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;

/**
 * Created by Luke on 2016-04-07.
 */
public class StgIntoTheWoods extends Stage{
    ActChar actChar;
    DPad dPad;
    TbsMenu tbsMenu;
    GamIntoTheWoods gamIntoTheWoods;
    public static final int StageWidth=1000;
    public static final int StageHeight=1000;
    public StgIntoTheWoods(){
        super(new ScalingViewport(Scaling.stretch, StageWidth,StageHeight, new OrthographicCamera(StageWidth, StageHeight)));
        gamIntoTheWoods= new GamIntoTheWoods();
        actChar= new ActChar();
        dPad= new DPad(actChar);
        tbsMenu = new TbsMenu();
        this.addActor(actChar);
        this.addActor(dPad.imgOutline);
        for (int i = 0; i < 4; i++) {
            this.addActor(dPad.ibDir[i]);
        }
        Gdx.input.setInputProcessor(this);

    }

}
