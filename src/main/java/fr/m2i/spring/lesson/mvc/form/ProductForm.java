package fr.m2i.spring.lesson.mvc.form;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Data
@ToString
@Valid
public class ProductForm {

    private Long id;

    @NotEmpty(message = "Vous devez entrer une valeur")
    private String name;

    @Min(1)
    @NotNull(message = "Vous devez entrer une valeur")
    private Double price;

    @Min(1)
    @NotNull(message = "Vous devez entrer une valeur")
    private int quantity;
}
