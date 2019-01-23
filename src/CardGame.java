public class CardGame extends Games {
    private int numofCard;
    public  CardGame(String name,int numofPlayers,int serialNum,int numofCard  ){
        super(name,numofPlayers,serialNum);
        this.numofCard = numofCard;
    }

    public int getNumofCard() {
        return numofCard;
    }

    @Override
    public String toString() {
        return getName() + "(" + getNumofPlayers() + " players ), has " + getNumofCard() + "cards.";
    }
}
