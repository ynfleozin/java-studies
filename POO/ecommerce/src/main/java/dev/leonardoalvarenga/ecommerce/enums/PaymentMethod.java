package dev.leonardoalvarenga.ecommerce.enums;

public enum PaymentMethod {
    CREDIT_CARD,
    BOLETO,
    PIX;

    public double calculateFinalPrice(double total){
        if(this == PIX){
            return total * 0.9;
        }
        return total;
    }
}
