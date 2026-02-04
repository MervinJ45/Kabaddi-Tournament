package Model;

public class Raid {

    private int raidId;
    private RaidOutCome raidOutCome;
    private String raidingTeam;
    private int pointsScored;
    private Player pointScorer;

    public Raid(int raidId, RaidOutCome raidOutCome, String raidingTeam, int pointsScored, Player pointScorer) {
        this.raidId = raidId;
        this.raidOutCome = raidOutCome;
        this.raidingTeam = raidingTeam;
        this.pointsScored = pointsScored;
        this.pointScorer = pointScorer;
    }

    //getters

    public int getRaidId() {
        return this.raidId;
    }

    public RaidOutCome getRaidOutCome() {
        return this.raidOutCome;
    }

    public String getRaidingTeam() {
        return this.raidingTeam;
    }

    public int getPointsScored() {
        return this.pointsScored;
    }

    public Player getPointScorer() {
        return this.pointScorer;
    }

    //setters

    public void setRaidOutCome(RaidOutCome raidOutCome) {
        this.raidOutCome = raidOutCome;
    }

    public void setRaidingTeam(String raidingTeam) {
        this.raidingTeam = raidingTeam;
    }

    public void setPointsScored(int pointsScored) {
        this.pointsScored = pointsScored;
    }

    public void setPointScorer(Player pointScorer) {
        this.pointScorer = pointScorer;
    }

    public void setRaidId(int raidId) {
        this.raidId = raidId;
    }

}
