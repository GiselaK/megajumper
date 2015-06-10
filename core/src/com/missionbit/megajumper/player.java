package com.missionbit.megajumper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Rectangle;

public class Player {
    public Vector2 playerPosition;
    public Vector2 playerVelocity;
    public Rectangle playerBounds;
    public Texture playerImage;
    private Vector2 gravity;
    private gameGlobals globals;


    public void create() {
        playerPosition = new Vector2();
        playerVelocity = new Vector2();
        playerBounds= new Rectangle();
        playerImage = new Texture("missionbit.png");
        gravity = new Vector2();
    }

    public void resetGame(){
        playerPosition.set(globals.width/2, 300);
        playerVelocity.set(0, 0);
        playerBounds.set(globals.width / 2, 0, playerImage.getWidth(), playerImage.getHeight());
        gravity.set(0, -20);
    }

    public void velocityMod(float value, char direction) {
        if (direction == 'x') {
            playerVelocity.x = value;
        }
        if (direction == 'y') {
            playerVelocity.y = value;
        }
    }

    public void update() {

        float deltaTime = Gdx.graphics.getDeltaTime();
        playerVelocity.add(gravity);
        playerBounds.setX(playerPosition.x);
        playerBounds.setY(playerPosition.y);
        playerPosition.mulAdd(playerVelocity, deltaTime);

        if (playerPosition.x<-50){
            playerPosition.x=globals.width+50;
        }
        else if (playerPosition.x>globals.width+50){
            playerPosition.x=-50;
        }
    }

}
