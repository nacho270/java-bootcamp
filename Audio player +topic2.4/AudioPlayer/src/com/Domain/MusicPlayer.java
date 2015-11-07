package com.Domain;

public class MusicPlayer {

	public MusicPlayer(){
	}
	
	public void play(Song song){
		System.out.println("play "+song);
	}
	
	public void stop(Song song){
		System.out.println("pause "+song);
	}
	
	public void pause(Song song){
		System.out.println("stop "+song);
	}
	
	
}
