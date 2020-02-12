package pl.sstobiecki.jms;

public interface OrderMessagingService {
    void sendOrder(Order order);
}
