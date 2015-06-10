package com.missionbit.megajumper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

public class Song {
    private Music music;

    public void create(String songLocation) {
        music = Gdx.audio.newMusic(Gdx.files.internal(songLocation));
        music.play();
    }
}