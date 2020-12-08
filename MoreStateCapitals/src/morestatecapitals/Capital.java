/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package morestatecapitals;

/**
 *
 * @author nacer
 */
public class Capital {
    private String name;
    private int population;
    private float squareMileage;
    
    public Capital(String name, int population, float squareMileage){
        this.name = name;
        this.population = population;
        this.squareMileage = squareMileage;
    }
    
    public String getName() {return this.name;}
    
    public int getPopulation() {return this.population;}
    
    public float getSquareMileage() {return this.squareMileage;}
    
}
