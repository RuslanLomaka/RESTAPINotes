package com.lomaka;

import com.lomaka.notesapi.util.JwtService;
import java.time.Duration;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class TestRoundTripJwt {
    @Test
    void roundTrip() {
        JwtService jwt = new JwtService();
        ReflectionTestUtils.setField(jwt, "secret",
                "f/1nP4qf0JqJbS3cFkeYIC2K5OzDQomAdh8onQ8aXnM=");

        String t = jwt.generateToken("test@example.com", Duration.ofMinutes(5));
        assertEquals("test@example.com", jwt.extractUsername(t));
        assertTrue(jwt.isTokenValid(t, "test@example.com"));
    }
}

