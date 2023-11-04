package com.example.demo.Cliente.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteInput {
    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 3, message = "El nombre debe tener mas de 3 caracteres")
    private String nombre;
    @NotBlank(message = "El apellido es obligatorio")
    @Size(min = 3, message = "El apellido debe tener mas de 3 caracteres")
    private String apellido;
    @NotBlank(message = "El email es obligatorio")
    @Email(message = "Email no válido")
    private String email;
    @Pattern(regexp = "^9\\d{8}$", message = "El telefono debe tener 9 digitos y empezar por 9")
    private String telefono;
}
