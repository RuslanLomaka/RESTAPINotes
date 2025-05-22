package com.lomaka.notesapi.service.implementation;

import com.lomaka.notesapi.dto.NoteDtoRequest;
import com.lomaka.notesapi.model.Note;
import com.lomaka.notesapi.repository.NoteRepository;
import com.lomaka.notesapi.service.NoteService;
import com.lomaka.notesapi.maper.NoteDtoMapper;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@RequiredArgsConstructor
@Service
public class NoteServiceImpl implements NoteService {
    private static final String NOTE_NOT_FOUND = "Note not found";
    private final NoteRepository noteRepository;
    private final NoteDtoMapper noteDtoMapper;

    @Override
    public Note createNote(NoteDtoRequest noteDtoRequest) {
        Note note = noteDtoMapper.toEntity(noteDtoRequest);
        note.setCreatedAt(LocalDateTime.now());
        noteRepository.save(note);
        return note;
    }

    @Override
    public Note getNoteById(Long id) {
        return noteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, NOTE_NOT_FOUND));
    }

    @Override
    public List<Note> getAllNotes() {
        return noteRepository.findAll().stream()
                             .toList();
    }

    @Override
    public Note updateNote(Long id, NoteDtoRequest updatedNote) {
        return noteRepository.findById(id)
                .map(note -> {
                    note.setTitle(updatedNote.getTitle());
                    note.setContent(updatedNote.getContent());
                    return noteRepository.save(note);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, NOTE_NOT_FOUND));
    }

    @Override
    public Note patchNote(Long id, NoteDtoRequest noteDto) {
        return noteRepository.findById(id)
                .map(note -> {
                    if (noteDto.getTitle() != null) note.setTitle(noteDto.getTitle());
                    if (noteDto.getContent() != null) note.setContent(noteDto.getContent());
                    return noteRepository.save(note);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, NOTE_NOT_FOUND));
    }

    @Override
    public Map<String, String> deleteNoteById(Long id) {
        return noteRepository.findById(id)
                .map(note -> {
                    noteRepository.deleteById(id);
                    return Map.of("message", "Note deleted successfully");
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, NOTE_NOT_FOUND));
    }
}