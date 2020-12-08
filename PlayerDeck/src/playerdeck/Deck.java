package playerdeck;


import java.util.ArrayList;
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
public class Deck {

    private String[] colors = {"Spade", "Heart", "Diamond", "Club"};
    private String[] numbers = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
    private String link = " of ";


    private ArrayList<String> deck;
    private ArrayList<String> player1 = new ArrayList<String>();
    private ArrayList<String> player2 = new ArrayList<String>();

    private int cards = 52; //sets the number of card per game

    public Deck(){
        createDeck();
    }

    public void setCards(int n){
        this.cards = n;
    }

    private void createDeck(){
        deck = new ArrayList<String>();
        for (int i = 0; i < colors.length; i++){
            for (int j = 0; j < numbers.length; j++){
                deck.add( numbers[j]+link+colors[i] );
            }
        }
    }

    public void show(ArrayList<String> cards){
        for(int i = 0; i < cards.size(); i++){
            System.out.println(i+1 +" - "+cards.get(i));
        }
    }

    public void shuffle(){
        ArrayList<String> temp_deck = new ArrayList<String>();
        int index;
        Random rand = new Random();
        while(deck.size()-52+this.cards!=0){
            index = rand.nextInt(deck.size());
            temp_deck.add( deck.remove(index)  );               
        }
        this.deck = temp_deck;
    }

    public ArrayList<String> draw(int n){
        ArrayList<String> d = new ArrayList<String>();
        int i=n;
        while(i>0 && this.deck.size()>0){
            d.add(this.deck.remove(0));
            i = i-1;
        }
        System.out.println("Drawing "+ (n-i) +" cards.");
        return d;
    }

    public ArrayList<String> playCard(ArrayList<String> player,int c){
        System.out.println("Card played : "+player.remove(c));
        return player;           
    }

    public ArrayList<String> player_turn(ArrayList<String> player,int p,int d){
        System.out.println("_____");
        System.out.println("Player"+p+" turn!");
        if (player.isEmpty()){
            player = this.draw(d);
        }
        if(!player.isEmpty()){
            int card_to_play;
            Scanner myScanner = new Scanner(System.in);
            System.out.println("");
            System.out.println("Hand:");
            this.show(player);
            do{
                System.out.println("Which card you want to play");
                card_to_play = myScanner.nextInt();
            } while(card_to_play>player.size() || card_to_play<0);
            player = this.playCard(player, card_to_play-1);            
        } else {
            System.out.println("No more cards :(");
        }

        return player;

    }


    public void play(int x){
        boolean playAgain = true;           
        Scanner myScanner = new Scanner(System.in);          
        while(playAgain){
            this.createDeck();
            this.shuffle();

            while(this.deck.size()>0 || !player1.isEmpty() || !player2.isEmpty()){
                this.player1 = this.player_turn(player1, 1, x);
                this.player2 = this.player_turn(player2, 2, x);                 
            }
            System.out.println("No more cards, Play again?\n");

            String in = myScanner.nextLine();
            playAgain = false;
            if("y".equals(in) || "yes".equals(in) || "ye".equals(in)){
                playAgain = true;
            }

        }
    }

}
