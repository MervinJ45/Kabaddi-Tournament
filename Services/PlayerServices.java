package Services;

import Model.Player;

public class PlayerServices {
    public void increaseRaidPoint(Player player, int pointsScored) {
        player.setRaidPoints(player.getRaidPoints() + pointsScored);
    }

    public void increaseTacklePoint(Player player, int pointsScored) {
        player.setTacklePoints(player.getTacklePoints() + pointsScored);
    }
}
