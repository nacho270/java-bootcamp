package player.state;

import player.Player;

public class PauseState implements State{
    Player player;

    public PauseState(Player player) {
        this.player = player;
    }

    @Override
    public void startButton() {
        System.out.println("starting");
        player.setCurrentState(new PlayState(player));
    }

    @Override
    public void stopButton() {
        System.out.println("stopping");
        player.setCurrentState(new StopState(player));
    }

    @Override
    public void pauseButton() {
        System.out.println("pause button clicked, nothing happend");
    }
}
