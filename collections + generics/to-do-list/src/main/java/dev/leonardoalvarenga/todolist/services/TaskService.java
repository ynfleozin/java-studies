package dev.leonardoalvarenga.todolist.services;

import dev.leonardoalvarenga.todolist.exceptions.TaskNotFoundException;
import dev.leonardoalvarenga.todolist.repositories.TaskRepository;

public class TaskService {
    private TaskRepository repository;

    public TaskService(TaskRepository repository){
        this.repository = repository;
    }

    public void removeTaskSafe(String category, String title){
        try {
            repository.removeTaskByTitle(category, title);
            System.out.println("SUCESSO: Tarefa '" + title + "' removida!");
        } catch(TaskNotFoundException e){
            System.out.println("ERRO DE NEGÓCIO: " + e.getMessage());
        } catch (Exception e){
            System.out.println("ERRO CRÍTICO: " + e.getMessage());
        }
    }
}
