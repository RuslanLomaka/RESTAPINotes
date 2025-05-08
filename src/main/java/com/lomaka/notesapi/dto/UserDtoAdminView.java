package com.lomaka.notesapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDtoAdminView {
    private Long id;
    private String username;
    private String role;
    private boolean enabled;
}
