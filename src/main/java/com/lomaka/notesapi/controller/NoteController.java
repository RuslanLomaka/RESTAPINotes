package com.lomaka.notesapi.controller;

import com.lomaka.notesapi.dto.NoteDtoRequest;
import com.lomaka.notesapi.dto.NoteDtoRespond;
import com.lomaka.notesapi.maper.NoteDtoMapper;
import com.lomaka.notesapi.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/notes")
@RequiredArgsConstructor
public class NoteController {
    private final NoteService noteService;
    private final NoteDtoMapper noteDtoMapper;

    @PostMapping
    public NoteDtoRespond createNote(@RequestBody NoteDtoRequest noteDto) {
        return noteDtoMapper.toRespondDto(noteService.createNote(noteDto));
    }

    @GetMapping("/{id}")
    public NoteDtoRespond getNoteById(@PathVariable Long id) {
        return noteDtoMapper.toRespondDto(noteService.getNoteById(id));
    }

    @GetMapping
    public List<NoteDtoRespond> getAllNotes() {
        return noteService.getAllNotes().stream()
                .map(noteDtoMapper::toRespondDto)
                .toList();
    }

    @PutMapping("/{id}")
    public NoteDtoRespond updateNote(@PathVariable Long id, @RequestBody NoteDtoRequest updatedNote) {
        return noteDtoMapper.toRespondDto(noteService.updateNote(id, updatedNote));
    }

    @PatchMapping("/{id}")
    public NoteDtoRespond patchNote(@PathVariable Long id, @RequestBody NoteDtoRequest noteDto) {
        return noteDtoMapper.toRespondDto(noteService.patchNote(id, noteDto));
    }

    @DeleteMapping("/{id}")
    public Map<String, String> deleteNoteById(@PathVariable Long id) {
        return noteService.deleteNoteById(id);
    }

    @GetMapping("/test")
    public String test() {
        return "<!DOCTYPE html>\n" +
                "<html xmlns:th=\"http://www.thymeleaf.org\">\n" +
                "<head>\n" +
                "    <title>Test Page</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1>Test Template</h1>\n" +
                "<p>\"You're talking to a Raspberry Pi somewhere in Northern Germany \uD83D\uDE0E \" +\n" +
                "    \"**⚡ Documentation:** All details, request/response schemas, and try-it-out features are now live in Swagger UI:  \\n\" +\n" +
                "    \"> \\uD83D\\uDD17 https://notes.ruslanlomaka.org/swagger-ui/index.html\";\n" +
                "</p>\n" +
                "</body>\n" +
                "</html>";

    }

}
