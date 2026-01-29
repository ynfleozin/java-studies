package dev.leonardoalvarenga.katas.palindrome;

public class PalindromeCheck {
    public static boolean isPalindrome(String palavra){
        if( palavra == null ){
            return false;
        }

        palavra = palavra.toLowerCase();

        int inicio = 0;
        int fim = palavra.length() - 1;

        while( inicio < fim ){
            if( palavra.charAt( inicio ) != palavra.charAt( fim )){
                return false;
            }else{
                inicio++;
                fim--;
            }
        }

        return true;
    }
}
