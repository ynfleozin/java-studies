package dev.leonardoalvarenga.todolist;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TaskBoardTest {
    @Test
    public void deveAdicionarERecuperarTarefaPorCategoria(){
        TaskBoard board = new TaskBoard();
        Task t1 = new Task("Estudar Java", "Estudos", 1);

        board.addTask(t1);

        List<Task> tarefasEstudo = board.getTasksByCategory("Estudos");

        assertNotNull(tarefasEstudo);
        assertEquals(1, tarefasEstudo.size());
        assertEquals("Estudar Java", tarefasEstudo.get(0).getTitle());
    }

    @Test
    public void deveAgruparMultiplasTarefasNaMesmaCategoria(){
        TaskBoard board = new TaskBoard();

        board.addTask(new Task("Lavar a louça", "Casa", 3));
        board.addTask(new Task("Varrer sala", "Casa", 4));
        board.addTask(new Task("Reunião", "Trabalho", 1));

        List<Task> tarefasCasa = board.getTasksByCategory("Casa");

        assertEquals(2, tarefasCasa.size());
        assertTrue(tarefasCasa.stream().allMatch(task -> task.getCategory().equals("Casa")));
    }

    @Test
    public void deveRetornarListaVaziaParaCategoriaInexistente(){
        TaskBoard board = new TaskBoard();

        List<Task> tarefasLazer = board.getTasksByCategory("Lazer");

        assertNotNull(tarefasLazer);
        assertTrue(tarefasLazer.isEmpty());
    }

    @Test
    public void deveRetornarTarefasOrdenadasPorPrioridade(){
        TaskBoard board = new TaskBoard();

        board.addTask(new Task("Lavar a louça", "Casa", 4));
        board.addTask(new Task("Limpar fogão", "Casa", 1));
        board.addTask(new Task("Varrer sala", "Casa", 3));

        List<Task> ordenadas = board.getTasksByCategorySorted("Casa");

        assertEquals("Limpar fogão", ordenadas.get(0).getTitle());
        assertEquals("Lavar a louça", ordenadas.get(2).getTitle());
    }
}
