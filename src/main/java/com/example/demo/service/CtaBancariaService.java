package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.example.demo.repository.modelo.CtaBancaria;

public interface CtaBancariaService {
	public void aperturar(CtaBancaria ctabancaria, LocalDate fechaApertura, BigDecimal saldo);
	public void actualizar(CtaBancaria ctabancaria);
	public CtaBancaria consultar(String saldo);

}
