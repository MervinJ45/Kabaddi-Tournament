
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Tournament {
    
    private ArrayList<Team> teams;
    private ArrayList<Match> matches;

    public Tournament() {
        teams = new ArrayList<>();
        matches = new ArrayList<>();
    }

    public void displayStandings(){
        Collections.sort(teams,new Comparator<Team>(){
            @Override
            public int compare(Team t1, Team t2){
                if(t1.getTotalPoints()!=t2.getTotalPoints()){
                    return t2.getTotalPoints() - t1.getTotalPoints();
                }
                else{
                    return t2.getPointsDiff() - t1.getPointsDiff();
                }
            }
        });
        for(Team team: teams){
            System.out.println(team.getTeamName()+" "+ team.getNoOfGamesPlayed()+" "+ team.getNoOFWins()+" "+team.getTotalPoints()+" "+team.getPointsDiff());
        }
    }

    public void displayStats(){
        Player playerWithMostRaidPoints = teams.get(0).getPlayers().get(0);
        for(Team team: teams){
            for(Player player: team.getPlayers()){
                if(playerWithMostRaidPoints.getRaidPoints() < player.getRaidPoints()){
                    playerWithMostRaidPoints = player;
                }
            }
        }
        System.out.println("Most Raid Points: ");
        System.out.println("Player: "+playerWithMostRaidPoints.getPlayerName());
        System.out.println("Points: "+playerWithMostRaidPoints.getRaidPoints());
        
        Player playerWithMostTacklePoints = teams.get(0).getPlayers().get(0);
        for(Team team: teams){
            for(Player player: team.getPlayers()){
                if(playerWithMostRaidPoints.getTacklePoints() < player.getTacklePoints()){
                    playerWithMostTacklePoints = player;
                }
            }
        }
        System.out.println("Most Tackle Points: ");
        System.out.println("Player: "+playerWithMostTacklePoints.getPlayerName());
        System.out.println("Points: "+playerWithMostTacklePoints.getTacklePoints());
    }

    public Team createTeam(String teamName){
        Team team = new Team(teamName);
        teams.add(team);
        return team;
    }

    public Match createMatch(Team teamA,Team teamB){
        Match match = new Match(matches.size()+1,teamA,teamB);
        matches.add(match);
        return match;
    }

    public void displayTeams(){
        for(Team team: teams){
            System.out.println(team.getTeamName()+" "+ team.getNoOfGamesPlayed()+" "+ team.getNoOFWins()+" "+team.getTotalPoints()+" "+team.getPointsDiff());
        }
    }

    public ArrayList<Match> getMatches(){
        return matches;
    }

    public ArrayList<Team> getTeams(){
        return teams;
    }

}
