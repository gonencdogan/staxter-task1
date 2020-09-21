package task1;

import java.util.ArrayList;
import java.util.List;

public class MessageService implements IMessageService {

    private final List<Observer> observers = new ArrayList<>(); // players List
    private int receivedMessagesCount = 0;
    private int sentMessagesCount = 0;

    /**
     *
     * @param o
     *
     * implementation of IMessageService method attach
     */
    @Override
    public void attach(Observer o) {
        observers.add(o);
    }

    /**
     *
     * @param message the message to be send
     * @param sender senden player
     * @param receiver receiver player
     * @param isReply initial message or replyMessage? true or false
     *
     * implementation of IMessageService method sendMessage
     */
    @Override
    public void sendMessage(String message, Player sender, Player receiver, boolean isReply) {
        // If the player initiator sent and received 10 messages then exit
        if (sentMessagesCount >= 10 && receivedMessagesCount >= 10){
            System.out.println("program ends in peace!");
            System.exit(0);
        }

        // Find the message receiver player, do not send the message to all subscribers
        Observer receiverPlayer = observers.stream().filter(p -> p.playerName.equals(receiver.getPlayerName())).findAny()
                .orElse(null);

        // If the receiver player is found send the message and notify
        if (receiverPlayer != null) {
            receiverPlayer.printMessage(message, sender, receiver);

            //  If the sender is initiator count the sending messages
            if (sender.getPlayerName().equals(Constants.INITIATOR)){
                sentMessagesCount++;
            }

            //  If the message is just for the reply
            if (!isReply){
                sendMessage("Got the " + message + " thank you!", receiver, sender, true);

                //  If the receiver is initiator count the receiving messages
                if (sender.getPlayerName().equals(Constants.INITIATOR)){
                    receivedMessagesCount++;
                }
            }
        }
    }
}
