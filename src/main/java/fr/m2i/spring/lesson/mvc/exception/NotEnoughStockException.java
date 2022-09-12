package fr.m2i.spring.lesson.mvc.exception;

public class NotEnoughStockException extends Exception {

    public NotEnoughStockException() {
        super("La produit n'est plus en stock");
    }
}
