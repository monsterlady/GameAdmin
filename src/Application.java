import org.json.JSONObject;

import javax.imageio.IIOException;
import java.io.IOException;

public class Application {

    public static void main(String[] args) {
        /**
         * Add method calls to your administration class below. Your program should perform the given
         * steps. Please also handle errors and print the error message when something went wrong!
         * Possible errors are:
         *  - Adding duplicate games (Games with the same name)
         *  - Adding expansions to a non existing game
         *  - Errors reading the input file (In this case the file is ok, but maybe in the future we will use a wrong file)
         */

        //TODO: Remove the following
        System.out.println("Yay! I am running!");

        //TODO: Create an instance of the game admin class
        Administrator admin = new Administrator();
        try {
        //TODO: Add the following boardgame:
        //Flash Point for 6 players, published by 999 Games
        admin.addBoardGame("Flash Point",6,15,"999 Games");
        //TODO; Add the following boardgame expansion, for the game Flash Point
        //Name: Dangerous Water, which is not standalone playable
            admin.addExpansion("Dangerous Water", false, 15);
        //TODO: Add the following boardgame:
        //Ticket to Ride for 5 players, published by Days of Wonder
        admin.addBoardGame("Ticket to Ride",5,68,"Days of Wonder");
        //TODO: Read the expansions for Ticket to Ride from the file ticket_to_ride_expansions.json

        admin.readJSONfile("ticket_to_ride_expansions.json",68);
        //TODO: Add the following cardgames
        //Poker for 4 players and with 52 cards
            admin.addCardGame("Poker",4,66,52);
        //Codenames for 8 players and with 200 cards
            admin.addCardGame("Codename",8,72,200);
    }catch (GameAdminException | IOException g){
        System.out.println(g.getMessage());
    }
        //TODO: Print the whole administration
        admin.printAllgames();
    }
}
