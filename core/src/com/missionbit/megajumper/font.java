package com.missionbit.megajumper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

import com.missionbit.megajumper.gameGlobals;

public class Font {
    private BitmapFont font;
    private gameGlobals globals;

    Font(gameGlobals globals) {
        this.globals = globals;
    }
    public void create() {
        font = new BitmapFont(Gdx.files.internal("font.fnt"), Gdx.files.internal("font.png"), false);
    }
    public void resetGame(){
    }
    public void drawGame(int score){
        font.setColor(Color.BLACK);
        font.draw(globals.batch,score+"", globals.width/2, globals.camera.position.y+globals.height/2-font.getLineHeight());
    }
}