package services;

import model.*;

public class FinalMatchServices implements MatchServices {

    PlayerServices playerServices = new PlayerServices();
    TeamServices teamServices = new TeamServices();

    public void addRaid(Match match, RaidOutCome raidOutCome, String raidingTeam, int pointsScored, Player pointScorer) {
        Raid raid = new Raid(match.getRaids().size() + 1, raidOutCome, raidingTeam, pointsScored, pointScorer);
        match.getRaids().add(raid);
        if (raidOutCome == RaidOutCome.SUCCESSFULL) {
            playerServices.increaseRaidPoint(pointScorer, pointsScored);
        } else if (raidOutCome == RaidOutCome.UNSUCCESSFULL) {
            playerServices.increaseTacklePoint(pointScorer, pointsScored);
        }
    }

    public void endMatch(Match match) {
        calculateResults(match);
        recordResults(match);
        generateMatchSummary(match);
    }

    public void calculateResults(Match match) {
        Team teamA = match.getTeamA();
        Team teamB = match.getTeamB();
        teamServices.recordGamePlayed(teamA, teamB);
        String teamAName = teamA.getTeamName();
        String teamBName = teamB.getTeamName();
        for (Raid raid : match.getRaids()) {
            String raidingTeam = raid.getRaidingTeam();
            if (raid.getRaidOutCome() == RaidOutCome.SUCCESSFULL) {
                if (teamAName.equals(raidingTeam)) {
                    match.setTeamAPoints(match.getTeamAPoints() + raid.getPointsScored());
                } else {
                    match.setTeamBPoints(match.getTeamBPoints() + raid.getPointsScored());
                }
            } else if (raid.getRaidOutCome() == RaidOutCome.UNSUCCESSFULL) {
                if (teamAName.equals(raidingTeam)) {
                    match.setTeamBPoints(match.getTeamBPoints() + raid.getPointsScored());
                } else {
                    match.setTeamAPoints(match.getTeamAPoints() + raid.getPointsScored());
                }
            }
        }
    }

    public void recordResults(Match match) {
        Team teamA = match.getTeamA();
        Team teamB = match.getTeamB();
        if (match.getTeamAPoints() > match.getTeamBPoints()) {
            int pointDiff = match.getTeamAPoints() - match.getTeamBPoints();
            teamServices.recordWin(teamA, pointDiff);
            teamServices.recordLoss(teamB, pointDiff);
        } else if (match.getTeamBPoints() > match.getTeamAPoints()) {
            int pointDiff = match.getTeamBPoints() - match.getTeamAPoints();
            teamServices.recordWin(teamA, pointDiff);
            teamServices.recordLoss(teamB, pointDiff);
        } else {
//            teamServices.recordTie(teamA);
//            teamServices.recordTie(teamB);
        }
    }

    public void generateMatchSummary(Match match) {
        System.out.println("Match Summary");
        Team teamA = match.getTeamA();
        Team teamB = match.getTeamB();
        System.out.println(teamA.getTeamName() + "   VS   " + teamB.getTeamName());
        System.out.println(teamA.getTeamName() + ":" + match.getTeamAPoints() + "      " + teamB.getTeamName() + ":" + match.getTeamBPoints());
        if (match.getTeamAPoints() == match.getTeamBPoints()) {
            System.out.println("Match Tied");
            System.out.println("----------");
            return;
        }
        String winner = (match.getTeamAPoints() > match.getTeamBPoints()) ? teamA.getTeamName() : teamB.getTeamName();
        System.out.println("Winner : " + winner);
        System.out.println("----------");
    }

//    public void addGoldenRaid(Match match, RaidOutCome raidOutCome, String raidingTeam, int pointsScored, Player pointScorer){
//        Raid goldenRaid = new Raid(0, raidOutCome, raidingTeam, pointsScored, pointScorer);
//        calculateGoldenRaidResults(match, goldenRaid);
//    }

//    public void calculateGoldenRaidResults(Raid goldenRaid){
//        if(goldenRaid.getRaidOutCome() == RaidOutCome.SUCCESSFULL){
//
//        }
//    }

}
