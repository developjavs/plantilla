package com.develop.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "roles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@AttributeOverrides({
	@AttributeOverride(name = "id", column = @Column(name = "ID_ROL"))
})
public class Rol extends BaseEntity {
	private static final long serialVersionUID = 1L;

	private String clave;

	private String descripcion;
}
