package com.lomaka.notes.service;

import com.lomaka.notes.dto.NoteDto;
import com.lomaka.notes.entity.Note;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public interface NoteService {

    Note createNote(Note note);

    Note getNoteById(Long id);

    Iterable<Note> getAllNotes();

    Note updateNote(Long id, Note updatedNote);

    Note patchNote(Long id, NoteDto note);

    Map<String,String> deleteNoteById(Long id);



}
