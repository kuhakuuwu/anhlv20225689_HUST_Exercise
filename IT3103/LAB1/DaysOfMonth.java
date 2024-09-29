import java.util.Scanner;

public class DaysOfMonth {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String monthInput;                
        int year = -1;
        int month = -1;
        
        while(true) {
            System.out.println("Please enter a month (Format: January/Jan./Jan/1):");
            monthInput = input.nextLine().trim();
            
            month = getMonthNumber(monthInput);
            try { 
                if (month == -1) {
                    System.out.println("Invalid month! Please try again!");
                    continue;                
                }            
            
                System.out.println("Please enter a year (E.g: 1999, 2001,...):");
                year = Integer.parseInt(input.nextLine().trim());
                if (year < 0) {
                    System.out.println("Invalid year! Please input a non-negative year!");
                    continue;                
                }

                break;                
            } catch (NumberFormatException e) {
                System.out.println("Invalid year format! Please try again!");
            }
        }
        
        int days = getDaysOfMonth(year, month);
        System.out.println("Number of days in this month: " + days);
        input.close();        
    }

    public static int getMonthNumber(String month) {
        month = month.toLowerCase();
        switch (month) {
            case "january": case "jan.": case "jan": case "1":
                return 1;
            case "february": case "feb.": case "feb": case "2":
                return 2;
            case "march": case "mar.": case "mar": case "3":
                return 3;
            case "april": case "apr.": case "apr": case "4":
                return 4;
            case "may": case "may.": case "5":
                return 5;
            case "june": case "jun.": case "jun": case "6":
                return 6;
            case "july": case "jul.": case "jul": case "7":
                return 7;
            case "august": case "aug.": case "aug": case "8":
                return 8;
            case "september": case "sept.": case "sep": case "9":
                return 9;
            case "october": case "oct.": case "oct": case "10":
                return 10;
            case "november": case "nov.": case "nov": case "11":
                return 11;
            case "december": case "dec.": case "dec": case "12":
                return 12;
            default:
                return -1;
        }       
    }

    public static int getDaysOfMonth(int year, int month) {
        switch (month) {
            case 1: case 3: case 5: case 7:  case 8: case 10: case 12:
                return  31;
    
            case 4: case 6: case 9: case 11:
                return 30;

            case 2:
                if(isLeapYear(year)){
                    return 29;
                } else return 28;

            default:
                return -1;
        }
    }

    public static boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) return true;            
            } else return true;        
        }
        return false;    
    }
}