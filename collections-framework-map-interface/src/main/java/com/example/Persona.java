package com.example;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
public class Persona {
	private String nombre;
	private String primerApellido;
	private String segundoApellido;
	private LocalDate fechaNacimiento;
	private Genero genero;

}
