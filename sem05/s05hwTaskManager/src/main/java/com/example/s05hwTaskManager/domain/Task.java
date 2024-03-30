package com.example.s05hwTaskManager.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "task_name",nullable = false)
    private String taskName;

    @Column(name = "task_status")
    private TaskStatus status = TaskStatus.BEFORE_START;

    @Column(name = "task_create_date")
    private LocalDate createDate;


}
