package com.example.groupchat.dto;

import com.example.groupchat.model.User;

public class UserMapper {
    public static DtoUser map (User user) {
        DtoUser dtoUser = new DtoUser();
        dtoUser.setId(user.getId());
        dtoUser.setName(user.getName());
        dtoUser.setSessionId(user.getSessionId());
        return dtoUser;
    }
}
