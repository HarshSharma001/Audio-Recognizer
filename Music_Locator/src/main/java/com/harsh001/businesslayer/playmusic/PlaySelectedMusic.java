package com.harsh001.businesslayer.playmusic;

import java.io.File;
import jaco.mp3.player.MP3Player;

public class PlaySelectedMusic 
{
	private MP3Player mp3;
	private String filepath=null;
	private static Boolean status = false;
	
	
	public static Boolean getStatus() {
		return status;
	}

	public static void setStatus(Boolean status) {
		PlaySelectedMusic.status = status;
	}

	public PlaySelectedMusic(String filepath)
	{
		this.filepath = filepath;
		mp3 = new MP3Player(new File(filepath));	
	}
	
	public void playSelectedMusic()
	{
		try 
		{
			mp3.play();
			status=true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	public void stopSelectedMusic()
	{
		try 
		{
			mp3.stop();
			status=false;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
