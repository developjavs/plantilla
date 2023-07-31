package com.jace.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.develop.model.BaseEntity;

public interface CommonService<E extends BaseEntity, ID extends Serializable> {

//	public List<E> findByCriteria(Map<String, Object> fields, String[] order);
	public List<E> findAll() throws Exception;
	public E findById(ID id) throws Exception;
	public E save(E entity) throws Exception;
	public E update(ID id, E entity) throws Exception;
	public boolean delete(ID id) throws Exception;
	public Optional<E> findByCriteria(Map<String, Object> fields);
	
}
