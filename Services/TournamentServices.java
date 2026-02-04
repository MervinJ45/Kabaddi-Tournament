package Services;

import Model.Match;
import Model.Player;
import Model.Team;

import java.util.ArrayList;

public class TournamentServices {

    private ArrayList<Team> teams;
    private ArrayList<Match> matches;

    public TournamentServices() {
        teams = new ArrayList<>();
        matches = new ArrayList<>();
    }

    public Team createTeam(String teamName) {
        Team team = new Team(teamName);
        teams.add(team);
        return team;
    }

    public Match createMatch(Team teamA, Team teamB) {
        Match match = new Match(matches.size() + 1, teamA, teamB);
        matches.add(match);
        return match;
    }

    public void displayTeams() {
        for (Team team : teams) {
            System.out.println(team.getTeamName() + " " + team.getNoOfGamesPlayed() + " " + team.getNoOFWins() + " " + team.getTotalPoints() + " " + team.getPointsDiff());
        }
    }

    public ArrayList<Match> getMatches() {
        return matches;
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }

}
