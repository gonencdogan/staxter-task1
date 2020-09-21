package task1;

/**
 * IMessageService interface has 2 methods. attach and send message
 */
public interface IMessageService {

    /**
     *
     * @param o
     * add subscriber
     */
    void attach(Observer o);

    /**
     *
     * @param message
     * @param sender
     * @param receiver
     * @param isReply
     *
     * method for sending message. Sender sends the message to receiver
     */
    void sendMessage(String message, Player sender, Player receiver, boolean isReply);

}
