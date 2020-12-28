

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nacer
 */
public class Hero extends Entity {
    
    private int[] potions = new int[5];
    private int gold;
    private int level;
      
    
    public Hero(String name){
        this.health = rnd(20,30);
        this.currHealth = this.health;
        this.attack = rnd(1,3);
        this.defense = rnd(1,5);
        for(int i=0; i<this.potions.length; i++)    {this.potions[i] = 2;}      
        this.gold = 0;
        this.name = name;
        this.level = 1;
    }
        
    public int availableSlots(){
        int empty_slots = 0;
        for(int i=0; i<this.potions.length; i++){
            if(this.potions[i]==0){
                empty_slots+=1;
            }
        }
        return empty_slots;
    }
    
    public void buyPotion(int price, int value){
        this.gold -= price;
        int i=0;
        while(this.potions[i]!=0 && i<this.potions.length){
            i++;
        }
        this.potions[i] = value;
    }
    
    public void drinkPotion(){
        int i =0;
        while(this.potions[i]==0){
            i++;
        }
        this.setCurrHealth( this.potions[i] + this.currHealth );
        this.potions[i] = 0;
    }
    
    public void resurrect(){
        int gold = getGold();
        this.health = rnd(20,30);
        this.attack = rnd(1,3);
        this.defense = rnd(1,5);
        for(int i=0; i<this.potions.length; i++)    {this.potions[i] = 2;}        
    }
    
    public int getGold(){return this.gold;}
    
    public void gainGold(int gold){ this.gold += gold;}
    
    
}
