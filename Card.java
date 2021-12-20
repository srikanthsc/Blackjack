public class Card {
    private Value value;
    private Color color;
    

   


    Card (Value value , Color color){
        this.value=value;
        this.color=color;
        
        
    }
    public String toString(){
        return this.getValueSymbole() + this.getColorSymbole();
    }

    public String getColorSymbole() {
        return color.getSymbole();
    }
    public String getColorName(){
        return color.name();
    }

    public String getValueSymbole(){
        return value.getSymbole();
    }
    public int getPoints(){
        return value.getPoints();
    }

}
