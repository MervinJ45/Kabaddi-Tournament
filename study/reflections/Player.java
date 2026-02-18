package study.reflections;

import study.annotations.*;

public class Player {
    @Name
    private String playerName;
    @Age
    @AgeRange(
            min = 18,
            max = 42
    )
    private int playerAge;

    @DefaultConstructor
    Player(){

    }

    Player(String playerName, int playerAge) {
        this.playerName = playerName;
        this.playerAge = playerAge;
    }

    public String getPlayerName() {
        return playerName;
    }

    @SetNameMethod
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPlayerAge() {
        return playerAge;
    }

    @SetAgeMethod
    public void setPlayerAge(int playerAge) {
        this.playerAge = playerAge;
    }

    public String methodToInvoke() {
        return "Method invoked dynamically using Reflection";
    }

    @RunMe
    public String runMeMethod() {
        return "Method run automatically";
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerName='" + playerName + '\'' +
                ", playerAge=" + playerAge +
                '}';
    }
}
