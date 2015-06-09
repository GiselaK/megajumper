package com.missionbit.megajumper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.missionbit.megajumper.MegaJumper;

/**
 * Created by giselakottmeier on 6/9/15.
 */
public class font {
    private BitmapFont font;


    public void create() {
//        font = new Texture("font.png");
        font = new BitmapFont(Gdx.files.internal("font.fnt"), Gdx.files.internal("font.png"), false);
    }
    public void resetGame(){

    }
    public void drawGame(int score){
        font.setColor(Color.BLACK);
        font.draw(MegaJumper.batch,score+"",MegaJumper.width/2,MegaJumper.camera.position.y+MegaJumper.height/2-font.getLineHeight());
//        font.draw(MegaJumper.batch,””+ score, MegaJumper.width/2,MegaJumper.camera.position.y+MegaJumper.height/2-font.getLineHeight());
    }
}