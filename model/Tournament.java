package model;

import java.util.ArrayList;

public class Tournament {

    private ArrayList<Team> teams;
    private ArrayList<Match> matches;
    private Team winner;
    private Team runner;

    public Tournament(){
        teams = new ArrayList<>();
        matches = new ArrayList<>();
    }

    //getter

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public ArrayList<Match> getMatches() {
        return matches;
    }

    public Team getWinner() {
        return winner;
    }

    public Team getRunner() {
        return runner;
    }

    //setter

    public void setTeams(ArrayList<Team> teams) {
        this.teams = teams;
    }

    public void setMatches(ArrayList<Match> matches) {
        this.matches = matches;
    }

    public void setWinner(Team winner) {
        this.winner = winner;
    }

    public void setRunner(Team runner) {
        this.runner = runner;
    }
}
