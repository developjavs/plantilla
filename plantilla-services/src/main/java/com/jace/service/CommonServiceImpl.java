package com.jace.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.develop.model.BaseEntity;
import com.jace.repository.CommonRepository;

public abstract class CommonServiceImpl<E extends BaseEntity, ID extends Serializable> implements CommonService<E, ID> {

	protected CommonRepository<E, ID> repository;

	public CommonServiceImpl(CommonRepository<E, ID> repository) {
		this.repository = repository;
	}

	@Override
	public List<E> findAll() throws Exception {
		try {
			List<E> entities = (List<E>) this.repository.findAll();
			return entities;	
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public E findById(ID id) throws Exception {
		try {
			Optional<E> entity = this.repository.findById(id);
			return entity.get();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public E save(E entity) throws Exception {
		try {
			return this.repository.save(entity);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public E update(ID id, E entity) throws Exception {
		try {
			Optional<E> instance = this.repository.findById(id);
			E entityUpdate = instance.get();
			entityUpdate = this.save(entity);
			return entityUpdate;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public boolean delete(ID id) throws Exception {
		try {
			if(this.repository.existsById(id)) {
				this.repository.deleteById(id);
				return true;
			}else {
				throw new Exception();
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	@SuppressWarnings("serial")
	public Optional<E> findByCriteria(Map<String, Object> fields) {
		return this.repository.findOne(new Specification<E>() {
			@Override
			public Predicate toPredicate(Root<E> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				List<Predicate> predicates = new ArrayList<>();

				if (fields != null)
					predicates = getParametersFilter(criteriaBuilder, root, fields);


				return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
			}
		});
	}

	public List<Predicate> getParametersFilter(CriteriaBuilder builder, Root<E> root, Map<String, Object> filters) {
		List<Predicate> predicates = new ArrayList<>();

		if (filters != null && !filters.isEmpty()) {
			filters.forEach((k, v) -> {
				predicates.add(builder.equal(root.get(k), filters.get(k)));
			});
		}
		return predicates;
	}
}
