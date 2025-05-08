package com.lomaka.notesapi.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NoteDtoRespond {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
}
