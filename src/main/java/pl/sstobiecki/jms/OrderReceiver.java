package pl.sstobiecki.jms;

public interface OrderReceiver {
    Order receiveOrder() throws javax.jms.JMSException;
}
