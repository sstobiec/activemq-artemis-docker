package pl.sstobiecki.jms;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class HelloWorldController {

    private OrderMessagingService orderMessagingService;
    private OrderReceiver orderReceiver;

    @Autowired
    public HelloWorldController(OrderMessagingService orderMessagingService, OrderReceiver orderReceiver) {
        this.orderMessagingService = orderMessagingService;
        this.orderReceiver = orderReceiver;
    }

    @GetMapping("/convertAndSend/order")
    @ResponseBody
    public String sayHello() {
        Order order = new Order();
        order.setText("Hello world!");
        orderMessagingService.sendOrder(order);
        return "No one knows what the future will bring";
    }

    @GetMapping("/convertAndReceive/order")
    @ResponseBody
    public String receiveHello() throws javax.jms.JMSException {
        log.info("Message: {} ", orderReceiver.receiveOrder());
        return null;
    }
}
