package com.example.demo.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;
@Service("Impar")
public class ParidadImparService implements ParidadService{

	@Override
	public BigDecimal verParidad(BigDecimal monto) {
		// TODO Auto-generated method stub
		return monto;
	}

}
