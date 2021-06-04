package oop.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class AppTest 
{
    @Test
    public void include_correct_years(){
        App myApp = new App();
        int currAge = 25;
        int retireAge = 65;
        int currYear = 2021;

        int yearsUntilRetire = myApp.calcYearsUntilRetire(currAge, retireAge);
        int yearOfRetire = myApp.calcYearOfRetire(yearsUntilRetire, currYear);

        String expectedMessage = "You have 40 years left until you can retire.\nIt's 2021, so you can retire in 2061.";
        String actualMessage = myApp.generateMessage(yearsUntilRetire, currYear, yearOfRetire);

        assertEquals(expectedMessage, actualMessage);
    }
}
