package com.command;
import com.Domain.MusicPlayer;
import com.Domain.Song;


public class Pause implements Command {

	private MusicPlayer musicPlayer;
	
	public Pause(MusicPlayer musicPlayer){
		this.musicPlayer = musicPlayer;
	}
	
	public void execute(Song song) {
		musicPlayer.pause(song);
		
	}

}
