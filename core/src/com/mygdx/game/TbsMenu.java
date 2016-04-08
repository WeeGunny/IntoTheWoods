package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

/**
 * Created by michelle on 3/27/2016.
 */
public class TbsMenu extends TextButton.TextButtonStyle {
    Skin skin = new Skin();
    TextureAtlas buttonAtlas;

    public TbsMenu() {
        BitmapFont font = new BitmapFont();
        skin.add("default", font);
        buttonAtlas = new TextureAtlas(Gdx.files.internal("Button.pack"));
        skin.addRegions(buttonAtlas);
        this.up = skin.getDrawable("buttonpressed01");
        this.down = skin.getDrawable("buttonpressed02");
        this.font = skin.getFont("default");
    }

    public TextButton.TextButtonStyle getTbs() {
        return this;
    }
}

