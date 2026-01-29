package dev.leonardoalvarenga.katas.palindrome;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PalindromeCheckTest {
    @Test
    void deveRetornarFalse(){
        String entrada = "Escada";

        boolean resultado = PalindromeCheck.isPalindrome( entrada );

        assertFalse( resultado );
    }

    @Test
    void deveRetornarTrue(){
        String entrada = "Arara";

        boolean resultado = PalindromeCheck.isPalindrome( entrada );

        assertTrue( resultado );
    }
}
