/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package birthdaycalculator;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author nacer
 */
public class BirthdayCalculator {

    /**
     * @param args the command line arguments
     */
    
        /**
     * 
     *  BIRTHDAY FUNCTIONS
     *   
     */
    
    public static String day(int d){
        switch(d){
            case 0 -> {
                return "Sunday";
             }
                
            case 1 -> {
                return "Monday";
             }
                                
            case 2 -> {
                return "Tuesday";
             }
                                
            case 3 -> {
                return "Wednesday";
             }
                                
            case 4 -> {
                return "Thursday";
             }
                                
            case 5 -> {
                return "Friday";
             }
                                
            case 6 -> {
                return "Saturday";
             }
        }
        return "";
    }  
    
    public static void birthday(){
        Date d = new Date();
        System.out.println("What's your birthday?");
        Scanner myScanner = new Scanner(System.in);
        /*
        String input = myScanner.nextLine();
        String[] date = input.split("-");
        */
        int day,month,year;
        Calendar birthday = Calendar.getInstance();
        
        do{
            do{
                System.out.print("Month: ");
                month = myScanner.nextInt();
            }while(month<1 || month>12);
            do{
                System.out.print("Day: ");
                day = myScanner.nextInt();
            }while(day<1 || day>31);
            do{
                System.out.print("Year: ");
                year = myScanner.nextInt();
            }while(year<1);

            birthday.set(Calendar.YEAR, year);
            birthday.set(Calendar.MONTH, month-1);
            birthday.set(Calendar.DAY_OF_MONTH, day);
        }while(d.getTime()<birthday.getTimeInMillis());
        
        //Day of the week user was born
        Date theDate = birthday.getTime();
        System.out.println("You were born on a " + day(theDate.getDay()));
        
        // Day of the week of this year
        
        
        Calendar birthday2 = Calendar.getInstance();
        birthday2.set(Calendar.MONTH, month-1);
        birthday2.set(Calendar.DAY_OF_MONTH, day);
        birthday2.set(Calendar.YEAR, d.getYear()+1900);
        theDate = birthday2.getTime();
        System.out.println("This year your birthday will be a " + day(theDate.getDay()));
        
        // How many days before user turn age + 1
        Calendar next_birthday = Calendar.getInstance();
        if (d.getMonth()< month-1 || (d.getMonth()== month-1 && d.getDate() <=  day) )  {
            next_birthday = birthday2;
        } else {
            next_birthday.set(Calendar.MONTH, month-1);
            next_birthday.set(Calendar.DAY_OF_MONTH, month);
            next_birthday.set(Calendar.YEAR, d.getYear()+1900+1);
        }
        long diff = next_birthday.getTimeInMillis()- d.getTime();
        long daysToBirthday = TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS);
        int age = d.getYear()+1900+1 - year;
        System.out.println("There's "+daysToBirthday+" day left before your "+age+"th birthday");
        
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        birthday();
    }
    
}
