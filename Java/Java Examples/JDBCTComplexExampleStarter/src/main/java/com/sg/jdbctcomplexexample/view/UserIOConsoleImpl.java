package com.sg.jdbctcomplexexample.view;

import java.math.BigDecimal;
import java.util.Scanner;
import org.springframework.stereotype.Component;

/**
 *
 * @author apprentice
 */
@Component
public class UserIOConsoleImpl implements UserIO {

    Scanner scanner = new Scanner(System.in);
    
    @Override
    public void print(String msg) {
        System.out.println(msg);
    }

    @Override
    public double readDouble(String prompt) {
        System.out.println(prompt);
        double returnValue =  scanner.nextDouble();
        scanner.nextLine();
        return returnValue;
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        do {
            System.out.println(prompt);
            double returnValue = scanner.nextDouble();
            scanner.nextLine();
            if(returnValue >= min && returnValue <= max) {
                return returnValue;
            }
        } while(true);
    }

    @Override
    public float readFloat(String prompt) {
        System.out.println(prompt);
        float returnValue =  scanner.nextFloat();
        scanner.nextLine();
        return returnValue;
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        do {
            System.out.println(prompt);
            float returnValue = scanner.nextFloat();
            scanner.nextLine();
            if(returnValue >= min && returnValue <= max) {
                return returnValue;
            }
        } while(true);
    }

    @Override
    public int readInt(String prompt) {
        System.out.println(prompt);
        int returnValue =  scanner.nextInt();
        scanner.nextLine();
        return returnValue;
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        do {
            System.out.println(prompt);
            int returnValue = scanner.nextInt();
            scanner.nextLine();
            if(returnValue >= min && returnValue <= max) {
                return returnValue;
            }
        } while(true);
    }

    @Override
    public long readLong(String prompt) {
        System.out.println(prompt);
        long returnValue =  scanner.nextLong();
        scanner.nextLine();
        return returnValue;
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        do {
            System.out.println(prompt);
            long returnValue = scanner.nextLong();
            scanner.nextLine();
            if(returnValue >= min && returnValue <= max) {
                return returnValue;
            }
        } while(true);
    }

    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }

    @Override
    public BigDecimal readBigDecimal(String prompt) {
        System.out.println(prompt);
        BigDecimal bd = new BigDecimal(scanner.nextLine());
        return bd;
    }
    
}
