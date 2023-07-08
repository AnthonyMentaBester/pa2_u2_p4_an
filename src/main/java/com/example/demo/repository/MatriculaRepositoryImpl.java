package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Matricula;
import com.example.demo.repository.modelo.dto.MatriculaDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
@Repository
@Transactional
public class MatriculaRepositoryImpl implements MatriculaRepository{

	@PersistenceContext
	private EntityManager entitymanager;

    @Override
    public void insertar(Matricula matricula) {
        // TODO Auto-generated method stub
        this.entitymanager.persist(matricula);
    }

	@Override
	public List<MatriculaDTO> impresionTodos() {
		// TODO Auto-generated method stub
		TypedQuery<MatriculaDTO> myQuery = this.entitymanager.createQuery("SELECT NEW com.example.demo.repository.modelo.dto.MatriculaDTO(m.alumno.nombre,m.materia.nombre) FROM Matricula m",MatriculaDTO.class);
		return myQuery.getResultList();
	}

}
