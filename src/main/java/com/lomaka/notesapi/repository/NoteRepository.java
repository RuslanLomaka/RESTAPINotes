package com.lomaka.notesapi.repository;

import com.lomaka.notesapi.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
}
