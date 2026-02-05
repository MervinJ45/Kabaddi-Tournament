package model;

import java.util.ArrayList;

public class Match {

    private int matchId;
    private Team teamA;
    private Team teamB;
    private int teamAPoints;
    private int teamBPoints;
    private ArrayList<Raid> raids;

    public Match(int matchId, Team teamA, Team teamB) {
        this.matchId = matchId;
        this.teamA = teamA;
        this.teamB = teamB;
        raids = new ArrayList<>();
    }

    //getters

    public int getMatchId() {
        return this.matchId;
    }

    public Team getTeamA() {
        return this.teamA;
    }

    public Team getTeamB() {
        return this.teamB;
    }

    public int getTeamAPoints() {
        return this.teamAPoints;
    }

    public int getTeamBPoints() {
        return this.teamBPoints;
    }

    public ArrayList<Raid> getRaids() {
        return raids;
    }

    //setters

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public void setTeamA(Team teamA) {
        this.teamA = teamA;
    }

    public void setTeamB(Team teamB) {
        this.teamB = teamB;
    }

    public void setTeamAPoints(int teamAPoints) {
        this.teamAPoints = teamAPoints;
    }

    public void setTeamBPoints(int teamBPoints) {
        this.teamBPoints = teamBPoints;
    }

}