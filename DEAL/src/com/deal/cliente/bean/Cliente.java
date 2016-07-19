package com.deal.cliente.bean;

import java.io.Serializable;

import javax.persistence.Column; 
import javax.persistence.Entity; 
import javax.persistence.GeneratedValue; 
import javax.persistence.GenerationType; 
import javax.persistence.Id; 
import javax.persistence.Table;


/**
 * 
 * @author gabriel
 *
 */

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1864742172520366278L;

	@Id @GeneratedValue
    @Column(name = "idCliente")
	private Long idCliente;
	
	@Column(name = "nombre")
	private String nombre;

	@Column(name = "apellidos")
	private String apellidos;
	
	public Cliente(){
	}

	public Long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	} 
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nombre=" + nombre + ", apellidos=" + apellidos + "]";
	}
	
	


}
