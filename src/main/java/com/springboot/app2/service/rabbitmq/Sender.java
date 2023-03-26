package com.springboot.app2.service.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.springboot.app2.util.rabbitmq.RabbitmqUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Component
public class Sender {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private void sendMessage(String message) {
        ConnectionFactory factory = new ConnectionFactory();

        try (Connection connection = factory.newConnection()) {
            Channel channel = connection.createChannel();
            channel.exchangeDeclare(RabbitmqUtil.EXCHANGE, RabbitmqUtil.TYPE);
            channel.basicPublish(RabbitmqUtil.EXCHANGE, RabbitmqUtil.ROUTING_KEY, false, null, message.getBytes());
        } catch (TimeoutException | IOException e) {
            logger.error(e.getMessage(), e);
        }
    }

}
