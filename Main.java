public class Main
{
    public static void main(String[] args)
    {
        Tournament pkl = new Tournament();
        Team uMumba = pkl.createTeam("U Mumba");
        Team dabangDelhi = pkl.createTeam("Dabang Delhi KC");
        Team teluguTitans = pkl.createTeam("Telugu Titans");
        Team tamilThalaivas = pkl.createTeam("Tamil Thalaivas");

        uMumba.createPlayers("Ajith Chauhan",Role.raider,uMumba.getTeamName());
        uMumba.createPlayers("Sandeep Kumar",Role.raider,uMumba.getTeamName());
        uMumba.createPlayers("Amir Mohammed Zafardanish",Role.raider,uMumba.getTeamName());
        uMumba.createPlayers("Sunil Kumar",Role.defender,uMumba.getTeamName());
        uMumba.createPlayers("Parvesh Bainswal",Role.defender,uMumba.getTeamName());
        uMumba.createPlayers("Lokesh Goswami",Role.defender,uMumba.getTeamName());
        uMumba.createPlayers("Rinku Sharma",Role.defender,uMumba.getTeamName());

        dabangDelhi.createPlayers("Ashu Malik",Role.raider,dabangDelhi.getTeamName());
        dabangDelhi.createPlayers("Neeraj Narwal",Role.raider,dabangDelhi.getTeamName());
        dabangDelhi.createPlayers("Ajinkya Pawar",Role.raider,dabangDelhi.getTeamName());
        dabangDelhi.createPlayers("Mohit Narwal",Role.defender,dabangDelhi.getTeamName());
        dabangDelhi.createPlayers("Surjeet Singh",Role.defender,dabangDelhi.getTeamName());
        dabangDelhi.createPlayers("Sharaub Nandhal",Role.defender,dabangDelhi.getTeamName());
        dabangDelhi.createPlayers("Fazel Atrachali",Role.defender,dabangDelhi.getTeamName());

        teluguTitans.createPlayers("Vijay Malik",Role.raider,teluguTitans.getTeamName());
        teluguTitans.createPlayers("Bharath Hooda",Role.raider,teluguTitans.getTeamName());
        teluguTitans.createPlayers("Chetan Sahu",Role.raider,teluguTitans.getTeamName());
        teluguTitans.createPlayers("Abi Duhan",Role.defender,teluguTitans.getTeamName());
        teluguTitans.createPlayers("Ajith Pawar",Role.defender,teluguTitans.getTeamName());
        teluguTitans.createPlayers("Shubam Shinde",Role.defender,teluguTitans.getTeamName());
        teluguTitans.createPlayers("Ankit Jaglan",Role.defender,teluguTitans.getTeamName());

        tamilThalaivas.createPlayers("Narendhar kandola",Role.raider,tamilThalaivas.getTeamName());
        tamilThalaivas.createPlayers("Arjun Deshwal",Role.raider,tamilThalaivas.getTeamName());
        tamilThalaivas.createPlayers("Pawan Sherawath",Role.raider,tamilThalaivas.getTeamName());
        tamilThalaivas.createPlayers("Ronak",Role.defender,tamilThalaivas.getTeamName());
        tamilThalaivas.createPlayers("Aashik",Role.defender,tamilThalaivas.getTeamName());
        tamilThalaivas.createPlayers("Sagar Rathee",Role.defender,tamilThalaivas.getTeamName());
        tamilThalaivas.createPlayers("Nithesh Kumar",Role.defender,tamilThalaivas.getTeamName());
        
        Match match1 = pkl.createMatch(uMumba,dabangDelhi);
        match1.addRaid(RaidOutCome.successfull,"U Mumba", 4,uMumba.getPlayer("Ajith Chauhan"));
        match1.addRaid(RaidOutCome.successfull,"Dabang Delhi KC", 5,dabangDelhi.getPlayer("Ashu Malik"));
        match1.addRaid(RaidOutCome.successfull,"U Mumba", 1,uMumba.getPlayer("Sandeep Kumar"));
        match1.addRaid(RaidOutCome.successfull,"Dabang Delhi KC", 1,dabangDelhi.getPlayer("Neeraj Narwal"));
        match1.addRaid(RaidOutCome.successfull,"U Mumba", 1,uMumba.getPlayer("Amir Mohammed Zafardanish"));
        match1.addRaid(RaidOutCome.unsuccessfull,"Dabang Delhi KC", 1,uMumba.getPlayer("Sunil Kumar"));
        match1.calculateResults();

        // Match match2 = pkl.createMatch(teluguTitans,tamilThalaivas);
        // match2.addRaid("Successfull","Telugu Titans", 1,"Vijay Mailk");
        // match2.addRaid("Successfull","Tamil Thalaivas", 1,"Narendhar kandola");
        // match2.addRaid("Successfull","Telugu Titans", 3,"Ajith Pawar");
        // match2.addRaid("Successfull","Tamil Thalaivas", 1,"Arjun Deshwal");
        // match2.addRaid("Successfull","Telugu Titans", 1,"Barath Hoods");
        // match2.addRaid("Successfull","Tamil Thalaivas", 1,"Pawan Sherawath  ");
        // match2.calculateResults();

        pkl.displayStandings();
        pkl.displayStats();
        
    }
}