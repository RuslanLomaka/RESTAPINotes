package com.lomaka.notesapi.util;

import java.util.UUID;


public class TokenUtil {
    public static String generateToken() {
        return UUID.randomUUID().toString();
    }
}