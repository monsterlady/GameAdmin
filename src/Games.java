public abstract class Games {
    private String name;
    private int numofPlayers;
    private int serialNum;

    public Games(String name,int numofPlayers,int serialNum){
        this.name = name;
        this.numofPlayers = numofPlayers;
        this.serialNum = serialNum;

    }

    public String getName() {
        return name;
    }


    public int getNumofPlayers() {
        return numofPlayers;
    }

    public int getSerialNum() {
        return serialNum;
    }

    public String toString(){
        return name + numofPlayers;
    }
}
