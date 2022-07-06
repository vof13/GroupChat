package com.example.groupchat.dto;

import com.example.groupchat.model.Message;

public class MessageMapper {

    public static DtoMessage map (Message message ) {
        DtoMessage dtoMessage = new DtoMessage();
        dtoMessage.setDatetime(message.getDateTime());
        dtoMessage.setUsername(message.getUser().getName());
        dtoMessage.setText(message.getMessage());
        return dtoMessage;
    }
}
