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
import com.example.demo.repository.modelo.Autor;
import com.example.demo.repository.modelo.Habitacion;
import com.example.demo.service.AutorService;
import com.example.demo.service.HabitacionService;
import com.example.demo.service.HotelService;
import com.example.demo.service.LibroService;

@SpringBootApplication
public class Pa2U2P4AnApplication implements CommandLineRunner {

	@Autowired
	private AutorService autorService;

	@Autowired
	private LibroService libroService;

	

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P4AnApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Set<Autor> autor = new HashSet<>();
		Set<Libro> libros = new HashSet<>();
		
		Autor aut1 = new Autor();
		aut1.setApellido("nunez");
		aut1.setNombre("anthony");
		
		Autor aut2 = new Autor();
		aut2.setApellido("numiro");
		aut2.setNombre("carlos");
		
		Libro lib1 = new Libro();
		lib1.setEditorial("hilos");
		lib1.setTitulo("las granjas");
		libros.add(lib1);
		lib1.setAutores(autor);
		
		
		Libro lib2 = new Libro();
		lib2.setEditorial("sssew23s");
		lib2.setTitulo("las monas");
		libros.add(lib2);
		lib2.setAutores(autor);
		
		this.autorService.actualizar(aut1);
		this.autorService.agregar(aut2);
		
		
		
		
		
		
		
	

	}

}
