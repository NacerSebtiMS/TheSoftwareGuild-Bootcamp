
import java.util.Random;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nacer
 */
public class Tower {
    private float encounter_chance; // should be between 0 and 1
    private int steps;
    
    private Hero player;
    private Entity monster;
    
    private Random rd = new Random();
    Scanner myScanner = new Scanner(System.in); 
    
    public Tower(float encounter_chance){
        this.encounter_chance = encounter_chance;
    }
    
    public void climbTower(){
        boolean playAgain = true;
        System.out.println("Hi travelever, you wish to become a Hero?");
        System.out.println("What is your name?");
        String name = this.myScanner.nextLine();
        this.player = new Hero(name);
        String choice;
        boolean fight;
        
        while(playAgain){
            this.steps = 0;
            while(player.alive()){
                this.steps++;
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println("Step "+this.steps);
                
                if(this.steps %10 == 0){
                    this.potionshop();
                }
                
                fight = nextStep();                
                if(fight){
                    this.encounter();
                } else {
                    System.out.println("You take a safe step.");
                }
                
                
            }
            System.out.println();
            System.out.println("YOU DIED!");
            System.out.println();
            System.out.println("You reached step "+ this.steps + "\nResurrect?");
            
            choice = this.myScanner.nextLine();
            playAgain = false;
            if("y".equals(choice) || "yes".equals(choice) || "ye".equals(choice)){
                playAgain = true;
                player.resurrect();                
            }
            
            
        }
    }
    
    public boolean nextStep(){ //Will there be an encounter?
        if (rd.nextFloat() < this.encounter_chance){return true;}
        return false;
    }
    
    public boolean encounter(){
        monster = new Goblin();
        System.out.println("You found a Goblin!");
        int action;
        while(monster.alive() && player.alive()){
            System.out.println();
            System.out.println("Goblin "+monster.getHP());
            System.out.println();
            System.out.println(player.name+" "+player.getHP());
            do{
                System.out.println();
                System.out.println("Choose an action:");
                System.out.println("1- Attack");
                System.out.println("2- Drink a potion ("+(5-this.player.availableSlots())+" Remaining");
                action = this.myScanner.nextInt();               
            }while(action<0 || action>2);
            
            if(action==1){
                player.attack(monster);
            } else if (action == 2){
                if(this.player.availableSlots()==5){
                    System.out.println("You look in your inventory but you have no potion left. You loose your turn.");
                } else {
                    this.player.drinkPotion();
                }
            }
            
            if(monster.alive()){
                monster.attack(player);
            }
        }
        
        if(player.alive())  {
            System.out.println("You got 2 gold.\tGold in pocket: "+this.player.getGold());
            player.gainGold(2);
            return true;
        }
        return false;
    }
    
    public void potionshop(){
        System.out.println("Welcome to the potion shop.");
        boolean shopping = true;
        String choice;
        Scanner myScanner = new Scanner(System.in);
        while(shopping && player.getGold()>=4 && player.availableSlots()>=1){          
            System.out.println("Would you like to buy a potion for 4 gold?");       
            System.out.println("Gold:"+this.player.getGold()+"\tEmpty Slots:"+this.player.availableSlots());
            choice = myScanner.nextLine();
            shopping = false;
            if("y".equals(choice) || "yes".equals(choice) || "ye".equals(choice)){
                shopping = true;
                player.buyPotion(4, 2);
                
            }
        }
        if(shopping){
            if(player.getGold()<4){
                System.out.println("You don't have enough gold.");
                System.out.println("You're kicked out of the shop");
            }
            if(player.availableSlots()==0){
                System.out.println("You don't have enough slots for your potions");
            }
        }
    }
    
    public int getSteps(){
        return this.steps;
    }
}
