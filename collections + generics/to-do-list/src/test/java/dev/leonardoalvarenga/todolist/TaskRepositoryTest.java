package dev.leonardoalvarenga.todolist;

import dev.leonardoalvarenga.todolist.repositories.TaskRepository;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TaskRepositoryTest {
    @Test
    public void deveAdicionarERecuperarTarefaPorCategoria(){
        TaskRepository board = new TaskRepository();
        Task t1 = new Task("Estudar Java", "Estudos", 1);

        board.addTask(t1);

        List<Task> tarefasEstudo = board.getTasksByCategory("Estudos");

        assertNotNull(tarefasEstudo);
        assertEquals(1, tarefasEstudo.size());
        assertEquals("Estudar Java", tarefasEstudo.get(0).getTitle());
    }

    @Test
    public void deveAgruparMultiplasTarefasNaMesmaCategoria(){
        TaskRepository board = new TaskRepository();

        board.addTask(new Task("Lavar a louça", "Casa", 3));
        board.addTask(new Task("Varrer sala", "Casa", 4));
        board.addTask(new Task("Reunião", "Trabalho", 1));

        List<Task> tarefasCasa = board.getTasksByCategory("Casa");

        assertEquals(2, tarefasCasa.size());
        assertTrue(tarefasCasa.stream().allMatch(task -> task.getCategory().equals("Casa")));
    }

    @Test
    public void deveRetornarListaVaziaParaCategoriaInexistente(){
        TaskRepository board = new TaskRepository();

        List<Task> tarefasLazer = board.getTasksByCategory("Lazer");

        assertNotNull(tarefasLazer);
        assertTrue(tarefasLazer.isEmpty());
    }

    @Test
    public void deveRetornarTarefasOrdenadasPorPrioridade(){
        TaskRepository board = new TaskRepository();

        board.addTask(new Task("Lavar a louça", "Casa", 4));
        board.addTask(new Task("Limpar fogão", "Casa", 1));
        board.addTask(new Task("Varrer sala", "Casa", 3));

        List<Task> ordenadas = board.getTasksByCategorySorted("Casa");

        assertEquals("Limpar fogão", ordenadas.get(0).getTitle());
        assertEquals("Lavar a louça", ordenadas.get(2).getTitle());
    }
}
