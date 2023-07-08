package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.EstudianteRepository;
import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.repository.modelo.dto.EstudianteDTO;
@Service
public class EstudianteServiceImpl implements EstudianteService {
	
	@Autowired
	private EstudianteRepository estudianteRepository;

	@Override
	public void agregar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.estudianteRepository.insertar(estudiante);
		
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.estudianteRepository.actualizar(estudiante);
		
		
	}

	@Override
	public Estudiante seleccionar(String cedula) {
		// TODO Auto-generated method stub
		return this.estudianteRepository.seleccionar(cedula);
	}

	@Override
	public void borrar(String cedula) {
		// TODO Auto-generated method stub
		this.estudianteRepository.eliminar(cedula);
		
	}

	@Override
	public Estudiante buscarPorApellido(String apellido) {
		// TODO Auto-generated method stub
		return this.estudianteRepository.seleccionarPorApellido(apellido);
	}

	@Override
	public List<Estudiante> buscarPorListaApellido(String apellido) {
		// TODO Auto-generated method stub
		return this.estudianteRepository.seleccionarListaPorApellido(apellido);
	}

	@Override
	public Estudiante buscarPorApellidoNombre(String apellido, String nombre) {
		// TODO Auto-generated method stub
		return this.estudianteRepository.seleccionarPorApellidoNombre(apellido, nombre);
	}

	@Override
	public Estudiante buscarPorApellidoTyped(String apellido) {
		// TODO Auto-generated method stub
		return this.estudianteRepository.seleccionarPorApellidoTyped(apellido);
	}

	@Override
	public Estudiante buscarPorApellidoNamed(String apellido) {
		// TODO Auto-generated method stub
		return this.estudianteRepository.seleccionarPorApellidoNamed(apellido);
	}

	@Override
	public Estudiante buscarPorApellidoNamedQuery(String apellido) {
		// TODO Auto-generated method stub
		return this.estudianteRepository.seleccionarPorApellidoNamedQuery(apellido);
	}

	@Override
	public Estudiante buscarPorApellidoNativeQuery(String apellido) {
		// TODO Auto-generated method stub
		return this.estudianteRepository.seleccionarPorApellidoNativeQuery(apellido);
	}

	@Override
	public Estudiante buscarPorApellidoNativeQueryNamed(String apellido) {
		// TODO Auto-generated method stub
		return this.estudianteRepository.seleccionarPorApellidoNativeQueryNamed(apellido);
	}
	
	@Override
	public Estudiante buscarPorNombreNativeQuery(String nombre) {
		// TODO Auto-generated method stub
		return this.estudianteRepository.seleccionarPorNombreNativeQuery(nombre);
	}

	@Override
	public Estudiante buscarPorNombreNativeQueryNamed(String nombre) {
		// TODO Auto-generated method stub
		return this.estudianteRepository.seleccionarPorNombreNativeQueryNamed(nombre);
	}

	@Override
	public Estudiante seleccionarPorApellidoCriteriaQuery(String apellido) {
		// TODO Auto-generated method stub
		return this.estudianteRepository.seleccionarPorApellidoCriteriaQuery(apellido);
	}

	@Override
	public Estudiante buscarEstudianteDinamicoCriteriaQuery(String nombre, String apellido, Double peso) {
		// TODO Auto-generated method stub
		return this.estudianteRepository.seleccionarEstudianteDinamicoCriteriaQuery(nombre, apellido, peso);
	}

	@Override
	public int borrarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return this.estudianteRepository.eliminarPorNombre(nombre);
	}

	@Override
	public int actualizarPorApellido(String nombre, String Apellido) {
		// TODO Auto-generated method stub
		return this.estudianteRepository.actualizarPorApellido(nombre, Apellido);
	}

	@Override
	public List<EstudianteDTO> buscarTodosDTO() {
		// TODO Auto-generated method stub
		return this.estudianteRepository.seleccionarTodosDTO();
	}

}
