package fr.m2i.spring.lesson.mvc.form;

import fr.m2i.spring.lesson.mvc.model.Role;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Data
@ToString
@Valid
public class UserForm {

    private Long id;

    @NotEmpty(message = "Vous devez entrer une valeur")
    private String firstName;

    @NotEmpty(message = "Vous devez entrer une valeur")
    private String lastName;

    @NotEmpty(message = "Vous devez entrer une valeur")
    private String email;

    @NotEmpty(message = "Vous devez entrer une valeur")
    private String password;

    @NotNull(message = "Vous devez entrer une valeur")
    private Double balance;

    @NotNull(message = "Vous devez entrer une valeur")
    private Role role;
}
