package com.Domain;
import java.util.ArrayList;
import java.util.List;

import com.command.Command;


public class Control {

	private Command command;
	private List<Song> songs;
	
 	public Control(){
 		this.songs = new ArrayList<Song>();
 	}

	public List<Song> getSongs() {
		return songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}

	public Command getCommand() {
		return command;
	}

	public void setCommand(Command command) {
		this.command = command;
	}
	public void executeNextSong(int idSong){
		Song song = this.songs.get(idSong);
		this.commandSong(song);
	}
	
 	public void commandSong(Song song){
 		this.command.execute(song);
 	}
 	
 	
}
