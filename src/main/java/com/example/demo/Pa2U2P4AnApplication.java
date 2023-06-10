package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.EstudianteService;

@SpringBootApplication
public class Pa2U2P4AnApplication implements CommandLineRunner {
	
	@Autowired
	private EstudianteService estudianteService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P4AnApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	Estudiante estu1 = new Estudiante();
	estu1.setApellido("narvaez");
	estu1.setNombre("anthony");
	estu1.setCedula("1719954370");
	//this.estudianteService.agregar(estu1);
	System.out.println(estu1);
	

	
	estu1.setNombre("josue");
	
	this.estudianteService.actualizar(estu1);
	System.out.println(estu1);
	
	this.estudianteService.seleccionar("1719954370");
	
	this.estudianteService.borrar("1751457167");
	

	}

}
