package com.example.demo.repository;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.repository.modelo.dto.EstudianteDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
@Repository
//cuando necesitamos acceder ala base de datos necesita esta anotacion
//almenos en la clase repository
@Transactional
public class EstudianteRepositoryImpl implements EstudianteRepository {
	
	
	@PersistenceContext
	//necesito el entity manager medienta la anotacion de arriba
	//componete que me permite la interaccion 
	private EntityManager entitymanager;
	
	@Override
	public void insertar(Estudiante estudiante) {
		this.entitymanager.persist(estudiante);
		
	}
	@Override
	public void actualizar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.entitymanager.merge(estudiante);
		
	}
	@Override
	public Estudiante seleccionar(String cedula) {
		// TODO Auto-generated method stub
		//primero recibe la clase estudiante es decir trabajare con un objeto y luego la primary key
		
		return this.entitymanager.find(Estudiante.class, cedula);
	}
	@Override
	public void eliminar(String cedula) {
		// TODO Auto-generated method stub+
		//instancio para saber que debo eliminar 
		Estudiante estu = this.seleccionar(cedula);
		this.entitymanager.remove(estu);
		
	}
	@Override
	public Estudiante seleccionarPorApellido(String apellido) {
		// TODO Auto-generated method stub
		//en SQL
		//Select * from e estudiante Where e.estu_apellido = 
		//JPQL
		//se mantienen las palabras reservadas
		//SELECT e FROM Estudiante e WHERE e.apellido = 
		//Query myQuery = this.entitymanager.createQuery("JPQL");
		Query myQuery = this.entitymanager.createQuery("SELECT e FROM Estudiante e WHERE e.apellido = :datoApellido");
		myQuery.setParameter("datoApellido", apellido);
		return (Estudiante) myQuery.getSingleResult();
		// ese estudiante me dice el tipo con el que trabajo
		
	}
	@Override
	public List<Estudiante> seleccionarListaPorApellido(String apellido) {
		// TODO Auto-generated method stub
		Query myQuery = this.entitymanager.createQuery("SELECT e FROM Estudiante e WHERE e.apellido = :datoApellido");
		myQuery.setParameter("datoApellido", apellido);
		return myQuery.getResultList();
		
	}
	@Override
	public Estudiante seleccionarPorApellidoNombre(String apellido, String nombre) {
		// TODO Auto-generated method stub
		Query myQuery = this.entitymanager.createQuery("SELECT e FROM Estudiante e WHERE e.apellido = :datoApellido AND e.nombre = :datoNombre");
		myQuery.setParameter("datoApellido", apellido);
		myQuery.setParameter("datoNombre", nombre);
		return (Estudiante) myQuery.getSingleResult();
	}
	@Override
	public Estudiante seleccionarPorApellidoTyped(String apellido) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myQuery = this.entitymanager.createQuery("SELECT e FROM Estudiante e WHERE e.apellido = :datoApellido", Estudiante.class);
		myQuery.setParameter("datoApellido", apellido);
		return myQuery.getSingleResult();
	}
	@Override
	public Estudiante seleccionarPorApellidoNamed(String apellido) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myQuery = this.entitymanager.createNamedQuery("Estudiante.buscarPorApellido", Estudiante.class);
		myQuery.setParameter("datoApellido", apellido);
		return myQuery.getSingleResult();
		
	}
	@Override
	public Estudiante seleccionarPorApellidoNamedQuery(String apellido) {
		// TODO Auto-generated method stub
		Query myQuery = this.entitymanager.createNamedQuery("Estudiante.buscarPorApellido");
		myQuery.setParameter("datoApellido", apellido);
		return (Estudiante) myQuery.getSingleResult();
	}
	
	//NATIVE
	@Override
	public Estudiante seleccionarPorApellidoNativeQuery(String apellido) {
		// TODO Auto-generated method stub
		Query myQuery = this.entitymanager.createNativeQuery("SELECT * FROM Estudiante WHERE estu_apellido = :datoApellido", Estudiante.class);
		myQuery.setParameter("datoApellido", apellido);
		return (Estudiante) myQuery.getSingleResult();
	}
	@Override
	public Estudiante seleccionarPorApellidoNativeQueryNamed(String apellido) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myQuery = this.entitymanager.createNamedQuery("Estudiante.buscarPorApellidoNative", Estudiante.class);
		myQuery.setParameter("datoApellido", apellido);
		return  myQuery.getSingleResult();
	}
	
	@Override
	public Estudiante seleccionarPorNombreNativeQuery(String nombre) {
		// TODO Auto-generated method stub
		Query myQuery = this.entitymanager.createNativeQuery("SELECT * FROM Estudiante WHERE estu_nombre = :datoNombre", Estudiante.class);
		myQuery.setParameter("datoNombre", nombre);
		return (Estudiante) myQuery.getSingleResult();
	}
	@Override
	public Estudiante seleccionarPorNombreNativeQueryNamed(String nombre) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myQuery = this.entitymanager.createNamedQuery("Estudiante.buscarPorNombreNative", Estudiante.class);
		myQuery.setParameter("datoNombre", nombre);
		return  myQuery.getSingleResult();
	}
	@Override
	public Estudiante seleccionarPorApellidoCriteriaQuery(String apellido) {
		// TODO Auto-generated method stub
		CriteriaBuilder myBuilder = this.entitymanager.getCriteriaBuilder();
		//especificamos el nombre tipo que tiene mi query
		CriteriaQuery<Estudiante> myCriteriaQuery = myBuilder.createQuery(Estudiante.class);
		//2.1 definimos el From (Root) asi se le conoce en criteria 
		Root <Estudiante> myTablaFrom = myCriteriaQuery.from(Estudiante.class);
		//3 construit}r las condiciones de mi sql
		//where se le conoce como predicados
		//e.apellido = datoApellido
		Predicate condicionApellido = myBuilder.equal(myTablaFrom.get("apellido"), apellido);
		//4. vamos a armar todo el sql Final 
		myCriteriaQuery.select(myTablaFrom).where(condicionApellido);
		//5. la ejecucion ya del query lo realizamos con TypedQuery
		TypedQuery<Estudiante> myQueryFinal= this.entitymanager.createQuery(myCriteriaQuery);
		
		
		return myQueryFinal.getSingleResult();
	}
	@Override
	public Estudiante seleccionarEstudianteDinamicoCriteriaQuery(String nombre, String apellido, Double peso) {
		// TODO Auto-generated method stub
		CriteriaBuilder myBuilder = this.entitymanager.getCriteriaBuilder();
		CriteriaQuery<Estudiante> myCriteriaQuery = myBuilder.createQuery(Estudiante.class);
		Root <Estudiante> myTablaFrom = myCriteriaQuery.from(Estudiante.class);
		
		Predicate condicionApellido = myBuilder.equal(myTablaFrom.get("apellido"), apellido);
		//> 100 e.nombre = AND = e.apellido 
		//< = 100 e.nombre OR                     e.apellodp 
		Predicate pNombre  = myBuilder.equal(myTablaFrom.get("nombre"), nombre);
		Predicate pApellido = myBuilder.equal(myTablaFrom.get("apellido"), apellido);
		Predicate predicadorFinal = null;
		if(peso.compareTo(Double.valueOf(100))<=0) {
			predicadorFinal = myBuilder.or(pNombre,pApellido);
			
		}
		else {
			
			predicadorFinal = myBuilder.and(pNombre,pApellido);
			
		}
		myCriteriaQuery.select(myTablaFrom).where(predicadorFinal);
		//5. la ejecucion ya del query lo realizamos con TypedQuery
		TypedQuery<Estudiante> myQueryFinal= this.entitymanager.createQuery(myCriteriaQuery);
		
		
		return myQueryFinal.getSingleResult();
	}
	@Override
	public int eliminarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		//Delete from Estudiante where estu_nombre = ?
		//DELETE FROM Estudiante e WHERE e.nombre = :datoNombre
		
		Query myQuery = this.entitymanager.createQuery("DELETE FROM Estudiante e WHERE e.nombre = :datoNombre");
		myQuery.setParameter("datoNombre", nombre);
		return myQuery.executeUpdate();
		
	}
	@Override
	public int actualizarPorApellido(String nombre,String apellido) {
		// TODO Auto-generated method stub
	
		//DELETE FROM Estudiante e WHERE e.nombre = :datoNombre
		//UPDATE Estudiante e SET e.nombre = :datoNombre WHERE  e.apellido = :datoApellido		
		Query myQuery = this.entitymanager.createQuery("UPDATE Estudiante e SET e.nombre = :datoNombre WHERE  e.apellido = :datoApellido");
		myQuery.setParameter("datoNombre", nombre);
		myQuery.setParameter("datoApellido", apellido);
		return myQuery.executeUpdate();
	}
	@Override
	public List<EstudianteDTO> seleccionarTodosDTO() {
		// TODO Auto-generated method stub
		//USAR UN TYPED QUERY
		TypedQuery<EstudianteDTO> myQuery = this.entitymanager.createQuery("SELECT NEW com.example.demo.repository.modelo.dto.EstudianteDTO(e.nombre,e.apellido) FROM Estudiante e",EstudianteDTO.class);
		return myQuery.getResultList();
	}

}
   