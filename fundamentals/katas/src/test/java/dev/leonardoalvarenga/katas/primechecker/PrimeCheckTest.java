package dev.leonardoalvarenga.katas.primechecker;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PrimeCheckTest {

    @Test
    void deveRetornarFalse(){
        int entrada = -2;

        boolean resultado = PrimeCheck.isPrime(entrada);

        assertFalse(resultado);
    }

    @Test
    void deveRetornarTrue(){
        int entrada = 7;

        boolean resultado = PrimeCheck.isPrime(entrada);

        assertTrue(resultado);
    }

    @Test
    void deveRetornarFalseParaNumeroComposto(){
        assertFalse(PrimeCheck.isPrime(4));
    }
}
