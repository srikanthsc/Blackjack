
 import java.util.*;
 import java.io.*;

 public class BlackJackConsole  {
    public BlackJackConsole() throws EmptyDeckException {
        System.out.println("Welcome to the BlackJack table. Let's play !");
        
          Deck deck=new Deck(2);
          Hand hand=new Hand();
          BlackJack blackjack=new BlackJack();
          Scanner sc=new Scanner(System.in);
          System.out.println("Your hand is currently : "+ hand);
          System.out.println("Here is the deck "+deck+"\n");
          for(int i = 0 ; i < 3 ; i ++) {
              try{ 
                hand.add(deck.draw());
              Card c=deck.draw();
            System.out.println(" this card is a  " + c + " worth " + c.getPoints() + " points ");
            System.out.println(" it's a ");

            switch(c.getColorSymbole()) {
                case "\u2665": System.out.print(" heart ");break;
                case "\u2660": System.out.print(" spade "); break;
                case "\u2663": System.out.print(" club "); break;
                case "\u2666": System.out.print(" diamond ");break;
            }
            if(c.getValueSymbole().matches("[JQK]")) {
                System.out.println(" and a face ! ");
            }else{
                System.out.println(" and it's not a face. ");
            }  
            } catch (EmptyDeckException ex) {
                System.err.println(ex.getMessage());
                System.exit(-1);
            }
        }
        System.out.println("Your hand is currently : "+ hand);
        System.out.println(" your best score is: "+ hand.best() );
          hand.clear();
           System.out.println("Your hand is currently : "+ hand);
           //-----------------------------------------jeu BlackJack---------------------------------------------------------------------------------// 
           System.out.println(" the bank draw: "+blackjack.getBankHandString());
           System.out.println(" you draw : "+blackjack.getPlayerHandString());
          
           System.out.println("Do you want another card : [y/N]: ");

           
           String a=sc.nextLine();
          
         blackjack.playerDrawAnotherCard();
        
          System.out.println("your new hand:"+blackjack.getPlayerHandString());
          System.out.println("Do you want another card : [y/N]: ");
          String b=sc.nextLine();
         blackjack.playerDrawAnotherCard();
          System.out.println("your new hand:"+blackjack.getPlayerHandString());
          System.out.println("Do you want another card : [y/N]: ");
          String c=sc.nextLine();
         


          
        
          
        blackjack.bankLastTurn();
        System.out.println("the bank draw cards. New hand:" +blackjack.getBankHandString());






           System.out.println("player best:"+blackjack.getPlayerBest());
           System.out.println("bank best:"+ blackjack.getBankBest());
           System.out.println("draw !");
           
           try {
            FileWriter fw = new FileWriter("score.txt");
            fw.write("player:"+blackjack.getPlayerBest());
            
            fw.write("\n bank:"+blackjack.getBankBest());
            
            fw.close();
            
          } catch (IOException e) {
            e.printStackTrace();
          }
           
           
         
    }
    public static void main(String[] args ) throws EmptyDeckException{
        new BlackJackConsole() ;
    }

}