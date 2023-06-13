package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.CtaBancariaRepository;
import com.example.demo.repository.modelo.CtaBancaria;

@Service
public class CtaBancariaServiceImpl implements CtaBancariaService {
	
	@Autowired
	private CtaBancariaRepository bancariaRepository;



	@Override
	public void actualizar(CtaBancaria ctabancaria) {
		// TODO Auto-generated method stub
		this.bancariaRepository.actualizar(ctabancaria);
		
	}

	@Override
	public CtaBancaria consultar(String saldo) {
		// TODO Auto-generated method stub
		return this.bancariaRepository.seleccionar(saldo);
	}

	@Override
	public void aperturar(CtaBancaria ctabancaria, LocalDate fechaApertura, BigDecimal saldo) {
		// TODO Auto-generated method stub
		CtaBancaria  cta = new CtaBancaria();
		cta.setFechaApertura(fechaApertura);
		cta.setCedulaPropietario("1719954370");
		cta.setNumero("12");
		cta.setTipo("A");
		cta.setSaldo(saldo);
		Integer numero = cta.getFechaApertura().getDayOfYear();
		    if (numero % 2 == 0) {
		        //saldo = new BigDecimal(saldo).multiply(0.05);
		    } else {
		        System.out.println("felicidades");
		    }
		
		
		this.bancariaRepository.insertar(ctabancaria);
		
		
	}

}
