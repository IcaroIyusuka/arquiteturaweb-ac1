package me.icaro.Ac1.repository;

import me.icaro.Ac1.modelo.Task;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

/*
Esta anotação é usada para indicar que a classe é um componente de acesso a dados (repositório).
Ela informa ao Spring que a classe anotada como @Repository é responsável por interagir com a fonte de dados, como um
banco de dados, fornecendo operações CRUD (create, read, update, delete) para uma entidade específica.
 */
@Repository
public class TaskRepositoryImpl implements TaskRepository {
    private final List<Task> tasks = new ArrayList<>();
    private Long nextId = 1L;

    public TaskRepositoryImpl() {
        // Adiciona algumas tarefas pré-cadastradas
        tasks.add(new Task(1L, "teste", "88899955520","teste@teste","vasco","785412"));
        nextId = 4L; // Atualiza o próximo ID
    }

    @Override
    public List<Task> findAll() {
        return tasks;
    }

    @Override
    public Task findById(Long id) {
        return tasks.stream()
                .filter(task -> task.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Task save(Task task) {
        if (task.getId() == null) {
            task.setId(nextId++);
            tasks.add(task);
        } else {
            tasks.removeIf(t -> t.getId().equals(task.getId()));
            tasks.add(task);
        }
        return task;
    }
}
