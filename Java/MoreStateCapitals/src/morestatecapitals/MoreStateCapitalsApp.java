/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package morestatecapitals;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author nacer
 */
public class MoreStateCapitalsApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        Map<String, Capital> capitals = new HashMap<>();
        
        // Data unmarshaling
        Scanner sc = new Scanner(
        new BufferedReader(new FileReader("MoreStateCapitals.txt")));
        
        // go through the file line by line
        String[] chunks;
        Capital capital;
        while (sc.hasNextLine()) {
            String currentLine = sc.nextLine();  
            
            // Split the input
            chunks = currentLine.split("::");
            
            // Create the capital object
            capital = new Capital(chunks[1],Integer.parseInt(chunks[2]),Float.parseFloat(chunks[3]));
            
            // Store it in the map
            capitals.put(chunks[0], capital);
        }
        
        Set<String> keys = capitals.keySet();
        System.out.println(keys.size()+" STATE/CAPITAL PAIRS LOADED."+"\n"+"==============================");
        
        for (String k : keys){
            System.out.println(k 
                    + " - " + capitals.get(k).getName() 
                    + " | Pop: " + capitals.get(k).getPopulation()
                    + " | Area: " + capitals.get(k).getSquareMileage() + " sq mi");
        }
        
        // Lower limit for city population
        System.out.print("\nPlease enter the lower limit for capital city population:");
        Scanner myScanner = new Scanner(System.in);
        int lower_limit = myScanner.nextInt();  
        System.out.println("\nLISTING CAPITALS WITH POPULATIONS GREATER THAN " + lower_limit + ":");
        for (String k : keys){
            if(capitals.get(k).getPopulation()>=lower_limit){
                System.out.println(k 
                        + " - " + capitals.get(k).getName() 
                        + " | Pop: " + capitals.get(k).getPopulation()
                        + " | Area: " + capitals.get(k).getSquareMileage() + " sq mi");
            }
        }
        
        // Upper limit for city sq mileage
        System.out.print("\nPlease enter the upper limit for capital city sq mileage:");
        float upper_limit = myScanner.nextFloat();   
        System.out.println("\nLISTING CAPITALS WITH AREAS LESS THAN " + upper_limit + ":");
        for (String k : keys){
            if(capitals.get(k).getSquareMileage()<=upper_limit){
                System.out.println(k 
                        + " - " + capitals.get(k).getName() 
                        + " | Pop: " + capitals.get(k).getPopulation()
                        + " | Area: " + capitals.get(k).getSquareMileage() + " sq mi");
            }
        }
        
        
    }
    
}
