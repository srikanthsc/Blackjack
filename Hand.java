import java.util.LinkedList;


public class Hand {

    LinkedList<Card> cardList =new LinkedList<Card>();
    
   

    public Hand(){

    }

    public String toString(){

        String string= "";

        for(int i=0; i < cardList.size(); i++){
               string=string + this.cardList.get(i).toString() + " ";
              
        }
        return string + " : " + count();
    }

    public void add(Card carte){
        cardList.add(carte);
    }

    public void clear(){
        cardList.clear();       
}

public LinkedList<Integer> count(){
    LinkedList<Integer> liste =new LinkedList<Integer>();
    liste.add(0);
    int val;
    for (int j=0;j< cardList.size();j++){
        int size=liste.size();
        for(int i=0;i<size;i++){
            val=liste.get(i);
            liste.set(i,val+cardList.get(j).getPoints());
            if(cardList.get(j).getPoints() ==1){
                liste.add(val+11);
            }
        }
    }
    return liste;
}
   public int best(){
       LinkedList<Integer> list=this.count();
       int max=list.get(0);
       for(int i=1;i<list.size();i++){
           if(list.get(i)>max && list.get(i) <=21){
               max= list.get(i);
           }
       }
       return max;
   }

} 
  







