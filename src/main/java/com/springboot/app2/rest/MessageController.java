package com.springboot.app2.rest;

import com.springboot.app2.dto.MessageDto;
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

    @Deprecated
    @GetMapping("/{message}")
    public MessageResponse sendMessageOld(@PathVariable String message) {
        return messageService.saveMessage(message);
    }

    @PostMapping
    public MessageResponse sendMessage(@RequestBody MessageDto messageDto) {
        return messageService.saveMessage(messageDto.getMessage());
    }

}
