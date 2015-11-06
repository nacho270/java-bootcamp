package player;

import player.state.State;
import player.state.StopState;

import java.util.ArrayList;
import java.util.List;

public class Player {
    Track trackInPlaying;
    List<Track> trackList;
    State currentState;
    int index;

    public Player() {
        trackList = new ArrayList<>();
    }

    public Player(List<Track> trackList) {
        this.trackList = trackList;
        index = -1;
        currentState = new StopState(this);
    }

    public void playButtonclicked() {
        currentState.startButton();
    }

    public void stopButtonClicked() {
        currentState.stopButton();
    }

    public void pauseButtonClicked() {
        currentState.pauseButton();
    }

    public List<Track> getTrackList() {
        return trackList;
    }

    public void setTrackList(List<Track> trackList) {
        this.trackList = trackList;
        trackInPlaying = trackList.get(0);
        index = 0;
    }

    public Track getTrackInPlaying() {
        return trackInPlaying;
    }

    public void setTrackInPlaying(Track trackInPlaying) {
        this.trackInPlaying = trackInPlaying;
    }

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public Track setNextTrack() {
        index++;
        if (index >= trackList.size()) {
            trackInPlaying = trackList.get(0);
            index = 0;
        } else {
            trackInPlaying = trackList.get(index);
        }
        return trackInPlaying;
    }
}
