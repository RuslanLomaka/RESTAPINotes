package com.lomaka.notesapi.maper;

import com.lomaka.notesapi.dto.UserDtoAdminView;
import com.lomaka.notesapi.dto.UserDtoRequest;
import com.lomaka.notesapi.dto.UserDtoRespond;
import com.lomaka.notesapi.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserDtoMapper {

    public User toEntity(UserDtoRequest dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        return user;
    }

    public UserDtoRespond toRespondDto(User user) {
        UserDtoRespond dto = new UserDtoRespond();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setRole(user.getRole().name());
        dto.setEnabled(user.isEnabled());
        return dto;
    }

    public UserDtoAdminView toAdminViewDto(User user) {
        UserDtoAdminView dto = new UserDtoAdminView();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setRole(user.getRole().name());
        dto.setEnabled(user.isEnabled());
        return dto;
    }

    public List<UserDtoAdminView> toAdminViewDtoList(List<User> users) {
        return users.stream()
                .map(this::toAdminViewDto)
                .collect(Collectors.toList());
    }
}
