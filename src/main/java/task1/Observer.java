package task1;

/**
 * abstract class defining the operations to be used to notify this object.
 */
public abstract class Observer {

    public String playerName;

    /**
     *
     * @param playerName
     * constructor for Observer with playerName param
     */
    public Observer(String playerName) {
        this.playerName = playerName;
    }

    /**
     *
     * @param message
     * @param sender
     * @param receiver
     *
     * printing the message from sender to receiver
     */
    public abstract void printMessage(String message, Player sender, Player receiver);

    // GETTERS AND SETTERS
    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
}
