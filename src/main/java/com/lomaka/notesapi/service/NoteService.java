package com.lomaka.notesapi.service;

import com.lomaka.notesapi.dto.NoteDtoRequest;
import com.lomaka.notesapi.model.Note;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public interface NoteService {

    Note createNote(NoteDtoRequest note);

    Note getNoteById(Long id);

    List<Note> getAllNotes();

    Note updateNote(Long id,NoteDtoRequest  updatedNote);

    Note patchNote(Long id, NoteDtoRequest note);

    Map<String,String> deleteNoteById(Long id);

}