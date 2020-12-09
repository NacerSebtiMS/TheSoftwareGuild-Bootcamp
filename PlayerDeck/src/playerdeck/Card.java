/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package playerdeck;

/**
 *
 * @author nacer
 */
public class Card {
    private String title;
    private String description;
    
    public Card(String title, String description){
        this.title = title;
        this.description = description;
    }
    
    public String getTitle() { return this.title; }
    
    public String getDescritpion() { return this.description; }
}
