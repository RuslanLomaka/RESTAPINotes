package com.lomaka.notes.service;

import com.lomaka.notes.dto.NoteDtoRequest;
import com.lomaka.notes.dto.NoteDtoRespond;
import com.lomaka.notes.entity.Note;
import com.lomaka.notes.repository.NoteRepository;
import com.lomaka.notes.utils.NoteDtoMapper;
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
    public NoteDtoRespond createNote(NoteDtoRequest noteDtoRequest) {
        Note note = noteDtoMapper.toEntity(noteDtoRequest);
        note.setCreatedAt(LocalDateTime.now());
        noteRepository.save(note);
        return noteDtoMapper.toRespondDto(note);
    }

    @Override
    public NoteDtoRespond getNoteById(Long id) {
        return noteDtoMapper.toRespondDto(
                noteRepository.findById(id)
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, NOTE_NOT_FOUND))
        );
    }

    @Override
    public List<NoteDtoRespond> getAllNotes() {
        return noteRepository.findAll().stream()
                .map(noteDtoMapper::toRespondDto)
                .toList();
    }

    @Override
    public NoteDtoRespond updateNote(Long id, NoteDtoRequest updatedNote) {
        return noteRepository.findById(id)
                .map(note -> {
                    note.setTitle(updatedNote.getTitle());
                    note.setContent(updatedNote.getContent());
                    return noteDtoMapper.toRespondDto(noteRepository.save(note));
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, NOTE_NOT_FOUND));
    }

    @Override
    public NoteDtoRespond patchNote(Long id, NoteDtoRequest noteDto) {
        return noteRepository.findById(id)
                .map(note -> {
                    if (noteDto.getTitle() != null) note.setTitle(noteDto.getTitle());
                    if (noteDto.getContent() != null) note.setContent(noteDto.getContent());
                    return noteDtoMapper.toRespondDto(noteRepository.save(note));
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