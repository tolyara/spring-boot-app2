package com.springboot.app2.service.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.springboot.app2.util.rabbitmq.RabbitmqUtil;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@Component
public class Consumer {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

//    @PostConstruct
    private void init() {
        listenForMessages();
    }

    private void listenForMessages() {
        try {
            ConnectionFactory factory = new ConnectionFactory();
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();

            channel.queueDeclare(RabbitmqUtil.QUEUE, false, false, false, null);
            channel.queueBind(RabbitmqUtil.QUEUE, RabbitmqUtil.EXCHANGE, RabbitmqUtil.ROUTING_KEY);
            channel.basicConsume(RabbitmqUtil.QUEUE, false,
                    (consumerTag, message) -> { logger.info("Got a message : {} ", new String(message.getBody(), StandardCharsets.UTF_8)); },
                    (consumerTag, sig) -> { logger.error("Got an exception : {}", sig.getMessage()); });
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

}
