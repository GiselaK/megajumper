package com.missionbit.megajumper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.missionbit.megajumper.MegaJumper;

/**
 * Created by giselakottmeier on 6/9/15.
 */
public class font {
    private BitmapFont font;
    private static int score;

    public void create() {
//        font = new Texture("font.png");
//        font = new BitmapFont(Gdx.files.internal("font.fnt"), Gdx.files.internal("font.png"), false);
    }
    public static void resetGame(){
        score=0;
    }
    public static void update(){
        score+=1;
    }
    public  void drawGame(){
//        font.draw(MegaJumper.batch,score+"",MegaJumper.width/2,MegaJumper.camera.position.y+MegaJumper.height/2-font.getLineHeight());
//        font.draw(MegaJumper.batch,””+ score, MegaJumper.width/2,MegaJumper.camera.position.y+MegaJumper.height/2-font.getLineHeight());
    }
}