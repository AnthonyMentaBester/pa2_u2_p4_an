package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.example.demo.repository.modelo.CtaBancaria;

public interface CtaBancariaService {
	public void aperturar(String cedula, String tipo, BigDecimal saldo);
	public void actualizar(CtaBancaria ctabancaria,String id);
	public CtaBancaria consultar(String id);

}
