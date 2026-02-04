package Services;

import Model.Player;
import Model.Role;
import Model.Team;

import java.util.ArrayList;

public class TeamServices {

    public void createPlayers(Team team, String playerName, Role role, String teamName) {
        Player player = new Player(playerName, role, teamName);
        team.getPlayers().add(player);
    }

    public void displayPlayers(Team team) {
        System.out.println("Team Name: " + team.getTeamName());
        ArrayList<Player> players = team.getPlayers();
        for (Player player : players) {
            System.out.println(player.getPlayerName() + " " + player.getRole());
        }
        System.out.println("----------");
    }

    public Player getPlayerByName(Team team, String playerName) {
        for (Player player : team.getPlayers()) {
            if (player.getPlayerName().equals(playerName)) {
                return player;
            }
        }
        return null;
    }

    public void recordGamePlayed(Team teamA, Team teamB) {
        teamA.setNoOfGamesPlayed(teamA.getNoOfGamesPlayed() + 1);
        teamB.setNoOfGamesPlayed(teamB.getNoOfGamesPlayed() + 1);
    }

    public void recordWin(Team team, int pointDiff) {
        team.setNoOFWins(team.getNoOFWins() + 1);
        team.setPointsDiff(team.getPointsDiff() + pointDiff);
        team.setTotalPoints(team.getTotalPoints() + 2);
    }

    public void recordLoss(Team team, int pointDiff) {
        team.setNoOFLosses(team.getNoOFWins() + 1);
        team.setPointsDiff(team.getPointsDiff() - pointDiff);
    }

    public void recordTie(Team team) {
        team.setTotalPoints(team.getTotalPoints() + 1);
    }
}
