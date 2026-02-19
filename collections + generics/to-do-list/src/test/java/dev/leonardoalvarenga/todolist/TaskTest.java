package dev.leonardoalvarenga.todolist;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TaskTest {
    @Test
    public void deveRetornarNegativo(){
        Task tarefaUrgente = new Task("Pagar Boleto", "Contas", 1);
        Task tarefaBaixa = new Task("Comprar pão", "Compras", 5);

        int p = tarefaUrgente.compareTo(tarefaBaixa);

        assertEquals(-1, p);
    }
}
