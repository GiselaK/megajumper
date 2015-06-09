package com.missionbit.megajumper;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MegaJumper extends ApplicationAdapter {
    public static SpriteBatch batch;
    public static int width;
    public static int height;
    public int score;
    public static OrthographicCamera camera;


    private Platform[] platforms;

    @Override
    public void create () {
        batch = new SpriteBatch();
        width = Gdx.graphics.getWidth();
        height = Gdx.graphics.getHeight();
        camera = new OrthographicCamera(width,height);
        platforms = new Platform[4];

        for (int i = 0; i < 4; i++) {
            platforms[i] = new Platform();
            platforms[i].create();
        }

        player.create();
        font.create();
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
        font.resetGame();
        camera.position.set(width/2,height/2,0);
        platforms[0].resetGame(300, 0);
        platforms[1].resetGame(0, 400);
        platforms[2].resetGame(300, 750);
        platforms[3].resetGame(300, 750);

        score = 0;

    }

    private void updateGame() {
        font.update();
        player.velocityMod(Gdx.input.getAccelerometerX()*-200, 'x');
        if (Gdx.input.justTouched()) {
            player.velocityMod(500, 'y');
            camera.position.y=player.playerPosition.y;
        }

        for (int i = 0; i < 4; i++) {
            if (player.playerBounds.overlaps(platforms[i].platformBounds)){
                player.velocityMod(500, 'y');
                camera.position.y=player.playerPosition.y;
            }
        }
        player.update();
        camera.position.y=player.playerPosition.y;
    }

    private void drawGame() {
        font.drawGame();
        batch.begin();
        camera.update();
        batch.setProjectionMatrix(camera.combined);
        batch.draw(player.playerImage, player.playerPosition.x, player.playerPosition.y);
        for (int i = 0; i < 3; i++) {
            batch.draw(platforms[i].platformImage, platforms[i].platformBounds.x, platforms[i].platformBounds.y);
        }

        batch.end();
    }
}
