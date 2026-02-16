package study.dateandtimeapi;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class DateTimeAPI {
    public static void main(String[] args) {
        //returns only the current date of the system(no time zone) doesn't provide time
        //no need of new keyword because new object is returned eventually
        LocalDate date1 = LocalDate.now();
        //will throw DateTimeException for wrong date value
        //LocalDate date2 = LocalDate.of(2026,2,29);
        LocalDate date2 = LocalDate.of(2026, 2, 28);
        //format yyyy-mm-dd
        LocalDate date3 = LocalDate.parse("2004-04-11");
        System.out.println(date1);
        System.out.println(date2);
        System.out.println(date3);
        //functions to get values from a date
        System.out.println(date2.getYear() + " " + date2.getMonth() + " " + date2.getMonthValue() + " " + date2.getDayOfMonth() + " " + date2.getDayOfWeek());
        //functions to alter a date
        System.out.println(date1.plusDays(1) + " " + date1.minusMonths(2) + " " + date1.withYear(2030) + " " + date1.withDayOfMonth(1));
        //functions to compare two dates
        System.out.println(date1.isBefore(date2));
        System.out.println(date1.isAfter(date2));
        System.out.println(date1.isEqual(date2));

        //returns the current system time
        LocalTime time1 = LocalTime.now();
        //functions to create time
        LocalTime time2 = LocalTime.of(9, 30);
        LocalTime time3 = LocalTime.parse("14:30:10");
        System.out.println(time1);
        System.out.println(time2);
        System.out.println(time3);
        //functions get values from time
        System.out.println(time1.getHour() + " " + time1.getMinute() + " " + time1.getSecond() + " " + time1.getNano());
        //functions to alter time
        System.out.println(time1.plusHours(2) + " " + time1.minusMinutes(10) + " " + time1.withSecond(0));
        //functions to compare time
        System.out.println(time1.isBefore(time2) + " " + time1.isAfter(time2));

        //creating date with time
        LocalDateTime dateTime1 = LocalDateTime.now();
        LocalDateTime dateTime2 = LocalDateTime.of(2026, 2, 16, 9, 30);
        LocalDateTime dateTime3 = LocalDateTime.parse("2026-02-20T10:30:00");
        System.out.println(dateTime1 + " " + dateTime2 + " " + dateTime3);

        //extracting date and time from DateTime
        LocalDate lDate = dateTime1.toLocalDate();
        LocalTime lTime = dateTime1.toLocalTime();
        System.out.println(lDate + " " + lTime);

        //creating date and time for specific time zone
        ZonedDateTime zonedDateTime1 = ZonedDateTime.now();
        //invalid zone id throw ZoneRulesException
        //ZonedDateTime zonedDateTime2 = ZonedDateTime.now(ZoneId.of("Asia/Chennai"));
        ZonedDateTime zonedDateTime2 = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
        System.out.println(zonedDateTime1 + " " + zonedDateTime2);

        LocalDate d1 = LocalDate.of(2004, 11, 4);
        LocalDate d2 = LocalDate.now();

        //calculating period between two dates (date-based)
        Period period = Period.between(d1, d2);
        System.out.println(period.getYears() + " " + period.getMonths() + " " + period.getDays());

        LocalTime t1 = LocalTime.of(21, 30, 10);
        LocalTime t2 = LocalTime.now();

        //calculating period between two times
        Duration duration = Duration.between(t2, t1);
        System.out.println(duration.toHours() + " " + duration.toMinutes() + " " + duration.toSeconds() + " " + duration.toMillis());

        //date formatting
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        String s = dateTime1.format(formatter);
        System.out.println(s);

        LocalDateTime ldt = LocalDateTime.parse("16-02-2026 14:30", formatter);
        System.out.println(ldt);

    }
}
