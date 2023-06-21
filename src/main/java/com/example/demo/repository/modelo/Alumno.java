package com.example.demo.repository.modelo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "alumno")
public class Alumno {
	
	@GeneratedValue(generator = "seq_alumno", strategy = GenerationType.SEQUENCE) /// atributo quue permite hacer match
	@SequenceGenerator(name = "seq_alumno", sequenceName = "seq_alumno", allocationSize = 1)

	@Id
	@Column(name = "alu_id")
	
	private Integer id;
	@Column(name = "alu_nombre")
	private String nombre;
	
	@OneToMany(mappedBy = "alumno")
	private List<Matricula> matriculas;

	
	// set y get
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}
	
	

}
