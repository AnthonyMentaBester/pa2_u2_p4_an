package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.CtaBancaria;
import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.CtaBancariaService;
import com.example.demo.service.EstudianteService;

@SpringBootApplication
public class Pa2U2P4AnApplication implements CommandLineRunner {
	
	@Autowired
	private EstudianteService estudianteService;
	
	@Autowired
	private CtaBancariaService bancariaService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P4AnApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		this.bancariaService.aperturar("1719954370", "A", new BigDecimal(100));
		CtaBancaria  cta = new CtaBancaria();
		cta.setFechaApertura(LocalDate.now());
		this.bancariaService.actualizar(cta, "1");
	
	
	

	}

}
