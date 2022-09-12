package fr.m2i.spring.lesson.mvc.exception;

public class BalanceInsufficientException extends Exception {

    public BalanceInsufficientException() {
        super("Vous manquez de crédit pour ce produit");
    }
}
