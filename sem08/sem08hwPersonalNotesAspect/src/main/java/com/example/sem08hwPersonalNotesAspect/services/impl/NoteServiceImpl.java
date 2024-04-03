package com.example.sem08hwPersonalNotesAspect.services.impl;

import com.example.sem08hwPersonalNotesAspect.annotations.TrackUserAction;
import com.example.sem08hwPersonalNotesAspect.domain.Note;
import com.example.sem08hwPersonalNotesAspect.domain.User;
import com.example.sem08hwPersonalNotesAspect.repository.iNoteRepository;
import com.example.sem08hwPersonalNotesAspect.repository.iUserRepository;
import com.example.sem08hwPersonalNotesAspect.services.iNoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * /**
 * Класс содержит бизнес-логику сервиса заметок.
 * Имплементирует интерфейс iUserService
 */

@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements iNoteService {

    /**
     * Внедрение в классы пользователя UserServiceImpl
     * и заметоки NoteServiceImpl соответственно
     * зависимостей от интерфейсов iUserService, iNoteService.
     */
    private final iNoteRepository noteRepository;
    private final iUserRepository userRepository;

    /**
     * Создание новой заметки.
     * @param note - экземпляр заметки класса Note.
     * @return запись в репозиторий.
     */

    @TrackUserAction
    @Override
    public Note createNote(Note note) {
        return noteRepository.save(note);
    }

    /**
     * Список всех заметок.
     * @return список заметок.
     */
    @TrackUserAction
    @Override
    public List<Note> getALlNotes() {
        return noteRepository.findAll();
    }

    /**
     * Получение заметки по id.
     * @param id - id искомой заметки.
     * @return в случае успеха - найденную заметку.
     * , в противном случае - null
     */
    @Override
    public Note getNoteById(Long id) {
        return noteRepository.findById(id)
                .orElseThrow(null);
    }

    /**
     * Изменение существующей заметки.
     * @param note - измененная заметка.
     * @return - измененная заметка.
     */
    @Override
    public Note updateNote(Note note){
        Note noteById = getNoteById(note.getNoteID());
        noteById.setNoteName(note.getNoteName());
        noteById.setNoteBody(note.getNoteBody());
        noteById.setNoteCreateTime(note.getNoteCreateTime());
        return noteRepository.save(noteById);
    }

    /**
     * Удаление заметки.
     * @param id -id заметки для удаления.
     */
    @Override
    public void deleteNote(Long id) {
        Note noteById = getNoteById(id);
        noteRepository.delete(noteById);
    }

    /**
     * Создание привязки заметки к пользователю по id заметки и id пользователя.
     * @param noteId - id искомой заметки.
     * @param userId - id искомого пользователя.
     * @return заметка, связанная с пользователем
     * в классе-обертке ResponseEntity<>.
     */
    public ResponseEntity<Note> assignNoteToUser(Long noteId
            ,Long userId){
        Optional<Note> noteOptional = noteRepository.findById(noteId);
        Optional<User> userOptional = userRepository.findById(userId);

        if(noteOptional.isPresent() && userOptional.isPresent()){
            Note note = noteOptional.get();
            User user = userOptional.get();
            note.setUser(user);
            noteRepository.save(note);
            return ResponseEntity.ok(note);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
