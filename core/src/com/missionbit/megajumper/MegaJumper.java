package com.missionbit.megajumper;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.missionbit.megajumper.Platforms;

public class MegaJumper extends ApplicationAdapter {
    public static SpriteBatch batch;
    public static int width;
    public static int height;
    public float score;
    public static OrthographicCamera camera;
    public Platforms platforms;

    private font Font;

    @Override
    public void create () {
        batch = new SpriteBatch();
        width = Gdx.graphics.getWidth();
        height = Gdx.graphics.getHeight();
        camera = new OrthographicCamera(width,height);
        Font = new font();

        platforms = new Platforms(10);

        player.create();
        Font.create();
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
        if(score<player.playerPosition.y){
            score=player.playerPosition.y;
            System.out.print(player.playerPosition.y);
            System.out.print("playerPos^");
            System.out.print(score);
            System.out.print("Score^");
        }
        player.velocityMod(Gdx.input.getAccelerometerX()*-200, 'x');



        if (platforms.checkCollision(camera)) {
            player.velocityMod(750, 'y');
            camera.position.y=player.playerPosition.y;
        }

        player.update();
        camera.position.y=player.playerPosition.y;
    }

    private void drawGame() {
        batch.begin();
        Font.drawGame();
        camera.update();
        batch.setProjectionMatrix(camera.combined);
        batch.draw(player.playerImage, player.playerPosition.x, player.playerPosition.y);
        platforms.draw(batch);
        batch.end();
    }
}
