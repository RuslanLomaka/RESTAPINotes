package com.lomaka.notesapi.maper;


import com.lomaka.notesapi.dto.NoteDtoAdminView;
import com.lomaka.notesapi.dto.NoteDtoRequest;
import com.lomaka.notesapi.dto.NoteDtoRespond;
import com.lomaka.notesapi.model.Note;
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

    public NoteDtoAdminView toAdminViewDto(Note note) {
        NoteDtoAdminView dto = new NoteDtoAdminView();
        dto.setId(note.getId());
        dto.setUserId(note.getUser().getId());
        dto.setCreatedAt(note.getCreatedAt());
        dto.setShared(note.isShared());
        return dto;
    }

}

