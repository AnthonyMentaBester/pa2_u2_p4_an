package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.repository.CtaBancariaRepository;
import com.example.demo.repository.modelo.CtaBancaria;

@Service
public class CtaBancariaServiceImpl implements CtaBancariaService {
	
	@Autowired
	private CtaBancariaRepository bancariaRepository;
	
	
	@Autowired
	@Qualifier("Impar")
	private ParidadService paridadService;

	@Override
	public CtaBancaria consultar(String saldo) {
		// TODO Auto-generated method stub
		return this.bancariaRepository.seleccionar(saldo);
	}



	@Override
	public void aperturar( String cedula, String tipo, BigDecimal saldo) {
		// TODO Auto-generated method stub
		CtaBancaria  cta = new CtaBancaria();
		cta.setFechaApertura(LocalDate.now());
		cta.setCedulaPropietario("1719954370");
		cta.setNumero("12");
		cta.setTipo("A");
		cta.setSaldo(saldo);
		Integer numero = cta.getFechaApertura().getDayOfYear();
		    if (numero % 2 == 0) {
		    	this.bancariaRepository.insertar(cta);
		    	
		    } else {
		        System.out.println("felicidades");
		    }
		
		
		
	}

	@Override
	public void actualizar(CtaBancaria ctabancaria, String id) {
		// TODO Auto-generated method stub
		this.bancariaRepository.actualizar(ctabancaria);		
	}

}
