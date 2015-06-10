package com.missionbit.megajumper;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.missionbit.megajumper.Player;

import com.missionbit.megajumper.gameGlobals;

public class Game extends Screen {
    private Player player;
    private Platforms platforms;
    private OrthographicCamera camera;
    public gameGlobals globals;

    Game(String songLocation, gameGlobals globals) {
        super(songLocation, globals);
        player = new Player();
        platforms = new Platforms(10, globals);
        camera = new OrthographicCamera();
        super.setScore(new Integer(0));
        globals = new gameGlobals();
        globals.addCamera(camera);
        globals.addBatch(batch);
        globals.addPlayer(player);
    }
    public void update() {
        if(getScore()<(int)player.playerPosition.y/50){
           setScore((int)player.playerPosition.y/50);
        }
        if (platforms.checkCollision()) {
            if (player.playerVelocity.y < 0) {
                player.velocityMod(750, 'y');
            }
            camera.position.y=player.playerPosition.y;
        }
        platforms.update();
        player.update();
        camera.position.y=player.playerPosition.y;
        player.velocityMod(Gdx.input.getAccelerometerX()*-200, 'x');
    }
    public void reset() {
        camera.position.set(globals.width / 2, globals.height / 2, 0);
        platforms.reset();
        setScore(0);
    }
    public void draw() {
        startDraw();
        camera.update();
        platforms.draw(getBatch());
        getBatch().setProjectionMatrix(camera.combined);
        getBatch().draw(player.playerImage, player.playerPosition.x, player.playerPosition.y);
        endDraw();
    }

}