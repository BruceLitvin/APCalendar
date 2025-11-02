public class APCalendar {

    private static boolean isLeapYear(int year) {

        boolean divisibleBy4 = ((year % 4) == 0); // leap year algorithm
        if (!divisibleBy4) return false;    // algorithm is if year divisible by four it is a leap year

        boolean centuryYear = ((year % 100) == 0); // an exception would be if it is divisible by 100 such as 1900
        if (!centuryYear) return true;

        boolean quadYear = ((year % 400) == 0); // if divisible by 400 then it is a leap year
        if (quadYear) return true;

        else return false;     // otherwise return false if the input doesn't follow algorithm above

    }

    public static int numberOfLeapYears(int year1, int year2) { // counts # of leap years between 2 years
        int count = 0; //set count to zero
        for (int i = year1; i <= year2; i++) { //from year1 to year2 count number of leap years
            if (isLeapYear(i)) count++; //if it is a leap year count goes up by 1

        }
        return count; //return the final number
    }


    private static int firstDayOfYear(int year) {
        if(year < 1900) return 0; //unsupported

        int day = 0; // January 1, 1899 was a sunday

        for (int i = 1900; i <= year; i++) { // before 1900 calendar was messy and inconsistent with the general leap year algorithm
            if (isLeapYear(i - 1)) {   // if previous year was a leap year
                day = day + 2; // add 2 for leap year
            } else day++; //otherwise add 1
        }
        return day % 7; //mod 7 to count for 7 days of the week
    }
    /* private static int dayOfYear(int month, int day, int year){

    }
    public static int dayOfWeek(int month, int day, int year){

    }*/

    public static void main(String[] args) {

// many test cases
        System.out.println(APCalendar.isLeapYear(1900));
        System.out.println(APCalendar.isLeapYear(2000));
        System.out.println("----------");
        System.out.println(APCalendar.isLeapYear(2025));
        System.out.println(APCalendar.isLeapYear(1900));
        System.out.println(APCalendar.isLeapYear(2000));


        System.out.println(APCalendar.numberOfLeapYears(2000, 2050));
        System.out.println(APCalendar.numberOfLeapYears(1900, 2050));

        System.out.println("--1900 1950 2000----");
        System.out.println(APCalendar.firstDayOfYear(1900));
        System.out.println(APCalendar.firstDayOfYear(1950));
        System.out.println(APCalendar.firstDayOfYear(2000));

        System.out.println("--2020-2026----");
        System.out.println(APCalendar.firstDayOfYear(2020));
        System.out.println(APCalendar.firstDayOfYear(2021));
        System.out.println(APCalendar.firstDayOfYear(2022));
        System.out.println(APCalendar.firstDayOfYear(2023));
        System.out.println(APCalendar.firstDayOfYear(2024));
        System.out.println(APCalendar.firstDayOfYear(2025));
        System.out.println(APCalendar.firstDayOfYear(2026));


    }
}