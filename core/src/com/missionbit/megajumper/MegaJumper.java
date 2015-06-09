package com.missionbit.megajumper;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.missionbit.megajumper.Platforms;

public class MegaJumper extends ApplicationAdapter {
    public static SpriteBatch batch;
    public static int width;
    public static int height;
    public int score;
    public static OrthographicCamera camera;
    public Platforms platforms;
    private Song song;
    private font Font;

    @Override
    public void create () {
        batch = new SpriteBatch();
        width = Gdx.graphics.getWidth();
        height = Gdx.graphics.getHeight();
        camera = new OrthographicCamera(width,height);
        Font = new font();
        song = new Song();
        platforms = new Platforms(10);

        player.create();
        Font.create();
        song.create();
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
        player.resetGame();
        Font.resetGame();
        camera.position.set(width / 2, height / 2, 0);
        platforms.reset();

        score = 0;

    }

    private void updateGame() {
        if (player.playerPosition.x<-50){
            player.playerPosition.x=width+50;
        }
        else if (player.playerPosition.x>width+50){
            player.playerPosition.x=-50;
        }
        if(score<(int)player.playerPosition.y/50){
            score=(int)player.playerPosition.y/50;
        }
        player.velocityMod(Gdx.input.getAccelerometerX()*-200, 'x');



        if (platforms.checkCollision()) {
            if (player.playerVelocity.y < 0) {
                player.velocityMod(750, 'y');
            }
            camera.position.y=player.playerPosition.y;
        }

        player.update();
        camera.position.y=player.playerPosition.y;
    }

    private void drawGame() {
        batch.begin();
        Font.drawGame(score);
        camera.update();
        platforms.draw(batch);
        batch.setProjectionMatrix(camera.combined);
        batch.draw(player.playerImage, player.playerPosition.x, player.playerPosition.y);
        batch.end();
    }
}

class Song {
    private Music music;

    public void create() {
        music = Gdx.audio.newMusic(Gdx.files.internal("baconpancakes.mp3"));
        music.play();
    }
}