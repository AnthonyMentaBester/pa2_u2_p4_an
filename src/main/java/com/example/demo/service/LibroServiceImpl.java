package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.repository.LibroRepository;
import com.example.demo.repository.modelo.Libro;

public class LibroServiceImpl implements LibroService{
	@Autowired
    private LibroRepository libroRepository;

    @Override
    public void agregar(Libro libro) {
        // TODO Auto-generated method stub
        this.libroRepository.insertar(libro);
    }

    @Override
    public void actualizar(Libro libro) {
        // TODO Auto-generated method stub
        this.libroRepository.actualizar(libro);
    }

    @Override
    public Libro buscar(Integer id) {
        // TODO Auto-generated method stub
        return this.libroRepository.seleccionar(id);
    }

    @Override
    public void borrar(Integer id) {
        // TODO Auto-generated method stub
        this.libroRepository.eliminar(id);
    }

}
