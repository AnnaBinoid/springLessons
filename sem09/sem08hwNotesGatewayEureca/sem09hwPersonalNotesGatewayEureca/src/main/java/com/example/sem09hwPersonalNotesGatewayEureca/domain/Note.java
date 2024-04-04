package com.example.sem09hwPersonalNotesGatewayEureca.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Класс заметки. Отношения многие к одному.
 * Поля класса : id, заголовок заметки,
 * тело заметки (задача), дата создания.
 */
@Data
@Entity
//@NoArgsConstructor
@Table(name = "notes")
public class Note {

    /**
     * ID заметки генерируется автоматически.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long noteID;

    /**
     * Заголовок (наименование) заметки,
     * задается пользователем.
     */
    private String noteName;

    /**
     * Тело заметки задается пользователем.
     */
    private String noteBody;

    /**
     * Время созданя заметки, задается автоматически.
     */
    private LocalDateTime noteCreateTime;

    /**
     * Задается тип отношений многие к одному
     * между пользователем и заметками.
     * Передается объект класса пользователя для
     * реализации джойна двух таблиц: пользователи и заметки.
     */
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Note(String NoteName, String NoteBody) {
        this.noteName = NoteName;
        this.noteBody = NoteBody;
        noteCreateTime = LocalDateTime.now();
    }

}
