package services;

import model.Match;
import model.Team;
import model.Tournament;

import java.util.ArrayList;

public class TournamentServices {

    public Team createTeam(Tournament tournament, String teamName) {
        ArrayList<Team> teams = tournament.getTeams();
        Team team = new Team(teamName);
        teams.add(team);
        return team;
    }

    public Match createMatch(Tournament tournament,Team teamA, Team teamB) {
        ArrayList<Match> matches = tournament.getMatches();
        Match match = new Match(matches.size() + 1, teamA, teamB);
        matches.add(match);
        return match;
    }

    public void displayTeams(Tournament tournament) {
        ArrayList<Team> teams = tournament.getTeams();
        for (Team team : teams) {
            System.out.println(team.getTeamName() + " " + team.getNoOfGamesPlayed() + " " + team.getNoOFWins() + " " + team.getTotalPoints() + " " + team.getPointsDiff());
        }
    }

}
