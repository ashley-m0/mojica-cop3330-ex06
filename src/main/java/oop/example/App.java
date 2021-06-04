package oop.example;

import java.util.Scanner;
import java.time.LocalDate;

/*
Exercise 6 - Retirement Calculator
Your computer knows what the current year is, which means you can incorporate that into your programs.
You just have to figure out how your programming language can provide you with that information.

Create a program that determines how many years you have left until retirement and the year you can
retire. It should prompt for your current age and the age you want to retire and display the output
as shown in the example that follows.

Example Output:
What is your current age? 25
At what age would you like to retire? 65
You have 40 years left until you can retire.
It's 2015, so you can retire in 2055.

Constraints:
Again, be sure to convert the input to numerical data before doing any math.
Don’t hard-code the current year into your program. Get it from the system time via your programming
language.

Challenge:
Handle situations where the program returns a negative number by stating that the user can already retire.
 */

public class App 
{
    static Scanner input = new Scanner (System.in);
    public static void main( String[] args )
    {
        App myApp = new App();
        LocalDate currentDate = LocalDate.now();

        String currAgeString = myApp.getCurrentAge();
        String retAgeString = myApp.getRetireAge();

        int currAge = myApp.convertStringToInt(currAgeString);
        int retAge = myApp.convertStringToInt(retAgeString);
        int currYear = currentDate.getYear();

        int yearsUntilRetire = myApp.calcYearsUntilRetire(currAge, retAge);
        int yearOfRetire = myApp.calcYearOfRetire(yearsUntilRetire, currYear);

        String output = myApp.generateMessage(yearsUntilRetire, currYear, yearOfRetire);
        System.out.println(output);
    }

    public String getCurrentAge(){
        System.out.print("What is your current age? ");
        String currentAge = input.nextLine();
        return currentAge;
    }

    public String getRetireAge(){
        System.out.print("At what age would you like to retire? ");
        String retireAge = input.nextLine();
        return retireAge;
    }

    public int convertStringToInt(String num){
        int actualNumber = Integer.parseInt(num);
        return actualNumber;
    }

    public int calcYearsUntilRetire(int currentAge, int retireAge){
        return (retireAge - currentAge);
    }

    public int calcYearOfRetire(int yearsToRetire, int currYear){
        return (currYear + yearsToRetire);
    }

    public String generateMessage (int yearsUntilRetire, int currYear, int yearOfRetire){
        String message = String.format("You have %d years left until you can retire.\nIt's %d, so you can retire in %d.", yearsUntilRetire, currYear, yearOfRetire);
        return message;
    }
}
