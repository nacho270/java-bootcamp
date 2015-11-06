package player.state;

import player.Player;

public class PlayState implements State {
    Player player;

    public PlayState(Player player) {
        this.player = player;
    }


    @Override
    public void startButton() {
        System.out.println("play button clicked, nothing happend");
    }

    @Override
    public void stopButton() {
        System.out.println("stopping");
        player.setCurrentState(new StopState(player));
    }

    @Override
    public void pauseButton() {
        System.out.println("pausing");
        player.setCurrentState(new PauseState(player));
    }
}
