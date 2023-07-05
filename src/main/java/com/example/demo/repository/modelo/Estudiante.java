package com.example.demo.repository.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQueries;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "estudiante")

@NamedQueries({
//genera la tabla 

//cuando yo realizo el mapeo de un objeto pasa a ser una entidad

	@NamedQuery(name = "Estudiante.buscarPorApellido", query = "SELECT e FROM Estudiante e WHERE e.apellido = :datoApellido"),
	@NamedQuery(name = "Estudiante.buscarPorNombre", query = "SELECT e FROM Estudiante e WHERE e.nombre = :datoNombre")
})
//debo poner el class por ser nativo 
@NamedNativeQueries({
@NamedNativeQuery(name = "Estudiante.buscarPorApellidoNative",query = "SELECT * FROM Estudiante WHERE estu_apellido = :datoApellido", resultClass =  Estudiante.class),
@NamedNativeQuery(name = "Estudiante.buscarPorNombreNative",query = "SELECT * FROM Estudiante WHERE estu_nombre = :datoNombre", resultClass =  Estudiante.class)
})
public class Estudiante {
	
	//debo realizar un mapeo a mi columna principal 
	//asignar un numero secuancial a una primary key ccomo un valor esta secuencia no vizualiza el usuario
	//se usa para la integridad referencial de la BD
	//debe tener 2 el nombre del generador el nnombre de la sequiencia el mismo del pgadmin y el crecimiento
	@GeneratedValue(generator = "seq_estudiante", strategy = GenerationType.SEQUENCE ) /// atributo quue permite hacer match
	@SequenceGenerator(name = "seq_estudiante", sequenceName = "seq_estudiante", allocationSize = 1)
	@Id
	@Column(name = "estu_id")
	//este atributo no debe ser seteado
	private Integer id;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name = "estu_cedula")
	private String cedula;

	@Column(name = "estu_nombre")
	private String nombre;
	@Column(name = "estu_apellido")
	private String apellido;
	@Column(name = "estu_peso")
	private Double peso;

	
	public Double getPeso() {
		return peso;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	//set y get
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	@Override
	public String toString() {
		return "Estudiante [id=" + id + ", cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", peso=" + peso + "]";
	}

	


	
}
