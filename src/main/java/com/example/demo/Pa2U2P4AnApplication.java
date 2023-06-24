package com.example.demo;

import java.util.List;

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
		estu1.setApellido("ferrer");
		estu1.setCedula("17199542312");
		estu1.setNombre("Anthony");
		
		Estudiante estu2 = new Estudiante();
		estu2.setApellido("ferrer");
		estu2.setCedula("17199542312");
		estu2.setNombre("Anthony");
		
	
	Estudiante estu = this.estudianteService.buscarPorApellido("narvaez");
	System.out.println(estu);
	
	Estudiante estu4 = this.estudianteService.buscarPorApellidoNombre("narvaez","josue");
	System.out.println(estu);
	
	List<Estudiante> estu3 = this.estudianteService.buscarPorListaApellido("ferrer");
			
	for (Estudiante estudiante : estu3) {
		System.out.println(estudiante);
	} 
	
	//typed 
	Estudiante estu5 = this.estudianteService.buscarPorApellidoTyped("narvaez");
	System.out.println(estu5);
	

	}

}
