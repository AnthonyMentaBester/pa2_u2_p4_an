package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.CtaBancaria;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CtaBancariaRepositoryImpl implements CtaBancariaRepository{
	
	
	@PersistenceContext
	private EntityManager entitymanager;

	@Override
	public void insertar(CtaBancaria ctabancaria) {
		// TODO Auto-generated method stub
		this.entitymanager.persist(ctabancaria);
		
	}

	@Override
	public void actualizar(CtaBancaria ctabancaria) {
		// TODO Auto-generated method stub
		this.entitymanager.merge(ctabancaria);
		
	}

	@Override
	public CtaBancaria seleccionar(String saldo) {
		// TODO Auto-generated method stub
		return this.entitymanager.find(CtaBancaria.class, saldo);
	}

}
