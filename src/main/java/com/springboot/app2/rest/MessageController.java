package com.springboot.app2.rest;

import com.springboot.app2.dto.MessageResponse;
import com.springboot.app2.entity.Message;
import com.springboot.app2.service.message.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/messages")
public class MessageController {

    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    // TODO - replace with POST
    @GetMapping("/{message}")
    public MessageResponse sendMessage(@PathVariable String message) {
        return messageService.saveMessage(message);
    }

}
