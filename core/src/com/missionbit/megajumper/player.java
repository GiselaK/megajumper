package com.missionbit.megajumper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Rectangle;

public class player {
    public static Vector2 playerPosition;
    private static Vector2 playerVelocity;
    public static Rectangle playerBounds;
    public static Texture playerImage;
    private static Vector2 gravity;
    public static void create() {
        playerPosition = new Vector2();
        playerVelocity = new Vector2();
        playerBounds= new Rectangle();
        playerImage = new Texture("missionbit.png");
        gravity = new Vector2();
    }
    public static void resetGame(){
        playerPosition.set(MegaJumper.width/2, 300);
        playerVelocity.set(0, 0);
        playerBounds.set(MegaJumper.width / 2, 0, playerImage.getWidth(), playerImage.getHeight());
        gravity.set(0, -20);
    }
    public static void velocityMod(float value, char direction) {
        if (direction == 'x') {
            playerVelocity.x = value;
        }
        if (direction == 'y') {
            playerVelocity.y = value;
        }
    }
    public static void update() {
        float deltaTime = Gdx.graphics.getDeltaTime();
        player.velocityMod(Gdx.input.getAccelerometerX()*-200, 'x');
        playerVelocity.add(gravity);
        playerBounds.setX(player.playerPosition.x);
        playerBounds.setY(player.playerPosition.y);
        playerPosition.mulAdd(player.playerVelocity, deltaTime);
    }
}
