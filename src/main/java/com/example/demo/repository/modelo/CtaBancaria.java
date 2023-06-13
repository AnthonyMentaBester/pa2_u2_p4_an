package com.example.demo.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.format.number.money.MonetaryAmountFormatter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Table(name = "ctabancaria")
//cuando yo realizo el mapeo de un objeto pasa a ser una entidad
@Entity
public class CtaBancaria {
	
	@GeneratedValue(generator = "seq_cta", strategy = GenerationType.SEQUENCE ) /// atributo quue permite hacer match
	@SequenceGenerator(name = "seq_cta", sequenceName = "seq_cta", allocationSize = 1)
	@Id
	@Column(name = "cta_id")
	
	private Integer id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name = "cta_numero")
	private String numero;
	@Column(name = "cta_tipo")
	private String tipo;
	@Column(name = "cta_fecha_apertura")
	private LocalDate fechaApertura;
	@Column(name = "cta_saldo")
	private BigDecimal saldo;
	@Column(name = "cta_cedula")
	private String cedulaPropietario;
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public LocalDate getFechaApertura() {
		return fechaApertura;
	}
	public void setFechaApertura(LocalDate fechaApertura) {
		this.fechaApertura = fechaApertura;
	}

	

	public BigDecimal getSaldo() {
		return saldo;
	}
	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}
	public String getCedulaPropietario() {
		return cedulaPropietario;
	}
	public void setCedulaPropietario(String cedulaPropietario) {
		this.cedulaPropietario = cedulaPropietario;
	}
	@Override
	public String toString() {
		return "CtaBancaria [id=" + id + ", numero=" + numero + ", tipo=" + tipo + ", fechaApertura=" + fechaApertura
				+ ", saldo=" + saldo + ", cedulaPropietario=" + cedulaPropietario + "]";
	}
	
	
	

}
