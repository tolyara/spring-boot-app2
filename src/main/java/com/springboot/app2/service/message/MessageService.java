package com.springboot.app2.service.message;

import com.springboot.app2.dto.MessageResponse;

public interface MessageService {

    MessageResponse saveMessage(String message);

}
