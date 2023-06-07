package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Estudiante;
@Repository
public class EstudianteRepositoryImpl implements EstudianteRepository {
	
	List<Estudiante> bd = new ArrayList<>();
	@Override
	public void insertar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.bd.add(estudiante);
		
	}

}
