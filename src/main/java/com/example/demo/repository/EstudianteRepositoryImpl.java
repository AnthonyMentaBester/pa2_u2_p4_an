package com.example.demo.repository;


import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
@Repository
//cuando necesitamos acceder ala base de datos necesita esta anotacion
//almenos en la clase repository
@Transactional
public class EstudianteRepositoryImpl implements EstudianteRepository {
	
	
	@PersistenceContext
	//necesito el entity manager medienta la anotacion de arriba
	//componete que me permite la interaccion 
	private EntityManager entitymanager;
	
	@Override
	public void insertar(Estudiante estudiante) {
		this.entitymanager.persist(estudiante);
		
	}
	@Override
	public void actualizar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.entitymanager.merge(estudiante);
		
	}
	@Override
	public Estudiante seleccionar(String cedula) {
		// TODO Auto-generated method stub
		//primero recibe la clase estudiante es decir trabajare con un objeto y luego la primary key
		
		return this.entitymanager.find(Estudiante.class, cedula);
	}
	@Override
	public void eliminar(String cedula) {
		// TODO Auto-generated method stub+
		//instancio para saber que debo eliminar 
		Estudiante estu = this.seleccionar(cedula);
		this.entitymanager.remove(estu);
		
	}

}
