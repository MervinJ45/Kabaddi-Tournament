package study.hascodeandequals;

public class Player {
    private int playerId;
    private String playerName;

    Player(int playerId, String playerName) {
        this.playerId = playerId;
        this.playerName = playerName;
    }

    //overriding hashCode() function from Object class 
    @Override
    public int hashCode() {
        return playerId;
    }

    //Overriding equals() function from object class
    //by default it compares the memory location of two objects
    //overridden so that both the objects playerID is compared
    @Override
    public boolean equals(Object obj) {
        return (this.playerId == ((Player) obj).playerId);
    }
}
