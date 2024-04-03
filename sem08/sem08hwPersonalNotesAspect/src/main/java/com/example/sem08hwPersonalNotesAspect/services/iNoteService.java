package com.example.sem08hwPersonalNotesAspect.services;

import com.example.sem08hwPersonalNotesAspect.domain.Note;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * Контракт о том, какие методы будет иметь сервис заметок.
 * Интерфейс - архитектурная граница между сервисом и котроллерами.
 * Благодаря имплементации интерфейса можно будет делать разные
 * реализаци сервисов.
 */
public interface iNoteService {

    Note createNote(Note note);
    List<Note> getALlNotes();
    Note getNoteById(Long id);
    Note updateNote(Note note);
    void deleteNote(Long id);
    ResponseEntity<Note> assignNoteToUser(Long bookId
            , Long userId);
}
