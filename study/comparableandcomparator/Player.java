package study.comparableandcomparator;

import java.util.ArrayList;
import java.util.Collections;

public class Player implements Comparable<Player> {
    private String name;
    private int runs;
    private int age;

    public String getName() {
        return name;
    }

    public int getRuns() {
        return runs;
    }

    public int getAge() {
        return age;
    }

    Player(String name, int runs, int age){
        this.name = name;
        this.runs = runs;
        this.age = age;
    }
    //in comparable the sorting logic is defined inside the class itself (override the compareTo())
    @Override
    public int compareTo(Player p){
        //descending order
        return p.runs - this.runs;
    }
    public static void main(String[] args){
        ArrayList<Player> players = new ArrayList<>();
        Player player1 = new Player("Rohit",450,38);
        Player player2 = new Player("Virat",430,37);
        Player player3 = new Player("Dhoni",133,44);
        players.add(player1);
        players.add(player2);
        players.add(player3);
        Collections.sort(players);
        for(Player player: players){
            System.out.println(player.getName()+" "+player.getRuns());
        }
        //comparator is defined externally with custom sorting logic outside the class
        //comparator is a functional interface so lambda expression can be used
        players.sort((Player p1, Player p2)-> p2.age - p1.age);
        for(Player player: players){
            System.out.println(player.getName()+" "+player.getAge());
        }
    }
}
