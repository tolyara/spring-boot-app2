package com.springboot.app2.service.message;

import com.springboot.app2.dao.MessageRepository;
import com.springboot.app2.dto.MessageResponse;
import com.springboot.app2.entity.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MessageServiceImpl implements MessageService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final MessageRepository messageRepository;

    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public MessageResponse saveMessage(String message) {
        logger.info("Saving message : {}", message);
        Message newMessage = new Message();
        newMessage.setMessage(message);
        newMessage.setCreateDate(LocalDateTime.now());

        Message savedMessage = messageRepository.save(newMessage);
        return new MessageResponse(savedMessage.getId(), savedMessage.getMessage(),savedMessage.getCreateDate());
    }

}
