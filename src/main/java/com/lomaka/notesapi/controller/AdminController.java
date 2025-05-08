package com.lomaka.notesapi.controller;

import com.lomaka.notesapi.dto.UserDtoAdminView;
import com.lomaka.notesapi.service.AdminService;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;

    @GetMapping("/users")
    public List<UserDtoAdminView> listAllUsers() {
        return adminService.getAllUsers();
    }

    @DeleteMapping("/users/{id}")
    public Map<String, String> deleteUser(@PathVariable Long id) {
        return adminService.deleteUserById(id);
    }

}
