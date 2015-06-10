package com.missionbit.megajumper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class gameGlobals {
    public int width;
    public int height;
    public OrthographicCamera camera;
    public SpriteBatch batch;
    public Player player;


    gameGlobals() {
        width = Gdx.graphics.getWidth();
        height = Gdx.graphics.getHeight();
    }
    public void addData(OrthographicCamera camera, SpriteBatch batch, Player player) {



    }
    public void addCamera(OrthographicCamera camera) {
        this.camera = camera;
    }
    public void addBatch(SpriteBatch batch) {
        this.batch = batch;
    }
    public void addPlayer(Player player) {
        this.player = player;
    }
}
