package me.icaro.Ac1.service;

import me.icaro.Ac1.modelo.Task;
import java.util.List;

public interface TaskService {
    List<Task> getAllTasks();
    Task getTaskById(Long id);
    Task createTask(Task task);
}