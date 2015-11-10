package com.main;

import com.Domain.Control;
import com.Domain.MusicPlayer;
import com.Domain.Song;
import com.command.Command;
import com.command.Pause;
import com.command.Play;
import com.command.Stop;

public class Main {


	public static void main(String[] args) {
		
		MusicPlayer musicPlayer = new MusicPlayer();
		Command play = new Play(musicPlayer);
		Command pause = new Pause(musicPlayer);
		Command stop = new Stop(musicPlayer);
		
		Song song = new Song("song1", 20);
		Control control = new Control();
		control.getSongs().add(song);
		
		control.setCommand(play);
		control.executeNextSong(0);
		
		control.setCommand(pause);
		control.executeNextSong(0);
		
		control.setCommand(stop);
		control.executeNextSong(0);
	}

}
