package com.lubriweb.pe.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "orden")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Orden implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idOrden;
	@Column
	private String numero;
	@Column
	private Date fechaCreacion;
	@Column
	private Date fechaRecibida;
	@Column
	private double total;
	
	//Muchas Ordenes un Usuario
	@JoinColumn(name = "IdUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Usuario ordenUsuarios;
	
	//Muchas Ordenes un Pago
	@JoinColumn(name = "IdMetodoPago", referencedColumnName = "idMetodoPago")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private MetodoPago metodoPago;
	
	
	@OneToOne(mappedBy = "orden")
	private DetalleOrden detalle;
	
	
	public Orden() {
		
	}



	public Orden(Integer idOrden, String numero, Date fechaCreacion, Date fechaRecibida, double total,
			Usuario ordenUsuarios, DetalleOrden detalle) {
		
		this.idOrden = idOrden;
		this.numero = numero;
		this.fechaCreacion = fechaCreacion;
		this.fechaRecibida = fechaRecibida;
		this.total = total;
		this.ordenUsuarios = ordenUsuarios;
		this.detalle = detalle;
	}




	public Integer getIdOrden() {
		return idOrden;
	}


	public void setIdOrden(Integer idOrden) {
		this.idOrden = idOrden;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public Date getFechaCreacion() {
		return fechaCreacion;
	}


	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}


	public Date getFechaRecibida() {
		return fechaRecibida;
	}


	public void setFechaRecibida(Date fechaRecibida) {
		this.fechaRecibida = fechaRecibida;
	}


	public double getTotal() {
		return total;
	}


	public void setTotal(double total) {
		this.total = total;
	}


	public Usuario getOrdenUsuarios() {
		return ordenUsuarios;
	}


	public void setOrdenUsuarios(Usuario ordenUsuarios) {
		this.ordenUsuarios = ordenUsuarios;
	}




	public DetalleOrden getDetalle() {
		return detalle;
	}




	public void setDetalle(DetalleOrden detalle) {
		this.detalle = detalle;
	}


	
	

	
	
}
