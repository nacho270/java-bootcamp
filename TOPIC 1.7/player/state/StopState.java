package player.state;

import player.Player;

public class StopState implements State {
    Player player;

    public StopState(Player player) {
        this.player = player;
    }

    @Override
    public void startButton() {
        System.out.println("starting play");
        System.out.println("next track is "+player.setNextTrack().getName());
        player.setCurrentState(new PlayState(player));
    }

    @Override
    public void stopButton() {
        System.out.println("stop button clicked, nothing happend");
    }

    @Override
    public void pauseButton() {
        System.out.println("pauseng");
        player.setCurrentState(new PauseState(player));
    }
}
