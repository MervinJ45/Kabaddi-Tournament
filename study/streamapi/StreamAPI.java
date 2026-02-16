package study.streamapi;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamAPI {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(1);
        nums.add(1);
        nums.add(4);
        nums.add(4);
        nums.add(6);
        nums.add(7);
        nums.add(8);
        nums.add(9);
        nums.add(10);
        ArrayList<String> players = new ArrayList<>();
        players.add("Rohit Sharma");
        players.add("Quinton De Kock");
        players.add("Tilak Varma");
        players.add("Surya Kumar Yadav");
        players.add("Sherfane Rutherford");
        players.add("Naman Dhir");
        players.add("Hardik Pandya");
        players.add("Mitchel Santner");
        players.add("Trent Boult");
        players.add("Mayank Markande");
        players.add("Jasprit Bumrah");
        players.add("Deepak Chahar");
        //filter values based on the condition and add values to a new list
        nums.stream().filter(i -> i % 2 == 0).toList();
        //.map() will transform all the values in the list
        List<Integer> bl = nums.stream().map(i -> i + 1).filter(i -> i % 2 != 0).toList();
        System.out.println(bl);
        //count all the values in the stream and return result as long
        long sum = bl.stream().count();
        System.out.println(sum);
        //distent() will remove the duplicate elements from the list
        List<Integer> remDup = nums.stream().distinct().toList();
        System.out.println(remDup);
        //sorted will sort the
        List<String> sortedPlayers = players.stream().sorted().toList();
        System.out.println(sortedPlayers);
        //limit specifies the max size and skip specifies no of element to skip from the starting of the list
        List<String> limitSkip = players.stream().limit(5).skip(2).toList();
        System.out.println(limitSkip);

        //collect will convert the collection into another collection
        Set<Integer> set = nums.stream().collect(Collectors.toSet());
        System.out.println(set);

        //list converted to map using stream
        Map<String, Integer> map = players.stream().collect(Collectors.toMap(
                player -> player,
                player -> player.length()
        ));
        System.out.println(map);

        //checks and return boolean
        System.out.println(nums.stream().anyMatch(i -> i == 1));
        System.out.println(nums.stream().allMatch(i -> i == 1));
        System.out.println(nums.stream().noneMatch(i -> i == 1));
    }
}
