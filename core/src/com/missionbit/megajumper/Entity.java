package com.missionbit.megajumper;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Entity {
    public Texture img;
    public Rectangle bounds;
    public Vector2 position;

    Entity(float x, float y, String imgLocation) {
        this.img = new Texture(imgLocation);
        this.bounds = new Rectangle(x, y, img.getWidth(), img.getHeight());
        this.position = new Vector2(x, y);
    }
    public void reset(int x, int y) {

    }
}
