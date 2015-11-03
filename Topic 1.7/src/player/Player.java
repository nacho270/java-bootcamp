package player;

import java.util.Timer;

import javax.swing.JLabel;

public class Player {

	//TODO FIX play stop pause buttons
	
	Thread music;
	Clock clock;
	Timer timer;
	JLabel label;
	
	public Player(JLabel label){
		this.label=label;
		timer = new Timer();
		timer.schedule(new Clock(label),0, 1000);
		music=new Thread(new Music());
		music.start();
	}
	
	public synchronized void playMusic(){
		music.notify();
		timer.notify();
	}
	public void stopMusic(){
		try {
			timer=new Timer();
			timer.schedule(new Clock(label),0, 1000);
			timer.wait();
			music=new Thread(new Music());
			music.start();
			music.wait();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}
	public synchronized void pauseMusic(){
		try {
			music.wait();
			timer.wait();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}
}
