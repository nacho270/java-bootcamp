import player.Player;
import player.Track;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Track> tracks = new ArrayList<>();
        tracks.add(new Track("Highway to hell",4*60));
        Player player = new Player(tracks);
        player.playButtonclicked();
    }
}
