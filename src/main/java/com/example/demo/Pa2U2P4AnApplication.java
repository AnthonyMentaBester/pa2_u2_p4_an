package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Hotel;
import com.example.demo.repository.modelo.Libro;
import com.example.demo.repository.modelo.Materia;
import com.example.demo.repository.modelo.Matricula;
import com.example.demo.repository.modelo.Alumno;
import com.example.demo.repository.modelo.Autor;
import com.example.demo.repository.modelo.Habitacion;
import com.example.demo.service.AutorService;
import com.example.demo.service.HabitacionService;
import com.example.demo.service.HotelService;
import com.example.demo.service.LibroService;
import com.example.demo.service.MatriculaService;

@SpringBootApplication
public class Pa2U2P4AnApplication implements CommandLineRunner {

	@Autowired
	private MatriculaService matriculaService;


	

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P4AnApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		List<Materia> materias = new ArrayList<>();
		List<Alumno> alumnos = new ArrayList<>();
		Materia mat = new Materia();
		mat.setNombre("lenguaje");
		materias.add(mat);
		Alumno alum = new Alumno();
		alum.setNombre("antohny");
		alumnos.add(alum);
		
		
		Matricula matri = new Matricula();
		matri.setFecha(LocalDate.now());
		matri.setAlumno(alum);
		matri.setMateria(mat);
		matri.setNumero("001");
		
		this.matriculaService.agregar(matri);
	

	}

}
