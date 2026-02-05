package model;

public class Player {

    private String playerName;
    private String teamName;
    private final Role role;
    private int totalPoints;
    private int raidPoints;
    private int tacklePoints;

    public Player(String playerName, Role role, String teamName) {
        this.playerName = playerName;
        this.role = role;
        this.teamName = teamName;
    }

    //getters

    public String getPlayerName() {
        return this.playerName;
    }

    public String getTeamName() {
        return this.teamName;
    }

    public int getTotalPoints() {
        return this.totalPoints;
    }

    public int getRaidPoints() {
        return this.raidPoints;
    }

    public int getTacklePoints() {
        return this.tacklePoints;
    }

    public Role getRole() {
        return this.role;
    }


    //setters

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setTeam(String teamName) {
        this.teamName = teamName;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public void setRaidPoints(int raidPoints) {
        this.raidPoints = raidPoints;
    }

    public void setTacklePoints(int tacklePoints) {
        this.tacklePoints = tacklePoints;
    }

}
