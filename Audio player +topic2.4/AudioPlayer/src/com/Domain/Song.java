package com.Domain;

public class Song {

	private String name;
	private int seconds;
	
	public Song(String name, int secs){
		this.name=name;
		this.seconds=secs;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSeconds() {
		return seconds;
	}
	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}
	public String toString(){
		return "Song: "+this.name+" "+this.seconds;
	}
	
}
