package pl.sstobiecki.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Destination;

@Component
public class JmsOrderMessgingServer implements  OrderMessagingService {

    private JmsTemplate jms;
    private Destination destination;

    @Autowired
    public JmsOrderMessgingServer(JmsTemplate jms, Destination destination) {
        this.jms = jms;
        this.destination = destination;
    }

    @Override
    public void sendOrder(Order order) {
        jms.convertAndSend(destination, order,
                message -> {
                    message.setStringProperty("X_ORDEROSOURCE", "WEB");
                    return message;
                });
    }

//    @Override
//    public void sendOrder(Order order) {
//        jms.send(destination,
//                session -> session.createObjectMessage(order));
//    }
}
