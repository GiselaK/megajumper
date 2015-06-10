package com.missionbit.megajumper;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.missionbit.megajumper.MegaJumper;
import com.missionbit.megajumper.Platform;

public class Platforms {
    private Platform[] objects;
    private int platformCount;
    Platforms(int number) {
        platformCount = number+3;
        objects = new Platform[platformCount];
        int rand = (int)(Math.random()/500);

        int height = 0;
        objects[0] = new Platform(0, 0, "platform.png");
        objects[1] = new Platform(200, 0, "platform.png");
        objects[2] = new Platform(400, 0, "platform.png");
        for (int i = 3; i < platformCount; i++) {
            rand = (int)(Math.random()*MegaJumper.width-200);
            objects[i] = new Platform(rand, height, "platform.png");
            height += 100;
        }
    }
    public void reset() {
        for (int i = 0; i < platformCount; i++) {
            objects[i].reset(0, 0);
        }
    }
    public boolean checkCollision() {
        for (int i = 0; i < platformCount; i++) {
            if (player.playerBounds.overlaps(objects[i].bounds)){
                return true;
            }
        }
        return false;
    }
    public void update() {

    }
    public void draw(SpriteBatch batch) {
        for (int i = 0; i < platformCount; i++) {
            objects[i].draw(batch);
        }
    }
}