package com.missionbit.megajumper;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.missionbit.megajumper.Entity;

public class Platform extends Entity {
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
