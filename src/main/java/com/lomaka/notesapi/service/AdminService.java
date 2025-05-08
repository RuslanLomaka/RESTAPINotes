package com.lomaka.notesapi.service;

import com.lomaka.notesapi.dto.UserDtoAdminView;
import java.util.List;
import java.util.Map;

public interface AdminService {
    Map<String, String> deleteUserById(Long id);
    List<UserDtoAdminView> getAllUsers();
}
