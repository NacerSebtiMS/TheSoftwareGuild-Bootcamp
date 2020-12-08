/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 *
 * @author nacer
 */
public class Goblin extends Entity {
    
    public Goblin(){
        this.health = rnd(5,10);
        this.currHealth = this.health;
        this.attack = rnd(2,3);
        this.defense = rnd(1,2);
        this.name = "Goblin";
    }
    
    public int dropGold(){
        return 2;
    }
}
