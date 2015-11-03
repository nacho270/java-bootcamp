package View;

import java.util.Scanner;
import com.Domain.ControlPlayer;

public class View extends Thread {
	private ControlPlayer controlPlayer;
	private final static String PLAY ="play"; 
	private final static String PAUSE ="pause";
	private final static String STOP ="stop";
	private Scanner input = new Scanner(System.in);
	
	public View(ControlPlayer music){
		super();
		this.controlPlayer = music;
	}
	
	public void userResponse(){
		
		int optionSelected = input.nextInt();
		while(!(optionSelected == 0)){
		this.action(optionSelected);
		optionSelected = input.nextInt();
		}
	}
	@Override
	public void run(){
		this.userResponse();
	}
	
	
	public void action(int value){
		switch (value) {
		case 1:
			this.controlPlayer.changeAction(PLAY);
			break;
		case 2:
			this.controlPlayer.changeAction(PAUSE);
			break;
		case 3:
			this.controlPlayer.changeAction(STOP);
			break;
		default:
			break;
		}
	}

}

