package task1;

public class MainApp {

    /**
     *
     * @param args
     * Main class - where it all begins
     */
    public static void main(String[] args)
    {
        // create the initiator Player
        Player initiator = new Player(Constants.INITIATOR);

        // create the second Player
        Player secondPlayer = new Player(Constants.SECOND_PLAYER);

        // create the MessageService instance
        MessageService p = new MessageService();

        // add Players to MessaageService (ADD OBSERVER IN OBSERVABLE PATTERN)
        p.attach(initiator);
        p.attach(secondPlayer);

        // try to send message from initiator player to second player (waiting for stop after 10 messages)
        for (int i = 0 ; i < 20; i++){
            p.sendMessage((i+1) + ".Message", initiator, secondPlayer, false);
        }

    }

}
