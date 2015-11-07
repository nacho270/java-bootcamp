package com.command;
import com.Domain.MusicPlayer;
import com.Domain.Song;


public class Stop implements Command {

	private MusicPlayer musicPlayer;
	
	public Stop(MusicPlayer musicPlayer){
		this.musicPlayer = musicPlayer;
	}
	
	public void execute(Song song) {
		this.musicPlayer.stop(song);
	}

}
