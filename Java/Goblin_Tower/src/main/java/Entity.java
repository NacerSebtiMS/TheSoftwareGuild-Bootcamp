
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nacer
 */
public class Entity {
    protected int health;
    protected int currHealth;
    protected int attack;
    protected int defense;
    protected String name;
    
    private Random rand = new Random();
    
    public int rnd(int a, int b){  
        return a + this.rand.nextInt(b-a+1);     
    }
    
    public int rollAtk(){
        return rnd(1,this.attack);
    }
    public int rollDef(){
        return rnd(0,this.defense);
    }
    
    public void attack(Entity e){
        int rolledAtk = this.rollAtk();
        int rolledDef = e.rollDef();
        int damage = rolledAtk - rolledDef;
        if (damage<0) {damage=0;}
        System.out.println(this.name+" hits for "+rolledAtk+", but"+e.name+" blocked"+rolledDef+"!");
        System.out.println(e.name+" takes "+damage+" damage!");
        e.setCurrHealth( e.getCurrHealth() - damage);
    }
    
    public boolean alive(){
        if (this.currHealth>0){return true;}
        return false;
    }
    
    public int getCurrHealth(){return this.currHealth;}
    
    public void setCurrHealth(int hp){
        if(hp>this.health){this.currHealth=this.health;}
        else if(hp<0) {this.currHealth=0;}
        else {this.currHealth=hp;}
    }
    
    public String getHP(){
        return this.currHealth +"/"+this.health;
    }
}
