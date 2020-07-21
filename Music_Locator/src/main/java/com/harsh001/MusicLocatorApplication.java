package com.harsh001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.harsh001.businesslayer.Music;
import com.harsh001.businesslayer.MusicDetailsExtractor;
import com.harsh001.businesslayer.MusicRecognizer;

@SpringBootApplication

public class MusicLocatorApplication {
	private static MusicRecognizer musicRecognizer;
	private static Music music;
	private static MusicDetailsExtractor mde;

	public static MusicDetailsExtractor getMde() {
		return mde;
	}

	public static void setMde(MusicDetailsExtractor mde) {
		MusicLocatorApplication.mde = mde;
	}

	public static Music getMusic() {
		return music;
	}

	public static void setMusic(Music music) {
		MusicLocatorApplication.music = music;
	}

	public static MusicRecognizer getMusicRecognizer() {
		return musicRecognizer;
	}

	public static void setMusicRecognizer(MusicRecognizer musicRecognizer) {
		MusicLocatorApplication.musicRecognizer = musicRecognizer;
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext con = SpringApplication.run(MusicLocatorApplication.class, args);
		setMusicRecognizer(con.getBean(MusicRecognizer.class));
		setMusic(con.getBean(Music.class));
		setMde(con.getBean(MusicDetailsExtractor.class));
	}

}
