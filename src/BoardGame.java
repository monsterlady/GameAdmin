public class BoardGame extends Games {
    private String publisher;

    public BoardGame(String name,int numofPlayers,int serialNum,String publisher){
        super(name,numofPlayers,serialNum);
        this.publisher = publisher;
    }

    public String getPublisher() {
        return publisher;
    }

    @Override
    public String toString() {
            return getName() + "(" + getNumofPlayers() + " players), "  + "published by " + getPublisher() ;
        }
    }

