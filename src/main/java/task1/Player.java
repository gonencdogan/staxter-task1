package task1;

/**
 * Player class extending from abstract class Observer
 */
public class Player extends Observer {

    /**
     * constructor
     * @param playerName
     */
    Player(String playerName) {
        super(playerName);
    }


    @Override
    public void printMessage(String message, Player sender, Player receiver) {
        System.out.println(sender.getPlayerName() + " sent message to " + this.getPlayerName() + " the message: " + message);
    }
}
