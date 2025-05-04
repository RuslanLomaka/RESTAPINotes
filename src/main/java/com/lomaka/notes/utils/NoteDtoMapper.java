package com.lomaka.notes.utils;


import com.lomaka.notes.dto.NoteDtoRequest;
import com.lomaka.notes.dto.NoteDtoRespond;
import com.lomaka.notes.entity.Note;
import org.springframework.stereotype.Component;

@Component
public class NoteDtoMapper {

    public Note toEntity(NoteDtoRequest noteDtoRequest) {
        Note note = new Note();
        note.setTitle(noteDtoRequest.getTitle());
        note.setContent(noteDtoRequest.getContent());
        return note;
    }

    public NoteDtoRespond toRespondDto(Note note) {
        NoteDtoRespond noteDtoRespond = new NoteDtoRespond();
        noteDtoRespond.setId(note.getId());
        noteDtoRespond.setTitle(note.getTitle());
        noteDtoRespond.setContent(note.getContent());
        noteDtoRespond.setCreatedAt(note.getCreatedAt());
        return noteDtoRespond;
    }
}