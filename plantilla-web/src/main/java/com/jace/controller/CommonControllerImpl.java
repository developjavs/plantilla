package com.jace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.develop.model.BaseEntity;
import com.jace.service.CommonServiceImpl;

public abstract class CommonControllerImpl<E extends BaseEntity, S extends CommonServiceImpl<E, Long>>
		implements CommonController<E, Long> {

	@Autowired
	protected S service;

	public List<E> findAll() {
		try {
			return service.findAll();
		} catch (Exception e) {
			return null;

		}
	}

	public E findById(Long id) {
		try {
			return service.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public E save(E entity) {
		try {
			return service.save(entity);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public E update(Long id, E entity) {
		try {
			return service.update(id, entity);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean delete(Long id) {
		try {
			return service.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}