package Model;

import java.util.ArrayList;


public class Team {

    private String teamName;
    private int noOfWins;
    private int noOfLosses;
    private int noOfGamesPlayed;
    private int totalPoints;
    private int pointDiff;
    private ArrayList<Player> players;

    public Team(String teamName) {
        this.teamName = teamName;
        players = new ArrayList<>();
    }

    //getter

    public String getTeamName() {
        return this.teamName;
    }

    public int getNoOFWins() {
        return this.noOfWins;
    }

    public int getNoOFLosses() {
        return this.noOfLosses;
    }

    public int getNoOfGamesPlayed() {
        return this.noOfGamesPlayed;
    }

    public int getTotalPoints() {
        return this.totalPoints;
    }

    public int getPointsDiff() {
        return this.pointDiff;
    }

    public ArrayList<Player> getPlayers() {
        return this.players;
    }

    //setter

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void setNoOFWins(int noOfWins) {
        this.noOfWins = noOfWins;
    }

    public void setNoOFLosses(int noOfLosses) {
        this.noOfLosses = noOfLosses;
    }


    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public void setPointsDiff(int pointDiff) {
        this.pointDiff = pointDiff;
    }

    public void setNoOfGamesPlayed(int noOfGamesPlayed) {
        this.noOfGamesPlayed = noOfGamesPlayed;
    }


}
