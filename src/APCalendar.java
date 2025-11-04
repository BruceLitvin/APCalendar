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
     private static int dayOfYear(int month, int day, int year){
        int counter=0;
        int[] months= new int[12];
         months[0]=31;//jan
         months[1]=28;//feb
         months[2]=31;//mar
         months[3]=30;//apr
         months[4]=31;//may
         months[5]=30;//jun
         months[6]=31;//jul
         months[7]=31;//aug
         months[8]=30;//sept
         months[9]=31;//oct
         months[10]=30;//nov
         months[11]=31;//dec
         for(int i=1; i<=month-1 ;i++) {
                counter=counter+months[i-1];
         }
         counter+=day;
         if ((isLeapYear(year)) & month>2 )// if it is after 2 and is a leap year add 1
            counter++;

         return counter;
    }

    public static int dayOfWeek(int month, int day, int year){ //determine day of the week
        //use mod 7 do find what day of the week it is
        // find what th first day of year and then what day it is of that year. Take mod 7 and return that value. Since it isn't constant it would be +! every year and +2 if it is a leap year.
       int first=0;
       int next =0;
       first=firstDayOfYear(year);
       next =dayOfYear(month,day,year);
       return (first+(next -1))%7; // -1 will prevent double counting for something like 1,1,2025

    }

    public static void main(String[] args) {
// test cases
        System.out.println(APCalendar.isLeapYear(1900));
        System.out.println(APCalendar.numberOfLeapYears(2000, 2050));
        System.out.println(APCalendar.numberOfLeapYears(1900, 2050));
        System.out.println(APCalendar.firstDayOfYear(2016));
        System.out.println(APCalendar.firstDayOfYear(2019));
        System.out.println(APCalendar.firstDayOfYear(2026));
        System.out.println(dayOfYear(3,1,2017));
        System.out.println(dayOfYear(3,1,2016));
        System.out.println(dayOfWeek(1,10,2019));
        System.out.println(dayOfWeek(1,5,2019));



    }
}