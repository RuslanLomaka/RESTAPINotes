package com.lomaka.notes.controller;

import com.lomaka.notes.entity.Note;
import com.lomaka.notes.dto.NoteDto;
import com.lomaka.notes.service.NoteService;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notes")
@RequiredArgsConstructor
public class NoteController {
    private final NoteService noteService;

    @PostMapping
    public Note createNote(@RequestBody Note note) {
        return noteService.createNote(note);
    }

    @GetMapping("/{id}")
    public Note getNoteById(@PathVariable Long id) {
        return noteService.getNoteById(id);
    }

    @GetMapping
    public Iterable<Note> getAllNotes() {
        return noteService.getAllNotes();
    }
    
    @PutMapping("/{id}")
    public Note updateNote(@PathVariable Long id, @RequestBody Note updatedNote) {
        return noteService.updateNote(id, updatedNote);
    }

    @PatchMapping("/{id}")
    public Note patchNote(@PathVariable Long id, @RequestBody NoteDto noteDto) {
        return noteService.patchNote(id, noteDto);
    }

    @DeleteMapping("/{id}")
    public Map<String,String> deleteNoteById(@PathVariable Long id) {
        return noteService.deleteNoteById(id);
    }

}
