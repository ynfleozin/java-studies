package dev.leonardoalvarenga.katas.fizzbuzz;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {

    @Test
    void deveRetornarFizzQuandoDivisivelPor3() {
        // Cenário (Given)
        int entrada = 3;

        // Ação (When)
        String resultado = FizzBuzz.calcular(entrada);

        // Verificação (Then)
        assertEquals("Fizz", resultado);
    }

    @Test
    void deveRetornarBuzzQuandoDivisivelPor5(){
        int entrada = 5;

        String resultado = FizzBuzz.calcular(entrada);

        assertEquals("Buzz", resultado);
    }

    @Test
    void deveRetornarFizzBuzzQuandoDivisivelPorAmbos(){
        int entrada = 15;

        String resultado = FizzBuzz.calcular(entrada);

        assertEquals("FizzBuzz", resultado);
    }

    @Test
    void deveRetornarNumeroQuandoNormal(){
        int entrada = 2;

        String resultado = FizzBuzz.calcular(entrada);

        assertEquals("2", resultado);
    }
}