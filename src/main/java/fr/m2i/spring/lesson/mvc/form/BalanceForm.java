package fr.m2i.spring.lesson.mvc.form;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Valid
public class BalanceForm {

    @Min(value = 1, message = "Vous devez entrer une valeur positive")
    @NotNull(message = "Vous devez entrer une valeur")
    private Double balance;

    public BalanceForm() {
        
    }
    
    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
