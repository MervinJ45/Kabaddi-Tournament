
import java.util.ArrayList;

public class Match{

    private int matchId;
    private Team teamA;
    private Team teamB;
    private int teamAPoints;
    private int teamBPoints;
    private ArrayList<Raid> raids;

    public Match(int matchId,Team teamA, Team teamB) {
        this.matchId = matchId;
        this.teamA = teamA;
        this.teamB = teamB;
        this.teamAPoints = 0;
        this.teamBPoints = 0;
        raids = new ArrayList<>();
    }

    public void addRaid(RaidOutCome raidOutCome, String raidingTeam, int pointsScored, Player pointScorer){
        Raid raid = new Raid(raids.size()+1,raidOutCome,raidingTeam,pointsScored,pointScorer);
        raid.executeRaid();
        raids.add(raid);
    }

    public void calculateResults(){
        teamA.setNoOfGamesPlayed();
        teamB.setNoOfGamesPlayed();
        String teamAName = teamA.getTeamName();
        String teamBName = teamB.getTeamName();
        for(Raid raid: raids){
            String raidingTeam = raid.getRaidingTeam();
            if(raid.getRaidOutCome() == RaidOutCome.successfull){
                if(teamAName.equals(raidingTeam)){
                    teamAPoints += raid.getPointsScored();
                }
                else{
                    teamBPoints += raid.getPointsScored();
                }
            }
            else if(raid.getRaidOutCome() == RaidOutCome.unsuccessfull){
                if(teamAName.equals(raidingTeam)){
                    teamBPoints += raid.getPointsScored();
                }
                else{
                    teamAPoints += raid.getPointsScored();
                }
            }
        }
        // System.out.println(teamAName + " " + teamAPoints);
        // System.out.println(teamBName + " " + teamBPoints);
        if(teamAPoints > teamBPoints){
            int pointDiff = teamAPoints - teamBPoints;
            // System.out.println("Winner: " + teamAName);
            teamA.recordWin(pointDiff);
            teamB.recordLoss(pointDiff);
        }
        else if(teamBPoints > teamAPoints){
            int pointDiff = teamBPoints - teamAPoints;
            // System.out.println("Winner: "+ teamBName);
            teamB.recordWin(pointDiff);
            teamA.recordLoss(pointDiff);
        }
        else{
            // System.out.println("Match Tie");
            teamA.recordTie();
            teamB.recordTie();
        }
    }

    //get

    public int getMatchId(){
        return this.matchId;
    }

    public Team getTeamA(){
        return this.teamA;
    }

    public Team getTeamB(){
        return this.teamB;
    }

    public int getTeamAPoints(){
        return this.teamAPoints;
    } 

    public int getTeamBPoints(){
        return this.teamBPoints;
    } 

    //set

    public void setMatchId(int matchId){
        this.matchId = matchId;
    }

    public void setTeamA(Team teamA){
        this.teamA = teamA;
    }

    public void setTeamB(Team teamB){
        this.teamB = teamB;
    }

    public void setTeamAPoints(int teamAPoints){
        this.teamAPoints = teamAPoints;
    }

    public void setTeamBPoints(int teamBPoints){
        this.teamBPoints = teamBPoints;
    }

}