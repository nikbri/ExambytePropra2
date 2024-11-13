package exambyte;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record User(
        @NotBlank(message = "Name darf nicht leer sein") String benutzername,
        @Email(message = "Bitte gültige Email angeben") Email email
) {
}
