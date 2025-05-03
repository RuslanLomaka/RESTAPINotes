package com.lomaka.notes.repository;

import com.lomaka.notes.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
}
