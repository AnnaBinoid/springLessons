package com.example.s05hwTaskManager.repository;

import com.example.s05hwTaskManager.domain.Task;
import com.example.s05hwTaskManager.domain.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByStatus(TaskStatus status);
}
