package com.missionbit.megajumper;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Platforms {
    private Platform[] objects;
    private int platformCount;
    Platforms(int number) {
        platformCount = number;
        objects = new Platform[platformCount];
        for (int i = 0; i < 10; i++) {
            objects[i] = new Platform(100, i*50, "platform.png");
        }
    }
    public void reset() {
        for (int i = 0; i < platformCount; i++) {
            objects[i].reset(0, 0);
        }
    }
    public boolean checkCollision(Rectangle bounds) {
        return false;
    }
    public void draw(SpriteBatch batch) {
        for (int i = 0; i < platformCount; i++) {
            objects[i].draw(batch);
        }
    }
}

class Platform extends Entity{
    Platform(int x, int y, String imgLocation) {
        super(x, y, imgLocation);
    }
    public void reset(float x, float y) {
        this.position.set(x, y);
    }
    public void draw(SpriteBatch batch) {
        batch.draw(img, position.x, position.y);
    }
}
