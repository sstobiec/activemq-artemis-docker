package pl.sstobiecki.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import javax.jms.Destination;


@Component
public class JmsOrderReceiver implements OrderReceiver {

    private JmsTemplate jms;
    private MessageConverter converter;
    private Destination destination;

    @Autowired
    public JmsOrderReceiver(JmsTemplate jms, MessageConverter converter, Destination destination) {
        this.jms = jms;
        this.converter = converter;
        this.destination = destination;
    }

    public Order receiveOrder() throws javax.jms.JMSException {
        return (Order) jms.receiveAndConvert(destination);
    }

//    public Order receiveOrder() throws javax.jms.JMSException {
//        javax.jms.Message message = jms.receive(destination);
//        return (Order) converter.fromMessage(message);
//    }
}
