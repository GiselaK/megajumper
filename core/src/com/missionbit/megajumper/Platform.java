package com.missionbit.megajumper;

import com.badlogic.gdx.graphics.Texture;;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Platform {
    public Texture platformImage;
    public Rectangle platformBounds;
    public Vector2 platformPosition;

    public void create() {
        platformImage = new Texture("platform.png");
        platformBounds = new Rectangle();
        platformPosition = new Vector2();
    }
    public void resetGame(int x, int y) {
        platformBounds.set(x, y, platformImage.getWidth(), platformImage.getHeight());
        platformPosition.set(x, y);
    }
}
