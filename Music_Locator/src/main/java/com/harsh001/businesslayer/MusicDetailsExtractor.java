package com.harsh001.businesslayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MusicDetailsExtractor {
	private static String artist, title, album, release_date, label, result = null;
	
	@Autowired
	private Music musicTrack;

	public void extractMusicDetails(String result) {
		MusicDetailsExtractor.result = result;
		extractArtist();
		extractTitle();
		extractAlbum();
		extractReleaseDate();
		extractLabel();
	}

	public void extractArtist() {
		artist = result.substring(40, result.indexOf("title") - 3);
		//System.out.println(artist);
	}

	public void extractTitle() {
		title = result.substring(result.indexOf("title") + 8, result.indexOf("album") - 3);
		//System.out.println(title);
	}

	public void extractAlbum() {
		album = result.substring(result.indexOf("album") + 8, result.indexOf("release_date") - 3);
		//System.out.println(album);
	}

	public void extractReleaseDate() {
		release_date = result.substring(result.indexOf("release_date") + 15, result.indexOf("label") - 3);
		//System.out.println(release_date);
	}

	public void extractLabel() {
		label = result.substring(result.indexOf("label") + 8, result.indexOf("timecode") - 3);
		//System.out.println(label);
	}
	
	public Music getMusicInstance()
	{
		musicTrack.setArtist(artist);
		musicTrack.setTitle(title);
		musicTrack.setAlbum(album);
		musicTrack.setRelease_date(release_date);
		musicTrack.setLabel(label);
		return musicTrack;
	}
}
