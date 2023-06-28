package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Estudiante;

public interface EstudianteService {
	public void agregar(Estudiante estudiante);
	public void actualizar(Estudiante estudiante);
	public Estudiante seleccionar(String cedula);
	public void borrar(String cedula);
	
	//query
	public Estudiante buscarPorApellido(String apellido);
	public Estudiante buscarPorApellidoNombre(String apellido,String nombre);
	public List<Estudiante> buscarPorListaApellido(String apellido);

	//typed
	public Estudiante buscarPorApellidoTyped(String apellido);
	
	//named
	public Estudiante buscarPorApellidoNamed(String apellido);
	public Estudiante buscarPorApellidoNamedQuery(String apellido);
	
	//sql puro native 
	public Estudiante buscarPorApellidoNativeQuery(String apellido);
	public Estudiante buscarPorApellidoNativeQueryNamed(String apellido);
	
	public Estudiante buscarPorNombreNativeQuery(String nombre);
	public Estudiante buscarPorNombreNativeQueryNamed(String nombre);
}
