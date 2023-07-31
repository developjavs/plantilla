package com.jace.controller;

import java.io.Serializable;
import java.util.List;

import com.develop.model.BaseEntity;

public interface CommonController<E extends BaseEntity, ID extends Serializable> {

	public List<E> findAll();
	public E findById(ID id);
	public E save(E entity);
	public E update(ID id, E entity);
	public boolean delete(ID id);
}