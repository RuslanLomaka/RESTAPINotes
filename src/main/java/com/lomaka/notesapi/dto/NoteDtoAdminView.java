package com.lomaka.notesapi.dto;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoteDtoAdminView {
    private Long id;
    private Long userId;
    private LocalDateTime createdAt;
    private boolean shared;
}
