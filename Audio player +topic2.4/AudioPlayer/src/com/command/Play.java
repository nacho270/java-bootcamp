package com.command;
import com.Domain.MusicPlayer;
import com.Domain.Song;


public class Play implements Command {

	private MusicPlayer musicPlayer;
	
	public Play(MusicPlayer musicPlayer){
		this.musicPlayer = musicPlayer;
	}
	public void execute(Song song) {
		this.musicPlayer.play(song);
	}

	
}
