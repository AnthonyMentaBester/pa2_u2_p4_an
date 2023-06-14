package com.example.demo.repository;

import com.example.demo.repository.modelo.CtaBancaria;
import com.example.demo.repository.modelo.Estudiante;

public interface CtaBancariaRepository {
	public void insertar(CtaBancaria ctabancaria);
	public void actualizar(CtaBancaria ctabancaria);
	public CtaBancaria seleccionar(String id);

}
