package View;

import com.Domain.ControlPlayer;
import com.Domain.MusicPlayer;
import com.Domain.Song;



public class TestAudioPlayer {

	public static void main(String[] args) {

		Song song = new Song("song1",30);
		MusicPlayer player = new MusicPlayer();
		ControlPlayer control = new ControlPlayer(player,song);
		View view = new View(control);
		
		System.out.println("Menu");
		System.out.println("1- play");
		System.out.println("2 - pause ");
		System.out.println("3 - stop ");
		System.out.println("0 - Close Program ");
		
		
		view.start();
		View view2 = new View(control);
		view2.start();
	}
}
