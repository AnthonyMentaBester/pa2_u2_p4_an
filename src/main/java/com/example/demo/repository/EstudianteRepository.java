package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Estudiante;

public interface EstudianteRepository {
	public void insertar(Estudiante estudiante);
	public void actualizar(Estudiante estudiante);
	public Estudiante seleccionar(String cedula);
	public void eliminar(String cedula);
	
	//query
	public Estudiante seleccionarPorApellido(String apellido);
	public List<Estudiante> seleccionarListaPorApellido(String apellido);
	public Estudiante seleccionarPorApellidoNombre(String apellido,String nombre);
	
	//typed
	
	public Estudiante seleccionarPorApellidoTyped(String apellido);
	
	//named
	public Estudiante seleccionarPorApellidoNamed(String apellido);
	public Estudiante seleccionarPorApellidoNamedQuery(String apellido);
	
	//sql puro natiuve
	public Estudiante seleccionarPorApellidoNativeQuery(String apellido);
	public Estudiante seleccionarPorApellidoNativeQueryNamed(String apellido);

	public Estudiante seleccionarPorNombreNativeQuery(String nombre);
	public Estudiante seleccionarPorNombreNativeQueryNamed(String nombre);

	//Criteria 
	public Estudiante seleccionarPorApellidoCriteriaQuery(String apellido);
	
}
