package dev.leonardoalvarenga.todolist;

public class Task {
    private String title;
    private String category;
    private int priority;

    public Task(String title, String category, int priority){
        this.title = title;
        this.category = category;
        this.priority = priority;
    }

    public String getTitle(){
        return title;
    }

    public String getCategory(){
        return category;
    }

    public int getPriority(){
        return priority;
    }

    @Override
    public String toString() {
        return String.format("[%d] %s (%s)", priority, title, category);
    }
}
