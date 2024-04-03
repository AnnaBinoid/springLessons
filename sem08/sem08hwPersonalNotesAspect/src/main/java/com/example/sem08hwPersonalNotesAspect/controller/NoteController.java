package com.example.sem08hwPersonalNotesAspect.controller;

import com.example.sem08hwPersonalNotesAspect.domain.Note;
import com.example.sem08hwPersonalNotesAspect.services.iNoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Класс контроллеров
 */
@RestController
@RequestMapping("/notes")
@RequiredArgsConstructor
public class NoteController {

    /**
     * Реализация связи репозиториев с контроллерами через интерфейсы.
     * На этапе сборки проекта Spring подтянет нужный класс
     * ,имплементирующий интерфейс.
     */

    private final iNoteService iNoteService;

    /**
     * Добавление заметки.
     * @param note - заметка от пользователя.
     * @return заметка пользователя сохраняется в репозиторий.
     */
    @PostMapping()
    public ResponseEntity<Note> createNote(@RequestBody Note note) {

        return new ResponseEntity<>(iNoteService.createNote(note)
                , HttpStatus.CREATED);
    }


    /**
     * Возвращает список заметок и HTTP-статус.
     * @return список заметок в классе-обертке RespoonseEntity<>
     * , позволяющем гибко настроить обработку ошибок.
     */
    @GetMapping
    public ResponseEntity<List<Note>> getAll(){
        return new ResponseEntity<>(iNoteService.getALlNotes()
                , HttpStatus.OK);
    }

    /**
     * Возвращает заметку по id, переданному в Get-запросе.
     * @param id - id искомой заметки
     * @return В случае успеха возвращает заметку в классе-обертке ResponseEntity<>
     *      , в противном случае выводит заметку с Null-полями.
     */
    @GetMapping("{note_id}")
    public ResponseEntity<Note> getNote(@PathVariable("note_id")Long id){
        Note noteById;
        try {
            noteById = iNoteService.getNoteById(id);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new Note(null, null));
        }
        return new ResponseEntity<>(noteById, HttpStatus.OK);
    }

    /**
     * Метод обновляет заметку на информацию, полученную из тела Put-запроса.
     * @param note - новая заметка.
     * @return возвращает обновленную заметку в классе-обертке ResponseEntity<>
     */
    @PutMapping
    public ResponseEntity<Note> updateNote(@RequestBody Note note){
        return new ResponseEntity<>(iNoteService.updateNote(note)
                , HttpStatus.OK);
    }

    /**
     * Обработчик запросов HTTP метода DELETE на ресурс /{note_id}.
     * @param id - id удаляемой заметки.
     * @return успешный статус ответа (код 200 ОК) без тела ответа.
     */
    @DeleteMapping("/{note_id}")
    public ResponseEntity<Void> deleteNote(@PathVariable("note_id") Long id){
        iNoteService.deleteNote(id);
        return ResponseEntity.ok().build();
    }

    /**
     * Обработчик запросов на присоединение пользователя к заметке.
     * @param note_id - id заметки, которую нужно прикрепить к пользователю
     * @param user_id - id пользователя, к которому будет прикреплена заметка.
     * @return заметку, прикрепленную к пользователю.
     */

    @PutMapping("/{note_id}/users/{user_id}")
    public ResponseEntity<Note> assignNoteToUser(@PathVariable Long note_id
            ,@PathVariable Long user_id) {
        return iNoteService.assignNoteToUser(note_id, user_id);

    }


}
