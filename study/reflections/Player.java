package study.reflections;

import study.annotations.AgeRange;
import study.annotations.RunMe;

public class Player {
    private String playerName;
    @AgeRange(
            min = 18,
            max = 42
    )
    private int playerAge;

    Player(String playerName, int playerAge) {
        this.playerName = playerName;
        this.playerAge = playerAge;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPlayerAge() {
        return playerAge;
    }

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
