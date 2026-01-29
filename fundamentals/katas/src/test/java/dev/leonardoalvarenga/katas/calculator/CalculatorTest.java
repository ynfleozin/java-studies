package dev.leonardoalvarenga.katas.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
    @Test
    void somar(){
        double resultado = Calculator.calculate(2, 10, "+");

        assertEquals(12, resultado);
    }
    
    @Test
    void subtrair(){
        double resultado = Calculator.calculate(10, 5, "-");
        
        assertEquals(5, resultado);
    }

    @Test
    void multiplicar(){
        double resultado = Calculator.calculate(10, 3, "*");

        assertEquals(30, resultado);
    }

    @Test
    void dividir(){
        double resultado = Calculator.calculate(10, 2, "/");

        assertEquals(5, resultado);
    }

    @Test
    void dividirPorZero(){
        double resultado = Calculator.calculate(10, 0, "/");

        assertEquals(0, resultado);
    }

    @Test
    void erroComOperadorInvalido(){
        assertThrows(IllegalArgumentException.class, () -> {
            Calculator.calculate(10, 5, "Banana");
        });
    }
}
