package com.lomaka.notes.service;

import com.lomaka.notes.dto.NoteDto;
import com.lomaka.notes.entity.Note;
import com.lomaka.notes.repository.NoteRepository;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@RequiredArgsConstructor
@Service
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;

    @Override
    public Note createNote(Note note) {
        note.setCreatedAt(LocalDateTime.now());
        return noteRepository.save(note);
    }

    @Override
    public Note getNoteById(Long id) {
        return noteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Note not found"));
    }

    @Override
    public Iterable<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    @Override
    public Note updateNote(Long id, Note updatedNote) {

        Optional<Note> noteOptional = noteRepository.findById(id);
        if (noteOptional.isPresent()) {
            Note note = noteOptional.get();
            note.setTitle(updatedNote.getTitle());
            note.setContent(updatedNote.getContent());
            return noteRepository.save(note);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Note not found");
        }
    }

    @Override
    public Note patchNote(Long id, NoteDto noteDto) {
        Optional<Note> noteOptional = noteRepository.findById(id);
        if (noteOptional.isPresent()) {
            Note note = noteOptional.get();
            if (noteDto.getTitle() != null) {
                note.setTitle(noteDto.getTitle());
            }
            if (noteDto.getContent() != null) {
                note.setContent(noteDto.getContent());
            }
            noteRepository.save(note);
            return note;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Note not found");
    }

    @Override
    public Map<String, String> deleteNoteById(Long id) {
        Optional<Note> noteOptional = noteRepository.findById(id);
        if (noteOptional.isPresent()) {
            noteRepository.deleteById(id);
            return Map.of("message", "Note deleted successfully");
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Note not found");
        }
    }
}