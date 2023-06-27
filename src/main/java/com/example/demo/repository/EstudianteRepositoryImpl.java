package com.example.demo.repository;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
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
	@Override
	public Estudiante seleccionarPorApellido(String apellido) {
		// TODO Auto-generated method stub
		//en SQL
		//Select * from e estudiante Where e.estu_apellido = 
		//JPQL
		//se mantienen las palabras reservadas
		//SELECT e FROM Estudiante e WHERE e.apellido = 
		//Query myQuery = this.entitymanager.createQuery("JPQL");
		Query myQuery = this.entitymanager.createQuery("SELECT e FROM Estudiante e WHERE e.apellido = :datoApellido");
		myQuery.setParameter("datoApellido", apellido);
		return (Estudiante) myQuery.getSingleResult();
		// ese estudiante me dice el tipo con el que trabajo
		
	}
	@Override
	public List<Estudiante> seleccionarListaPorApellido(String apellido) {
		// TODO Auto-generated method stub
		Query myQuery = this.entitymanager.createQuery("SELECT e FROM Estudiante e WHERE e.apellido = :datoApellido");
		myQuery.setParameter("datoApellido", apellido);
		return myQuery.getResultList();
		
	}
	@Override
	public Estudiante seleccionarPorApellidoNombre(String apellido, String nombre) {
		// TODO Auto-generated method stub
		Query myQuery = this.entitymanager.createQuery("SELECT e FROM Estudiante e WHERE e.apellido = :datoApellido AND e.nombre = :datoNombre");
		myQuery.setParameter("datoApellido", apellido);
		myQuery.setParameter("datoNombre", nombre);
		return (Estudiante) myQuery.getSingleResult();
	}
	@Override
	public Estudiante seleccionarPorApellidoTyped(String apellido) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myQuery = this.entitymanager.createQuery("SELECT e FROM Estudiante e WHERE e.apellido = :datoApellido", Estudiante.class);
		myQuery.setParameter("datoApellido", apellido);
		return myQuery.getSingleResult();
	}
	@Override
	public Estudiante seleccionarPorApellidoNamed(String apellido) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myQuery = this.entitymanager.createNamedQuery("SELECT e FROM Estudiante e WHERE e.apellido = :datoApellido", Estudiante.class);
		myQuery.setParameter("datoApellido", apellido);
		return myQuery.getSingleResult();
		
	}

}
