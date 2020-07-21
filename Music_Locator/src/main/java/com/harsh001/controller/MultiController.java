package com.harsh001.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.harsh001.MusicLocatorApplication;
import com.harsh001.businesslayer.Music;
import com.harsh001.businesslayer.MusicRecognizer;
import com.harsh001.businesslayer.playmusic.PlaySelectedMusic;

@RestController
public class MultiController {
	
	private PlaySelectedMusic controlMusic;
	
	@RequestMapping(path = "/musiclocator")
	public ModelAndView getMusicLocatorHomePage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("MusicLocator");
		return mav;
	}

	@RequestMapping(path = "/getmusicdetails")
	public ModelAndView recognizeMusic(@RequestParam(name = "musicfile") String filepath) {
		Music music;
		controlMusic = new PlaySelectedMusic(filepath);
		controlMusic.playSelectedMusic();
		
		ModelAndView mav = new ModelAndView();
		MusicRecognizer musicRecognizer = MusicLocatorApplication.getMusicRecognizer();
		music = musicRecognizer.getMusicDetails(filepath);

		mav.addObject("Music", music);
		//System.out.println(music);
		mav.setViewName("MusicLocator");
		return mav;
	}
	
	@RequestMapping(path = "/stopmusic")
	public ModelAndView stopMusic()
	{
		controlMusic.stopSelectedMusic();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("MusicLocator");
		return mav;
	}
}
