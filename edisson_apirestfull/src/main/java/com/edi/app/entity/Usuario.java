package com.edi.app.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@Entity
@Data
@Table(name = "usuarios")
public class Usuario implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user")
	private Integer id_user;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "clave")
	private String clave;

	@Column(name = "email")
	private String email;

	@Column(name = "imagenpath")
	private String imagenpath;

	@Column(name = "imagenurl")
	@Transient
	private String imagenurl;

	@Column(name = "cedpath")
	private String cedpath;

	@Column(name = "cedurl")
	@Transient
	private String cedurl;

	@Column(name = "estado")
	private Boolean estado;


	
}
