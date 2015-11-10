package com.Domain;


public class MusicPlayer implements Observer{

	private int timePlayed=0;
	private boolean stopOff=true;
	
	public MusicPlayer(){
	}
	
	public void play(Song song) {
		int time = song.getTotalTime();
		this.stopOff=true;
		while (timePlayed != time && this.stopOff){
			timePlayed++;
		try{
			Thread.sleep(1000);
		}catch(Exception ex){
			System.out.println("Errod");
		}
		song.setTotalTime(time);
		System.out.println(timePlayed);
	}
	}

	public void pause(Song song) {
		System.out.println("Pausa");
		this.stopOff = false;
	}

	public void stop(Song song) {
			this.timePlayed=0;
			this.stopOff = false;
			System.out.println("Stop");
	}
}

