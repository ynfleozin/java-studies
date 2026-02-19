package dev.leonardoalvarenga.todolist;

import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<Task> taskQueue = new PriorityQueue<>();

        taskQueue.add(new Task("Lavar louça", "Casa", 4));
        taskQueue.add(new Task("Entregar relatórios", "Trabalho", 1));
        taskQueue.add(new Task("Comprar pão", "Compras", 5));
        taskQueue.add(new Task("Reunião", "Trabalho", 2));

        System.out.println("Executando tarefas...");

        while(!taskQueue.isEmpty()){
            Task task = taskQueue.poll();
            System.out.println("Fazendo agora: " + task);
        }
    }
}