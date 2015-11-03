package com.observer;

import com.Domain.Song;


public interface Observer {

	public void play(Song song);
	public void pause(Song song);
	public void stop(Song song);
}
