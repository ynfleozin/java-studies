package dev.leonardoalvarenga.katas;

import dev.leonardoalvarenga.katas.fizzbuzz.FizzBuzz;
import dev.leonardoalvarenga.katas.palindrome.PalindromeCheck;

public class Main {
    public static void main(String[] args) {
        //FizzBuzz
        for(int i = 1; i <= 100; i++){
            String resultado = FizzBuzz.calcular(i);
            System.out.println(resultado);
        }

        //Palindrome CHeck
        System.out.println(PalindromeCheck.isPalindrome("arara"));

    }
}