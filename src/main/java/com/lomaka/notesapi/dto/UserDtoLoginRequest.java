package com.lomaka.notesapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDtoLoginRequest {
    private String username;
    private String password;
}
