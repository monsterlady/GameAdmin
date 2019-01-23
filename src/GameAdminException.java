public class GameAdminException extends Exception {
    public GameAdminException(String errortext){
        super("Error " + errortext );
    }
}
