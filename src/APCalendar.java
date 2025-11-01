public class APCalendar {

    private static boolean isLeapYear(int year){

      boolean divisibleBy4 = year % 4==0;
      if (!divisibleBy4) return false;
        boolean centuryYear = year % 100 == 0;
        if(centuryYear== false) return true;
        boolean quadYear = year % 400==0;
        if (quadYear == true) return true;

        else return false;

    }

    // make new variable count
    // iterate for loop from year 1 to year 2 (call IsLeapYear, if true then count++)
    public static int numberOfLeapYears (int year1, int year2){
        int count=0;
        for(int i=year1; i<=year2;i++){
            if (isLeapYear(i)==true) count++;

        }
        return count;
    }
    /* private static int firstDayOfYear(int year){


    }
    private static int dayOfYear(int month, int day, int year){

    }
    public static int dayOfWeek(int month, int day, int year){

    }*/

    public static void main(String[] args) {


        System.out.println(APCalendar.isLeapYear(2024));
        System.out.println(APCalendar.isLeapYear(2025));
        System.out.println(APCalendar.isLeapYear(1900));
        System.out.println(APCalendar.isLeapYear(1600));
        System.out.println(APCalendar.numberOfLeapYears(2000,2050));
        System.out.println(APCalendar.numberOfLeapYears(1900,2050));


    }
}