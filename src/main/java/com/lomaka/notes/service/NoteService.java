package com.lomaka.notes.service;

import com.lomaka.notes.dto.NoteDtoRequest;
import com.lomaka.notes.dto.NoteDtoRespond;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public interface NoteService {

    NoteDtoRespond createNote(NoteDtoRequest note);

    NoteDtoRespond getNoteById(Long id);

    List<NoteDtoRespond> getAllNotes();

    NoteDtoRespond updateNote(Long id,NoteDtoRequest  updatedNote);

    NoteDtoRespond patchNote(Long id, NoteDtoRequest note);

    Map<String,String> deleteNoteById(Long id);

}