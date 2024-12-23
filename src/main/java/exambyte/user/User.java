package exambyte.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


/* Rekord dient erstmal nur, damit die Controller etc. programmiert werden können
folgende Attribute müssen vermutlich noch hinzugefügt werden: Tests[] Liste mit allen Tests des Users*/
public record User(
        @NotBlank(message = "Name darf nicht leer sein") String benutzername,
        @Email(message = "Gültige Email") String email,
        @NotBlank(message = "Passwort darf nicht leer sein") String passwort,
        String role
) {
}
