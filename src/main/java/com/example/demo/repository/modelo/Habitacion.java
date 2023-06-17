package com.example.demo.repository.modelo;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "habitacion")
public class Habitacion {
	
	@GeneratedValue(generator = "seq_habitacion", strategy = GenerationType.SEQUENCE ) /// atributo quue permite hacer match
	@SequenceGenerator(name = "seq_habitacion", sequenceName = "seq_habitacion", allocationSize = 1)
	
	@Id
	@Column(name = "habi_id")
	private Integer id;
	//si no realizo operaciones matematicas 
	//poner string
	@Column(name = "habi_numero")
	private String numero;
	@Column(name = "habi_valor")
	private BigDecimal valor;
	
	@ManyToOne
	@JoinColumn(name = "habi_id_hotel")
	private Hotel hotel;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	
	
	
	

}