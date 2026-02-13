package study.dateandtimeapi;

import java.time.LocalDate;
import java.time.LocalTime;

public class DateTimeAPI {
    public static void main(String[] args) {
        //returns only the current date of the system(no time zone) doesn't provide time
        //no need of new keyword because new object is returned eventually
        LocalDate date = LocalDate.now();
        System.out.println(date);
        //returns the current system time
        LocalTime time = LocalTime.now();
        System.out.println(time);
    }
}
