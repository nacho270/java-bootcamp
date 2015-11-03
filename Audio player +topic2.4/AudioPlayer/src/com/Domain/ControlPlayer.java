package com.Domain;

import com.observer.Observer;
import com.observer.ObserverSubject;

public class ControlPlayer implements ObserverSubject {

	private Song song;
	private Observer observer;
	
	public ControlPlayer(Observer observer,Song song){
		this.observer = observer;
		this.song=song;
	}

	public void changeAction(String action){
		doNotify(action);
	}

	public void getActionBy(String action){
		if("play".equals(action)){
			this.observer.play(song);
		}if("pause".equals(action)){
			this.observer.pause(song);
		}if("stop".equals(action)){
			this.observer.stop(song);
		}
	}

	public void doNotify(String action) {
		getActionBy(action);
	}
}
