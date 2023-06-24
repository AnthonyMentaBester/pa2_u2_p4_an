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
}
