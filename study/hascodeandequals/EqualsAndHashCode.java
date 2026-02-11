package study.hascodeandequals;

public class EqualsAndHashCode {
    public static void main(String[] args) {
        Player player1 = new Player(1, "Rohit Sharma");
        Player player2 = new Player(1, "Rohit Sharma");
        System.out.println(player1.equals(player2));
    }
}
