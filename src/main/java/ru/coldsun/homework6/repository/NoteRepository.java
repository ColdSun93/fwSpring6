package ru.coldsun.homework6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.coldsun.homework6.model.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
}
