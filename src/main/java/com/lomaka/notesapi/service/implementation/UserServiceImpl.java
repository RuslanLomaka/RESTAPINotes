package com.lomaka.notesapi.service.implementation;

import com.lomaka.notesapi.dto.UserDtoLoginRequest;
import com.lomaka.notesapi.dto.UserDtoRequest;
import com.lomaka.notesapi.dto.UserDtoRespond;
import com.lomaka.notesapi.maper.UserDtoMapper;
import com.lomaka.notesapi.model.Role;
import com.lomaka.notesapi.model.User;
import com.lomaka.notesapi.repository.UserRepository;
import com.lomaka.notesapi.service.UserService;
import com.lomaka.notesapi.util.EmailService;
import com.lomaka.notesapi.util.JwtService;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final UserDtoMapper userDtoMapper;
    private final EmailService emailService;
    private final AuthenticationManager authenticationManager;

    @Value("${app.base.url}")
    private String baseUrl;



    /**
     * POST /users/register
     */
    @Override
    @Transactional
    public Map<String, String> register(UserDtoRequest request) {
        // 1. build entity
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setEmail(request.getEmail());
        user.setRole(Role.USER);
        user.setEnabled(false);

        String token = generateToken();                       // single UUID
        LocalDateTime now = LocalDateTime.now();
        user.setVerificationToken(token);
        user.setTokenCreatedAt(now);
        user.setTokenExpiresAt(now.plusMinutes(15));

        // 2. persist → guarantees confirm() can find the token
        userRepository.save(user);

        // 3. send e‑mail (rollback if this blows up)

        try {
            String link = baseUrl + "/users/confirm?token=" + token;
            emailService.sendVerificationEmail(user.getEmail(), link);
        } catch (Exception ex) {
            throw new IllegalStateException("Failed to send verification e‑mail", ex);
        }

        // 4. tell caller we’re good
        return Map.of("message", "User registered. Please confirm e‑mail. If you don't see the confirmation message, chek in spam");
    }

    /**
     * GET /users/confirm?token=...
     */
    @Override
    public Map<String, String> confirmUser(String token) {
        User user = userRepository.findByVerificationToken(token)
                .orElseThrow(() -> new IllegalArgumentException("Invalid token"));

        if (user.getTokenExpiresAt().isBefore(LocalDateTime.now())) {
            return Map.of("message", "Token expired.");
        }

        user.setEnabled(true);
        user.setVerificationToken(null);
        user.setTokenCreatedAt(null);
        user.setTokenExpiresAt(null);
        userRepository.save(user);

        return Map.of("message", "Email confirmed successfully.");
    }

    @Override
    public Map<String, String> login(UserDtoLoginRequest dto) {
        // 1) authenticate
        var authToken = new UsernamePasswordAuthenticationToken(
                dto.getUsername(), dto.getPassword());
        authenticationManager.authenticate(authToken);   // throws if bad

        // 2) issue JWT
        String jwt = jwtService.generateToken(dto.getUsername(),
                Duration.ofMinutes(30));

        return Map.of("token", jwt);
    }

    @Override
    public UserDtoRespond getCurrentUser() {
        // TODO: implement get current user logic
        return null;
    }

    /* util */
    private String generateToken() {
        return UUID.randomUUID().toString();   // TokenUtil wrapper if you prefer
    }
}
