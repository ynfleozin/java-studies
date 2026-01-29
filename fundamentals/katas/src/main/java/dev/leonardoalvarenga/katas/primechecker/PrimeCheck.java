package dev.leonardoalvarenga.katas.primechecker;

public class PrimeCheck {
    public static boolean isPrime(int numero){
        if(numero <= 1){
            return false;
        }

        for(int i = 2; i * i <= numero; i++){
            if( numero % i == 0 ){
                return false;
            }
        }

        return true;
    }
}
