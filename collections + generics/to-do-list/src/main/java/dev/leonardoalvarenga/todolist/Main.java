package dev.leonardoalvarenga.todolist;

import dev.leonardoalvarenga.todolist.repositories.TaskRepository;
import dev.leonardoalvarenga.todolist.services.TaskService;

public class Main {
    public static void main(String[] args) {
        TaskRepository repository = new TaskRepository();

        repository.addTask(new Task("Lavar a louça", "Casa", 4));
        repository.addTask(new Task("Varrer sala", "Casa", 3));
        repository.addTask(new Task("Entregar relatórios", "Trabalho", 1));

        TaskService service = new TaskService(repository);

        System.out.println("TESTANDO REMOÇÃO c/ SUCESSO");
        service.removeTaskSafe("Casa", "Lavar a louça");

        System.out.println("TESTANDO REMOÇÃO c/ ERRO");
        service.removeTaskSafe("Casa", "Lavar o teto");

        service.removeTaskSafe("Lazer", "Jogar videogame");
    }
}