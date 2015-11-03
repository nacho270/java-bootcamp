package player;

import java.util.TimerTask;

import javax.swing.JLabel;

//every second run is called it changes the label text increassing 1 second.
public class Clock extends TimerTask {

	MusicPlayer mp;
	int seconds;
	int minutes;
	JLabel label;
	
	public Clock(JLabel label) {
		this.label=label;
		seconds=0;
		minutes=0;
	}

	public void run() {
				seconds++;
				if(seconds>60){
					minutes++;
					seconds=0;
				}
				label.setText(minutes+":"+seconds);
		}
		
}


