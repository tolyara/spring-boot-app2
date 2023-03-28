package com.springboot.app2.service.message;

import com.springboot.app2.dao.MessageRepository;
import com.springboot.app2.dto.MessageResponse;
import com.springboot.app2.entity.Message;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;

    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public MessageResponse saveMessage(String message) {
        Message newMessage = new Message();
        newMessage.setMessage(message);
        newMessage.setCreateDate(LocalDateTime.now());

        Message savedMessage = messageRepository.save(newMessage);
        return new MessageResponse(savedMessage.getId(), savedMessage.getMessage(),savedMessage.getCreateDate());
    }

}
