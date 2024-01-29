package ru.coldsun.homework6.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.coldsun.homework6.model.Note;
import ru.coldsun.homework6.repository.NoteRepository;

import java.time.LocalDateTime;
import java.util.List;
//import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notes")
public class NoteController {
    private final NoteRepository noteRepository;

    /**
     * Добавление заметки.
     */
    @PostMapping
    public Note addNote(@RequestBody Note note){
        note.setCreationDate(LocalDateTime.now());
        //if (note.getStatus()==null) note.setStatus(TaskStatus.NOT_STARTED);
        return noteRepository.save(note);
    }

    /**
     * Редактирование заметки.
     */
    @PutMapping("/{id}")
    public Note updateTaskStatus(@PathVariable Long id, @RequestBody Note note){
        Note changeNote = noteRepository.findById(id).orElse(null);
        if (changeNote != null) {
            return noteRepository.save(changeNote);
        } else {
            return null;
        }
    }

    /**
     * Просмотр всех заметок
     */
    @GetMapping
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    /**
     * Получение заметки по id
     */
    @GetMapping("/{id}")
    public Note getById(@PathVariable("id") Long id) {
        return noteRepository.findById(id).orElseThrow();
    }
    /**
     * Удаление заметки
     */
    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable Long id){
        noteRepository.deleteById(id);
    }


}
