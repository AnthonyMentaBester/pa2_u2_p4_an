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
}
