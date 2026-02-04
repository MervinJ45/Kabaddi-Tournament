package Services;

import Model.Player;
import Model.Team;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class DisplayStatsServices {

    public void displayStandings(ArrayList<Team> teams) {
        System.out.println("Points Table");
        Collections.sort(teams, new Comparator<Team>() {
            @Override
            public int compare(Team t1, Team t2) {
                if (t1.getTotalPoints() != t2.getTotalPoints()) {
                    return t2.getTotalPoints() - t1.getTotalPoints();
                } else {
                    return t2.getPointsDiff() - t1.getPointsDiff();
                }
            }
        });
        for (Team team : teams) {
            System.out.println(team.getTeamName() + " " + team.getNoOfGamesPlayed() + " " + team.getNoOFWins() + " " + team.getTotalPoints() + " " + team.getPointsDiff());
        }
        System.out.println("---------");
    }


    public void displayStats(ArrayList<Team> teams) {
        System.out.println("Stats");
        Player playerWithMostRaidPoints = teams.get(0).getPlayers().get(0);
        for (Team team : teams) {
            for (Player player : team.getPlayers()) {
                if (playerWithMostRaidPoints.getRaidPoints() < player.getRaidPoints()) {
                    playerWithMostRaidPoints = player;
                }
            }
        }
        System.out.println("Most Raid Points: ");
        System.out.println("Player: " + playerWithMostRaidPoints.getPlayerName());
        System.out.println("Points: " + playerWithMostRaidPoints.getRaidPoints());

        Player playerWithMostTacklePoints = teams.get(0).getPlayers().get(0);
        for (Team team : teams) {
            for (Player player : team.getPlayers()) {
                if (playerWithMostRaidPoints.getTacklePoints() < player.getTacklePoints()) {
                    playerWithMostTacklePoints = player;
                }
            }
        }
        System.out.println("Most Tackle Points: ");
        System.out.println("Player: " + playerWithMostTacklePoints.getPlayerName());
        System.out.println("Points: " + playerWithMostTacklePoints.getTacklePoints());
        System.out.println("---------");
    }


}
