package app;

import model.*;
import services.*;

public class Main {
    public static void main(String[] args) {

        Tournament pkl = new Tournament();
        TournamentServices pklServices = new TournamentServices();
        DisplayStatsServices displayStandingsServices = new DisplayStatsServices();
        MatchServices leagueMatchServices = new LeagueMatchServices();
        TeamServices teamServices = new TeamServices();

        Team uMumba = pklServices.createTeam(pkl,"U Mumba");
        Team dabangDelhi = pklServices.createTeam(pkl,"Dabang Delhi KC");
        Team teluguTitans = pklServices.createTeam(pkl,"Telugu Titans");
        Team tamilThalaivas = pklServices.createTeam(pkl,"Tamil Thalaivas");

        pklServices.displayTeams(pkl);

        teamServices.createPlayers(uMumba, "Ajith Chauhan", Role.raider, uMumba.getTeamName());
        teamServices.createPlayers(uMumba, "Sandeep Kumar", Role.raider, uMumba.getTeamName());
        teamServices.createPlayers(uMumba, "Amir Mohammed Zafardanish", Role.raider, uMumba.getTeamName());
        teamServices.createPlayers(uMumba, "Sunil Kumar", Role.defender, uMumba.getTeamName());
        teamServices.createPlayers(uMumba, "Parvesh Bainswal", Role.defender, uMumba.getTeamName());
        teamServices.createPlayers(uMumba, "Lokesh Goswami", Role.defender, uMumba.getTeamName());
        teamServices.createPlayers(uMumba, "Rinku Sharma", Role.defender, uMumba.getTeamName());

        teamServices.createPlayers(dabangDelhi, "Ashu Malik", Role.raider, dabangDelhi.getTeamName());
        teamServices.createPlayers(dabangDelhi, "Neeraj Narwal", Role.raider, dabangDelhi.getTeamName());
        teamServices.createPlayers(dabangDelhi, "Ajinkya Pawar", Role.raider, dabangDelhi.getTeamName());
        teamServices.createPlayers(dabangDelhi, "Mohit Narwal", Role.defender, dabangDelhi.getTeamName());
        teamServices.createPlayers(dabangDelhi, "Surjeet Singh", Role.defender, dabangDelhi.getTeamName());
        teamServices.createPlayers(dabangDelhi, "Sharaub Nandhal", Role.defender, dabangDelhi.getTeamName());
        teamServices.createPlayers(dabangDelhi, "Fazel Atrachali", Role.defender, dabangDelhi.getTeamName());

        teamServices.createPlayers(teluguTitans, "Vijay Malik", Role.raider, teluguTitans.getTeamName());
        teamServices.createPlayers(teluguTitans, "Bharath Hooda", Role.raider, teluguTitans.getTeamName());
        teamServices.createPlayers(teluguTitans, "Chetan Sahu", Role.raider, teluguTitans.getTeamName());
        teamServices.createPlayers(teluguTitans, "Abi Duhan", Role.defender, teluguTitans.getTeamName());
        teamServices.createPlayers(teluguTitans, "Ajith Pawar", Role.defender, teluguTitans.getTeamName());
        teamServices.createPlayers(teluguTitans, "Shubam Shinde", Role.defender, teluguTitans.getTeamName());
        teamServices.createPlayers(teluguTitans, "Ankit Jaglan", Role.defender, teluguTitans.getTeamName());

        teamServices.createPlayers(tamilThalaivas, "Narendhar kandola", Role.raider, tamilThalaivas.getTeamName());
        teamServices.createPlayers(tamilThalaivas, "Arjun Deshwal", Role.raider, tamilThalaivas.getTeamName());
        teamServices.createPlayers(tamilThalaivas, "Pawan Sherawath", Role.raider, tamilThalaivas.getTeamName());
        teamServices.createPlayers(tamilThalaivas, "Ronak", Role.defender, tamilThalaivas.getTeamName());
        teamServices.createPlayers(tamilThalaivas, "Aashik", Role.defender, tamilThalaivas.getTeamName());
        teamServices.createPlayers(tamilThalaivas, "Sagar Rathee", Role.defender, tamilThalaivas.getTeamName());
        teamServices.createPlayers(tamilThalaivas, "Nithesh Kumar", Role.defender, tamilThalaivas.getTeamName());

        teamServices.displayPlayers(uMumba);
        teamServices.displayPlayers(dabangDelhi);
        teamServices.displayPlayers(teluguTitans);
        teamServices.displayPlayers(tamilThalaivas);

        Match match1 = pklServices.createMatch(pkl,uMumba, dabangDelhi);
        leagueMatchServices.addRaid(match1, RaidOutCome.successfull, "U Mumba", 4, teamServices.getPlayerByName(uMumba, "Ajith Chauhan"));
        leagueMatchServices.addRaid(match1, RaidOutCome.successfull, "Dabang Delhi KC", 5, teamServices.getPlayerByName(dabangDelhi, "Ashu Malik"));
        leagueMatchServices.addRaid(match1, RaidOutCome.successfull, "U Mumba", 2, teamServices.getPlayerByName(uMumba, "Sandeep Kumar"));
        leagueMatchServices.addRaid(match1, RaidOutCome.successfull, "Dabang Delhi KC", 2, teamServices.getPlayerByName(dabangDelhi, "Neeraj Narwal"));
        leagueMatchServices.addRaid(match1, RaidOutCome.successfull, "U Mumba", 1, teamServices.getPlayerByName(uMumba, "Amir Mohammed Zafardanish"));
        leagueMatchServices.addRaid(match1, RaidOutCome.unsuccessfull, "Dabang Delhi KC", 1, teamServices.getPlayerByName(uMumba, "Sunil Kumar"));
        leagueMatchServices.endMatch(match1);

        displayStandingsServices.displayStandings(pkl.getTeams());
        displayStandingsServices.displayStats(pkl.getTeams());

    }
}