package com.example.demo.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;
@Service("Par")
public class ParidadParService implements ParidadService{

	@Override
	public BigDecimal verParidad(BigDecimal saldo) {
		// TODO Auto-generated method stub
		BigDecimal newSaldo = saldo.multiply(new BigDecimal(0.05));
		return saldo.add(newSaldo);
	}
	
	

}
