package me.icaro.Ac1.repository;

import me.icaro.Ac1.modelo.Task;

import java.util.List;

public interface TaskRepository {
    List<Task> findAll();
    Task findById(Long id);
    Task save(Task task);
}
