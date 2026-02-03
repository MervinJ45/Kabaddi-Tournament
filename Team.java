
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
        this.noOfWins = 0;
        this.noOfLosses = 0;
        this.noOfGamesPlayed = 0;
        this.totalPoints = 0;
        this.pointDiff = 0;
        players = new ArrayList<>();
    }
    
    public void createPlayers(String playerName, Role role, String teamName){
        Player player = new Player(playerName, role, teamName);
        players.add(player);
    }
    
    public void displayPlayers(){
        System.out.println(this.teamName + ": ");
        for(Player player: players){
            System.out.println(player.getPlayerName());
        }
    }

    public void recordWin(int pointDiff){
        noOfWins += 1;
        totalPoints += 2;
        this.pointDiff += pointDiff;
    }
    
    public void recordLoss(int pointDiff){
        noOfLosses += 1;
        this.pointDiff -= pointDiff;
    }
    
    public void recordTie(){
        totalPoints += 1;
    }

    public void setNoOfGamesPlayed(){
        this.noOfGamesPlayed += 1;
    } 

    //get

    public Player getPlayer(String Name){
        for(Player player: players){
            if(player.getPlayerName().equals(Name)){
                return player;
            }
        }
        return null;
    }

    public String getTeamName(){
        return this.teamName;
    }

    public int getNoOFWins(){
        return this.noOfWins;
    }

    public int getNoOFLosses(){
        return this.noOfLosses;
    }

    public int getNoOfGamesPlayed(){
        return this.noOfGamesPlayed;
    } 

    public int getTotalPoints(){
        return this.totalPoints;
    } 

    public int getPointsDiff(){
        return this.pointDiff;
    } 

    public ArrayList<Player> getPlayers(){
        return this.players;
    }

    public void setTeamName(String teamName){
        this.teamName = teamName;
    }

    public void setNoOFWins(int noOfWins){
        this.noOfWins = noOfWins;
    }

    public void setNoOFLosses(int noOfLosses){
        this.noOfLosses = noOfLosses;
    }


    public void setTotalPoints(int totalPoints){
        this.totalPoints = totalPoints;
    } 

    public void getPointsDiff(int pointDiff){
        this.pointDiff = pointDiff;
    }


}
