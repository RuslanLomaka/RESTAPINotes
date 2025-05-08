package com.lomaka.notesapi.service.implementation;

import com.lomaka.notesapi.dto.UserDtoAdminView;
import com.lomaka.notesapi.service.AdminService;
import com.lomaka.notesapi.util.EmailService;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AdminServiceImpl implements AdminService {
    private final EmailService emailService;
    @Override
    public Map<String, String> deleteUserById(Long id) {
        return Map.of();
    }

    @Override
    public List<UserDtoAdminView> getAllUsers() {
        return List.of();
    }
    // Implement admin service methods
}
