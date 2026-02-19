package dev.leonardoalvarenga.todolist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskBoard {
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
}
