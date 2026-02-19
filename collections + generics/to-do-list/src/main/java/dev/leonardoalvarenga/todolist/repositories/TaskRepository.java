package dev.leonardoalvarenga.todolist.repositories;

import dev.leonardoalvarenga.todolist.Task;
import dev.leonardoalvarenga.todolist.exceptions.TaskNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;

public class TaskRepository {
    private Map<String, List<Task>> board = new HashMap<>();

    public void addTask(Task task){
        String category = task.getCategory();

        if(!board.containsKey(category)){
            board.put(category, new ArrayList<>());
        }

        List<Task> categoryList = board.get(category);

        categoryList.add(task);
    }

    public List<Task> getTasksByCategory(String category){
        if(!board.containsKey(category)){
            return new ArrayList<>();
        }

        return board.get(category);
    }

    public List<Task> getTasksByCategorySorted(String category){
        List<Task> tasks = getTasksByCategory(category);

        List<Task> orderedTasks = new ArrayList<>(tasks);
        Collections.sort(orderedTasks);

        return orderedTasks;
    }

    public void removeTaskByTitle(String category, String title){
        List<Task> tasks = board.get(category);

        if (tasks == null || tasks.isEmpty()){
            throw new TaskNotFoundException("A categoria '" + category + "' não existe.");
        }

        boolean removed = tasks.removeIf(t -> t.getTitle().equals(title));

        if(!removed){
            throw new TaskNotFoundException("A tarefa '" + title + "' não foi encontrada.");
        }
    }
}
