package com.lomaka.notesapi.service;

import com.lomaka.notesapi.dto.UserDtoLoginRequest;
import com.lomaka.notesapi.dto.UserDtoRequest;
import com.lomaka.notesapi.dto.UserDtoRespond;
import java.util.Map;

public interface UserService {
    Map<String, String> register(UserDtoRequest request);

    Map<String, String> login(UserDtoLoginRequest request);

    UserDtoRespond getCurrentUser();

    Map<String, String> confirmUser(String token);
}
