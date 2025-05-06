package com.lomaka.notes.controller;

import com.lomaka.notes.dto.NoteDtoRequest;
import com.lomaka.notes.dto.NoteDtoRespond;
import com.lomaka.notes.service.NoteService;
import java.util.List;
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
    public NoteDtoRespond createNote(@RequestBody NoteDtoRequest noteDto) {
        return noteService.createNote(noteDto);
    }

    @GetMapping("/{id}")
    public NoteDtoRespond getNoteById(@PathVariable Long id) {
        return noteService.getNoteById(id);
    }

    @GetMapping
    public List<NoteDtoRespond> getAllNotes() {
        return noteService.getAllNotes();
    }
    
    @PutMapping("/{id}")
    public NoteDtoRespond updateNote(@PathVariable Long id, @RequestBody NoteDtoRequest updatedNote) {
        return noteService.updateNote(id, updatedNote);
    }

    @PatchMapping("/{id}")
    public NoteDtoRespond patchNote(@PathVariable Long id, @RequestBody NoteDtoRequest noteDto) {
        return noteService.patchNote(id, noteDto);
    }

    @DeleteMapping("/{id}")
    public Map<String,String> deleteNoteById(@PathVariable Long id) {
        return noteService.deleteNoteById(id);
    }

    @GetMapping("/test")
    public String test() {
        return "You're talking to a Raspberry Pi somewhere in Northern Germany 😎";
    }

}
