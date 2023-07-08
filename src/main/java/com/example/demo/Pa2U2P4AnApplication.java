package com.example.demo;

import java.util.List;

import org.hibernate.engine.jdbc.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.repository.modelo.Habitacion;
import com.example.demo.repository.modelo.Hotel;
import com.example.demo.repository.modelo.dto.EstudianteDTO;
import com.example.demo.repository.modelo.dto.MatriculaDTO;
import com.example.demo.service.EstudianteService;
import com.example.demo.service.HabitacionService;
import com.example.demo.service.HotelService;
import com.example.demo.service.MatriculaService;

@SpringBootApplication
public class Pa2U2P4AnApplication implements CommandLineRunner {

	@Autowired
	private EstudianteService estudianteService;

	@Autowired
	private MatriculaService matriculaService;
	
	@Autowired 
	private HabitacionService habitacionService;
	
	@Autowired
	private HotelService hotelService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P4AnApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Estudiante estu1 = new Estudiante();
		estu1.setApellido("c");
		estu1.setCedula("17199542312");
		estu1.setNombre("d");
		estu1.setPeso(1022.00);
		// this.estudianteService.actualizar(estu1);

		Estudiante estu2 = new Estudiante();
		estu2.setApellido("ferrer");
		estu2.setCedula("17199542312");
		estu2.setNombre("Carlos");

		List<EstudianteDTO> reporte = this.estudianteService.buscarTodosDTO();
		for (EstudianteDTO estudianteDTO : reporte) {
			System.out.println(estudianteDTO);
		}
		
		List<MatriculaDTO> repo = this.matriculaService.reporteTodos();
		for (MatriculaDTO matriculaDTO : repo) {
			System.out.println(matriculaDTO);
		}
		Hotel hot = this.hotelService.buscar(1);
		System.out.println(hot);
		
		Habitacion habi = this.habitacionService.buscar(1);
		
		System.out.println(habi);
	
	}
	
	

}
