package services;

import model.Match;
import model.Player;
import model.RaidOutCome;

public interface MatchServices {
    public void addRaid(Match match, RaidOutCome raidOutCome, String raidingTeam, int pointsScored, Player pointScorer);
    public void endMatch(Match match);
    public void calculateResults(Match match);
    public void recordResults(Match match);
    public void generateMatchSummary(Match match);
}
