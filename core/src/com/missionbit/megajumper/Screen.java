package com.missionbit.megajumper;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Screen {
    public SpriteBatch batch;
    private Song song;
    private Font font;
    private int score;

    Screen(String songLocation, gameGlobals globals) {
        batch = new SpriteBatch();
        song = new Song();
        song.create(songLocation);
        font = new Font(globals);
    }
    public void startDraw() {
        batch.begin();
        font.drawGame(score);
    }
    public void endDraw() {
        batch.end();
    }
    public void setScore(int score) {
        this.score = score;
    }
    public int getScore() {
        return score;
    }
    public SpriteBatch getBatch() {
        return batch;
    }
}
