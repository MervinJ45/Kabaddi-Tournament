enum Role{
    raider,
    allRounder,
    defender
}

public class Player {
    
    private String playerName;
    private String teamName;
    private final Role role;
    private int totalPoints;
    private int raidPoints;
    private int tacklePoints;

    public Player(String playerName, Role role, String teamName) {
        this.playerName= playerName;
        this.role = role;
        this.teamName = teamName;
        this.totalPoints = 0;
        this.raidPoints = 0;
        this.tacklePoints = 0;
    }

    public void increaseRaidPoint(int points){
        raidPoints += points;
    }

    public void increaseTacklePoint(int points){
        tacklePoints += points;
    }

    //get

    public String getPlayerName(){
        return this.playerName;
    }

    public String getTeamName(){
        return this.teamName;
    }
    
    public int getTotalPoints(){
        return this.totalPoints;
    }
    
    public int getRaidPoints(){
        return this.raidPoints;
    } 

    public int getTacklePoints(){
        return this.tacklePoints;
    } 
    
    public Role getRole(){
        return this.role;
    }


    //set

    public void setPlayerName(String playerName){
        this.playerName = playerName;
    }

    public void setTeam(String teamName){
        this.teamName = teamName;
    }

    public void setTotalPoints(int totalPoints){
        this.totalPoints = totalPoints;
    }

    public void setRaidPoints(int raidPoints){
        this.raidPoints = raidPoints;
    } 

    public void setTacklePoints(int tacklePoints){
        this.tacklePoints = tacklePoints;
    } 

}
