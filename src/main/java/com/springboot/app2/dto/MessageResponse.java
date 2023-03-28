package com.springboot.app2.dto;

import java.time.LocalDateTime;

public class MessageResponse {

    private Long messageId;

    private String message;

    private LocalDateTime createDate;

    public MessageResponse() {
    }

    public MessageResponse(Long messageId, String message, LocalDateTime createDate) {
        this.messageId = messageId;
        this.message = message;
        this.createDate = createDate;
    }

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
