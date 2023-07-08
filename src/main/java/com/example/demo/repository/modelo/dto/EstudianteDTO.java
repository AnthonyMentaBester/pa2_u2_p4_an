package com.example.demo.repository.modelo.dto;

import jakarta.persistence.Column;

public class EstudianteDTO {
	
	//CREAR un objeto dto especificamente con los atributos necesito consultar 
	
	private String nombre;
	
	private String apellido;
	
	//puedes poinerlo directo 
	public EstudianteDTO() {
		// TODO Auto-generated constructor stub
	}

	//debe haber un costructor 
	//no hace falta el constructor por defecto si solo esta por el de defecto
	//en cambio si pongo el explicito el de aca abajo 
	//la buena practica es declarar el constructor por defecto
	
	public EstudianteDTO(String nombre, String apellido) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
	}

	//set y get
	public String getNombre() {
		return nombre;
	}

	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	@Override
	public String toString() {
		return "EstudianteDTO [nombre=" + nombre + ", apellido=" + apellido + "]";
	}
	
	

}
