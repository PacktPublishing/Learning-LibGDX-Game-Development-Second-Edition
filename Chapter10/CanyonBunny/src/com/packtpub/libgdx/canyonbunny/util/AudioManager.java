/*******************************************************************************
 * Copyright 2013 Andreas Oehlke
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/

package com.packtpub.libgdx.canyonbunny.util;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

public class AudioManager {

	public static final AudioManager instance = new AudioManager();

	private Music playingMusic;

	// singleton: prevent instantiation from other classes
	private AudioManager () {
	}

	public void play (Sound sound) {
		play(sound, 1);
	}

	public void play (Sound sound, float volume) {
		play(sound, volume, 1);
	}

	public void play (Sound sound, float volume, float pitch) {
		play(sound, volume, pitch, 0);
	}

	public void play (Sound sound, float volume, float pitch, float pan) {
		if (!GamePreferences.instance.sound) return;
		sound.play(GamePreferences.instance.volSound * volume, pitch, pan);
	}

	public void play (Music music) {
		playingMusic = music;
		if (GamePreferences.instance.music) {
			music.setLooping(true);
			music.setVolume(GamePreferences.instance.volMusic);
			music.play();
		}
	}

	public void stopMusic () {
		if (playingMusic != null) playingMusic.stop();
	}

	public Music getPlayingMusic () {
		return playingMusic;
	}

	public void onSettingsUpdated () {
		if (playingMusic == null) return;
		playingMusic.setVolume(GamePreferences.instance.volMusic);
		if (GamePreferences.instance.music) {
			if (!playingMusic.isPlaying()) playingMusic.play();
		} else {
			playingMusic.pause();
		}
	}

}
