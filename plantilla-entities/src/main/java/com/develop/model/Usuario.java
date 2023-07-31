package com.develop.model;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "USUARIOS")
@AttributeOverrides({
	@AttributeOverride(name = "id", column = @Column(name = "ID_USUARIO"))
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario extends BaseEntity {
	private static final long serialVersionUID = 1L;

	private String nombre;

	@Column(name = "A_PATERNO")
	private String paterno;

	@Column(name = "A_MATERNO")
	private String materno;

	private Date registro;

	private int estatus;

	private String correo;

	private String password;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_ROL")
	private Rol rol;
}
