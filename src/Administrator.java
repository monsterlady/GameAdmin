import netscape.javascript.JSObject;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Administrator {
    private ArrayList<Games> gameArrayList = new ArrayList<>();
    private ArrayList<DLC> dlcArrayList = new ArrayList<>();


    public void printAllgames(){
       printBoardGame();
       printCardGame();
    }

    public void printBoardGame(){
        int order = 0;
        for (int i = 0;i < gameArrayList.size();i++){
            if(gameArrayList.get(i) instanceof BoardGame){
                order++;
                System.out.println("Board Game: "+ order+ ". "+gameArrayList.get(i).toString());
                System.out.println("Expansion: ");
                for(DLC E : dlcArrayList){
                    if(E.getSerialNum() == ((BoardGame) gameArrayList.get(i)).getSerialNum()){
                        System.out.println(E.toString());
                    }
                }
            }
        }
    }

    public void printCardGame(){
        int order = 0;
        for (int i = 0;i < gameArrayList.size();i++){
            if(gameArrayList.get(i) instanceof CardGame){
                order++;
                System.out.println("Card Game: "+ order+ ". "+ gameArrayList.get(i).toString());
            }
        }
    }

    public void addBoardGame(String name,int numofPlayers,int serialNum,String publisher) throws GameAdminException{
        if(gameArrayList.isEmpty()) {
            BoardGame nwBoardGame = new BoardGame(name, numofPlayers, serialNum, publisher);
            gameArrayList.add(nwBoardGame);

        } else if(isDuplicated(serialNum)){
            throw new GameAdminException( name +" has duplicated Serial Number");
        } else {
            BoardGame nwBoardGame = new BoardGame(name, numofPlayers, serialNum, publisher);
            gameArrayList.add(nwBoardGame);

        }
    }

    public void addCardGame(String name,int numofPlayers,int serialNum,int numofCard)throws GameAdminException{
        if(gameArrayList.isEmpty()) {
            CardGame nwCardGame = new CardGame(name, numofPlayers, serialNum, numofCard);
            gameArrayList.add(nwCardGame);
        } else if(isDuplicated(serialNum)){
            throw new GameAdminException( name +" has duplicated Serial Number");
        } else {
            CardGame nwCardGame = new CardGame(name, numofPlayers, serialNum, numofCard);
            gameArrayList.add(nwCardGame);
        }
    }

    public  void addExpansion(String name,boolean isStandAlone,int serialNum) throws GameAdminException {
            String publisher = "";
            int numofPlayers = 0;
            boolean isMatched = false;
            for (Games each : gameArrayList) {
                if (each.getSerialNum() == serialNum && each instanceof BoardGame) {
                    numofPlayers = each.getNumofPlayers();
                    publisher = ((BoardGame) each).getPublisher();
                    DLC nwDLC = new DLC(name, numofPlayers, publisher, serialNum, isStandAlone);
                    dlcArrayList.add(nwDLC);
                    isMatched = true;
                }
            }
            if(!isMatched){
                    throw new GameAdminException("Serial Number doesn't match! Check it again !");
            }
    }

    public void readJSONfile(String filename,int serialNum) throws IOException {
        try{
        String jsonString = new String(Files.readAllBytes(Paths.get(filename)));
        JSONArray jsonArray = new JSONArray(jsonString);
        for(int i = 0;i<jsonArray.length();i++){
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            addExpansion(jsonObject.getString("name"),jsonObject.getBoolean("canPlayedStandalone"),serialNum);
        }
        }catch (IOException | GameAdminException i){
            System.out.println(i.getMessage());
        }
    }

    public boolean isDuplicated(int serialNum){
        boolean isduplicated = false;
        for (Games eachgame : gameArrayList) {
            if (eachgame.getSerialNum() == serialNum) {
                isduplicated = true;
                break;
            }
        }
        return isduplicated;
    }


}
