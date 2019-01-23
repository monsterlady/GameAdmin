public class DLC extends BoardGame {
    private boolean isStandAlone;
    public DLC(String name,int numofPlayers,String publisher,int serialNum,boolean isStandAlone){
        super(name,numofPlayers,serialNum,publisher);
        this.isStandAlone = isStandAlone;
    }

    public boolean isStandAlone() {
        return isStandAlone;
    }

    @Override
    public String toString() {
       if(isStandAlone()){
           return "          "+getName() + " (Can be played standalone)";
       } else {
           return "          "+getName();
       }
    }
}
