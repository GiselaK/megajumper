package com.missionbit.megajumper;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;


import com.missionbit.megajumper.gameGlobals;

public class MegaJumper extends ApplicationAdapter {
    public gameGlobals globals;
    public Game game;


    @Override
    public void create () {
        game = new Game("baconpancakes.mp3", globals);
        resetGame();
    }

    @Override
    public void render () {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        updateGame();
        drawGame();
    }

    private void resetGame() {
        game.reset();
    }

    private void updateGame() {
        game.update();
    }

    private void drawGame() {
        game.draw();
    }
}