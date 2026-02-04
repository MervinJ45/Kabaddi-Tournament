package App;

import Model.*;
import Services.DisplayStatsServices;
import Services.MatchServices;
import Services.TeamServices;
import Services.TournamentServices;

public class Main {
    public static void main(String[] args) {
        TournamentServices pkl = new TournamentServices();
        DisplayStatsServices displayStandingsServices = new DisplayStatsServices();
        MatchServices matchServices = new MatchServices();
        TeamServices teamServices = new TeamServices();

        Team uMumba = pkl.createTeam("U Mumba");
        Team dabangDelhi = pkl.createTeam("Dabang Delhi KC");
        Team teluguTitans = pkl.createTeam("Telugu Titans");
        Team tamilThalaivas = pkl.createTeam("Tamil Thalaivas");

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

        Match match1 = pkl.createMatch(uMumba, dabangDelhi);
        matchServices.addRaid(match1, RaidOutCome.successfull, "U Mumba", 4, teamServices.getPlayerByName(uMumba, "Ajith Chauhan"));
        matchServices.addRaid(match1, RaidOutCome.successfull, "Dabang Delhi KC", 5, teamServices.getPlayerByName(dabangDelhi, "Ashu Malik"));
        matchServices.addRaid(match1, RaidOutCome.successfull, "U Mumba", 1, teamServices.getPlayerByName(uMumba, "Sandeep Kumar"));
        matchServices.addRaid(match1, RaidOutCome.successfull, "Dabang Delhi KC", 2, teamServices.getPlayerByName(dabangDelhi, "Neeraj Narwal"));
        matchServices.addRaid(match1, RaidOutCome.successfull, "U Mumba", 1, teamServices.getPlayerByName(uMumba, "Amir Mohammed Zafardanish"));
        matchServices.addRaid(match1, RaidOutCome.unsuccessfull, "Dabang Delhi KC", 1, teamServices.getPlayerByName(uMumba, "Sunil Kumar"));
        matchServices.endMatch(match1);

        displayStandingsServices.displayStandings(pkl.getTeams());
        displayStandingsServices.displayStats(pkl.getTeams());

    }
}