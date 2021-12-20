import java.io.*;

public class BlackJack {
    private Deck deck;
    private Hand playerHand;
    private Hand bankHand;
    private Boolean gameFinished;
    private int playerScore;
    private int bankScore;
    private String SCORE_FILENAME;


    public BlackJack(){

        this.deck=new Deck(4);
        this.playerHand=new Hand();
        this.bankHand=new Hand();
        this.gameFinished=false;
        reset();
        

    }

    public void reset()  {

        
      playerHand.clear();
      bankHand.clear();
      try{
      playerHand.add(deck.draw());
      bankHand.add(deck.draw());
      } catch (EmptyDeckException ex){
        System.err.println(ex.getMessage());
        System.exit(-1);
      

      }

    }
    public String getPlayerHandString(){
           return playerHand.toString();
    }
    public String getBankHandString(){

        return bankHand.toString();

    }
    public int getPlayerBest(){

        return playerHand.best();

    }
    public int getBankBest(){

        return bankHand.best();

    }
    public Boolean isPlayerWinner(){

        if(isGameFinished() && getPlayerBest() <= 21 && (getPlayerBest() > getBankBest() || getBankBest() > 21)){  
            return true; 
      }  else {
          return false;
     
      }       
    }
    public Boolean isBankWinner(){ 
        
        if(isGameFinished() && getBankBest() <= 21 && (getPlayerBest() < getBankBest() || getPlayerBest() > 21)){  
                   return true;
    } else {
        return false;
    }
    }
    public Boolean isGameFinished(){


      if(gameFinished==false){

      
       return false;
      } else {

       
         return true;
    }
    }
    public void playerDrawAnotherCard() throws EmptyDeckException {
      
        if(gameFinished==false){
            try{
                playerHand.add(deck.draw());
            } catch (EmptyDeckException ex){
                System.err.println(ex.getMessage());
                System.exit(-1); 

            }
             if(getPlayerBest()>21){
                 gameFinished=true;
             }
                    
                
            
        }
         
    }

    public void bankLastTurn() throws EmptyDeckException{


        while(getBankBest() <=21 && isGameFinished() == false && getPlayerBest()>21){
            try{
                bankHand.add(deck.draw());
            } catch (EmptyDeckException ex) {
                System.err.println(ex.getMessage());
                System.exit(-1);
        }     
        
        if(getBankBest() > getPlayerBest()){
            gameFinished=true;
                  break;
        }
        }
    }

    //on a utiliser une autre methode pour copier les scores dans un fichier txt voir la class BlackJackConsole  ligne 43.
    public void updateScores(){
           
    }

    public void writeScore(){

             
    }

    public void readScore(){

        

    }
}

    