

enum RaidOutCome{
    successfull,
    unsuccessfull,
    emptyRaid
}

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

    public void executeRaid(){
        if(raidOutCome == RaidOutCome.successfull){
            pointScorer.increaseRaidPoint(pointsScored);
        }
        else if(raidOutCome == RaidOutCome.unsuccessfull){
            pointScorer.increaseTacklePoint(pointsScored);
        }
    }

    //get
    
    public int getRaidId(){
        return this.raidId;
    }
    
    public RaidOutCome getRaidOutCome(){
        return this.raidOutCome;
    }

    public String getRaidingTeam(){
        return this.raidingTeam;
    }

    public int getPointsScored(){
        return this.pointsScored;
    }
    
    public Player getPointScorer(){
        return this.pointScorer;
    }

}
