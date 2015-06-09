package com.missionbit.megajumper;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MegaJumper extends ApplicationAdapter {
    private SpriteBatch batch;
    public static int width;
    public static int height;
    public int score;
    public Platforms platforms;
    @Override
    public void create () {
        batch = new SpriteBatch();
        width = Gdx.graphics.getWidth();
        height = Gdx.graphics.getHeight();
        platforms = new Platforms(10);
        player.create();
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
        platforms.reset();
        score = 0;

    }
    private void updateGame() {
        player.update();
        if (Gdx.input.justTouched()) {
            player.velocityMod(500, 'y');
        }
        if (platforms.checkCollision(player.playerBounds)) {
            player.velocityMod(500, 'y');
        }
    }
    private void drawGame() {
        batch.begin();
        batch.draw(player.playerImage, player.playerPosition.x, player.playerPosition.y);
        platforms.draw(batch);
        batch.end();
    }
}
