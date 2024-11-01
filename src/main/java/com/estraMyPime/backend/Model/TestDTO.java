package com.estraMyPime.backend.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestDTO {
    private Long id;
    private String pregunta1;
    private String pregunta2;
    private String pregunta3;
    private String pregunta4;
    private String pregunta5;
    private String pregunta6;
    private String pregunta7;
    private String pregunta8;
    private String pregunta9;
    private UserDTO user; // Incluir un DTO para el usuario
}
