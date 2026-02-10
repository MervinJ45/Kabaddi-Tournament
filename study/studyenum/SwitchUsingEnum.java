package study.studyenum;

import java.util.Comparator;

public class SwitchUsingEnum {
    public static void main(String[] args) {
        Enum opt;
        opt = Enum.BOWLER;
        //no break and default needed
        switch (opt) {
            case BATTER -> System.out.println("Batter");
            case BOWLER -> System.out.println("Bowler");
            case ALLROUNDER -> System.out.println("All-Rounder");
        }
        //switch can return values;
        String res = switch (Enum.ALLROUNDER) {
            case BATTER -> "Batter";
            case BOWLER -> "Bowler";
            case ALLROUNDER -> "All-Rounder";
        };
        System.out.println(res);
    }
}
